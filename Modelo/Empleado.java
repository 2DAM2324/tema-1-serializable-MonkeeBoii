import java.util.ArrayList;

public class Empleado{

    private String DNI;
    private String NombreEmpleado;
    private String Proyecto;
    private ArrayList<Proyecto> arrayProyecto;
    
    Empleado(){
        this.DNI = "";
        this.NombreEmpleado = "";
        this.Proyecto = "";
        this.arrayProyecto = new ArrayList<>();
    }
    // Constructor por parametro
    Empleado(String DNI, String Nombre, String Proyecto){
        this.DNI = DNI;
        this.NombreEmpleado = Nombre;
        this.Proyecto = Proyecto;
    }

    //GET
    public String getDNI() {
        return this.DNI;
    }

    public String getNombreEmpleado() {
        return this.NombreEmpleado;
    }

    public String getProyecto() {
        return this.Proyecto;
    }

    public Proyecto getProyectos(int i) {
        return this.arrayProyecto.get(i);
    }

    //SET
    public void setDNI(String dNI) {
        this.DNI = dNI;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.NombreEmpleado = nombreEmpleado;
    }
    
    public void setProyecto(String proyecto) {
        this.Proyecto = proyecto;
    }

    public void setArrayProyecto(Proyecto a) {
        this.arrayProyecto.add(a);
    }
}