package oop.quantumleapinc.vms.payload.form;

import jakarta.validation.constraints.NotBlank;

public class FormConfigRequest {
    private Long formConfigId;
    private String randomPath;
    private Integer version;
    @NotBlank
    private String title;
    @NotBlank
    private String formDesign;

    private String status;

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

    public String getFormDesign() {
        return formDesign;
    }

    public void setFormDesign(String formDesign) {
        this.formDesign = formDesign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
