package pl.filiphagno.spring6backend.services;

import pl.filiphagno.spring6backend.model.BeerCSVRecord;

import java.io.File;
import java.util.List;


public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
