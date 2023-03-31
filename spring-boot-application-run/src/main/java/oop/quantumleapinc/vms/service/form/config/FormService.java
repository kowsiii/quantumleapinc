package oop.quantumleapinc.vms.service.form.config;

import oop.quantumleapinc.vms.model.form.config.FormConfig;
import oop.quantumleapinc.vms.model.form.config.FormConfigInfo;
import oop.quantumleapinc.vms.model.form.submission.Form;
import oop.quantumleapinc.vms.payload.form.*;
import oop.quantumleapinc.vms.repository.FormConfigInfoRepository;
import oop.quantumleapinc.vms.repository.FormConfigRepository;
import oop.quantumleapinc.vms.repository.FormRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    FormRepository formRepository;

    @Autowired
    FormConfigRepository formConfigRepository;

    @Autowired
    FormConfigInfoRepository formConfigInfoRepository;

    public FormResponse get(String path, String loginUser) {
        Form form = formRepository.findByPathAndUsername(path, loginUser).orElseThrow(() -> new EntityNotFoundException(path));;

        return transformToFormResponse(form);
    }

    public FormDataResponse save(FormRequest formRequest, String loginUser) {
        Optional<Form> OptionalForm = formRepository.findByPathAndUsername(formRequest.getPath(), loginUser);
        Form form;
        if (OptionalForm.isPresent()) {
            form = OptionalForm.get();
        } else {
            form = new Form();
            form.setFormConfigId(formRequest.getFormConfigId());
            form.setFormConfigInfoId(formRequest.getFormConfigInfoId());
            form.setPath(formRequest.getPath());
            form.setUsername(loginUser);
            form.setCreatedBy(loginUser);
            form.setCreatedDate(LocalDateTime.now());
        }
        form.setStatus(formRequest.getStatus());
        form.setFormData(formRequest.getFormData());
        form.setModifiedBy(loginUser);
        form.setModifiedDate(LocalDateTime.now());

        form = formRepository.saveAndFlush(form);

        return transformToResponse(form);
    }

    private FormDataResponse transformToResponse(Form form) {

        FormDataResponse formDataResponse = new FormDataResponse();
        BeanUtils.copyProperties(form, formDataResponse);

        return formDataResponse;
    }

    private FormResponse transformToFormResponse(Form form) {
        FormResponse formResponse = new FormResponse();

        FormDataResponse formDataResponse = new FormDataResponse();
        BeanUtils.copyProperties(form, formDataResponse);

        FormConfigResponse  formConfigResponse = new FormConfigResponse();
        FormConfig formConfig = formConfigRepository.findById(form.getFormConfigId()).orElse(new FormConfig());
        BeanUtils.copyProperties(formConfig, formConfigResponse);

        FormConfigInfoResponse formConfigInfoResponse = new FormConfigInfoResponse();
        FormConfigInfo formConfigInfo = formConfigInfoRepository.findById(form.getFormConfigInfoId()).orElse(new FormConfigInfo());
        BeanUtils.copyProperties(formConfigInfo, formConfigInfoResponse);

        formResponse.setFormConfigResponse(formConfigResponse);
        formResponse.setFormConfigInfoResponse(formConfigInfoResponse);
        formResponse.setFormDataResponse(formDataResponse);

        return formResponse;
    }

}
