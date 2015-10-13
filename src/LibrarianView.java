import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LibrarianView extends ConsoleUserInterface {

	public String menuL() {

		this.headerA();
		System.out.println("		%                  Librarian                    %");
		System.out.println("		%   Enter ___ :                                 %");
		System.out.println("		%                                               %");
		System.out.println("		%      adb   :      Add Book                    %");
		System.out.println("		%                                               %");
		System.out.println("		%      adj   :      Add Journal                 %");
		System.out.println("		%                                               %");
		System.out.println("		%      dbk   :      Display Books               %");
		System.out.println("		%                                               %");
		System.out.println("		%      djl   :      Display Journals            %");
		System.out.println("		%                                               %");
		System.out.println("		%      dtr   :      Display Transactions        %");
		System.out.println("		%                                               %");
		System.out.println("		%      bcm   :      Back to Main Screen         %");
		System.out.println("		%                                               %");
		System.out.println("		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
    	System.out.print(">>>");
    	InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader bR = new BufferedReader(isr);
    	System.out.print(">>>");
    	String userIn = null;
    	try{
        	userIn = bR.readLine();	
    	}catch(IOException e){
    		System.out.println("Could not read from line~ ");
    	}
		return userIn;
	}
	

}
