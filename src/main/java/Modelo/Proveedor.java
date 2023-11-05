package Modelo;

import java.io.Serializable;

public class Proveedor implements Serializable{
    
    private String codigoProveedor;
    private String nombreProveedor;
    private Producto productoProveedor;

    public Proveedor(){
        codigoProveedor = "";
        nombreProveedor = "";
        productoProveedor = new Producto();
    }

    public Proveedor(String codigoProveedor, String nombreProveedor){

        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.productoProveedor = new Producto();
    }

    //SET 

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setProductoProveedor(Producto productoProveedor) {
        this.productoProveedor = productoProveedor;
    }
    
    //GET
    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public Producto getProductoProveedor() {
        return productoProveedor;
    }
}
