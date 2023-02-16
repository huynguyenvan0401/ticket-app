package com.zeran.ticket.repository;

import com.zeran.ticket.entity.Code;
import com.zeran.ticket.entity.People;
import com.zeran.ticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, Long> {
    Optional<Code> findByCode(String code);
}
