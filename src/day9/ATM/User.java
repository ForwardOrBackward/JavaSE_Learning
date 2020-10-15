package day9.ATM;


public class User {
	private String cardId; //卡号
	private String identityId; //身份证号
	private String pwd; //卡号密码
	private double money; //余额
	//构造器
	public User(){	
	}
	public User(String cardId, String pwd, String identityId, double money){
		this.cardId = cardId;
		this.identityId = identityId;
		this.pwd = pwd;
		this.money = money;
	}
	//访问器
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	//show方法展示属性
	public String show(){
		return cardId + "\t" + money;
	}
}
