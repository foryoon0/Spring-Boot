package hello.demo.lifecycle;

public class NetworkClient {
	
	private String url;
	
	public NetworkClient() {
		System.out.println("������ ȣ��, url = " + url);
		connect();
		call("�ʱ�ȭ ���� �޼���");
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	//���� ���� �� ȣ��
	public void connect() {
		System.out.println("connect: " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + "message = " + message);
	}
	
	//���� ���� �� ȣ�� 
	public void disconnect() {
		System.out.println("close: "+ url);
	}

}
