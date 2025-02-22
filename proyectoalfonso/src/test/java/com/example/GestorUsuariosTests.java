package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

import org.junit.Test;

import com.example.GestorUsuarios;

public class GestorUsuariosTests {
    private GestorUsuarios gestor;

    @Before
    public void setUp() {
        gestor = new GestorUsuarios();
    }

    //prueba 1
    @Test
    public void agregarUsuarioCorrectamente() {
    assertTrue(gestor.agregarUsuario("usuario1"));
    assertEquals(1, gestor.cantidadUsuarios());
    }

    //prueba 2
    @Test
    public void agregarUsuarioDuplicado() {
    gestor.agregarUsuario("usuario1");
    assertFalse(gestor.agregarUsuario("usuario1"));
    }   

    //prueba 3
    @Test
    public void agregarUsuarioNulo() {
    assertFalse(gestor.agregarUsuario(""));
    assertFalse(gestor.agregarUsuario(null));
    }

    //prueba 4
    @Test
    public void eliminarUsuarioExistente() {
    gestor.agregarUsuario("usuario1");
    assertTrue(gestor.eliminarUsuario("usuario1"));
    assertEquals(0, gestor.cantidadUsuarios());
    }

    //prueba 5
    @Test
    public void eliminarUsuarioInexistente() {
        assertFalse(gestor.eliminarUsuario("usuario2"));
    }

    //prueba 6
    @Test
    public void verificarExistenciaDeUsuario() {
        gestor.agregarUsuario("usuario1");
        assertTrue(gestor.existeUsuario("usuario1"));
        assertFalse(gestor.existeUsuario("usuario2"));
    }

    //prueba 7
    @Test
    public void cantidadUsuarios() {
        gestor.agregarUsuario("usuario1");
        gestor.agregarUsuario("usuario2");
        assertEquals(2, gestor.cantidadUsuarios());
    }


}
