package test1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Usuario;
import model.Pelicula;
import datos.Catalogo;
import excepciones.CatalogoException;

/**
 * <p><b> Nombre </b> MovieFlixTest </p>
 * 
 * <p><strong>Descripcion </strong> pruebas unitarias</p>
 * 
 * @author	Gintare Bartuseviciute
 * 
 * @version	v2
 * 
 * @since	20/03/2021
 */


public class MovieFlixTest {
	private Usuario u1;
	private Pelicula p1;
	private Catalogo c1;

	
	@Before
	public void instanciacion() {
		 u1 = new Usuario();
		 p1 = new Pelicula();
		 c1 = new Catalogo();
		 
	}
	
	//Author: Darío
	@Test //Aseguro que existe usuario
	public void instanciarusuarioTest() {
		assertNotNull(u1);
	}
	//Author: Darío
	@Test //Aseguro que el usuario tiene nombre
	public void setNombreUsuarioTest() {
		u1.setNombreUsuario("Fernando");
		assertNotNull(u1.getNombreUsuario());
	}
	
	//Author: Darío
	@Test //Aseguro que el nombre asignado a usuario es igual al que tendría que ser
	public void setNombUsuarioTest() {
		u1.setNombreUsuario("Fernando");
		String expected = "Fernando";
		assertEquals(expected, u1.getNombreUsuario());
	}
	
	//Author: Gintare
	@Test //Aseguro que existe pelicula
	public void instanciarpeliculaTest() {
		assertNotNull(p1);
	}
	
	//Author: Antonia
	@Test // Aseguro que existe catalogo
	public void instanciarCatalogo() {
	    Assert.assertNotNull(c1);
	}
	
	//Author: Yelder
	@Test //Aseguro que hay un codigo
	public void agregarPeliculaTest() throws CatalogoException {
		c1.agregarPelicula(1, p1);
		assertTrue(c1.getCatalogo().containsKey(1));
	}
	
	//Author: Toni
	@Test // Aseguro que haya una pelicula
	public void agregarPeliculaValorTest() throws CatalogoException {
		c1.agregarPelicula(2, p1);
		assertNotNull(c1.getCatalogo().get(2));
	}
	
	
}

