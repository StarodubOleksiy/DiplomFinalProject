<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

   <div class="menu" >
      <nav>
          <ul>
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
   <h1>${title}</h1>
   <h1>${message}</h1>

<div id="right">
    <form method="GET" action="findByWord">
        <table>
            <tr><th><h2>Пошук</h2></th></tr>
            <tr>
                <td>Введіть назву страви :</td>
                <td><input type="text" name="name"/></td>

            </tr>
            <tr>
                <td colspan="2"><input type="submit"></td>
            </tr>
        </table>
    </form>


    <table style="align-items: center" class="dish">
        ${der}
        <tr>
            <td><a href="/showDish?dishName=${finddish.name}">${finddish.name}</a></td>
        </tr>
    </table>

</div>
</body>
</html>
