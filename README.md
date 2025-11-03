# 🎭 ¿Quién es quién? — Videojuego en Java

Este proyecto es una versión digital y adaptada para **un solo jugador** del clásico juego de mesa **“¿Quién es quién?”**, desarrollada desde cero como parte de mi aprendizaje en el ciclo de **Desarrollo de Aplicaciones Web (DAW)**.

---

## 🕹️ Descripción del juego

En esta versión, el jugador debe descubrir cuál es el **personaje secreto** realizando hasta **3 preguntas** para descartar candidatos.  
Puedes preguntar por características como si es **chico o chica**, si **lleva gafas**, si **tiene barba**, etc.  
Después de las 3 preguntas, dispones de **3 intentos** para adivinar quién es el personaje oculto.

- ✅ Si aciertas, el sistema te felicita.  
- ❌ Si fallas los tres intentos, el juego te revelará quién era el personaje secreto.  
- 🧩 En la **primera partida**, el sistema mostrará quién es el personaje (modo *debug*), pero esto se puede **desactivar comentando una línea en el código**.

---

## ⚙️ Estructura del proyecto

El juego se compone de **3 clases principales**:

1. **`Personas`** → Define los atributos de cada personaje (género, accesorios, cabello, etc.).  
2. **`GestorPersonas`** → Contiene las 24 instancias de personajes con sus características definidas.  
3. **`Interface_juego`** → Controla la interfaz gráfica, dibuja el tablero, gestiona los botones y controla el flujo del juego desde inicio hasta fin.

---

## 🧠 Objetivo del proyecto

Este fue mi **primer programa creado completamente desde cero** en Java, y lo desarrollé con el propósito de:

- Aprender a crear una **ventana gráfica con Swing**.  
- Practicar el uso de **botones, eventos y condiciones lógicas**.  
- Desarrollar la estructura y flujo de un pequeño juego funcional.  

Aunque está lejos de ser perfecto, le tengo mucho cariño y me ha servido como base para mejorar mis habilidades en **Java y programación estructurada**.

---

## 💻 Tecnologías y librerías utilizadas

- ☕ **Java**
- 🎨 **Swing** (interfaz gráfica)
- 🧩 **AWT**
- 📦 **Colecciones** (`List`, `Map`, `HashMap`, `Random`)

```java
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
