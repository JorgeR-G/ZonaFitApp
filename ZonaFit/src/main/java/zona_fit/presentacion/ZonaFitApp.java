package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        // Creamos un obnjeto de la clase clienteDao
        IClienteDAO clienteDAO = new ClienteDAO();
        var clienteDao = new ClienteDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDao);
            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Zona Fit (GYM)
                1. Listar Clientes
                2. Buscar Clientes
                3. Agregar Clientes
                4. Modificar Clientes
                5. Eliminar Cliente
                6. Salir
                Elije una opción:\s""");
        return Integer.parseInt(consola.nextLine());

    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDAO clienteDAO){
        var salir = false;
        switch (opcion){
            case 1 -> { // 1. Listar clientes
                System.out.println("--- Listado de Clientes ---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 -> { // 2.Buscar cliente id
                System.out.println("Introduce el id del Cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if(encontrado)
                    System.out.print("Cliente encontrado: " + cliente);
                else
                    System.out.println("Cliente NO encontrado: " + cliente);
            }
            case 3 -> { // 3. Agregar cliente
                System.out.println("--- Agregar Cliente ---");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Miembro: ");
                var miembro = Integer.parseInt(consola.nextLine());
                // Creamos el opbjeto cliente (sin el id)
                var cliente = new Cliente(nombre, apellido, miembro);
                var agregado = clienteDAO.agregarCliente(cliente);
                if(agregado)
                    System.out.println("Cliente agregado: " + cliente);
                else
                    System.out.println("Cliente NO agregado: " + cliente);
            }
            case 4 -> { // 4. Modificar Cliente
                System.out.print("Id Cliente: ");
                var IdCliente = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Miembro: ");
                var miembro = Integer.parseInt(consola.nextLine());
                // Creamos el objeto a modificar
                var cliente = new Cliente(IdCliente, nombre, apellido, miembro);
                var modificar = clienteDAO.modificarCliente(cliente);
                if(modificar)
                    System.out.println("Cliente modificado: " + cliente);
                else
                    System.out.println("Cliente NO modificado: " + cliente);
            }
            case 5 -> { // 5. Eliminar Cliente
                System.out.print("--- Eliminar Cliente  ---");
                System.out.print("Id Cliente: ");
                var IdCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(IdCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if(eliminado)
                    System.out.println("Cliente eliminado: " + cliente);
                else
                    System.out.println("Cliente NO eliminado0: " + cliente);
            }
            case 6 -> { // 6. Salir
                System.out.println("Hasta Pronto!");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;
    }
}

