package oop.quantumleapinc.vms.model.wf;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import oop.quantumleapinc.vms.model.form.config.FormConfig;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "workflow_step")
public class WorkflowStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wfStepId;

    @NotBlank
    @Size(max = 255)
    @Column(nullable=false, unique=false)
    private String label;

    @NotBlank
    @Size(max = 1000)
    @Column(length=1000, nullable=false, unique=false)
    private String inputs;

    @NotBlank
    @Size(max = 1000)
    @Column(length=1000, nullable=false, unique=false)
    private String outputs;

    @NotBlank
    @Column(nullable=false, unique=false)
    private Integer position_x;

    @NotBlank
    @Column(nullable=false, unique=false)
    private Integer position_y;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wfId", nullable=false)
    private Workflow workflow;

}
