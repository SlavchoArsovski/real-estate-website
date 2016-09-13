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
        yearOfConstructionInput: '#yearOfConstruction',
        numberOfBedsInput: '#numberOfBeds',
        numberOfRoomsInput: '#numberOfRooms',
        centralHeatingDropdown: '#centralHeatingDropdown',
        centralHeatingDropdownSelectedOption: '#centralHeatingDropdown option:selected',
        airConditionedDropdown: '#airConditionedDropdown',
        airConditionedDropdownSelectedOption: '#airConditionedDropdown option:selected',
        yardIncludedDropdown: '#yardIncludedDropdown',
        yardIncludedDropdownSelectedOption: '#yardIncludedDropdown option:selected',
        garageIncludedDropdown: '#garageIncludedDropdown',
        garageIncludedDropdownSelectedOption: '#garageIncludedDropdown option:selected',
        elevatorIncludedDropdown: '#elevatorIncludedDropdown',
        elevatorIncludedDropdownSelectedOption: '#elevatorIncludedDropdown option:selected',
        poolIncludedDropdown: '#poolIncludedDropdown',
        poolIncludedDropdownSelectedOption: '#poolIncludedDropdown option:selected',
        parkingIncludedDropdown: '#parkingIncludedDropdown',
        parkingIncludedDropdownSelectedOption: '#parkingIncludedDropdown option:selected',
        realEstateList: '.real-estate-list',
        realEstateItemHtmlTemplate: '.real-estate-list-item-template'
    },

    initView: function (model) {
        this._initViewChangingEvents();
        this._initModelChangingEvents();
    },

    _initViewChangingEvents: function () {

        var inputKeyDown = function (e) {
            // Allow: backspace, delete, tab, escape, enter and .
            if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
                // Allow: Ctrl+A
                (e.keyCode == 65 && e.ctrlKey === true) ||
                // Allow: Ctrl+C
                (e.keyCode == 67 && e.ctrlKey === true) ||
                // Allow: Ctrl+X
                (e.keyCode == 88 && e.ctrlKey === true) ||
                // Allow: home, end, left, right
                (e.keyCode >= 35 && e.keyCode <= 39)) {
                // let it happen, don't do anything
                return;
            }
            // Ensure that it is a number and stop the keypress
            if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                e.preventDefault();
            }
        }

        $(this.pageComponents.numberOfBedsInput).keydown(function (e) {
            inputKeyDown(e);
        });

        $(this.pageComponents.numberOfRoomsInput).keydown(function (e) {
            inputKeyDown(e);
        });

        $(this.pageComponents.priceFromInput).keydown(function (e) {
            inputKeyDown(e);
        });

        $(this.pageComponents.priceToInput).keydown(function (e) {
            inputKeyDown(e);
        });

        $(this.pageComponents.squareMetersFromInput).keydown(function (e) {
            inputKeyDown(e);
        });

        $(this.pageComponents.squareMetersToInput).keydown(function (e) {
            inputKeyDown(e);
        });

        $(this.pageComponents.yearOfConstructionInput).keydown(function (e) {
            inputKeyDown(e);
        });
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

        $(me.pageComponents.yearOfConstructionInput).on('change', function (event) {
            $(me).trigger('yearOfConstructionChange', event.target.value);
        });

        $(me.pageComponents.numberOfBedsInput).on('change', function (event) {
            $(me).trigger('numberOfBedsChange', event.target.value);
        });

        $(me.pageComponents.numberOfRoomsInput).on('change', function (event) {
            $(me).trigger('numberOfRoomsChange', event.target.value);
        });

        $(me.pageComponents.centralHeatingDropdown).on('change', function (event) {
            $(me).trigger('centralHeatingIncludedChange', $(me.pageComponents.centralHeatingDropdownSelectedOption).val());
        });

        $(me.pageComponents.airConditionedDropdown).on('change', function (event) {
            $(me).trigger('airConditionedChange', $(me.pageComponents.airConditionedDropdownSelectedOption).val());
        });

        $(me.pageComponents.yardIncludedDropdown).on('change', function (event) {
            $(me).trigger('yardIncludedChange', $(me.pageComponents.yardIncludedDropdownSelectedOption).val());
        });

        $(me.pageComponents.garageIncludedDropdown).on('change', function (event) {
            $(me).trigger('garageIncludedChange', $(me.pageComponents.garageIncludedDropdownSelectedOption).val());
        });

        $(me.pageComponents.elevatorIncludedDropdown).on('change', function (event) {
            $(me).trigger('elevatorIncludedChange', $(me.pageComponents.elevatorIncludedDropdownSelectedOption).val());
        });

        $(me.pageComponents.poolIncludedDropdown).on('change', function (event) {
            $(me).trigger('poolIncludedChange', $(me.pageComponents.poolIncludedDropdownSelectedOption).val());
        });

        $(me.pageComponents.parkingIncludedDropdown).on('change', function (event) {
            $(me).trigger('parkingIncludedChange', $(me.pageComponents.parkingIncludedDropdownSelectedOption).val());
        });

    },

    updateView: function (model) {

        this._updateSearchProperties(model.validProperties);
        this._updateRealEstateType(model.selectedRealEstateType);
        this._updatePriceFrom(model.priceFrom);
        this._updatePriceTo(model.priceTo);
        this._updateCity(model.selectedCity);
        this._updateSquareMetersFrom(model.squareMetersFrom);
        this._updateSquareMetersTo(model.squareMetersTo);
        this._updateYearOfConstruction(model.yearOfConstruction);
        this._updateNumberOfBeds(model.numberOfBeds);
        this._updateCentralHeating(model.selectedCentralHeating);
        this._updateAirConditioning(model.selectedAirConditioned);
        this._updateGarageIncluded(model.selectedGarageIncluded);
        this._updateElevatorIncluded(model.selectedElevatorIncluded);
        this._updateParkingIncluded(model.selectedParkingIncluded);
        this._updatePoolIncluded(model.selectedPoolIncluded);
        this._updateNumberOfRooms(model.numberOfRooms);
        this._updateRealEstates(model.realEstates, model.messages);
    },

    _updateSearchProperties: function (validProperties) {

        if ($.inArray('YEAR_OF_CONSTRUCTION', validProperties) > -1) {
            $(this.pageComponents.yearOfConstructionInput).removeAttr('disabled');
        } else {
            $(this.pageComponents.yearOfConstructionInput).attr('disabled', 'disabled');
        }

        if ($.inArray('NUMBER_OF_ROOMS', validProperties) > -1) {
            $(this.pageComponents.numberOfRoomsInput).removeAttr('disabled');
        } else {
            $(this.pageComponents.numberOfRoomsInput).attr('disabled', 'disabled');
        }

        if ($.inArray('NUMBER_OF_BEDS', validProperties) > -1) {
            $(this.pageComponents.numberOfBedsInput).removeAttr('disabled');
        } else {
            $(this.pageComponents.numberOfBedsInput).attr('disabled', 'disabled');
        }

        if ($.inArray('CENTRAL_HEATING_INCLUDED', validProperties) > -1) {
            $(this.pageComponents.centralHeatingDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.centralHeatingDropdown).attr('disabled', 'disabled');
        }

        if ($.inArray('AIR_CONDITIONED', validProperties) > -1) {
            $(this.pageComponents.airConditionedDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.airConditionedDropdown).attr('disabled', 'disabled');
        }

        if ($.inArray('YARD_INCLUDED', validProperties) > -1) {
            $(this.pageComponents.yardIncludedDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.yardIncludedDropdown).attr('disabled', 'disabled');
        }

        if ($.inArray('GARAGE_INCLUDED', validProperties) > -1) {
            $(this.pageComponents.garageIncludedDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.garageIncludedDropdown).attr('disabled', 'disabled');
        }

        if ($.inArray('ELEVATOR_INCLUDED', validProperties) > -1) {
            $(this.pageComponents.elevatorIncludedDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.elevatorIncludedDropdown).attr('disabled', 'disabled');
        }

        if ($.inArray('POOL_INCLUDED', validProperties) > -1) {
            $(this.pageComponents.poolIncludedDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.poolIncludedDropdown).attr('disabled', 'disabled');
        }

        if ($.inArray('PARKING_INCLUDED', validProperties) > -1) {
            $(this.pageComponents.parkingIncludedDropdown).removeAttr('disabled');
        } else {
            $(this.pageComponents.parkingIncludedDropdown).attr('disabled', 'disabled');
        }

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

    _updateYearOfConstruction: function (yearOfConstruction) {
        $(this.pageComponents.yearOfConstructionInput).val(yearOfConstruction);
    },

    _updateNumberOfBeds: function (numberOfBeds) {
        $(this.pageComponents.numberOfBedsInput).val(numberOfBeds);
    },

    _updateNumberOfRooms: function (numberOfRooms) {
        $(this.pageComponents.numberOfRoomsInput).val(numberOfRooms);
    },

    _updateCentralHeating: function (selectedCentralHeating) {
        $(this.pageComponents.centralHeatingDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.centralHeatingDropdown + ' option[value="' + selectedCentralHeating + '"]').attr('selected', 'selected');
    },

    _updateAirConditioning: function (selectedAirConditioning) {
        $(this.pageComponents.airConditionedDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.airConditionedDropdown + ' option[value="' + selectedAirConditioning + '"]').attr('selected', 'selected');
    },

    _updateYardIncluded: function (selectedYardIncluded) {
        $(this.pageComponents.yardIncludedDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.yardIncludedDropdown + ' option[value="' + selectedYardIncluded + '"]').attr('selected', 'selected');
    },

    _updateGarageIncluded: function (selectedGarageIncluded) {
        $(this.pageComponents.garageIncludedDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.garageIncludedDropdown + ' option[value="' + selectedGarageIncluded + '"]').attr('selected', 'selected');
    },

    _updateElevatorIncluded: function (selectedElevatorIncluded) {
        $(this.pageComponents.elevatorIncludedDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.elevatorIncludedDropdown + ' option[value="' + selectedElevatorIncluded + '"]').attr('selected', 'selected');
    },

    _updatePoolIncluded: function (selectedPoolIncluded) {
        $(this.pageComponents.poolIncludedDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.poolIncludedDropdown + ' option[value="' + selectedPoolIncluded + '"]').attr('selected', 'selected');
    },

    _updateParkingIncluded: function (selectedParkingIncluded) {
        $(this.pageComponents.parkingIncludedDropdownSelectedOption).removeAttr('selected');
        $(this.pageComponents.parkingIncludedDropdown + ' option[value="' + selectedParkingIncluded + '"]').attr('selected', 'selected');
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