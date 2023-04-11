package com.userservice.repo;


import com.userservice.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserDetail,Long> {
    UserDetail findByUsername(String username);
}
