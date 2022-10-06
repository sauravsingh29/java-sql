package com.cigna.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLServerRepository extends JpaRepository< Employee, Long> {
}
