package day7.BookManageSystem;
/**
 * 
 *ͼ�����ϵͳ2.0(��������)
 */
public class BookManager {
	Book [] books =new Book[100]; //���
	
	//���
	public void add(Book book){
		boolean tag = false;
		for (int i = 0;i<books.length;i++)
			if(books[i]==null){
				tag =true;
				books[i]=book;
				//��������д���ǳ����Ĵ���,��Ȼbook[i]��null,
				//����ô����book[i].no��?�ᱨ��ָ���쳣
//				books[i].no = book.no;
//				books[i].name = book.name;
//				books[i].price = book.price;
				System.out.println("��ӳɹ�");
				break;
			}
		if (tag == false){
			System.out.println("�������");
		}
	}
	
	//�޸�
	public void update(int no, String nameNew ,double priceNew){
		boolean tag = false;
		for(int i =0 ; i<books.length ; i++){
			//��"books[i].no==no"ǰ�����"books[i]!=null&&"�ĺô���ֻҪbooks[i]Ϊ����
			//�Ͳ����ж�&&����������������,�Ͳ�����ֿ�ָ���쳣��,�ǳ�����!!!
			if(books[i]!=null&&books[i].no==no){
				tag = true;
				books[i].name = nameNew;
				books[i].price = priceNew;
				System.out.println("�޸ĳɹ�");
			}
		}
		if (tag == false){
			System.out.println("�鼮������,�޸�ʧ��");
		}
	}
	
	//ɾ��
	public void delete(int no){
		boolean tag = false;
		for(int i =0 ; i<books.length ; i++){
			//��"books[i].no==no"ǰ�����"books[i]!=null&&"�ĺô���ֻҪbooks[i]Ϊ����
			//�Ͳ����ж�&&����������������,�Ͳ�����ֿ�ָ���쳣��,�ǳ�����!!!
			if(books[i]!=null&&books[i].no==no){
				tag = true;
				books[i]=null;
				System.out.println("ɾ���ɹ�");
			}
		}
		if (tag == false){
			System.out.println("�鼮������,ɾ��ʧ��");
		}
	}
	//��ѯ����
	public void queryAll(){
		for(int i = 0 ; i<books.length; i++){
			if(books[i]!=null){
				System.out.println(books[i].show());
			}
		}
	}
	//��ѯһ����
	public void query(int no){
		boolean tag = false;
		//��"books[i].no==no"ǰ�����"books[i]!=null&&"�ĺô���ֻҪbooks[i]Ϊ����
		//�Ͳ����ж�&&����������������,�Ͳ�����ֿ�ָ���쳣��,�ǳ�����!!!
		for(int i = 0 ; i<books.length; i++){
			if(books[i]!=null&&books[i].no==no){
				tag = true;
				System.out.println(books[i].show());
			}
		}
		if (tag == false){
			System.out.println("�鼮������,��ѯʧ��");
		}
	}
}
