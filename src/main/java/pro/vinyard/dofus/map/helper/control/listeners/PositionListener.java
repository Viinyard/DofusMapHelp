package pro.vinyard.dofus.map.helper.control.listeners;

import java.util.EventListener;

public interface PositionListener extends EventListener {
	
	void positionChanged(PositionChangedEvent e);

}
