package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Modelos.DetallePedido;
import utilidades.HibernateUtil;
import utilidades.Leer;

public class DetallePedidoDao implements Dao<DetallePedido> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<DetallePedido> getAll() {
		Session s = HibernateUtil.getSession();

		System.out.println("Introduce el ID del cliente para visualizr sus pedidos");
		int id = Leer.pedirEnteroValidar();

		Query q = s.createQuery(
				"select e from DetallePedido e where codigo_pedido in ( select codigo_pedido from Pedido where codigo_cliente= "
						+ id + " group by codigo_pedido");
		Query q2 = s.createQuery(
				"select sum(cantidad*precio_unidad) as total from DetallePedido e where codigo_pedido in ( select codigo_pedido from Pedido where codigo_cliente = "
						+ id + ")");
		// Query q3 = s.createQuery("select nombre_producto, gama, descripcion from productos");
		// Query q4 = s.createQuery("select fecha_pedido from pedido");

		List<DetallePedido> todosLosDetallesPedidos = q.getResultList();
		List<DetallePedido> sumaDetallesPedidos = q2.getResultList();
		// List<DetallePedido> nombreGamaDescripcionProductos = q3.getResultList();
		// List<DetallePedido> fechaDelPedido = q4.getResultList();

		System.out.println("La suma total es:" + sumaDetallesPedidos);
		// System.out.println("Productos: " + nombreGamaDescripcionProductos);
		// System.out.println("La fecha del pedido es: " + fechaDelPedido);
		return todosLosDetallesPedidos;
	}

	public DetallePedido getById(Long id) {
		return null;
	}

	public void create(DetallePedido t) {

	}

	public void update(DetallePedido t) {

	}

	public void delete(DetallePedido t) {

	}
}