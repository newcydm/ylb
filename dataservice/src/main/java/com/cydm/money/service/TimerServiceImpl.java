package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.cydm.money.common.config.AlipayConfig;

import com.cydm.money.common.util.BillQuery;
import com.cydm.money.mapper.*;
import com.cydm.money.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

import java.util.List;

@Component
@Service(interfaceClass = TimerService.class,version = "1.0.0",loadbalance = "leastactive")
@Transactional(timeout = 60)
public class TimerServiceImpl implements TimerService{

    @Autowired
    private LoanInfoMapper loanInfoMapper;

    @Autowired
    private BidInfoMapper bidInfoMapper;

    @Autowired
    private IncomeRecordMapper incomeRecordMapper;

    @Autowired
    private FinanceAccountMapper financeAccountMapper;

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Async
    public void revenuePlan(){
        List<LoanInfo> loanInfoList=loanInfoMapper.selectFulScaleAll();
        for (LoanInfo loanInfo : loanInfoList) {
            List<BidInfo> bidInfoList = bidInfoMapper.selectById(loanInfo.getId());
            for (BidInfo bidInfo : bidInfoList) {
                IncomeRecord incomeRecord=new IncomeRecord();
                incomeRecord.setUid(Integer.parseInt(bidInfo.getUid()));//用户id
                incomeRecord.setLoanId(loanInfo.getId());//产品id
                incomeRecord.setBidId(bidInfo.getId());//投标id
                incomeRecord.setBidMoney(bidInfo.getBidMoney());//投资金额

                //利用Calendar类来实现对Date时间加减
                Calendar rightNow = Calendar.getInstance();

                rightNow.setTime(loanInfo.getProductFullTime());
                if(loanInfo.getProductType()==0){//天为单位
                    incomeRecord.setIncomeMoney(Math.ceil(bidInfo.getBidMoney()*(loanInfo.getRate()/100/365)*loanInfo.getCycle()));
                    rightNow.add(Calendar.DAY_OF_YEAR,loanInfo.getCycle());
                }else{//月为单位
                    incomeRecord.setIncomeMoney(Math.ceil(bidInfo.getBidMoney()*(loanInfo.getRate()/100/365)*loanInfo.getCycle()*30));
                    rightNow.add(Calendar.MONTH,loanInfo.getCycle());
                }

                incomeRecord.setIncomeDate(rightNow.getTime());//收益时间
                incomeRecord.setIncomeStatus(0);//收益状态
                incomeRecordMapper.insert(incomeRecord);

            }

            loanInfo.setProductStatus(2);
            loanInfoMapper.updateStatus(loanInfo);
        }
    }

    @Async
    public void returnedMoney(){
        List<IncomeRecord> incomeRecordList = incomeRecordMapper.selectNotRecord(0);
        for (IncomeRecord incomeRecord : incomeRecordList) {//查出每条收益计划

            FinanceAccount financeAccount=new FinanceAccount();
            financeAccount.setAvailableMoney(incomeRecord.getBidMoney()+incomeRecord.getIncomeMoney());
            financeAccount.setUid(incomeRecord.getUid());
            financeAccountMapper.updateReturnedMoney(financeAccount);

            incomeRecord.setIncomeStatus(1);
            incomeRecordMapper.update(incomeRecord);
        }
    }

    @Async
    public void rechargeResult() {
        for (RechargeRecord rechargeRecord : rechargeRecordMapper.selectStatus(0)) {
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ rechargeRecord.getRechargeNo() +"\"}");
            //请求并返回JSON对象
            JSONObject result = null;
            try {
                result = JSON.parseObject(alipayClient.execute(alipayRequest).getBody());
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = result.getJSONObject("alipay_trade_query_response");
            int code = jsonObject.getInteger("code");
            if(code==10000){//支付宝交易存在
                String trade_status = jsonObject.getString("trade_status");
                if("TRADE_SUCCESS".equals(trade_status)||"TRADE_FINISHED".equals(trade_status)){
                    //支付成功
                    toRecharge(rechargeRecord);
                }else if("TRADE_CLOSED".equals(trade_status)){
                    //支付失败
                    rechargeRecord.setRechargeStatus(2+"");
                    rechargeRecordMapper.update(rechargeRecord);
                }
            }else if(code==40004){//支付宝交易不存在
                result = JSON.parseObject(BillQuery.gateWayInitQuery(rechargeRecord.getRechargeNo()));
                if(result.getString("orderDetail")!=null){
                    String orderDetail = result.getString("orderDetail").replace("[", "");
                    orderDetail=orderDetail.replace("]","");
                    JSONObject jsonObject1 = JSON.parseObject(orderDetail);
                    if(jsonObject1.getInteger("payResult")==10){
                        //支付成功
                        toRecharge(rechargeRecord);
                    }
                }else{
                    rechargeRecord.setRechargeStatus(2+"");
                    rechargeRecordMapper.update(rechargeRecord);
                }
            }
        }
    }

    private void toRecharge(RechargeRecord rechargeRecord){
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setUid(rechargeRecord.getUid());
        financeAccount.setAvailableMoney(rechargeRecord.getRechargeMoney());
        //给用户充值
        financeAccountMapper.updateReturnedMoney(financeAccount);

        rechargeRecord.setRechargeStatus(1+"");
        //修改充值订单状态
        rechargeRecordMapper.update(rechargeRecord);
    }
}
