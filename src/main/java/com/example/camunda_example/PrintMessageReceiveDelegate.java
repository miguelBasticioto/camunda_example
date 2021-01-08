package com.example.camunda_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class PrintMessageReceiveDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(PrintMessageReceiveDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) {
        LOGGER.info(delegateExecution.getVariable("test").toString());

        LOGGER.info("Evento capturado");

    }
}
