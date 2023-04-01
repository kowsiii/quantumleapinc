package oop.quantumleapinc.vms.model.form.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    public Long getFormConfigInfoId() {
        return formConfigInfoId;
    }

    public void setFormConfigInfoId(Long formConfigInfoId) {
        this.formConfigInfoId = formConfigInfoId;
    }

    public FormConfig getFormConfig() {
        return formConfig;
    }

    public void setFormConfig(FormConfig formConfig) {
        this.formConfig = formConfig;
    }

    public String getFormDesign() {
        return formDesign;
    }

    public void setFormDesign(String formDesign) {
        this.formDesign = formDesign;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


