package oop.quantumleapinc.vms.repository;

import oop.quantumleapinc.vms.model.form.config.FormConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormConfigRepository extends JpaRepository<FormConfig, Long> {
    Optional<FormConfig> findByRandomPath(String randomPath);
}
