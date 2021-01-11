package com.example.camunda_example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.List;

public class StartProductsProcessDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String products = "[{\"id\": 1, \"name\": \"Produto 1\"}, {\"id\": 2, \"name\": \"Produto 2\"}, {\"id\": 3, \"name\": \"Produto 3\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> productList = objectMapper.readValue(products, new TypeReference<List<Product>>() {
        });

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        productList.forEach(product -> {
            try {
                runtimeService
                    .createProcessInstanceByKey("productValidate")
                    .setVariable("product", objectMapper.writeValueAsString(product))
                    .execute();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

    }
}
