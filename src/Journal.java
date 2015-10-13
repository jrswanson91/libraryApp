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
public class Journal extends Docs implements Serializable {
	public Journal(String title, String date, int volume, int issue, String publisher){
		this.setTitle(title);
		this.setDateOfPublication(date);
		this.setVolumeNumber(volume);
		this.setIssueNumber(issue);
		this.setPublisher(publisher);
		this.setCopies(1);
	}
	public Journal(){
		
	}
	public String toString(){
		return (this.getTitle() + "		" + this.getDateOfPublication() + "		" + this.getVolumeNumber() + "		" + this.getIssueNumber() + "		" + this.getPublisher());
	}
	public void display(){
		
		System.out.print(this.getTitle());
		System.out.print("     ");
		System.out.print(this.getDateOfPublication());
		System.out.print("     ");
		System.out.print(this.getVolumeNumber());
		System.out.print("     ");
		System.out.print(this.getIssueNumber());
		System.out.print("     ");
		System.out.println(this.getPublisher());
		System.out.print("\n");
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int volumeNumber;

	/** 
	 * /**
	 *  * @return the volumeNumber
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getVolumeNumber() {
		// begin-user-code
		return volumeNumber;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param volumeNumber the volumeNumber to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setVolumeNumber(int volumeNumber) {
		// begin-user-code
		this.volumeNumber = volumeNumber;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int issueNumber;

	/** 
	 * /**
	 *  * @return the issueNumber
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getIssueNumber() {
		// begin-user-code
		return issueNumber;
		// end-user-code
	}

	/** 
	 * /**
	 *  * @param issueNumber the issueNumber to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIssueNumber(int issueNumber) {
		// begin-user-code
		this.issueNumber = issueNumber;
		// end-user-code
	}
}