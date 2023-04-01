package oop.quantumleapinc.vms.model.form.submission;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
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
}
