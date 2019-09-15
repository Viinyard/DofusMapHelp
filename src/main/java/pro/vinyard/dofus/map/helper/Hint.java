package pro.vinyard.dofus.map.helper;

import com.google.api.client.util.Key;

public class Hint {

	@Key
	private int n;
	
	@Key
	private int x;
	
	@Key
	private int y;
	
	@Key
	private int d;

	@Override
	public String toString() {
		return "Hints [n=" + n + ", x=" + x + ", y=" + y + ", d=" + d + "]";
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

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

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
}
