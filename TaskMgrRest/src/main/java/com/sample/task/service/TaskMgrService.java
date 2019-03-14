package com.sample.task.service;

import com.sample.task.dao.TaskMgrDao;
import com.sample.task.domain.ParentTask;
import com.sample.task.domain.SearchTask;
import com.sample.task.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskMgrService {
    @Autowired
    TaskMgrDao taskMgrDao;


    @Transactional
    public void addTask(Task task) {
        System.out.println("task mgr add service");
        if (task.getParentTask() != null){
            Task parentTaskref=taskMgrDao.viewTask(task.getParentTask());
            ParentTask parentTask =new ParentTask();
            System.out.println("add task");
            System.out.println(parentTaskref.getId());
            parentTask.setTask(task.getParentTask());
            parentTask.setId(parentTaskref.getId());
            task.setParentTaskEntity(parentTask);
        }
        taskMgrDao.addTask(task);
    }

    @Transactional
    public void updateTask(Task task) {
        Task viewTask =taskMgrDao.viewTask(task.getTask());
        if (viewTask != null){
            task.setId(viewTask.getId());
            if (task.getParentTask() != null){
                System.out.println("update task");
                Task parentTaskref=taskMgrDao.viewTask(task.getParentTask());
                ParentTask parentTask =new ParentTask();
                parentTask.setTask(task.getParentTask());
                parentTask.setId(parentTaskref.getId());
                task.setParentTaskEntity(parentTask);
            }

            taskMgrDao.updateTask(task);
        }
    }

    @Transactional
    public void deleteTask(String task){

        taskMgrDao.deleteTask(task);
    }


    @Transactional
    public Task viewTask(String task){
        return taskMgrDao.viewTask(task);
    }

    @Transactional
    public List<Task> listTask(SearchTask searchTask){
        return taskMgrDao.listTask(searchTask);
    }
}
