function productCheck() {
	if(document.frm.name.value.length == 0){
		alert("영화명을 입력하시오");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.price.value.length == 0){
		alert("가격을 입력하시오");
		frm.price.focus();
		return false;
	}
	
	if(isNaN(document.frm.price.value)){
		alert("가격은 숫자로만 입력하시오");
		frm.price.focus();
		return false;
	}
	return true;
}