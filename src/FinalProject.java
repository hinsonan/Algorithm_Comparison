import java.util.Random;

public class FinalProject {
	
	//creates the variables that will keep up with comparisons and assignments
	static int comparisons = 0;
	static int assignments = 0;
	
	public static void main(String[] args) {
		computeBubbleSort();	
		
		System.out.println(" ");
		System.out.println(" ");
		
		computeInsertionSort();
		
		System.out.println(" ");
		System.out.println(" ");
		
		computeSelectionSort();
		
		System.out.println(" ");
		System.out.println(" ");
		
		computeQuickSort();
		
		System.out.println(" ");
		System.out.println(" ");
		
		computeMergeSort();
		
		
	}//End of main
	
	//gives you an array of n size that is full of random numbers
	private static int[] generateArray(int size){
		int[] array = new int[size];
		Random rand = new Random();		
		for(int i = 0; i < array.length - 1; i++){
			array[i] = rand.nextInt(size * 10);
		}
		return array;
	}//end of GenerateArray
	
	//bubble sort method
	private static void bubbleSort(int[] bubArray){
		//resets the counter variables
		comparisons = 0;
		assignments = 0;
		// make a variable that contains the length of the array since it will used a lot
		int n = bubArray.length;
		// have a temp value so i can swap values with it
        int temp = 0;
        
        // iterates the length of the array
        for(int i=0; i < n; i++){
        	comparisons++;
        	// initializes a swap value to make the algorithm more efficient by not sorting if the array had no swaps
        	int swap = 0;
        	// iterates one less than the array so it doesn't sort the last number because it will already be sorted
        	for(int j=1; j < (n-i); j++){
        		comparisons++;
                // if the value before j is bigger than swap the values        
                if(bubArray[j-1] > bubArray[j]){
                	
                    // swap the numbers
                    temp = bubArray[j-1];
                    bubArray[j-1] = bubArray[j];
                    bubArray[j] = temp;
                    assignments += 3;
                    swap++;
               }
                        
          }
        	// if there are no swaps then exit the loop
        	if(swap == 0){
        		break;
        	}
        }
	}//End of Bubble Sort Method
	
	public static void insertionSort(int[] arr){
        comparisons = 0;
        assignments = 0;
        int temp;
        for (int i = 1; i < arr.length; i++) {
        	comparisons++;
            for(int j = i ; j > 0 ; j--){
            	comparisons++;
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    assignments += 3;
                }
            }
        }        
    }//End of insertionSort
	
	public static void selectionSort(int[] selectArray){
		comparisons = 0;
		assignments = 0;
		int n = selectArray.length;
		
		 for (int i = 0; i < n - 1; i++)
	        {
			 	comparisons++;
			 	//stores the index of the value of i
	            int index = i;
	            for (int j = i + 1; j < n; j++)
	            {
	            	comparisons++;
	            	// if the array at index j is less than the array at index then index = j
	                if (selectArray[j] < selectArray[index]){
	                	comparisons++;
	                	index = j;
	                }
	            }      
	            // this smaller number is equal to the array at index
	            int smallerNumber = selectArray[index]; 
	            // makes the value at index equal value at index i
	            selectArray[index] = selectArray[i];
	            // value at index i will now be the value of the smaller number
	            selectArray[i] = smallerNumber;
	            assignments += 3;
	        }
	        
	    }

	
	 private static void quickSort(int[] arr, int lo, int hi)
	 {
		    /*Quicksort(A[l..r])
			Sorts a subarray by quicksort
			Input: Subarray of arrayA[0..n-1],defined by its left and right
			indiceslandr
			Output: SubarrayA[l..r] sorted in nondecreasing order
				if l<r 
		    		s = Partition(A[l..r])//sis a split position
		    		Quicksort(A[l..s-1])
		    		Quicksort(A[s+1..r])*/
		 
		 if(lo < hi)
		 {
			 int s = hoarePartition(arr, lo, hi);			 
			 quickSort(arr, lo, s );
			 quickSort(arr, s + 1 , hi);
			 
		 }
	 }//End of Quicksort
	
	

	
	public static int hoarePartition(int[] arr, int lo, int hi) {
		  //this other way took some research on manipulating loops but performs much better than my previous code
		  //part of the issues in the code I had was because of the do while loops
		  //with this approach we simplify the algorithm using incrementing arrays within a while loop which cuts down on the code you have to write
		
	      int p = arr[lo];
	      int i = lo - 1;
	      int j = hi + 1;
	      
	      /*So before I had a do while loop and that was causing some of the issues
	      I found out I could make a while loop that is always true
	      so this loop will always run until i >= j
	      the return statement takes you out of the while loop
	      */
	      while (true) {
	    	  
	    	 /* Now these while loops use postfix notation
	    	  * you have to use postfix or else you will get a array out of bounds exception
	    	  * every time these loops are false the variable will increase
	    	  * the loops will stop when a[i] >= pivot or a[j] <= pivot depending on which loop it is
	    	  */ 
	         while (arr[++i] < p)
	        	 comparisons++;	         
	         while (arr[--j] > p)
	        	 assignments++; 
	 
	         if (i >= j) {
	        	 //this breaks out of the while(true) loop
	            return j;
	         }
	         //swaps the values
	         int temp = arr[i];
		     arr[i] = arr[j];
		     arr[j] = temp;
		     assignments+=3;
	      }
	   }//End of Hoare Partition
	
	 public static void mergeSort(int[] arr) {
		 //initialize the size of array
	     int size = arr.length;
	     if (size < 2)
	         return;
	     //gets the middle index of array
	     int mid = size / 2;
	     //left size and right size will now be initialized in order to break the array apart
	     int leftSize = mid;
	     int rightSize = size - mid;
	     //makes an array for the left part
	     int[] left = new int[leftSize];
	     //makes an array for the right part
	     int[] right = new int[rightSize];
	     //these next 2 for loops fill the array with the correct numbers from the original array
	     for (int i = 0; i < mid; i++) {
	         left[i] = arr[i];
	         assignments++;

	     }
	     for (int i = mid; i < size; i++) {
	         right[i - mid] = arr[i];
	         assignments++;
	     }
	     mergeSort(left);
	     mergeSort(right);
	     merge(left, right, arr);
	    }

	    public static void merge(int[] left, int[] right, int[] arr) {
	    	//get the length of the arrays
	        int leftSize = left.length;
	        int rightSize = right.length;
	        int i = 0, j = 0, k = 0;
	        //this loop will put the numbers in the correct order 
	        while (i < leftSize && j < rightSize) {
	            if (left[i] <= right[j]) {
	            	comparisons++;
	                arr[k] = left[i];
	                assignments++;
	                i++;
	                k++;
	            } else {
	                arr[k] = right[j];
	                comparisons++;
	                assignments++;
	                k++;
	                j++;
	            }
	        }
	        while (i < leftSize) {
	            arr[k] = left[i];
	            assignments++;
	            k++;
	            i++;
	        }
	        while (j < leftSize) {
	            arr[k] = right[j];
	            assignments++;
	            k++;
	            j++;
	        }
	    }
	
	private static void printElementsInArray(int[] arr){
		 //prints the elements in array
        for(int i = 0; i < arr.length ; i++ ){
			if (i % 20 == 0 && i > 0)
			{
				System.out.println();
			}
			
			System.out.print(arr[i] + " ");
		}
	}//End of printElementInArray
	public static void printComparisonsAndAssignments(String nameOfAlgorithm, int sizeOfArray){
		System.out.print("\nFor " +nameOfAlgorithm+  " at array size " + sizeOfArray+ "\n"
				+ "Comparisons: " + comparisons + "\n"
				+ "Assignments: " + assignments);
	}//End of printComparisonsAndAssignments
	
	//this method will compute the comparisons and assignments
	public static void computeBubbleSort(){
		//initializes the variables to keep up with the average
		int compareAvgHundred = 0, assignAvgHundred = 0, compareAvgThousand = 0, assignAvgThousand =0, compareAvgTenThousand = 0, assignAvgTenThousand = 0;
		
		System.out.print("Bubble Sort \t 100 \t\t1000 \t\t 10000\n");
		//controls the while loop
		int loopcount = 1;
		while(loopcount <= 5)
		{
			int[] arrayHundred = generateArray(100);
			int[] arrayThousand = generateArray(1000);
			int[] arrayTenThousand = generateArray(10000);
			//this array will keep track of the comparisons and assignments
			int[] compare = new int[3];
			int[] assign = new int[3];
			
			bubbleSort(arrayHundred);
			
			compare[0] = comparisons;
			assign[0] = assignments;
			
			compareAvgHundred += comparisons;
			assignAvgHundred += assignments;
			
			bubbleSort(arrayThousand);
			
			compare[1] = comparisons;
			assign[1] = assignments;
			
			compareAvgThousand += comparisons;
			assignAvgThousand += assignments;
			
			
			bubbleSort(arrayTenThousand);
			
			compare[2] = comparisons;
			assign[2] = assignments;
			
			compareAvgTenThousand += comparisons;
			assignAvgTenThousand += assignments;
			
			System.out.print(loopcount+ "\t      " + compare[0]+ "/" + assign[0]+ "\t   "+compare[1]
							+"/"+ assign[1]+ "   "+ compare[2]+ "/"+ assign[2] +"\n");
			
			loopcount++;
			
		}
		System.out.print("Avg\t      " + compareAvgHundred/5 + "/" + assignAvgHundred/5 + "\t   " + compareAvgThousand/5 + "/" + assignAvgThousand/5
				+ "   " + compareAvgTenThousand/5 + "/" + assignAvgTenThousand/5);		
		
				
	}//End of computeBubbleSort
	
	public static void computeInsertionSort(){
		//initializes the variables to keep up with the average
		int compareAvgHundred = 0, assignAvgHundred = 0, compareAvgThousand = 0, assignAvgThousand =0, compareAvgTenThousand = 0, assignAvgTenThousand = 0;
		
		System.out.print("Insertion Sort \t 100 \t\t1000 \t\t 10000\n");
		//controls the while loop
		int loopcount = 1;
		while(loopcount <= 5)
		{
			int[] arrayHundred = generateArray(100);
			int[] arrayThousand = generateArray(1000);
			int[] arrayTenThousand = generateArray(10000);
			//this array will keep track of the comparisons and assignments
			int[] compare = new int[3];
			int[] assign = new int[3];
			
			insertionSort(arrayHundred);
			
			compare[0] = comparisons;
			assign[0] = assignments;
			
			compareAvgHundred += comparisons;
			assignAvgHundred += assignments;
			
			insertionSort(arrayThousand);
			
			compare[1] = comparisons;
			assign[1] = assignments;
			
			compareAvgThousand += comparisons;
			assignAvgThousand += assignments;
			
			
			insertionSort(arrayTenThousand);
			
			compare[2] = comparisons;
			assign[2] = assignments;
			
			compareAvgTenThousand += comparisons;
			assignAvgTenThousand += assignments;
			
			System.out.print(loopcount+ "\t      " + compare[0]+ "/" + assign[0]+ "\t   "+compare[1]
							+"/"+ assign[1]+ "   "+ compare[2]+ "/"+ assign[2] +"\n");
			
			loopcount++;
			
		}
		System.out.print("Avg\t      " + compareAvgHundred/5 + "/" + assignAvgHundred/5 + "\t   " + compareAvgThousand/5 + "/" + assignAvgThousand/5
				+ "   " + compareAvgTenThousand/5 + "/" + assignAvgTenThousand/5);		
		
				
	}//End of computeInsertionSort
	public static void computeSelectionSort(){
		//initializes the variables to keep up with the average
		int compareAvgHundred = 0, assignAvgHundred = 0, compareAvgThousand = 0, assignAvgThousand =0, compareAvgTenThousand = 0, assignAvgTenThousand = 0;
		
		System.out.print("Selection Sort \t 100 \t\t1000 \t\t 10000\n");
		//controls the while loop
		int loopcount = 1;
		while(loopcount <= 5)
		{
			int[] arrayHundred = generateArray(100);
			int[] arrayThousand = generateArray(1000);
			int[] arrayTenThousand = generateArray(10000);
			//this array will keep track of the comparisons and assignments
			int[] compare = new int[3];
			int[] assign = new int[3];
			
			selectionSort(arrayHundred);
			
			compare[0] = comparisons;
			assign[0] = assignments;
			
			compareAvgHundred += comparisons;
			assignAvgHundred += assignments;
			
			selectionSort(arrayThousand);
			
			compare[1] = comparisons;
			assign[1] = assignments;
			
			compareAvgThousand += comparisons;
			assignAvgThousand += assignments;
			
			
			selectionSort(arrayTenThousand);
			
			compare[2] = comparisons;
			assign[2] = assignments;
			
			compareAvgTenThousand += comparisons;
			assignAvgTenThousand += assignments;
			
			System.out.print(loopcount+ "\t      " + compare[0]+ "/" + assign[0]+ "\t     "+compare[1]
							+"/"+ assign[1]+ "      "+ compare[2]+ "/"+ assign[2] +"\n");
			
			loopcount++;
			
		}
		System.out.print("Avg\t      " + compareAvgHundred/5 + "/" + assignAvgHundred/5 + "\t     " + compareAvgThousand/5 + "/" + assignAvgThousand/5
				+ "      " + compareAvgTenThousand/5 + "/" + assignAvgTenThousand/5);		
		
				
	}//End of computeSelectionSort
	
	public static void computeQuickSort(){
		//initializes the variables to keep up with the average
		int compareAvgHundred = 0, assignAvgHundred = 0, compareAvgThousand = 0, assignAvgThousand =0,
				compareAvgTenThousand = 0, assignAvgTenThousand = 0, compareAvgHundredThousand = 0, assignAvgHundredThousand = 0,
				compareAvgMillion = 0, assignAvgMillion = 0;
		
		System.out.print("Quick Sort \t 100 \t      1000 \t    10000\t     100000 \t     1000000\n");
		//controls the while loop
		int loopcount = 1;
		while(loopcount <= 5)
		{
			int[] arrayHundred = generateArray(100);
			int[] arrayThousand = generateArray(1000);
			int[] arrayTenThousand = generateArray(10000);
			int[] arrayHundredThousand = generateArray(100000);
			int[] arrayMillion = generateArray(1000000);
			//this array will keep track of the comparisons and assignments
			int[] compare = new int[5];
			int[] assign = new int[5];
			
			comparisons = 0;
			assignments = 0;			
			quickSort(arrayHundred, 0, 99);
			
			compare[0] = comparisons;
			assign[0] = assignments;
			
			compareAvgHundred += comparisons;
			assignAvgHundred += assignments;
			
			comparisons = 0;
			assignments = 0;			
			quickSort(arrayThousand, 0, 999);
			
			compare[1] = comparisons;
			assign[1] = assignments;
			
			compareAvgThousand += comparisons;
			assignAvgThousand += assignments;
			
			comparisons = 0;
			assignments = 0;
			quickSort(arrayTenThousand, 0, 9999);
			
			compare[2] = comparisons;
			assign[2] = assignments;
			
			compareAvgTenThousand += comparisons;
			assignAvgTenThousand += assignments;
			
			comparisons = 0;
			assignments = 0;
			quickSort(arrayHundredThousand, 0, 99999);
			
			compare[3] = comparisons;
			assign[3] = assignments;
			
			compareAvgHundredThousand += comparisons;
			assignAvgHundredThousand += assignments;
			
			comparisons = 0;
			assignments = 0;
			quickSort(arrayMillion, 0, 999999);
			
			compare[4] = comparisons;
			assign[4] = assignments;
			
			compareAvgMillion += comparisons;
			assignAvgMillion += assignments;
			
			System.out.print(loopcount+ "\t       " + compare[0]+ "/" + assign[0]+ "\t   "+compare[1]
							+"/"+ assign[1]+ "   "+ compare[2]+ "/"+ assign[2] + "\t " + compare[3] + "/" + assign[3] +
							"\t " + compare[4] + "/" + assign[4] + "\n");
			
			loopcount++;
			
		}
		System.out.print("Avg\t       " + compareAvgHundred/5 + "/" + assignAvgHundred/5 + "\t   " + compareAvgThousand/5 + "/" + assignAvgThousand/5
				+ "   " + compareAvgTenThousand/5 + "/" + assignAvgTenThousand/5 + "     " + compareAvgHundredThousand/5 + "/" + 
				assignAvgHundredThousand/5 + "  " + compareAvgMillion/5 + "/" + assignAvgMillion/5);		
		 
				
	}//End of computeQuickSort
	
	public static void computeMergeSort(){
		//initializes the variables to keep up with the average
		int compareAvgHundred = 0, assignAvgHundred = 0, compareAvgThousand = 0, assignAvgThousand =0,
				compareAvgTenThousand = 0, assignAvgTenThousand = 0, compareAvgHundredThousand = 0, assignAvgHundredThousand = 0,
				compareAvgMillion = 0, assignAvgMillion = 0;
		
		System.out.print("Merge Sort \t 100 \t      1000 \t    10000\t     100000 \t        1000000\n");
		//controls the while loop
		int loopcount = 1;
		while(loopcount <= 5)
		{
			int[] arrayHundred = generateArray(100);
			int[] arrayThousand = generateArray(1000);
			int[] arrayTenThousand = generateArray(10000);
			int[] arrayHundredThousand = generateArray(100000);
			int[] arrayMillion = generateArray(1000000);
			//this array will keep track of the comparisons and assignments
			int[] compare = new int[5];
			int[] assign = new int[5];
			
			comparisons = 0;
			assignments = 0;			
			mergeSort(arrayHundred);
			
			compare[0] = comparisons;
			assign[0] = assignments;
			
			compareAvgHundred += comparisons;
			assignAvgHundred += assignments;
			
			comparisons = 0;
			assignments = 0;			
			mergeSort(arrayThousand);
			
			compare[1] = comparisons;
			assign[1] = assignments;
			
			compareAvgThousand += comparisons;
			assignAvgThousand += assignments;
			
			comparisons = 0;
			assignments = 0;
			mergeSort(arrayTenThousand);
			
			compare[2] = comparisons;
			assign[2] = assignments;
			
			compareAvgTenThousand += comparisons;
			assignAvgTenThousand += assignments;
			
			comparisons = 0;
			assignments = 0;
			mergeSort(arrayHundredThousand);
			
			compare[3] = comparisons;
			assign[3] = assignments;
			
			compareAvgHundredThousand += comparisons;
			assignAvgHundredThousand += assignments;
			
			comparisons = 0;
			assignments = 0;
			mergeSort(arrayMillion);
			
			compare[4] = comparisons;
			assign[4] = assignments;
			
			compareAvgMillion += comparisons;
			assignAvgMillion += assignments;
			
			System.out.print(loopcount+ "\t       " + compare[0]+ "/" + assign[0]+ "\t   "+compare[1]
							+"/"+ assign[1]+ "   "+ compare[2]+ "/"+ assign[2] + "\t " + compare[3] + "/" + assign[3] +
							"    " + compare[4] + "/" + assign[4] + "\n");
			
			loopcount++;
			
		}
		System.out.print("Avg\t       " + compareAvgHundred/5 + "/" + assignAvgHundred/5 + "\t   " + compareAvgThousand/5 + "/" + assignAvgThousand/5
				+ "   " + compareAvgTenThousand/5 + "/" + assignAvgTenThousand/5 + "    " + compareAvgHundredThousand/5 + "/" + 
				assignAvgHundredThousand/5 + "    " + compareAvgMillion/5 + "/" + assignAvgMillion/5);		
		 
				
	}//End of computeMergeSort
	
	


}
