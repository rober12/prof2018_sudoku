package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
    

	SudokuVerifier sv = new SudokuVerifier();
    
	@Test
	public void sudokuCorrecto() {
 		assertEquals(0, sv.verify(  "915384276" +
 									"843726915" +
 									"762591483" +
 									"698257341" +
 									"327148569" +
 									"154639827" +
 									"436972158" +
 									"279815634" +
 									"581463792"));
    		}
	
	@Test
	public void sudokuNegativos() {
 		assertEquals(-1, sv.verify( "915384276" +
 									"843726915" +
 									"762591483" +
 									"69-8257341" +
 									"327148569" +
 									"154639827" +
 									"436972158" +
 									"279815634" +
 									"581463792"));
    		}	
	@Test
	public void sudokuRepetidosSubgrid() {
 		assertEquals(-2, sv.verify( "915394276" +
 									"843766915" +
 									"762511483" +
 									"698287341" +
 									"327118569" +
 									"154639227" +
 									"436972158" +
 									"279815634" +
 									"581463792"));
    		}
	@Test
	public void sudokuRepetidosFilas() {
 		assertEquals(-3, sv.verify( "915384976" +
									"843726215" +
									"762591483" +
									"698257341" +
									"327148569" +
									"154639827" +
									"436972158" +
									"279815634" +
									"581463792"));
}
	@Test
	public void sudokuRepetidosColumnas() {
 		assertEquals(-4, sv.verify( "915384276" +
									"843726915" +
									"762591483" +
									"638257941" +
									"927148563" +
									"154639827" +
									"436972158" +
									"279815634" +
									"581463792"));
}
	

}
