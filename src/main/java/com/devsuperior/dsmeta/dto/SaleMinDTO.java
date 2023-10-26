package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleMinDTO {

	private Long id;
	private Double amount;
	private LocalDate date;
	private SellerMinDTO seller;
	
	public SaleMinDTO(Long id, Double amount, LocalDate date, SellerMinDTO seller) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	
	public SaleMinDTO(Sale sale) {
		id = sale.getId();
		amount = sale.getAmount();
		date = sale.getDate();
		seller = new SellerMinDTO(sale.getSeller());
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}
}
