
//同意实名认证协议
$(function() {
	$("#agree").click(function(){
		var ischeck = document.getElementById("agree").checked;
		if (ischeck) {
			$("#btnRegist").attr("disabled", false);
			$("#btnRegist").removeClass("fail");
		} else {
			$("#btnRegist").attr("disabled","disabled");
			$("#btnRegist").addClass("fail");
		}
	});
});
//打开注册协议弹层
function alertBox(maskid,bosid){
	$("#"+maskid).show();
	$("#"+bosid).show();
}
//关闭注册协议弹层
function closeBox(maskid,bosid){
	$("#"+maskid).hide();
	$("#"+bosid).hide();
}

//错误提示
function showError(id,msg) {
	$("#"+id+"Ok").hide();
	$("#"+id+"Err").html("<i></i><p>"+msg+"</p>");
	$("#"+id+"Err").show();
	$("#"+id).addClass("input-red");
}
//错误隐藏
function hideError(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id).removeClass("input-red");
}
//显示成功
function showSuccess(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id+"Ok").show();
	$("#"+id).removeClass("input-red");
}
$(function () {
	$("#realName").blur(function () {
		var name=$(this).val();
		if(name.trim()==''){
			showError('realName',"姓名不能为空");
			return;
		}
		var nameText=/^[\u4e00-\u9fa5]{0,}$/;
		if(!nameText.test(name)){
			showError('realName',"姓名只能输入中文");
			return;
		}
		hideError('realName')
	})

	$("#idCard").blur(function () {
		var idCard=$(this).val();
		if(idCard.trim()==''){
			showError('idCard',"身份证号码不能为空")
			return;
		}
		var idCardText=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(!idCardText.test(idCard)){
			showError('idCard','身份证格式错误')
			return;
		}
		hideError('idCard')
	})

	$("#imgCode").click(function () {
		$(this).attr('src',"../jcaptcha/captcha?q="+new Date().getTime());
	});

	//认证按钮
	$("#btnRegist").click(function () {
		$("#realName").blur()
		$("#idCard").blur()
		$.ajax({
			url:"",
			type:"post",
			data:{realName:$("#realName").val(),idCard:$("#idCard").val(),captcha:$("#captcha").val()},
			success:function (result) {
				if(result.code==200){
					showSuccess('realName')
					showSuccess('idCard')
					showSuccess('captcha')
					$.leftTime(3,function (d) {
						if(!d.status){
							window.location.href='../../index';
						}
					})
				}
				if(result.code==201){
					showError('captcha',result.message)
				}
				if(result.code==202){
					showError('realName',result.message)
					showError('idCard',result.message)
				}
			}
		})
	})
})