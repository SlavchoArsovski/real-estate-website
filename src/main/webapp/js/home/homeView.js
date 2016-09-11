var homeView = {

    pageComponents: {
        realEstateTypesDropdown: '#realEstateTypeDropdown',
        realEstateTypesDropdownSelectedOption: '#realEstateTypeDropdown option:selected',
        priceFromInput: '#price_from',
        priceToInput: '#price_to',
        cityDropdown: '#cityDropdown',
        cityDropdownSelectedOption: '#cityDropdown option:selected',
        squareMetersFromInput: '#square-meters_from',
        squareMetersToInput: '#square-meters_to'
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
    }

};