package UDPModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import Entity.BaseObject;
import Stub.CDC;
import Stub.DOM;
import Stub.TCPSM;

public class UDPBC implements IUDPBC {
	
	private int port = 27016;;
	private int bufferSize = 512;
	private long updateSecond = 20;
	
	private TCPSM _tcpsm;
	private CDC _cdc;
	
	private Timer timer;

	private DatagramSocket socket;
	
	public UDPBC(TCPSM tcpsm,CDC cdc) {
		_tcpsm = tcpsm;
		_cdc = cdc;
		timer = new Timer();
	}
	
	@Override
	public void startUDPBroadCast() {
		// TODO Auto-generated method stub
		try {
			socket = new DatagramSocket();
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		timer.schedule(timerTask, 0, updateSecond);

	}
	
	private TimerTask timerTask = new TimerTask() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			Vector<String> IPTable = _tcpsm.getClientIPTable();
			Vector<BaseObject> data = _cdc.getUpdateInfo();
			try {
				for (BaseObject object : data) 
				{
					byte buffer[] = object.toString().getBytes();
					for (String ip : IPTable) {
						DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port);
						socket.send(packet);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

}
