package model;

public enum Categorias {
	
	policiaca(5),  romantica(7),  aventuras(3),  comedia(6), animacion(5), thriller(10);
	
	private int Categoria;

	private Categorias(int categoria) {
		Categoria = categoria;
	}

	public int getCategoria() {
		return Categoria;
	}

	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	
	
	
	
	
	
	
	

}