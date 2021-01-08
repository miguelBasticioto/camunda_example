package com.example.camunda_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;
import java.util.logging.Logger;

public class CheckWeatherDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(PrintComplaintDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Random rnd = new Random();

        Boolean weatherOk = rnd.nextBoolean();

        LOGGER.info(weatherOk.toString());

        delegateExecution.setVariable("name", "Miguel");
        delegateExecution.setVariable("weatherOk", weatherOk);
    }
}
