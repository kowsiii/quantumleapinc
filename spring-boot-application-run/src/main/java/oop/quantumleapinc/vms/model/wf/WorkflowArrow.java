package oop.quantumleapinc.vms.model.wf;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workflow_arrow")
public class WorkflowArrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wfArrowId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wfId", nullable=false)
    private Workflow workflow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wfFromStepId", nullable=false)
    private WorkflowStep workflowFromStep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wfToStepId", nullable=false)
    private WorkflowStep workflowToStep;

}
