package day9.ATM;


public class User {
	private String cardId; //����
	private String identityId; //���֤��
	private String pwd; //��������
	private double money; //���
	//������
	public User(){	
	}
	public User(String cardId, String pwd, String identityId, double money){
		this.cardId = cardId;
		this.identityId = identityId;
		this.pwd = pwd;
		this.money = money;
	}
	//������
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
	//show����չʾ����
	public String show(){
		return cardId + "\t" + money;
	}
}
