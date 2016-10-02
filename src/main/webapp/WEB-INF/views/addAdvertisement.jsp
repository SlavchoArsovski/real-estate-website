<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/css/addAdvertisement.css" var="mainCss"/>
<spring:url value="/js/jquery-3.1.0.min.js" var="jqueryJs"/>
<spring:url value="/js/utils/utils.js" var="utils"/>


<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${jqueryJs}" type="application/javascript"></script>
    <script src="${utils}" type="application/javascript"></script>

    <title>Add advertisement</title>

    <script type="application/javascript">

        function submitAdvertisementFormAfterRealEstateTypeChange(event) {
            $('#advertisementForm').append('<input type="hidden" name="realEstateChange" value="realEstateChange" />');
            $('#submitAdvertisement').click();
        }

        $(document).ready(function () {

            $('#price').keydown(function (e) {
                utils.inputWithOnlyDigits(e);
            });

            $('#squareMeters').keydown(function (e) {
                utils.inputWithOnlyDigits(e);
            });

            $('#yearOfConstruction').keydown(function (e) {
                utils.inputWithOnlyDigits(e);
            });

            $('#numberOfBeds').keydown(function (e) {
                utils.inputWithOnlyDigits(e);
            });

            $('#numberOfRooms').keydown(function (e) {
                utils.inputWithOnlyDigits(e);
            });
        });

    </script>

</head>
<body>

<a href="addAdvertisement?language=en">EN</a> | <a href="addAdvertisement?language=mk">MK</a>

<form:form name="advertisementForm" method="post" modelAttribute="advertisementForm"
           action="addAdvertisement?${_csrf.parameterName}=${_csrf.token}" cssClass="advertisementForm"
           enctype="multipart/form-data">

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.realEstateType"/>
        </label>
        <form:select class="propertyValue" path="selectedRealEstateType" items="${advertisementForm.realEstateTypes}"
                     onchange="return submitAdvertisementFormAfterRealEstateTypeChange()"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.advertisementType"/>
        </label>
        <form:select class="propertyValue" path="selectedAdvertisementType"
                     items="${advertisementForm.advertisementTypes}"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.description"/>
        </label>
    </div>

    <div>
        <form:textarea class="description" path="description"/>
    </div>

    <div>
        <form:errors path="description" element="div"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.city"/>
        </label>
        <form:select class="propertyValue" path="selectedCity" items="${advertisementForm.cities}"/>
    </div>

    <div>
        <form:errors path="selectedCity" element="div"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.address"/>
        </label>
        <form:input class="propertyValue" path="address" type="text"/>
    </div>

    <div>
        <form:errors path="address" element="div"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.price"/>
        </label>
        <form:input id="price" class="propertyValue" path="price" type="text" placeholder="€"/>
    </div>

    <div>
        <form:errors path="price" element="div"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.squareMeters"/>
        </label>
        <form:input id="squareMeters" class="propertyValue" path="squareMeters" type="text" placeholder="M2"/>
    </div>

    <div>
        <form:errors path="squareMeters" element="div"/>
    </div>

    <div>
        <label class="property">
            <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.image"/>
        </label>
        <form:input id="realEstateImage" path="realEstateImage" class="propertyValue" type="file"/>
    </div>

    <c:if test="${advertisementForm.validProperties.contains('YEAR_OF_CONSTRUCTION')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.yearOfConstruction"/>
            </label>
            <form:input id="yearOfConstruction" class="propertyValue" path="yearOfConstruction" type="text"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('NUMBER_OF_ROOMS')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.numberOfRooms"/>
            </label>
            <form:input id="numberOfRooms" class="propertyValue" path="numberOfRooms" type="text"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('NUMBER_OF_BEDS')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.numberOfBeds"/>
            </label>
            <form:input id="numberOfBeds" class="propertyValue" path="numberOfBeds" type="text"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('CENTRAL_HEATING_INCLUDED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.centralHeating"/>
            </label>
            <form:checkbox class="propertyValue" path="centralHeating"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('AIR_CONDITIONED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.airConditioned"/>
            </label>
            <form:checkbox class="propertyValue" path="airConditioned"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('ELEVATOR_INCLUDED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.elevator"/>
            </label>
            <form:checkbox class="propertyValue" path="elevator"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('GARAGE_INCLUDED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.garage"/>
            </label>
            <form:checkbox class="propertyValue" path="garage"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('PARKING_INCLUDED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.parking"/>
            </label>
            <form:checkbox class="propertyValue" path="parking"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('YARD_INCLUDED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.yard"/>
            </label>
            <form:checkbox class="propertyValue" path="yard"/>
        </div>
    </c:if>

    <c:if test="${advertisementForm.validProperties.contains('POOL_INCLUDED')}">
        <div>
            <label class="property">
                <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.pool"/>
            </label>
            <form:checkbox class="propertyValue" path="pool"/>
        </div>
    </c:if>

    <div>
        <spring:message code="realestatewebsite.fe.messages.addAdvertisement.label.submit" var="submitText"/>
        <input id="submitAdvertisement" name="submit" type="submit" value="${submitText}">
        </input>
    </div>

    <div>
        <a href="home">Почетна</a>
    </div>


</form:form>

</body>
</html>
