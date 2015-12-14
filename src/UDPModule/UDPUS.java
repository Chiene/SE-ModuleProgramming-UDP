package UDPModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;
import Stub.DOMStub;
import UDPModule.Entity.SActionMode;
import UDPModule.Factory.ServerActionFactory;

public class UDPUS implements IUDPUS {
	private DOMStub _dom;
	private int _port = 27016;;
	private int bufferSize = 512;
	private long updateSecond = 50;
	private byte _buffer[];

	private DatagramPacket _dataPacket;
	private DatagramSocket _socket;

	private Timer _reciveUDPDataTimer;

	public UDPUS(DOMStub dom) {
		_buffer = new byte[bufferSize];
		_dataPacket = new DatagramPacket(_buffer, _buffer.length);
		_reciveUDPDataTimer = new Timer();
		_dom = dom;
		try {
			_socket = new DatagramSocket(_port);
		} catch (SocketException e) {
			System.out.println("error port");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initUDPserver() {
		_reciveUDPDataTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					reciveFromUDPServer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, updateSecond);
	}

	@Override
	public void stopUDPServer() {
		// TODO Auto-generated method stub
		if (_reciveUDPDataTimer != null) {
			_reciveUDPDataTimer.cancel();
			_socket.close();
		}

	}

	private void reciveFromUDPServer() throws IOException {
		_socket.receive(_dataPacket);
		String msgToken[] = new String[3];
		String msg = new String(_buffer, 0, _dataPacket.getLength());
		for (int i = 0; i < 3; i++) {
			int subIndex = msg.indexOf(" ");
			msgToken[i] = msg.substring(0, subIndex);
			msg = msg.substring(subIndex + 1);
		}
		SActionMode actionMode = ServerActionFactory.getServerActionMode(msgToken[0]);
		actionMode.update(_dom, msgToken[1], msg);
	}

}
