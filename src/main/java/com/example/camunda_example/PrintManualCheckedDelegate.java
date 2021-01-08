package com.example.camunda_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class PrintManualCheckedDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(PrintManualCheckedDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("A tarefa foi concluída manualmente.");
    }
}
