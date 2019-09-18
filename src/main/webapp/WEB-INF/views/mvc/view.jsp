<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>