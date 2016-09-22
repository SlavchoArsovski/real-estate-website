<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/css/addAdvertisement.css" var="mainCss"/>
<spring:url value="/js/jquery-3.1.0.min.js" var="jqueryJs"/>


<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${jqueryJs}" type="application/javascript"></script>

    <title>Add advertisement</title>

    <script type="application/javascript">

        function submitAdvertisementFormAfterRealEstateTypeChange(event) {
            $('#advertisementForm').append('<input type="hidden" name="realEstateChange" value="realEstateChange" />');
            $('#submitAdvertisement').click();
        }

    </script>

</head>
<body>

<a href="addAdvertisement?language=en">EN</a> | <a href="addAdvertisement?language=mk">MK</a>

<form:form id="advertisementForm" name="advertisementForm" method="post" modelAttribute="viewBean"
           action="addAdvertisement" cssClass="advertisementForm">

    <div>
        <label class="property">Real Estate Type</label>
        <form:select class="propertyValue" path="selectedRealEstateType" items="${viewBean.realEstateTypes}"
                     onchange="return submitAdvertisementFormAfterRealEstateTypeChange()"/>
    </div>

    <div>
        <label class="property">Description</label>
        <form:textarea class="propertyValue" path="description"/>
    </div>

    <div>
        <label class="property">City</label>
        <form:select class="propertyValue" path="selectedCity" items="${viewBean.cities}"/>
    </div>

    <div>
        <label class="property">Price</label>
        <form:input class="propertyValue" path="price" type="text"/>
    </div>

    <div>
        <label class="property">Square Meters</label>
        <form:input class="propertyValue" path="squareMeters" type="text"/>
    </div>

    <c:if test="${viewBean.validProperties.contains('YEAR_OF_CONSTRUCTION')}">
        <div>
            <label class="property">Year Of Construction</label>
            <form:input class="propertyValue" path="yearOfConstruction" type="text"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('NUMBER_OF_ROOMS')}">
        <div>
            <label class="property">Number of rooms</label>
            <form:input class="propertyValue" path="numberOfRooms" type="text"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('NUMBER_OF_BEDS')}">
        <div>
            <label class="property">Number of beds</label>
            <form:input class="propertyValue" path="numberOfBeds" type="text"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('CENTRAL_HEATING_INCLUDED')}">
        <div>
            <label class="property">Central Heating</label>
            <form:checkbox class="propertyValue" path="centralHeating"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('AIR_CONDITIONED')}">
        <div>
            <label class="property">Air Conditioned</label>
            <form:checkbox class="propertyValue" path="airConditioned"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('ELEVATOR_INCLUDED')}">
        <div>
            <label class="property">Elevator</label>
            <form:checkbox class="propertyValue" path="elevator"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('GARAGE_INCLUDED')}">
        <div>
            <label class="property">Garage</label>
            <form:checkbox class="propertyValue" path="garage"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('PARKING_INCLUDED')}">
        <div>
            <label class="property">Parking</label>
            <form:checkbox class="propertyValue" path="parking"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('YARD_INCLUDED')}">
        <div>
            <label class="property">Yard</label>
            <form:checkbox class="propertyValue" path="yard"/>
        </div>
    </c:if>

    <c:if test="${viewBean.validProperties.contains('POOL_INCLUDED')}">
        <div>
            <label class="property">Pool</label>
            <form:checkbox class="propertyValue" path="pool"/>
        </div>
    </c:if>

    <div>
        <input id="submitAdvertisement" name="submit" type="submit" value="Submit"/>
    </div>

</form:form>

</body>
</html>
