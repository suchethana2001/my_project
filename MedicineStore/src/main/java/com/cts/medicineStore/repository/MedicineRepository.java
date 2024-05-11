package com.cts.medicineStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.medicineStore.entity.Medicine;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	List<Medicine> findByNameContaining(String name);

}
