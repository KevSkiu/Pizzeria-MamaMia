package com.pizzeria.mamamia.controller;

import com.pizzeria.mamamia.model.Producto;
import com.pizzeria.mamamia.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Esta puerta ya la tenían (Para que JC lea las pizzas)
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // --- NUEVO: Esta puerta sirve para crear pizzas desde el panel Admin ---
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto nuevoProducto) {
        Producto productoGuardado = productoRepository.save(nuevoProducto);
        return ResponseEntity.ok(productoGuardado);
    }
}