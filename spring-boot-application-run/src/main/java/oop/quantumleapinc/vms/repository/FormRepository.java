package oop.quantumleapinc.vms.repository;

import oop.quantumleapinc.vms.model.form.submission.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Long> {
    List<Form> findByUsername(String username);

    List<Form> findByPath(String path);

    Optional<Form> findByFormConfigIdAndFormConfigInfoIdAndUsername(Long FormConfigId, Long formConfigInfoId, String username);

    List<Form> findByFormConfigIdAndFormConfigInfoId(Long FormConfigId, Long formConfigInfoId);
}
