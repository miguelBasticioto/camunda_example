package com.example.camunda_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class PrintWeatherDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(PrintWeatherDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Boolean weatherOk = (Boolean) delegateExecution.getVariable("weatherOk");

        if (weatherOk) {
            LOGGER.info("O clima está bom.");
        } else {
            LOGGER.info("O clima não esta bom.");
        }

    }
}
