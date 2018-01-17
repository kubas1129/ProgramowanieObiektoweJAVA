package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public double extractMax()
	{
		return top();
	}

	public void deleteMax()
	{
		swapElements(size()-1,0);
		tab.remove(size()-1);
		heapSize--;
		HeapifyMax();
	}

	public void HeapifyMax()
	{
		for(int i = 0; i < size();i++)
		{
			int left =  2 * i + 1;
			int right = 2 * i + 2;
			int max = i;

			if(left < size() && tab.get(left) > tab.get(max))
				max = left;
			if(right < size() && tab.get(right) > tab.get(max))
				max = right;
			if(max != i)
			{
				Double temp = tab.get(i);
				tab.set(i,tab.get(max));
				tab.set(max,temp);
			}
		}
	}

	public void replace(double value)
	{
		if(size() > 0)
		{
			this.deleteMax();
			this.insert(value);
		}
		else
		{
			this.insert(value);
		}
	}

	public void heapify(ArrayList<Double> list)
	{
		tab.addAll(list);
		this.heapSize = list.size();
		HeapifyMax();
	}

	public void PrintHeap()
	{
		for(Double n : tab)
		{
			System.out.println(n);
		}
		System.out.println("");
	}

}
