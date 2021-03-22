
package utilidades;
import java.util.Scanner;

/**
 * <p><b> Nombre </b> LecturaDatos</p>
 * 
 * <p><strong>Descripcion </strong>clase con metodos para leer datos</p>
 * 
 * @author	Antonia Hidalgo
 * @version	v1
 * 
 * @since	17/03/2021
 */
//libreria para usar métodos Scanner

@SuppressWarnings ("resource")
public class LecturaDatos {
	public static String leerString() {
		return new Scanner(System.in).nextLine();
	}
	public static String leerString(String msg) {
		System.out.print(msg);
		return leerString();
	}
	public static double leerDouble() {
	return new Scanner(System.in).nextDouble();
	}
	public static double leerDouble(String msg) {
		System.out.print(msg);
		return leerDouble();
	}
	public static int leerInt() {
		return new Scanner(System.in).nextInt();
	}
	public static int leerInt(String msg) {
		System.out.print(msg);
		return leerInt();
	}
	public static byte leerByte() {
		return new Scanner(System.in).nextByte();
	}
	public static byte leerByte(String msg) {
		System.out.print(msg);
		return leerByte();
	}
	public static boolean leerBoolean() {
		return new Scanner(System.in).nextBoolean();
	}
	public static boolean leerBoolean(String msg) {
		System.out.print(msg);
		return leerBoolean();
	}
}
	
