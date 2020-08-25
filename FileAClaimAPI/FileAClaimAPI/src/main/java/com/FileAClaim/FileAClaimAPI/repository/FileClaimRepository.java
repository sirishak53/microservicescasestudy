package com.FileAClaim.FileAClaimAPI.repository;

import com.FileAClaim.FileAClaimAPI.model.FileClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileClaimRepository extends JpaRepository<FileClaim, Long> {
}