/*package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        final ListView<String> listView = new ListView<>();
        Button btnCargar = new Button("Cargar Usuarios");

        btnCargar.setOnAction(e -> {
            listView.getItems().clear();
            cargarUsuarios(listView);
        });

        VBox root = new VBox(10, btnCargar, listView);
        root.setStyle("-fx-padding: 10px; -fx-alignment: center;"); // Improve UI appearance

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setTitle("Usuarios");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cargarUsuarios(ListView<String> listView) {
        String query = "SELECT nombre FROM usuarios";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listView.getItems().add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error loading users: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/

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