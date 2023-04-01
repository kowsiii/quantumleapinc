package oop.quantumleapinc.vms.model.form.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({ "formConfig"})
public class FormConfigInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formConfigInfoId;

    @NotBlank
    @Size(max = 255)
    @Column(length=255, nullable=false, unique=false)
    private String title;

    @NotBlank
    @Size(max = 50000)
    @Column(length=50000, nullable=false, unique=false)
    private String formDesign;

    @Min(1)
    @Column(nullable=false, unique=false)
    private Integer version;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="formConfigId", nullable=false)
    private FormConfig formConfig;

    public FormConfigInfo() {
    }

    
}


