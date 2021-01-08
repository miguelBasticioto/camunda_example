package com.example.camunda_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class PrintComplaintDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(PrintComplaintDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Infelizmente o clima ta ruim.");
    }
}
