package oop.quantumleapinc.vms.repository;

import oop.quantumleapinc.vms.model.form.submission.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Long> {
    Optional<Form> findByPathAndUsername(String path, String username);
}
