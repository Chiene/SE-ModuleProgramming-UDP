package UDPModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

import org.ietf.jgss.Oid;

import Enum.ServerAction;
import Enum.SpriteType;
import Stub.DOM;
import Stub.TCPSM;

public class UDPUS implements IUDPUS {
	private DOM dom;
	private int port = 27016;;
	private int bufferSize = 512;
	private long updateSecond = 50;
	private byte buffer[];
	
	private DatagramPacket dataPacket;
	private DatagramSocket socket;
	
	private Timer reciveUDPDataTimer;
	
	public UDPUS(DOM _dom) {
		buffer = new byte[bufferSize];
		dataPacket = new DatagramPacket(buffer, buffer.length);
		reciveUDPDataTimer = new Timer();
		dom = _dom;
	}
	
	@Override
	public void initUDPserver() {
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			System.out.println("error port");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reciveUDPDataTimer.schedule(new TimerTask() {
			
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
		}, updateSecond);
	}
	
	private void reciveFromUDPServer() throws IOException
	{
		
		socket.receive(dataPacket);
		String msgToken[] = new String[3];
		String msg = new String(buffer, 0, dataPacket.getLength());
		for(int i =0 ; i< 3 ;i++)
		{
			int subIndex = msg.indexOf(" ");
			msgToken[i] = msg.substring(0,subIndex);
			msg = msg.substring(subIndex);
		}
		
		switch (ServerAction.valueOf(msgToken[0])){
		case ADD:
			switch (SpriteType.valueOf(msgToken[1])) {
			case VIRTUALCHARACTER:
				dom.addVirtualCharacter();
				break;
			case ITEM:
				dom.addItem();
				break;
			default:
				break;
			}
			break;
		case UPDATE:
			switch (SpriteType.valueOf(msgToken[1])) {
			case VIRTUALCHARACTER:
				dom.updateVirtualCharacter();
				break;
			case ITEM:
				dom.updateItem();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		 
	}
	


}
