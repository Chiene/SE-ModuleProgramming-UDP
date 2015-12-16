import Stub.CDCStub;
import Stub.TCPSMStub;
import UDPModule.UDPBC;
import UDPModule.UDPUS;
import UDPModule.Enum.*;

public class mainServer {
	CDCStub _CDC;
	TCPSMStub _TCPSM;
	UDPBC _UDPBC;
	UDPUS _UDPUS;

	public mainServer() {
		_TCPSM = new TCPSMStub();
		_CDC = new CDCStub();
		_CDC.insertData(ServerCommandType.ADD.toString() + " " + SpriteType.ITEM.toString() + " " + "user1 1 1");
		_CDC.insertData("Fail" + " " + SpriteType.ITEM.toString() + " " + "user1 1 1");
		_TCPSM.insertIp("127.0.0.1");
		_UDPBC = new UDPBC(_TCPSM, _CDC);
	}

	public void run() {
		_UDPBC.startUDPBroadCast();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mainServer().run();
	}

}
