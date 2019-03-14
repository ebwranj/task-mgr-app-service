package com.sample.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ParentTask")

public class ParentTask {
    @Id
@Column(name = "PARENT_TASK_ID")
    private Integer id;
@Column(name = "PARENT_TASK")
    private String task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
