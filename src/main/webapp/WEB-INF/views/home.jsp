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
                <p class="header-section-secondary text-center hidden-xs hidden-xxs">with the most complete source of
                    homes for sale &amp; real estate near you</p>
            </header>
            <div class="home-search-wrapper">
                <div id="menu-wrapper" class="menu-wrapper">
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="for_sale" value="for_sale" checked="">
                        <label for="for_sale">
                            <spring:message code="realestatewebsite.fe.messages.home.menu.item.buy"/>
                        </label>
                    </div>
                    <div class="menu-item">
                        <input type="radio" name="property-status" id="for_rent" value="for_rent">
                        <label for="for_rent">
                            <spring:message code="realestatewebsite.fe.messages.home.menu.item.rent"/>
                        </label>
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

                <div>
                    <select>
                        <option>All</option>
                        <option>Sale</option>
                        <option>Rent</option>
                    </select>
                </div>

                <div>
                    <select>
                        <c:forEach items="${viewBean.realEstateTypesDropdown}" var="realEstateType">

                            <c:choose>
                                <c:when test="${realEstateType.key.equals(viewBean.selectedRealEstateType)}">
                                    <option value="${realEstateType.key}" selected="selected">${realEstateType.value}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${realEstateType.key}">${realEstateType.value}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    Price from: <input type="text" />
                </div>

                <div>
                    Price To: <input type="text" />
                </div>

                <select onchange="showSubItems(this.value)" name="location" class="large">
                    <option value="">Сите</option>

                    <option value="1">Скопје</option>
                    <option value="2">Берово</option>
                    <option value="3">Битола</option>
                    <option value="4">Дебар</option>
                    <option value="5">Делчево</option>
                    <option value="6">Демир Хисар</option>
                    <option value="33">Дојран</option>
                    <option value="7">Гевгелија</option>
                    <option value="8">Гостивар</option>
                    <option value="9">Кавадарци</option>
                    <option value="10">Кичево</option>
                    <option value="11">Кочани</option>
                    <option value="12">Кратово</option>
                    <option value="13">Крива Паланка</option>
                    <option value="14">Крушево</option>
                    <option value="15">Куманово</option>
                    <option value="32">Маврово</option>
                    <option value="16">Македонски Брод</option>
                    <option value="17">Неготино</option>
                    <option value="18">Охрид</option>
                    <option value="31">Пехчево</option>
                    <option value="19">Прилеп</option>
                    <option value="20">Пробиштип</option>
                    <option value="21">Радовиш</option>
                    <option value="22">Ресен</option>
                    <option value="23">Штип</option>
                    <option value="24">Струга</option>
                    <option value="25">Струмица</option>
                    <option value="26">Свети Николе</option>
                    <option value="27">Тетово</option>
                    <option value="28">Валандово</option>
                    <option value="29">Велес</option>
                    <option value="30">Виница</option>
                </select>

            </div>
        </div>
    </div>

</div>

<div class="main-container">

    <div class="real-estate-container">

        <div class="real-estate-list">
            <c:forEach items="${viewBean.realEstates}" var="realEstate">

                <div class="real-estate-list-item">

                    <div class="real-estate-list-item-image"> </div>

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
                        </div>

                        <div>
                            <spring:message
                                    code="realestatewebsite.fe.messages.home.realestatelist.price"/>: ${realEstate.price}
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
