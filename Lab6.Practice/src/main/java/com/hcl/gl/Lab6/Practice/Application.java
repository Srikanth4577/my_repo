package com.hcl.gl.Lab6.Practice;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.gl.Lab6.Practice.Pojo.Bill;
import com.hcl.gl.Lab6.Practice.Pojo.BillService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	BillService billService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server Started");
		String date="2023-02-02";
		String date1="2023-03-02";
		String date2="2023-01-02";
		String date3="2023-01-15";
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-M-dd");
		formatter=formatter.withLocale(Locale.ENGLISH);
		
		LocalDate id=LocalDate.parse(date,formatter);
		LocalDate id1=LocalDate.parse(date1,formatter);
		LocalDate id2=LocalDate.parse(date2,formatter);
		LocalDate id3=LocalDate.parse(date3,formatter);
		
		Bill b=new Bill(1, id, "Biryani", 20, 25.4);
		billService.insertData(b);
		
		Bill b1=new Bill(2, id1, "Rotti", 50, 2.4);
		billService.insertData(b1);
		
		Bill b2=new Bill(3, id2, "Rice", 100, 25.4);
		billService.insertData(b2);
		
		Bill b3=new Bill(4, id3, "parota", 25, 155.7);
		billService.insertData(b3);
		
		//List<Bill> getAllBills=billService.getAll();
		List<Bill> getAllByName=billService.getByName("Rice");
		for(Bill temp:getAllByName) {
			System.out.println("------By Name------");
			System.out.println("Id is :"+temp.getId());
			System.out.println("Name is:"+temp.getName());
			System.out.println("Price is :"+temp.getPrice());
			System.out.println("Date is :"+temp.getBillDate());
		}
		
		
		DateTimeFormatter formatters=DateTimeFormatter.ofPattern("yyyy-M-dd");
		formatter=formatters.withLocale(Locale.ENGLISH);
		LocalDate d1=LocalDate.parse(date,formatter);
		LocalDate d2=LocalDate.parse(date1,formatter);
		List<Bill> getallItems=billService.getBydates(d1, d2);
		for(Bill temp:getallItems) {
			System.out.println("---------Bills-----");
			System.out.println("Name is:"+temp.getName());
			
		}
		

	}
	

}
