<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Form</title></head>
<body>
<h1>${empty medicine ? 'Add' : 'Edit'} medicine</h1>
<form action="controller" method="post">
<c:if test="${not empty medicine}">
  <input type="hidden" name="id" value="${medicine.id}"/>
</c:if>
Name: <input type="text" name="name" value="${medicine.name}"/><br/>
Manufacturer: <input type="text" name="manufacturer" value="${medicine.manufacturer}"/><br/>
Price: <input type="text" name="price" value="${medicine.price}"/><br/>
Quantity: <input type="text" name="quantity" value="${medicine.quantity}"/><br/>
Expiry Date: <input type="text" name="expiryDate" value="${medicine.expiryDate}"/><br/>
<input type="submit" value="Save"/>
</form>
<a href="controller?action=list">&larr; Back</a>
</body>
</html>
