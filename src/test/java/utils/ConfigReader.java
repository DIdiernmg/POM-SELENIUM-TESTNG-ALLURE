package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Este bloque se ejecuta al iniciar la clase
    static {
        try {
            // Buscamos el archivo en la carpeta que creaste en la raíz
            FileInputStream file = new FileInputStream("settings/config.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo cargar el archivo config.properties en la carpeta settings.");
        }
    }

    // Método para obtener los valores
    public static String get(String key) {
        return properties.getProperty(key);
    }
}