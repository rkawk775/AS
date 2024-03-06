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
	return true;
}
