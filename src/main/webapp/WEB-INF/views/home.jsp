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

                    <div>
                        <label class="propertyText">Year of Construction</label>
                        <input id="yearOfConstruction" class="propertyValue" type="text"
                               value="${viewBean.yearOfConstruction}"/>
                    </div>

                    <div>
                        <label class="propertyText">Central Heating</label>
                        <c:choose>
                            <c:when test="${viewBean.centralHeatingIncluded}">
                                <input id="centralHeatingIncluded" class="propertyValue" type="checkbox"
                                       checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="centralHeatingIncluded" class="propertyValue" type="checkbox"/>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div>
                        <label class="propertyText">Air Conditioned</label>
                        <c:choose>
                            <c:when test="${viewBean.airConditioned}">
                                <input id="airConditioned" class="propertyValue" type="checkbox" checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="airConditioned" class="propertyValue" type="checkbox"/>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div>
                        <label class="propertyText">Yard</label>
                        <c:choose>
                            <c:when test="${viewBean.yardIncluded}">
                                <input id="yardIncluded" class="propertyValue" type="checkbox" checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="yardIncluded" class="propertyValue" type="checkbox"/>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div>
                        <label class="propertyText">Garage</label>
                        <c:choose>
                            <c:when test="${viewBean.garageIncluded}">
                                <input id="garageIncluded" class="propertyValue" type="checkbox" checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="garageIncluded" class="propertyValue" type="checkbox"/>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div>
                        <label class="propertyText">Elevator</label>
                        <c:choose>
                            <c:when test="${viewBean.elevatorIncluded}">
                                <input id="elevatorIncluded" class="propertyValue" type="checkbox" checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="elevatorIncluded" class="propertyValue" type="checkbox"/>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div>
                        <label class="propertyText">Number Of floors</label>
                        <input id="numberOfFloors" class="propertyValue" type="text">
                    </div>

                    <div>
                        <label class="propertyText">Number Of beds</label>
                        <input id="numberOfBeds" class="propertyValue" type="text">
                    </div>

                    <div>
                        <label class="propertyText">Number Of Offices</label>
                        <input id="numberOfOffices" class="propertyValue" type="text">
                    </div>

                    <div>
                        <label class="propertyText">Parking</label>
                        <c:choose>
                            <c:when test="${viewBean.parkingIncluded}">
                                <input id="parkingIncluded" class="propertyValue" type="checkbox" checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="parkingIncluded" class="propertyValue" type="checkbox"/>
                            </c:otherwise>
                        </c:choose>
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
