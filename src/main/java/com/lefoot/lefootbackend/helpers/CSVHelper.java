package com.lefoot.lefootbackend.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lefoot.lefootbackend.models.CSVUploadData;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
  public static String TYPE = "text/csv";
  public static boolean hasCSVFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }
  public static List<CSVUploadData> csvToUploadedData(InputStream is) {
    try (
      BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      CSVParser csvParser = new CSVParser(
        fileReader,
        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
      );
    ) {
      List<CSVUploadData> uploadedData = new ArrayList<CSVUploadData>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      for (CSVRecord csvRecord : csvRecords) {  
        CSVUploadData csvUploadData = new CSVUploadData(
          csvRecord.get("nome"),
          Integer.parseInt(csvRecord.get("idade")),
          csvRecord.get("cpf"),
          parseDateFromString(csvRecord.get("data_nasc")),
          csvRecord.get("genero"),
          csvRecord.get("email"),
          csvRecord.get("cep"),
          csvRecord.get("endereco"),
          Integer.parseInt(csvRecord.get("numero")),
          csvRecord.get("bairro"),
          csvRecord.get("municipio"),
          csvRecord.get("estado")
        );
        uploadedData.add(csvUploadData);
      }
      return uploadedData;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  private static Date parseDateFromString(String stringDate) {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try {
      Date date = format.parse(stringDate);
      return date;
    } catch(ParseException error) {
      System.err.println(error);
    }
    return null;
  }
}
