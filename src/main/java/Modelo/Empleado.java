package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Empleado implements Serializable {
    private String dni;
    private String nombre;
    private ArrayList<Proyecto> proyectosAsignados;

    public Empleado() {
        proyectosAsignados = new ArrayList<>();
    }

    public Empleado(String id, String nombre) {
        this.dni = id;
        this.nombre = nombre;
        proyectosAsignados = new ArrayList<>();
    }

    public String getDNI() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Proyecto> getProyectosAsignados() {
        return proyectosAsignados;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProyectosAsignados(ArrayList<Proyecto> proyectosAsignados) {
        this.proyectosAsignados = proyectosAsignados;
    }
    
    public void agregarProyecto(Proyecto a){
        this.proyectosAsignados.add(a);
    }
    
    public void eliminarProyecto(Proyecto a, Empleado b) {
        List<Proyecto> proyectosAsignados = b.getProyectosAsignados();
        Iterator<Proyecto> iterator = proyectosAsignados.iterator();

        while (iterator.hasNext()) {
            Proyecto pro = iterator.next();
            if (pro.getId().equals(a.getId())) {
                iterator.remove(); // Usar el iterator para eliminar el elemento
            }
        }
    }

}
