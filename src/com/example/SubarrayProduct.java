package com.example;

public class SubarrayProduct {
	public static void main(String[] args) {
		int[] array = {1,2,3};
		int maxProduct = 4;
		//System.out.println(numSubarraysWithMaxProductSlidingWindow(array, maxProduct));
		System.out.println(numSubarraysWithMaxProductBruteForce(array, maxProduct));
		//System.out.println(count(array, maxProduct));
	}

	static int[] getNewArray(int[] numbers){
	       int[] targetArray = new int[numbers.length-2];int counter=0;
	       for(int i=0; i < numbers.length; i++){
	           if(i !=0 && (i != (numbers.length -1) )) {
	             targetArray[counter] = numbers[i];
	             counter++;
	           }
	       }
	       return targetArray;                 
	   }
	
	public static int numSubarraysWithMaxProductSlidingWindow(int[] array, int maxProduct) {
		if (array == null) {
			throw new IllegalArgumentException("Array cannot be null!");
		}

		int n = array.length;
		int numSubarraysWithMaxProduct = 0;
		int product = 1;

		for (int left = 0, right = -1; left < n; ++left) {
			// I have rewritten
			// "product * array[right + 1] < maxProduct"
			// as
			// "array[right + 1] < Math.ceil((double)maxProduct / product)"
			// to avoid the overflow that can result from multiplication.
			while (right + 1 < n && array[right + 1] < Math.ceil((double) maxProduct / product)) {
				product *= array[++right];
			}

			int subarraySize = right - left + 1;
			numSubarraysWithMaxProduct += subarraySize;

			product /= array[left];
		}

		return numSubarraysWithMaxProduct;
	}

	public static int numSubarraysWithMaxProductBruteForce(int[] array, int maxProduct) {
		if (array == null) {
			throw new IllegalArgumentException("Array cannot be null!");
		}

		int n = array.length;
		int numSubarraysWithMaxProduct = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				int product = 1;

				for (int k = i; k <= j; ++k) {
					product *= array[k];
				}

				if (product < maxProduct) {
					++numSubarraysWithMaxProduct;
				} else {
					break;
				}
			}
		}

		return numSubarraysWithMaxProduct;
	}
	
	static long count(int[] numbers, int k) {
        
		numbers = getNewArray(numbers);
        for(int q :numbers){
            System.out.println("q:"+q);
        }
		if (numbers == null) {
			throw new IllegalArgumentException("Array cannot be null!");
		}
       int []newNumbers = new int[numbers.length-2];
       int counter=0;
       for(int p=1; p <numbers.length-1; p++){
           newNumbers[counter] = numbers[p];
           counter++;
       }
       k= numbers[numbers.length-1];
		int n = newNumbers.length;
		int numSubarraysWithMaxProduct = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				int product = 1;

				for (int l = i; l <= j; ++l) {
					product *= newNumbers[l];
				}

				if (product < k) {
					++numSubarraysWithMaxProduct;
				} else {
					break;
				}
			}
		}

		return numSubarraysWithMaxProduct;
   }


}
