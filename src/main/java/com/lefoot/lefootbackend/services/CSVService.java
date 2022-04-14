package com.lefoot.lefootbackend.services;

import java.io.IOException;
import java.util.List;

import com.lefoot.lefootbackend.helpers.CSVHelper;
import com.lefoot.lefootbackend.models.CSVUploadData;
import com.lefoot.lefootbackend.repositories.CSVUploadDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
  @Autowired
  CSVUploadDataRepository csvUploadDataRepository;

  public void save(MultipartFile file) {
    try {
      List<CSVUploadData> csvUploadData = CSVHelper.csvToUploadedData(file.getInputStream());
      csvUploadDataRepository.saveAll(csvUploadData);
    } catch(IOException e) {
      throw new RuntimeException("Failed to store csv data: " + e.getMessage());
    }
  }

  public List<CSVUploadData> getAllCSVUploadData() {
    return csvUploadDataRepository.findAll();
  }
}
