import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Jack
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Library{
	//declare counts, objects, and input string 

	static public List<Map> list = new ArrayList<Map>();
	static public Map<Integer, Book> books = new HashMap<Integer, Book>();
	static public Map<Integer, Journal> journals = new HashMap<Integer, Journal>();
	static public Map<Integer, Faculty> faculty = new HashMap<Integer, Faculty>();
	static public Map<Integer, Student> students = new HashMap<Integer, Student>();
	static public Map<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
	static public Book bb;
	static public Journal jj;
	static public Student ss;
	static public Faculty ff;
	static public Transaction tt;
/*	static Book[] bbb = new Book[100];
	static Journal[] jjj = new Journal[100];
	static Faculty[] fff = new Faculty[100];
	static Student[] sss = new Student[100];
	static Transaction[] ttt = new Transaction[100];*/
	static UserView userFace = new UserView();
	static AdminView adminFace = new AdminView();
	static LibrarianView libFace = new LibrarianView();
	static ReturnView returnFace = new ReturnView();
	static CheckOutView ckoFace = new CheckOutView();
	static MainMenu mainFace = new MainMenu();
	static public int bookcount, journalcount, studentcount, facultycount, transactioncount = 0;
	static public String userinput, user2input;
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader bR = new BufferedReader(isr);
	
	public static void main(String[] args) throws IOException, ConcurrentModificationException, IndexOutOfBoundsException, NullPointerException, ParseException, ArrayIndexOutOfBoundsException, FileNotFoundException{
		
		//read inList of Hash Maps and put objects into correct positions from serialized file
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("simplibFile.ser");
		    ois = new ObjectInputStream(fis);

		    list = (ArrayList) ois.readObject();
		    
		    /*for (Map o: list)
			  System.out.println(o.toString());*/
			    
		    books = list.get(0);
		    journals = list.get(1);
		    faculty = list.get(2);
		    students = list.get(3);
		    transactions = list.get(8);
		    
		    int greatest = 0;
		    for (int id: books.keySet()){
		    	greatest = id;
		    }
		    bookcount = greatest + 1;
		    for (int id: journals.keySet()){
		    	greatest = id;
		    }
		    journalcount = greatest + 1;
		    for (int id: faculty.keySet()){
			    greatest = id;
			}
		    facultycount = greatest + 1;
	    	for (int id: students.keySet()){
		    	greatest = id;
		    }
		    studentcount = greatest + 1;
	    	for (int id: transactions.keySet()){
		    	greatest = id;
		    }
		    transactioncount = greatest + 1;

		} catch (IOException ioe) {
			System.out.println("Error: " + ioe);
		}catch (IndexOutOfBoundsException e){
			System.out.println("missing transactions");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error: " + cnfe);
		}finally {
            fis.close();
            
        }
        
		/*
		 * 
		bookcount = 0;
		BufferedReader br = null;
        try {
        	br = new BufferedReader(new FileReader("books.txt"));
        	String current;
        	while ((current = br.readLine()) != null) {
        		String[] input = current.split("		");
        		int temp = Integer.parseInt(input[4]);
        		bb = new Book(input[0], input[1], input[2], input[3], temp, input[5]);
        		books.put(bookcount, bb);
        		bookcount++;
        	}
        }catch(IOException E){
        	//E.printStackTrace();
        	System.out.println("books.txt file not found! Input books as Staff user.");
        }
        
        //read in to journals object
        journalcount = 0;
        br = null;
        try {
    		br = new BufferedReader(new FileReader("journals.txt"));
    		String current;
    		while ((current = br.readLine()) != null) {
    			String[] input = current.split("		");
    			int temp = Integer.parseInt(input[2]);
    			int temp1 = Integer.parseInt(input[3]);
    			jj = new Journal(input[0], input[1], temp, temp1, input[4]);
    			journals.put(journalcount, jj);
    			journalcount++;
    		}
        }catch(IOException E){
             //E.printStackTrace();
        	System.out.println("journals.txt file not found! Input journals as Staff user.");
        }
        
        //read in to faculty object
        facultycount = 0; 
        br = null;
        try{
        	br = new BufferedReader(new FileReader("faculty.txt"));
        	String current;
        	while((current = br.readLine()) != null) {
        		String[] input = current.split ("		");
    			int temp = Integer.parseInt(input[1]);
    			int temp1 = Integer.parseInt(input[2]);
    			ff = new Faculty(input[0], temp, temp1, 12);
    			faculty.put(facultycount, ff);
    			facultycount++;
        	}
        }catch(IOException E){
             //E.printStackTrace();
        	System.out.println("faculty.txt file not found! Input faculty as Staff user.");
        }
        
        //read in to students object
        studentcount = 0; 
        br = null;
        try{
        	br = new BufferedReader(new FileReader("students.txt"));
        	String current;
        	while((current = br.readLine()) != null) {
        		String[] input = current.split ("		");
    			int temp = Integer.parseInt(input[1]);
    			int temp1 = Integer.parseInt(input[2]);
    			ss = new Student(input[0], temp, temp1, 6);
    			students.put(studentcount, ss);
    			studentcount++;
        	}
        }catch(IOException E){
             //E.printStackTrace();
        	System.out.println("students.txt file not found! Input students as Staff user.");
        }
        
        //read in to transaction object
        transactioncount = 0; 
        br = null;
        try{
        	br = new BufferedReader(new FileReader("transactions.txt"));
        	String current;
        	while((current = br.readLine()) != null) {
        		String[] input = current.split ("	");
        		SimpleDateFormat format= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        		Date outd = format.parse(input[2]);
				Date dued = format.parse(input[3]);
				tt = new Transaction(input[1], outd, dued, input[0], input[4]);
				transactions.put(transactioncount, tt);
				transactioncount++;
        	}
        }catch(IOException E){
             //E.printStackTrace();
        	System.out.println("transactions.txt file not found! Input faculty as Staff user.");
        }
        */
		
        userinput = " ";
        //Main Menu
        while(!(userinput.equals("ext"))){
        	//mainmenu;
        	userinput = mainFace.menuM();
        	if(userinput.equals("usr")){
        		//UserMenu
        		while(!(userinput.equals("bcm"))){
        			userinput = userFace.menuU();
                    	//checkout
                    	if(userinput.equals("cko")){
                    		checkout();
                    	//return
                    	}else if(userinput.equals("rtn")){
                    		retturn();
                    	//search
                    	}else if(userinput.equals("src")){
                    		search();
                    	}else if(userinput.equals("bcm")){
                    		break;
                    	}else{
               				System.out.println("incorrect input try again");
               			}
        			}
            }else if(userinput.equals("adm")){
            		//admin view
            	boolean idtaken = false;
            	while(!userinput.equals("bcm")){
            		userinput = adminFace.menuA();
            		if(userinput.equals("ads")){
            			String name = null;
            			int id = 0, itemsout = 0;
            			
            			System.out.print("Name: ");
            			try{
            				user2input = bR.readLine();
            				name = user2input;
            			}catch(IOException e){
                    		System.out.println("Could not read from line~ ");
            			}
            			System.out.print("ID: ");
            			try{
            				user2input = bR.readLine();
            				int temp = Integer.parseInt(user2input);
            				for(int idx: students.keySet()){
            					ss = students.get(idx);
            					if(ss.getId() == temp){
            						System.out.println("id taken! try again");
            						idtaken = true;
            						break;
            					}
            				}if (idtaken == true){
            					break;
            				}else{
            					id = temp;
            				}
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				System.out.print("Items Out: ");
           				try{
           					user2input = bR.readLine();
           					int temp = Integer.parseInt(user2input);
           					itemsout = temp;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				ss = new Student(name, id, itemsout, 6);
           				students.put(studentcount, ss);
           				System.out.println("Student Added! \n");
               			studentcount ++;
           			}else if(userinput.equals("adf")){
            			String name = null;
            			int id = 0, itemsout = 0;
           				
           				System.out.print("Name: ");
           				try{
           					user2input = bR.readLine();
           					name = user2input;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				System.out.print("ID: ");
           				try{
           					user2input = bR.readLine();
           					int temp = Integer.parseInt(user2input);
           					for(int idx: faculty.keySet()){
            					ff = faculty.get(idx);
            					if(ff.getId() == temp){
            						System.out.println("id taken! try again");
            						idtaken = true;
            						break;
            					}
            				}if (idtaken == true){
            					break;
            				}else{
            					id = temp;
            				}
           					
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
            			System.out.print("Items Out: ");
            			try{
            				user2input = bR.readLine();
            				int temp = Integer.parseInt(user2input);
           					itemsout = temp;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				ff = new Faculty(name, id, itemsout, 12);
           				faculty.put(facultycount, ff);
           				System.out.println("Faculty Member Added!\n");
               			facultycount ++;
           			
           			}else if(userinput.equals("dst")){
           				System.out.println("Name     ID         Items Out        Max Items Out\n");
           				for (int id : students.keySet()) {
               				ss = students.get(id);
               				ss.display();
               			}
           			}else if(userinput.equals("dfy")){
           				System.out.println("Name     ID       Items Out         Max Items Out\n");
           				for (int id : faculty.keySet()) {
           					ff = faculty.get(id);
                    		ff.display();
                    		
                    	}
            		}else if(userinput.equals("rst")){
            			System.out.print("Name of Student to remove: ");
           				try{
           					user2input = bR.readLine();
           					Iterator it = students.keySet().iterator();
    						while(it.hasNext()){
    							ss = students.get(it.next());
    							if(ss.getName().equals(user2input)){
    								it.remove();
        							System.out.println("Successfully removed:");
        							ss.display();
    							}
    						}
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
            			
            		}else if(userinput.equals("rdf")){
            			System.out.print("Name of faculty member to remove: ");
           				try{
           					user2input = bR.readLine();
           					Iterator it = faculty.keySet().iterator();
    						while(it.hasNext()){
    							ff = faculty.get(it.next());
    							if(ff.getName().equals(user2input)){
    								it.remove();
        							System.out.println("Successfully removed:");
        							ff.display();
    							}
    						}
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           			}else if(userinput.equals("bcm")){
           				break;
           			}else{
           				System.out.println("incorrect input try again");
           			}
           		}
            }else if(userinput.equals("lib")){
            	//librarian view
            	while(!userinput.equals("bcm")){
            		userinput = libFace.menuL();
            		if(userinput.equals("adb")){
            			String title = null, publisher = null, pdate = null, ISBN = null, author = null;
           				int ncopies = 0;
           				
           				System.out.print("Title: ");
           				try{
           					user2input = bR.readLine();
           					title = user2input;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				System.out.print("Publisher: ");
           				try{
            				user2input = bR.readLine();
            				publisher = user2input;
            			}catch(IOException e){
                       			System.out.println("Could not read from line~ ");
                		}
            			System.out.print("Published Date: ");
           				try{
           					user2input = bR.readLine();
           					pdate = user2input;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				System.out.print("ISBN: ");
           				try{
           					user2input = bR.readLine();
           					ISBN = user2input;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				System.out.print("Number of Copies: ");
           				try{
           					user2input = bR.readLine();
            				int temp = Integer.parseInt(user2input);
            				ncopies = temp;
            			}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
            			}
            			System.out.print("Author: ");
           				try{
           					user2input = bR.readLine();
           					author = user2input;
           				}catch(IOException e){
                   			System.out.println("Could not read from line~ ");
           				}
           				bb = new Book(title, publisher, pdate,ISBN, ncopies, author);
           				books.put(bookcount, bb);
           				System.out.println("\nBook Added! \n");
           				bookcount ++;
               			
           			}else if(userinput.equals("adj")){
            			if (journalcount == 100){
                			System.out.println("No more journals can be added.");
                		}else{
               				String title = null, pdate = null, publisher = null;
               				int volume = 0, issue = 0;
               				System.out.print("Title: ");
               				try{
               					user2input = bR.readLine();
               					title = user2input;
               				}catch(IOException e){
                       			System.out.println("Could not read from line~ ");
               				}
               				System.out.print("Published Date: ");
               				try{
               					user2input = bR.readLine();
               					pdate = user2input;
               				}catch(IOException e){
                           		System.out.println("Could not read from line~ ");
                   			}
               				System.out.print("Volume Number: ");
                			try{
                				user2input = bR.readLine();
                				int temp = Integer.parseInt(user2input);
                				volume = temp;
               				}catch(IOException e){
                       			System.out.println("Could not read from line~ ");
               				}
               				System.out.print("Issue Number: ");
               				try{
               					user2input = bR.readLine();
               					int temp = Integer.parseInt(user2input);
               					issue = temp;
               				}catch(IOException e){
                       			System.out.println("Could not read from line~ ");
               				}
               				System.out.print("Publisher: ");
               				try{
               					user2input = bR.readLine();
                   				publisher = user2input;
               				}catch(IOException e){
                            	System.out.println("Could not read from line~ ");
                            }
               				jj = new Journal(title, pdate, volume, issue, publisher);
               				journals.put(journalcount, jj);
                			System.out.println("Journal Added! \n");
                			journalcount ++;
                		}
            		}else if(userinput.equals("dbk")){
           				System.out.println("Title	Publisher		Date of Pub		ISBN 	# of Copies 	Author(s)\n");
           				for (int id : books.keySet()) {
           					bb = books.get(id);
                    		bb.display();
                    	}
           			}else if(userinput.equals("djl")){
           				System.out.println("Title      Date of Pub      Volume         Issue      Publisher\n");
           				for (int id : journals.keySet()) {
           					jj = journals.get(id);
                    		jj.display();
                    	}
           			}else if(userinput.equals("dtr")){
           				System.out.println("Who       Type           Date Out        Date In        What");
           				for (int id : transactions.keySet()) {
           					tt = transactions.get(id);
                    		tt.display();
                    	}
            		}else if (userinput.equals("bcm")){
            			break;
            		}else{
            			System.out.println("incorrect input try again");
            		}
            	}
            }else if(userinput.equals("ext")){
           		//exit
            	
            	try{
	            	FileOutputStream fos = new FileOutputStream("simplibFile.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(list);
            	}catch(IOException e){
            		System.out.println("Error:" + e);
            	}
           		//write arrays to files 
            	//student save
 /*           	if(studentcount == 0){
            		try{
	            		FileWriter outfile = new FileWriter("students.txt", false);
	           			outfile.write("");
	           			outfile.close();
	           			break;
            		}catch(IOException e){
    					System.out.println("could not open file");
    				}
           		}else if (studentcount == 1){
           			try{
	           			FileWriter outfile = new FileWriter("students.txt", false);
	           			outfile.write(sss[0].toString());
	           			outfile.close();
           			}catch(IOException e){
    					System.out.println("could not open file");
    				}
           		}else if (studentcount > 1){
           			for(i = 0; i < studentcount; i ++){
           				if(i == 0){
           					try{
	           					FileWriter outfile = new FileWriter("students.txt", false);
	           					outfile.write(sss[0].toString());
	            				outfile.close();
	            				FileWriter outfileappend = new FileWriter("students.txt", true);
	            				outfileappend.write("\n");
	            				outfileappend.close();
           					}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}else if(i == (studentcount -1)){
           					try{
           						FileWriter outfileappend = new FileWriter("students.txt", true);
	               				outfileappend.write(sss[i].toString());
	               				outfileappend.close();
           					}catch(IOException e){
            					System.out.println("could not open file");
            				}
           				}else {
           					try{
	           					FileWriter outfileappend = new FileWriter("students.txt", true);
	               				outfileappend.write(sss[i].toString());
	               				outfileappend.write("\n");
	               				outfileappend.close();
           					}catch(IOException e){
            					System.out.println("could not open file");
            				}
           				}
           			}
           		}
           		//faculty save
            	if(facultycount == 0){
            		try{
	            		FileWriter outfile = new FileWriter("faculty.txt", false);
	            		outfile.write("");
	            		outfile.close();
	            		break;
            		}catch(IOException e){
    					System.out.println("could not open file");
    				}
            	}else if (facultycount == 1){
	            	try{
	            		FileWriter outfile = new FileWriter("faculty.txt", false);
	            		outfile.write(fff[0].toString());
	            		outfile.close();
	            	}catch(IOException e){
    					System.out.println("could not open file");
    				}
            	}else if (facultycount > 1){
            		for(i = 0; i < facultycount; i ++){
            			if(i == 0){
            				try{
	            				FileWriter outfile = new FileWriter("faculty.txt", false);
	            				outfile.write(fff[0].toString());
	            				outfile.close();
	            				FileWriter outfileappend = new FileWriter("faculty.txt", true);
	            				outfileappend.write("\n");
	            				outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}else if (i == (facultycount -1)){
            				try{
	            				FileWriter outfileappend = new FileWriter("faculty.txt", true);
	                			outfileappend.write(fff[i].toString());
	                			outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}else{
            				try{
	            				FileWriter outfileappend = new FileWriter("faculty.txt", true);
	                			outfileappend.write(fff[i].toString());
	                			outfileappend.write("\n");
	                			outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}
            		}
            	}
            	//books save
            	if(bookcount == 0){
	            	try{
            			FileWriter outfile = new FileWriter("books.txt", false);
	            		outfile.write("");
	            		outfile.close();
	            		break;
	            	}catch(IOException e){
    					System.out.println("could not open file");
    				}	
            	}else if (bookcount == 1){
            		try{
	        			FileWriter outfile = new FileWriter("books.txt", false);
	        			outfile.write(bbb[0].toString());
	        			outfile.close();
            		}catch(IOException e){
            			System.out.println("could not open file");
            		}
            	}else if (bookcount > 1){
            		for(i = 0; i < bookcount; i ++){
            			if(i == 0){
            				try{
            					FileWriter outfile = new FileWriter("books.txt", false);
	            				outfile.write(bbb[0].toString());
	            				outfile.close();
	            				FileWriter outfileappend = new FileWriter("books.txt", true);
	                			outfileappend.write("\n");
	                			outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}else if(i == (bookcount -1)){
            				try{
	            				FileWriter outfileappend = new FileWriter("books.txt", true);
	                			outfileappend.write(bbb[i].toString());
	                			outfileappend.close();
	                		}catch(IOException e){
	            				System.out.println("could not open file");
	            			}
            			}else {
            				try{
	            				FileWriter outfileappend = new FileWriter("books.txt", true);
	                			outfileappend.write(bbb[i].toString());
	                			outfileappend.write("\n");
	                			outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}
            		}
            	}
            	//journals save
            	if(journalcount == 0){
            		try{
	            		FileWriter outfile = new FileWriter("journals.txt", false);
	            		outfile.write("");
	            		outfile.close();
	            		break;
            		}catch(IOException e){
    					System.out.println("could not open file");
    				}
            	}else if (journalcount == 1){
            		try{
            			FileWriter outfile = new FileWriter("journals.txt", false);
            			outfile.write(jjj[0].toString());
            			outfile.close();
            		}catch(IOException e){
    					System.out.println("could not open file");
    				}
            	}else if (journalcount > 1){
            		for(i = 0; i < journalcount; i ++){
            			if(i == 0){
            				try{
            					FileWriter outfile = new FileWriter("journals.txt", false);
            					outfile.write(jjj[0].toString());
            					outfile.close();
            					FileWriter outfileappend = new FileWriter("journals.txt", true);
                				outfileappend.write("\n");
                				outfileappend.close();
            				}catch(IOException e){
        						System.out.println("could not open file");
        					}
            			}else if (i == (journalcount -1)){
            				try{
            					FileWriter outfileappend = new FileWriter("journals.txt", true);
                				outfileappend.write(jjj[i].toString());
                				outfileappend.close();
            				}catch(IOException e){
        						System.out.println("could not open file");
        					}
            			}else{
            				try{
            					FileWriter outfileappend = new FileWriter("journals.txt", true);
            					outfileappend.write(jjj[i].toString());
            					outfileappend.write("\n");
            					outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}
            		}
            	}
            	//transactions save
            	if(transactioncount == 0){
            		try{
            			FileWriter outfile = new FileWriter("transactions.txt", false);
            			outfile.write("");
            			outfile.close();
            			break;
            		}catch(IOException e){
    					System.out.println("could not open file");
    				}
            	}else if (transactioncount == 1){
            		try{
            			FileWriter outfile = new FileWriter("transactions.txt", false);
            			outfile.write(ttt[0].toString());
            			outfile.close();
            		}catch(IOException e){
    					System.out.println("could not open file");
    				}
            	}else if (transactioncount > 1){
            		for(i = 0; i < transactioncount; i ++){
            			if(i == 0){
            				try{
            					FileWriter outfile = new FileWriter("transactions.txt", false);
            					outfile.write(ttt[0].toString());
            					outfile.close();
            					FileWriter outfileappend = new FileWriter("transactions.txt", true);
            					outfileappend.write("\n");
            					outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}else if(i == (journalcount - 1)){
            				try{
            					FileWriter outfileappend = new FileWriter("transactions.txt", true);
            					outfileappend.write(ttt[i].toString());
            					outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}else{
            				try{
            					FileWriter outfileappend = new FileWriter("transactions.txt", true);
            					outfileappend.write(ttt[i].toString());
            					outfileappend.write("\n");
            					outfileappend.close();
            				}catch(IOException e){
            					System.out.println("could not open file");
            				}
            			}
            		}
            	}*/
            	//exit program
        		break;
            }else{
            	System.out.println("Try again:  usr for Users adm for admin and lib for librarian and ext to Exit and save.");
            }
		}
		return;
	}
	//search function
	static public void search(){
		
		InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader bbRR = new BufferedReader(isr);
    	
		System.out.print("Search by Title || Author || Publisher. Enter what you want to find:  ");
		//if found display item 
		//Title or Author
		try{
			String srch = bbRR.readLine();
		
			for (int id : books.keySet()) {
				bb = books.get(id);
				if(bb.getAuthors().equals(srch)){
					System.out.print("\n");
					bb.display();
				}
				if(bb.getTitle().equals(srch)){
					System.out.print("\n");
					bb.display();
				}
				if(bb.getPublisher().equals(srch)){
					System.out.print("\n");
					bb.display();
				}
			}for (int id : journals.keySet()) {
				jj = journals.get(id);
				if(jj.getTitle().equals(srch)){
					System.out.print("\n");
					jj.display();
				}
				if(jj.getPublisher().equals(srch)){
					System.out.print("\n");
					jj.display();
				}
			}
		}catch(IOException e){
			System.out.println("Could not read from line~");
		}
	}
	//checkout function/rent
	static public void checkout(){
		
		InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader bbRR = new BufferedReader(isr);
    	String checkout = "";
    	int identnum =0;
    	int found = 0;
    	String who = null, type = null, what=null;
    	//checkout menu
    	while(!(checkout.equals("bcu"))){
			checkout = ckoFace.menuC();
			//student checkout
			if(checkout.equals("stu")){
				System.out.println("What is your name Student?\n");
				System.out.print(">>>");
				try{
					checkout = bbRR.readLine();
					//find student
					
					for (int id : students.keySet()) {
						ss = students.get(id);
						if(checkout.equals(ss.getName())){
							found =1;
							identnum = id;
							break;
						}
					}
					if(found == 1){
						who = checkout;
						if(ss.getItems()>=ss.getMaxLoanLength()){
							System.out.println(checkout + ": is not allowed to checkout anymore documents.");
						}else{
							System.out.println("Enter the title of what you would like to rent.\n");
							System.out.print(">>>");
							try{
			    				checkout = bbRR.readLine();
			    				//look through books
			    				for (int idd : books.keySet()) {
			    					bb = books.get(idd);
			    					//find book
			    					if(bb.getTitle().equals(checkout)){
			    						if (bb.getCopies() == 0){
			    							System.out.println("No copies available!");
			    						}else{
    			    						what = checkout;
    			    						int temp4 = 0;
    			    						temp4 = bb.getCopies();
    			    						temp4--;
    			    						bb.setCopies(temp4);
    			    						books.put(idd, bb);
    			    						int temp3 = 0;
    			    						temp3 = ss.getItems();
    			    						temp3++;
    			    						ss.setItems(temp3);
    			    						students.put(identnum, ss);
    			    						System.out.println("How long is the loan length in number of days?");
    			    						System.out.print(">>>");
    			    						try{
    			    							//add transaction
    			    							checkout = bbRR.readLine();
    			    							int temporary = Integer.parseInt(checkout);
    			    							Date out = new Date();
    			    						    Date due = new Date();
    			    						    Calendar due1 = Calendar.getInstance();
    			    						    due1.setTime(due);
    			    							due1.add(Calendar.DATE, temporary);
    			    							due = due1.getTime();
    			    							type = "Check-Out";
    			    							tt = new Transaction(type, out, due, who, what);
    			    							//tt = tt.getInstance(type, out, due, who, what);
    			    							transactions.put(transactioncount, tt);
        			    						tt.display();
        			    						transactioncount++;
    			    						}catch(IOException e){
    			    							System.out.println("Could not read from line~");
    			    						}
			    						}
			    				//look through journals
			    				}for (int iddd : journals.keySet()) {
			    					//if journal found
			    					jj = journals.get(iddd);
			    					if(jj.getTitle().equals(checkout)){
			    						if (jj.getCopies() == 0){
			    							System.out.println("No copies available!");
			    						}else{
    			    						what = checkout;
    			    						int temp4 = 0;
    			    						temp4 = jj.getCopies();
    			    						temp4--;
    			    						jj.setCopies(temp4);
    			    						journals.put(iddd, jj);
    			    						int temp3 = 0;
    			    						temp3 = ss.getItems();
    			    						temp3++;
    			    						ss.setItems(temp3);
    			    						students.put(identnum, ss);
    			    						System.out.println("How long is the loan length in number of days?");
    			    						System.out.print(">>>");
    			    						try{
    			    							//add transaction
    			    							checkout = bbRR.readLine();
    			    							int temporary = Integer.parseInt(checkout);
    			    							Date out = new Date();
    			    						    Date due = new Date();
    			    						    Calendar due1 = Calendar.getInstance();
    			    						    due1.setTime(due);
    			    							due1.add(Calendar.DATE, temporary);
    			    							due = due1.getTime();
    			    							type = "Check-Out";
    			    							tt = new Transaction(type, out, due, who, what);
    			    							//tt = tt.getInstance(type, out, due, who, what);
    			    							transactions.put(transactioncount, tt);
        			    						tt.display();
        			    						transactioncount++;
    			    						}catch(IOException e){
    			    							System.out.println("Could not read from line~");
    			    						}
			    						}
			    					}
			    				}
			    			}	
							}catch(IOException e){
									System.out.println("Could not read from line~ ");
							}
						}
					}else if(found != 1){
						System.out.println("Student not included.");
					}
				}catch(IOException e){
					System.out.println("Could not read from line~");
				}
			//faculty checkout
			}else if(checkout.equals("fac")){
				System.out.println("What is your name Faculty Member?\n");
				System.out.print(">>>");
				try{
					checkout = bbRR.readLine();
					//find faculty
					for (int id : faculty.keySet()) {
						ff = faculty.get(id);
						if(checkout.equals(ff.getName())){
							found = 1; 
							identnum = id;
							break;
						}
					}
					if(found == 1){
						who = checkout;
						if(ff.getItems()>=ff.getMaxLoanLength()){
							System.out.println(checkout + ": is not allowed to checkout anymore documents.");
						}else{
							System.out.println("Enter the title of what you would like to rent.\n");
							System.out.print(">>>");
							try{
								checkout = bbRR.readLine();
								//look through books
								for (int idd : books.keySet()) {
									bb = books.get(idd);
									//find book
									if(bb.getTitle().equals(checkout)){
										if (bb.getCopies() == 0){
			    							System.out.println("No copies available!");
			    						}else{
    										what = checkout;
    										int temp4 = 0;
    										temp4 = bb.getCopies();
    										temp4--;
    										bb.setCopies(temp4);
    										books.put(idd, bb);
    										int temp3 = 0;
    										temp3 = ff.getItems();
    										temp3++;
    										ff.setItems(temp3);
    										faculty.put(identnum, ff);
    										System.out.println("How long is the loan length in days?");
    										System.out.print(">>>");
    										try{
    											//add transaction
    											checkout = bbRR.readLine();
    											int temporary = Integer.parseInt(checkout);
    											Date out = new Date();
    											Date due = new Date();
    											Calendar due1 = Calendar.getInstance();
    											due1.setTime(due);
    											due1.add(Calendar.DATE, temporary);
    											due = due1.getTime();
    											type = "Check-Out";
    											tt= new Transaction(type, out, due, who, what);
    											//tt = tt.getInstance(type, out, due, who, what);
    											transactions.put(transactioncount, tt);
    											tt.display();
    											transactioncount++;
    										}catch(IOException e){
    			    							System.out.println("Could not read from line~");
    										}
			    						}
									}
								//look through journals
								}for (int iddd : journals.keySet()) {
									jj = journals.get(iddd);
									//find the journal
									if(jj.getTitle().equals(checkout)){
										if (jj.getCopies() == 0){
			    							System.out.println("No copies available!");
			    						}else{
    										what = checkout;
    										int temp4 = 0;
    										temp4 = jj.getCopies();
    										temp4--;
    										jj.setCopies(temp4);
    										journals.put(iddd, jj);
    										int temp3 = 0;
    										temp3 = ff.getItems();
    										temp3++;
    										ff.setItems(temp3);
    										faculty.put(identnum, ff);
    										System.out.println("How long is the loan length in days?");
    										System.out.print(">>>");
    										try{
    											//add transaction
    											checkout = bbRR.readLine();
    											int temporary = Integer.parseInt(checkout);
    											Date out = new Date();
    											Date due = new Date();
    											Calendar due1 = Calendar.getInstance();
    											due1.setTime(due);
    											due1.add(Calendar.DATE, temporary);
    											due = due1.getTime();
    											type = "Check-Out";
    											tt = new Transaction(type, out, due, who, what);
    											//tt = tt.getInstance(type, out, due, who, what);
    											transactions.put(transactioncount, tt);
    											tt.display();
    											transactioncount++;
    										}catch(IOException e){
    											System.out.println("Could not read from line~");
    										}
			    						}
									}
								}
							}catch(IOException e){
								System.out.println("Could not read from line~ ");
							}
						}
					}else if(found != 1){
						System.out.println("Faculty Member not included.");
					}
				}catch(IOException e){
					System.out.println("Could not read from line~");
				}
			//back to user
			}else if(checkout.equals("bcu")){
				break;
			}else{
				System.out.println("Try again.");
			}
    	}
	}
	//return function
	static public void retturn(){
		
		InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader bbRR = new BufferedReader(isr);
    	String retturn = "";
    	int found = 0, identnum = 0;
    	String who = null, what=null;
    	//return menu
    	while(!(retturn.equals("bcu"))){
			retturn = returnFace.menuR();
			//student return
			if(retturn.equals("stu")){
				System.out.println("What is your name Student?\n");
				System.out.print(">>>");
				try{
					retturn = bbRR.readLine();
					who = retturn;
					System.out.println("Enter the title of what you would like to return.\n");
					System.out.print(">>>");
					try{
						retturn = bbRR.readLine();
						what = retturn;
						//find student
						for (int id : students.keySet()) {
							ss = students.get(id);
    						if(who.equals(ss.getName())){
    							found = 1;
    							identnum = id;
    							break;
    						}
						}
						//find book and update
						if(found == 1){
							for (int idd : books.keySet()) {
								bb = books.get(idd);
								if(bb.getTitle().equals(retturn)){
									int temp =0;
									temp = bb.getCopies();
									temp++;
									bb.setCopies(temp);
									books.put(idd, bb);
									temp=0;
									temp = ss.getItems();
									temp--;
									ss.setItems(temp);
									students.put(identnum, ss);
								}
							}
							//find journal and update
							for (int iddd : journals.keySet()) {
								if(jj.getTitle().equals(retturn)){
									int temp =0;
									temp = jj.getCopies();
									temp++;
									jj.setCopies(temp);
									journals.put(iddd, jj);
									temp = 0;
									temp = ss.getItems();
									temp--;
									ss.setItems(temp);
									students.put(identnum, ss);
								}
							}
							//remove transaction
							Iterator it = transactions.keySet().iterator();
							while(it.hasNext()){
								tt = transactions.get(it.next());
								if(tt.getWho().equals(who) && tt.getWhat().equals(what)){
									it.remove();
	    							System.out.println("Successfully returned:");
	    							tt.display();
								}
							}
						}else{
							System.out.println("Student not included.");
						}
					}catch(IOException e){
						System.out.println("Could not read from line~");
					}
				}catch(IOException e){
					System.out.println("Could not read from line~");
				}
			//faculty return	
			}else if(retturn.equals("fac")){
				System.out.println("What is your name Faculty Member?\n");
				System.out.print(">>>");
				try{
					retturn = bbRR.readLine();
					who = retturn;
					System.out.println("Enter the title of what you would like to return.\n");
					System.out.print(">>>");
					try{
						//find faculty
						for (int id : faculty.keySet()) {
							ff = faculty.get(id);
    						if(who.equals(ff.getName())){
    							found = 1;
    							identnum = id;
    							break;
    						}
						}
						if(found == 1){
							retturn = bbRR.readLine();
							what = retturn;
							//find and update book
							for (int idd : books.keySet()) {
								bb= books.get(idd);
								if(bb.getTitle().equals(retturn)){
									int temp = 0;
									temp = bb.getCopies();
									temp++;
									bb.setCopies(temp);
									books.put(idd, bb);
									temp = 0;
									temp = ff.getItems();
									temp--;
									ff.setItems(temp);
									faculty.put(identnum, ff);
								}
							}
							//find and update journals
							for (int iddd : journals.keySet()) {
								jj = journals.get(iddd);
								if(jj.getTitle().equals(retturn)){
									int temp = 0;
									temp = jj.getCopies();
									temp++;
									jj.setCopies(temp);
									journals.put(iddd, jj);
									temp=0;
									temp = ff.getItems();
									temp--;
									ff.setItems(temp);
									faculty.put(identnum, ff);
								}
							}
							//remove transaction
							Iterator it = transactions.keySet().iterator();
							while(it.hasNext()){
								tt = transactions.get(it.next());
								if(tt.getWho().equals(who) && tt.getWhat().equals(what)){
									it.remove();
	    							System.out.println("Successfully returned:");
	    							tt.display();
								}
							}
							
						}else{
							System.out.println("Faculty member not included.");
						}
					}catch(IOException e){
						System.out.println("Could not read from line~");
					}
				}catch(IOException e){
					System.out.println("Could not read from line~");
				}
			//back to user	
			}else if(retturn.equals("bcu")){
				break;
			}else{
				System.out.println("Try again.");
			}
    	}
	}
}