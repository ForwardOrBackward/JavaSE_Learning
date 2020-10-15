package day9.ATM;

import java.util.Scanner;

public class AtmManager {
	Atm atm = new Atm();
	Scanner input = new Scanner(System.in);
	private int index = -1; // �û����±�
	private int count = 1; // �������ϵͳ���������ڼ�����
	private int loginNum = 0; // ������¼��ǰ�û��˴ν���ϵͳ��¼ʧ���˶��ٴ�

	public void startMenu() {
		// ����ϵͳ
		loginMenu();
	}

	private void loginMenu() {
		while (true) {
			System.out.println("\n\t-ϵͳ����-");
			System.out.println("1.��¼; 2.����; 3.�˳�ϵͳ;\n");
			loginNum = 0; // ÿ�����½���ϵͳ����¼ʧ�ܴ������¹���
			System.out.println("--�������¼�˵�ѡ��(����1��2��3):");
			String menuNo = input.next();
			while (menuNo.equals("1")) {
				System.out.println("�����뿨��:");
				String cardId = input.next();
				System.out.println("����������:");
				String pwd = input.next();
				this.index = atm.queryById(cardId, pwd);
				// ��¼ʧ�ܳ������ξ���ʾ������û���˻�,�뿪��
				if (index == -1 && loginNum < 3) {
					loginNum++;// ÿ��¼ʧ��һ�ξͼ�1
					System.out.println("�˺Ż��������,����������:");
				} else if (index == -1 && loginNum >= 3) {
					System.out.println("-��������������,�����˺Ų�����-");
					System.out.println("-����������2���п������������������ݼ��������˺�����-");
					String num = input.next();
					if (num.equals("2")) {
						createAccount();
					}
				} else {
					System.out.println("��¼�ɹ�");
					mainMenu();
					break;
				}
			}
			if (menuNo.equals("2")) {
				createAccount();
			}
			if (menuNo.equals("3")) {
				System.out.println("�˳�ATM");
				System.exit(0);
			}
			if(!menuNo.equals("1") && !menuNo.equals("2") && !menuNo.equals("3")){
				System.out.println("-�������,����������-");
			}
		}
	}

	private void createAccount() {
		System.out.println("���������֤��");
		count++;
		String identityId = input.next();
		System.out.println("����������");
		String pwd = input.next();
		String cardId = "00" + count;
		User user = new User(cardId, pwd, identityId, 0);
		atm.addUser(user);		
	}

	private void mainMenu() {
		while (true) {
			System.out.println("\n\t -�û����˵�-");
			System.out.println("1.��Ǯ; 2.ȡǮ; 3.ת��; 4.�����; 5.�˳���ǰ�˻�; 6.�˳�ϵͳ\n");
			System.out.println("--���������˵�ѡ��:");
			String menuNo = input.next();
			int money;
			//switch����ֱ���þ�����ַ�����case,��Ϊswitch��Ч��
			//�൱��menuNo.equals("1"),������menuNo=="1",�����ǿ��õġ�
			switch (menuNo) {
			case "1":
				System.out.println("�������Ǯ���:");
				money = input.nextInt();
				atm.addMoney(index, money);
				break;
			case "2":
				System.out.println("������ȡǮ���:");
				money = input.nextInt();
				atm.subMoney(index, money);
				break;
			case "3":
				System.out.println("������ת���û�:");
				String cardId = input.next();
				System.out.println("������ת�˽��:");
				money = input.nextInt();
				atm.transferAccount(index, cardId, money);
				break;
			case "4":
				atm.queryMoney(index);
				break;
			case "5":
				return;
			case "6":
				System.out.println("�˳�ATM");
				System.exit(0);
			default:
				System.out.println("�����������,����������:");
			}
		}
	}
}
