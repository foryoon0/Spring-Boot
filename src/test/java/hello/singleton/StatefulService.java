package hello.singleton;

public class StatefulService {

	private int price; // ���¸� �����ϴ� �ʵ�
	
	public int order(String name, int price) {
		System.out.println("name = " + name + "price = " + price);
		this.price = price; // ���Ⱑ ����!!
		return price;
	}

//	public int getPrice() {
////		return price;
//	
//	}
}
