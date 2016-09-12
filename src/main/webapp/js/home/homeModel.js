var homeModel = {

    init: function (afterInit) {
        var url = 'http://localhost:8080/real-estate-website/home/propertyChanged';
        var self = this;
        $.ajax({
            dataType: "json",
            type: 'GET',
            url: url,
            cache: false,
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
        data['centralHeatingIncluded'] = this.centralHeatingIncluded;
        data['airConditioned'] = this.airConditioned;
        data['yardIncluded'] = this.yardIncluded;
        data['garageIncluded'] = this.garageIncluded;
        data['elevatorIncluded'] = this.elevatorIncluded;
        data['numberOfFloors'] = this.numberOfFloors;
        data['numberOfBeds'] = this.numberOfBeds;
        data['numberOfOffices'] = this.numberOfOffices;
        data['parkingIncluded'] = this.parkingIncluded;

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
        this._propertyChange('centralHeatingIncluded', centralHeatingIncluded);
    },

    changeAirConditioned: function (airConditioned) {
        this._propertyChange('airConditioned', airConditioned);
    },

    changeYardIncluded: function (yardIncluded) {
        this._propertyChange('yardIncluded', yardIncluded);
    },

    changeGarageIncluded: function (garageIncluded) {
        this._propertyChange('garageIncluded', garageIncluded);
    },

    changeElevatorIncluded: function (elevatorIncluded) {
        this._propertyChange('elevatorIncluded', elevatorIncluded);
    },

    changeNumberOfFloors: function (numberOfFloors) {
        this._propertyChange('numberOfFloors', numberOfFloors);
    },

    changeNumberOfBeds: function (numberOfBeds) {
        this._propertyChange('numberOfBeds', numberOfBeds);
    },

    changeNumberOfOffices: function (numberOfOffices) {
        this._propertyChange('numberOfOffices', numberOfOffices);
    },

    changeParkingIncluded: function (parkingIncluded) {
        this._propertyChange('parkingIncluded', parkingIncluded);
    },

    getModelForView: function () {
        return {
            selectedRealEstateType: this.selectedRealEstateType,
            selectedCity: this.selectedCity,
            priceFrom: this.priceFrom,
            priceTo: this.priceTo,
            squareMetersFrom: this.squareMetersFrom,
            squareMetersTo: this.squareMetersTo,
            realEstates: this.realEstates,
            yearOfConstruction: this.yearOfConstruction,
            centralHeatingIncluded: this.centralHeatingIncluded,
            airConditioned: this.airConditioned,
            yardIncluded: this.yardIncluded,
            garageIncluded: this.garageIncluded,
            elevatorIncluded: this.elevatorIncluded,
            numberOfFloors: this.numberOfFloors,
            numberOfBeds: this.numberOfBeds,
            numberOfOffices: this.numberOfOffices,
            parkingIncluded: this.parkingIncluded,
            messages: this.messages
        };
    }
};