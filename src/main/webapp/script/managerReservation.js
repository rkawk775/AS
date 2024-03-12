function managerCheck() {
	if(document.frm.res_date.value.length==0) {
		alert("날짜를 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.res_time.value.length==0){
		alert("시간을 입력해주세요.");
		frm.name.focus();
		return false;
	}
}