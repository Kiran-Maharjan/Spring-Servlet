<%-- 
    Document   : login
    Created on : Jul 17, 2018, 8:39:14 AM
    Author     : kiran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM-Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post">
            <div>
                <label>User Name</label>
                <input type="text" name="username" required="required" />
                            </div>
           
            <div>
                <label>Password</label>
                <input type="password" name="password" required="required" />   
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit"> Login</button>
        </form>
        
    </body>
</html>
