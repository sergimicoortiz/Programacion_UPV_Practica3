package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.shop.ClothingItem;

public class TestClothingItem {

	@Test
	public void shouldAnswerWithTrue() {
		ClothingItem item1 = new ClothingItem("Camisa", 25.99, 'M');
		ClothingItem item2 = new ClothingItem("Camisa", 25.99, 'P'); // default size should be S
		assertTrue((item1 != null)
				&& (item1 instanceof ClothingItem)
				&& item2.getSize() == 'S');
	}
}
