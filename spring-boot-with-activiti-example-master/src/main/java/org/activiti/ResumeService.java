package org.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ResumeService implements JavaDelegate {

    public void storeResume() {
        System.out.println("Storing resume ...");
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Storing resume for me ...");
    }
}
