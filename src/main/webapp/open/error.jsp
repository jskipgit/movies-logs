<%--
  Created by IntelliJ IDEA.
  User: jasonskipper
  Date: 2/9/17
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>So Sorry!</title>
</head>
<body>
There was some trouble, we are very sorry.  Come back some day when we are better.
<c:out value="${url}"/>
<p>
<c:out value="${exception}"/>
</p>
</body>
</html>
