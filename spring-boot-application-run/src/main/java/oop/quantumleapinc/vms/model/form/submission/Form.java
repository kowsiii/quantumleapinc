package oop.quantumleapinc.vms.model.form.submission;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "form", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"path", "username"})
})

public class Form implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;

    @NotBlank
    @Size(max = 50000)
    @Column(length=50000, nullable=false, unique=false)
    private String formData;

    @NotBlank
    @Size(max = 255)
    @Column(length=255, nullable=false, unique=false)
    private String path;

    @NotBlank
    @Size(max = 50)
    @Column(length=50, nullable=false, unique=false)
    private String status;

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

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="formConfigId", nullable=false)
//    private FormConfig formConfig;

    @Column(nullable = false)
    private Long formConfigId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="formConfigInfoId", nullable=false)
//    private FormConfigInfo formConfigInfo;
    @Column(nullable = false)
    private Long formConfigInfoId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="username", referencedColumnName="username", nullable=false)
//    private User user;
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String username;

    public Form() {
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

//    public FormConfig getFormConfig() {
//        return formConfig;
//    }
//
//    public void setFormConfig(FormConfig formConfig) {
//        this.formConfig = formConfig;
//    }

//    public FormConfigInfo getFormConfigInfo() {
//        return formConfigInfo;
//    }
//
//    public void setFormConfigInfo(FormConfigInfo formConfigInfo) {
//        this.formConfigInfo = formConfigInfo;
//    }


    public Long getFormConfigId() {
        return formConfigId;
    }

    public void setFormConfigId(Long formConfigId) {
        this.formConfigId = formConfigId;
    }

    public Long getFormConfigInfoId() {
        return formConfigInfoId;
    }

    public void setFormConfigInfoId(Long formConfigInfoId) {
        this.formConfigInfoId = formConfigInfoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
