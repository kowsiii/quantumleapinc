package oop.quantumleapinc.vms.repository;

import oop.quantumleapinc.vms.model.form.config.FormConfigInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormConfigInfoRepository extends JpaRepository<FormConfigInfo, Long> {
}
