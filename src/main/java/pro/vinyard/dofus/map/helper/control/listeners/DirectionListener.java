package pro.vinyard.dofus.map.helper.control.listeners;

import java.util.EventListener;

public interface DirectionListener extends EventListener {
	
	void directionChanged(DirectionChangedEvent e);

}
