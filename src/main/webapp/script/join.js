function joinCheck() {
	
	
	if (document.frm.email.value.length==0) {
		alert("이메일을 입력해주세요.");
		frm.eamil.focus();
		return false;
	}
	
	if (document.frm.pwd.value=="") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pw.focus();
		return false;
	}
	
	if (document.frm.pw.value != document.frm.pw_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.name.value.length==0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.phone.value.length==0){
		alert("전화번호를 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
}