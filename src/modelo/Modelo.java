package modelo;

import java.util.List;

import dao.*;
import dominio.*;

public class Modelo {

	private ProveedorDAO proveedores;
	private ProductoDAO productos;
	private CompraDAO compras ;
	private UsuarioDAO usuarios;
	
	public Proveedor alta(Proveedor p){return proveedores.alta(p);}
	public Producto alta(Producto p){return productos.alta(p);}
	public Compra alta(Compra c){return compras.alta(c);}
	public Usuario alta(Usuario u){return usuarios.alta(u);}
	
	public boolean baja(Proveedor p){return proveedores.baja(p.getId());}
	public boolean baja(Producto p){return productos.baja(p.getId());}
	public boolean baja(Compra c){return compras.baja(c.getId());}
	public boolean baja(Usuario c){return usuarios.baja(c.getId());}
	
	public boolean modificacion(Proveedor p){return proveedores.modificacion(p);}
	public boolean modificacion(Producto p){return productos.modificacion(p);}
	public boolean modificacion(Compra c){return compras.modificacion(c);}
	public boolean modificacion(Usuario c){return usuarios.modificacion(c);}
	
	public Proveedor consultaProveedor(int id){return proveedores.consulta(id);}
	public Producto consultaProducto(int id){return productos.consulta(id);}
	public Compra consultaCompra(int id){return compras.consulta(id);}
	public Usuario consultaUsuario(int id){return usuarios.consulta(id);}
	
	public List<Proveedor> consultaProveedores(){return proveedores.consultaAll();}
	public List<Producto> consultaProductos(){return productos.consultaAll();}
	public List<Compra> consultaCompras(){return compras.consultaAll();}
	public List<Usuario> consultaUsuarios(){return usuarios.consultaAll();}
	
	
	
	
	
	
	public UsuarioDAO getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(UsuarioDAO usuarios) {
		this.usuarios = usuarios;
	}
	public ProveedorDAO getProveedores() {
		return proveedores;
	}
	public void setProveedores(ProveedorDAO proveedores) {
		this.proveedores = proveedores;
	}
	public ProductoDAO getProductos() {
		return productos;
	}
	public void setProductos(ProductoDAO productos) {
		this.productos = productos;
	}
	public CompraDAO getCompras() {
		return compras;
	}
	public void setCompras(CompraDAO compras) {
		this.compras = compras;
	}
	
	
	
	
	
}
