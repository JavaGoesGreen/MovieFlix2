package excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	// 1: ERROR
	// 2: WARNING
	// 3: INFO
	public CatalogoException(String message, int tipo) {
		super(message);
		setLevel(tipo);
	}	

	public void setLevel(int tipo) {

		switch (tipo) {
		case 1:
			level = Level.SEVERE;
			//OMG.. llama a los marines, a spiderman, a Bob Esponja...
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
