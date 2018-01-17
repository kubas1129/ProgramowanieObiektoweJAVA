package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

	@Test
	public void heapifyHeapWithManyElements()
	{
		Heap heap = new Heap();
		heap.insert(20);
		heap.insert(300);
		heap.insert(45);
		heap.insert(9);
		heap.HeapifyMax();
		assertEquals(300,heap.extractMax(),0.01);
	}

	@Test
	public void deleteMaxElementFromHeap()
	{
		Heap heap = new Heap();
		heap.insert(400);
		heap.insert(24);
		heap.insert(7);
		heap.insert(890);
		heap.insert(234);
		heap.deleteMax();
		assertEquals(400,heap.extractMax(),0.01);
	}

	@Test
	public void replaceMaxElementWithBrandNewElement()
	{
		Heap heap = new Heap();
		heap.insert(345);
		heap.insert(12);
		heap.insert(90);
		heap.insert(45);
		heap.insert(900);
		heap.replace(67);
		assertEquals(345,heap.extractMax(),0.01);

	}

	@Test
	public void createHeapFromArrayList()
	{
		Heap heap = new Heap();
		ArrayList<Double> ll = new ArrayList<Double>(Arrays.asList((double)7,(double)343,(double)12));
		heap.heapify(ll);
		assertEquals(343,heap.extractMax(),0.01);
	}


}
