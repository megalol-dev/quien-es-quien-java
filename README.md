# 📘 ¿Quién es Quién? – Juego en Java (Versión Refactorizada)

Proyecto desarrollado en **Java + Swing** que recrea el clásico juego de mesa *“¿Quién es quién?”*.  
Incluye interfaz gráfica completa, selección aleatoria del personaje oculto, sistema de preguntas, descartes automáticos y modo de adivinanza final.

Esta versión ha sido **refactorizada desde cero** para ser mucho más clara, modular y fácil de modificar.  
Ideal para estudiantes de **DAW/DAM** que quieran aprender programación orientada a objetos, eventos de Swing y organización de proyectos Java.

---

## 🧩 Características principales

### ✔️ Interfaz gráfica completa (Swing)
- Panel de preguntas con 16 botones.
- Panel de personajes con 24 botones, cada uno con su imagen.
- Sistema automático para tachar personajes descartados.

### ✔️ Personaje oculto aleatorio
Al iniciar una partida, el programa elige un personaje al azar de la lista.

### ✔️ Sistema de preguntas
Puedes realizar **3 preguntas** (género, pelo, piel, etc.).  
El juego descartará automáticamente los personajes que no coincidan con la respuesta.

### ✔️ Modo adivinanza
Al consumir las preguntas, obtienes **3 intentos** para adivinar el personaje oculto.

### ✔️ Reinicio automático
El juego pregunta si quieres volver a jugar o salir tras ganar o perder.

### ✔️ Código totalmente refactorizado
- Métodos más cortos, organizados y comentados.
- Separación clara entre interfaz, datos y lógica.
- Mapa `JButton → Persona` para vincular cada botón con su personaje.
- 24 métodos individuales para cada personaje (muy fácil de editar).

---

## 🎓 Proyecto ideal para estudiantes de DAW / DAM

Este proyecto te enseña:

- POO aplicada ✔️  
- Gestión de eventos con `ActionListener` ✔️  
- Uso de layouts de Swing (`BorderLayout`, `GridLayout`) ✔️  
- Manejo de imágenes (`ImageIcon`, escalado, BufferedImage) ✔️  
- Refactorización avanzada ✔️  
- Cómo estructurar un proyecto Java real ✔️  

Perfecto para trabajos de clase, prácticas o ampliar tu portfolio.

---

## 🎬 Video explicativo (20 min)

Aquí podrás ver:

- El juego funcionando  
- Explicación detallada del código  
- Cómo modificar personajes, imágenes y atributos  
- Cómo extender el juego  

🔗 **ENLACE AL VIDEO:** *(Lo añadirás cuando lo subas)*

---

## 📂 Estructura del proyecto
/src
└─ Elementos_juego
├─ InterfazJuego.java → Ventana principal + lógica de juego
├─ Personas.java → Modelo de datos de cada personaje
├─ GestorPersonas.java → Carga de personajes

/img
├─ (24 imágenes de personajes)
├─ (1 imágenes para tachar personajes)
└─ Iconos opcionales de ejemplo para decorar los botones de las preguntas, esta función no se incluyó finalmente, pero esta todo preparado para si tú quieres implementarlo.

---

## 🧠 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/TU-USUARIO/TU-REPO.git

    Abre el proyecto en Eclipse, IntelliJ o NetBeans.

    Ejecuta la clase:

    InterfazJuego.main()

¡Y a jugar!
