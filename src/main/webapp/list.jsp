<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Medicines</title></head>
<body>
<h1>Medicines</h1>
<a href="controller?action=add">+ Add</a>
<table border="1" cellpadding="5">
<tr>
  <th>ID</th><th>Name</th><th>Manufacturer</th>
  <th>Price</th><th>Quantity</th><th>Expiry Date</th><th>Actions</th>
</tr>
<c:forEach var="m" items="${medicines}">
<tr>
  <td>${m.id}</td>
  <td>${m.name}</td>
  <td>${m.manufacturer}</td>
  <td>${m.price}</td>
  <td>${m.quantity}</td>
  <td>${m.expiryDate}</td>
  <td>
    <a href="controller?action=edit&id=${m.id}">Edit</a> |
    <a href="controller?action=delete&id=${m.id}">Delete</a>
  </td>
</tr>
</c:forEach>
</table>
</body>
</html>
