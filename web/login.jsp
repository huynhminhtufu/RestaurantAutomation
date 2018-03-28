<%-- 
    Document   : login
    Created on : Jul 10, 2017, 2:45:37 PM
    Author     : huynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login Page</h2>
        <form action="login" method="POST">
            <table>
                <tr><td>EmpName</td><td><input type="text" name="empName" value="" /></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value="" /></td></tr>
                <tr><td colspan="2"><input type="submit" value="Login" name="submit" /></td></tr>
            </table>
        </form>
        <s:if test="%{loginStatus == false}">
            <div>Username or password is incorrect.</div>
        </s:if>
    </body>
</html>