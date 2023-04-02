package oop.quantumleapinc.vms.controller;

import oop.quantumleapinc.vms.login.payload.response.MessageResponse;
import oop.quantumleapinc.vms.payload.form.FormConfigRequest;
import oop.quantumleapinc.vms.payload.form.FormConfigResponse;
import oop.quantumleapinc.vms.service.form.config.FormConfigService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/config/form")
public class FormConfigController {
    @Autowired
    FormConfigService formConfigService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody FormConfigRequest formConfigRequest) {
        logger.debug("add: new form config" );
        try {
            //Principal principal = request.getUserPrincipal();
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormConfigResponse formConfigResponse = formConfigService.add(formConfigRequest, loginUser);
            return ResponseEntity.ok().body(new MessageResponse("Success", "form config created."));
        } catch (Exception ex) {
            logger.error("add: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to add form config."));
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody FormConfigRequest formConfigRequest,
                                    @PathVariable("id") Long formConfigId) {
        logger.debug("update: update form config for " +  formConfigId);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormConfigResponse formConfigResponse = formConfigService.update(formConfigRequest, loginUser, formConfigId);
            return ResponseEntity.ok().body(new MessageResponse("Success", "form config updated."));
        } catch (Exception ex) {
            logger.error("update: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to update form config."));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long formConfigId) {
        logger.debug("update: update form config for " +  formConfigId);
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormConfigResponse formConfigResponse = formConfigService.delete(loginUser, formConfigId);
            return ResponseEntity.ok().body(new MessageResponse("Success", "form config updated."));
        } catch (Exception ex) {
            logger.error("update: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to update form config."));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long formConfigId) {
        logger.debug("get: form config for " + formConfigId);
        try {
            return ResponseEntity.ok().body(formConfigService.get(formConfigId));
        } catch (Exception ex) {
            logger.error("get: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to find the form config."));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        logger.debug("list: get form config list");
        try {
            return ResponseEntity.ok().body(formConfigService.getList());
        } catch (Exception ex) {
            logger.error("list: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to get form config list."));
        }
    }

    @GetMapping("/mylist")
    public ResponseEntity<?> mylist() {
        logger.debug("list: get form config list");
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            return ResponseEntity.ok().body(formConfigService.getList(loginUser));
        } catch (Exception ex) {
            logger.error("list: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to get form config list."));
        }
    }

    @PostMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(@RequestBody FormConfigRequest formConfigRequest,
                                          @PathVariable("id") Long formConfigId) {
        logger.debug("updateStatus: update form config status for " +  formConfigId + " with status " + formConfigRequest.getStatus());
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormConfigResponse formConfigResponse = formConfigService.updateStatus(loginUser, formConfigId, formConfigRequest.getStatus());
            return ResponseEntity.ok().body(new MessageResponse("Success", "form config status updated."));
        } catch (Exception ex) {
            logger.error("updateStatus: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to update form config status."));
        }
    }

    @PostMapping("/title/{id}")
    public ResponseEntity<?> updateTitle(@RequestBody FormConfigRequest formConfigRequest,
                                         @PathVariable("id") Long formConfigInfoId) {
        logger.debug("updateTitle: update form config title for " +  formConfigInfoId + " with title " + formConfigRequest.getTitle());
        try {
            String loginUser = SecurityContextHolder.getContext().getAuthentication().getName();
            FormConfigResponse formConfigResponse = formConfigService.updateTitle(loginUser, formConfigInfoId, formConfigRequest.getTitle());
            return ResponseEntity.ok().body(new MessageResponse("Success", "form config title updated."));
        } catch (Exception ex) {
            logger.error("updateTitle: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to update form config title."));
        }
    }
}
