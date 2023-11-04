

public class Proveedor {
    
    private String codigoProveedor;
    private String nombreProducto;
    private String nombreProveedor;
    private String codigoProducto;
    private Producto productoProveedor;

    Proveedor(){
        codigoProveedor = "";
        nombreProducto = "";
        nombreProveedor = "";
        codigoProducto = "";
        productoProveedor = null;
    }

    Proveedor(String codigoProveedor, String nombreProducto, String nombreProveedor, String codigoProducto){

        this.codigoProveedor = codigoProveedor;
        this.nombreProducto = nombreProducto;
        this.nombreProveedor = nombreProveedor;
        this.codigoProducto = codigoProducto;
        this.productoProveedor = null;

    }

    //SET 
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setProductoProveedor(Producto productoProveedor) {
        this.productoProveedor = productoProveedor;
    }

    //GET
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public Producto getProductoProveedor() {
        return productoProveedor;
    }
}
