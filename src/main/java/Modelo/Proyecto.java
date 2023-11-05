package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Proyecto implements Serializable{
    private String id;
    private String nombre;
    private String presupuesto;
    private Producto productoProyecto;
    private ArrayList<Empleado> empleados;

    public Proyecto() {
        productoProyecto = new Producto();
        empleados = new ArrayList<>();
    }

    public Proyecto(String id, String nombre, String presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.empleados = new ArrayList<>();
        this.productoProyecto = new Producto();

    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getPresupuesto() {
        return presupuesto;
    }
   
    public ArrayList<Empleado> getAsignacionesEmpleados() {
        return empleados;
    }

    public Producto getProductoProyecto() {
        return productoProyecto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setProductoProyecto(Producto productoProyecto) {
        this.productoProyecto = productoProyecto;
    }

    public void setEmpleados(ArrayList<Empleado> Empleados) {
        this.empleados = Empleados;
    }
   
    public void agregarProyecto(Empleado a){
        this.empleados.add(a);
    }
    
    public void eliminarProyectoDeProducto(Empleado empleadoA, Proyecto proyecto) {
        List<Empleado> proyectosEmpleado = proyecto.getAsignacionesEmpleados();
        Iterator<Empleado> iterator = proyectosEmpleado.iterator();

        while (iterator.hasNext()) {
            Empleado pro = iterator.next();
            if (pro.getDNI().equals(empleadoA.getDNI())) {
                iterator.remove();
            }
        }
    }
}

