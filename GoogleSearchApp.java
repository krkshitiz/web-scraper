package com.google.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Keyword 
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the Keyword");
       String keyword = sc.nextLine();
       
       //search over your preferred search engine
       String url = "https://www.google.com/search" + "?q=" + keyword + "&num=100";

       Document doc = Jsoup.connect(url).get();
       
       String html = doc.html();
       
       Files.write(Paths.get("D:\\Java Programs\\GoogleSearchAPI\\file.txt"), html.getBytes());
        
       Elements links = doc.select("cite");
       
       for (Element link : links) 
       {
    	   String text = link.text();
    	   if(text.contains(">"))
    	   {
    		   text = text.replaceAll(" > ", "/");
    	   }
    	   else
    	   {	   
    	   System.out.println(link.text());
    	   }
       }
       
    		   sc.close();
	}

} 
