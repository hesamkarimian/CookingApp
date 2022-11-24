package com.sam.cookingapp.security.repositories;

import com.sam.cookingapp.security.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    public Privilege findByNam(String name);
}
