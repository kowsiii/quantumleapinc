package oop.quantumleapinc.vms.service.file;

import oop.quantumleapinc.vms.model.file.FileDB;
import oop.quantumleapinc.vms.model.form.submission.Form;
import oop.quantumleapinc.vms.repository.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileStorageService {
    @Autowired
    private FileDBRepository fileDBRepository;

    public void saveAllFilesList(List<FileDB> fileList, Form form) {
        for (FileDB fileModal : fileList) {
            fileModal.setForm(form);
            fileDBRepository.saveAndFlush(fileModal);
        }
    }

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(FileDB);
    }

    public FileDB getFile(Long id) {
        return fileDBRepository.findById(id).get();
    }

    public List<FileDB> getFiles(Long formId) {
        return fileDBRepository.findByFormFormId(formId);
    }

}
