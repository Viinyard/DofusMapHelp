package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import pro.vinyard.dofus.map.helper.Position;
import pro.vinyard.dofus.map.helper.control.listeners.PositionChangedEvent;
import pro.vinyard.dofus.map.helper.control.listeners.PositionListener;
import pro.vinyard.dofus.map.helper.model.DofusMapModel;

public class PositionPane extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;

	private NumberPane posX, posY;
	private EventListenerList listeners = new EventListenerList();
	
	public PositionPane() {
		this.setLayout();
	}

	private void setLayout() {
		this.setLayout(new GridLayout(1, 2));
		
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.posX = new NumberPane();
		this.posY = new NumberPane();
		
		this.posX.addChangeListener(e -> this.notifyPositionChanged());
		this.posY.addChangeListener(e -> this.notifyPositionChanged());
		
		this.add(this.posX);
		this.add(this.posY);
	}
	
	public void addPositionListener(PositionListener listener) {
		this.listeners.add(PositionListener.class, listener);
	}
	
	public void removePositionListener(PositionListener listener) {
		this.listeners.remove(PositionListener.class, listener);
	}
	
	public PositionListener[] getPositionListeners() {
		return this.listeners.getListeners(PositionListener.class);
	}
	
	public void notifyPositionChanged() {
		for(PositionListener listener : this.getPositionListeners()) {
			listener.positionChanged(new PositionChangedEvent(this, new Position(this.posX.getValue(), this.posY.getValue())));
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DofusMapModel) {
			DofusMapModel model = (DofusMapModel) o;
			this.posX.setValue(model.getPosition().getPosX());
			this.posY.setValue(model.getPosition().getPosY());
		}
	}
	
	
}
