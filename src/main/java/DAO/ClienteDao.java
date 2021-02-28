package DAO;

import Modelos.Cliente;
import utilidades.HibernateUtil;
import utilidades.Leer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClienteDao implements Dao<Cliente> {

	Cliente v = new Cliente();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Cliente> getAll() {
		Session r = HibernateUtil.getSession();
		Query q = r.createQuery("select e from Cliente e order by nombre_cliente");
		List<Cliente> allClientes = q.getResultList();
		for (Cliente cliente : allClientes) {
			System.out.println(cliente);
		}
		return allClientes;
	}

	public Cliente getById(Long id) {
		Session r = HibernateUtil.getSession();

		System.out.println("introduce el ID para buscar en la Base de Datos");
		v = r.find(Cliente.class, Leer.pedirEnteroValidar());
		System.out.println("Cliente encontrado");
		System.out.println(v);
		return v;
	}

	public void create(Cliente cliente) {
		Session r = HibernateUtil.getSession();
		Transaction transaccion = r.beginTransaction();

		
		System.out.println("Codigo del cliente");
		cliente.setCodigoCliente(Leer.pedirEnteroValidar());

		System.out.println("Nombre del cliente: ");
		cliente.setNombreCliente(Leer.pedirCadena());

		System.out.println("Nombre de contacto: ");
		cliente.setNombreContacto(Leer.pedirCadena());

		System.out.println("Apellido de contacto: ");
		cliente.setApellidoContacto(Leer.pedirCadena());

		System.out.println("Telefono: ");
		cliente.setTelefono(Leer.pedirCadena());

		System.out.println("Fax: ");
		cliente.setFax(Leer.pedirCadena());

		System.out.println("Linea de direccion: ");
		cliente.setLineaDireccion1(Leer.pedirCadena());

		System.out.println("Linea de direccion 2: ");
		cliente.setLineaDireccion2(Leer.pedirCadena());

		System.out.println("Ciudad: ");
		cliente.setCiudad(Leer.pedirCadena());

		System.out.println("Region: ");
		cliente.setRegion(Leer.pedirCadena());

		System.out.println("Pais: ");
		cliente.setPais(Leer.pedirCadena());

		System.out.println("Codigo postal: ");
		cliente.setCodigoPostal(Leer.pedirCadena());

		System.out.println("Codigo empleado rep ventas: ");
		cliente.setCodigoEmpleadoPepVentas(Leer.pedirEnteroValidar());

		System.out.println("Limite de credito: ");
		cliente.setLimiteCredito(Leer.pedirDecimal());

		r.save(cliente);
		transaccion.commit();
		System.out.println("Cliente creado en la Base de Datos");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Cliente> buscar() {
		Session r = HibernateUtil.getSession();
		System.out.println("introduce el nombre, el contacto o el apellido del cliente");
		String buscar = Leer.pedirCadena();
		Query q = r.createQuery(
				"select e from Cliente e where nombre_cliente = '" + buscar + "'" + " or nombre_contacto = '"
						+ buscar + "' or apellido_contacto = '" + buscar + "' order by nombre_cliente");
		List<Cliente> allClientes = q.getResultList();
		for (Cliente cliente : allClientes) {
			System.out.println(cliente);
		}
		return allClientes;
	}

	public void update(Cliente cliente) {

	}

	public void delete(Cliente cliente) {
	}
}