<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<!-- modelAttribute="editCustomer"는 메모리에 있는 객체를 읽어옴 -->
<form:form modelAttribute="editCustomer">
	<h2 class="text-primary">고객정보 수정</h2>
<table class="table table-hover">
	<tr><td>이름</td><td><form:input path="name"/>
	<%-- <input type="text" name="name" id="name" 
			value="${editCustomer.name }">와 같은 의미 --%>
	<!-- cssClass="error" class=error와 같은 의미 -->
	<!-- form:errors : name에 에러가 발생하면 보여줘라 -->
		<form:errors path="name" cssClass="error"></form:errors></td></tr>
	<tr><td>주소</td><td><form:input path="address"/>
		<form:errors path="address" cssClass="error"></form:errors></td></tr>
	<tr><td>이메일</td><td><form:input path="email"/>
		<form:errors path="email" cssClass="error"></form:errors></td></tr>
	<tr><td colspan="2"><button type="submit" value="process" 
		name="event_process">다음</button></td></tr>
</table>
</form:form>
</body>
</html>