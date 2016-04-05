package com.twitter.poruke;


/**
 * 
 * @author Miljan Jovic
 * 
 *         Klasa koja sadrzi naziv korisnika i poruku.
 */

public class TwitterPoruka {

	/**
	 * Privatni atribut korisnik, koji predstavlja naziv korisnika koji ce
	 * proslediti poruku.
	 */
	private String korisnik;
	
	/**
	 * Privatni atribut poruka, koji sadrzi tekst koji ce korisnik proslediti.
	 */
	private String poruka;

	/**
	 * Metoda koja vraca naziv korisnika
	 * 
	 * @return String - korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda koja kao parametar prima naziv korisnika i postavlja atribut na
	 * datu vrednost.
	 * 
	 * @param String
	 *            - korisnik
	 * @throws runtimeException
	 *             - kada se kao parametar prosledi null ili prazan string.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja vraca poruku.
	 * 
	 * @return String - poruka
	 */
	public String getPoruka() {
		return "poruka";
	}

	/**
	 * Metoda koja kao parametar prima poruku i postavlja atribut na datu
	 * vrednost.
	 * 
	 * @param String
	 *            - poruka
	 * @throws RuntimeException
	 *             - kada se metodi prosledni poruka koja je jednaka null ili
	 *             koja je duza od 140 karaktera.
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Redefinisana toString metoda.
	 * 
	 * @return String - korsnik i poruka.
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
