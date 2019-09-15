package pro.vinyard.dofus.map.helper.control.listeners;

import java.util.EventObject;

import pro.vinyard.dofus.map.helper.Hint;

public class HintChangedEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	private Hint value;

	public HintChangedEvent(Object source) {
		super(source);
	}
	
	public HintChangedEvent(Object source, Hint value) {
		this(source);
		this.value = value;
	}

	public Hint getValue() {
		return value;
	}

	public void setValue(Hint value) {
		this.value = value;
	}

}
