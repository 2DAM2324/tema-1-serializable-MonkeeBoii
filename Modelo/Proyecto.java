import java.util.ArrayList;

public class Proyecto {
    
    private String codigoProyectos;
    private String nombreProyectos;
    private String presupuesto;
    private ArrayList<Empleado> arrayEmpleado;
    private Producto productoProyecto;


    Proyecto(){
        codigoProyectos = "";
        nombreProyectos = "";
        presupuesto = "";
        arrayEmpleado = new ArrayList<>();
        productoProyecto = null;
    }
    //constructor por parametro
    Proyecto(String codigo, String nombre, String presupuesto){
        this.codigoProyectos = codigo;
        this.nombreProyectos = nombre;
        this.presupuesto = presupuesto;
        arrayEmpleado = new ArrayList<>();
        productoProyecto = null;
    }

    //SET
    public void setCodigoProyectos(String codigoProyectos) {
        this.codigoProyectos = codigoProyectos;
    }

    public void setNombreProyectos(String nombreProyectos) {
        this.nombreProyectos = nombreProyectos;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setArrayEmpleado(Empleado a) {
        this.arrayEmpleado.add(a);
    }
    
    public void setProductoProyecto (Producto p){
        this.productoProyecto =p ;
    }

    //GET
    public String getCodigoProyectos() {
        return codigoProyectos;
    }

    public String getNombreProyectos() {
        return nombreProyectos;
    }

    public String getPresupuesto() {
        return presupuesto;
    }
    
    public Empleado getEmpleado(int i) {
        return this.arrayEmpleado.get(i);
    }

    public Producto getProductoProyecto() {
        return productoProyecto;
    }
}
