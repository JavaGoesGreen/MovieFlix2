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

    public static Categorias dimeCategorias(int valor) {
    	Categorias c =Categorias.values()[valor];
    	switch(valor) {
    	case 1:
    		c=Categorias.policiaca;
    		
    	case 2:
    		c=Categorias.romantica;
    	case 3:
    		c=Categorias.aventuras;
    	case 4:
    		c=Categorias.comedia;
    	case 5:
    	    c=Categorias.animacion;
    	case 6:
    		c=Categorias.thriller;
    	}
    	return c;
    	
    }


}