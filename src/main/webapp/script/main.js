function asCheck(){

	

	  var obj_length = document.getElementsByName("asitem").length;
	
	  var a =0;
	 
	
      for (var i=0; i<obj_length; i++) {
          if (document.getElementsByName("asitem")[i].checked == true) {
              a++;
          }
       }
       

      
	if(a < 1){
		alert("as 항목을 선택해주세요");
		return false;
		
      }  
	if(document.frm.res_date.value == ""){
		alert("날짜를 정해주세요");
		return false;
	}
	if(document.frm.res_time.value == ""){
		alert("시간를 정해주세요");
		return false;
	}
	
	if(document.frm.check.value == "a"){
		
	}else {
		if(document.frm.name.value == document.frm.hidden.value){
			alert("대리자 이름이 본인 이름과 일치 합니다")	
			return false;
			}
	}
	return true;

}