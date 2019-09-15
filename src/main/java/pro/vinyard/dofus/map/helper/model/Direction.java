package pro.vinyard.dofus.map.helper.model;

public enum Direction {
	NORTH("top"),
	EAST("right"),
	WEST("left"),
	SOUTH("bottom");
	
	private String direction;
	
	Direction(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
