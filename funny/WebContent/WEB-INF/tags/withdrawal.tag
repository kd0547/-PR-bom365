<%@tag import="model.supporter.SupporterVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%
	String id = session.getAttribute("supporter_id").toString();
	String name = session.getAttribute("supporter_name").toString();
	
%>
<script type="text/javascript">
    function del(){
        var ans=confirm("회원님의 정보는 복구되지않습니다. \n정말 탈퇴하시겠습니까?");
        if(ans==true){
			
        	var trans = document.getElementById("trans");
        	trans.method = "POST";
        	trans.action = "userdelete.me";
            trans.submit();
        }
        else{
        	event.preventDefault();
        }
    }
</script>
<c:set var="name" value="<%= name%>"> </c:set>
<div class="col-md-12 total-wrap withdrawal" id="login">
	<div class="container-htag">
		<h1>${name }님!</h1>
		<h5>
			탈퇴에 앞서 봉사자님을 통해 행복을 다시 찾고있는<br>많은 우리 동물들을 위해 다시한번 고민을 부탁드립니다
		</h5>
	</div>
<!-- action수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id="trans" name="withdrawal" class="withdrawalForm2">
		<table id="tableStyle">
			<tr>
				<input id="hidden_id" type="text" value="<%= id %>" style="display:none" name="supporter_id">
				<td>비밀번호</td>
				<td><input type="password" class="form-control" name="supporter_password"></td>
			</tr>
		</table>
		<table id="tableStyle" style="margin-top: 20px;">
			<tr>
				<td><input type="submit" class="btn btn-primary del"
					value="&nbsp;Delete My Account&nbsp;" onclick="del()"></td>
			</tr>
			<tr>
		</table>
	</form>
	<!-- action수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</div>