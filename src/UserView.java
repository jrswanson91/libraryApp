import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserView extends ConsoleUserInterface {

	public String menuU() {
		
		this.headerA();
		System.out.println("		%                   USER                        %");
		System.out.println("		%   Enter ___ :                                 %");
		System.out.println("		%                                               %");
		System.out.println("		%      cko   :      Check Out                   %");
		System.out.println("		%                                               %");
		System.out.println("		%      rtn   :      Return                      %");
		System.out.println("		%                                               %");
		System.out.println("		%      src   :      Search                      %");
		System.out.println("		%                                               %");
		System.out.println("		%      bcm   :      Back to Home Screen         %");
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
