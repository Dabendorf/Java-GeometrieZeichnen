package geometriezeichnen;

/**
 * Diese Klasse repraesentiert eine Pyramide.<br>
 * Als Eigenschaften enthaelt sie die (x,y)-Koordinaten des Punktes unten links, ausserdem die Laenge, die Breite und die Hoehe.<br>
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Pyramide {
	
	private int x,y;
	private int h,b,t;

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

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}
}