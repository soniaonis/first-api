package com.example.first.api.repositories;

import com.example.first.api.models.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<CUser, Integer> {
}
