package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    //REPORT
    /*@Query(value = "SELECT obj FROM Sale obj JOIN FETCH obj.seller " +
            "WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
            "AND obj.date >= DATEADD(MONTH, -12, CURRENT_DATE)",
            countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller s WHERE UPPER(s.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Sale> searchReport(String minDate, String maxDate, String name, Pageable pageable);
*/
    //SUMMARY

    @Query("SELECT NEW com.devsuperior.dsmeta.dto.SummaryDTO(obj.seller.name, SUM(obj.amount)) " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY obj.seller.name")
    List<SummaryDTO> searchSummary(LocalDate minDate, LocalDate maxDate);
}

