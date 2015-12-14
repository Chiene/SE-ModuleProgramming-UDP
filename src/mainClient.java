import Stub.DOMStub;
import UDPModule.UDPUS;

public class mainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMStub dom = new DOMStub();
		UDPUS client = new UDPUS(dom);
		client.initUDPserver();
	}

}
