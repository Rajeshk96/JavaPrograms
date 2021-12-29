package com.crm.JavaPrograms;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		boolean isPrime=true;
		
		System.out.println("Enter the number :");
		int a = sc.nextInt();
		
		 if(a<2) {
			 
			 System.out.println("It is not Prime NUmber");  
			 
		 }
		 else {
			 for (int i=2;i<=a/2;i++){
			 
			 if(a%i==0) {
				 isPrime=false;
				 break;
			 }
		 }
		 if(isPrime) {
			 System.out.println("It is a Prime NUmber");
		 }
		 else {
			 System.out.println("It is not Prime NUmber");
		 }
		 }
		 
		 

	}

}
