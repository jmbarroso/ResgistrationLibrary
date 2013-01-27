<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:message code="user.createView.title" /></title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#"><g:message code="app.title" /></a>
        <ul class="nav">
            <li class="active"><a href="#"><g:message code="app.menu.createUserLink" /></a></li>
        </ul>
    </div>
</div>


<div class="container">
    <g:render template="/shared/messageBoxTemplate"/>

    <g:form class="form-horizontal" controller="user" action="register">

        <fieldset>
        <legend><g:message code="user.createView.form.legend" /></legend>
        <div class="control-group ${hasErrors(bean: userCommand, field: 'username', 'error')}">
            <label class="control-label" for="input.username"><g:message code="user.createView.form.labels.username" /></label>

            <div class="controls">
                <g:textField id="input.username" name="username"
                             value="${fieldValue(bean: userCommand, field: 'username')}"></g:textField>

                <span class="help-block">
                    <g:eachError bean="${userCommand}" field="username">
                        <p><g:message error="${it}"/></p>
                    </g:eachError>
                </span>

            </div>
        </div>

        <div class="control-group ${hasErrors(bean: userCommand, field: 'email', 'error')}">
            <label class="control-label" for="input.email"><g:message code="user.createView.form.labels.email" /></label>

            <div class="controls">
                <g:textField id="input.email" name="email"
                             value="${fieldValue(bean: userCommand, field: 'email')}"></g:textField>

                <span class="help-block">
                    <g:eachError bean="${userCommand}" field="email">
                        <p><g:message error="${it}"/></p>
                    </g:eachError>
                </span>
            </div>
        </div>

        <div class="control-group ${hasErrors(bean: userCommand, field: 'zipCode', 'error')}">
            <label class="control-label" for="input.zipCode"><g:message code="user.createView.form.labels.zipcode" /></label>

            <div class="controls">
                <g:textField id="input.zipCode" name="zipCode"
                             value="${fieldValue(bean: userCommand, field: 'zipCode')}"></g:textField>

                <span class="help-block">
                    <g:eachError bean="${userCommand}" field="zipCode">
                        <p><g:message error="${it}"/></p>
                    </g:eachError>
                </span>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label"><g:message code="user.createView.form.labels.domain" /></label>

            <div class="controls">
                <g:select  id="input.domain" name="userDomain" from="${['English','Brazil','Spanish']}" value="${fieldValue(bean: userCommand, field: 'userDomain')}"></g:select>
            </div>
        </div>

        <button type="submit" class="btn"><g:message code="user.createView.form.submitButton" /></button>
    </g:form></div>
</body>
</html>