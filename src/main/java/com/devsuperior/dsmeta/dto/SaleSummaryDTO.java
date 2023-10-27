package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleSummaryDTO {

    private String name;
    private Double sum;

    public SaleSummaryDTO(){
    }

    public SaleSummaryDTO(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }

    public SaleSummaryDTO(Sale entity) {
        name = entity.getSeller().getName();
        sum = entity.getAmount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
