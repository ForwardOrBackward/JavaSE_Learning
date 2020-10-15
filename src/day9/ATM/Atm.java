package day9.ATM;

/**
 * 
 *�����������ݾ���ģ��һ��ATM��
 */
public class Atm {
	//�����û�
	private User[] users = new User[100];
	//��ʼ��һ���û�
	{
		User user = new User("001", "123456", "12345678901234", 0);
		users[0] = user;
	}
	//����
	public void addUser(User user){
		for(int i = 0; i < users.length; i++){
			if(users[i] == null){
				users[i] = user;
				System.out.println("�����ɹ�");
				System.out.println("��Ŀ���Ϊ:"+user.getCardId());
				System.out.println("���:"+user.getMoney());
				break;
			}
		}
	}
	//��ѯ�û�cardId���±�,�����ڷ���-1;
	public int queryById(String cardId, String pwd){
		for(int i = 0; i < users.length; i++){
			if(users[i] != null && users[i].getCardId().equals(cardId) && users[i].getPwd().equals(pwd)){
				return i;
			}
		}
		return -1;
	}
	//���
	public void addMoney(int index, int money){
		users[index].setMoney(users[index].getMoney() + money);
		System.out.println("-���" + money + "Ԫ�ɹ�-");
	}
	//ȡ��
	public void subMoney(int index, int money){
		if(money <= users[index].getMoney()){
			users[index].setMoney(users[index].getMoney() - money);
			System.out.println("-ȡ��" + money + "Ԫ�ɹ�-");
		}else{
			System.out.println("-����,ȡ��ʧ��-");
		}
	}
	//��ѯ���
	public void queryMoney(int index){
		System.out.println("��ǰ���Ϊ" + users[index].getMoney() + "Ԫ");
	}
	//ת�˸�����û�
	public void transferAccount(int index, String targetCardId, int money){
		if(users[index].getMoney() < money){
			System.out.println("-����ת�˽��-");
			return;
		}
		for(int i = 0; i < users.length; i++){
			if(users[i] != null && users[i].getCardId().equals(targetCardId)){
				users[index].setMoney(users[index].getMoney() - money);
				users[i].setMoney(users[i].getMoney() + money);
				System.out.println("-ת��" + money + "Ԫ�ɹ�-");
				return;
			}
		}
		System.out.println("�˺�:" + targetCardId + "������");
	}
}
