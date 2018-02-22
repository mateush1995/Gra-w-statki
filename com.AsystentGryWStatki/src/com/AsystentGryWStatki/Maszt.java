package com.AsystentGryWStatki;
import java.awt.*;

public class Maszt {
	private boolean czyZestrzelony;
	private Point wspolrzedne;
	
	public Maszt(Point wspolrzedne) {
		this.czyZestrzelony = false;
		this.wspolrzedne = wspolrzedne;
	}
	
	public Point getWspolrzedne() {
		return this.wspolrzedne;
	}
	
	public void setCzyZestrzelony() {
		this.czyZestrzelony = true;
	}	
}
