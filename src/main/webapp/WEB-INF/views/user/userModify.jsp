<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/WEB-INF/views/commonJsp/basicLib.jsp"%>
<c:set var="user" value="${ user }" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
$(function() {
	
	// 우편번호 검색 버튼 클릭 이벤트 핸들러
	$("#zipcodeBtn").on('click', function() {
		new daum.Postcode({
	        oncomplete: function(data) {
	            $('#addr1').val(data.roadAddress);
	            $('#zipcode').val(data.zonecode);
	        }
	    }).open();
	});
});
</script>
</head>

<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/WEB-INF/views/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form"
						action="${ cp }/user/modify" method="post"
						enctype="multipart/form-data"
				>
					
					<div class="form-group">
						<label for=picture" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="${ cp }/user/picture/${ user.userId }">
						</div>
					</div>
					
					<div class="form-group">
						<label for=picture" class="col-sm-2 control-label">사용자 사진 변경</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="picture" name="picture"
								placeholder="사용자 사진">
						</div>
					</div>

					<div class="form-group">
						<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<span>${ user.userId }</span>
							<input type="hidden" name="userId" value="${ user.userId }">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userNm" name="userNm"
								placeholder="사용자 이름" value="${ user.userNm }">
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias"
								name="alias" placeholder="별명" value="${ user.alias }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">생일</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="reg_dt"
								name="reg_dt" placeholder="생일" value="<fmt:formatDate value="${ user.reg_dt }" pattern="yyyy-MM-dd" />">
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="addr1"
								name="addr1" placeholder="주소1" readonly value="${ user.addr1 }">
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-default" id="zipcodeBtn">우편번호</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2"
								name="addr2" placeholder="주소2" value="${ user.addr2 }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcode"
								name="zipcode" placeholder="우편번호" readonly value="${ user.zipcode }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userRegDt" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass"
								name="pass" placeholder="비밀번호">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userRegDt" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass2"
								placeholder="비밀번호">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" id="regBtn">사용자 등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
