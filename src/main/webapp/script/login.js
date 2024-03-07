function loginCheck(){
	if(document.loginfrm.email.value.length == 0){
		alert("이메일을 입력하세요");
		frm.eamil.focus();
		return false;
	}
	
	if(document.loginfrm.pw.value.length == 0){
		alert("비밀번호를 입력하세요");
		frm.pw.focus();
		return false;
	}
	/*
	var admin_radio = document.getElementByName('admin');
	var result = null;
	
	for(var i=0; i<admin_radio.length; i++){
		if(admin_radio[i].checked == true){
			result = admin_radio[i].value;
		}
	}
	if(result == null){
		alert("권한을 선택하세요");
		return false;
	}
	*/
	
	var admin_radio = $('input[name=admin]').is(':checked');
	if(!admin_radio){
		alert("권한을 선택하세요");
		return false;
	}
}
