package ui;

import main.Bash;
import controller.MainController;

public class Launcher {

	
	public static void main(String[]args){
		Bash bash = new Bash();
		MainController controller = new MainController(bash);
		Ui ui = new Ui(controller);
	}
		
	
}
