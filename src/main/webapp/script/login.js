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

    var admin_radio = document.querySelector('input[name="admin"]:checked');
    if (!admin_radio) {
        alert("권한을 선택하세요");
        return false;
    }
    return true;
}
