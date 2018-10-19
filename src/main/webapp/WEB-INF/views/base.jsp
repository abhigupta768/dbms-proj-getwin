<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Getwin Shop</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
	margin-left:auto;
	margin-right:auto;
	margin-top:100px;'
}

th {
	height: 25px;
	background: #EF5D60;
}

th, td {
	padding: 5px;
	text-align:center;
}

@import
	url(https://fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800)
	;

html, body {
	font-family: 'Dosis';
	font-weight: 300;
}

.header {
	width: 100%;
	border-bottom: 1px solid black;
	text-align: right;
	position: relative;
}

.header .logo {
	position: absolute;
	top: 0;
	left: 0;
	font-size: 32px;
	font-weight: 100;
	padding: 26px;
	border-right: 1px solid black;
	background-color: #EF5D60;
	color: white;
}

.menu {
	background-color: #2F4858;
}

.link {
	display: inline-block;
	padding: 15px 0;
	margin: 15px 25px;
	position: relative;
	text-decoration: none;
	text-transform: uppercase;
	color: white;
	font-weight: 800;
	font-size: 24px;
}

.link .bar {
	width: 100%;
	display: inline-block;
	border-bottom: 5px solid white;
	position: absolute;
	bottom: 0;
	left: 0;
	opacity: 0;
	transition: all 300ms;
}

.link:hover .bar {
	opacity: 1;
	bottom: 5px;
}
</style>
</head>
<body>
	<!-- <div class="header">
		<div class="logo">Company Title</div>
		<div class="menu">
			<a href="#" class="link">
				<div class="title">Home</div>
				<div class="bar"></div>
			</a> <a href="#" class="link">
				<div class="title">Logout</div>
				<div class="bar"></div>
			</a>
		</div>
	</div>-->


	<c:choose>
		<c:when test='${role=="ROLE_ADMIN"}'>
			<div class="header">
				<div class="logo">Getwin Electro Pneumatic Corp.</div>
				<div class="menu">
					<a href="/dbms/admin" class="link">
						<div class="title">Home</div>
						<div class="bar"></div>
					</a> <a href="/dbms/j_spring_security_logout" class="link">
						<div class="title">Logout</div>
						<div class="bar"></div>
					</a>
				</div>
			</div>
			</div>
		</c:when>
		<c:when test='${role=="ROLE_USER"}'>
			<div class="header">
				<div class="logo">Getwin Electro Pneumatic Corp.</div>
				<div class="menu">
					<a href="/dbms/user" class="link">
						<div class="title">Home</div>
						<div class="bar"></div>
					</a> <a href="/dbms/j_spring_security_logout" class="link">
						<div class="title">Logout</div>
						<div class="bar"></div>
					</a>
				</div>
			</div>
		</c:when>
		<c:when test='${role=="ROLE_EMPLOYEE"}'>
			<div class="header">
				<div class="logo">Getwin Electro Pneumatic Corp.</div>
				<div class="menu">
					<a href="/dbms/empl" class="link">
						<div class="title">Home</div>
						<div class="bar"></div>
					</a> <a href="/dbms/j_spring_security_logout" class="link">
						<div class="title">Logout</div>
						<div class="bar"></div>
					</a>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="header">
				<div class="logo">Getwin Electro Pneumatic Corp.</div>
				<div class="menu">
					<a href="/dbms" class="link">
						<div class="title">Home</div>
						<div class="bar"></div>
					</a> 
					<a href="/dbms/login" class="link">
						<div class="title">Login</div>
						<div class="bar"></div>
					</a> <a href="/dbms/register" class="link">
						<div class="title">Signup</div>
						<div class="bar"></div>
					</a>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>