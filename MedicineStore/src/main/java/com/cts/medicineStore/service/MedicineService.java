package com.cts.medicineStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.medicineStore.entity.Medicine;
import com.cts.medicineStore.repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository mRepo;

	public void save(Medicine m) {
		mRepo.save(m);
	}

	public List<Medicine> getAllMedicine() {
		return mRepo.findAll();
	}

	public Medicine getMedicineById(int id) {
		return mRepo.findById(id).get();
	}

	public void deleteById(int id) {
		mRepo.deleteById(id);
	}

	public List<Medicine> search(String name) {
		return mRepo.findByNameContaining(name);
		// TODO Auto-generated method stub
		
	}
	

}
