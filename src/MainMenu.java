import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainMenu extends ConsoleUserInterface {

	public String menuM() {
		String userIn = "hello";
		try{

			this.headerA();
	    	System.out.println("		%                 Main Menu                     %");
	    	System.out.println("		%   Enter ___ :                                 %");
	    	System.out.println("		%                                               %");
	    	System.out.println("		%      usr   :      User                        %");
	    	System.out.println("		%             - Checkout, Return, or Search     %");
	    	System.out.println("		%                                               %");
	    	System.out.println("		%      adm   :      Admin                       %");
	    	System.out.println("		%             - Add/Remove User, Display Users  %");
	    	System.out.println("		%                                               %");
	    	System.out.println("		%      lib   :      Librarian                   %");
	    	System.out.println("		%             - Add Document, Transactions      %");
	    	System.out.println("		%                                               %");
	    	System.out.println("		%      ext   :      Exit and Save               %");
	    	System.out.println("		%                                               %");
	    	System.out.println("		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
	    	
	    	InputStreamReader isr = new InputStreamReader(System.in);
	    	BufferedReader bR = new BufferedReader(isr);
	    	System.out.print(">>>");
	    	
        	userIn = bR.readLine();	
    	}catch(IOException e){
    		System.out.println("Could not read from line~ ");
    	}
		return userIn;
	}

}
