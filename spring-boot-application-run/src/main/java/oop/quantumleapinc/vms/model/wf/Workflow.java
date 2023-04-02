package oop.quantumleapinc.vms.model.wf;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import oop.quantumleapinc.vms.model.form.config.FormConfigInfo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "workflow")
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wfId;

    @NotBlank
    @Size(max = 255)
    @Column(nullable=false, unique=false)
    private String name;

    @NotBlank
    @Size(max = 500)
    @Column(length=500, nullable=true, unique=false)
    private String description;

    @NotBlank
    @Size(max = 1)
    @Column(length=1, nullable=false, unique=false)
    private String active;

    @NotBlank
    @Size(max = 255)
    @Column(length=255, nullable=false, unique=false)
    private String createdBy;

    @Column(columnDefinition = "TIMESTAMP", nullable=false, unique=false)
    private LocalDateTime createdDate;

    @NotBlank
    @Size(max = 255)
    @Column(length=255, nullable=false, unique=false)
    private String modifiedBy;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, unique=false)
    private LocalDateTime modifiedDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="workflow", cascade = CascadeType.PERSIST)
    private Set<WorkflowStep> workflowStepSet = new HashSet<>();

    public Workflow() {
    }



}
