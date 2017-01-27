<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>${title}</h1>
	<h1>${message}</h1>

	<div class="menu" >
		<nav>
			<ul>
				<li>
					<a href="/employees" >
						<span>Employees</span>
					</a>
				</li>
				<li>
					<a href="/dishes" >
						<span>Dishes</span>
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
					<a href="/orders" >
						<span>Orders</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>



</body>
</html>