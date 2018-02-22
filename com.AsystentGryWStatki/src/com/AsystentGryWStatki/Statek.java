package com.AsystentGryWStatki;
import java.util.LinkedList;
import java.awt.*;

public class Statek {
	private int liczbaMasztow;
	private LinkedList<Maszt> listaMasztow;
	private boolean czyZatopiony;
	
	public Statek(Plansza plansza, int liczbaMasztow, Point...punkty) {
		this.liczbaMasztow = liczbaMasztow;
		this.czyZatopiony = false;
		listaMasztow = new LinkedList<Maszt>();
		switch(punkty.length) {
		case 1: konstruktorDlaJednegoMasztu(plansza, punkty);
				break;
		case 2: konstruktorDlaDwochMasztow(plansza, punkty);
				break;
		case 3: konstruktorDlaTrzechMasztow(plansza, punkty);
				break;
		case 4: konstruktorDlaCzterechMasztow(plansza, punkty);
				break;
		}
	}
	
	public void konstruktorDlaJednegoMasztu(Plansza plansza, Point...punkty) {
		Maszt maszt = new Maszt(punkty[0]);
		if(czyZajeteMiejsce(plansza, maszt)) {
			listaMasztow.add(maszt);
		}else {
			System.out.println("Statek ju¿ tam jest!");
		}
	}
	
	public void konstruktorDlaDwochMasztow(Plansza plansza, Point...punkty) {
		boolean flaga1, flaga2;
		Maszt maszt1 = new Maszt(punkty[0]);
		if(czyZajeteMiejsce(plansza, maszt1)) {
			flaga1 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		
		Maszt maszt2 = new Maszt(punkty[1]);
		if(czyZajeteMiejsce(plansza, maszt2) && sasiedztwo(plansza, maszt2)) {
			flaga2 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		if(flaga1 && flaga2) {
			listaMasztow.add(maszt1);
			listaMasztow.add(maszt2);
		}
	}
	
	public void konstruktorDlaTrzechMasztow(Plansza plansza, Point...punkty) {
		boolean flaga1, flaga2, flaga3;
		Maszt maszt1 = new Maszt(punkty[0]);
		if(czyZajeteMiejsce(plansza, maszt1)) {
			flaga1 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		
		Maszt maszt2 = new Maszt(punkty[1]);
		if(czyZajeteMiejsce(plansza, maszt2) && sasiedztwo(plansza, maszt2)) {
			flaga2 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		
		Maszt maszt3 = new Maszt(punkty[2]);
		if(czyZajeteMiejsce(plansza, maszt3) && sasiedztwo(plansza, maszt3)) {
			flaga3 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		if(flaga1 && flaga2 && flaga3) {
			listaMasztow.add(maszt1);
			listaMasztow.add(maszt2);
			listaMasztow.add(maszt3);
		}
	}
	
	public void konstruktorDlaCzterechMasztow(Plansza plansza, Point...punkty) {
		boolean flaga1, flaga2, flaga3, flaga4;
		Maszt maszt1 = new Maszt(punkty[0]);
		if(czyZajeteMiejsce(plansza, maszt1)) {
			flaga1 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		
		Maszt maszt2 = new Maszt(punkty[1]);
		if(czyZajeteMiejsce(plansza, maszt2) && sasiedztwo(plansza, maszt2)) {
			flaga2 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
				
		Maszt maszt3 = new Maszt(punkty[2]);
		if(czyZajeteMiejsce(plansza, maszt3) && sasiedztwo(plansza, maszt3)) {
			flaga3 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		
		Maszt maszt4 = new Maszt(punkty[3]);
		if(czyZajeteMiejsce(plansza, maszt4) && sasiedztwo(plansza, maszt4)) {
			flaga4 = true;
		}else {
			System.out.println("Statek ju¿ tam jest!");
			return;
		}
		
		if(flaga1 && flaga2 && flaga3 && flaga4) {
			listaMasztow.add(maszt1);
			listaMasztow.add(maszt2);
			listaMasztow.add(maszt3);
			listaMasztow.add(maszt4);
		}
	}
	
	public LinkedList<Maszt> getListaMasztow(){
		return listaMasztow;
	}
	
	public boolean czyZajeteMiejsce(Plansza plansza, Maszt maszt) {
		if(plansza.getPlansze()[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y - 1] == "O") {
			return false;
		}
		return true;		
	}
	
	public boolean sasiedztwo(Plansza plansza, Maszt maszt) {
		if(maszt.getWspolrzedne().y == 0) {
			if(plansza.getPlansze()[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y] == "O") {
				return false;
			}else if(plansza.getPlansze()[maszt.getWspolrzedne().x][maszt.getWspolrzedne().y - 1] == "O") {
				return false;
			}else if(plansza.getPlansze()[maszt.getWspolrzedne().x - 2][maszt.getWspolrzedne().y - 1] == "O") {
				return false;
			}
		}else {
			return true;
		}
		
		if(maszt.getWspolrzedne().x == 0) {
			if(plansza.getPlansze()[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y] == "O") {
				return false;
			}else if(plansza.getPlansze()[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y - 2] == "O") {
				return false;
			}else if(plansza.getPlansze()[maszt.getWspolrzedne().x][maszt.getWspolrzedne().y - 1] == "O") {
				return false;
			}
		}else {
			return true;
		}
		
		if(plansza.getPlansze()[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y - 2] == "O") {
			return true;
		}else if(plansza.getPlansze()[maszt.getWspolrzedne().x][maszt.getWspolrzedne().y - 1] == "O") {
			return true;
		}else if(plansza.getPlansze()[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y] == "O") {
			return true;
		}else if(plansza.getPlansze()[maszt.getWspolrzedne().x - 2][maszt.getWspolrzedne().y - 1] == "O") {
			return true;
		}else {
			return false;
		}
	}	
}
