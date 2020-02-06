package com.roger.utils;

	class Test2
	{
		//To Reverse a String
		public static String reverse(String str){
			String reversed="";
			char[] localStr=str.toCharArray();
			for(char c : localStr){
				reversed=c+reversed;
			}
			return reversed;
		}
		
			//To check if string is palindrome
		   public static  boolean isPalindrome(String s){
			   boolean flag=true;
			   int i=0,j=s.length()-1;
			   while(i<j){
				   if(s.charAt(i)!=s.charAt(j)){
					   flag=false;
					   return flag;
				   }
				   i++;j--;
			   }
			   return flag;
		   }
		   
		   public static boolean isPrimeNumber(int num){
				   boolean flag=true;
				   for(int i=2;i<num/2;i++){
					   if(i==0 || i==1){
						   break;			   
						   }
					   if(num%i==0){
					   flag=false;
					   break;
					   }
				   if(flag){
				   }
			   }
			   return flag;
		   }
	   public static void main(String [] args)
	   {
		   //Palindrome
		  String s="palindrome";
		  if(Test2.isPalindrome(s)){System.out.println("YES");}else{System.out.println("NO");}
		  //PrimenNumber
		  int num=7;
		  if(Test2.isPrimeNumber(num)){System.out.println("YES");}else{System.out.println("NO");
		  }
		  System.out.println(Test2.reverse("MENDES"));
		  
	   }
	}