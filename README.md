# API Backend de Gestión de Productos desde Cero

Este es un proyecto universitario desarrollado en **Java con Spring Boot (versión 4.0.6)**. El objetivo del taller es construir una API REST básica en el backend que permita gestionar una lista de elementos en memoria utilizando los métodos HTTP principales (GET, POST, PUT, DELETE).

## Tecnologías Utilizadas
* **Lenguaje:** Java 21
* **Framework:** Spring Boot 4.0.6
* **Gestor de Dependencias:** Maven
* **Herramienta de Construcción:** Spring Initializr
* **Cliente de Pruebas:** Thunder Client (VS Code)

## Pasos de Configuración Seguidos
1. **Inicialización:** Se utilizó *Spring Initializr* para generar el esqueleto del proyecto con la dependencia de *Spring Web*.
2. **Cambio de Puerto:** Se configuró el archivo `application.properties` para exponer el servidor en el puerto `5000` (`server.port=5000`).
3. **Modelo de Datos:** Se creó la clase `Producto.java` con atributos encapsulados (`id`, `nombre`, `precio`).
4. **Controlador REST:** Se implementó `ProductoController.java` mapeando la ruta `/productos` para procesar el ciclo de vida de las peticiones HTTP.

## Endpoints Disponibles (Endpoints de la API)
| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| **GET** | `/productos` | Retorna la lista completa en formato JSON. |
| **GET** | `/productos/{id}` | Busca un producto por ID (Maneja error 404 si no existe). |
| **POST** | `/productos` | Agrega un nuevo producto enviando un JSON. |
| **PUT** | `/productos/{id}` | Modifica un producto existente según su ID. |
| **DELETE** | `/productos/{id}` | Elimina de la lista el producto con el ID indicado. |

## Interfaz Gráfica (Frontend)
El proyecto incluye una interfaz web moderna y limpia construida con HTML, JavaScript nativo y Tailwind CSS. 
* Para acceder, simplemente enciende el servidor y entra a: `http://localhost:5000`
* Permite interactuar visualmente con todos los métodos de la API en tiempo real.
