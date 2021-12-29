package com.crm.JavaPrograms;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		int num = 112;
		int temp=num;
		int rev=0;
		while(num>0) {
			int rem = num%10;
			rev = (rev*10)+rem;
			num=num/10;
		}
		if(temp==rev) {
			System.out.println("The given number "+temp+" is PALINDROME");
		}
		else{
			System.out.println("The given number "+temp+" is not PALINDROME");
		}

	}

}

