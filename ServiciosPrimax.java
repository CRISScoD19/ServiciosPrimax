import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;

public class ServiciosPrimax {
    static Scanner sc = new Scanner(System.in);
    static String correo, contrasena;
    static final String usuarioAD="yony";
    static final String contraAD="1234";
    static final String usuarioVE="yony1";
    static final String contraVE="4321";
    static ArrayList<String> servicios = new ArrayList<>();
    static ArrayList<Double> precios = new ArrayList<>();
    public static void eliminarPro(){
        System.out.println("\n------ ELIMINAR  PRODUCTO -------");
        System.out.println("Ingrese el nombre del producto:");
        String nombre=sc.nextLine();
        if (servicios.contains(nombre)){
            int indice=servicios.indexOf(nombre);
            servicios.remove(indice);
            precios.remove(indice);
            System.out.println("Producto eliminado!");
        }else{
            System.out.println("No se encontró el producto");
        }
        System.out.println("---------------------------------");
    }
    public static void agregarProducto() {
        sc.nextLine();
        System.out.print("Ingrese el nombre del producto ");
        String nombre = sc.nextLine();
        double precioss;
            System.out.print("ingrese el precio del producto ");
            precioss= sc.nextDouble();
        servicios.add(nombre);
        precios.add(precioss);
        System.out.println("Estudiante agregado correctamente.");
    }
    public static void mostrarProducto(){
        System.out.println("\n----------- PRODUCTOS -----------");
        if (servicios.size()>0){
            for (int i = 0; i < servicios.size(); i++) {
                System.out.println(servicios.get(i)+" - "+precios.get(i));
            }
        }else {
            System.out.println("No hay productos a mostrar");
        }
        System.out.println("---------------------------------");
    }
    public static void modificarPRO(){
        System.out.println("Ingrese nombre del producto a modificar");
        String produc= sc.nextLine();
        int indice=servicios.indexOf(produc);
        if(indice!=0){
            String nuevoPRO;
            double precioa;
            System.out.println("ingrese el nombre del producto");
            nuevoPRO= sc.nextLine();
            System.out.println("ingrese el precio del producto");
            precioa=sc.nextDouble();
            servicios.set(indice,nuevoPRO);
            precios.set(indice,precioa);
        }

    }
    public static void menuAD(){
        System.out.println("Menu del administrador");
        System.out.println("1.-Agregar producto");
        System.out.println("2.-Modificar producto");
        System.out.println("3.-Eliminar producto");
        System.out.println("4.-Mostrar producto");
        System.out.println("5.-Registrar usuario");
        System.out.println("6.-Salir al menu principal");
        int nume= sc.nextInt();
        switch (nume){
            case 1:
                agregarProducto();
                break;
            case 2:
                modificarPRO();
                break;
            case 3:
                eliminarPro();
                break;
            case 4:
                mostrarProducto();
                break;
            case 5:

                break;
            case 6:

                break;
            case 7:
                break;
            default:
                System.out.println("NO VALIDO");
        }
    }
    public static void main(String[] args) {
        System.out.println("-Bienvenido a Autoservicio Primax-");
        boolean ros=true;
        while(ros){
            System.out.println("---BIENVENIDO A SERVICIOS PRIMAX--");
            System.out.println("Elija las siguientes opciones");
            System.out.println("1.-Soy administrador\n 2.-Soy venderdor\n 3.-Soy cliente\n 3.-SALIR");
            int num= sc.nextInt();
            switch (num) {
                case 1:
                    iniciarSesionAD();
                    menuAD();
                    break;
                case 2:
                    iniciarSesioVE();
                    break;
                case 3:
                    System.out.println("CREAR SU CUENTA");
                    crearCuenta();
                    break;
                case 4:
                    System.out.println("SALIENDO");
                    ros=false;

                    break;
                default:
                    System.out.println("NO VALIDO");
            }
        }
    }

    public static void crearCuenta() {
        Pattern patronCorreo = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        Pattern patronContra = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{8,}$");

        while (true) {
            System.out.println("- CREAR CUENTA -");
            System.out.print("Ingrese su correo: ");
            correo = sc.nextLine();
            Matcher matchCorreo = patronCorreo.matcher(correo);

            System.out.print("Cree una contraseña (mín. 8 caracteres, letras y números): ");
            contrasena = sc.nextLine();
            Matcher matchContra = patronContra.matcher(contrasena);

            if (matchCorreo.matches() && matchContra.matches()) {
                System.out.println("Cuenta creada exitosamente\n");
                break;
            } else {
                System.out.println("Correo o contraseña no válidos. Intente nuevamente.\n");
            }
        }
    }
    public static boolean iniciarSesioVE() {
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("=== INICIAR SESIÓN ===");
            System.out.print("USUARIO: ");
            String usuario = sc.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = sc.nextLine();

            if (usuario.equals(usuarioVE) && contraseña.equals(contraVE)) {
                System.out.println("Inicio de sesión exitoso.\n");
                return true;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }
        return false;
    }
    public static boolean iniciarSesionAD() {
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("=== INICIAR SESIÓN ===");
            System.out.print("USUARIO: ");
            String usuario = sc.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = sc.nextLine();

            if (usuario.equals(usuarioAD) && contraseña.equals(contraAD)) {
                System.out.println("Inicio de sesión exitoso.\n");
                return true;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }
        return false;
    }

    public static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n- MENÚ DE SERVICIOS -");
            System.out.println("1. Venta de Gasolina");
            System.out.println("2. Tienda Listo");
            System.out.println("3. Mantenimiento Automotriz");
            System.out.println("4. Finalizar compra");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            double total = 0;
            String descripcion = "";

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione tipo de gasolina:");
                    System.out.println("1. Regular - S/19.50 por galón");
                    System.out.println("2. Premium - S/22.00 por galón");

                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese cantidad de galones: ");
                    double galones = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {
                        total = galones * 19.50;
                        descripcion = String.format("Gasolina Regular: %.2f galones x S/19.50", galones);
                    } else if (tipo == 2) {
                        total = galones * 22.00;
                        descripcion = String.format("Gasolina Premium: %.2f galones x S/22.00", galones);
                    } else {
                        System.out.println("Opción inválida.");
                        continue;
                    }
                    break;

                case 2:
                    servicios.add("1. Hot Dog - S/8.00");
                    servicios.add("2. Hamburguesa - S/12.00");
                    servicios.add("3. Gaseosa - S/5.00");
                    servicios.add("4. Galletas - S/1.00");
                    servicios.add("5. Dulces - S/0.50");
                    servicios.add("6. Helado - S/3.00");
                    servicios.add("7. Agua Mineral - S/1.00");
                    System.out.print("Seleccione producto: ");
                    int producto = sc.nextInt();
                    sc.nextLine();

                    switch (producto) {
                        case 1:
                            total = 8.00; descripcion = "Tienda Listo: Hot Dog";
                            break;
                        case 2:
                            total = 12.00; descripcion = "Tienda Listo: Hamburguesa";
                            break;
                        case 3:
                            total = 5.00; descripcion = "Tienda Listo: Gaseosa";
                            break;
                        case 4:
                            total = 1.00; descripcion = "Tienda Listo: Galletas";
                            break;
                        case 5:
                            total = 0.50; descripcion = "Tienda Listo: Dulces";
                            break;
                        case 6:
                            total = 3.00; descripcion = "Tienda Listo: Helado";
                            break;
                        case 7:
                            total = 1.00; descripcion = "Tienda Listo: Agua Mineral";
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            continue;
                    }
                    break;

                case 3:
                    servicios.add("2. Alineamiento - S/80.00");
                    servicios.add("1. Cambio de Aceite - S/50.00");
                    servicios.add("3. Lavado Premium - S/30.00");
                    System.out.print("Seleccione servicio: ");
                    int mant = sc.nextInt();
                    sc.nextLine();

                    switch (mant) {
                        case 1:
                            total = 50.00; descripcion = "Mantenimiento: Cambio de Aceite";
                            break;
                        case 2:
                            total = 80.00; descripcion = "Mantenimiento: Alineamiento";
                            break;
                        case 3:
                            total = 30.00; descripcion = "Mantenimiento: Lavado Premium";
                            break;
                        default: System.out.println("Opción inválida.");
                            continue;
                    }
                    break;

                case 4:
                    if (servicios.isEmpty()) {
                        System.out.println("No ha seleccionado ningún servicio aún.");
                        continue;
                    } else {
                        if (metodoPago()) {
                            generarBoleta();
                            salir = true;
                        }
                        continue;
                    }

                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            servicios.add(descripcion);
            precios.add(total);

            System.out.print("\n¿Desea volver al menú? (s/n): ");
            String volver = sc.nextLine();
            if (volver.equalsIgnoreCase("n")) {
                if (metodoPago()) {
                    generarBoleta();
                    salir = true;
                }
            }
        }
    }

    public static boolean metodoPago() {
        double totalFinal = 0;
        for (double precio : precios) {
            totalFinal += precio;
        }
        System.out.println("\n- MÉTODO DE PAGO -");
        System.out.println("1. Tarjeta");
        System.out.println("2. Efectivo");
        System.out.print("Seleccione opción: ");
        int opcionPago = sc.nextInt();
        sc.nextLine();

        switch (opcionPago) {
            case 1:
                while (true) {
                    System.out.print("Ingrese número de tarjeta (16 dígitos): ");
                    String tarjeta = sc.nextLine();
                    if (tarjeta.matches("\\d{16}")) {
                        System.out.print("Ingrese CVV (son de 3 digitos): ");
                        String cvv = sc.nextLine();
                        System.out.println("Pago con tarjeta exitoso.");
                        return true;
                    } else {
                        System.out.println("Número de tarjeta inválido. Debe tener 16 dígitos numéricos.");
                    }
                }

            case 2:
                System.out.println("La suma del total de los productos comprados es: " +totalFinal);
                System.out.print("Ingrese monto entregado: ");
                double efectivo = sc.nextDouble();
                double vuelto = efectivo - totalFinal;
                if (efectivo >= totalFinal) {
                    System.out.printf("Pago en efectivo exitoso. Vuelto: S/ %.2f\n", vuelto);
                    return true;
                } else {
                    System.out.println("Monto insuficiente.");
                    return false;
                }

            default:
                System.out.println("Método no válido.");
                return false;
        }
    }

    public static void generarBoleta() {
        double total = 0;
        for (double precio : precios) {
            total += precio;
        }
        System.out.println("\n- BOLETA DE VENTA -");
        System.out.println("Cliente: " + correo);
        System.out.println("Servicios seleccionados:");
        for (int i = 0; i < servicios.size(); i++) {
            System.out.println("- " + servicios.get(i) + " = S/ " + precios.get(i));
        }
        double igv = total * 0.18;
        double totalConIGV = total;
        System.out.printf("IGV (18%%): S/ %.2f\n", igv);
        System.out.printf("Total a pagar (con IGV): S/ %.2f\n", totalConIGV);
        try (FileWriter writer = new FileWriter("boleta.txt")) {
            writer.write("Cliente: " + correo + "\n");
            writer.write("Servicios seleccionados:\n");
            for (int i = 0; i < servicios.size(); i++) {
                writer.write("- " + servicios.get(i) + " - S/ " + precios.get(i) + "\n");
            }
            writer.write(String.format("IGV (18%%): S/ %.2f\n", igv));
            writer.write(String.format("Total a pagar (con IGV): S/ %.2f\n", totalConIGV));
            System.out.println("Boleta exportada a boleta.txt");
        } catch (IOException e) {
            System.out.println("Error al exportar la boleta.");
        }
    }
}