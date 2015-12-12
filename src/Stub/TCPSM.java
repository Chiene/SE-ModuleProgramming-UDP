package Stub;

import java.util.Vector;

public class TCPSM {
	Vector<String> clientIPTable;
	
	public TCPSM()
	{
		clientIPTable = new Vector<String>();
		clientIPTable.add("127.0.0.1");
	}
	
	public void initTcpServer()
	{
		
	}
	
	public Vector<String> getClientIPTable()
	{
		return clientIPTable;
	}

}
