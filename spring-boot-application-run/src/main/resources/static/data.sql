INSERT INTO `employee` (`id`, `name`, `password`, `employee_contact_no`, `employee_id`, `employee_type`) VALUES ('1', 'admin', 'adminpass', '12345678', '1', 'admin'), ('2', 'approver', 'approverpass', '12345678', '2', 'approver');

INSERT INTO `permissions` (`permission_id`, `modified_by`, `permission_read`, `permission_write`) VALUES ('1', '1', b'1', b'1'), ('2', '1', b'1', b'0');