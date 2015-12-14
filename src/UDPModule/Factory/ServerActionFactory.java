package UDPModule.Factory;

import Enum.ServerActionType;
import Stub.DOMStub;
import UDPModule.Entity.SActionMode;
import UDPModule.Entity.SAddMode;
import UDPModule.Entity.SUpdateMode;

public class ServerActionFactory {

	public static SActionMode getServerActionMode(String mode) {
		SActionMode actionMode = null;
		switch (ServerActionType.valueOf(mode)) {
		case ADD:
			actionMode = new SAddMode();
			break;
		case UPDATE:
			actionMode = new SUpdateMode();
			break;
		default:
			break;
		}
		return actionMode;
	}
}
