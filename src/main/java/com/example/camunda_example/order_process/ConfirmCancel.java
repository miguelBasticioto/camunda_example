package com.example.camunda_example.order_process;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class ConfirmCancel implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(ConfirmCancel.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String productId = (String) delegateExecution.getVariable("productId");
        LOGGER.info("Produto de id: " + productId + " não disponível.");
    }
}
