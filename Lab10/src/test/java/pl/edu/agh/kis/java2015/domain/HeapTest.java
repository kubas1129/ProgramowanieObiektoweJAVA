package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}

	@Test
	public void checkingSizeAfterAddElements(){
		Heap heap = new Heap();
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		assertEquals(3,heap.size());
	}

	@Test
	public void	extractMaxElementFromMaxHeap()
	{
		Heap heap = new Heap();
		heap.insert(10);
		heap.insert(5);
		heap.insert(45);
		heap.insert(12);
		assertEquals(45,heap.extractMax(),0.01);
	}

}
