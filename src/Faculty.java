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
public class Faculty extends Users implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Faculty(String name, int id, int itemsOut,int max){
		this.setName(name);
		this.setId(id);
		this.setItems(itemsOut);
		this.setMaxLoanLength(max);
	}
	public String toString(){
		return (this.getName() + "		" + this.getId() + "		" + this.getItems());
	}
	public void display(){
		
		System.out.print(this.getName());
		System.out.print("     ");
		System.out.print(this.getId());
		System.out.print("     ");
		System.out.print(this.getItems());
		System.out.print("     ");
		System.out.println(this.getMaxLoanLength());
		System.out.print("\n");
	}
	public Faculty() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}
}