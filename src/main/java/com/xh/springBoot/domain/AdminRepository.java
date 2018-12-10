package com.xh.springBoot.domain;

import com.xh.springBoot.modle.qc_admin_user;
import com.xh.springBoot.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<qc_admin_user, Long> {
    qc_admin_user findById(long id);
    qc_admin_user findByUsername(String username);
    void deleteById(Long id);
}
