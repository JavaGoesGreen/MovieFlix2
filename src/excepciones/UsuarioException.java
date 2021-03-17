package excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioException extends Exception {

	private static final long serialVersionUID = 1L;

	private Level level;

	public UsuarioException() {
	}

	public UsuarioException(String message) {
		super(message);
	}

	public UsuarioException(Throwable cause) {
		super(cause);
	}

	public UsuarioException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UsuarioException(String message, int tipo) {
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
		Logger.getLogger(UsuarioException.class.getName()).log(level, null, super.getMessage());
		return super.getMessage();
	}

}
