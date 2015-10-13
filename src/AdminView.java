import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AdminView extends ConsoleUserInterface {

	public String menuA() {

		this.headerA();
		System.out.println("		%                  Admin                        %");
		System.out.println("		%   Enter ___ :                                 %");
		System.out.println("		%                                               %");
		System.out.println("		%      ads   :      Add Student                 %");
		System.out.println("		%                                               %");
		System.out.println("		%      adf   :      Add Faculty                 %");
		System.out.println("		%                                               %");
		System.out.println("		%      dst   :      Display Students            %");
		System.out.println("		%                                               %");
		System.out.println("		%      dfy   :      Display Faculty             %");
		System.out.println("		%                                               %");
		System.out.println("		%      rst   :      Remove Student              %");
		System.out.println("		%                                               %");
		System.out.println("		%      rdf   :      Remove Faculty              %");
		System.out.println("		%                                               %");
		System.out.println("		%      bcm   :      Back to Menu Screen         %");
		System.out.println("		%                                               %");
		System.out.println("		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
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
