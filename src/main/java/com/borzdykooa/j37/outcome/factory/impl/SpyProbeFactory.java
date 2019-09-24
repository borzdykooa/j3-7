package com.borzdykooa.j37.outcome.factory.impl;

import com.borzdykooa.j37.income.IncomeParameter;
import com.borzdykooa.j37.outcome.factory.PeaceShipFactory;
import com.borzdykooa.j37.outcome.model.Ship;
import com.borzdykooa.j37.outcome.model.SpyProbe;
import com.borzdykooa.j37.outcome.parameter.Parameter;
import com.borzdykooa.j37.outcome.parameter.impl.ScanSensor;
import com.borzdykooa.j37.outcome.parameter.impl.ScanSensorType;


public class SpyProbeFactory extends PeaceShipFactory {

    @Override
    public Ship getShip() {
        return new SpyProbe();
    }

    @Override
    public Parameter getUniqueParameter() {
        ScanSensor scanSensor = new ScanSensor();
        String result = this.getShipTemplate().getParameters().stream()
                .filter(param -> param.getScanSensor() != null)
                .map(IncomeParameter::getScanSensor)
                .findFirst().orElse(null);
        scanSensor.setScanSensor(ScanSensorType.getByValue(result));

        return scanSensor;
    }
}
