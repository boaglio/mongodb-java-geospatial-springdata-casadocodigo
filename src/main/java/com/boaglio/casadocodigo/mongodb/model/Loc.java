package com.boaglio.casadocodigo.mongodb.model;

public class Loc {

	private Double x;

	private Double y;

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Loc [x=" + x + ", y=" + y + "]";
	}

}
