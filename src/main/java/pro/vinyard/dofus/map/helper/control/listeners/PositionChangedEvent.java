package pro.vinyard.dofus.map.helper.control.listeners;

import java.util.EventObject;

import pro.vinyard.dofus.map.helper.Position;

public class PositionChangedEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	private Position value;

	public PositionChangedEvent(Object source) {
		super(source);
	}
	
	public PositionChangedEvent(Object source, Position value) {
		this(source);
		this.value = value;
	}

	public Position getValue() {
		return value;
	}

	public void setValue(Position value) {
		this.value = value;
	}

}
