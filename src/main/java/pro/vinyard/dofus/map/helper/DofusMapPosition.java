package pro.vinyard.dofus.map.helper;

import com.google.api.client.util.Key;

public class DofusMapPosition {

	@Override
	public String toString() {
		return "DofusMapPosition [x=" + x + ", y=" + y + ", di=" + di + "]";
	}

	@Key
	private int x;
	
	@Key
	private int y;
	
	@Key
	private String di;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDi() {
		return di;
	}

	public void setDi(String di) {
		this.di = di;
	}

}
