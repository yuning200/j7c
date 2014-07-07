package com.ch5.f01;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {
	
	public List<Product> generator(int size){
		List<Product> prolist = new ArrayList<Product>();
		for (int i = 0; i < size; i++) {
			Product product = new Product();
			product.setName("Product_"+i);
			product.setPrice(10);
			prolist.add(product);
		}
		return prolist;
	}
}
