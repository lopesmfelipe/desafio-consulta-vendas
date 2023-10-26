package com.devsuperior.dsmeta.services;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	/*
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
/*
	//REPORT
	public Page<SaleMinDTO> searchReport(String minDate, String maxDate, String name, Pageable pageable) {

		if (minDate == "") {
			LocalDate maximumDate = LocalDate.now();
			LocalDate minimalDate = maximumDate.minusMonths(12);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String minDateString = minimalDate.format(formatter);
			minDate = minDateString;

		}
		if (maxDate == "") {
			LocalDate maximumDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String maxDateString = maximumDate.format(formatter);
			maxDate = maxDateString;
		}

		Page<Sale> page = repository.searchReport(minDate, maxDate, name, pageable);
		return page.map(x -> new SaleMinDTO(x));
	}
*/
	//SUMMARY
	public List<SummaryDTO> findSummary(String minDate, String maxDate) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate miDate = LocalDate.parse(minDate, formatter);
				LocalDate maDate = LocalDate.parse(maxDate, formatter);
				return repository.searchSummary(miDate, maDate);
		}
}