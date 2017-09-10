package com.example.codility;

public class SmallestWinter {

	public static void main(String[] args) {
		int temp[] = {5,-2,3,8,6};
		System.out.println(new SmallestWinter().solution(temp));

	}
	
	public int solution(int[] T){
		int result = 0; int split = 0; int max =0;
		for(int i=0; i <T.length; i++){
			for(int j=i+1; j < T.length; j++){
				if(T[i] >= T[j]){
					//continue;
				}else{
					split = j;
					break;
				}
			}
			if(split>max)
			max = split;	
			System.out.println("split:"+split);
			
		}
		/*if(max+1 == T.length){
             max= max-1;			
		}*/
		System.out.println("max:"+max);
		return result;
	}

}
