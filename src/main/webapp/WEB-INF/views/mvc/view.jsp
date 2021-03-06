<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ cp }/js/jquery-3.4.1.min.js"></script>
<script>
$(function() {
	//pathBtn이 클릭될때 이벤트 핸들러
	$('#pathBtn').on('click', function() {
		$('#frm')
		.attr('action', '${ cp }/mvc/path/' + frm.path.value)
		.submit();
	});
})
</script>
</head>
<body>
	<h2>mvc/view.jsp</h2>
	
	<h3>i18n</h3>
	<form action="${ cp }/mvc/i18n">
		<select name="language">
			<option value="ko">한국어</option>
			<option value="zh">중국어</option>
			<option value="en">영어</option>
		</select>
		<input type="submit" value="전송">
	</form>
	<spring:message code="GREETING" />
	<spring:message code="VISITOR">
		<spring:argument value="brown" />
	</spring:message>
	
	<h3>spring validator jsr303</h3>
	<form action="${ cp }/mvc/jsr303">
		<input type="text" name="userId" value="brown"> <br>
		<input type="text" name="userNm" value="브라운"> <br>
		<input type="submit" value="전송"> <form:errors path="user.pass" />
	</form>
	
	<h3>spring validator</h3>
	<form action="${ cp }/mvc/validator">
		<input type="text" name="userId" value="brown"> <form:errors path="user.userId" /> <br>
		<input type="text" name="userNm" value="브라운"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h3>redirect Attribute</h3>
	<form action="${ cp }/mvc/redirect">
		<input type="text" name="userId" value="brown"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h3>request param</h3>
	<form action="${ cp }/mvc/requestParam" method="POST">
		userId : <input type="text" name="userId" value="sally"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h3>path variable</h3>
	<form id="frm">
		brown <input type="radio" name="path" value="brown" checked> <br>
		sally <input type="radio" name="path" value="sally"> <br>
		<input type="button" id="pathBtn" value="전송">
	</form>
	
	<h3>requestPart</h3>
	<form id="frmPart" action="${ cp }/mvc/upload" enctype="multipart/form-data" method="POST">
		<input type="text" name="userId" vlaue="brown"> <br>
		<input type="file" name="picture"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h3>multi parameter</h3>
	<form action="${ cp }/mvc/multiParameter" method="POST">
		<input type="text" name="userId" value="brown"> <br>
		<input type="text" name="userId" value="sally"> <br>
		<input type="text" name="addr.addr1" value="대전시 중구 중앙로 76"> <br>
		<input type="text" name="addr.addr2" value="대덕인재개발원"> <br>
		
		<input type="text" name="addrList[0].addr1" value="대전시 중구 중앙로 76 list1"> <br>
		<input type="text" name="addrList[0].addr2" value="대덕인재개발원 list1"> <br>
		
		<input type="text" name="addrList[1].addr1" value="대전시 중구 중앙로 76 list2"> <br>
		<input type="text" name="addrList[1].addr2" value="대덕인재개발원 list2"> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>