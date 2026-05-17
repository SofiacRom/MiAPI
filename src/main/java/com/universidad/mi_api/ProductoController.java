package com.universidad.mi_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController 
@RequestMapping("/productos") // La URL base para todos los endpoints será http://localhost:5000/productos
public class ProductoController {

    // REQUERIMIENTO 2: Lista en memoria para almacenar los datos temporalmente
    private List<Producto> productos = new ArrayList<>(Arrays.asList(
        new Producto(1, "Laptop", 1200.0),
        new Producto(2, "Mouse", 25.0),
        new Producto(3, "Teclado", 45.0)
    ));

    // REQUERIMIENTO 3: Endpoint GET (Consultar todos)
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productos; // Spring convierte automáticamente esta lista a formato JSON
    }

    // REQUERIMIENTO 4: Endpoint GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable int id) {
        // Buscamos el producto en la lista que coincida con el ID recibido
        for (Producto p : productos) {
            if (p.getId() == id) {
                return ResponseEntity.ok(p); // Retorna el producto con estado 200 OK
            }
        }
        // Si sale del bucle y no lo encuentra, maneja el caso retornando 404 Not Found
        return ResponseEntity.notFound().build();
    }

    // REQUERIMIENTO 5: Endpoint POST (Crear)
    @PostMapping
    public String crear(@RequestBody Producto nuevoProducto) {
        productos.add(nuevoProducto); // Agrega el nuevo producto que envía el cliente a la lista
        return "Producto agregado con éxito"; // Mensaje de confirmación
    }

    // REQUERIMIENTO 6: Endpoint PUT (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable int id, @RequestBody Producto datosNuevos) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                // Modificamos los atributos del elemento existente con los nuevos datos
                p.setNombre(datosNuevos.getNombre());
                p.setPrecio(datosNuevos.getPrecio());
                return ResponseEntity.ok(p); // Retorna el elemento actualizado
            }
        }
        return ResponseEntity.notFound().build(); // Si el ID no existe, retorna 404
    }

    // REQUERIMIENTO 7: Endpoint DELETE (Eliminar)
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        // Remueve de la lista si el ID coincide
        boolean eliminado = productos.removeIf(p -> p.getId() == id);
        
        if (eliminado) {
            return "Producto eliminado con éxito";
        } else {
            return "El producto con ID " + id + " no existe.";
        }
    }
}