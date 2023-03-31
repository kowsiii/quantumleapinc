package oop.quantumleapinc.vms.payload.form;

import java.time.LocalDateTime;

public class FormConfigInfoResponse {
    private Long formConfigInfoId;
    private String formDesign;
    private Integer version;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private String title;

    public Long getFormConfigInfoId() {
        return formConfigInfoId;
    }

    public void setFormConfigInfoId(Long formConfigInfoId) {
        this.formConfigInfoId = formConfigInfoId;
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
