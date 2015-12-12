import Stub.CDC;
import Stub.TCPSM;
import UDPModule.UDPBC;
import UDPModule.UDPUS;

public class mainServer {
	CDC _CDC;
	TCPSM _TCPSM;
	UDPBC _UDPBC;
	UDPUS _UDPUS;
	public mainServer()
	{
		_TCPSM = new TCPSM();
		_CDC = new CDC();
		_UDPBC = new UDPBC(_TCPSM,_CDC);
	}
	
	public void run()
	{
		_CDC.initUpdateInfor();
		_UDPBC.startUDPBroadCast();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mainServer().run();
	}

}
