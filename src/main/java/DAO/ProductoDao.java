package DAO;

import utilidades.HibernateUtil;
import utilidades.Leer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelos.Producto;

import java.util.List;

public class ProductoDao implements Dao<Producto> {

	public List<Producto> getAll() {
		return null;	
		}

	public Producto getById(Long id) {
		return null;
		}

	public void create(Producto producto) {
		}

	public void update(Producto producto) {
		Session r = HibernateUtil.getSession();
		Transaction transaccion = r.beginTransaction();
		
		System.out.println("Introduce el id del producto a modificar");
		producto = r.find(Producto.class, Leer.pedirCadena());
		
		producto = r.load(Producto.class, r);
		
		System.out.println("Introduce el nuevo nombre del producto");
		producto.setNombre(Leer.pedirCadena());
		
		System.out.println("Introduce la nueva gama del producto: ");
		String newGama = Leer.pedirCadena();
		if (newGama.equalsIgnoreCase("")) {
			newGama = producto.getGama();
		}
		producto.setGama(newGama);

		System.out.println("Introduce las nuevas dimensiones del producto: ");
		String newDimensiones = Leer.pedirCadena();
		if (newDimensiones.equalsIgnoreCase("")) {
			newDimensiones = producto.getDimensiones();
		}
		producto.setDimensiones(newDimensiones);

		System.out.println("Introduce el nuevo proveedor del producto: ");
		String newProveedor = Leer.pedirCadena();
		if (newProveedor.equalsIgnoreCase("")) {
			newProveedor = producto.getProveedor();
		}
		producto.setProveedor(newProveedor);

		System.out.println("Introduce la nueva descripcion del producto: ");
		String newDescripcion = Leer.pedirCadena();
		if (newDescripcion.equalsIgnoreCase("")) {
			newDescripcion = producto.getDescripcion();
		}
		producto.setDescripcion(newDescripcion);

		System.out.println("Introduce la nueva cantidad en stock del producto: ");
		producto.setCantidadEnStock(Leer.pedirEnteroValidar());

		System.out.println("Introduce el nuevo precio de venta del producto: ");
		producto.setPrecioVenta(Leer.pedirDecimal());

		System.out.println("Introduce el nuevo precio de proveedor del producto: ");
		producto.setPrecioProveedor(Leer.pedirDecimal());
		
		r.update(producto);
		transaccion.commit();
		System.out.println("Producto actualizado");
	}

	public void delete(Producto producto) {
		
	}
}