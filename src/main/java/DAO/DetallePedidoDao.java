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
		Session r = HibernateUtil.getSession();

		System.out.println("Introduce el ID del cliente para visualizr sus pedidos");
		int id = Leer.pedirEnteroValidar();

		Query y = r.createQuery(
				"select e from DetallePedido e where codigo_pedido in ( select codigo_pedido from Pedido where codigo_cliente= "
						+ id + " group by codigo_pedido");
		Query y2 = r.createQuery(
				"select sum(cantidad*precio_unidad) as total from DetallePedido e where codigo_pedido in " 
						+ "( select codigo_pedido from Pedido where codigo_cliente = "
						+ id + ")");

		List<DetallePedido> allDetallesPedidos = y.getResultList();
		List<DetallePedido> sumaDetallesPedidos = y2.getResultList();

		System.out.println("El total es:" + sumaDetallesPedidos);
		
		return allDetallesPedidos;
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