package Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Entity.Sprite;
import Enum.ServerActionType;
import Enum.SpriteType;
import Mock.UDPUSMock;
import Stub.CDCStub;
import Stub.TCPSMStub;
import UDPModule.IUDPUS;
import UDPModule.UDPBC;
import UDPModule.UDPUS;

public class UDPBCTest {
	private CDCStub _cdc;
	private TCPSMStub _tcpsm;
	private UDPBC udpBroadCast;
	private UDPUSMock udpusMock;

	public UDPBCTest() {
		// TODO Auto-generated constructor stub
		_cdc = new CDCStub();
		_tcpsm = new TCPSMStub();
		udpBroadCast = new UDPBC(_tcpsm, _cdc);
		udpusMock = new UDPUSMock();
	}

	@After
	public void setDown() {
		_cdc.clearData();
		_tcpsm.clearIpTable();
		udpBroadCast.endUDPBroadCast();
		udpusMock.stopUDPServer();
	}

	@Test
	public void testBroadCastOneMessage() {
		_tcpsm.insertIp("127.0.0.1");
		String data = ServerActionType.ADD.toString() + " " + SpriteType.ITEM.toString() + " " + "user1 1 1";
		_cdc.insertData(data);
		udpBroadCast.startUDPBroadCast();
		assertTrue(data.equals(udpusMock.getData()));
	}

}