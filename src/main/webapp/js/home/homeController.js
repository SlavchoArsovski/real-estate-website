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

});