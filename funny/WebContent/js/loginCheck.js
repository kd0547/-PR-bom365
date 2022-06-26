	function loginCheck() {
		var ans = confirm("로그인 후 이용 가능합니다.");
		if (ans == true) {
			location.href = 'login.jsp';
		} else {
			event.preventDefault();
		}
	}
	
	function goREG() {
		location.href='supportREGRequest.jsp';
	}
	
	function goTEM() {
		location.href='supportTEMRequest.jsp';
	}
