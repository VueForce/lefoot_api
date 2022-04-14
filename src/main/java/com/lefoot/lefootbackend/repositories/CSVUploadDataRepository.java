package com.lefoot.lefootbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lefoot.lefootbackend.models.CSVUploadData;

@Repository
public interface CSVUploadDataRepository extends JpaRepository<CSVUploadData, Long>{
  
}
