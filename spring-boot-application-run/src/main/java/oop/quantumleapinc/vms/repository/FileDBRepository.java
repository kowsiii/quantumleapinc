package oop.quantumleapinc.vms.repository;

import oop.quantumleapinc.vms.model.file.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {

 List<FileDB> findByFormFormId(Long formId);

}