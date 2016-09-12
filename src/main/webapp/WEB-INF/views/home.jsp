<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/css/main.css" var="mainCss"/>
<spring:url value="/css/jquery-ui.min.css" var="jqueryUiCss"/>
<spring:url value="/js/jquery-3.1.0.min.js" var="jqueryJs"/>
<spring:url value="/js/jquery-ui.min.js" var="jqueryUiJs"/>
<spring:url value="/js//home/homeView.js" var="homeView"/>
<spring:url value="/js/home/homeModel.js" var="homeModel"/>
<spring:url value="/js/home/homeController.js" var="homeController"/>


<spring:url value="/images" var="imageFolderPrefix"/>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="${mainCss}" rel="stylesheet"/>
    <link href="${jqueryUiCss}" rel="jqueryUiCss"/>
    <script src="${jqueryJs}"></script>
    <script src="${jqueryUiJs}"></script>
    <script src="${homeView}"></script>
    <script src="${homeModel}"></script>
    <script src="${homeController}"></script>

    <title><spring:message code="realestatewebsite.fe.messages.home.title"/></title>

</head>
<body>

<a href="home?language=en">EN</a> | <a href="home?language=mk">MK</a>

<div class="home-header" id="homepage-header">
    <div id="hero-img-wrapper" class="hero-img-wrapper">
        <div class="hero-img-fallback">
            <img alt="realtor.com for sale home page"
                 src="${imageFolderPrefix}/wallpapers_1.jpg">
        </div>
    </div>
    <div class="container home-header-content">
        <div class="row">
            <header class="header-group header-group-white text-center" id="hero-header-text">
                <h1>
                    <span>Discover Your Perfect Home</span>
                </h1>
            </header>
            <div class="home-search-wrapper">
                <div id="menu-wrapper" class="menu-wrapper">
                    <div class="menu-item"
                         onclick="window.location.href=window.location.pathname + '?advertisementType=SALE'">
                        <input type="radio" name="property-status" id="for_sale" value="for_sale" checked="">
                        <label for="for_sale">
                            <spring:message code="realestatewebsite.fe.messages.home.menu.item.buy"/>
                        </label>
                    </div>
                    <div class="menu-item"
                         onclick="window.location.href=window.location.pathname + '?advertisementType=RENT'">
                        <input type="radio" name="property-status" id="for_rent" value="for_rent">
                        <label for="for_rent">
                            <spring:message code="realestatewebsite.fe.messages.home.menu.item.rent"/>
                        </label>
                    </div>
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="recently_sold" value="recently_sold">
                        <label for="recently_sold">Add Advertisement</label>
                    </div>
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="property_records" value="property_records">
                        <label for="property_records">Log In</label>
                    </div>
                </div>

                <div class="search-properties">

                    <div>
                        <label class="propertyText">Real Estate Type</label>
                        <select id="realEstateTypeDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.realEstateTypesDropdown}" var="realEstateType">

                                <c:choose>
                                    <c:when test="${realEstateType.key.equals(viewBean.selectedRealEstateType)}">
                                        <option value="${realEstateType.key}"
                                                selected="selected">${realEstateType.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${realEstateType.key}">${realEstateType.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Price from</label>
                        <input id="price_from" class="propertyValue" type="text" value="${viewBean.priceFrom}"/>
                    </div>

                    <div>
                        <label class="propertyText">Price to</label>
                        <input id="price_to" class="propertyValue" type="text" value="${viewBean.priceTo}"/>
                    </div>

                    <div>
                        <label class="propertyText">City</label>
                        <select id="cityDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.citiesDropdown}" var="city">

                                <c:choose>
                                    <c:when test="${city.key.equals(viewBean.selectedCity)}">
                                        <option value="${city.key}" selected="selected">${city.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${city.key}">${city.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Square Meters from</label>
                        <input id="square-meters_from" class="propertyValue" type="text"
                               value="${viewBean.squareMetersFrom}"/>
                    </div>

                    <div>
                        <label class="propertyText">Square Meters to</label>
                        <input id="square-meters_to" class="propertyValue" type="text"
                               value="${viewBean.squareMetersTo}"/>
                    </div>

                    <c:set var="yearOfConstructionSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('YEAR_OF_CONSTRUCTION')}">
                        <c:set var="yearOfConstructionSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="yearOfConstructionSearch" class="${yearOfConstructionSearchClass}">
                        <label class="propertyText">Year of Construction</label>
                        <input id="yearOfConstruction" class="propertyValue" type="text"
                               value="${viewBean.yearOfConstruction}"/>
                    </div>

                    <c:set var="numberOfRoomsSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('NUMBER_OF_ROOMS')}">
                        <c:set var="numberOfRoomsSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="numberOfRoomsSearch" class="${numberOfRoomsSearchClass}">
                        <label class="propertyText">Number of rooms</label>
                        <input id="numberOfRooms" class="propertyValue" type="text"
                               value="${viewBean.numberOfRooms}"/>
                    </div>

                    <c:set var="numberOfBedsSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('NUMBER_OF_BEDS')}">
                        <c:set var="numberOfBedsSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="numberOfBedsSearch" class="${numberOfBedsSearchClass}">
                        <label class="propertyText">Number of beds</label>
                        <input id="numberOfBeds" class="propertyValue" type="text" value="${viewBean.numberOfBeds}"/>
                    </div>

                    <c:set var="centralHeatingSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('CENTRAL_HEATING_INCLUDED')}">
                        <c:set var="centralHeatingSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="centralHeatingSearch" class="${centralHeatingSearchClass}">
                        <label class="propertyText">Central Heating</label>
                        <select id="centralHeatingDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.centralHeatingDropdown}" var="centralHeating">

                                <c:choose>
                                    <c:when test="${centralHeating.key.equals(viewBean.selectedCentralHeating)}">
                                        <option value="${centralHeating.key}"
                                                selected="selected">${centralHeating.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${centralHeating.key}">${centralHeating.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <c:set var="airConditionSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('AIR_CONDITIONED')}">
                        <c:set var="airConditionSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="airConditionSearch" class="${airConditionSearchClass}">
                        <label class="propertyText">Air Conditioned</label>
                        <select id="airConditionedDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.airConditionedDropdown}" var="airConditioned">

                                <c:choose>
                                    <c:when test="${airConditioned.key.equals(viewBean.selectedAirConditioned)}">
                                        <option value="${airConditioned.key}"
                                                selected="selected">${airConditioned.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${airConditioned.key}">${airConditioned.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <c:set var="yardSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('YARD_INCLUDED')}">
                        <c:set var="yardSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="yardSearchClass" class="${yardSearchClass}">
                        <label class="propertyText">Yard</label>
                        <select id="yardIncludedDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.yardIncludedDropdown}" var="yardIncluded">

                                <c:choose>
                                    <c:when test="${yardIncluded.key.equals(viewBean.selectedYardIncluded)}">
                                        <option value="${yardIncluded.key}"
                                                selected="selected">${yardIncluded.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${yardIncluded.key}">${yardIncluded.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <c:set var="garageSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('GARAGE_INCLUDED')}">
                        <c:set var="garageSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="garageSearch" class="${garageSearchClass}">
                        <label class="propertyText">Garage</label>
                        <select id="garageIncludedDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.garageIncludedDropdown}" var="garageIncluded">

                                <c:choose>
                                    <c:when test="${garageIncluded.key.equals(viewBean.selectedGarageIncluded)}">
                                        <option value="${garageIncluded.key}"
                                                selected="selected">${garageIncluded.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${garageIncluded.key}">${garageIncluded.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <c:set var="elevatorSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('ELEVATOR_INCLUDED')}">
                        <c:set var="elevatorSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="elevatorSearch" class="${elevatorSearchClass}">
                        <label class="propertyText">Elevator</label>
                        <select id="elevatorIncludedDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.elevatorIncludedDropdown}" var="elevatorIncluded">

                                <c:choose>
                                    <c:when test="${elevatorIncluded.key.equals(viewBean.selectedElevatorIncluded)}">
                                        <option value="${elevatorIncluded.key}"
                                                selected="selected">${elevatorIncluded.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${elevatorIncluded.key}">${elevatorIncluded.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <c:set var="poolSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('POOL_INCLUDED')}">
                        <c:set var="poolSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="poolSearch" class="${poolSearchClass}">
                        <label class="propertyText">Pool</label>
                        <select id="poolIncludedDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.poolIncludedDropdown}" var="poolIncluded">

                                <c:choose>
                                    <c:when test="${poolIncluded.key.equals(viewBean.selectedPoolIncluded)}">
                                        <option value="${poolIncluded.key}"
                                                selected="selected">${poolIncluded.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${poolIncluded.key}">${poolIncluded.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <c:set var="parkingSearchClass" value=""/>
                    <c:if test="${!viewBean.validProperties.contains('PARKING_INCLUDED')}">
                        <c:set var="parkingSearchClass" value="property-disabled"/>
                    </c:if>

                    <div id="parkingSearch" class="${parkingSearchClass}">
                        <label class="propertyText">Parking</label>
                        <select id="parkingIncludedDropdown" class="propertyValue">
                            <c:forEach items="${viewBean.parkingIncludedDropdown}" var="parkingIncluded">

                                <c:choose>
                                    <c:when test="${parkingIncluded.key.equals(viewBean.selectedParkingIncluded)}">
                                        <option value="${parkingIncluded.key}"
                                                selected="selected">${parkingIncluded.value}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${parkingIncluded.key}">${parkingIncluded.value}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                </div>
            </div>
        </div>
    </div>

</div>

<div class="main-container">

    <div class="real-estate-container">

        <div class="real-estate-list-item-template">
            <div class="real-estate-list-item">

                <div class="real-estate-list-item-image"></div>

                <div class="real-estate-list-item-details">

                    <div>{realEstateItemTemplate.address}</div>

                    <div>
                        {realEstateItemTemplate.messageRealEstateType}
                        {realEstateItemTemplate.messageAt}
                        {realEstateItemTemplate.city}, {realEstateItemTemplate.region}
                    </div>

                    <div>
                        {realEstateItemTemplate.messageArea}: {realEstateItemTemplate.squareMeters} m<sup>2</sup>
                    </div>

                    <div>
                        {realEstateItemTemplate.messagePrice}: {realEstateItemTemplate.price}
                        {realEstateItemTemplate.messageCurrency}
                    </div>

                    <div>
                        {realEstateItemTemplate.messagePhone}: {realEstateItemTemplate.phone}
                    </div>
                </div>
            </div>
        </div>

        <div class="real-estate-list">

            <c:forEach items="${viewBean.realEstates}" var="realEstate">

                <div class="real-estate-list-item">

                    <div class="real-estate-list-item-image"></div>

                    <div class="real-estate-list-item-details">
                        <div>${realEstate.address}</div>

                        <div>
                            <spring:message
                                    code="realestatewebsite.fe.messages.general.realEstateType.${realEstate.realEstateType}"/>
                            <spring:message
                                    code="realestatewebsite.fe.messages.home.realestatelist.realEstateType.atPlace"/>
                                ${realEstate.city}, ${realEstate.region}
                        </div>

                        <div>
                            <spring:message
                                    code="realestatewebsite.fe.messages.home.realestatelist.area"/>: ${realEstate.squareMeters}
                            m<sup>2</sup>
                        </div>

                        <div>
                            <spring:message
                                    code="realestatewebsite.fe.messages.home.realestatelist.price"/>: ${realEstate.price}
                            <spring:message
                                    code="realestatewebsite.fe.messages.home.realestatelist.currency"/>
                        </div>

                        <div>
                            <spring:message code="realestatewebsite.fe.messages.home.realestatelist.phone"/>: 070
                            882-031
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

</div>

</body>
</html>
