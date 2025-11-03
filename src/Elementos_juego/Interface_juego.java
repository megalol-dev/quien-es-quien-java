package Elementos_juego;


//importaciones
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;
import java.util.Map;        
import java.util.HashMap; 

//interface del juego
public class Interface_juego extends JFrame {
	
	// No es obligatorio, pero Java lo recomienda para evitar problemas de serialización en el futuro
	private static final long serialVersionUID = 1L;
	
	//variables generales
	
	//Variables para saber quienes son los personajes y el personaje oculto
	private Personas personajeOculto;
    private List<Personas> listaPersonajes;
    

    //Variable para saber cuanta preguntas y cuantos intentos tienes
    //Una vez tienes 0 preguntas se activa del "modo respuesta" y tendras 3 intentos para revolser quien es el personaje secretro
    private int preguntas = 3;
    private int intentos = 3;
  

	//Variables de los botones de los personajes
	private Map<JButton, Personas> botonesPersonajes = new HashMap<>();
	
	//Variables de los botones de las preguntas
	
	private JButton botonChico;
	private JButton botonChica;
	private JButton botonGafas;
	private JButton botonPendientes;
	private JButton botonBarba;
	private JButton botonBigote;
	private JButton botonPecas;
	private JButton botonPeloRubio;
	private JButton botonPeloMoreno;
	private JButton botonPeloNegro;
	private JButton botonOjosClaros;
	private JButton botonOjosOscuros;
	private JButton botonOjosDesconocidos;
	private JButton botonPielClara;
	private JButton botonPielNormal;
	private JButton botonPielOscura;
	
	

	
	
	
	//variables de las imagenes 
	
	//botones
	ImageIcon iconoChico = new ImageIcon("img/Boton es chico.png");
	ImageIcon iconoChica = new ImageIcon("img/Boton es chica.png");
	ImageIcon iconoGafas = new ImageIcon("img/Boton lleva gafas.png");
	ImageIcon iconoPendientes = new ImageIcon("img/Boton lleva pendientes.png");
	ImageIcon iconoBarba = new ImageIcon("img/Boton lleva barba.png");
	ImageIcon iconoBigote = new ImageIcon("img/Boton lleva bigote.png");
	ImageIcon iconoPecas = new ImageIcon("img/Boton tienes pecas.png");
	ImageIcon iconoPeloRubio = new ImageIcon("img/Boton pelo rubio.png");
	ImageIcon iconoPeloMoreno = new ImageIcon("img/Boton pelo moreno.png");
	ImageIcon iconoPeloNegro = new ImageIcon("img/Boton pelo negro.png");
	ImageIcon iconoOjosClaros = new ImageIcon("img/Boton ojos claros.png");
	ImageIcon iconoOjosOscuros = new ImageIcon("img/Boton ojos oscuros.png");
	ImageIcon iconoOjosDesconocidos = new ImageIcon("img/Boton ojos desconocidos.png");
	ImageIcon iconoPielClara = new ImageIcon("img/Boton piel clara.png");
	ImageIcon iconoPielNormal = new ImageIcon("img/Boton piel normal.png");
	ImageIcon iconoPielOscura = new ImageIcon("img/Boton piel oscura.png");
	//end variables	
	
	
    // Constructor que recibe el personaje oculto y la lista
    public Interface_juego(Personas personajeOculto, List<Personas> listaPersonajes) {
        this.personajeOculto = personajeOculto;
        this.listaPersonajes = listaPersonajes;
        
        
        
        
        
    } //end construtor de interface_juego
			
    
    
	//constructor de la clase juego
	public Interface_juego() {
		
	
		
		
		//PANTALLA
		//titulo de la pantalla
		setTitle("¿Quién es quién en JAVA? Creado por José Luis Escudero Polo");
		
		//tamaño de la pantalla
		setSize(1400,800);
		
		//cerrar el programa al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//centrar la pantalla en la ventana
		setLocationRelativeTo(null);
		
		//Iniciar UI
		initUI();
		
		
		// Nuevos datos para testear
		// Inicializar lista de personajes correctamente
	    GestorPersonas gestor = new GestorPersonas();
	    List<Personas> lista = gestor.getListaPersonajes();
	    this.listaPersonajes = lista; 

	    // Elegir personaje oculto al azar
	    Random alAzar = new Random();
	    personajeOculto = lista.get(alAzar.nextInt(lista.size()));
				
        
        // Mostrar mensaje de bienvenida DESPUÉS de que la interfaz se pinte completamente
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this,
                "¡Hola jugad@r! Bienvenido/a a ¿Quién es quién?\n\n" +
                "Tu objetivo es adivinar qué personaje ha sido elegido al azar.\n" +
                "Tienes hacer 3 preguntas para descartar personajes.\n" +
                "Después tendrás 3 intentos para adivinar quién es.\n\n" +
                "¡Buena suerte!",
                "Inicio del juego",
                JOptionPane.INFORMATION_MESSAGE);
            	
            	//-----------------------------------------------------------------
             	//para testear, dime quien es el personaje oculto
                JOptionPane.showMessageDialog(this,
                    "DEBUG: El personaje oculto es: " + personajeOculto.getNombre(),
                    "Personaje Oculto",
                    JOptionPane.INFORMATION_MESSAGE);
                //-----------------------------------------------------------------
                
                
        });    
        
	} //end interface clase
	


	
//-------------------------------------------------------------------------------------------------------------------------	
//															Metodos
//--------------------------------------------------------------------------------------------------------------------------	


	
// Metodo de  interfaz gráfica de usuario (UI).
//	Crea y organiza los componentes visuales, establece los layouts, añade botones con sus iconos y listeners, y prepara el panel principal. 
private void initUI() {
	setLayout(new BorderLayout());
	JPanel panelBotones = new JPanel();
	
	// 0 filas, 5 columnas, con espacio  de 5 horizontal y 5 vertical para dejar margenes
	// Al poner 0 filas, los objetos de organizan de 5 en 5 en el menu sin importar cuantos objetos en total existan
	// Por el contrario si tenemos 3 filas, 5 objetos, necesitamos SI o SI los 15 objetos, o no se visualiza como esperamos
	panelBotones.setLayout(new GridLayout(0, 8, 5, 5)); 
	
	
	// Crear icono transparente de 50x50 píxeles (Necesita importar a BufferedImage)
	BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
	ImageIcon iconoTransparente = new ImageIcon(img);
	

	

	
	// Crear botones de preguntas + frase descriptiva + incono
	botonChico = new JButton("¿Es chico?",iconoTransparente); //Usa un inoco traspararente para dar dimensioens al resto de botones
	botonChica = new JButton("¿Es chica?");
	botonGafas = new JButton("¿Tiene gafas?");
	botonPendientes = new JButton("¿Tiene pendientes?");
	botonBarba = new JButton("¿Tiene barba?");
	botonBigote = new JButton("¿Tiene bigote?");
	botonPecas = new JButton("¿Tiene pecas?");
	botonPeloRubio = new JButton("¿Pelo rubio?");
	botonPeloMoreno = new JButton("¿Pelo monero?");
	botonPeloNegro = new JButton("¿Pelo negro?");
	botonOjosClaros = new JButton("¿Ojos claros?");
	botonOjosOscuros = new JButton("¿Ojos oscuros?");
	botonOjosDesconocidos = new JButton("¿Ojos ocultos?");
	botonPielClara = new JButton("¿Piel clara?");
	botonPielNormal = new JButton("¿Piel normal?");
	botonPielOscura = new JButton("¿Piel oscura?");
	//end
	
	//Confiugra el primer boton (Que tiene una imgane invisible)
	//Adapta el texto del boton encima de la imagen y los  centra en la celda del boton
	botonChico.setIcon(iconoTransparente);
	botonChico.setHorizontalTextPosition(SwingConstants.CENTER);
	botonChico.setVerticalTextPosition(SwingConstants.CENTER);
	//end

	//oculta el borde de la imagne al pinchar en el boton
	botonChico.setFocusPainted(false);
	botonChica.setFocusPainted(false);
	botonGafas.setFocusPainted(false);
	botonPendientes.setFocusPainted(false);
	botonBarba.setFocusPainted(false);
	botonBigote.setFocusPainted(false);
	botonPecas.setFocusPainted(false);
	botonPeloRubio.setFocusPainted(false);
	botonPeloMoreno.setFocusPainted(false);
	botonPeloNegro.setFocusPainted(false);
	botonOjosClaros.setFocusPainted(false);
	botonOjosOscuros.setFocusPainted(false);
	botonOjosDesconocidos.setFocusPainted(false);
	botonPielClara.setFocusPainted(false);
	botonPielNormal.setFocusPainted(false);
	botonPielOscura.setFocusPainted(false);
	//end
	
	
    // Añadir botones al panel
    panelBotones.add(botonChico);
    panelBotones.add(botonChica);
    panelBotones.add(botonGafas);
    panelBotones.add(botonPendientes);
    panelBotones.add(botonBarba);
    panelBotones.add(botonBigote);
    panelBotones.add(botonPecas);
    panelBotones.add(botonPeloRubio);
    panelBotones.add(botonPeloMoreno);
    panelBotones.add(botonPeloNegro);
    panelBotones.add(botonOjosClaros);
    panelBotones.add(botonOjosOscuros);
    panelBotones.add(botonOjosDesconocidos);
    panelBotones.add(botonPielClara);
    panelBotones.add(botonPielNormal);
    panelBotones.add(botonPielOscura);

    // Añadir el panel a la parte baja (SOUTH) del JFrame
    add(panelBotones, BorderLayout.SOUTH);
    

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 																																	   //
    //												Acciones para cada uno de los botones												   //
    //																																       //
    // Los siguetes bloques de código se encargan de la lógica de cada unos de los botones de preguntas									   //
    // Funcionan mediantes 6 pasos hasta terminar la acción de cada uno de los botones.													   //				
    //																																	   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Boton es chico----------------------------------------------------------------------------------
    // Es personaje secreto ¿es chico?
    botonChico.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto es chico
        boolean esChico = personajeOculto.esChico();

        // 2. Mostrar resultado al jugador
        if(esChico) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto es chico");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no es chico");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeEsChico = personaje.esChico();

            // Si no coincide, tachamos
            if (personajeEsChico != esChico) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonChico.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });

    
    
    //Boton es chica----------------------------------------------------------------------------------
 // Es personaje secreto ¿es chica?
    botonChica.addActionListener(e -> {

        // 1. Obtener si el personaje oculto es chica
        boolean esChica = personajeOculto.esChica();

        // 2. Mostrar resultado al jugador
        if (esChica) {
            JOptionPane.showMessageDialog(this, "El personaje oculto es chica");
        } else {
            JOptionPane.showMessageDialog(this, "El personaje oculto no es chica");
        }

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeEsChica = personaje.esChica();

            // Si no coincide, tachamos
            if (personajeEsChica != esChica) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
            "Te quedan " + preguntas + " preguntas.",
            "Preguntas restantes",
            JOptionPane.INFORMATION_MESSAGE);

        // 5. desactiva este botón
        botonChica.setEnabled(false);

        // 6. si hemos llegado a 0 preguntas, activa modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });


    
    
    
    //Boton de Gafas----------------------------------------------------------------------------------
    // Es personaje secreto ¿Lleva gafas?
    botonGafas.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto llevas gafas
        boolean llevaGafas = personajeOculto.llevaGafas();

        // 2. Mostrar resultado al jugador
        if(llevaGafas) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto usa gafas");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no usa gafas");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeLlevaGafas = personaje.llevaGafas();

            // Si no coincide, tachamos
            if (personajeLlevaGafas != llevaGafas) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonGafas.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    //Boton de Pendientes----------------------------------------------------------------------------------
    // Es personaje secreto ¿Lleva pendientes?
    botonPendientes.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto llevas pendientes
        boolean llevaPendientes = personajeOculto.llevaPendientes();

        // 2. Mostrar resultado al jugador
        if(llevaPendientes) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto lleva pendientes");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no lleva pendientes");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeLlevaPendientes = personaje.llevaPendientes();

            // Si no coincide, tachamos
            if (personajeLlevaPendientes != llevaPendientes) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPendientes.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
  
    
    //Boton de Barba----------------------------------------------------------------------------------
    // Es personaje secreto ¿Lleva Barva?
    botonBarba.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto llevas barba
        boolean llevaBarba = personajeOculto.llevaBarba();

        // 2. Mostrar resultado al jugador
        if(llevaBarba) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto lleva barba");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no lleva barba");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeLlevaBarba = personaje.llevaBarba();

            // Si no coincide, tachamos
            if (personajeLlevaBarba != llevaBarba) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonBarba.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de Bigote----------------------------------------------------------------------------------
    // Es personaje secreto ¿Lleva Bigote?
    botonBigote.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto lleva bigote
        boolean llevaBigote = personajeOculto.llevaBigote();

        // 2. Mostrar resultado al jugador
        if(llevaBigote) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto lleva bigote");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no lleva bigote");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeLlevaBigote = personaje.llevaBigote();

            // Si no coincide, tachamos
            if (personajeLlevaBigote != llevaBigote) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonBigote.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de Pecas----------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene Pecas?
    botonPecas.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene pecas
        boolean tienePecas = personajeOculto.tienePecas();

        // 2. Mostrar resultado al jugador
        if(tienePecas) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene pecas");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene pecas");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePecas = personaje.tienePecas();

            // Si no coincide, tachamos
            if (personajeTienePecas != tienePecas) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPecas.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    //Boton de Pelo Rubio----------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene el pelo rubio?
    botonPeloRubio.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo rubio
        boolean tienePeloRubio = personajeOculto.tienePeloRubio();

        // 2. Mostrar resultado al jugador
        if(tienePeloRubio) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene el pelo rubio");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene el pelo rubio");
        	}

        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePeloRubio = personaje.tienePeloRubio();

            // Si no coincide, tachamos
            if (personajeTienePeloRubio != tienePeloRubio) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPeloRubio.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de Pelo Moreno----------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene el pelo moreno?
    botonPeloMoreno.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tienePeloMoreno = personajeOculto.tienePeloMoreno();

        // 2. Mostrar resultado al jugador
        if(tienePeloMoreno) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene le pelo moreno");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene el pelo moreno");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePeloMoreno = personaje.tienePeloMoreno();

            // Si no coincide, tachamos
            if (personajeTienePeloMoreno != tienePeloMoreno) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPeloMoreno.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de Pelo Negro----------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene el pelo negro?
    botonPeloNegro.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tienePeloNegro = personajeOculto.tienePeloNegro();

        // 2. Mostrar resultado al jugador
        if(tienePeloNegro) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene le pelo negro");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene el pelo negro");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePeloNegro = personaje.tienePeloNegro();

            // Si no coincide, tachamos
            if (personajeTienePeloNegro != tienePeloNegro) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }


        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPeloNegro.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
   
    
    
  //Boton de Ojos Claros---------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene los ojos claros?
    botonOjosClaros.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tieneOjosClaros = personajeOculto.tieneOjosClaros();

        // 2. Mostrar resultado al jugador
        if(tieneOjosClaros) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene los ojos claros");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene los ojos claros");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTieneOjosClaros = personaje.tieneOjosClaros();

            // Si no coincide, tachamos
            if (personajeTieneOjosClaros != tieneOjosClaros) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonOjosClaros.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de Ojos Oscuros---------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene los ojos oscuros?
    botonOjosOscuros.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tieneOjosOscuros = personajeOculto.tieneOjosOscuros();

        // 2. Mostrar resultado al jugador
        if(tieneOjosOscuros) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene los ojos oscuros");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene los ojos oscuros");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTieneOjosOscuros = personaje.tieneOjosOscuros();

            // Si no coincide, tachamos
            if (personajeTieneOjosOscuros != tieneOjosOscuros) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonOjosOscuros.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de de ojos Ocultos---------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene los ojos ocultos?
    botonOjosDesconocidos.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tieneOjosOcultos = personajeOculto.tieneOjosOcultos();

        // 2. Mostrar resultado al jugador
        if(tieneOjosOcultos) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene los ojos tapados");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene un color de ojos visible");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTieneOjosOcultos = personaje.tieneOjosOcultos();

            // Si no coincide, tachamos
            if (personajeTieneOjosOcultos != tieneOjosOcultos) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonOjosDesconocidos.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    
    
    //Boton de piel clara---------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene los piel clara?
    botonPielClara.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tienePielClara = personajeOculto.tienePielClara();

        // 2. Mostrar resultado al jugador
        if(tienePielClara) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene un tono de piel claro");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene un color de piel claro");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePielClara = personaje.tienePielClara();

            // Si no coincide, tachamos
            if (personajeTienePielClara != tienePielClara) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPielClara.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });
    
    //Boton de piel normal---------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene la piel normal?
    botonPielNormal.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tienePielNormal = personajeOculto.tienePielNormal();

        // 2. Mostrar resultado al jugador
        if(tienePielNormal) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene un tono de piel intermedio");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene un color de piel intermedio");
        	}

        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePielNormal = personaje.tienePielNormal();

            // Si no coincide, tachamos
            if (personajeTienePielNormal != tienePielNormal) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPielNormal.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });

    
    
    //Boton de piel oscura---------------------------------------------------------------------------------
    // Es personaje secreto ¿Tiene la piel oscura?
    botonPielOscura.addActionListener(e -> {
        
        // 1. Obtener si el personaje oculto tiene el pelo moreno
        boolean tienePielOscura = personajeOculto.tienePielOscura();

        // 2. Mostrar resultado al jugador
        if(tienePielOscura) {
        	JOptionPane.showMessageDialog(this, "El personaje oculto tiene un tono de piel oscuro");
        	}
        else{
        	JOptionPane.showMessageDialog(this, "El personaje oculto no tiene un color de piel oscuro");
        	}

        
        // 3. Recorrer todos los botones y comparar
        for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
            JButton boton = entry.getKey();
            Personas personaje = entry.getValue();

            boolean personajeTienePielOscura = personaje.tienePielOscura();

            // Si no coincide, tachamos
            if (personajeTienePielOscura != tienePielOscura) {
                ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
                Image imagenRedimensionada = iconoDescartado.getImage().getScaledInstance(
                    boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoFinal = new ImageIcon(imagenRedimensionada);
                boton.setDisabledIcon(iconoFinal);
                boton.setEnabled(false);
            }
        }

        // 4. Aumentar turno
        preguntas--;
        JOptionPane.showMessageDialog(this,
        	    "Te quedan " + preguntas + " preguntas.",
        	    "Preguntas restantes",
        	    JOptionPane.INFORMATION_MESSAGE);
        
        // 5. desactiva este boton
        botonPielOscura.setEnabled(false);
        
        // 6. si hemos llegado a 0 preguntas activa el modo buscar personaje
        if (preguntas == 0) {
            activarModoRespuesta();
        }
    });


    
    
    //Graficos de lo personajes
    
    //Crea un Java Panel con los atributos de 2 filas y 3 columnas, el 10 y 10 son los espacios de separacion entre los personajes
    JPanel panelPersonajes = new JPanel(new GridLayout(0, 8, 0, 0));
    panelPersonajes.setPreferredSize(new Dimension(1280, 480));
	BotonesPersonajes(panelPersonajes);
	add(panelPersonajes, BorderLayout.CENTER);
	
	//Añade al panel de personajes un Layout de 10 en derecha, arriba, izquierda, abajo
	JPanel contenedor = new JPanel(new BorderLayout());
	contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen externo
	contenedor.add(panelPersonajes, BorderLayout.CENTER);
	add(contenedor);
    
     
}//end initUI




//metodo  botones de los personajes (tiene 2 partes:
//Parte 1: Crea los botones de los personjes
//Parte 2: Lleva la lógica para responer que personaje es el oculto
private void BotonesPersonajes(JPanel panelPersonajes) {
	
	//Parte 1 Creación de los botones de los personaes
	//------------------------------------------------------------------------
	GestorPersonas gestor = new GestorPersonas();
	List<Personas> lista = gestor.getListaPersonajes();
	
	for (Personas p : lista) {
	    // Redimensionar imagen a 180 x 180
	    ImageIcon originalIcon = new ImageIcon(p.getRutaImagen());
	    Image imagenRedimensionada = originalIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
	    ImageIcon icono = new ImageIcon(imagenRedimensionada);
	    
	    // Crear botón con imagen redimensionada
	    JButton boton = new JButton(icono);
	    
	    // Quitar borde (opcional para que no tenga marco)
	    boton.setBorder(BorderFactory.createEmptyBorder());
	    
	    // Desactiva el botón (no interactivo por ahora)
	    boton.setDisabledIcon(icono); 
	    boton.setEnabled(true);
	    
	    // Añadir al panel de personajes
	    panelPersonajes.add(boton);
	    
	    // Asociar botón con el personaje (para lógica futura)
	    botonesPersonajes.put(boton, p);
	   
	    
	    
	    //Parte 2: Lógica para responder si un personaje es el personaje oculto
	    //------------------------------------------------------------------------
	    boton.addActionListener(e -> {
	        if (preguntas != 0 || intentos <= 0) return;

	        Personas elegido = botonesPersonajes.get(boton);
	        
	        // si adivinaste al personaje secreto 
	        if (elegido.equals(personajeOculto)) {
	            int opcion = JOptionPane.showOptionDialog(
	                    panelPersonajes,
	                    "¡Correcto! Has adivinado el personaje: " + elegido.getNombre() + "\n\n¿Quieres jugar otra vez?",
	                    "¡Victoria!",
	                    JOptionPane.YES_NO_OPTION,
	                    JOptionPane.INFORMATION_MESSAGE,
	                    null,
	                    new String[] {"Volver a jugar", "Salir"},
	                    "Volver a jugar"
	            );
	            	
	            if (opcion == JOptionPane.YES_OPTION) {
	                reiniciar();
	            } 
	            
	            else {
	                System.exit(0);
	            }

	        }//end adivinaste al personaje secreto
	        
	        
	        // Si el personaje no era el secreto
	        else {
	            intentos--;

	            if (intentos > 0) {
	                JOptionPane.showMessageDialog(
	                        panelPersonajes,
	                        "¡Incorrecto! Te quedan " + intentos + " intento(s).",
	                        "Sigue intentando",
	                        JOptionPane.WARNING_MESSAGE
	                );
	            }//end fallaste al responder
	            
	            
	            //Si agotas todas las oportunidades de contextar y pierdes
	            else {
	                JOptionPane.showMessageDialog(
	                        panelPersonajes,
	                        "¡Has perdido! El personaje era: " + personajeOculto.getNombre(),
	                        "Fin del juego",
	                        JOptionPane.ERROR_MESSAGE
	                );
	                
	                //perdiste, ¿volver a jugar?
	                int opcion = JOptionPane.showOptionDialog(
	                        panelPersonajes,
	                        "¿Quieres volver a jugar o salir?",
	                        "Volver a jugar",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE,
	                        null,
	                        new String[] {"Volver a jugar", "Salir"},
	                        "Volver a jugar"
	                );

	                if (opcion == JOptionPane.YES_OPTION) {
	                    reiniciar();
	                } 
	                else {
	                    System.exit(0);
	                }
	            }//end perdiste
	        }//el personaje no era el secreto
	    });// fin de boton para responder si un personaje es el secreto
	    
	}//end bucle for
	
}// end método botones personajes



//Metodo para modo respuesta
private void activarModoRespuesta() {
	// Desactivas todos los botones de preguntas, pues ya solo puedes intentar responder quien es el personaje oculto.
    JOptionPane.showMessageDialog(this,
    	    "Adivina quien es el personaje oculto.",
    	    "¿Quien es quien?",
    	    JOptionPane.INFORMATION_MESSAGE);
    botonChico.setEnabled(false);
    botonChica.setEnabled(false);
    botonGafas.setEnabled(false);
    botonPendientes.setEnabled(false);
    botonBarba.setEnabled(false);
    botonBigote.setEnabled(false);
    botonGafas.setEnabled(false);
    botonPecas.setEnabled(false);
    botonPeloRubio.setEnabled(false);
    botonPeloMoreno.setEnabled(false);
    botonPeloNegro.setEnabled(false);
    botonOjosClaros.setEnabled(false);
    botonOjosOscuros.setEnabled(false);
    botonOjosDesconocidos.setEnabled(false);
    botonPielClara.setEnabled(false);
    botonPielNormal.setEnabled(false);
    botonPielOscura.setEnabled(false);
    
    
}//end 

	
//metodo para reinicar el juego
public void reiniciar() {
	
	//reinicia las varibles
    preguntas = 3;
    intentos = 3;
   
    
    //seleccina un nuevo personaje oculto
    personajeOculto = listaPersonajes.get(new Random().nextInt(listaPersonajes.size()));
    
    //activar los graficos de los personajes y sus botones
    for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
        JButton boton = entry.getKey();
        Personas persona = entry.getValue();

        // Restaurar imagen original del personaje
        ImageIcon originalIcon = new ImageIcon(persona.getRutaImagen());
        Image imagenRedimensionada = originalIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenRedimensionada);

        boton.setIcon(icono);
        boton.setDisabledIcon(icono);
        boton.setEnabled(true);
    }
    
    //restaurame los botones de las preguntas
    botonChico.setEnabled(true);
    botonChica.setEnabled(true);
    botonGafas.setEnabled(true);
    botonPendientes.setEnabled(true);
    botonBarba.setEnabled(true);
    botonBigote.setEnabled(true);
    botonPecas.setEnabled(true);
    botonPeloRubio.setEnabled(true);
    botonPeloMoreno.setEnabled(true);
    botonPeloNegro.setEnabled(true);
    botonOjosClaros.setEnabled(true);
    botonOjosOscuros.setEnabled(true);
    botonOjosDesconocidos.setEnabled(true);
    botonPielClara.setEnabled(true);
    botonPielNormal.setEnabled(true);
    botonPielOscura.setEnabled(true);   
    
};//end metodo reiniciar


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///																																		    ///
///														S T R A T 		G A M E																///
///			    																															///
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//metodo main temporal para arrancar la interface//
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
    	Interface_juego juego = new Interface_juego();
        juego.setVisible(true);
    });
    	
	
}//end metodo main



}//End clase interface
