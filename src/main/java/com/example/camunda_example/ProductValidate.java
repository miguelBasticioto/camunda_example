package com.example.camunda_example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class ProductValidate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(ProductValidate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String p = (String) delegateExecution.getVariable("product");

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(p, Product.class);

        LOGGER.info(product.getName() + " validado");
    }
}
