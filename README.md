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
El juego descartará automáticamente los personajes que no cumplan la condición.

### ✔️ Modo adivinanza
Cuando consumes las preguntas, obtienes **3 intentos** para adivinar el personaje oculto.

### ✔️ Reinicio automático
Tras ganar o perder, el juego te permite volver a jugar o salir.

### ✔️ Código totalmente refactorizado
- Métodos más cortos, organizados y comentados.
- Separación clara entre interfaz, datos y lógica.
- Uso de un mapa `JButton → Persona` para vincular cada botón con su personaje.
- 24 métodos individuales, uno por personaje (muy fácil de editar o ampliar).

---

## 🎓 Proyecto ideal para estudiantes de DAW / DAM

Con este proyecto aprenderás:

- Programación Orientada a Objetos (POO) ✔️  
- Gestión de eventos (`ActionListener`) ✔️  
- Uso de layouts de Swing (`BorderLayout`, `GridLayout`) ✔️  
- Carga y escalado de imágenes (`ImageIcon`, `BufferedImage`) ✔️  
- Refactorización de código ✔️  
- Cómo estructurar un proyecto Java real ✔️  

Perfecto para prácticas, trabajos de clase o para tu portfolio.

---

## 🎬 Vídeo explicativo (20 min)

Incluye:

- Demostración del juego funcionando  
- Explicación detallada del código  
- Cómo modificar personajes, imágenes y atributos  
- Cómo extender o personalizar el juego  

🔗 **ENLACE AL VIDEO:** *(Lo añadirás cuando lo subas)*

---

## 📂 Estructura del proyecto

```text
/src
└─ Elementos_juego
   ├─ InterfazJuego.java      → Ventana principal + lógica del juego
   ├─ Personas.java           → Modelo de datos de cada personaje
   ├─ GestorPersonas.java     → Carga y gestión de la lista de personajes

/img
├─ (24 imágenes de personajes)
├─ (24 imágenes tachadas para descartar personajes)
└─ Iconos opcionales para decorar los botones de las preguntas
   *(esta función no se usó finalmente, pero está preparada por si quieres añadirla)*
```
---
🧠 Cómo ejecutar el proyecto

Clona el repositorio:
- git clone https://github.com/TU-USUARIO/TU-REPO.git
- Abre el proyecto en Eclipse, IntelliJ o NetBeans.
- Ejecuta la clase: InterfazJuego.main()
- ¡Y a jugar! 🎉😁
