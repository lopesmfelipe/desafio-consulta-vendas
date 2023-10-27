package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleReportDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleReportDTO(entity);
	}

	//REPORT
	public Page<SaleReportDTO> searchRepo(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate minimalDate = minDate.isEmpty() ? today.minusMonths(12) : LocalDate.parse(minDate);
		LocalDate maximumDate = maxDate.isEmpty() ? today : LocalDate.parse(maxDate);

		Page<Sale> page = repository.searchReport(minimalDate, maximumDate, name, pageable);
		return page.map(x -> new SaleReportDTO(x));
	}

	//SUMMARY
	public List<SaleSummaryDTO> findSummary(String minDate, String maxDate) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate miDate = minDate.isEmpty() ? today.minusMonths(12) : LocalDate.parse(minDate);
		LocalDate maDate = maxDate.isEmpty() ? today : LocalDate.parse(maxDate);

		return repository.searchSummary(miDate, maDate);
		}
}