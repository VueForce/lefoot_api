package com.lefoot.lefootbackend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lefoot.lefootbackend.models.CSVUploadData;
import com.lefoot.lefootbackend.repositories.CSVUploadDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVUploadDataController {
  @Autowired
  private CSVUploadDataRepository csvUploadDataRepository;

  @GetMapping("/csv-upload")
  public String helloWorld() {
    return "hello world";
  }
}
