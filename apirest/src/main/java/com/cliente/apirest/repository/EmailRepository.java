package com.cliente.apirest.repository;

import com.cliente.apirest.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
