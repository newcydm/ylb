var referrer = "";//登录后返回页面
referrer = document.referrer;
if (!referrer) {
	try {
		if (window.opener) {                
			// IE下如果跨域则抛出权限异常，Safari和Chrome下window.opener.location没有任何属性              
			referrer = window.opener.location.href;
		}  
	} catch (e) {
	}
}

//按键盘Enter键即可登录
$(document).keyup(function(event){
	if(event.keyCode == 13){
		login();
	}
});

$(function () {
	$("#imgCode").click(function () {
		$(this).attr('src',"../jcaptcha/captcha?q="+new Date().getTime());
	});

	$("#loginId").click(function () {
		var phone=$("#phone").val();
		var password=$("#loginPassword").val();

		if(phone.length==0){
			alert("手机号不能为空")
			return;
		}
		var phoneText=/^1[1-9]\d{9}$/;
		if(!phoneText.test(phone)){
			alert("手机号格式不正确")
			return;
		}
		if(password.length==0){
			alert("密码不能为空")
			return;
		}


		$.ajax({
			url:"",
			type:"post",
			data:{phone:phone,loginPassword:$.md5(password),code:$("#captcha").val()},
			success:function (result) {
				if(result.code==200){
					window.location.href='../../index';
				}else{
					alert(result.message)
				}
			}
		})
	});
})