package pro.vinyard.dofus.map.helper.control.listeners;

import java.util.EventObject;

import pro.vinyard.dofus.map.helper.model.Direction;

public class DirectionChangedEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	private Direction value;

	public DirectionChangedEvent(Object source) {
		super(source);
	}
	
	public DirectionChangedEvent(Object source, Direction value) {
		this(source);
		this.value = value;
	}

	public Direction getValue() {
		return value;
	}

	public void setValue(Direction value) {
		this.value = value;
	}

}
