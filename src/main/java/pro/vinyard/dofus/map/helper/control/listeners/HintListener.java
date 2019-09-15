package pro.vinyard.dofus.map.helper.control.listeners;

import java.util.EventListener;

public interface HintListener extends EventListener {

	void hintChanged(HintChangedEvent e);
}
