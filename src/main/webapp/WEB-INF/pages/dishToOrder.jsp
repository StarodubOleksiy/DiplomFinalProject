<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add dish to menu</title>
</head>
<body>
<div class="menu" >
  <nav>
    <ul>
      <li>
        <a href="/admin" >
          <span>Головна адміністратор</span>
        </a>
      </li>
      <li>
        <a href="/employees" >
          <span>Employees</span>
        </a>
      </li>
      <li>
        <a href="/menu" >
          <span>Menu</span>
        </a>
      </li>
      <li>
        <a href="/storage" >
          <span>Storage</span>
        </a>
      </li>
      <li>
        <a href="/dishes" >
          <span>Dishes</span>
        </a>
      </li>
      <li>
        <a href="/orders" >
          <span>Orders</span>
        </a>
      </li>
    </ul>
  </nav>
</div>
<form method="POST" action="addDishToOrder">
  <table>
    <tr><th><h2>Додати  нову страву до замовлення</h2></th></tr>
    <tr>
      <td>Введіть назву страви :</td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit"></td>
    </tr>
  </table>
</form>

</body>
</html>