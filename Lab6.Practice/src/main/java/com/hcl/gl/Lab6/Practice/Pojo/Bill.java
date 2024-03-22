package com.hcl.gl.Lab6.Practice.Pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	@Id
	private int id;
	private LocalDate billDate;
	private String name;
	private int unit;
	private Double price;

}
