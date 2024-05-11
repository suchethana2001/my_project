package com.cts.medicineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.medicineStore.entity.MyCartList;

public interface MyCartRepository extends JpaRepository<MyCartList, Integer>{
	

}
