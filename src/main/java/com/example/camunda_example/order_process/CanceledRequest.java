package com.example.camunda_example.order_process;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CanceledRequest implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        Boolean canceled = (Boolean) delegateExecution.getVariable("productAvailable");

        if (canceled) throw new BpmnError("task_failed_code", "User Task failed!");
    }
}
