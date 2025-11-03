package Elementos_juego;


// Clase personas 

public class Personas {
	// Orden variables, id,nombre, esChico, esChica, llevaPendientes, llevaGafas, llevaBarva, llevaBigote, pecas
	// pelo rubio, pelo moreno, pelo negro, ojos claros, ojos oscuros, ojos desconocidos, piel clara, piel intermedia, piel occura
	// Imagen del personaje
	// imagen del personaje descartado
	
	
	// variables generales de los personajes
	private int id;
	private String nombre;
	private boolean esChico;
	private boolean esChica;
	private boolean llevaPendientes;
	private boolean llevaGafas;
	private boolean llevaBarba;
	private boolean llevaBigote;
	private boolean pecas;
	private boolean peloRubio;
	private boolean peloMoreno;
	private boolean peloNegro;
	private boolean ojosClaros;
	private boolean ojosOscuros;
	private boolean ojosDesconocidos;
	private boolean pielClara;
	private boolean pielIntermedia;
	private boolean pielOscura;
	
	//Variables de graficos para los personajes
	private String archivoImagen;
	private String imagenTachado;
	

// Constructor
public Personas (int id, String nombre, boolean esChico, boolean esChica, boolean llevaPendientes, 
		boolean llevaGafas, boolean llevaBarba, boolean llevaBigote, boolean pecas, 
		boolean peloRubio, boolean peloMoreno, boolean peloNegro, 
		boolean ojosClaros, boolean ojosOscuros, boolean ojosDesconocidos,
		boolean pielClara, boolean pielIntermedia, boolean pielOscura, 
		String archivoImagen, String imagenTachado) {
	
	this.id = id;
	this.nombre = nombre;
	this.esChico = esChico;
	this.esChica = esChica;
	this.llevaPendientes = llevaPendientes;
	this.llevaGafas = llevaGafas;
	this.llevaBarba = llevaBarba;
	this.llevaBigote = llevaBigote;
	this.pecas = pecas;
	this.peloRubio = peloRubio;
	this.peloMoreno = peloMoreno;
	this.peloNegro = peloNegro;
	this.ojosClaros = ojosClaros;
	this.ojosOscuros = ojosOscuros;
	this.ojosDesconocidos = ojosDesconocidos;
	this.pielClara = pielClara;
	this.pielIntermedia = pielIntermedia;
	this.pielOscura = pielOscura;
	
	this.archivoImagen = archivoImagen;
	this.imagenTachado = imagenTachado;
	
}//end constructor


//-------------------------------------------------------------------------------------------------------------
//metodos
//-------------------------------------------------------------------------------------------------------------

//metodo para saber la ID de cada personaje
public int getId() {
    return id;
}



//metodo para devolver un nombre
public String getNombre() {
	return nombre;
	
}//end



//metodo para saber si el personaje es chico
public boolean esChico() {
    return esChico; 
}//end
		


//metodo para saber si el personaje es chica
public boolean esChica() {
    return esChica; 
}//end



//metodo para saber si el personaje lleva pendientes
public boolean llevaPendientes() {
return llevaPendientes; 
}//end



//metodo para saber si el personaje lleva gafas
public boolean llevaGafas() {
  return llevaGafas; 
}//end



//metodo para saber si el personaje lleva barba
public boolean llevaBarba() {
return llevaBarba; 
}//end



//metodo para saber si el personaje lleva bigote
public boolean llevaBigote() {
return llevaBigote; 
}//end


//metodo para saber si el personaje tiene pecas
public boolean tienePecas() {
return pecas; 
}//end



//metodo para saber si el personaje tiene el pelo rubio
public boolean tienePeloRubio() {
return peloRubio; 
}//end



//metodo para saber si el personaje tiene el pelo moreno
public boolean tienePeloMoreno() {
return peloMoreno; 
}//end



//metodo para saber si el personaje tiene el pelo moreno
public boolean tienePeloNegro() {
return peloNegro; 
}//end



//metodo para saber si el personaje tiene los ojos claros
public boolean tieneOjosClaros() {
return ojosClaros; 
}//end



//metodo para saber si el personaje tiene los ojos oscuros
public boolean tieneOjosOscuros() {
return ojosOscuros; 
}//end



//metodo para saber si el personaje tiene los ojos tapados
public boolean tieneOjosOcultos() {
return ojosDesconocidos; 
}//end



//metodo para saber si el personaje tiene un tono de piel clara
public boolean tienePielClara() {
return pielClara; 
}//end



//metodo para saber si el personaje tiene un tono de piel normal
public boolean tienePielNormal() {
return pielIntermedia; 
}//end



//metodo para saber si el personaje tiene un tono de piel normal
public boolean tienePielOscura() {
return pielOscura; 
}//end



//metodo para encontar la ruta de las imagenes
public String getRutaImagen() {
    return "img/" + archivoImagen;
}



public String getImagenTachado() {
    return "img/" + imagenTachado;
}


//metodo para comparar si una persona tiene un atributo en particular
public boolean tieneAtributo(String atributo) {
	switch (atributo.toLowerCase()) {
	case "es chico": return this.esChico;
    case "es chica": return this.esChica;
    case "lleva gafas": return this.llevaGafas;
    case "lleva pendientes": return this.llevaPendientes;
    case "lleva barba": return this.llevaBarba;
    case "lleva bigote": return this.llevaBigote;
    case "pecas": return this.pecas;
    case "pelo rubio": return this.peloRubio;
    case "pelo moreno": return this.peloMoreno;
    case "pelo negro": return this.peloNegro;
    case "ojos claros": return this.ojosClaros;
    case "ojos oscuros": return this.ojosOscuros;
    case "ojos desconocidos": return this.ojosDesconocidos;
    case "piel clara": return this.pielClara;
    case "piel intermedia": return this.pielIntermedia;
    case "piel oscura": return this.pielOscura;
    default: return false;
	
	}
}//end metodo



//metodo para comprar 2 objetos por su ID
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Personas otra = (Personas) obj;
    return this.id == otra.id;
}//end

//metodo para mostar la ID obtenida (Asi sabemos el personaje que es)
public int hashCode() {
    return Integer.hashCode(id);
}

}//End clase personas