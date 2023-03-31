package oop.quantumleapinc.vms.model.form.config;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form_config")
public class FormConfig  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formConfigId;

    @NotBlank
    @Size(max = 255)
    @Column(length=255, nullable=false, unique=true)
    private String randomPath;

    @Min(1)
    @Column(nullable=false, unique=false)
    private Integer version;

    @NotBlank
    @Size(min = 1, max = 1)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy="formConfig", cascade = CascadeType.PERSIST)
    @OrderBy("version")
    private Set<FormConfigInfo> formConfigInfoSet = new HashSet<>();

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumns(
//            {
//                    @JoinColumn(nullable=false, updatable=false,insertable=false, name="formConfigId", referencedColumnName="formConfigId"),
//                    @JoinColumn(nullable=false, updatable=false,insertable=false, name="version", referencedColumnName="version"),
//            }
//    )
//    private FormConfigInfo activeFormConfigInfo;

    public FormConfig() {
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

    public Set<FormConfigInfo> getFormConfigInfoSet() {
        return formConfigInfoSet;
    }

    public void setFormConfigInfoSet(Set<FormConfigInfo> formConfigInfoSet) {
        this.formConfigInfoSet = formConfigInfoSet;
    }

    public FormConfigInfo getActiveFormConfigInfo() {
        if ((getFormConfigInfoSet() != null) && (getFormConfigInfoSet().size()> 0)) {
            for (FormConfigInfo formConfigInfo : getFormConfigInfoSet()) {
                if (formConfigInfo.getVersion()==getVersion()) {
                    return formConfigInfo;
                }
            }
        }

        return null;
    }
}
