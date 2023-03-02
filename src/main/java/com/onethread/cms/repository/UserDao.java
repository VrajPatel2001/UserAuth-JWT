package com.onethread.cms.repository;

import com.onethread.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByFullName(String fullname);
    User findByEmail(String email);
}