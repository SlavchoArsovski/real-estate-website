<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/css/main.css" var="mainCss"/>
<spring:url value="/js/jquery-3.1.0.min.js" var="jqueryJs"/>

<spring:url value="/images" var="imageFolderPrefix"/>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${jqueryJs}"></script>

    <title><spring:message code="realestatewebsite.fe.messages.home.title" /></title>

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
                <p class="header-section-secondary text-center hidden-xs hidden-xxs">with the most complete source of
                    homes for sale &amp; real estate near you</p>
            </header>
            <div class="home-search-wrapper">
                <div id="menu-wrapper" class="menu-wrapper">
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="for_sale" value="for_sale" checked="">
                        <label for="for_sale">Buy</label>
                    </div>
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="for_rent" value="for_rent">
                        <label for="for_rent">Rent</label>
                    </div>
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="recently_sold" value="recently_sold">
                        <label for="recently_sold">Just Sold</label>
                    </div>
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="property_records" value="property_records">
                        <label for="property_records">Home Estimate</label>
                    </div>
                </div>

                <div class="input-group search-input-group">
                    <input type="text" id="searchBox" class="form-control"
                           placeholder="Address, City, Zip,  Neighborhood or MLS ID" value="New York City, NY"
                           autocomplete="off">
                    <span class="input-group-btn">
        <button class="btn btn-primary js-searchButton" type="button">
          <span class="hidden-xxs hidden-xs">Search</span>
        </button>
  </span>
                </div>

                <div class="search-autocomplete container-fluid no-show js-autocomplete-dropdow" style="">
                    <div class="autocomplete-example default-search-results hidden-xs hidden-xxs js-default-search-results">

                    </div>
                    <div class="no-show found-search-results js-found-search-results">
                        <ul class="list-unstyled">
                        </ul>
                    </div>

                </div>

            </div>
        </div>
    </div>

</div>

<div class="main-container">

    <c:forEach items="${viewBean.realEstates}" var="realEstate">
        <div class="real-estate-container">
            <div class="real-estate-list">
                <div>
                    <spring:message code="realestatewebsite.fe.messages.home.realestatelist.realEstateType" />:
                    <spring:message code="realestatewebsite.fe.messages.home.realestatelist.realEstateType.${realEstate.realEstateType}" />
                </div>
                <div>
                    <spring:message code="realestatewebsite.fe.messages.home.realestatelist.city" />: ${realEstate.city}
                </div>
                <div>
                    <spring:message code="realestatewebsite.fe.messages.home.realestatelist.region" />: ${realEstate.region}
                </div>
                <div>
                    <spring:message code="realestatewebsite.fe.messages.home.realestatelist.area" />: ${realEstate.squareMeters}
                </div>
                <div>
                    <spring:message code="realestatewebsite.fe.messages.home.realestatelist.price" />: ${realEstate.price}
                </div>
            </div>
        </div>
    </c:forEach>


</div>

</body>
</html>
