package Stub;

import java.util.Vector;

public class TCPSMStub {
	Vector<String> clientIPTable;
	
	public TCPSMStub() {
		clientIPTable = new Vector<String>();
	}
	
	public Vector<String> getClientIPTable() {
		return clientIPTable;
	}

	public void insertIp(String msg) {
		clientIPTable.add(msg);
	}
	
	public void clearIpTable() {
		clientIPTable.clear();
	}
}
