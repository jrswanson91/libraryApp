import java.io.Serializable;


/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * @author Conner
 * 
 * <!-- end-UML-doc -->
 * @author Jack
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Book extends Docs implements Serializable {
	public Book(String title, String publisher, String date, String isbn, int copies, String authors) {
		this.setAuthors(authors);
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setDateOfPublication(date);
		this.setIsbn(isbn);
		this.setCopies(copies);
	}
	public void display(){
		
		System.out.print(this.getTitle());
		System.out.print("     ");
		System.out.print(this.getPublisher());
		System.out.print("     ");
		System.out.print(this.getDateOfPublication());
		System.out.print("     ");
		System.out.print(this.getIsbn());
		System.out.print("     ");
		System.out.print(this.getCopies());
		System.out.print("     ");
		System.out.println(this.getAuthors());
		System.out.print("\n");
	}
	public String toString(){
		return (this.getTitle() + "		" + this.getPublisher() + "		" + this.getDateOfPublication() + "		" + this.getIsbn() + "		" + this.getCopies() + "		" + this.getAuthors());
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String isbn;

	/** 
	 * /**
	 *  * @return the isbn
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getIsbn() {
		// begin-user-code
		return isbn;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param isbn the isbn to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIsbn(String isbn) {
		// begin-user-code
		this.isbn = isbn;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Book() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}    
}