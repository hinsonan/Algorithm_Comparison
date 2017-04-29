import java.util.Random;

public class FinalProject {
	
	//creates the variables that will keep up with comparisons and assignments
	static int comparisons = 0;
	static int assignments = 0;
	
	public static void main(String[] args) {
		computeBubbleSort();	
		
		
		
		
	}//End of main
	
	//gives you an array of n size that is full of random numbers
	private static int[] generateArray(int size){
		int[] array = new int[size];
		Random rand = new Random();		
		for(int i = 0; i < array.length - 1; i++){
			array[i] = rand.nextInt(size * 2);
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
	         while (arr[++i] < p); 
	         while (arr[--j] > p); 
	 
	         if (i >= j) {
	        	 //this breaks out of the while(true) loop
	            return j;
	         }
	         //swaps the values
	         int temp = arr[i];
		     arr[i] = arr[j];
		     arr[j] = temp;
	      }
	   }//End of Hoare Partition
	
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
		int compareAvgHundred = 0, assignAvgHundred = 0, compareAvgThousand = 0, assignAvgThousand =0, compareAvgTenThousand = 0, assignAvgTenThousand = 0;
		
		int i = 0;
		
		System.out.print("Bubble Sort \t 100 \t\t1000 \t\t 10000\n");
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

}
