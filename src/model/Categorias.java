package model;

import model.Categorias;

public enum Categorias {
	
	policiaca(1),  romantica(2),  aventuras(3),  comedia(4), animacion(5), thriller(6);
	
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
	
	private static Categorias[] values = null;

    public static Categorias dimeUnaCategoria(int val) {
        if (Categorias.values == null) {
            Categorias.values = Categorias.values();
        }
       
        return Categorias.values[val];
    }	
		

}