package UDPModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import Stub.TCPSM;

public class UDPUS implements IUDPUS {
	
	private int port = 27016;;
	private int bufferSize = 512;
	private byte buffer[];
	private DatagramPacket dataPacket;
	private DatagramSocket socket;
	
	public UDPUS() {
		buffer = new byte[bufferSize];
		dataPacket = new DatagramPacket(buffer, buffer.length);
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
		System.out.println("Wait for client\n");
		while(true)
		{
			try {
				 socket.receive(dataPacket);
				 String msg = new String(buffer, 0, dataPacket.getLength());
		         System.out.println(msg); 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}	

}
