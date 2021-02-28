package main;

import utilidades.HibernateUtil;
import utilidades.Leer;

import DAO.ClienteDao;
import DAO.DetallePedidoDao;
import DAO.ProductoDao;
import Modelos.Cliente;
import Modelos.Producto;

public class App {
	public static void main(String[] args) {
		
		try {
			HibernateUtil.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Cliente cliente = new Cliente();
		ClienteDao miCliente = new ClienteDao();
		Producto producto = new Producto();
		ProductoDao miProducto = new ProductoDao();
		DetallePedidoDao miDetallePedido = new DetallePedidoDao();
		
		int opcion = 0;
		do {
			
			System.out.println("1.- Anadir cliente");
			System.out.println("2.- Mostrar cliente");
			System.out.println("3.- Mostrar todos los clientes");
			System.out.println("4.- Buscar cliente");
			System.out.println("5.- Editar producto");
			System.out.println("6.- Mostrar todos los detalles de los pedidos de un cliente");
			System.out.println("7.- Mostrar empleado del mes");
			System.out.println("0.- Salir");
			
			opcion = Leer.pedirEnteroValidar();

			switch (opcion) {
			case 1:
				miCliente.create(cliente);
				break;
			case 2:
				miCliente.getById(null);
				break;
			case 3:
				miCliente.getAll();
				break;
			case 4:
				miCliente.buscar();
				break;
			case 5:
				miProducto.update(producto);
				break;
			case 6:
				miDetallePedido.getAll();
				break;
			}
		} while (opcion != 0);
		HibernateUtil.apagar();
	}
}