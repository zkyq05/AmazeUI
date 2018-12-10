package com.xh.springBoot.domain;

import com.xh.springBoot.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    void deleteById(Long id);
}
