package com.sample.task.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class SearchTask {
    private String task;
    private String parentTask;
    private String startPriority;
    private String endPriority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public String getStartPriority() {
        return startPriority;
    }

    public void setStartPriority(String startPriority) {
        this.startPriority = startPriority;
    }

    public String getEndPriority() {
        return endPriority;
    }

    public void setEndPriority(String endPriority) {
        this.endPriority = endPriority;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
