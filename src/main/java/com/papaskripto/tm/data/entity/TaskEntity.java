package com.papaskripto.tm.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table (name = "TASKS")
@Data
public class TaskEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)

    @Column (name = "TASK_ID")
    private UUID taskId;

    @Column (name = "NAME")
    private String taskName;
}
