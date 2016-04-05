package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	@Test
	public void testSetKorisnikNaziv() {
		TwitterPoruka tp = new TwitterPoruka();
		String k = "Pera";
		tp.setKorisnik(k);
		assertEquals("Pera", tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		TwitterPoruka tp = new TwitterPoruka();
		String k = null;
		tp.setKorisnik(k);
		assertEquals(null, tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(new String(""));
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaStringDuziOd140() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setPoruka("hahahahahahahahahahahahahah" + "ahahahahahahahahahahahahahahahahahah"
				+ "ahahahahahahahahahahahahahahahahahahahahahahahaha" + "hahahahahahahahahaha"
				+ "hahahahahahahahahahahahahahahahahahahahaha" + "hahahaha");
		// ima vise od 140 karaktera
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		TwitterPoruka tp = new TwitterPoruka();
		String k = null;
		tp.setPoruka(k);
	}

	@Test
	public void testToString() {
		TwitterPoruka tp = new TwitterPoruka();
		String s = "KORISNIK:" + tp.getKorisnik() + " PORUKA:" + tp.getPoruka();
		assertEquals(s, tp.toString());
		// Greska u get metodi jer se ne vraca atribut poruka vec string
		// "poruka"
	}

}
