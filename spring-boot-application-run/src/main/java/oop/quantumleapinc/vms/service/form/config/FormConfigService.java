package oop.quantumleapinc.vms.service.form.config;

import oop.quantumleapinc.vms.model.form.config.FormConfig;
import oop.quantumleapinc.vms.model.form.config.FormConfigInfo;
import oop.quantumleapinc.vms.payload.form.FormConfigInfoResponse;
import oop.quantumleapinc.vms.payload.form.FormConfigRequest;
import oop.quantumleapinc.vms.payload.form.FormConfigResponse;
import oop.quantumleapinc.vms.repository.FormConfigInfoRepository;
import oop.quantumleapinc.vms.repository.FormConfigRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class FormConfigService {

    @Autowired
    FormConfigRepository formConfigRepository;

    @Autowired
    FormConfigInfoRepository formConfigInfoRepository;

    public List<FormConfigResponse> getList() {
        List<FormConfigResponse> result = new ArrayList<>();
        List<FormConfig> list = formConfigRepository.findAll();
        list.forEach((formConfig) -> {
            result.add(transformToResponse(formConfig));
        });
        return result;
    }

    public FormConfigResponse get(Long formConfigId) {
        FormConfig formConfig = formConfigRepository.findById(formConfigId)
                .orElseThrow(() -> new EntityNotFoundException(formConfigId.toString()));
        return transformToResponse(formConfig);
    }

    public FormConfigResponse get(String path) {
        FormConfig formConfig = formConfigRepository.findByRandomPath(path)
                .orElseThrow(() -> new EntityNotFoundException(path));
        return transformToResponse(formConfig);
    }

    @Transactional
    public FormConfigResponse add(FormConfigRequest formConfigRequest, String loginUser) {
        FormConfig formConfig = new FormConfig();
        formConfig.setActive("Y");
        formConfig.setVersion(1);
        formConfig.setRandomPath(UUID.randomUUID().toString());
        formConfig.setCreatedBy(loginUser);
        formConfig.setModifiedBy(loginUser);
        formConfig.setCreatedDate(LocalDateTime.now());
        formConfig.setModifiedDate(LocalDateTime.now());

        FormConfigInfo formConfigInfo = new FormConfigInfo();
        formConfigInfo.setFormDesign(formConfigRequest.getFormDesign());
        formConfigInfo.setVersion(1);
        formConfigInfo.setCreatedBy(loginUser);
        formConfigInfo.setModifiedBy(loginUser);
        formConfigInfo.setCreatedDate(LocalDateTime.now());
        formConfigInfo.setModifiedDate(LocalDateTime.now());
        formConfigInfo.setTitle(formConfigRequest.getTitle());

        formConfigInfo.setFormConfig(formConfig);
        formConfig.getFormConfigInfoSet().add(formConfigInfo);

        formConfig = formConfigRepository.saveAndFlush(formConfig);

        return transformToResponse(formConfig);
    }

    @Transactional
    public FormConfigResponse update(FormConfigRequest formConfigRequest,
                                     String loginUser, Long formConfigId) {
        FormConfig formConfig = formConfigRepository.findById(formConfigId)
                .orElseThrow(() -> new EntityNotFoundException(formConfigId.toString()));
        formConfig.setModifiedBy(loginUser);
        formConfig.setModifiedDate(LocalDateTime.now());

        Integer lastVersion = 0;
        for(FormConfigInfo formConfigInfo : formConfig.getFormConfigInfoSet()) {
            if (formConfigInfo != null) {
                lastVersion = formConfigInfo.getVersion();
            }
        }
        lastVersion++;

        formConfig.setVersion(lastVersion);

        FormConfigInfo formConfigInfo = new FormConfigInfo();
        formConfigInfo.setFormDesign(formConfigRequest.getFormDesign());
        formConfigInfo.setVersion(lastVersion);
        formConfigInfo.setCreatedBy(loginUser);
        formConfigInfo.setModifiedBy(loginUser);
        formConfigInfo.setCreatedDate(LocalDateTime.now());
        formConfigInfo.setModifiedDate(LocalDateTime.now());
        formConfigInfo.setTitle(formConfigRequest.getTitle());

        formConfigInfo.setFormConfig(formConfig);
        formConfigInfo = formConfigInfoRepository.saveAndFlush(formConfigInfo);

        formConfig.getFormConfigInfoSet().add(formConfigInfo);

        formConfig = formConfigRepository.saveAndFlush(formConfig);

        return transformToResponse(formConfig);
    }

    @Transactional
    public FormConfigResponse updateStatus(String loginUser, Long formConfigId, String status) {
        FormConfig formConfig = formConfigRepository.findById(formConfigId)
                .orElseThrow(() -> new EntityNotFoundException(formConfigId.toString()));
        formConfig.setModifiedBy(loginUser);
        formConfig.setModifiedDate(LocalDateTime.now());
        formConfig.setActive(status);

        formConfig = formConfigRepository.saveAndFlush(formConfig);

        return transformToResponse(formConfig);
    }

    @Transactional
    public FormConfigResponse updateTitle(String loginUser, Long formConfigInfoId, String title) {
        FormConfigInfo formConfigInfo = formConfigInfoRepository.findById(formConfigInfoId)
                .orElseThrow(() -> new EntityNotFoundException(formConfigInfoId.toString()));
        formConfigInfo.setModifiedBy(loginUser);
        formConfigInfo.setModifiedDate(LocalDateTime.now());
        formConfigInfo.setTitle(title);

        formConfigInfo = formConfigInfoRepository.saveAndFlush(formConfigInfo);

        return transformToResponse(formConfigInfo.getFormConfig());
    }

    //
    private FormConfigResponse transformToResponse(FormConfig formConfig) {
        FormConfigResponse formConfigResponse = new FormConfigResponse();
        BeanUtils.copyProperties(formConfig, formConfigResponse);

        Set<FormConfigInfoResponse> formConfigInfoResponseSet = new HashSet<>();
        FormConfigInfo formConfigInfo = formConfig.getActiveFormConfigInfo();
        //for(FormConfigInfo formConfigInfo : formConfig.getFormConfigInfoSet()) {
        if(formConfigInfo != null) {
            FormConfigInfoResponse formConfigInfoResponse = new FormConfigInfoResponse();
            BeanUtils.copyProperties(formConfigInfo, formConfigInfoResponse);
            formConfigInfoResponseSet.add(formConfigInfoResponse);
        }
        //}
        formConfigResponse.setFormConfigInfoSet(formConfigInfoResponseSet);

        return formConfigResponse;
    }
}
