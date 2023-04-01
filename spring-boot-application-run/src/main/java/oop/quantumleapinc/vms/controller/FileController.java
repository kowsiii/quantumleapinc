package oop.quantumleapinc.vms.controller;

import oop.quantumleapinc.vms.model.file.FileDB;
import oop.quantumleapinc.vms.service.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") Long id) {
        FileDB fileDB = fileStorageService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity getFiles(@PathVariable("id") Long formId) {
        List<FileDB> files = fileStorageService.getFiles(formId);
        return ResponseEntity.ok()
                .body(files);
    }

}
