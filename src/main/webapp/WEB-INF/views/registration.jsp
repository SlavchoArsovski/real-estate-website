<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Registration</title>

    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #registration-box {
            width: 350px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>

</head>
<body>

<a href="registration?language=en">EN</a> | <a href="registration?language=mk">MK</a>

<div id="registration-box">

    <form:form name="userForm" modelAttribute="userForm" method="POST" enctype="utf8">

        <table>
            <tr>
                <td>
                    <spring:message code="realestatewebsite.fe.messages.general.user"/>
                </td>
                <td>
                    <form:input type="text" name="userName" path="userName" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:errors path="userName" element="div"/>
                </td>
            </tr>
            <tr>
                <td>
                    Email
                </td>
                <td>
                    <form:input type="text" name="email" path="email" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:errors path="email" element="div"/>
                </td>
            </tr>
            <tr>
                <td>
                    Phone Number
                </td>
                <td>
                    <form:input type="text" name="phoneNumber" path="phoneNumber" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:errors path="phoneNumber" element="div"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="realestatewebsite.fe.messages.general.password"/>
                </td>
                <td>
                    <form:input type="password" name="password" path="password" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:errors path="password" element="div"/>
                </td>
            </tr>
            <tr>
                <td>
                    Password Confirm
                </td>
                <td>
                    <form:input type="password" name="passwordConfirm" path="passwordConfirm" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:errors path="passwordConfirm" element="div"/>
                </td>
            </tr>
            <tr>
                <td colspan='2'>
                    <spring:message code="realestatewebsite.fe.messages.login.label.submit" var="submitText"/>
                    <input name="submit" type="submit" value="${submitText}"/>
                </td>
            </tr>
            <tr>
                <td><a href="home">Почетна</a></td>
                <td><a href="login">Најава</a></td>
            </tr>

        </table

    </form:form>
</div>
</body>
</html>