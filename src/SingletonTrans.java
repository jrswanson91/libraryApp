
public class SingletonTrans {

	private static SingletonTrans transinstance;

	private SingletonTrans(){}
	
	public SingletonTrans getSingletonTrans() {
		if (null == transinstance) {
			transinstance = new SingletonTrans();
		}
		return transinstance;
	}
}
