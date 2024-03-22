package com.hcl.gl.Lab6.Practice.Pojo;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	
	@Autowired
	BillRepo repo;
	//insertBill
	//deleteBill
	//viewAllBill
	//viewBillByCustomerName
	//viewBillByDate

	//--------insertBill---------
	public void insertData(Bill bill) {
		repo.save(bill);
	}
	
	//--------viewAllBill----------
	public List<Bill> getAll(){
		return repo.findAll();
		
	}
	
	//---------deleteBill-----------
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	//----
	public List<Bill> getByName(String name){
		Bill bi=new Bill();
		bi.setName(name);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id","billDate","unit","price");
		Example<Bill> example=Example.of(bi,exampleMatcher);
		return repo.findAll(example);
		
	}
	
	//-------
	public List<Bill> getBydates(LocalDate d1,LocalDate d2){
		return repo.findByBillDateBetween(d1, d2);
		
	}
	
	
	
}
