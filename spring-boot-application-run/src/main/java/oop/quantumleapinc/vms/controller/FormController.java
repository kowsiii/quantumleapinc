package oop.quantumleapinc.vms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import oop.quantumleapinc.vms.login.payload.response.MessageResponse;
import oop.quantumleapinc.vms.model.file.FileDB;
import oop.quantumleapinc.vms.payload.form.FormDataResponse;
import oop.quantumleapinc.vms.payload.form.FormRequest;
import oop.quantumleapinc.vms.service.form.config.FormConfigService;
import oop.quantumleapinc.vms.service.form.config.FormService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    FormConfigService formConfigService;

    @Autowired
    FormService formService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/load/{path}")
    public ResponseEntity<?> getFormConfig(@PathVariable String path) {
        logger.debug("getFormConfig: get form config with path: '{}", path);
        try {
            return ResponseEntity.ok().body(formConfigService.get(path));
        } catch (Exception ex) {
            logger.error("getFormConfig: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form config!"));
        }
    }

    @PostMapping("/{path}")
    public ResponseEntity<?> submit(@RequestPart(value = "data", required = true) String data,
                                    @RequestPart(value = "files", required = false) MultipartFile[] files,
                                    @PathVariable("path") String path) {
        logger.debug("submit: form data save with path: '{}", path);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormRequest formRequest = new ObjectMapper().readValue(data, FormRequest.class);
            logger.debug("data: " + formRequest.toString());
            List<FileDB> fileList = new ArrayList<FileDB>();
            if (files != null) {
                for (MultipartFile file : files) {
                    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                    if ((!fileName.isBlank()) && (!fileName.isEmpty())) {
                        String fileContentType = file.getContentType();
                        FileDB fileDB = new FileDB(fileName, fileContentType, file.getBytes());
                        fileList.add(fileDB);
                    }
                }
            }
            FormDataResponse formDataResponse = formService.saveAll(formRequest, loginUser, fileList);
            return ResponseEntity.ok().body(new MessageResponse("Success", "Saved successfully with Form Id: "
                    + formDataResponse.getFormId()));
        } catch (Exception ex) {
            logger.error("submit: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to save the form data."));
        }
    }

    @GetMapping("/mysubmissions")
    public ResponseEntity<?> getByUser() {
        logger.debug("getByUser: get my submitted forms");
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            return ResponseEntity.ok().body(formService.getByUser(loginUser));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form data."));
        }
    }

    @GetMapping("/mysubmission/{formConfigId}/{formConfigInfoId}")
    public ResponseEntity<?> getByFormAndUser(@PathVariable("formConfigId") Long formConfigId,
                                              @PathVariable("formConfigInfoId") Long formConfigInfoId) {
        logger.debug("get: form data with formConfigId: {} formConfigInfoId: {}", formConfigId, formConfigInfoId);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            return ResponseEntity.ok().body(formService.getByUser(formConfigId, formConfigInfoId, loginUser));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form data."));
        }
    }

    @GetMapping("/admin/submissions/{path}")
    public ResponseEntity<?> getByPath(@PathVariable("path") String path) {
        logger.debug("get: form data with path: '{}", path);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            return ResponseEntity.ok().body(formService.getByPath(path));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form data."));
        }
    }

    @GetMapping("/admin/submission/{formId}")
    public ResponseEntity<?> getByForm(@PathVariable("formId") Long formId) {
        logger.debug("get: form data with formId: {}", formId);
        try {
            return ResponseEntity.ok().body(formService.getByForm(formId));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form data."));
        }
    }

    @GetMapping("/admin/submissions/{formConfigId}/{formConfigInfoId}")
    public ResponseEntity<?> getByForm(@PathVariable("formConfigId") Long formConfigId,
                                       @PathVariable("formConfigInfoId") Long formConfigInfoId) {
        logger.debug("get: form data with formConfigId: {} formConfigInfoId: {}", formConfigId, formConfigInfoId);
        try {
            return ResponseEntity.ok().body(formService.getByFormConfig(formConfigId, formConfigInfoId));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form data."));
        }
    }

}
