<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del() {
		var val = confirm("정말 삭제하시겠습니까 ?");
		if (val) location.href="${path}/delete/${customer.id}";
		else alert("삭제가 취소 되었습니다");
	}
</script>
</head><body>
<div class="container" align="center">
	<h2 class="text-primary">고객정보 상세</h2>
<table class="table table-bordered">
	<tr><td>아이디</td><td>${customer.id }</td></tr>
	<tr><td>이름</td><td>${customer.name }</td></tr>
	<tr><td>주소</td><td>${customer.address}</td></tr>
	<tr><td>이메일</td><td>${customer.email}</td></tr>
	<tr><td colspan="2"><a class="btn btn-info btn-sm" 
		href="${path }/customer">목록</a>
		<a class="btn btn-danger btn-sm" onclick="del()">삭제</a></td></tr>
</table>
</div>
</body>
</html>