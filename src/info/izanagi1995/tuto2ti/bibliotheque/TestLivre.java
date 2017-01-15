package info.izanagi1995.tuto2ti.bibliotheque;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestLivre {
	
	static Livre livre1 = new Livre("Test", "Jules Vernes", 1910, new String[]{"Coucou", "Page 2"});
	static Livre livre2 = new Livre("Test", "Jules Vernes", 1910, new String[]{"Coucou", "Page 2"});

	@Test
	public void test() {
		assertTrue(livre1.equals(livre2));
	}
	
	@Test
	public void testSetAuteur(){
		livre1.setAuteur("Un autre auteur");
		assertEquals("Un autre auteur", livre1.getAuteur());
		livre2.setAuteur("");
		assertEquals("Auteur inconnu", livre2.getAuteur());
	}
	
	@Test
	public void testGetPage(){
		assertNull(livre1.getPage(-1));
		assertEquals("Page 2", livre1.getPage(2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMauvaisePage(){
		livre1.setPage(999999, "Test mauvaise page");
	}
	
	@Test
	public void testBonnePage(){
		String oldPage = livre2.setPage(1, "Hello");
		assertEquals("Coucou", oldPage);
		assertEquals("Hello", livre2.getPage(1));
	}

}
