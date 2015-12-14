package Mock;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

import UDPModule.IUDPUS;
import UDPModule.Entity.SActionMode;
import UDPModule.Factory.ServerActionFactory;

public class UDPUSMock implements IUDPUS{

	private int port = 27016;;
	private int bufferSize = 512;
	private long updateSecond = 50;
	private byte buffer[];
	
	private DatagramPacket dataPacket;
	private DatagramSocket socket;
	
	private Timer reciveUDPDataTimer;
	
	public UDPUSMock() {
		// TODO Auto-generated constructor stub
		buffer = new byte[bufferSize];
		dataPacket = new DatagramPacket(buffer, buffer.length);
		reciveUDPDataTimer = new Timer();
		
	}

	@Override
	public void initUDPserver() {
		
	}
	
	public String getData() {
		try {
			socket = new DatagramSocket(port);
			socket.receive(dataPacket);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(buffer, 0, dataPacket.getLength());
	}

	
}
