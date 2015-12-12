import Stub.DOM;
import UDPModule.UDPUS;

public class mainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOM dom = new DOM();
		UDPUS client = new UDPUS(dom);
		client.initUDPserver();
	}

}
