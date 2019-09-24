package com.borzdykooa.j37.outcome.model;

import com.borzdykooa.j37.outcome.parameter.Parameter;

public class Transport extends Ship {

    public static class Builder {

        private Parameter armor;
        private Parameter fuel;
        private Parameter fuelType;
        private Parameter name;
        private Parameter typeParameter;
        private Parameter uniqueParameter;

        public Builder setArmor(Parameter armor) {
            this.armor = armor;

            return this;
        }

        public Builder setFuel(Parameter fuel) {
            this.fuel = fuel;

            return this;
        }

        public Builder setFuelType(Parameter fuelType) {
            this.fuelType = fuelType;

            return this;
        }

        public Builder setName(Parameter name) {
            this.name = name;

            return this;
        }

        public Builder setTypeParameter(Parameter typeParameter) {
            this.typeParameter = typeParameter;

            return this;
        }

        public Builder setUniqueParameter(Parameter uniqueParameter) {
            this.uniqueParameter = uniqueParameter;

            return this;
        }

        public Transport build() {
            Transport transport = new Transport();
            transport.setArmor(armor);
            transport.setFuel(fuel);
            transport.setFuelType(fuelType);
            transport.setName(name);
            transport.setTypeParameter(typeParameter);
            transport.setUniqueParameter(uniqueParameter);
            return transport;
        }
    }
}
