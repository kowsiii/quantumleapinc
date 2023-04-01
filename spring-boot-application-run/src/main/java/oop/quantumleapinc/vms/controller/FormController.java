package oop.quantumleapinc.vms.controller;

import oop.quantumleapinc.vms.login.payload.response.MessageResponse;
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
import org.springframework.web.bind.annotation.*;

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
                    .body(new MessageResponse("Error","Not able to find the form config!"));
        }
    }

    @GetMapping("/{path}")
    public ResponseEntity<?> get(@PathVariable("path") String path) {
        logger.debug("get: form data with path: '{}", path);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            return ResponseEntity.ok().body(formService.get(path, loginUser));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error","Not able to find the form data."));
        }
    }

    @PostMapping("/{path}")
    public ResponseEntity<?> submit(@Valid @RequestBody FormRequest formRequest,
                                    @PathVariable("path") String path) {
        logger.debug("submit: form data save with path: '{}", path);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormDataResponse formDataResponse = formService.save(formRequest, loginUser);
            return ResponseEntity.ok().body(new MessageResponse("Success", "Saved successfully with Form Id: "
                    + formDataResponse.getFormId()));
        } catch (Exception ex) {
            logger.error("submit: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to save the form data."));
        }
    }
}
