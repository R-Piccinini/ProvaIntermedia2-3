package org.generation.italy;

import java.time.LocalDate;
import java.util.Scanner;

import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Creazione nuova app");
		System.out.println("Inserire nome:");
		String nome = sc.nextLine();
		String scelta;
		float valutazioneMedia = 0;

		System.out.println("Inserire sistema operativo:");
		String sistemaOperativo = sc.nextLine();

		System.out.println("Inserire prezzo:");
		float prezzo = Float.parseFloat(sc.nextLine());

		MobileApp m = new MobileApp(nome, sistemaOperativo, prezzo);

		do {

			System.out.println(m.toString());

			System.out.println(
					"(1-Download Singolo)-(2-Download Multiplo)-(3-Ricevi Recensione)-(4-Visualizza Recensioni)-(5-Esci)");

			System.out.println("");
			scelta = sc.nextLine();

			while (!(scelta.equals("1") || scelta.equals("2") || scelta.equals("3") || scelta.equals("4")
					|| scelta.equals("5"))) {
				System.out.println("Scelta non valida");
				System.out.println();
				System.out.println(
						"(1-Download Singolo)-(2-Download Multiplo)-(3-Ricevi Recensione)-(4-Visualizza Recensioni)-(5-Esci)");
				scelta = sc.nextLine();
			}

			switch (scelta) {

			case ("1"):
				m.download();
				break;
			case ("2"):
				System.out.println("Inserire numero di download:");
				int nDownload = sc.nextInt();
				sc.nextLine();
				m.download(nDownload);
				break;
			case ("3"):
				LocalDate dataRec = LocalDate.now();
				System.out.println("Inserisci nome utente:");
				String nomeUtente = sc.nextLine();

				System.out.println("Inserisci numero stelle:");
				int numeroStelle;
				numeroStelle = sc.nextInt();
				sc.nextLine();

				System.out.println("Inserisci commento:");
				String testo = sc.nextLine();

				Recensione recensione = new Recensione(dataRec, nomeUtente, numeroStelle, testo);
				m.riceviRecensione(recensione);
				break;
			case ("4"):
				for (Recensione recensione2 : m.getElencoRecensioni()) {
					System.out.println(recensione2.toString());
					System.out.println();
				}
				break;
			case ("5"):
				break;
			}

			Float ricavoTotale = m.getRicavoTotale();
			if(ricavoTotale>0) {
			valutazioneMedia=m.valutazioneMedia();
			}
			System.out.println();
			System.out.println("Ricavo totale: " + ricavoTotale+"€" + " Valutazione media: "+valutazioneMedia);

		} while (!(scelta.equals("5")));
		sc.close();
		System.out.println("Arrivederci");
	}

}
