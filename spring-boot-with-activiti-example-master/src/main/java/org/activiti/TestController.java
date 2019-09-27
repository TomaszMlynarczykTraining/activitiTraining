package org.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ApplicantRepository applicantRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/completeTask", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void startHireProcess() {

        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        list.forEach(i->System.out.println(i.getProcessDefinitionKey()));


        List<Task> tasks = taskService.createTaskQuery().list();

        tasks.forEach(t->t.setAssignee("me"));
    }


}
