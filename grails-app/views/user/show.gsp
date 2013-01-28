<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Show register user</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#"><g:message code="app.title" /></a>
        <ul class="nav">
            <li class=""><a href="${g.createLink(action: 'create')}"><g:message code="app.menu.createUserLink" /></a></li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="page-header">
            <h3>Show user data</h3>
        </div>
    </div>

    <div class="well">
        <div class="row">
            <div class="span2">
                <h4><g:message code="user.createView.form.labels.username" /></h4>
            </div>

            <div class="span2">
                <span>${user.username}</span>
            </div>
        </div>

        <div class="row">
            <div class="span2">
                <h4><g:message code="user.createView.form.labels.email" /></h4>
            </div>

            <div class="span3">
                <span>${user.email}</span>
            </div>
        </div>

        <div class="row">
            <div class="span2">
                <h4><g:message code="user.createView.form.labels.zipcode" /></h4>
            </div>

            <div class="span3">
                <span>${user.zipCode}</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>