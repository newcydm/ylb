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

//注册协议确认
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
	
	$("#phone").blur(function () {
		var phone=$("#phone").val();
		if(phone.trim()==''){
			showError('phone',"手机号不能为空")
			return;
		}

		var phoneText=/^1[1-9]\d{9}$/;
		if(!phoneText.test(phone)){
			showError('phone',"手机号格式不正确")
			return;
		}

		$.ajax({
			url:"../api/phone",
			type:"post",
			data:{phone:phone},
			success:function (result) {
				console.log(result.code)
				if(result.code==200){
					showSuccess("phone");
				}else{
					showError('phone','手机号已被注册');
				}
			}
		});



	})

	$("#loginPassword").blur(function () {
		var password=$("#loginPassword").val();
		if(password.trim()==''){
			showError('loginPassword','密码不能为空')
			return ;
		}
		var passwordText=/^[0-9a-zA-Z]+$/;
		if(!passwordText.test(password)){
			showError('loginPassword','密码字符只可使用数字和大小写英文字母');
			return;
		}

		passwordText=/^(([a-zA-Z]+[0-9]+)|([0-9]+[a-zA-Z]+))[a-zA-Z0-9]*/;
		if(!passwordText.test(password)){
			showError('loginPassword','密码应同时包含英文和数字');
			return;
		}

		showSuccess("loginPassword");

	});
	
	//获取验证码按钮
	$("#messageCodeBtn").click(function () {

		if($(this).hasClass('on')){
			return;
		}

		$("#phone").blur();
		if($("#phoneErr").text()!=''){
			return;
		}

		$.ajax({
			url:'../sendCode',
			data:{phone:$("#phone").val()},
			type:"post",
			success:function (result) {
				if(result.code==200){
					$("#messageCodeBtn").addClass('on');
					$.leftTime(60,function (d) {

						if(d.status){
							$("#messageCodeBtn").text(d.s+'秒');
						}else{
							$("#messageCodeBtn").removeClass('on');
							$("#messageCodeBtn").text("获取验证码");
						}
					});
				}
			}
		});




	})

	//注册按钮
	$("#btnRegist").click(function () {
		$("#phone").blur();
		$("#loginPassword").blur();

		if($("[id$=Err]").text().trim()!=''){
			return;
		}


		$.ajax({
			url:"",
			type:"post",
			data:{phone:$("#phone").val(),loginPassword:$.md5($("#loginPassword").val()),messageCode:$("#messageCode").val()},
			success:function (result) {
				if(result.code==200){
					window.location.href='realName';
				}else{
					showError("messageCode",result.message);
				}
			}
		})

	})
});


