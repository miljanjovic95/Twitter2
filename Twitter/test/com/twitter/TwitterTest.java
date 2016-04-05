package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("Pera", "test");
		t.unesi("Mika", "test2");

		assertEquals(t.vratiSvePoruke().size(), 2);

	}

	@Test
	public void testUnesi() {
		TwitterPoruka tPoruka = new TwitterPoruka();
		tPoruka.setKorisnik("Pera");
		tPoruka.setPoruka("test");
		t.unesi("Pera", "test");
		LinkedList<TwitterPoruka> tp = t.vratiSvePoruke();
		assertEquals(tp.getFirst().toString(), tPoruka.toString());
		// greska: u metodi setKorisnik smo prosledjivali string "korisnik"
		// umesto parametar korisnik
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		TwitterPoruka[] niz = t.vratiPoruke(10, "");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanNull() {
		TwitterPoruka[] niz = t.vratiPoruke(10, null);
	}

	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Mika");
		tp.setPoruka("#test2");
		t.unesi("Pera", "test1");
		t.unesi("Mika", "#test2");
		t.unesi("Zika", "#test3");
		TwitterPoruka[] niz = t.vratiPoruke(10, "#");
		assertEquals(tp.toString(), niz[0].toString());

	}

}
