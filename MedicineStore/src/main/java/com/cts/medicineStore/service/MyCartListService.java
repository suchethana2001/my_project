package com.cts.medicineStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.medicineStore.entity.Medicine;
import com.cts.medicineStore.entity.MyCartList;
import com.cts.medicineStore.repository.MyCartRepository;

@Service
public class MyCartListService {
	@Autowired
	private MyCartRepository mycart;
	@Autowired
	private MedicineService service;

	public void saveMyCart(MyCartList m) {
		int count =m.getCount();
		Medicine med=service.getMedicineById(m.getId());
		if(count>med.getCount()) {
			m.setCount(med.getCount());
		}
		mycart.save(m);
	}

	public List<MyCartList> getAllMyMedicine() {
		return mycart.findAll();
	}

	public void deleteById(int id) {
		mycart.deleteById(id);
	}
	public MyCartList getMedicineById(int id) {
		return mycart.findById(id).get();
	}
	public double getTotalPrice() {
		List<MyCartList> list=this.getAllMyMedicine();
		double sum=0.0;
		double k=0.0;
		if(list.size()==0) {
			return 0.0;
		}
		else {
			for(MyCartList m:list) {
				double p=m.getPrice();
				double c=m.getCount();
				k=p*c;
				sum+=k;
				
			}
			
		}
		return sum;
	}

	public void removeMedicine() {
		List<MyCartList> cartList=this.getAllMyMedicine();
		List<Medicine> medicineList=service.getAllMedicine();
		for(MyCartList list:cartList) {
			int cartId=list.getId();
			for(Medicine m:medicineList) {
				int mid=m.getId();
				if(cartId==mid) {
					int countCart=list.getCount();
					m.setCount((m.getCount())-countCart);
					deleteById(cartId);
				}
				service.save(m);
			}
			
		}
		
		// TODO Auto-generated method stub
		
	}
	
}
