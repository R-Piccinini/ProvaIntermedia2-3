package org.generation.italy.model;

import java.util.ArrayList;
import java.util.Scanner;

public class MobileApp {

	private String nome;
	private String sistemaOperativo;
	private float prezzo;
	private ArrayList<Recensione> elencoRecensioni;
	private float ricavoTotale;

	public MobileApp(String nome, String sistemaOperativo, float prezzo) {
		super();
		setNome(nome,null);
		setSistemaOperativo(sistemaOperativo,null);
		setPrezzo(prezzo, null);
		ricavoTotale = 0;
		elencoRecensioni=new ArrayList<Recensione>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome,Scanner sc) {
		
		while (nome.isBlank()) {
			System.out.println("Inserire nome:");
			nome = sc.nextLine();
		}
		
		this.nome = nome;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo,Scanner sc) {
		while (sistemaOperativo.isBlank()) {
			System.out.println("Inserire sistema operativo:");
			sistemaOperativo = sc.nextLine();
		}
		this.sistemaOperativo = sistemaOperativo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo,Scanner sc) {
		while (prezzo <= 0) {
			System.out.println("Inserire prezzo:");
			prezzo = sc.nextFloat();
			sc.nextLine();
		}
		this.prezzo = prezzo;
		
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}

	public void download() {
		ricavoTotale += prezzo;
	}

	public void download(int numeroDownload) {
		ricavoTotale += prezzo * numeroDownload;
	}

	public void riceviRecensione(Recensione recensione) {
		elencoRecensioni.add(recensione);

	}
	public float valutazioneMedia() {
		int stelleTot=0;
		for(Recensione recensione:elencoRecensioni) {
			stelleTot+=recensione.getNumeroStelle();		
		}
		float valutazioneMedia=stelleTot/elencoRecensioni.size();
		return valutazioneMedia;
	
	}

	@Override
	public String toString() {
		return "MobileApp [nome=" + nome + ", sistemaOperativo=" + sistemaOperativo + ", prezzo=" + prezzo + "€]";
	}
}
