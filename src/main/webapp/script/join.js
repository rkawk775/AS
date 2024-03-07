function joinCheck() {
	
	if (document.frm.email.value.length==0) {
		alert("이메일을 입력해주세요.");
		frm.eamil.focus();
		return false;ㅌㅌ
	}
	const email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	
	if (document.frm.email.value.length==false) {
		alert("이메일형식이 올바르지 않습니다.");
		frm.eamil.focus();
		return false;
	}
	
	if (document.frm.pw.value=="") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pw.focus();
		return false;
	} else {
		if( document.frm.pw.value.length < 8 ){
			alert("비밀번호는 8자리 이상으로 입력하세요.");
			frm.pw.focus();
			return false;
		}
	
	if (document.frm.pw.value != document.frm.pw_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.name.value.length==0) {
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.phone.value.length==0){
		alert("전화번호를 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
}
}