<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 26.08.2015
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table border="5">

<c:forEach items="${testIdList}" var="item">
  <tr>

 <td> <c:out value="${item}"/></td>

    </tr>
</c:forEach>

  </table>


${testWord}

</body>
</html>
