package com.sample.task.dao;


import com.sample.task.domain.SearchTask;
import com.sample.task.domain.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskMgrDao {

    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void addTask(Task task){

        em.merge(task);
    }

    @Transactional
    public void updateTask(Task task) {

        em.merge(task);
    }

    @Transactional
    public void deleteTask(String taskName){
        Task task=viewTask(taskName);
        em.remove(task);
    }

    @Transactional
    public List<Task> listTask(SearchTask searchTask){
        String queryString= "from Task a";
        Map<String,Object> queryMap=new HashMap<>();
        System.out.println("parent task "+searchTask.getParentTask());

        if (!StringUtils.isEmpty(searchTask.getParentTask())){
            queryString =queryString + " join a.parentTaskEntity b  where b.task=:parentTask";
            queryMap.put("parentTask",searchTask.getParentTask());
        }

        if(!StringUtils.isEmpty(searchTask.getTask())){
            queryString=appendQuery(queryString,"a.task=:task");
            queryMap.put("task",searchTask.getTask());
        }

        if(!StringUtils.isEmpty(searchTask.getStartPriority())){
            queryString=appendQuery(queryString,"priority>=:startPriority");
            queryMap.put("startPriority",searchTask.getStartPriority());
        }

        if(!StringUtils.isEmpty(searchTask.getEndPriority())){
            queryString=appendQuery(queryString,"priority<=:endPriority");
            queryMap.put("endPriority",searchTask.getEndPriority());
        }
        if(searchTask.getStartDate() != null){
            queryString=appendQuery(queryString,"startDate>=:startDate");
            queryMap.put("startDate",searchTask.getStartDate());
        }

        if(searchTask.getEndDate() != null){
            queryString=appendQuery(queryString,"endDate<=:endDate");
            queryMap.put("endDate",searchTask.getEndDate());
        }

        Query query= em.createQuery(queryString);
        for (Map.Entry<String,Object> entryParam: queryMap.entrySet()){
            query.setParameter(entryParam.getKey(),entryParam.getValue());
        }
        List<Task> queryResult=query.getResultList();

       return queryResult;

    }

    private String appendQuery(String queryString,String appendQuery) {
        if (queryString.contains("where")){
            queryString=queryString + " and " + appendQuery;
        }
        else {
            queryString=queryString + " where " + appendQuery;
        }
        return queryString;

    }

    @Transactional
    public Task viewTask(String task) {
        List<Task> queryResult=null;
        Query query= em.createQuery("from Task where task = :task");
        query.setParameter("task",task);
        queryResult =query.getResultList();
        if (queryResult.size() >0){
            return queryResult.get(0);
        }
        return null;
    }
}

