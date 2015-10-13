import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CheckOutView extends ConsoleUserInterface {

	public String menuC() {
		String userIn = "hello";
		try{

			this.headerA();
    		System.out.println("		%                   Ckeck Out                   %");
    		System.out.println("		%   Enter ___ :                                 %");
    		System.out.println("		%                                               %");
    		System.out.println("		%      fac   :        Faculty                   %");
    		System.out.println("		%                                               %");
    		System.out.println("		%      stu   :        Student                   %");
    		System.out.println("		%                                               %");
    		System.out.println("		%      bcu   :        Back                      %");
    		System.out.println("		%                                               %");
    		System.out.println("		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
    		System.out.print(">>>");
			InputStreamReader isr = new InputStreamReader(System.in);
	    	BufferedReader bR = new BufferedReader(isr);
	    	userIn = bR.readLine();
		}catch(IOException e){
			System.out.println("Could not read from line~ ");
		}
		return userIn;
	}
	

}
