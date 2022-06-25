function application_sendit(){
	// validationcheck
	let frm = document.applicationForm;
	let application_title = frm.application_title;
	// 신청서 제목 처리
	if(application_title.value != ""){
		frm.submit();
	} else{
		alert("제목을 입력해주세요.");
		event.preventDefault();
	}
}