<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Registration</title>
</head>
<body>

<a href="registration?language=en">EN</a> | <a href="registration?language=mk">MK</a>

<h1>
    Registration
</h1>
<form:form modelAttribute="user" method="POST" enctype="utf8">
    <br>
    <tr>
        <td>
            <label>
                User Name
            </label>
        </td>
        <td><form:input path="userName" value=""/></td>
        <form:errors path="userName" element="div"/>
    </tr>
    <tr>
        <td>
            <label>
                E mail
            </label>
        </td>
        <td><form:input path="email" value=""/></td>
        <form:errors path="email" element="div"/>
    </tr>
    <tr>
        <td>
            <label>
                Password
            </label>
        </td>
        <td>
            <form:input path="password" value="" type="password"/></td>
        <form:errors path="password" element="div"/>
    </tr>
    <tr>
        <td>
            <label>
                Password Confirm
            </label>
        </td>
        <td><form:input path="matchingPassword" value="" type="password"/></td>
        <form:errors element="div"/>
    </tr>
    <button type="submit">
        Submit
    </button>
</form:form>
<br>
<a href="login">Login</a>
</body>
</html>