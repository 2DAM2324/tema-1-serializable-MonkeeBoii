import java.util.ArrayList;

public class Producto {
    
    private String nombreProductos;
    private String codigoProductos;
    private double precio;
    private Proveedor proveedorProducto;
    private ArrayList<Proyecto> proyectosProducto;

    Producto(){

        this.nombreProductos = "";
        this.codigoProductos = "";
        this.precio = 0.0;
        this.proveedorProducto = null;
        this.proyectosProducto = new ArrayList<>();
    }

    // Constructor por parametro
    Producto(String nombre, String codigo, double precio){

        this.codigoProductos = codigo;
        this.nombreProductos = nombre;
        this.precio = precio;
        this.proveedorProducto = null;
        this.proyectosProducto = new ArrayList<>();
    }

    //SET
    public void setCodigoProductos(String codigoProductos) {
        this.codigoProductos = codigoProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setProveedorProducto(Proveedor proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public void setProyectosProducto(Proyecto a) {
        this.proyectosProducto.add(a);
    }

    //GET
    public String getCodigoProductos() {
        return this.codigoProductos;
    }

    public String getNombreProductos() {
        return this.nombreProductos;
    }

    public double getPrecio() {
        return this.precio;
    }

    public Proveedor getProveedorProducto() {
        return this.proveedorProducto;
    }

    public Proyecto getProyectosProducto(int i) {
        return this.proyectosProducto.get(i);
    }

}
