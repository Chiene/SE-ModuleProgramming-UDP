package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Enum.ServerActionType;
import Enum.SpriteType;
import Mock.DOMMock;
import Stub.UDPBCStub;
import UDPModule.UDPUS;

public class UDPUSTest {
	private UDPUS _udpus;
	private UDPBCStub _udpBCStub;
	private DOMMock _domMock;

	public UDPUSTest() {
		// TODO Auto-generated constructor stub
		_domMock = new DOMMock();
		_udpus = new UDPUS(_domMock);
		_udpBCStub = new UDPBCStub();
	}
	
	@Before 
	public void setup() {
		_udpus.initUDPserver();
		_udpBCStub.startUDPBroadCast();
		
	}
	
	@After
	public void setdown() {
		_udpBCStub.endUDPBroadCast();
		_udpus.stopUDPServer();
	}

	@Test
	public void testUDPUSToAddItem() {
		String msg = "user1 1 1";
		String data = ServerActionType.ADD.toString() + " " + SpriteType.ITEM.toString() + " " + msg;
		String expected = "addItem " + msg;
		_udpBCStub.send(data, "127.0.0.1");
		while (_domMock.getResult().isEmpty()) {
		}
		assertTrue(expected.equals(_domMock.getResult()));
	}

	@Test
	public void testUDPUSToUpdateItem() {
		String msg = "user2 2 2";
		String data = ServerActionType.UPDATE.toString() + " " + SpriteType.ITEM.toString() + " " + msg;
		String expected = "updateItem " + msg;
		_udpBCStub.send(data, "127.0.0.1");
		while (_domMock.getResult().isEmpty()) {
		}
		assertTrue(expected.equals(_domMock.getResult()));
	}

	@Test
	public void testUDPUSToAddVirtualCharacter() {
		String msg = "user2 2 2";
		String data = ServerActionType.ADD.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " " + msg;
		String expected = "addVirtualCharacter " + msg;
		_udpBCStub.send(data, "127.0.0.1");
		while (_domMock.getResult().isEmpty()) {
		}
		assertTrue(expected.equals(_domMock.getResult()));
	}

	@Test
	public void testUDPUSToUpdateVirtualCharacter() {
		String msg = "user1 1 1";
		String data = ServerActionType.UPDATE.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " " + msg;
		String expected = "updateVirtualCharacter " + msg;
		_udpBCStub.send(data, "127.0.0.1");
		while (_domMock.getResult().isEmpty()) {
		}
		assertTrue(expected.equals(_domMock.getResult()));
	}

}
