package com.example.usermgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermgmt.entity.UserEntity;

@Repository
public interface UserMgmtRepo extends JpaRepository<UserEntity, Long>{

}
