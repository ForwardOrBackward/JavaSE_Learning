package day9.ATM;

/**
 * 
 *这个包里的内容就是模拟一个ATM机
 */
public class Atm {
	//所有用户
	private User[] users = new User[100];
	//初始化一个用户
	{
		User user = new User("001", "123456", "12345678901234", 0);
		users[0] = user;
	}
	//开户
	public void addUser(User user){
		for(int i = 0; i < users.length; i++){
			if(users[i] == null){
				users[i] = user;
				System.out.println("开户成功");
				System.out.println("你的卡号为:"+user.getCardId());
				System.out.println("余额:"+user.getMoney());
				break;
			}
		}
	}
	//查询用户cardId的下标,不存在返回-1;
	public int queryById(String cardId, String pwd){
		for(int i = 0; i < users.length; i++){
			if(users[i] != null && users[i].getCardId().equals(cardId) && users[i].getPwd().equals(pwd)){
				return i;
			}
		}
		return -1;
	}
	//存款
	public void addMoney(int index, int money){
		users[index].setMoney(users[index].getMoney() + money);
		System.out.println("-存款" + money + "元成功-");
	}
	//取款
	public void subMoney(int index, int money){
		if(money <= users[index].getMoney()){
			users[index].setMoney(users[index].getMoney() - money);
			System.out.println("-取款" + money + "元成功-");
		}else{
			System.out.println("-余额不足,取款失败-");
		}
	}
	//查询余额
	public void queryMoney(int index){
		System.out.println("当前余额为" + users[index].getMoney() + "元");
	}
	//转账给别的用户
	public void transferAccount(int index, String targetCardId, int money){
		if(users[index].getMoney() < money){
			System.out.println("-余额不足转账金额-");
			return;
		}
		for(int i = 0; i < users.length; i++){
			if(users[i] != null && users[i].getCardId().equals(targetCardId)){
				users[index].setMoney(users[index].getMoney() - money);
				users[i].setMoney(users[i].getMoney() + money);
				System.out.println("-转账" + money + "元成功-");
				return;
			}
		}
		System.out.println("账号:" + targetCardId + "不存在");
	}
}
