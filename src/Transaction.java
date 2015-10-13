import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Transaction implements Serializable{
	private String Type;
	private Date DateOut;
	private Date DD;
	private String who;
	private String what;
	public String toString(){
		return (this.getWho() + "	" +  this.getType() + "	" + this.getDateOut() + "	" + this.getDD() + "	" + this.getWhat());
	}
	
	
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public Transaction(String type, Date out, Date due, String who, String what){
		this.setType(type);
		this.setDateOut(out);
		this.setDD(due);
		this.setWho(who);
		this.setWhat(what);
	}
	
	public void display(){
		System.out.print(this.getWho());
		System.out.print("     ");
		System.out.print(this.getType());
		System.out.print("     ");
		System.out.print(this.getDateOut());
		System.out.print("     ");
		System.out.print(this.getDD());
		System.out.print("     ");
		System.out.println(this.getWhat());
		System.out.print("\n");
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getDateOut() {
		return DateOut;
	}
	public void setDateOut(Date dateOut) {
		DateOut = dateOut;
	}
	public Date getDD() {
		return DD;
	}
	public void setDD(Date dd) {
		DD = dd;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
}
