package Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import UDPModule.Enum.*;
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
		
	}
	
	@After
	public void setdown() {
		_udpBCStub.endUDPBroadCast();
		_udpus.stopUDPServer();
	}

	@Test
	public void testUDPUSToAddItem() {
		_udpus.initUDPserver();
		_udpBCStub.startUDPBroadCast();
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
		_udpus.initUDPserver();
		_udpBCStub.startUDPBroadCast();
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
		_udpus.initUDPserver();
		_udpBCStub.startUDPBroadCast();
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
		_udpus.initUDPserver();
		_udpBCStub.startUDPBroadCast();
		String msg = "user1 1 1";
		String data = ServerActionType.UPDATE.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " " + msg;
		String expected = "updateVirtualCharacter " + msg;
		_udpBCStub.send(data, "127.0.0.1");
		while (_domMock.getResult().isEmpty()) {
		}
		assertTrue(expected.equals(_domMock.getResult()));
	}

}
