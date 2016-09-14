var homeModel = {

    _getParameterByName: function (name, url) {
        if (!url) {
            url = window.location.href;
        }
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);

        if (!results) {
            return undefined;
        }
        if (!results[2]) {
            return '';
        }

        return decodeURIComponent(results[2].replace(/\+/g, " "));
    },

    init: function (afterInit) {
        var url = 'http://localhost:8080/real-estate-website/home/propertyChanged';
        var self = this;

        var data = {};
        var advertisementType = self._getParameterByName('advertisementType');

        if (!advertisementType) {
            advertisementType = 'SALE';
        }

        data['advertisementType'] = advertisementType;

        $.ajax({
            dataType: "json",
            type: 'GET',
            url: url,
            cache: false,
            data: data,
            success: function (response) {
                self.update(response, true);
                if (afterInit) {
                    afterInit();
                }
            }
        });
    },

    _propertyChange: function (key, value) {
        var url = 'http://localhost:8080/real-estate-website/home/propertyChanged';
        var data = {};
        var self = this;

        data['selectedRealEstateType'] = this.selectedRealEstateType;
        data['selectedCity'] = this.selectedCity;
        data['priceFrom'] = this.priceFrom;
        data['priceTo'] = this.priceTo;
        data['squareMetersFrom'] = this.squareMetersFrom;
        data['squareMetersTo'] = this.squareMetersTo;
        data['yearOfConstruction'] = this.yearOfConstruction;
        data['selectedCentralHeating'] = this.selectedCentralHeating;
        data['selectedAirConditioned'] = this.selectedAirConditioned;
        data['selectedYardIncluded'] = this.selectedYardIncluded;
        data['selectedGarageIncluded'] = this.selectedGarageIncluded;
        data['selectedElevatorIncluded'] = this.selectedElevatorIncluded;
        data['numberOfRooms'] = this.numberOfRooms;
        data['numberOfBeds'] = this.numberOfBeds;
        data['selectedParkingIncluded'] = this.selectedParkingIncluded;
        data['selectedPoolIncluded'] = this.selectedPoolIncluded;
        data['advertisementType'] = this.advertisementType;

        data[key] = value;
        data['changedProperty'] = key;

        $.ajax({
            url: url,
            type: "POST",
            data: data,
            success: function (response) {
                var newModel = response;
                self.update(newModel);
            }
        });
    },

    update: function (newModel, noTrigger) {
        for (var key in newModel) {
            //copy all the fields
            this[key] = newModel[key];
        }

        if (noTrigger) {
            return;
        }
        $(this).trigger('modelchanged');
    },

    changeRealEstateType: function (realEstateType) {
        this._propertyChange('selectedRealEstateType', realEstateType);
    },

    changeCity: function (city) {
        this._propertyChange('selectedCity', city);
    },

    changePriceFrom: function (priceFrom) {
        this._propertyChange('priceFrom', priceFrom);
    },

    changePriceTo: function (priceTo) {
        this._propertyChange('priceTo', priceTo);
    },

    changeSquareMetersFrom: function (squareMetersFrom) {
        this._propertyChange('squareMetersFrom', squareMetersFrom);
    },

    changeSquareMetersTo: function (squareMetersTo) {
        this._propertyChange('squareMetersTo', squareMetersTo);
    },

    changeYearOfConstruction: function (yearOfConstruction) {
        this._propertyChange('yearOfConstruction', yearOfConstruction);
    },

    changeCentralHeatingIncluded: function (centralHeatingIncluded) {
        this._propertyChange('selectedCentralHeating', centralHeatingIncluded);
    },

    changeAirConditioned: function (airConditioned) {
        this._propertyChange('selectedAirConditioned', airConditioned);
    },

    changeYardIncluded: function (yardIncluded) {
        this._propertyChange('selectedYardIncluded', yardIncluded);
    },

    changeGarageIncluded: function (garageIncluded) {
        this._propertyChange('selectedGarageIncluded', garageIncluded);
    },

    changeElevatorIncluded: function (elevatorIncluded) {
        this._propertyChange('selectedElevatorIncluded', elevatorIncluded);
    },


    changeNumberOfRooms: function (numberOfRooms) {
        this._propertyChange('numberOfRooms', numberOfRooms);
    },

    changeNumberOfBeds: function (numberOfBeds) {
        this._propertyChange('numberOfBeds', numberOfBeds);
    },

    changePoolIncluded: function (poolIncluded) {
        this._propertyChange('selectedPoolIncluded', poolIncluded);
    },

    changeParkingIncluded: function (parkingIncluded) {
        this._propertyChange('selectedParkingIncluded', parkingIncluded);
    },

    getModelForView: function () {
        return {
            selectedRealEstateType: this.selectedRealEstateType,
            selectedCity: this.selectedCity,
            priceFrom: this.priceFrom,
            priceTo: this.priceTo,
            squareMetersFrom: this.squareMetersFrom,
            squareMetersTo: this.squareMetersTo,
            yearOfConstruction: this.yearOfConstruction,
            selectedCentralHeating: this.selectedCentralHeating,
            selectedAirConditioned: this.selectedAirConditioned,
            selectedYardIncluded: this.selectedYardIncluded,
            selectedGarageIncluded: this.selectedGarageIncluded,
            selectedElevatorIncluded: this.selectedElevatorIncluded,
            numberOfRooms: this.numberOfRooms,
            numberOfBeds: this.numberOfBeds,
            selectedPoolIncluded: this.selectedPoolIncluded,
            selectedParkingIncluded: this.selectedParkingIncluded,
            validProperties: this.validProperties,
            realEstates: this.realEstates,
            advertisementType: this.advertisementType,
            messages: this.messages
        };
    }
};