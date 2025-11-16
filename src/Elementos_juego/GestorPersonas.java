package Elementos_juego;

//Importaciones
import java.util.ArrayList;
import java.util.List;

//clase Gestor_personas

public class GestorPersonas {
	
	// Lista de personas
	private List<Personas> persona;
	
	
	//Construtor
	public GestorPersonas() {
	persona = new ArrayList<>();
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////																																  ////
	////													lista sde personajes														  ////
	////																															      ////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// A continuación se muestran los parametros de cada personje del juego
	
	//personaje 1 CAROLINA
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(1,"Carolina",
			
			false, 	//chico
			true,	//chica
			true,	//pendientes
			true,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			true,	//ojos oscuros
			false, 	//ojos desconocidos
			
			false,	//piel clara
			true,	//piel intermedia
			false,	//piel oscura
			
			"Personaje 1 CAROLINA.png",
			"Personaje descartado.png"));
			
	
	//personaje 2 CRISTINA
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(2,"Cristina",
			false, 	//chico
			true,	//chica
			true,	//pendientes
			true,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
			
			true,	//ojos claros
			false,	//ojos oscuros
			false, 	//ojos desconocidos
			
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
			
			"Personaje 2 CRISTINA.png",
			"Personaje descartado.png"));
	
	//personaje 3 GABRIELA
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(3,"Gabriela",
			false, 	//chico
			true,	//chica
			true,	//pendientes
			false,	//gafas
			false,	//barba
			false,	//bigote
			true, 	//pecas 
			
			true,	//pelo rubio
			false, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			false,	//ojos oscuros
			true, 	//ojos desconocidos
			
			true,	//piel clara
			false,	//piel intermedia
			false,	//piel oscura
			
			"Personaje 3 GABRIELA.png",
			"Personaje descartado.png"));
	
	//personaje 4 OSCAR
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(4,"Óscar",
			true, 	//chico
			false,	//chica
			false,	//pendientes
			false,	//gafas
			true,	//barba
			true,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			false,	//ojos oscuros
			true, 	//ojos desconocidos
			
			false,	//piel clara
			true,	//piel intermedia
			false,	//piel oscura
			
			"Personaje 4 OSCAR.png",
			"Personaje descartado.png"));
	
	//personaje 5 MARIA
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(5,"María",
			false, 	//chico
			true,	//chica
			true,	//pendientes
			false,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			false, 	//pelo moreno
			true, 	//pelo negro
			
			false,	//ojos claros
			true,	//ojos oscuros
			false, 	//ojos desconocidos
			
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
			
			"Personaje 5 MARIA.png",
			"Personaje descartado.png"));
	
	//personaje 6 BORJA
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(6,"Borja",
			true, 	//chico
			false,	//chica
			false,	//pendientes
			true,	//gafas
			true,	//barba
			true,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			false, 	//pelo moreno
			true, 	//pelo negro
			
			false,	//ojos claros
			true,	//ojos oscuros
			false, 	//ojos desconocidos
			
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
			
			"Personaje 6 BORJA.png",
			"Personaje descartado.png"));
	
	//personaje 7 LORETO
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(7,"Loreto",
			false, 	//chico
			true,	//chica
			false,	//pendientes
			true,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			false,	//ojos oscuros
			true, 	//ojos desconocidos
			
			true,	//piel clara
			false,	//piel intermedia
			false,	//piel oscura
			
			"Personaje 7 LORETO.png",
			"Personaje descartado.png"));
	
	//personaje 8 NACHO
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(8,"Nacho",
			true, 	//chico
			false,	//chica
			true,	//pendientes
			true,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
			
			true,	//pelo rubio
			false, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			false,	//ojos oscuros
			true, 	//ojos desconocidos
			
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
			
			"Personaje 8 NACHO.png",
			"Personaje descartado.png"));
	
	//personaje 9 BEATRIZ
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(9,"Beatriz",
			false, 	//chico
			true,	//chica
			true,	//pendientes
			true,	//gafas
			false,	//barba
			false,	//bigote
			true, 	//pecas 
			
			false,	//pelo rubio
			false, 	//pelo moreno
			true, 	//pelo negro
			
			true,	//ojos claros
			false,	//ojos oscuros
			false, 	//ojos desconocidos
			
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
			
			"Personaje 9 BEATRIZ.png",
			"Personaje descartado.png"));
	
	//personaje 10 PEDRO
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(10,"Pedro",
			true, 	//chico
			false,	//chica
			false,	//pendientes
			true,	//gafas
			true,	//barba
			true,	//bigote
			false, 	//pecas 
			
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			true,	//ojos oscuros
			false, 	//ojos desconocidos
			
			true,	//piel clara
			false,	//piel intermedia
			false,	//piel oscura
			"Personaje 10 PEDRO.png",
			"Personaje descartado.png"));
	
	//personaje 11 RAQUEL
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(11,"Raquel",
			false, 	//chico
			true,	//chica
			false,	//pendientes
			false,	//gafas
			false,	//barba
			false,	//bigote
			true, 	//pecas 
			
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
			
			false,	//ojos claros
			true,	//ojos oscuros
			false, 	//ojos desconocidos
			
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
			"Personaje 11 RAQUEL.png",
			"Personaje descartado.png"));
	
	//personaje 12 SARA
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(12,"Sara",
			false, 	//chico
			true,	//chica
			true,	//pendientes
			false,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
				
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
				
			true,	//ojos claros
			false,	//ojos oscuros
			false, 	//ojos desconocidos
				
			false,	//piel clara
			true,	//piel intermedia
			false,	//piel oscura
				
			"Personaje 12 SARA.png",
			"Personaje descartado.png"));

	//personaje 13 INES
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(13,"Inés",
			false, 	//chico
			true,	//chica
			false,	//pendientes
			true,	//gafas
			false,	//barba
			false,	//bigote
			false, 	//pecas 
				
			false,	//pelo rubio
			true, 	//pelo moreno
			false, 	//pelo negro
				
			true,	//ojos claros
			false,	//ojos oscuros
			false, 	//ojos desconocidos
				
			false,	//piel clara
			true,	//piel intermedia
			false,	//piel oscura
				
			"Personaje 13 INES.png",
			"Personaje descartado.png"));
		
	//personaje 14 DANIEL
	// -------------------------------------------------------------------------------------------------------------------------------------//
	persona.add(new Personas(14,"Daniel",
			true, 	//chico
			false,	//chica
			false,	//pendientes
			false,	//gafas
			false,	//barba
			true,	//bigote
			false, 	//pecas 
				
			false,	//pelo rubio
			false, 	//pelo moreno
			true, 	//pelo negro
				
			false,	//ojos claros
			false,	//ojos oscuros
			true, 	//ojos desconocidos
				
			false,	//piel clara
			false,	//piel intermedia
			true,	//piel oscura
				
			"Personaje 14 DANIEL.png",
			"Personaje descartado.png"));
		
	//personaje 15 SUSANA
	// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(15,"Susana",
				false, 	//chico
				true,	//chica
				true,	//pendientes
				true,	//gafas
				false,	//barba
				false,	//bigote
				true, 	//pecas 
				
				false,	//pelo rubio
				false, 	//pelo moreno
				true, 	//pelo negro
				
				false,	//ojos claros
				true,	//ojos oscuros
				false, 	//ojos desconocidos
				
				true,	//piel clara
				false,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 15 SUSANA.png",
				"Personaje descartado.png"));
		
		//personaje 16 RAMON
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(16,"Ramón",
				true, 	//chico
				false,	//chica
				false,	//pendientes
				false,	//gafas
				false,	//barba
				false,	//bigote
				true, 	//pecas 
				
				true,	//pelo rubio
				false, 	//pelo moreno
				false, 	//pelo negro
				
				true,	//ojos claros
				false,	//ojos oscuros
				false, 	//ojos desconocidos
				
				true,	//piel clara
				false,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 16 RAMON.png",
				"Personaje descartado.png"));
		
		//personaje 17 CATALINA
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(17,"Catalina",
				false, 	//chico
				true,	//chica
				true,	//pendientes
				false,	//gafas
				false,	//barba
				false,	//bigote
				false, 	//pecas 
				
				false,	//pelo rubio
				false, 	//pelo moreno
				true, 	//pelo negro
				
				false,	//ojos claros
				true,	//ojos oscuros
				false, 	//ojos desconocidos
				
				false,	//piel clara
				false,	//piel intermedia
				true,	//piel oscura
				
				"Personaje 17 CATALINA.png",
				"Personaje descartado.png"));
		
		//personaje 18 ARTURO
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(18,"Arturo",
				true, 	//chico
				false,	//chica
				
				false,	//pendientes
				false,	//gafas
				false,	//barba
				true,	//bigote
				false, 	//pecas 
				
				true,	//pelo rubio
				false, 	//pelo moreno
				false, 	//pelo negro
				
				true,	//ojos claros
				false,	//ojos oscuros
				false, 	//ojos desconocidos
				
				true,	//piel clara
				false,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 18 ARTURO.png",
				"Personaje descartado.png"));
		
		//personaje 19 CARLOS
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(19,"Carlos",
				true, 	//chico
				false,	//chica
				
				false,	//pendientes
				false,	//gafas
				false,	//barba
				false,	//bigote
				false, 	//pecas 
				
				false,	//pelo rubio
				false, 	//pelo moreno
				true, 	//pelo negro
				
				true,	//ojos claros
				false,	//ojos oscuros
				false, 	//ojos desconocidos
				
				false,	//piel clara
				false,	//piel intermedia
				true,	//piel oscura
				
				"Personaje 19 CARLOS.png",
				"Personaje descartado.png"));
	
		//personaje 20 JESUS
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(20,"Jesús",
				true, 	//chico
				false,	//chica
				
				true,	//pendientes
				false,	//gafas
				true,	//barba
				true,	//bigote
				true, 	//pecas 
				
				false,	//pelo rubio
				false, 	//pelo moreno
				true, 	//pelo negro
				
				false,	//ojos claros
				true,	//ojos oscuros
				false, 	//ojos desconocidos
				
				false,	//piel clara
				true,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 20 JESUS.png",
				"Personaje descartado.png"));
		
		//personaje 21 VERONICA
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(21,"Verónica",
				false, 	//chico
				true,	//chica
				
				true,	//pendientes
				false,	//gafas
				false,	//barba
				false,	//bigote
				false, 	//pecas 
				
				true,	//pelo rubio
				false, 	//pelo moreno
				false, 	//pelo negro
				
				true,	//ojos claros
				false,	//ojos oscuros
				false, 	//ojos desconocidos
				
				true,	//piel clara
				false,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 21 VERONICA.png",
				"Personaje descartado.png"));
		
		//personaje 22 JORGE
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(22,"Jorge",
				true, 	//chico
				false,	//chica
				
				false,	//pendientes
				true,	//gafas
				false,	//barba
				true,	//bigote
				false, 	//pecas 
				
				true,	//pelo rubio
				false, 	//pelo moreno
				false, 	//pelo negro
				
				false,	//ojos claros
				false,	//ojos oscuros
				true, 	//ojos desconocidos
				
				false,	//piel clara
				true,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 22 JORGE.png",
				"Personaje descartado.png"));
		
		//personaje 23 ALBERTO
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(23,"Alberto",
				true, 	//chico
				false,	//chica
				
				true,	//pendientes
				false,	//gafas
				true,	//barba
				false,	//bigote
				true, 	//pecas 
				
				false,	//pelo rubio
				true, 	//pelo moreno
				false, 	//pelo negro
				
				true,	//ojos claros
				false,	//ojos oscuros
				false, 	//ojos desconocidos
				
				false,	//piel clara
				true,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 23 ALBERTO.png",
				"Personaje descartado.png"));
		
		//personaje 24 ALEJANDRO
		// -------------------------------------------------------------------------------------------------------------------------------------//
		persona.add(new Personas(24,"Alejandro",
				true, 	//chico
				false,	//chica
				
				true,	//pendientes
				false,	//gafas
				true,	//barba
				true,	//bigote
				false, 	//pecas
				
				false,	//pelo rubio
				true, 	//pelo moreno
				false, 	//pelo negro
				
				true,	//ojos claros
				false,	//ojos oscuros
				false, 	//ojos desconocidos
				
				false,	//piel clara
				true,	//piel intermedia
				false,	//piel oscura
				
				"Personaje 24 ALEJANDRO.png",
				"Personaje descartado.png"));
		
	
	}//end Constructor Gestor personas
	
	
	//Metodo para obtener personas
	public List<Personas> getListaPersonajes() {
	    return persona;
	}
	
	
	
}//End Gestor_personas

