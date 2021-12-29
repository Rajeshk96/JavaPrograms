package com.crm.JavaPrograms;

import java.util.Scanner;

public class FibonacciNumber {

	public static void main(String[] args) {
		
	/*
		int num1 = 0;
		int num2 = 1;
		
		System.out.print(num1+" ");
		System.out.print(num2+" ");
		
		for(int i=0;i<3;i++) {
			
			int num3;
		
			num3 = num1 + num2;
			
			System.out.print(num3+" ");
			
			num1=num2;
			num2=num3;
		*/
		
		int num1 = 0;
		int num2 = 1;
		
		System.out.print(num1+" ");
		System.out.print(num2+" ");
		
		for(int i=0;i<10;i++) {
			
			int num3;
		
			num3 = num1 + num2;
			if(num3>=25) {
				break;
			}
			
			System.out.print(num3+" ");
			
			num1=num2;
			num2=num3;
		
			
		}

	}

}
