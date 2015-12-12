import Stub.CDC;
import Stub.TCPSM;
import UDPModule.UDPBC;
import UDPModule.UDPUS;

public class Main {
	CDC _CDC;
	TCPSM _TCPSM;
	UDPBC _UDPBC;
	UDPUS _UDPUS;
	public Main()
	{
		_TCPSM = new TCPSM();
		_CDC = new CDC();
		_UDPBC = new UDPBC(_TCPSM,_CDC);
	}
	
	public void run()
	{
		_UDPBC.startUDPBroadCast();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
