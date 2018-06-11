package com.web.apps.HelperClasses;
public class WordFromNumber {
	public static void main(String[] args){
		System.err.println(getwordFromNumber(252563));
	}
	public static String getwordFromNumber(int num){
		String words="";
		if(num <= 0) System.out.println("Enter numbers greater than 0");
		else{
			WordFromNumber a = new WordFromNumber();
			words+=a.pw((num/1000000000)," Hundred");
			words+=a.pw((num/10000000)%100," crore");
			words+=a.pw(((num/100000)%100)," lakh");
			words+=a.pw(((num/1000)%100)," thousand");
			words+=a.pw(((num/100)%10)," hundred");
			words+=a.pw((num%100)," ");
		}
		return words;
	}
	public String pw(int n,String ch){
		String word="";
		String one[]={" "," one"," two"," three"," four"," five"," six"," seven"," eight"," Nine"," ten"," eleven"," twelve"," thirteen"," fourteen","fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};
		String ten[]={" "," "," twenty"," thirty"," forty"," fifty"," sixty","seventy"," eighty"," ninety"};
		if(n > 19) word+=ten[n/10]+""+one[n%10];    else word+=one[n];
		if(n > 0)  word+=ch;
		return word;
	}
}