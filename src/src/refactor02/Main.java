package refactor02;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        calculadoraDescuento(8.2, false);
        validarEmail("qwerty@gmail.com");
        validarTelefono("6313121312");
        validarNombre("Zoe");
        calcularImpuesto(130000, 6);
        // + Metodos
    }
// -----------------------------------------------------------------------------------------
// Ejercicio 1:

    public static double calculadoraDescuento(double precio, boolean esClienteVip) {
        double porcentaje = esClienteVip ? 0.20 : 0.10;
        double descuento = precio * porcentaje;

        System.out.println("Descuento aplicado: " + descuento);
        return precio - descuento;
    }


    // -----------------------------------------------------------------------------------------
// Ejercicio 2:
    public static boolean validarEmail(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }
        if (email.length() > 100) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.length() == 0) {
            return false;
        }
        if (telefono.length() > 9) {
            return false;
        }
        return telefono.matches("\\d+");
    }

    public static boolean validarNombre(String nombre) {
        if (nombre == null || nombre.length() == 0) {
            return false;
        }
        if (nombre.length() > 50) {
            return false;
        }
        return nombre.matches("[a-zA-Z ]+");
    }

// -----------------------------------------------------------------------------------------
//  Ejercicio 3:

    public static double calcularImpuesto(double ingreso, int dependientes) {
        if (ingreso < 10000) {
            if (dependientes == 0) {
                return ingreso * 0.10;
            } else if (dependientes == 1) {
                return ingreso * 0.08;
            } else if (dependientes >= 2) {
                return ingreso * 0.05;
            }
        } else if (ingreso < 50000) {
            if (dependientes == 0) {
                return ingreso * 0.20;
            } else if (dependientes == 1) {
                return ingreso * 0.15;
            } else if (dependientes >= 2) {
                return ingreso * 0.12;
            }
        } else {
            if (dependientes == 0) {
                return ingreso * 0.30;
            } else if (dependientes == 1) {
                return ingreso * 0.25;
            } else if (dependientes >= 2) {
                return ingreso * 0.20;
            }
        }
        return 0;
    }
//
//// -----------------------------------------------------------------------------------------
////  Ejercicio 4:
//
//    public void Producto() {
//
//        private String nombre;
//        private double precio;
//        private int stock;
//
//        public void setNombre (String nombre){
//            if (nombre == null) {
//                throw new IllegalArgumentException("Nombre no puede ser nulo");
//            }
//            if (nombre.trim().isEmpty()) {
//                throw new IllegalArgumentException("Nombre no puede estar vacío");
//            }
//            if (nombre.length() > 100) {
//                throw new IllegalArgumentException("Nombre demasiado largo");
//            }
//            this.nombre = nombre;
//        }
//
//        public void setPrecio (double precio){
//            if (precio < 0) {
//                throw new IllegalArgumentException("Precio no puede ser negativo");
//            }
//            if (precio > 1000000) {
//                throw new IllegalArgumentException("Precio excede el máximo permitido");
//            }
//            this.precio = precio;
//        }
//
//        public void setStock ( int stock){
//            if (stock < 0) {
//                throw new IllegalArgumentException("Stock no puede ser negativo");
//            }
//            if (stock > 10000) {
//                throw new IllegalArgumentException("Stock excede el máximo permitido");
//            }
//            this.stock = stock;
//        }
//    }
//// ------------------------------------------------------------------------------------------
////  Ejercicio 5:
//
//    public void Configuracion() {
//        private Properties propiedades;
//
//        public Properties cargarConfiguracionDesarrollo () {
//            propiedades = new Properties();
//            propiedades.setProperty("ambiente", "desarrollo");
//            propiedades.setProperty("url", "localhost:8080");
//            propiedades.setProperty("debug", "true");
//            propiedades.setProperty("timeout", "5000");
//            return propiedades;
//        }
//
//        public Properties cargarConfiguracionProduccion () {
//            propiedades = new Properties();
//            propiedades.setProperty("ambiente", "produccion");
//            propiedades.setProperty("url", "api.midominio.com");
//            propiedades.setProperty("debug", "false");
//            propiedades.setProperty("timeout", "30000");
//            return propiedades;
//        }
//
//        public Properties cargarConfiguracionTesting () {
//            propiedades = new Properties();
//            propiedades.setProperty("ambiente", "testing");
//            propiedades.setProperty("url", "test.midominio.com");
//            propiedades.setProperty("debug", "true");
//            propiedades.setProperty("timeout", "10000");
//            return propiedades;
//        }
//    }
}