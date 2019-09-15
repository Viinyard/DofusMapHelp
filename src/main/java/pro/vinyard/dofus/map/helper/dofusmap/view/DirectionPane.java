package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import org.springframework.stereotype.Component;

import pro.vinyard.dofus.map.helper.control.listeners.DirectionChangedEvent;
import pro.vinyard.dofus.map.helper.control.listeners.DirectionListener;
import pro.vinyard.dofus.map.helper.model.Direction;
import pro.vinyard.dofus.map.helper.model.DofusMapModel;

@Component
public class DirectionPane extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;

	private JButton up, down, left, right;
	private EventListenerList listeners = new EventListenerList();
	
	public DirectionPane() {
		this.setLayout();
	}
	
	private void setLayout() {
		this.setLayout(new BorderLayout());
		
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.up = new JButton(Direction.NORTH.getDirection());
		this.up.addActionListener(e -> this.notifyDirectionChanged(Direction.NORTH));
		
		this.down = new JButton(Direction.SOUTH.getDirection());
		this.down.addActionListener(e -> this.notifyDirectionChanged(Direction.SOUTH));
		
		this.left = new JButton(Direction.WEST.getDirection());
		this.left.addActionListener(e -> this.notifyDirectionChanged(Direction.WEST));
		
		this.right = new JButton(Direction.EAST.getDirection());
		this.right.addActionListener(e -> this.notifyDirectionChanged(Direction.EAST));
		
		this.add(this.up, BorderLayout.NORTH);
		this.add(this.down, BorderLayout.SOUTH);
		this.add(this.right, BorderLayout.EAST);
		this.add(this.left, BorderLayout.WEST);
	}
	
	public void addDirectionListener(DirectionListener listener) {
		this.listeners.add(DirectionListener.class, listener);
	}
	
	public void removeDirectionListener(DirectionListener listener) {
		this.listeners.remove(DirectionListener.class, listener);
	}
	
	public DirectionListener[] getDirectionListeners() {
		return this.listeners.getListeners(DirectionListener.class);
	}
	
	private void notifyDirectionChanged(Direction direction) {
		for(DirectionListener listener : this.getDirectionListeners()) {
			listener.directionChanged(new DirectionChangedEvent(this, direction));
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DofusMapModel) {
			DofusMapModel model = (DofusMapModel) o;
			this.up.setSelected(model.getDirection() == Direction.NORTH);
			this.down.setSelected(model.getDirection() == Direction.SOUTH);
			this.left.setSelected(model.getDirection() == Direction.WEST);
			this.right.setSelected(model.getDirection() == Direction.EAST);
		}
	}

}
