package Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Producto implements Serializable {
    
    private String codigoProductos;
    private String nombreProductos;
    private String precio;
    private Proveedor proveedorProducto;
    private ArrayList<Proyecto> proyectosProducto;

    public Producto(){

        this.nombreProductos = "";
        this.codigoProductos = "";
        this.precio = "";
        this.proyectosProducto = new ArrayList<>();
    }

    // Constructor por parametro
    public Producto(String codigo, String nombre, String precio){

        this.nombreProductos = nombre;
        this.codigoProductos = codigo;
        this.precio = precio;
        this.proveedorProducto = new Proveedor();
        this.proyectosProducto = new ArrayList<>();
    }

    //SET

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public void setCodigoProductos(String codigoProductos) {
        this.codigoProductos = codigoProductos;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setProveedorProducto(Proveedor proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public void setProyectosProducto(ArrayList<Proyecto> proyectosProducto) {
        this.proyectosProducto = proyectosProducto;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public String getCodigoProductos() {
        return codigoProductos;
    }

    public String getPrecio() {
        return precio;
    }

    public Proveedor getProveedorProducto() {
        return proveedorProducto;
    }

    public ArrayList<Proyecto> getProyectosProducto() {
        return proyectosProducto;
    }
    
    public void agregarProyecto(Proyecto a){
        this.proyectosProducto.add(a);
    }
    
    public void eliminarProyecto(Proyecto a, Producto b) {
    List<Proyecto> proyectosProducto = b.getProyectosProducto();
    Iterator<Proyecto> iterator = proyectosProducto.iterator();

    while (iterator.hasNext()) {
        Proyecto pro = iterator.next();
        if (pro.getId().equals(a.getId())) {
            iterator.remove(); // Usar el iterator para eliminar el elemento
        }
    }
}


}
