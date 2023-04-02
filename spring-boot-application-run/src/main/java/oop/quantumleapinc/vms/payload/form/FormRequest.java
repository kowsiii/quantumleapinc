package oop.quantumleapinc.vms.payload.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class FormRequest implements Serializable {

    private Long formId;
    private Long formConfigId;
    private Long formConfigInfoId;

    @Size(max = 50000)
    private String formData;

    @Size(max = 50000)
    private String assignees;

    @NotBlank
    @Size(max = 255)
    private String path;

    @NotBlank
    @Size(max = 50)
    private String status;

    @NotBlank
    @Size(max = 255)
    private String username;

    public FormRequest() {
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

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

    public String getAssignees() {
        return assignees;
    }

    public void setAssignees(String assignees) {
        this.assignees = assignees;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
