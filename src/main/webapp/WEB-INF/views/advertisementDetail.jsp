<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/css/advertisementDetail.css" var="advertisementDetailCss"/>

<html>
<head>
    <title>Advertisement Detail</title>
    <link href="${advertisementDetailCss}" rel="stylesheet"/>
</head>
<body>

<img class="real-estate-image"
     src="realEstateImage/${viewBean.realEstateId}?type=${viewBean.realEstateImageType}"
     alt="image no found"/>


<table class="detail-table">
    <tbody>
    <c:forEach items="${viewBean.advertisementProperties}" var="property">
        <tr>
            <td class="title">${property.key}</td>
            <td class="value">${property.value}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2">
            <a href="home">Почетна</a>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
