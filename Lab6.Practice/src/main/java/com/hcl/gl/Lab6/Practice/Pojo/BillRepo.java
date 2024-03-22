package com.hcl.gl.Lab6.Practice.Pojo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill, Integer>{

	List<Bill> findByBillDateBetween(LocalDate d1,LocalDate d2);
}
