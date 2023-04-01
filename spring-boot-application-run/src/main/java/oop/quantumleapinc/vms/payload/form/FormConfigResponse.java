package oop.quantumleapinc.vms.payload.form;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class FormConfigResponse {

    private Long formConfigId;
    private String randomPath;
    private Integer version;
    private String active;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private Set<FormConfigInfoResponse> formConfigInfoResponseSet = new HashSet<>();

    public FormConfigResponse() {
    }

    public FormConfigResponse(String randomPath) {
        this.randomPath = randomPath;
    }

    public Long getFormConfigId() {
        return formConfigId;
    }

    public void setFormConfigId(Long formConfigId) {
        this.formConfigId = formConfigId;
    }

    public String getRandomPath() {
        return randomPath;
    }

    public void setRandomPath(String randomPath) {
        this.randomPath = randomPath;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Boolean getActiveStatus() {
        return active.equalsIgnoreCase("Y") ? Boolean.TRUE : Boolean.FALSE;
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

    public Set<FormConfigInfoResponse> getFormConfigInfoSet() {
        return formConfigInfoResponseSet;
    }

    public void setFormConfigInfoSet(Set<FormConfigInfoResponse> formConfigInfoResponseSet) {
        this.formConfigInfoResponseSet = formConfigInfoResponseSet;
    }
}
