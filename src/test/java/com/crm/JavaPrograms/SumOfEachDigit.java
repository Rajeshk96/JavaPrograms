package com.crm.JavaPrograms;

public class SumOfEachDigit {

	public static void main(String[] args) {
		
		int num = 36;
		
		int sum = 0;
		
		int temp=num;
		
		while(num>0) {
			
			int rem = num%10;
			sum = sum+rem;
			num=num/10;
		}
		
		System.out.println(sum);

	}

}
