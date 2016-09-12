var homeView = {

    pageComponents: {
        realEstateTypesDropdown: '#realEstateTypeDropdown',
        realEstateTypesDropdownSelectedOption: '#realEstateTypeDropdown option:selected',
        priceFromInput: '#price_from',
        priceToInput: '#price_to',
        cityDropdown: '#cityDropdown',
        cityDropdownSelectedOption: '#cityDropdown option:selected',
        squareMetersFromInput: '#square-meters_from',
        squareMetersToInput: '#square-meters_to',
        realEstateList: '.real-estate-list',
        realEstateItemHtmlTemplate: '.real-estate-list-item-template'
    },

    initView: function (model) {
        this._initViewChangingEvents();
        this._initModelChangingEvents();
    },

    _initViewChangingEvents: function () {

    },

    _initModelChangingEvents: function () {
        var me = this;

        $(me.pageComponents.realEstateTypesDropdown).on('change', function (event) {
            $(me).trigger('realEstateTypeChange', $(me.pageComponents.realEstateTypesDropdownSelectedOption).val());
        });

        $(me.pageComponents.priceFromInput).on('change', function (event) {
            $(me).trigger('priceFromChange', event.target.value);
        });

        $(me.pageComponents.priceToInput).on('change', function (event) {
            $(me).trigger('priceToChange', event.target.value);
        });

        $(me.pageComponents.cityDropdown).on('change', function (event) {
            $(me).trigger('cityChange', $(me.pageComponents.cityDropdownSelectedOption).val());
        });

        $(me.pageComponents.squareMetersFromInput).on('change', function (event) {
            $(me).trigger('squareMetersFromChange', event.target.value);
        });

        $(me.pageComponents.squareMetersToInput).on('change', function (event) {
            $(me).trigger('squareMetersToChange', event.target.value);
        });

    },

    updateView: function (model) {

        this._updateRealEstateType(model.selectedRealEstateType);
        this._updatePriceFrom(model.priceFrom);
        this._updatePriceTo(model.priceTo);
        this._updateCity(model.selectedCity);
        this._updateSquareMetersFrom(model.squareMetersFrom);
        this._updateSquareMetersTo(model.squareMetersTo);
        this._updateRealEstates(model.realEstates, model.messages);
    },

    _updateRealEstateType: function (selectedRealEstateType) {

        $(this.pageComponents.realEstateTypesDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.realEstateTypesDropdown + ' option[value="' + selectedRealEstateType + '"]').attr('selected', 'selected');
    },

    _updateCity: function (selectedCity) {


        $(this.pageComponents.cityDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.cityDropdown + ' option[value="' + selectedCity + '"]').attr('selected', 'selected');

    },

    _updatePriceFrom: function (priceFrom) {
        $(this.pageComponents.priceFromInput).val(priceFrom);
    },

    _updatePriceTo: function (priceTo) {
        $(this.pageComponents.priceToInput).val(priceTo);
    },

    _updateSquareMetersFrom: function (squareMetersFrom) {
        $(this.pageComponents.squareMetersFromInput).val(squareMetersFrom);
    },

    _updateSquareMetersTo: function (squareMetersTo) {
        $(this.pageComponents.squareMetersToInput).val(squareMetersTo);
    },

    _updateRealEstates: function (realEstates, messages) {

        var me = this;

        $(me.pageComponents.realEstateList).html('');

        $.each(realEstates, function (index, realEstate) {

            var templateHtml = $(me.pageComponents.realEstateItemHtmlTemplate).html();

            templateHtml = templateHtml.replace('{realEstateItemTemplate.address}', realEstate.address);
            templateHtml = templateHtml.replace('{realEstateItemTemplate.city}', realEstate.city);
            templateHtml = templateHtml.replace('{realEstateItemTemplate.price}', realEstate.price);
            templateHtml = templateHtml.replace('{realEstateItemTemplate.region}', realEstate.region);
            templateHtml = templateHtml.replace('{realEstateItemTemplate.squareMeters}', realEstate.squareMeters);
            templateHtml = templateHtml.replace('{realEstateItemTemplate.phone}', '070 882-031');
            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messageRealEstateType}',
                messages['realestatewebsite.fe.messages.general.realEstateType.' + realEstate.realEstateType]
            );
            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messageAt}',
                messages['realestatewebsite.fe.messages.home.realestatelist.realEstateType.atPlace']
            );
            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messageArea}',
                messages['realestatewebsite.fe.messages.home.realestatelist.area']
            );

            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messageArea}',
                messages['realestatewebsite.fe.messages.home.realestatelist.price']
            );
            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messagePrice}',
                messages['realestatewebsite.fe.messages.home.realestatelist.price']
            );
            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messageCurrency}',
                messages['realestatewebsite.fe.messages.home.realestatelist.currency']
            );
            templateHtml = templateHtml.replace(
                '{realEstateItemTemplate.messagePhone}',
                messages['realestatewebsite.fe.messages.home.realestatelist.phone']
            );

            $(me.pageComponents.realEstateList).append(templateHtml);
        });

    }

};