package day9.ATM;

import java.util.Scanner;

public class AtmManager {
	Atm atm = new Atm();
	Scanner input = new Scanner(System.in);
	private int index = -1; // 用户的下标
	private int count = 1; // 用来标记系统开户开到第几个了
	private int loginNum = 0; // 用来记录当前用户此次进入系统登录失败了多少次

	public void startMenu() {
		// 进入系统
		loginMenu();
	}

	private void loginMenu() {
		while (true) {
			System.out.println("\n\t-系统界面-");
			System.out.println("1.登录; 2.开户; 3.退出系统;\n");
			loginNum = 0; // 每次重新进入系统将登录失败次数重新归零
			System.out.println("--请输入登录菜单选项(数字1或2或3):");
			String menuNo = input.next();
			while (menuNo.equals("1")) {
				System.out.println("请输入卡号:");
				String cardId = input.next();
				System.out.println("请输入密码:");
				String pwd = input.next();
				this.index = atm.queryById(cardId, pwd);
				// 登录失败超过三次就提示可能是没有账户,请开户
				if (index == -1 && loginNum < 3) {
					loginNum++;// 每登录失败一次就加1
					System.out.println("账号或密码错误,请重新输入:");
				} else if (index == -1 && loginNum >= 3) {
					System.out.println("-输入错误次数过多,可能账号不存在-");
					System.out.println("-请输入数字2进行开户或者输入其他内容继续输入账号密码-");
					String num = input.next();
					if (num.equals("2")) {
						createAccount();
					}
				} else {
					System.out.println("登录成功");
					mainMenu();
					break;
				}
			}
			if (menuNo.equals("2")) {
				createAccount();
			}
			if (menuNo.equals("3")) {
				System.out.println("退出ATM");
				System.exit(0);
			}
			if(!menuNo.equals("1") && !menuNo.equals("2") && !menuNo.equals("3")){
				System.out.println("-输入错误,请重新输入-");
			}
		}
	}

	private void createAccount() {
		System.out.println("请输入身份证号");
		count++;
		String identityId = input.next();
		System.out.println("请输入密码");
		String pwd = input.next();
		String cardId = "00" + count;
		User user = new User(cardId, pwd, identityId, 0);
		atm.addUser(user);		
	}

	private void mainMenu() {
		while (true) {
			System.out.println("\n\t -用户主菜单-");
			System.out.println("1.存钱; 2.取钱; 3.转账; 4.查余额; 5.退出当前账户; 6.退出系统\n");
			System.out.println("--请输入主菜单选项:");
			String menuNo = input.next();
			int money;
			//switch可以直接用具体的字符串做case,因为switch的效果
			//相当于menuNo.equals("1"),而不是menuNo=="1",所以是可用的。
			switch (menuNo) {
			case "1":
				System.out.println("请输入存钱金额:");
				money = input.nextInt();
				atm.addMoney(index, money);
				break;
			case "2":
				System.out.println("请输入取钱金额:");
				money = input.nextInt();
				atm.subMoney(index, money);
				break;
			case "3":
				System.out.println("请输入转账用户:");
				String cardId = input.next();
				System.out.println("请输入转账金额:");
				money = input.nextInt();
				atm.transferAccount(index, cardId, money);
				break;
			case "4":
				atm.queryMoney(index);
				break;
			case "5":
				return;
			case "6":
				System.out.println("退出ATM");
				System.exit(0);
			default:
				System.out.println("输入命令错误,请重新输入:");
			}
		}
	}
}
