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
<div class="dish" div id="personal">
  <h1>Список меню ресторана</h1>
  <table style="align-items: center">
    <tr>
      <th> Name </th>
      </tr>

    <c:forEach items="${menu}" var="menu">
      <tr>
       <td> <a href="/showDishes?menuName=${menu.name}">${menu.name}</a></td>
      </tr>
    </c:forEach>
  </table>
</div>



</body>
</html>
