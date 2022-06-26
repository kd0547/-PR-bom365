/**
 * 
 */
function idOverlap(str) {


	if (!checkNullCheck(str)
		|| !str) {
		idResultMessage("*아이디를 입력해 주세요")
		return false;
	}

	if (checkSpecialCheck(str)) {
		idResultMessage("*특수문자는 사용할 수 없습니다.");
		return false;

	}

	if (koreanCheckReg(str)) {
		idResultMessage("*한글은 사용할 수 없습니다.");
		return false;
	}

	if (!checkNumberReg(str)) {
		idResultMessage("*숫자만 사용할 수 없습니다.");
		return false;
	}

	return true;
}
function sucremovePWNode() {
	let removeText = document.getElementById("pwd-box");
	let h3 = removeText.children[0];
	if (removeText.childElementCount) {
		removeText.removeChild(h3);
	}
}
function postCheckReg(str) {
	var regExp = /\d{5}/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}

}

function idResultMessage(str) {
	removeNode();
	createNode(str);
}
function createNode(str) {
	let createText = document.getElementById("text-box");
	if (createText.childElementCount == 0) {
		let h3 = document.createElement('h3');
		h3.setAttribute('class', 'check-id-ps');
		h3.innerText = str;
		createText.appendChild(h3);
	}

}
function removeNode() {
	let removeText = document.getElementById("text-box");
	let h3 = removeText.children[0];
	if (removeText.childElementCount) {
		removeText.removeChild(h3);
	}
}
function successPWNode(str) {
	let createText = document.getElementById("pwd-box");
	if (createText.childElementCount == 0) {
		let h3 = document.createElement('h3');
		h3.setAttribute('class', 'check-id-ps');
		h3.style.color = "blue";
		h3.innerText = str;
		createText.appendChild(h3);
	}

}

function PWResultMessage(str) {
	removePWNode();
	createPWNode(str);
}

function createPWNode(str) {
	let createText = document.getElementById("pwd-box");
	if (createText.childElementCount == 0) {
		let h3 = document.createElement('h3');
		h3.setAttribute('class', 'check-id-ps');
		h3.innerText = str;
		createText.appendChild(h3);
	}
}

function removePWNode() {
	let removeText = document.getElementById("pwd-box");
	let h3 = removeText.children[0];
	if (removeText.childElementCount) {
		removeText.removeChild(h3);
	}
}

function passwordCheckReg(str) {
	var regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,20}$/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}
/*
	핸드폰 유효성 검사
*/
function phoneCheckReg(str) {
	var regExp = /\d{3}\d{4}\d{4}/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}

}
/*
	우편주소 유효성 검사
*/
function postCheckReg(str) {
	var regExp = /\d{5}/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}

}
/*
	한글 유효성 검사
*/
function koreanCheckReg(str) {
	var regExp = /[가-힣]+/;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}
/*
	주소 유효성 검사
*/
function addressCheck(str) {
	var regExp = /(([가-힣A-Za-z·\d~\-\.]{2,}(로|길).[\d]+)|([가-힣A-Za-z·\d~\-\.]+(읍|동)\s)[\d]+)/;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}


/*
	공백 체크
*/

function checkNullCheck(str) {
	var regExp = /./g;

	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}

}

/*
	특수문자 체크 
*/
function checkSpecialCheck(str) {
	var regExp = /[/\[\]\{\}\/\(\)\.\?\<\>!@#$%^&*]+/g;

	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}


function checkNumberReg(str) {
	var regExp = /[0-9_]*[a-z]+[0-9_]*/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}
/*

*/
function checkEngOnlyReg(str) {
	var regExp = /[A-Za-z]+/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}
function checkNumOnlyReg(str) {
	var regExp = /\d/g;
	if (regExp.test(str)) {
		return true;
	} else {
		return false;
	}
}
//회원가입 조건이 만족하지 않으면 회원가입 버튼이 활성화되지 않게 하기 


/*
	//최소 10자리 이상 : 영어 대문자, 소문자, 숫자, 특수문자 중 2종류 조합
	//최소 8자리 이상 : 영어 대문자, 소문자, 숫자, 특수문자 중 3종류 조합
	//비밀번호 생성 규칙을 확인하고 데이터가 null인지 그리고 패스워드 더블체크 
*/
function name_check(name) {
	return koreanCheckReg(name);
}

function pwd_check(pwd, pwdcheck) {
	return pwd === pwdcheck;
}