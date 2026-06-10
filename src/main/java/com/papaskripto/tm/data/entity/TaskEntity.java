package com.papaskripto.tm.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table (name = "TASKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)

    @Column (name = "TASK_ID")
    private UUID taskId;

    @Column (name = "NAME")
    private String taskName;
}
