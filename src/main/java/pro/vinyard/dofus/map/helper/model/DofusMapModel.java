package pro.vinyard.dofus.map.helper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import pro.vinyard.dofus.map.helper.Hint;
import pro.vinyard.dofus.map.helper.Position;


public class DofusMapModel extends Observable {
	
	private Direction direction;
	private List<Hint> indices = new ArrayList<Hint>();
	private Hint indice;
	private Position position, destination;
	
	public DofusMapModel() {
		this.position = new Position(0, 0);
		
	}

	public Position getDestination() {
		return destination;
	}

	public Direction getDirection() {
		return direction;
	}

	public List<Hint> getIndices() {
		return indices;
	}

	public Position getPosition() {
		return position;
	}

	public void setDestination(Position destination) {
		this.destination = destination;
		this.setChanged();
		this.notifyObservers();
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setIndices(List<Hint> indices) {
		this.indices = indices;
		this.setChanged();
		this.notifyObservers("indices");
	}
	
	public void setPosition(Position position) {
		this.position = position;
		System.out.println("new pos : " + position);
		this.setChanged();
		this.notifyObservers();
	}

	public Hint getIndice() {
		return indice;
	}

	public void setIndice(Hint indice) {
		this.indice = indice;
		this.setChanged();
		this.notifyObservers("indice");
	}

}
