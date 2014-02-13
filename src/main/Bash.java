package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bash{

//	private ArrayList<Observer> observers = new ArrayList<Observer>();
//	
//	public void addObserver(Observer o){
//		observers.add(o);
//		System.out.println(observers.size());
//	}
//	
	private String output = "";
	
//	public void update(String out){
//		for(int i = 0;i < observers.size();i++){
//			observers.get(i).update(out);
//		}
//		
//	}
	
	public Bash(){
	}
	
	public String getOutput(){
		return output;
	}
	
	public String getTitle(String url) throws IOException{
		String cmd="youtube-dl --get-title " + url;
	    return runCommandWithOutput(cmd);
	}
	
	private String runCommandWithOutput(String command) throws IOException{
		   Runtime runtime = Runtime.getRuntime();
	       Process process = runtime.exec(command);
	       InputStream is = process.getInputStream();
	       InputStreamReader isr = new InputStreamReader(is);
	       BufferedReader br = new BufferedReader(isr);
	       String line;
	       
	       while ((line = br.readLine()) != null) {
		         output += "\n";
		         output += line;
		         System.out.println(line);
	       }
	       
	       return output;
	       
	}
	

	public void extract_youtube_audio(String url) throws IOException{
		  String cmd="youtube-dl --extract-audio " + url;
	      output = runCommandWithOutput(cmd);
	}
	
	
}