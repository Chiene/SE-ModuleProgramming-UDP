package UDPModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

import org.ietf.jgss.Oid;

import Enum.ServerActionType;
import Enum.SpriteType;
import Stub.DOM;
import Stub.TCPSM;
import UDPModule.Entity.SActionMode;
import UDPModule.Factory.ServerActionFactory;

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
		},0, updateSecond);
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
			msg = msg.substring(subIndex+1);
		}
		SActionMode actionMode = ServerActionFactory.getServerActionMode(msgToken[0]);
		actionMode.update(dom,msgToken[1],msg);	
	}
	


}
