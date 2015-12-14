package Test;

import static org.junit.Assert.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Entity.Sprite;
import Enum.ServerActionType;
import Enum.SpriteType;
import Mock.UDPUSMock;
import Stub.CDC;
import Stub.TCPSM;
import UDPModule.IUDPUS;
import UDPModule.UDPBC;
import UDPModule.UDPUS;

public class UDPBCTest {
	private CDC _cdc;
	private TCPSM _tcpsm;
	private UDPBC udpBroadCast;
	private UDPUSMock udpusMock;
	

	
	@Before
	public void setUp() {
		_cdc = new CDC();
		_tcpsm = new TCPSM();
		udpBroadCast = new UDPBC(_tcpsm, _cdc);
		udpusMock = new UDPUSMock();
		_cdc.clearData();
	}
	
	@After
	public void setDown() {
	}
	
	@Test
	public void testBroadCastOneMessage() {
		String data = ServerActionType.ADD.toString() + " " + SpriteType.ITEM.toString() + " "+"user1 1 1";
		_cdc.insertData(data);
		udpBroadCast.startUDPBroadCast();
		assertTrue(data.equals(udpusMock.getData()));
	}

}