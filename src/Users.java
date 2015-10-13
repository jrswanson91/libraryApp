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
public class Users implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private int items;


	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}
	private int maxLoanLength;

	/** 
	 * /**
	 *  * @return the maxLoanLength
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getMaxLoanLength() {
		// begin-user-code
		return maxLoanLength;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param maxLoanLength the maxLoanLength to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setMaxLoanLength(int maxLoanLength) {
		// begin-user-code
		this.maxLoanLength = maxLoanLength;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Library library;

	/** 
	 * /**
	 *  * @return the library
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Library getLibrary() {
		// begin-user-code
		return library;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param library the library to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setLibrary(Library library) {
		// begin-user-code
		this.library = library;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

}