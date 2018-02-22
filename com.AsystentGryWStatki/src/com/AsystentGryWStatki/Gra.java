package com.AsystentGryWStatki;
import java.util.Scanner;
import java.util.Random;
import java.awt.*;

public class Gra {

	public static void main(String[] args) {
		Plansza plansza = new Plansza(10, 10);
		Plansza planszaPrzeciwnika = new Plansza(10, 10);
		Scanner skaner = new Scanner(System.in);
		Random generator = new Random();
		boolean czyKoniecGry = false;
		
		plansza.stworzPlansze();
		planszaPrzeciwnika.stworzPlansze();
		
		plansza.pokazPlansze();
		planszaPrzeciwnika.pokazPlansze();
		
		plansza.stawianieStatkow(plansza);
		plansza.stawianieStatkowPrzeciwnika(planszaPrzeciwnika);
		
		plansza.pokazPlansze();
		planszaPrzeciwnika.pokazPlansze();
		
		while(!czyKoniecGry) {
			int x = skaner.nextInt();
			int y = skaner.nextInt();
			
			plansza.strzal(planszaPrzeciwnika, new Point(x, y));
			plansza.strzalPrzeciwnika(plansza, new Point(generator.nextInt(10) + 1, generator.nextInt(10) + 1));
			if(plansza.getListaStatkowGracza().isEmpty()) {
				czyKoniecGry = true;
			}
			if(planszaPrzeciwnika.getListaStatkowPrzeciwnika().isEmpty()) {
				czyKoniecGry = true;
			}
			
			plansza.pokazPlansze();
			planszaPrzeciwnika.pokazPlansze();
		}		
		
		System.out.println("Koniec gry!");
	}
	
	
}
