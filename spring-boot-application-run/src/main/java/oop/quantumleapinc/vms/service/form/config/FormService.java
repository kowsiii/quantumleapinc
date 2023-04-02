package oop.quantumleapinc.vms.service.form.config;

import jakarta.transaction.Transactional;
import oop.quantumleapinc.vms.model.file.FileDB;
import oop.quantumleapinc.vms.model.form.config.FormConfig;
import oop.quantumleapinc.vms.model.form.config.FormConfigInfo;
import oop.quantumleapinc.vms.model.form.submission.Form;
import oop.quantumleapinc.vms.payload.form.*;
import oop.quantumleapinc.vms.repository.FileDBRepository;
import oop.quantumleapinc.vms.repository.FormConfigInfoRepository;
import oop.quantumleapinc.vms.repository.FormConfigRepository;
import oop.quantumleapinc.vms.repository.FormRepository;
import jakarta.persistence.EntityNotFoundException;
import oop.quantumleapinc.vms.service.file.FileStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    FormRepository formRepository;

    @Autowired
    FormConfigRepository formConfigRepository;

    @Autowired
    FormConfigInfoRepository formConfigInfoRepository;

    @Autowired
    FileStorageService fileStorageService;

    public List<FormResponse> getByUser(String loginUser) {
        List<Form> forms = formRepository.findByUsername(loginUser);
        return transformToFormResponse(forms);
    }

    public List<FormResponse> getByUser(Long formConfigId, Long formConfigInfoId, String loginUser) {
        List<Form> forms = new ArrayList<>();
        Optional<Form> OptionalForm = formRepository.findByFormConfigIdAndFormConfigInfoIdAndUsername(formConfigId,
                formConfigInfoId, loginUser);
        if (OptionalForm.isPresent()) {
            forms.add(OptionalForm.get());
        }
        return transformToFormResponse(forms);
    }

    public List<FormResponse> getByPath(String path) {
        List<Form> forms = formRepository.findByPath(path);
        return transformToFormResponse(forms);
    }

    public List<FormResponse> getByFormConfig(Long formConfigId, Long formConfigInfoId) {
        List<Form> forms = formRepository.findByFormConfigIdAndFormConfigInfoId(formConfigId, formConfigInfoId);
        return transformToFormResponse(forms);
    }

    public List<FormResponse> getByForm(Long formId) {
        List<Form> forms = new ArrayList<>();
        Optional<Form> OptionalForm = formRepository.findById(formId);
        if (OptionalForm.isPresent()) {
            forms.add(OptionalForm.get());
        }
        return transformToFormResponse(forms);
    }

    @Transactional
    public FormDataResponse saveAll(FormRequest formRequest, String loginUser, List<FileDB> fileList) {
        Form form = save(formRequest, loginUser);
        fileStorageService.saveAllFilesList(fileList, form);
        return transformToResponse(form);
    }

    private Form save(FormRequest formRequest, String loginUser) {
        Optional<Form> OptionalForm = formRepository.findByFormConfigIdAndFormConfigInfoIdAndUsername(formRequest.getFormConfigId(),
                formRequest.getFormConfigInfoId(), loginUser);
        Form form;
        if (OptionalForm.isPresent()) {
            form = OptionalForm.get();
        } else {
            form = new Form();
            form.setFormConfigId(formRequest.getFormConfigId());
            form.setFormConfigInfoId(formRequest.getFormConfigInfoId());
            form.setPath(formRequest.getPath());
            form.setUsername(formRequest.getUsername());
            form.setCreatedBy(loginUser);
            form.setCreatedDate(LocalDateTime.now());
            form.setAssignees(formRequest.getAssignees());
        }
        form.setStatus(formRequest.getStatus());
        form.setFormData(formRequest.getFormData());
        form.setModifiedBy(loginUser);
        form.setModifiedDate(LocalDateTime.now());

        form = formRepository.saveAndFlush(form);

        return form;
        //return transformToResponse(form);
    }

    private FormDataResponse transformToResponse(Form form) {

        FormDataResponse formDataResponse = new FormDataResponse();
        BeanUtils.copyProperties(form, formDataResponse);

        return formDataResponse;
    }

    private List<FormResponse> transformToFormResponse(List<Form> forms) {
        List<FormResponse> formResponses = new ArrayList<>();
        forms.forEach(form -> {
            FormResponse formResponse = new FormResponse();

            FormDataResponse formDataResponse = new FormDataResponse();
            BeanUtils.copyProperties(form, formDataResponse);
            formResponse.setFormDataResponse(formDataResponse);

            FormConfigResponse formConfigResponse = new FormConfigResponse();
            FormConfig formConfig = formConfigRepository.findById(form.getFormConfigId()).orElse(new FormConfig());
            BeanUtils.copyProperties(formConfig, formConfigResponse);
            formResponse.setFormConfigResponse(formConfigResponse);

            FormConfigInfoResponse formConfigInfoResponse = new FormConfigInfoResponse();
            FormConfigInfo formConfigInfo = formConfigInfoRepository.findById(form.getFormConfigInfoId()).orElse(new FormConfigInfo());
            BeanUtils.copyProperties(formConfigInfo, formConfigInfoResponse);
            formResponse.setFormConfigInfoResponse(formConfigInfoResponse);

            formResponses.add(formResponse);
        });

        return formResponses;
    }
}
