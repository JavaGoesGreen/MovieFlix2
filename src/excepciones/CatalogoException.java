package excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * <p><b> Nombre </b>  CatalogoException</p>
 * 
 * <p><strong>Descripcion </strong> clase que contiene las excepciones propias del catalogo de peliculas</p>
 * 
 * @author	Antonia Hidalgo
 * @author	Gintare Bartuseviciute
 * @author	Dario Denche
 * @author	Toni Blanche
 * @author	Yelder Da Silva
 * @version	v1
 * 
 * @since	18/03/2021
 */

public class CatalogoException extends Exception {

	private static final long serialVersionUID = 1L;

	private Level level;

	public CatalogoException() {
	}

	public CatalogoException(String message) {
		super(message);
	}

	public CatalogoException(Throwable cause) {
		super(cause);
	}

	public CatalogoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CatalogoException(String message, int tipo) {
		super(message);
		setLevel(tipo);
	}	

	public void setLevel(int tipo) {

		switch (tipo) {
		case 1:
			level = Level.SEVERE;
			break;
		case 2:
			level = Level.WARNING;
			break;
		case 3:
			level = Level.INFO;
			break;
		default:
			level = Level.INFO;
			break;
		}
	}

	@Override
	public String toString() {
		Logger.getLogger(CatalogoException.class.getName()).log(level, null, super.getMessage());
		return super.getMessage();
	}

}
