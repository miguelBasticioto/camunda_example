package com.example.camunda_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.instance.MessageEventDefinition;
import org.camunda.bpm.model.bpmn.instance.ThrowEvent;

import java.util.logging.Logger;

public class ThrowMessageDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {

        ThrowEvent messageEvent = (ThrowEvent) delegateExecution.getBpmnModelElementInstance();

        MessageEventDefinition messageEventDefinition = (MessageEventDefinition) messageEvent
            .getEventDefinitions().iterator().next();

        String receivingMessageName = messageEventDefinition.getMessage().getName();

        delegateExecution.getProcessEngineServices()
            .getRuntimeService()
            .createMessageCorrelation(receivingMessageName)
            .correlate();

    }
}
