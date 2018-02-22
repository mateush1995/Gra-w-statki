package com.AsystentGryWStatki;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class Plansza {
	
	private int kolumny;
	private int wiersze;
	private String[][] planszaDoGry;
	private LinkedList<Statek> listaStatkowGracza;
	private LinkedList<Statek> listaStatkowPrzeciwnika;
	
	public Plansza(int kolumny, int wiersze) {
		this.kolumny = kolumny;
		this.wiersze = wiersze;
		listaStatkowGracza = new LinkedList<Statek>();
		listaStatkowPrzeciwnika = new LinkedList<Statek>();
	}
	
	public int getKolumny() {
		return this.kolumny;
	}
	
	public int getWiersze() {
		return this.wiersze;
	}
	
	public void setKolumny(int kolumny) {
		this.kolumny = kolumny;
	}
	
	public void setWiersze(int wiersze) {
		this.wiersze = wiersze;
	}
	
	public String[][] getPlansze(){
		return this.planszaDoGry;
	}
	
	public String [][] stworzPlansze() {
		planszaDoGry = new String[kolumny][wiersze];
		for(int k = 0; k < kolumny; k++) {
			for(int w = 0; w < wiersze; w++) {
				planszaDoGry[k][w] = "-";
			}
		}
		return planszaDoGry;
	}
	
	public void pokazPlansze() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int k = 0; k < this.planszaDoGry.length; k++) {
			for(int w = 0; w < this.planszaDoGry[k].length; w++) {
				System.out.print(this.planszaDoGry[k][w]);
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void dodajMaszt(Maszt maszt) {
		planszaDoGry[maszt.getWspolrzedne().x - 1][maszt.getWspolrzedne().y - 1] = "M";
	}
	
	public void dodajStatek(Statek statek) {
		for(Maszt m : statek.getListaMasztow()) {
			planszaDoGry[m.getWspolrzedne().x - 1][m.getWspolrzedne().y - 1] = "O";
		}
		listaStatkowGracza.add(statek);
	}
	
	public void dodajStatekPrzeciwnika(Statek statek) {
		for(Maszt m : statek.getListaMasztow()) {
			planszaDoGry[m.getWspolrzedne().x - 1][m.getWspolrzedne().y - 1] = "O";
		}
		listaStatkowPrzeciwnika.add(statek);
	}
	
	public LinkedList<Statek> getListaStatkowGracza(){
		return listaStatkowGracza;
	}
	
	public LinkedList<Statek> getListaStatkowPrzeciwnika(){
		return listaStatkowPrzeciwnika;
	}
	
	public void stawianieStatkow(Plansza plansza) {
		boolean planszaNieGotowa = true;
		Scanner skaner = new Scanner(System.in);
		Point [] czteromasztowiec = new Point[4];
		Point [] trojmasztowiec = new Point[3];
		Point [] dwumasztowiec = new Point[2];
		Point jednomasztowiec  = new Point();
		
		while(planszaNieGotowa) {
			int x, y;
			System.out.println("Postaw statki, najpierw oœ OY potem oœ OX");
			System.out.println("Stwórz czteromasztowiec: ");
			for(int i = 0; i < 4; i++) {
				x = skaner.nextInt();
				y = skaner.nextInt();
				czteromasztowiec[i] = new Point(x, y);
			}
			Statek statek = new Statek(plansza, 4, czteromasztowiec);
			plansza.dodajStatek(statek);
			
			System.out.println("Stwórz dwa trzymasztowce: ");
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 3; j++) {
					x = skaner.nextInt();
					y = skaner.nextInt();
					trojmasztowiec[j] = new Point(x, y);
				}
				statek = new Statek(plansza, 3, trojmasztowiec);
				plansza.dodajStatek(statek);
			}
			
			System.out.println("Stwórz trzy dwumasztowce: ");
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					x = skaner.nextInt();
					y = skaner.nextInt();
					dwumasztowiec[j] = new Point(x, y);
				}
				statek = new Statek(plansza, 2, dwumasztowiec);
				plansza.dodajStatek(statek);
			}
			
			System.out.println("Stwórz cztery jednomasztowce");
			for(int i = 0; i < 4; i++) {
				x = skaner.nextInt();
				y = skaner.nextInt();
				jednomasztowiec = new Point(x, y);
				statek = new Statek(plansza, 1, jednomasztowiec);
				plansza.dodajStatek(statek);
			}
			
			planszaNieGotowa = false;
		}
	}
	
	public void stawianieStatkowPrzeciwnika(Plansza plansza) {
		boolean planszaNieGotowa = true;
		Point [] czteromasztowiec = new Point[4];
		Point [] trojmasztowiec = new Point[3];
		Point [] dwumasztowiec = new Point[2];
		Point jednomasztowiec  = new Point();
		Random generator = new Random();
		
		while(planszaNieGotowa) {
			int x, y;
			System.out.println("Postaw statki, najpierw oœ OY potem oœ OX");
			System.out.println("Stwórz czteromasztowiec: ");
			for(int i = 0; i < 4; i++) {
				x = generator.nextInt(10) + 1;
				y = generator.nextInt(10) + 1;
				czteromasztowiec[i] = new Point(x, y);
			}
			Statek statek = new Statek(plansza, 4, czteromasztowiec);
			plansza.dodajStatekPrzeciwnika(statek);
			
			System.out.println("Stwórz dwa trzymasztowce: ");
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 3; j++) {
					x = generator.nextInt(10) + 1;
					y = generator.nextInt(10) + 1;
					trojmasztowiec[j] = new Point(x, y);
				}
				statek = new Statek(plansza, 3, trojmasztowiec);
				plansza.dodajStatekPrzeciwnika(statek);
			}
			
			System.out.println("Stwórz trzy dwumasztowce: ");
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					x = generator.nextInt(10) + 1;
					y = generator.nextInt(10) + 1;
					dwumasztowiec[j] = new Point(x, y);
				}
				statek = new Statek(plansza, 2, dwumasztowiec);
				plansza.dodajStatekPrzeciwnika(statek);
			}
			
			System.out.println("Stwórz cztery jednomasztowce");
			for(int i = 0; i < 4; i++) {
				x = generator.nextInt(10) + 1;
				y = generator.nextInt(10) + 1;
				jednomasztowiec = new Point(x, y);
				statek = new Statek(plansza, 1, jednomasztowiec);
				plansza.dodajStatekPrzeciwnika(statek);
			}
			
			planszaNieGotowa = false;
		}
	}
	
	public void strzal(Plansza plansza, Point strzal) {
		boolean flaga = false;
		LinkedList<Statek> listaTymczasowaStatkow = new LinkedList<Statek>();
		LinkedList<Maszt> listaTymczasowaMasztow = new LinkedList<Maszt>();
		for(Statek statek : plansza.listaStatkowPrzeciwnika) {
			for(Maszt maszt : statek.getListaMasztow()) {
				if(maszt.getWspolrzedne().x == strzal.x && maszt.getWspolrzedne().y == strzal.y) {
					if(plansza.getPlansze()[strzal.x - 1][strzal.y - 1] == "O") {
						plansza.getPlansze()[strzal.x - 1][strzal.y - 1] = "X";
						maszt.setCzyZestrzelony();
						listaTymczasowaMasztow.add(maszt);
						flaga = true;
					}
				}
			}
			statek.getListaMasztow().removeAll(listaTymczasowaMasztow);
			if(statek.getListaMasztow().isEmpty()) {
				listaTymczasowaStatkow.add(statek);
			}
		}
		
		plansza.listaStatkowPrzeciwnika.removeAll(listaTymczasowaStatkow);
		
		if(!flaga) {
			System.out.println("Pud³o");
			plansza.getPlansze()[strzal.x - 1][strzal.y - 1] = "P";
		}
	}
	
	public void strzalPrzeciwnika(Plansza plansza, Point strzal) {
		boolean flaga = false;
		LinkedList<Statek> listaTymczasowaStatkow = new LinkedList<Statek>();
		LinkedList<Maszt> listaTymczasowaMasztow = new LinkedList<Maszt>();
		for(Statek statek : plansza.listaStatkowGracza) {
			for(Maszt maszt : statek.getListaMasztow()) {
				if(maszt.getWspolrzedne().x == strzal.x && maszt.getWspolrzedne().y == strzal.y) {
					if(plansza.getPlansze()[strzal.x - 1][strzal.y - 1] == "O") {
						plansza.getPlansze()[strzal.x - 1][strzal.y - 1] = "X";
						maszt.setCzyZestrzelony();
						//statek.getListaMasztow().remove(maszt);
						listaTymczasowaMasztow.add(maszt);
						flaga = true;
					}
				}
			}
			statek.getListaMasztow().removeAll(listaTymczasowaMasztow);
			if(statek.getListaMasztow().isEmpty()) {
				listaTymczasowaStatkow.add(statek);
			}
		}
		
		plansza.listaStatkowGracza.removeAll(listaTymczasowaStatkow);
		
		if(!flaga) {
			System.out.println("Pud³o");
			plansza.getPlansze()[strzal.x - 1][strzal.y - 1] = "P";
		}
	}

}
