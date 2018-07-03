package com.web.apps.HelperClasses;
import java.util.HashMap;
import java.util.Map;
public class CollectionProgram {
	public static void main(String[] args) {
		findDuplicateString("MYNAMEISRAMWHATSYOURNAME");
		findDuplicateWord("MY NAME IS RAM WHAT IS YOUR NAME");
	}

	public static void findDuplicateString(String s){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++){
		  char c = s.charAt(i);
		  if (map.containsKey(c)){
		    int cnt = map.get(c);//taking value(count for that string) based on key
		    map.put(c, ++cnt);
		  }else{
		    map.put(c, 1);
		  }
		}
		System.out.println("Count of letters in String \nmap="+map);
	}
	
	public static void findDuplicateWord(String s){
		String[] words=s.split(" ");
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < words.length; i++){
		  String word = words[i];
		  if (map.containsKey(word)){
		    int cnt = map.get(word);//taking value(count for that string) based on key
		    map.put(word, ++cnt);
		  }else{
		    map.put(word, 1);
		  }
		}
		System.out.println("Count of Words in sentence \nmap="+map);
	}
}