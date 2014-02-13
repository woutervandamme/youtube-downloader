package controller;

import java.io.IOException;

import main.Bash;

public class MainController {

	private Bash bash;
	
	public MainController(Bash b){
		bash = b;	
	}
	
	public void extract_audio(String url) throws IOException{
		bash.extract_youtube_audio(url);
	}
	
	public String getOuput(){
		return bash.getOutput();
	}
	
	public String getTitle(String url) throws IOException{
		return bash.getTitle(url);
	}
	
	
}
