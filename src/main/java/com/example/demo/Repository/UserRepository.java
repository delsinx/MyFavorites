package com.example.demo.Repository;


import Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface user extends JpaRepository<UserModel, Long> {
}
