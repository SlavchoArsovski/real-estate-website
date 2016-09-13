<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/css/main.css" var="mainCss"/>
<spring:url value="/js/jquery-3.1.0.min.js" var="jqueryJs"/>
<spring:url value="/js//home/homeView.js" var="homeView"/>
<spring:url value="/js/home/homeModel.js" var="homeModel"/>
<spring:url value="/js/home/homeController.js" var="homeController"/>


<spring:url value="/images" var="imageFolderPrefix"/>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${jqueryJs}" type="application/javascript"></script>
    <script src="${homeView}" type="application/javascript"></script>
    <script src="${homeModel}" type="application/javascript"></script>
    <script src="${homeController}" type="application/javascript"></script>

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
            <div class="header-group header-group-white text-center" id="hero-header-text">
                <h1>
                    <span>Discover Your Perfect Home</span>
                </h1>
            </div>
            <div class="home-search-wrapper">
                <div id="menu-wrapper" class="menu-wrapper">
                    <div class="menu-item"
                         onclick="window.location.href=window.location.pathname + '?advertisementType=SALE'">
                        <input type="radio" name="property-status" id="for_sale" value="for_sale" checked="checked">
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
                                <option value="${realEstateType.key}"
                                    ${realEstateType.key.equals(viewBean.selectedRealEstateType) ? 'selected' : ''}>${realEstateType.value}</option>
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
                                <option value="${city.key}" ${city.key.equals(viewBean.selectedCity) ? 'selected' : ''}>${city.value}</option>
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
                               value="${viewBean.yearOfConstruction}" ${viewBean.validProperties.contains('YEAR_OF_CONSTRUCTION') ? '' : 'disabled'} />
                    </div>

                    <div>
                        <label class="propertyText">Number of rooms</label>
                        <input id="numberOfRooms" class="propertyValue" type="text"
                               value="${viewBean.numberOfRooms}" ${viewBean.validProperties.contains('NUMBER_OF_ROOMS') ? '' : 'disabled'} />
                    </div>

                    <div>
                        <label class="propertyText">Number of beds</label>
                        <input id="numberOfBeds" class="propertyValue" type="text"
                               value="${viewBean.numberOfBeds}" ${viewBean.validProperties.contains('NUMBER_OF_BEDS') ? '' : 'disabled'} />
                    </div>

                    <div>
                        <label class="propertyText">Central Heating</label>

                        <select id="centralHeatingDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('CENTRAL_HEATING_INCLUDED') ? '' : 'disabled'} >

                            <c:forEach items="${viewBean.centralHeatingDropdown}" var="centralHeating">
                                <option value="${centralHeating.key}"
                                    ${centralHeating.key.equals(viewBean.selectedCentralHeating) ? 'selected' : ''}>${centralHeating.value}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Air Conditioned</label>
                        <select id="airConditionedDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('AIR_CONDITIONED') ? '' : 'disabled'}>
                            <c:forEach items="${viewBean.airConditionedDropdown}" var="airConditioned">
                                <option value="${airConditioned.key}"
                                    ${airConditioned.key.equals(viewBean.selectedAirConditioned) ? 'selected' : ''}>${airConditioned.value}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Yard</label>
                        <select id="yardIncludedDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('YARD_INCLUDED') ? '' : 'disabled'}>
                            <c:forEach items="${viewBean.yardIncludedDropdown}" var="yardIncluded">
                                <option value="${yardIncluded.key}"
                                    ${yardIncluded.key.equals(viewBean.selectedYardIncluded) ? 'selected' : ''}>${yardIncluded.value}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Garage</label>
                        <select id="garageIncludedDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('GARAGE_INCLUDED') ? '' : 'disabled'}>
                            <c:forEach items="${viewBean.garageIncludedDropdown}" var="garageIncluded">
                                <option value="${garageIncluded.key}"
                                    ${garageIncluded.key.equals(viewBean.selectedGarageIncluded) ? 'selected' : ''}>${garageIncluded.value}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Elevator</label>
                        <select id="elevatorIncludedDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('ELEVATOR_INCLUDED') ? '' : 'disabled'}>
                            <c:forEach items="${viewBean.elevatorIncludedDropdown}" var="elevatorIncluded">
                                <option value="${elevatorIncluded.key}"
                                    ${elevatorIncluded.key.equals(viewBean.selectedElevatorIncluded) ? 'selected' : ''}>${elevatorIncluded.value}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="propertyText">Pool</label>
                        <select id="poolIncludedDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('POOL_INCLUDED') ? '' : 'disabled'}>
                            <c:forEach items="${viewBean.poolIncludedDropdown}" var="poolIncluded">
                                <option value="${poolIncluded.key}"
                                    ${poolIncluded.key.equals(viewBean.selectedPoolIncluded) ? 'selected' : ''}>${poolIncluded.value}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div style="clear: both"/>

                    <div>
                        <label class="propertyText">Parking</label>
                        <select id="parkingIncludedDropdown"
                                class="propertyValue" ${viewBean.validProperties.contains('PARKING_INCLUDED') ? '' : 'disabled'}>
                            <c:forEach items="${viewBean.parkingIncludedDropdown}" var="parkingIncluded">
                                <option value="${parkingIncluded.key}"
                                    ${parkingIncluded.key.equals(viewBean.selectedParkingIncluded) ? 'selected' : ''}>${parkingIncluded.value}
                                </option>
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
