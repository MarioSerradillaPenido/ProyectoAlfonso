package com.example;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<String> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public boolean agregarUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty() || usuarios.contains(usuario)) {
            return false;
        }
        return usuarios.add(usuario);
    }

    public boolean eliminarUsuario(String usuario) {
        return usuarios.remove(usuario);
    }

    public boolean existeUsuario(String usuario) {
        return usuarios.contains(usuario);
    }

    public int cantidadUsuarios() {
        return usuarios.size();
    }
}
