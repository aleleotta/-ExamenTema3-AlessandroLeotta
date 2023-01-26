package fraccion;
/**
 * Clase que se usa para operar con fracciones.
 * @author aleleotta
 *
 */
// Clase que define una fracción
public class Fraccion {
	// Numerador
	/**
	 * Numerador
	 */
	private int num;
	
	// Denominador
	/**
	 * Denominador
	 */
	private int den;

	// Constructor por defecto
	/**
	 * Es el constructor por defecto donde se usa una fraccion que resulta siempre en 0.
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	/**
	 * Es el constructor con parametros donde las fracciones no resultan en 0.
	 * @param num Numerador
	 * @param den Denominador
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fraccion simplificada
		simplificar();
	}

	// Constructor copia
	/**
	 * Copia del constructor.
	 * @param f Fraccion
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters
	/**
	 * Setter del numerador.
	 * @param num Numero
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * Getter del numerador.
	 * @return Devuelve el numerador.
	 */
	public int getNum() {
		return num;

	}
	/**
	 * Setter del denominador.
	 * @param den Denominador
	 */
	public void setDen(int den) {
		this.den = den;
	}
	/**
	 * Getter del denominador.
	 * @return Devuelve el denominador.
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * Calculo del maximo comun divisor por el algoritmo de Euclides.
	 * @return Devuelve el resultado del M.C.D.
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * Metodo para simplificar fracciones.
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString
	/**
	 * Metodo que genera un mensaje.
	 * @return Devuelve el mensaje.
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	/**
	 * Suma de fracciones.
	 * @param f Fraccion
	 * @return Devuelve el auxiliar.
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones
	/**
	 * Restar fracciones.
	 * @param f Fraccion
	 * @return Devuelve el auxiliar.
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
	/**
	 * Multiplicar fracciones.
	 * @param f Fraccion
	 * @return Devuelve el auxiliar.
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
	/**
	 * Dividir fracciones.
	 * @param f Fraccion
	 * @return Devuelve el auxiliar.
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;
	}
}
