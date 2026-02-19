package refactor02;

import java.util.Properties;

public class Main_02 {

    public static void main(String[] args) {

        // Ejercicio 1
        System.out.println("Precio final: " + calculadoraDescuento(8.2, false));

        // Ejercicio 2
        System.out.println("Email válido: " + validarEmail("qwerty@gmail.com"));
        System.out.println("Teléfono válido: " + validarTelefono("631312131"));
        System.out.println("Nombre válido: " + validarNombre("Zoe"));

        // Ejercicio 3
        System.out.println("Impuesto calculado: " + calcularImpuesto(130000, 6));

        // Ejercicio 4
        Producto p = new Producto();
        p.setNombre("Tablet");
        p.setPrecio(250.99);
        p.setStock(15);

        // Ejercicio 5
        Configuracion config = new Configuracion();
        System.out.println(config.cargarConfiguracionTesting());
    }

    // -----------------------------------------------------------------------------------------
    // Ejercicio 1

    public static double calculadoraDescuento(double precio, boolean esClienteVip) {
        double porcentaje = esClienteVip ? 0.20 : 0.10;
        double descuento = precio * porcentaje;
        double precioFinal = precio - descuento;

        System.out.println("Descuento aplicado: " + descuento);
        return precioFinal;
    }

    // -----------------------------------------------------------------------------------------
    // Ejercicio 2

    public static boolean validarEmail(String email) {
        return email != null &&
                !email.isEmpty() &&
                email.length() <= 100 &&
                email.contains("@") &&
                email.contains(".");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono != null &&
                telefono.matches("\\d{9}");
    }

    public static boolean validarNombre(String nombre) {
        return nombre != null &&
                !nombre.isEmpty() &&
                nombre.length() <= 50 &&
                nombre.matches("[a-zA-Z ]+");
    }

    // -----------------------------------------------------------------------------------------
    // Ejercicio 3

    public static double calcularImpuesto(double ingreso, int dependientes) {
        double impuesto = 0;

        if (ingreso < 10000) {
            if (dependientes == 0) impuesto = 0.10;
            else if (dependientes == 1) impuesto = 0.08;
            else impuesto = 0.05;

        } else if (ingreso < 50000) {
            if (dependientes == 0) impuesto = 0.20;
            else if (dependientes == 1) impuesto = 0.15;
            else impuesto = 0.12;

        } else {
            if (dependientes == 0) impuesto = 0.30;
            else if (dependientes == 1) impuesto = 0.25;
            else impuesto = 0.20;
        }

        return ingreso * impuesto;
    }

    // -----------------------------------------------------------------------------------------
    // Ejercicio 4 (clase dentro de Main)

    public static class Producto {

        private String nombre;
        private double precio;
        private int stock;

        public void setNombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty())
                throw new IllegalArgumentException("Nombre inválido");
            if (nombre.length() > 100)
                throw new IllegalArgumentException("Nombre demasiado largo");

            this.nombre = nombre;
        }

        public void setPrecio(double precio) {
            if (precio < 0)
                throw new IllegalArgumentException("Precio no puede ser negativo");
            if (precio > 1_000_000)
                throw new IllegalArgumentException("Precio demasiado alto");

            this.precio = precio;
        }

        public void setStock(int stock) {
            if (stock < 0)
                throw new IllegalArgumentException("Stock no puede ser negativo");
            if (stock > 10_000)
                throw new IllegalArgumentException("Stock excede límite");

            this.stock = stock;
        }
    }

    // -----------------------------------------------------------------------------------------
    // Ejercicio 5 (clase dentro de Main)

    public static class Configuracion {

        private Properties propiedades;

        private Properties crearConfig(String ambiente, String url, boolean debug, int timeout) {
            propiedades = new Properties();
            propiedades.setProperty("ambiente", ambiente);
            propiedades.setProperty("url", url);
            propiedades.setProperty("debug", String.valueOf(debug));
            propiedades.setProperty("timeout", String.valueOf(timeout));
            return propiedades;
        }

        public Properties cargarConfiguracionDesarrollo() {
            return crearConfig("desarrollo", "localhost:8080", true, 5000);
        }

        public Properties cargarConfiguracionProduccion() {
            return crearConfig("produccion", "api.midominio.com", false, 30000);
        }

        public Properties cargarConfiguracionTesting() {
            return crearConfig("testing", "test.midominio.com", true, 10000);
        }
    }
}