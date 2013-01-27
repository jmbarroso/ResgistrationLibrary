<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register User</title>                                     e
</head>
<body>

<g:form controller="user" action="register">

    <g:textField name="username" value="${fieldValue(bean:userCommand,field:'username')}"></g:textField>
    <g:textField name="email"  value="${fieldValue(bean:userCommand, field:'email')}"></g:textField>
    <g:textField name="zipCode"  value="${fieldValue(bean:userCommand, field:'zipCode')}"></g:textField>

</g:form>

</body>
</html>