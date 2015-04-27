import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Integer> input = new ArrayList<Integer> ();
		String line = "";
		
		//reading input into an ArrayList
		try (BufferedReader br =  new BufferedReader (new FileReader("bin/Files/QuickSort.txt"))) {
			line = br.readLine();
			
			while (line != null) {
				input.add(Integer.parseInt(line));
				line = br.readLine();
			}
		}
		
		//List<Integer> input2 = Arrays.asList(3,2);
		quickSort(input, 0, input.size() - 1);
		System.out.println(input);
		
	}
	
	public static void quickSort(List<Integer> input, int lo, int hi)  {
		if (lo >= hi) {
			return; 
		}
		else {
			int pivotIndex = partition(input, lo, hi);
			quickSort(input, lo, pivotIndex - 1);
			quickSort(input, pivotIndex, hi);
		}
		
	}
	
	public static int partition(List<Integer> input, int lo, int hi) {
		
		int pivot = input.get(lo);
		int i = lo + 1;
		int j = lo + 1;
		
		while (j <= hi) {
			if (input.get(j) < pivot) {
				swap(input, i, j);
				i++;
			}
			j++;
		}
		
		// swap the last time
		swap(input, lo, i - 1);
		
		return i;
		
	}
	
	public static void swap(List<Integer> input, int i, int j) {
		int temp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
	}
	
}
