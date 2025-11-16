package Elementos_juego;

// importaciones
// --------------------------------------------------------------------------------------------------------------------------------------------------------
import javax.swing.*;                 // Componentes de interfaz gráfica (JFrame, JPanel, JButton, JOptionPane, etc.)
import java.awt.BorderLayout;         // Layout para colocar paneles en Norte/Sur/Este/Oeste/Centro
import java.awt.Dimension;            // Para indicar tamaños preferidos de ventanas y paneles
import java.awt.Image;                // Representa imágenes genéricas para poder escalarlas/redimensionarlas
import java.awt.GridLayout;           // Layout en forma de cuadrícula (filas x columnas)
import java.awt.image.BufferedImage;  // Imagen en memoria, útil para crear iconos transparentes, etc.

import java.util.List;                // Lista ordenada (se usa para lista de personajes)
import java.util.Map;                 // Mapa clave→valor (se usa para botón → personaje)
import java.util.HashMap;             // Implementación concreta de Map (HashMap)
import java.util.Arrays;              // Utilidades para trabajar con arrays (por ejemplo Arrays.asList)
import java.util.Objects;             // Utilidades como requireNonNull para validar parámetros
import java.util.Optional;            // Contenedor para valores que pueden estar o no (getPorId devuelve Optional)
import java.util.Random;              // Generador de números aleatorios (elige el personaje oculto)
import java.util.function.Predicate;  // Interfaz funcional para condiciones booleanas (si la usas en filtros, etc.)



public class InterfazJuego extends JFrame {

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Estado Inicial
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  private static final long serialVersionUID = 1L;	// JFrame lo utiliza para versiones (en este proyecto no)

  private Personas personajeOculto;              // personaje secreto
  private List<Personas> listaPersonajes;        // catálogo de personajes

  private int preguntas = 3;                     // número de preguntas 
  private int intentos = 3;                      // intentos para adivinar quien es el personaje oculto

  private final Map<JButton, Personas> botonesPersonajes = new HashMap<>(); // mapa clave : valor (boton X = personaje X)

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Botones de preguntas 
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
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

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  //Iconos de los botones de las preguntas (rutas de imágenes) NO SE USA PERO ESTA IMPLEMENTADO
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /*
   * Actualmente este bloque no se utiliza porque se descartó el uso de iconos
   * en los botones de las preguntas. 
   * 
   * Sin embargo, las rutas y objetos "ImageIcon" ya están listos por si más
   * adelante quieres activarlos, o si alguien que descargue el proyecto 
   * desea añadir imágenes a los botones fácilmente.
   */
  
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

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Constructores (A y B)
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /**
   * Constructor A, para testear. Crea una partida personalizada para hacer pruebas.
   * Puedes hacer que el personaje oculto sea X para comprobar parametros en concreto.
   */
  public InterfazJuego(Personas personajeOculto, List<Personas> listaPersonajes) {
    this.personajeOculto = Objects.requireNonNull(personajeOculto);		// Asigna al personaje oculto
    this.listaPersonajes = Objects.requireNonNull(listaPersonajes);		// Asigna la lista de personajes
    configurarVentana();												// Carga la configuración de la ventana(tamaño, título, cierre...)
    initUI();															// Inicializa la interfaz gráfica (botones, paneles y reglas de interacción...)
  }//end
  

  /**
   * Constructor B, el que usa el juego por defecto.
   * Genera automáticamente la lista de personajes y el personaje oculto.
   * Luego configura la ventana y construye toda la interfaz del juego.
   */
  public InterfazJuego() {
    configurarVentana();

    // 1) Cargar a los personajes 
    GestorPersonas gestor = new GestorPersonas();
    this.listaPersonajes = gestor.getListaPersonajes();
    this.personajeOculto = listaPersonajes.get(new Random().nextInt(listaPersonajes.size()));

    // 2) Crear UI (ya existe listaPersonajes)
    initUI();

    // 3) Mensajes de bienvenida (y DEBUG) tras pintar la interfaz
    SwingUtilities.invokeLater(() -> {
      JOptionPane.showMessageDialog(this,
          "¡Hola jugad@r! Bienvenido/a a ¿Quién es quién?\n\n" +
          "Tu objetivo es adivinar qué personaje ha sido elegido al azar.\n" +
          "Tienes hacer 3 preguntas para descartar personajes.\n" +
          "Después tendrás 3 intentos para adivinar quién es.\n\n" +
          "¡Buena suerte!",
          "Inicio del juego",
          JOptionPane.INFORMATION_MESSAGE);

      // ----- MODO DEBUG -----
      /*
       * Solo se activa la primera vez cuando se inicia el programa
       * Si no quieres la ayuda, simplemente comenta este JoptionPane
       * */
      JOptionPane.showMessageDialog(this,
          "DEBUG: El personaje oculto es: " + personajeOculto.getNombre(),
          "Personaje Oculto",
          JOptionPane.INFORMATION_MESSAGE);
    });
  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Configuración ventana
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /** Configura título, tamaño y cierre de la ventana. */
  private void configurarVentana() {
    setTitle("¿Quién es quién en JAVA? Creado por José Luis Escudero Polo");
    setPreferredSize(new Dimension(1400, 800));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//cierra el programa al pulsar en la X
    // ¡Ojo! El centrado se hace después de pack() en initUI().
  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Inicialización UI 
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /*
   * Este método construye y organiza la interfaz del juego de forma modular.
   * 
   * -> Usa un BorderLayout como estructura base (dividido en zonas: norte, sur, centro...).
   * -> En la parte inferior (SOUTH) coloca el panel de botones de preguntas.
   * -> En el centro (CENTER) coloca el panel de personajes dentro de un contenedor con margen.
   * -> Llama a "configurarAccionesPreguntas()" para asignar la lógica de los botones.
   * -> Finalmente, ajusta el tamaño de la ventana con pack() y la centra en pantalla.
   * 
   */
  private void initUI() {
    setLayout(new BorderLayout());
    
    // Panel de preguntas (botones)
    JPanel panelPreguntas = construirPanelPreguntas();
    add(panelPreguntas, BorderLayout.SOUTH);
    
    // Panel de personajes (botones)
    JPanel panelPersonajes = construirPanelPersonajes();
    JPanel contenedor = new JPanel(new BorderLayout());
    contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    contenedor.add(panelPersonajes, BorderLayout.CENTER);
    add(contenedor, BorderLayout.CENTER);
    
    // pregunta sobre un personaje
    configurarAccionesPreguntas();
    
    // Calcula y ajusta el tamaño de la ventana según el tamaño preferido de sus componentes
    pack();
    
    // Centramos **después** de pack() para evitar que salga en la esquina
    setLocationRelativeTo(null);
    
  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Panel de preguntas (creación de botones y estilos)
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /** Construye el panel de preguntas (fila de botones) y prepara su estilo. */
  private JPanel construirPanelPreguntas() {
	  
	// Caja de 0 filas(las que necesites), 8 columnas, 5 y 5 pixeles de separacion (Nota -> GridLayout obliga a los botones a ser iguales)
    JPanel panel = new JPanel(new GridLayout(0, 8, 5, 5)); 

    // Icono transparente de 50x50 para igualar alturas si decides añadir iconos reales (TYPE_INT_ARGB -> invisible)
    BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
    ImageIcon iconoTransparente = new ImageIcon(img);

    // Crear botones (dejas el transparente en el primero como en tu código)
    // GridLayout iguala el tamaño de todos los botones,
    // así que basta con que el primero use el iconoTransparente como referencia.
    botonChico = new JButton("¿Es chico?",iconoTransparente); 	// prueba a poner en el icono -> "iconoChico" para ver el resultado visible
    botonChica = new JButton("¿Es chica?");
    botonGafas = new JButton("¿Tiene gafas?");
    botonPendientes = new JButton("¿Tiene pendientes?");
    botonBarba = new JButton("¿Tiene barba?");
    botonBigote = new JButton("¿Tiene bigote?");
    botonPecas = new JButton("¿Tiene pecas?");
    botonPeloRubio = new JButton("¿Pelo rubio?");
    botonPeloMoreno = new JButton("¿Pelo moreno?");
    botonPeloNegro = new JButton("¿Pelo negro?");
    botonOjosClaros = new JButton("¿Ojos claros?");
    botonOjosOscuros = new JButton("¿Ojos oscuros?");
    botonOjosDesconocidos = new JButton("¿Ojos ocultos?");
    botonPielClara = new JButton("¿Piel clara?");
    botonPielNormal = new JButton("¿Piel normal?");
    botonPielOscura = new JButton("¿Piel oscura?");

    // Centrar texto del primero, asi aunque añadas un icono el texto estara en el centro
    botonChico.setHorizontalTextPosition(SwingConstants.CENTER);
    botonChico.setVerticalTextPosition(SwingConstants.CENTER);

    // Quitar borde de focus y añadir al panel
    for (JButton botonPregunta : Arrays.asList(
        botonChico, botonChica, botonGafas, botonPendientes, botonBarba, botonBigote,
        botonPecas, botonPeloRubio, botonPeloMoreno, botonPeloNegro,
        botonOjosClaros, botonOjosOscuros, botonOjosDesconocidos,
        botonPielClara, botonPielNormal, botonPielOscura)) {
      botonPregunta.setFocusPainted(false);
      panel.add(botonPregunta);
    }
    
    return panel; //vuelve al panel
  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Panel de personajes (24 botones en métodos separados)
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /**
   * Construye el panel central y añade los 24 botones de personaje mediante
   * métodos individuales (editables) que encapsulan la lógica común.
   */
  private JPanel construirPanelPersonajes() {
    JPanel panel = new JPanel(new GridLayout(0, 8, 0, 0)); // parametros 0 filas, 8 columas, 0 espacios, 0 espacio
    panel.setPreferredSize(new Dimension(1280, 480));

    // Cada método crea, configura y añade su botón
    crearBotonCarolina(panel);
    crearBotonCristina(panel);
    crearBotonGabriela(panel);
    crearBotonOscar(panel);
    crearBotonMaria(panel);
    crearBotonBorja(panel);
    crearBotonLoreto(panel);
    crearBotonNacho(panel);
    crearBotonBeatriz(panel);
    crearBotonPedro(panel);
    crearBotonRaquel(panel);
    crearBotonSara(panel);
    crearBotonInes(panel);
    crearBotonDaniel(panel);
    crearBotonSusana(panel);
    crearBotonRamon(panel);
    crearBotonCatalina(panel);
    crearBotonArturo(panel);
    crearBotonCarlos(panel);
    crearBotonJesus(panel);
    crearBotonVeronica(panel);
    crearBotonJorge(panel);
    crearBotonAlberto(panel);
    crearBotonAlejandro(panel);

    return panel;
  }//end
  

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  //(crea el panel de jugadores visualmente y crea su logica para pulsar al jugador)
  
  // Métodos de creación de botón por personaje (24). Cada uno:
  // 1) busca el Personaje por id, 
  // 2) crea botón con icono escalado,
  // 3) lo añade al panel y al mapa, 
  // 4) configura su listener.
  // Si quieres personalizar uno en concreto, abre su método y edítalo.
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  private void crearBotonCarolina(JPanel panel) { crearBotonDeId(panel, 1); }
  private void crearBotonCristina(JPanel panel) { crearBotonDeId(panel, 2); }
  private void crearBotonGabriela(JPanel panel) { crearBotonDeId(panel, 3); }
  private void crearBotonOscar(JPanel panel)    { crearBotonDeId(panel, 4); }
  private void crearBotonMaria(JPanel panel)    { crearBotonDeId(panel, 5); }
  private void crearBotonBorja(JPanel panel)    { crearBotonDeId(panel, 6); }
  private void crearBotonLoreto(JPanel panel)   { crearBotonDeId(panel, 7); }
  private void crearBotonNacho(JPanel panel)    { crearBotonDeId(panel, 8); }
  private void crearBotonBeatriz(JPanel panel)  { crearBotonDeId(panel, 9); }
  private void crearBotonPedro(JPanel panel)    { crearBotonDeId(panel,10); }
  private void crearBotonRaquel(JPanel panel)   { crearBotonDeId(panel,11); }
  private void crearBotonSara(JPanel panel)     { crearBotonDeId(panel,12); }
  private void crearBotonInes(JPanel panel)     { crearBotonDeId(panel,13); }
  private void crearBotonDaniel(JPanel panel)   { crearBotonDeId(panel,14); }
  private void crearBotonSusana(JPanel panel)   { crearBotonDeId(panel,15); }
  private void crearBotonRamon(JPanel panel)    { crearBotonDeId(panel,16); }
  private void crearBotonCatalina(JPanel panel) { crearBotonDeId(panel,17); }
  private void crearBotonArturo(JPanel panel)   { crearBotonDeId(panel,18); }
  private void crearBotonCarlos(JPanel panel)   { crearBotonDeId(panel,19); }
  private void crearBotonJesus(JPanel panel)    { crearBotonDeId(panel,20); }
  private void crearBotonVeronica(JPanel panel) { crearBotonDeId(panel,21); }
  private void crearBotonJorge(JPanel panel)    { crearBotonDeId(panel,22); }
  private void crearBotonAlberto(JPanel panel)  { crearBotonDeId(panel,23); }
  private void crearBotonAlejandro(JPanel panel){ crearBotonDeId(panel,24); }

 
  // Crea un botón para el personaje con el id indicado y lo añade al panel.
  private void crearBotonDeId(JPanel panel, int id) {
    Personas persona = getPorId(id).orElse(null);
    if (persona == null) return; // si no encuentas a una persona, devuelve null y sigue con el programa

    // Crear icono escalado 180x180
    ImageIcon icono = escalarIcono(new ImageIcon(persona.getRutaImagen()), 180, 180);
    
    // Configura el boton de cada persoanaje
    JButton boton = new JButton(icono);
    boton.setBorder(BorderFactory.createEmptyBorder()); 
    boton.setDisabledIcon(icono);
    boton.setEnabled(true);

    // Añadir al panel y al mapa botón→personaje
    panel.add(boton);
    botonesPersonajes.put(boton, persona);
    
    
    // Si pulsamos en un personaje
    boton.addActionListener(e -> {

    	// Condición: Solo se permite adivinar cuando ya agotaste las preguntas y aún quedan intentos
        if (preguntas != 0 || intentos <= 0) {
            return;
        }
        
        // Modo adivinar esta activado //
        // Eliges a un personaje -> "elegido", este sera compradado con el personaje Oculto
        Personas elegido = botonesPersonajes.get(boton);

        // --- ACIERTO ---
        if (elegido.equals(personajeOculto)) {
            int opcion = JOptionPane.showOptionDialog(
                panel,
                "¡Correcto! Era " + elegido.getNombre() + " ¿Quieres jugar otra vez?",
                "Victoria",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[] {"Reiniciar", "Salir"},
                "Reiniciar"
            );

            if (opcion == JOptionPane.YES_OPTION) {
                reiniciar();
            } else {
                System.exit(0);
            }
            return; // fin del listener
        }

        // --- FALLO ---
        intentos--;

        if (intentos > 0) {
            JOptionPane.showMessageDialog(
                panel,
                "Incorrecto, te quedan " + intentos + " intento(s).",
                "Sigue intentando",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // --- GAME OVER ---
        JOptionPane.showMessageDialog(
            panel,
            "Has perdido. El personaje era: " + personajeOculto.getNombre(),
            "Fin del juego",
            JOptionPane.ERROR_MESSAGE
        );

        int opcion = JOptionPane.showOptionDialog(
            panel,
            "¿Quieres volver a jugar?",
            "Game Over",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] {"Reiniciar", "Salir"},
            "Reiniciar"
        );

        if (opcion == JOptionPane.YES_OPTION) {
            reiniciar();
        } else {
            System.exit(0);
        }
    });

  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Listeners de preguntas (uno por botón) y helpers de lógica
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /** Conecta cada botón de pregunta con su acción específica (1:1). */
  private void configurarAccionesPreguntas() {
    configurarAccionBotonChico();
    configurarAccionBotonChica();
    configurarAccionBotonGafas();
    configurarAccionBotonPendientes();
    configurarAccionBotonBarba();
    configurarAccionBotonBigote();
    configurarAccionBotonPecas();
    configurarAccionBotonPeloRubio();
    configurarAccionBotonPeloMoreno();
    configurarAccionBotonPeloNegro();
    configurarAccionBotonOjosClaros();
    configurarAccionBotonOjosOscuros();
    configurarAccionBotonOjosDesconocidos();
    configurarAccionBotonPielClara();
    configurarAccionBotonPielNormal();
    configurarAccionBotonPielOscura();
  }//end

  // Metodos para comprobar cada accion de cada boton de pregunta //
  
  // Pregunta 1 -> es chico ?
  private void configurarAccionBotonChico() {
    botonChico.addActionListener(e -> {
      boolean esChico = personajeOculto.esChico();
      mostrarInfo(esChico ? "El personaje oculto es chico" : "El personaje oculto no es chico");
      descartar(p -> p.esChico() == esChico);
      despuesDePreguntar(botonChico);
    });
  }//end
  
  // Pregunta 2 -> es chica ?
  private void configurarAccionBotonChica() {
    botonChica.addActionListener(e -> {
      boolean esChica = personajeOculto.esChica();
      mostrarInfo(esChica ? "El personaje oculto es chica" : "El personaje oculto no es chica");
      descartar(p -> p.esChica() == esChica);
      despuesDePreguntar(botonChica);
    });
  }//end 
  
  // Pregunta 3 -> lleva gafas ?
  private void configurarAccionBotonGafas() {
    botonGafas.addActionListener(e -> {
      boolean llevaGafas = personajeOculto.llevaGafas();
      mostrarInfo(llevaGafas ? "El personaje oculto usa gafas" : "El personaje oculto no usa gafas");
      descartar(p -> p.llevaGafas() == llevaGafas);
      despuesDePreguntar(botonGafas);
    });
  }//end 
  
  // Pregutna 4 -> lleva pendientes?
  private void configurarAccionBotonPendientes() {
    botonPendientes.addActionListener(e -> {
      boolean llevaPendientes = personajeOculto.llevaPendientes();
      mostrarInfo(llevaPendientes ? "El personaje oculto lleva pendientes" : "El personaje oculto no lleva pendientes");
      descartar(p -> p.llevaPendientes() == llevaPendientes);
      despuesDePreguntar(botonPendientes);
    });
  }//end 
  
  // Pregunta 5 -> tiene barba?
  private void configurarAccionBotonBarba() {
    botonBarba.addActionListener(e -> {
      boolean llevaBarba = personajeOculto.llevaBarba();
      mostrarInfo(llevaBarba ? "El personaje oculto lleva barba" : "El personaje oculto no lleva barba");
      descartar(p -> p.llevaBarba() == llevaBarba);
      despuesDePreguntar(botonBarba);
    });
  }//end
  
  // Pregunta 6 -> tiene bigote?
  private void configurarAccionBotonBigote() {
    botonBigote.addActionListener(e -> {
      boolean llevaBigote = personajeOculto.llevaBigote();
      mostrarInfo(llevaBigote ? "El personaje oculto lleva bigote" : "El personaje oculto no lleva bigote");
      descartar(p -> p.llevaBigote() == llevaBigote);
      despuesDePreguntar(botonBigote);
    });
  }//end
  
  // Pregunta 7 -> tiene pecas?
  private void configurarAccionBotonPecas() {
    botonPecas.addActionListener(e -> {
      boolean tienePecas = personajeOculto.tienePecas();
      mostrarInfo(tienePecas ? "El personaje oculto tiene pecas" : "El personaje oculto no tiene pecas");
      descartar(p -> p.tienePecas() == tienePecas);
      despuesDePreguntar(botonPecas);
    });
  }//end
  
  // Pregunta 8 -> tiene pelo rubio?
  private void configurarAccionBotonPeloRubio() {
    botonPeloRubio.addActionListener(e -> {
      boolean tienePeloRubio = personajeOculto.tienePeloRubio();
      mostrarInfo(tienePeloRubio ? "El personaje oculto tiene el pelo rubio" : "El personaje oculto no tiene el pelo rubio");
      descartar(p -> p.tienePeloRubio() == tienePeloRubio);
      despuesDePreguntar(botonPeloRubio);
    });
  }//end
  
  // Pregunta 9 -> tiene pelo moreno?
  private void configurarAccionBotonPeloMoreno() {
    botonPeloMoreno.addActionListener(e -> {
      boolean tienePeloMoreno = personajeOculto.tienePeloMoreno();
      mostrarInfo(tienePeloMoreno ? "El personaje oculto tiene el pelo moreno" : "El personaje oculto no tiene el pelo moreno");
      descartar(p -> p.tienePeloMoreno() == tienePeloMoreno);
      despuesDePreguntar(botonPeloMoreno);
    });
  }//end
  
  // Pregunta 10 -> tiene pelo negro?
  private void configurarAccionBotonPeloNegro() {
    botonPeloNegro.addActionListener(e -> {
      boolean tienePeloNegro = personajeOculto.tienePeloNegro();
      mostrarInfo(tienePeloNegro ? "El personaje oculto tiene el pelo negro" : "El personaje oculto no tiene el pelo negro");
      descartar(p -> p.tienePeloNegro() == tienePeloNegro);
      despuesDePreguntar(botonPeloNegro);
    });
  }//end
  
  // Pregunta 11 -> tiene ojos claros?
  private void configurarAccionBotonOjosClaros() {
    botonOjosClaros.addActionListener(e -> {
      boolean tieneOjosClaros = personajeOculto.tieneOjosClaros();
      mostrarInfo(tieneOjosClaros ? "El personaje oculto tiene los ojos claros" : "El personaje oculto no tiene los ojos claros");
      descartar(p -> p.tieneOjosClaros() == tieneOjosClaros);
      despuesDePreguntar(botonOjosClaros);
    });
  }//end
  
  // Pregunta 12 -> tiene ojos oscuros?
  private void configurarAccionBotonOjosOscuros() {
    botonOjosOscuros.addActionListener(e -> {
      boolean tieneOjosOscuros = personajeOculto.tieneOjosOscuros();
      mostrarInfo(tieneOjosOscuros ? "El personaje oculto tiene los ojos oscuros" : "El personaje oculto no tiene los ojos oscuros");
      descartar(p -> p.tieneOjosOscuros() == tieneOjosOscuros);
      despuesDePreguntar(botonOjosOscuros);
    });
  }//end
  
  // Pregunta 13 -> tiene ojos descononocidos?
  private void configurarAccionBotonOjosDesconocidos() {
    botonOjosDesconocidos.addActionListener(e -> {
      boolean tieneOjosOcultos = personajeOculto.tieneOjosOcultos();
      mostrarInfo(tieneOjosOcultos ? "El personaje oculto tiene los ojos tapados" : "El personaje oculto tiene un color de ojos visible");
      descartar(p -> p.tieneOjosOcultos() == tieneOjosOcultos);
      despuesDePreguntar(botonOjosDesconocidos);
    });
  }//end
  
  // Pregunta 14 -> tiene piel clara?
  private void configurarAccionBotonPielClara() {
    botonPielClara.addActionListener(e -> {
      boolean tienePielClara = personajeOculto.tienePielClara();
      mostrarInfo(tienePielClara ? "El personaje oculto tiene un tono de piel claro" : "El personaje oculto no tiene un tono de piel claro");
      descartar(p -> p.tienePielClara() == tienePielClara);
      despuesDePreguntar(botonPielClara);
    });
  }//end
  
  // Pregunta 15 -> tiene tono de piel normal?
  private void configurarAccionBotonPielNormal() {
    botonPielNormal.addActionListener(e -> {
      boolean tienePielNormal = personajeOculto.tienePielNormal();
      mostrarInfo(tienePielNormal ? "El personaje oculto tiene un tono de piel intermedio" : "El personaje oculto no tiene un tono de piel intermedio");
      descartar(p -> p.tienePielNormal() == tienePielNormal);
      despuesDePreguntar(botonPielNormal);
    });
  }//end
  
  // Pregunta 16 -> tiene tono de piel oscura?
  private void configurarAccionBotonPielOscura() {
    botonPielOscura.addActionListener(e -> {
      boolean tienePielOscura = personajeOculto.tienePielOscura();
      mostrarInfo(tienePielOscura ? "El personaje oculto tiene un tono de piel oscuro" : "El personaje oculto no tiene un tono de piel oscuro");
      descartar(p -> p.tienePielOscura() == tienePielOscura);
      despuesDePreguntar(botonPielOscura);
    });
  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Helpers de lógica común (tachar, feedback, contadores)
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /** Tacha y deshabilita los botones cuyo personaje NO cumple la condición. */
  private void descartar(Predicate<Personas> coincide) {
	  
    for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
      JButton boton = entry.getKey();
      Personas personaje = entry.getValue();
      
      if (!coincide.test(personaje)) {
        ImageIcon iconoDescartado = new ImageIcon(personaje.getImagenTachado());
        Image esc = iconoDescartado.getImage().getScaledInstance(
            boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
        boton.setDisabledIcon(new ImageIcon(esc));
        boton.setEnabled(false);
      }  
    }
  }//end

  
  /** Muestra mensaje informativo y gestiona el flujo tras una pregunta. */
  private void despuesDePreguntar(JButton botonUsado) {
    preguntas = Math.max(0, preguntas - 1);
    JOptionPane.showMessageDialog(this,
        "Te quedan " + preguntas + " preguntas.",
        "Preguntas restantes",
        JOptionPane.INFORMATION_MESSAGE);

    botonUsado.setEnabled(false);

    if (preguntas == 0) activarModoRespuesta();
  }//end

  
  /** Muestra un diálogo de información con el texto dado. */
  private void mostrarInfo(String texto) {
    JOptionPane.showMessageDialog(this, texto);
  }//end

  
  /** Escala un ImageIcon a w×h con calidad suave. */
  private static ImageIcon escalarIcono(ImageIcon icono, int w, int h) {
    Image img = icono.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
    return new ImageIcon(img);
  }//end

  
  /** Devuelve un personaje por id si existe. */
  private Optional<Personas> getPorId(int id) {
    if (listaPersonajes == null) return Optional.empty();
    return listaPersonajes.stream().filter(p -> p.getId() == id).findFirst();
  }//end

  
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // Flujo de juego (modo respuesta, reinicio)
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /** Activa el modo de respuesta: deshabilita preguntas y permite elegir personaje. */
  private void activarModoRespuesta() {
    JOptionPane.showMessageDialog(this,
        "Adivina quien es el personaje oculto.",
        "¿Quien es quien?",
        JOptionPane.INFORMATION_MESSAGE);

    // Desactivar todos los botones de preguntas
    for (JButton b: Arrays.asList(
        botonChico, botonChica, botonGafas, botonPendientes, botonBarba, botonBigote,
        botonPecas, botonPeloRubio, botonPeloMoreno, botonPeloNegro,
        botonOjosClaros, botonOjosOscuros, botonOjosDesconocidos,
        botonPielClara, botonPielNormal, botonPielOscura)) {
      if (b != null) b.setEnabled(false);
    }
  }//end

  /** Reinicia contadores, elige nuevo personaje oculto y restaura los iconos de los botones. */
  public void reiniciar() {
    preguntas = 3;
    intentos = 3;

    personajeOculto = listaPersonajes.get(new Random().nextInt(listaPersonajes.size()));

    // Restaurar iconos/personajes
    for (Map.Entry<JButton, Personas> entry : botonesPersonajes.entrySet()) {
      JButton boton = entry.getKey();
      Personas persona = entry.getValue();
      ImageIcon icono = escalarIcono(new ImageIcon(persona.getRutaImagen()), 180, 180);
      boton.setIcon(icono);
      boton.setDisabledIcon(icono);
      boton.setEnabled(true);
    }

    // Reactivar botones de preguntas
    for (JButton b : Arrays.asList(
        botonChico, botonChica, botonGafas, botonPendientes, botonBarba, botonBigote,
        botonPecas, botonPeloRubio, botonPeloMoreno, botonPeloNegro,
        botonOjosClaros, botonOjosOscuros, botonOjosDesconocidos,
        botonPielClara, botonPielNormal, botonPielOscura)) {
      if (b != null) b.setEnabled(true);
    }
  }//end

  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  // 							METODO MAIN -> GO GAME - GO GAME - GO GAME - GO GAME <- METODO MAIN
  // --------------------------------------------------------------------------------------------------------------------------------------------------------
  /*
   * Puedes usar dos constructores para iniciar el juego
   * -> MODO A para hacer prueba y elequir quien quieres que sea el personaje secreto
   * -> MODO B para iniciar una partida normal
   * */
  public static void main(String[] args) { 
	
	// 🟢 MODO NORMAL (Constructor B) 
	  
	SwingUtilities.invokeLater(() -> {
		InterfazJuego juego = new InterfazJuego();
		juego.setVisible(true);
	});
	 
	
    // 🟢 MODO TESTEO (Constructor A)
    
	/*
    SwingUtilities.invokeLater(() -> {
    	GestorPersonas gestor = new GestorPersonas();           // Carga el gestor de personajes
        List<Personas> lista = gestor.getListaPersonajes();     // Obtiene la lista completa

        // Busca en la lista al personaje llamado "Loreto"
        Personas loreto = lista.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase("Loreto"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró al personaje 'Loreto'"));

        // Usa el constructor A para iniciar el juego con Loreto (o quien tu quieras) como personaje oculto, solo marca aqui al personaje
        InterfazJuego juego = new InterfazJuego(loreto, lista);
        juego.setVisible(true);
    });
    */
	  
    
    
    }//end Metodo MAIN
    
}//end class

