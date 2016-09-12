$(document).ready(function () {

    homeModel.init(function () {
        homeView.initView(homeModel.getModelForView());
        homeView.updateView(homeModel.getModelForView());
    });


    $(homeModel).on('modelchanged', function () {
        homeView.updateView(homeModel.getModelForView());
    });

    $(homeView).on('realEstateTypeChange', function (event, realEstateType) {
        homeModel.changeRealEstateType(realEstateType);
    });

    $(homeView).on('cityChange', function (event, city) {
        homeModel.changeCity(city);
    });

    $(homeView).on('priceFromChange', function (event, priceFrom) {
        homeModel.changePriceFrom(priceFrom);
    });

    $(homeView).on('priceToChange', function (event, priceTo) {
        homeModel.changePriceTo(priceTo);
    });

    $(homeView).on('squareMetersFromChange', function (event, priceFrom) {
        homeModel.changeSquareMetersFrom(priceFrom);
    });

    $(homeView).on('squareMetersToChange', function (event, priceTo) {
        homeModel.changeSquareMetersTo(priceTo);
    });

    $(homeView).on('yearOfConstructionChange', function (event, yearOfConstruction) {
        homeModel.changeYearOfConstruction(yearOfConstruction);
    });

    $(homeView).on('centralHeatingIncludedChange', function (event, centralHeatingIncluded) {
        homeModel.changeCentralHeatingIncluded(centralHeatingIncluded);
    });

    $(homeView).on('airConditionedChange', function (event, airConditioned) {
        homeModel.changeAirConditioned(airConditioned);
    });

    $(homeView).on('yardIncludedChange', function (event, yardIncluded) {
        homeModel.changeYardIncluded(yardIncluded);
    });

    $(homeView).on('garageIncludedChange', function (event, garageIncluded) {
        homeModel.changeGarageIncluded(garageIncluded);
    });

    $(homeView).on('elevatorIncludedChange', function (event, elevatorIncluded) {
        homeModel.changeElevatorIncluded(elevatorIncluded);
    });

    $(homeView).on('numberOfBedsChange', function (event, numberOfBeds) {
        homeModel.changeNumberOfBeds(numberOfBeds);
    });

    $(homeView).on('numberOfRoomsChange', function (event, numberOfRooms) {
        homeModel.changeNumberOfRooms(numberOfRooms);
    });


    $(homeView).on('poolIncludedChange', function (event, poolIncluded) {
        homeModel.changePoolIncluded(poolIncluded);
    });

    $(homeView).on('parkingIncludedChange', function (event, parkingIncluded) {
        homeModel.changeParkingIncluded(parkingIncluded);
    });


});