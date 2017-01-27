
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title></title>
</head>
<body>
<div class="menu" >
  <nav>
    <ul>
      <li>
        <a href="/welcome" >
          <span>Головна</span>
        </a>
      </li>
      <li>
        <a href="/showMenu" >
          <span>Меню</span>
        </a>
      </li>
      <li>
        <a href="/showEmployees" >
          <span>Офіціанти</span>
        </a>
      </li>
      <li>
        <a href="/schema" >
          <span>Схема ресторана</span>
        </a>
      </li>
      <li>
        <a href="/contacts" >
          <span>Наші контакти</span>
        </a>
      </li>
    </ul>
  </nav>
</div>
<div class="dish" id="personal">
<h1>${dish.name}</h1>
<table style="align-items: center">
  <tr>

    <th>Dish category </th>
    <th>Price</th>
    <th>Weight</th>

  </tr>

  <tr>
       <td>${dish.dishCategory}</td>
    <td>${dish.price}</td>
    <td>${dish.weight}</td>
  </tr>
</table>

<table style="align-items: center">
  <tr>
    <th>Ingradients </th>
  </tr>
  <c:forEach var="ingradients" items="${ingradients}" >
  <tr>
    <td>${ingradients.name}</td>
  </tr>
  </c:forEach>
</table>


</div>
<div id="image">
<img src="/resources/images/${dish.image}"alt="Логотип" />
</div>
</body>
</html>
