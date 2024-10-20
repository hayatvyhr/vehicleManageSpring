package com.example.cars.Repository;

import com.example.cars.Entity.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminLogin, Integer> {
    boolean existsByUsernameAndPassword(String username, String password);

}
