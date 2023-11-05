package Controlador;

import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Proyecto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.w3c.dom.NodeList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLGeneratorAndRead{
    
    public XMLGeneratorAndRead(){  
    }
    
    public void generarXMLParaEmpleados(List<Empleado> empleados, String nombreArchivo) {
        ObjectOutputStream serializador = null;
        try {
            serializador = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            serializador.writeObject(empleados);
            System.out.println("Empleados serializados con éxito en " + nombreArchivo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (serializador != null) {
                try {
                    serializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    public void generarXMLParaProyecto(List<Proyecto> proyectos, String nombreArchivo) {
        ObjectOutputStream serializador = null;
        try {
            serializador = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            serializador.writeObject(proyectos);
            System.out.println("Proyectos serializados con éxito en " + nombreArchivo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (serializador != null) {
                try {
                    serializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public void generarXMLParaProducto(List<Producto> productos, String nombreArchivo) {
        ObjectOutputStream serializador = null;
        try {
            serializador = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            serializador.writeObject(productos);
            System.out.println("Productos serializados con éxito en " + nombreArchivo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (serializador != null) {
                try {
                    serializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
   
    public void generarXMLParaProveedor(List<Proveedor> proveedores, String nombreArchivo) {
        ObjectOutputStream serializador = null;
        try {
            serializador = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            serializador.writeObject(proveedores);
            System.out.println("Proveedores serializados con éxito en " + nombreArchivo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (serializador != null) {
                try {
                    serializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    public List<Empleado> leerXMLDeEmpleados(String nombreArchivo) {
         List<Empleado> empleados = null;
        ObjectInputStream deserializador = null;

        try {
            deserializador = new ObjectInputStream(new FileInputStream(nombreArchivo));
            empleados = (List<Empleado>) deserializador.readObject();
            System.out.println("Empleados deserializados con éxito desde " + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } finally {
            if (deserializador != null) {
                try {
                    deserializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

        return empleados;
    }
    
    public void cargarDatosEnJTableEmpleados(List<Empleado> empleados, JTable tablaEmpleados) {
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        modelo.setRowCount(0); // Limpia las filas existentes en el modelo

        for (Empleado empleado : empleados) {
            String dni = empleado.getDNI();
            String nombre = empleado.getNombre();

            modelo.addRow(new Object[]{dni, nombre});
        }

        // Asigna el modelo actualizado a la tabla
        tablaEmpleados.setModel(modelo);
    }
    
    
    //
    
    public List<Proyecto> leerXMLDeProyectos(String nombreArchivo) {
        List<Proyecto> listaProyectos = null;
        ObjectInputStream deserializador = null;
        try {
            deserializador = new ObjectInputStream(new FileInputStream(nombreArchivo));
            listaProyectos = (List<Proyecto>) deserializador.readObject();
            System.out.println("Proyectos deserializados con éxito desde " + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (deserializador != null) {
                try {
                    deserializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return listaProyectos;
    }
    
    public void cargarDatosEnJTableProyectos(List<Proyecto> proyectos, JTable tablaProyecto) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProyecto.getModel();
        modelo.setRowCount(0);

        for (Proyecto proyecto : proyectos) {
            String Codigo = proyecto.getId();
            String nombre = proyecto.getNombre();
            String presupuesto = proyecto.getPresupuesto();

            modelo.addRow(new Object[]{Codigo, nombre, presupuesto});
        }

        tablaProyecto.setModel(modelo);
    }
    
    public List<Producto> leerXMLDeProductos(String nombreArchivo) {
        List<Producto> listaProductos = null;
        ObjectInputStream deserializador = null;
        try {
            deserializador = new ObjectInputStream(new FileInputStream(nombreArchivo));
            listaProductos = (List<Producto>) deserializador.readObject();
            System.out.println("Productos deserializados con éxito desde " + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (deserializador != null) {
                try {
                    deserializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return listaProductos;
    }

    
    public void cargarDatosEnJTableProductos(List<Producto> productos, JTable tablaProducto) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProducto.getModel();
        modelo.setRowCount(0);
        if(productos != null){
            for (Producto producto : productos) {
                String Codigo = producto.getCodigoProductos();
                String nombre = producto.getNombreProductos();
                String precio = producto.getPrecio();
                modelo.addRow(new Object[]{Codigo, nombre, precio});
            }
        }

        tablaProducto.setModel(modelo);
    }
    
    public void cargarDatosEnJTableProductos(Producto producto, JTable tablaProducto) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProducto.getModel();
        modelo.setRowCount(0);
        if(producto != null){
                String Codigo = producto.getCodigoProductos();
                String nombre = producto.getNombreProductos();
                String precio = producto.getPrecio();
                modelo.addRow(new Object[]{Codigo, nombre, precio});
            
        }

        tablaProducto.setModel(modelo);
    }
    
    public List<Proveedor> leerXMLDeProveedores(String nombreArchivo) {
        List<Proveedor> listaProveedores = null;
        ObjectInputStream deserializador = null;
        try {
            deserializador = new ObjectInputStream(new FileInputStream(nombreArchivo));
            listaProveedores = (List<Proveedor>) deserializador.readObject();
            System.out.println("Proveedores deserializados con éxito desde " + nombreArchivo);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (deserializador != null) {
                try {
                    deserializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return listaProveedores;
    }
    
    public void cargarDatosEnJTableProveedores(List<Proveedor> proveedores, JTable tablaProveedores) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
        modelo.setRowCount(0);

        for (Proveedor proveedor : proveedores) {
            String codigoProveedor = proveedor.getCodigoProveedor();
            String nombreProveedor = proveedor.getNombreProveedor();
            
            modelo.addRow(new Object[]{codigoProveedor, nombreProveedor});
        }

        tablaProveedores.setModel(modelo);
    }
    
    public void eliminarFilaSeleccionadaEmpleados(JTable tabla, ArrayList<Empleado> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) { 
            modelo.removeRow(filaSeleccionada);

            if (filaSeleccionada < lista.size()) {
                lista.remove(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarFilaSeleccionadaProyecto(JTable tabla, ArrayList<Proyecto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) { 
            modelo.removeRow(filaSeleccionada);

            if (filaSeleccionada < lista.size()) {
                lista.remove(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarFilaSeleccionadaProveedor(JTable tabla, ArrayList<Proveedor> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) { 
            modelo.removeRow(filaSeleccionada);

            if (filaSeleccionada < lista.size()) {
                lista.remove(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarFilaSeleccionadaProducto(JTable tabla, ArrayList<Producto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) { 
            modelo.removeRow(filaSeleccionada);

            if (filaSeleccionada < lista.size()) {
                lista.remove(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Empleado modificarEmpleado(String Dni, String Nombre, JTable tabla, ArrayList<Empleado> lista){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            
            for(Empleado empleado : lista){
                if(empleado.getDNI().equals(valor1)){
                    empleado.setDni(Dni);
                    empleado.setNombre(Nombre);
                    return empleado;
                }
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean generarCamposVistaEmpleado(JTextField dni, JTextField nombre, JTable tabla){
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();
            
            dni.setText(valor1);
            nombre.setText(valor2);
            a = true;
        }
        return a;
    }
    
    public void resetearCamposEmpleado(JTextField dni, JTextField nombre){
        dni.setText("");
        nombre.setText("");
    }
    
    public Proyecto modificarProyecto(String id, String Nombre, String Presupuesto, JTable tabla, ArrayList<Proyecto> lista){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            
            for(Proyecto proyecto : lista){
                if(proyecto.getId().equals(valor1)){
                    proyecto.setId(id);
                    proyecto.setNombre(Nombre);
                    proyecto.setPresupuesto(Presupuesto);
                    return proyecto;
                }
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean generarCamposVistaProyecto(JTextField id, JTextField nombre, JTextField presupuesto, JTable tabla){
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();
            String valor3 = modelo.getValueAt(filaSeleccionada, 2).toString();
            
            id.setText(valor1);
            nombre.setText(valor2);
            presupuesto.setText(valor3);
            a = true;
        }
        return a;
    }
    
    public void resetearCamposProyecto(JTextField dni, JTextField nombre, JTextField presupuesto){
        dni.setText("");
        nombre.setText("");
        presupuesto.setText("");
    }
    
    public Producto modificarProductos(String id, String Nombre, String Precio, JTable tabla, ArrayList<Producto> lista){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            
            for(Producto producto : lista){
                if(producto.getCodigoProductos().equals(valor1)){
                    producto.setCodigoProductos(id);
                    producto.setNombreProductos(Nombre);
                    producto.setPrecio(Precio);
                    return producto;
                }
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean generarCamposVistaProducto(JTextField id, JTextField nombre, JTextField precio, JTable tabla){
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();
            String valor3 = modelo.getValueAt(filaSeleccionada, 2).toString();
            
            id.setText(valor1);
            nombre.setText(valor2);
            precio.setText(valor3);
            a = true;
        }
        return a;
    }
    
    public void resetearCamposProducto(JTextField dni, JTextField nombre, JTextField presupuesto){
        dni.setText("");
        nombre.setText("");
        presupuesto.setText("");
    }
    
    public Proveedor modificarProveedores(String idProveedor, String Nombre, JTable tabla, ArrayList<Proveedor> lista){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            
            for(Proveedor proveedor : lista){
                if(proveedor.getCodigoProveedor().equals(valor1)){
                    proveedor.setCodigoProveedor(idProveedor);
                    proveedor.setNombreProveedor(Nombre);
                    return proveedor;
                }
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean generarCamposVistaProveedor(JTextField id, JTextField nombre, JTable tabla){
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada != -1){
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();
            
            id.setText(valor1);
            nombre.setText(valor2);
            a = true;
        }
        return a;
    }
    
    public void resetearCamposProveedor(JTextField dni, JTextField nombre){
        dni.setText("");
        nombre.setText("");
    }
    
    public Proyecto buscarObjetoEnArrayProyecto(String id, ArrayList<Proyecto> proyectos){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el codigo del proyecto que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        for(Proyecto proyecto : proyectos){
            if(proyecto.getId().equals(id)){
                return proyecto;
            }
        }
        return null;
    }
    
    public Empleado buscarObjetoEnArrayEmpleado(String id, ArrayList<Empleado> empleados){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el dni del empleado que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for(Empleado empleado : empleados){
            if(empleado.getDNI().equals(id)){
                return empleado;
            }
        }
        return null;
        
    }
    
    public Producto buscarObjetoEnArrayProducto(String id, ArrayList<Producto> productos){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el id que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for(Producto producto : productos){
            if(producto.getCodigoProductos().equals(id)){
                return producto;
            }
        }
        return null;
        
    }
    
    public Proveedor buscarObjetoEnArrayProveedor(String id, ArrayList<Proveedor> proveedores){
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el id que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for(Proveedor proveedor : proveedores){
            if(proveedor.getCodigoProveedor().equals(id)){
                return proveedor;
            }
        }
        return null;
        
    }
    
    public void anadirProyectoAEmpleado(ArrayList<Proyecto> proyectos, Proyecto proyecto){
        boolean proyectoExistente = false;
        for (Proyecto proyecto1 : proyectos) {
            if (proyecto1.getId().equals(proyecto.getId())) {
                proyectoExistente = true;
                break;
            }
        }
        if(proyecto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Introduce un proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (proyectoExistente) {
            JOptionPane.showMessageDialog(null, "Por favor, No puedes añadir un mismo proyecto al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Añadir el proyecto a la lista
            proyectos.add(proyecto);
        }
        
    }
    
    public void anadirEmpleadoAProyecto(ArrayList<Empleado> empleados, Empleado empleado){
        
        boolean empleadoExistente = false;
        for (Empleado empleado1 : empleados) {
            if (empleado1.getDNI().equals(empleado.getDNI())) {
                empleadoExistente = true;
                break;
            }
        }
        if(empleado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Introduce un proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (empleadoExistente) {
            JOptionPane.showMessageDialog(null, "Por favor, No puedes añadir un mismo proyecto al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Añadir el proyecto a la lista
            empleados.add(empleado);
        }
        
    }
    
    public void anadirProyectoAProducto(List<Proyecto> proyectos, Proyecto proyecto){
        
        boolean empleadoExistente = false;
        for (Proyecto proyecto1 : proyectos) {
            if (proyecto1.getId().equals(proyecto.getId())) {
                empleadoExistente = true;
                break;
            }
        }
        if(proyecto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Introduce un proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (empleadoExistente) {
            JOptionPane.showMessageDialog(null, "Por favor, No puedes añadir un mismo proyecto al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Añadir el proyecto a la lista
            proyectos.add(proyecto);
        }
    }

    public void anadirProductoAProyecto(Proyecto productoDelProyecto, Producto producto) {
        if (productoDelProyecto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto del proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (producto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (productoDelProyecto.getProductoProyecto().getCodigoProductos().equals(producto.getCodigoProductos())) {
            JOptionPane.showMessageDialog(null, "No puedes añadir el mismo producto al proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            productoDelProyecto.setProductoProyecto(producto);

        }
    }   
    public void eliminarProyecto(ArrayList<Proyecto> proyectos, String id){
        if(proyectos != null){
            Iterator<Proyecto> iterator = proyectos.iterator();
            while (iterator.hasNext()) {
                Proyecto proyecto = iterator.next();
                if (proyecto.getId().equals(id)) {
                    iterator.remove(); // Removes the current element from the list
                }
            }
        }
    }
    
    public void eliminarEmpleadoEnProyecto(ArrayList<Empleado> empleados, String id){
        if(empleados != null){
            Iterator<Empleado> iterator = empleados.iterator();
            while (iterator.hasNext()) {
                Empleado empleado = iterator.next();
                if (empleado.getDNI().equals(id)) {
                    iterator.remove(); // Removes the current element from the list
                }
            }
        }
    }
    
    public void eliminarProductoEnProveedor(Producto productos, String id){
        if(productos != null){
            if (productos.getCodigoProductos().equals(id)) {
                productos.setCodigoProductos("");
                productos.setNombreProductos("");
                productos.setPrecio("");
            }
            
        }
    }
    
    public void eliminarProductoEnProveedor(Proveedor proveedor, String id){
        if(proveedor != null){
            if (proveedor.getCodigoProveedor().equals(id)) {
                proveedor.setCodigoProveedor("");
                proveedor.setNombreProveedor("");
            }
        }
    }
    
    public void anadirProveedorAProducto(Proveedor b, Producto a) {
        if (b == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un proveedor valido", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (a == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (b.getProductoProveedor().getCodigoProductos().equals(a.getCodigoProductos())) {
            JOptionPane.showMessageDialog(null, "No puedes añadir el mismo producto al proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            b.setProductoProveedor(a);

        }
    }
    
    
    
    public void anadirProveedorAProducto(Producto a, Proveedor b) {
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un proveedor valido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (b == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (a.getProveedorProducto().getCodigoProveedor().equals(b.getCodigoProveedor())) {
            JOptionPane.showMessageDialog(null, "No puedes añadir el mismo producto al proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            a.setProveedorProducto(b);
        }
    }
    
    
    public boolean comprobarSiElObjetoYaExisteProducto(ArrayList<Producto> lista, String id){
        for( Producto objeto : lista){
            if(objeto.getCodigoProductos().equals(id)){
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Producto con el mismo ID", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public boolean comprobarSiElObjetoYaExisteEmpleado(ArrayList<Empleado> lista, String id){
        for( Empleado objeto : lista){
            if(objeto.getDNI().equals(id)){
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Empleados con el mismo DNI.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public boolean comprobarSiElObjetoYaExisteProyecto(ArrayList<Proyecto> lista, String id){
        for( Proyecto objeto : lista){
            if(objeto.getId().equals(id)){
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Proyecto con el mismo ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public boolean comprobarSiElObjetoYaExisteProveedor(ArrayList<Proveedor> lista, String id){
        for( Proveedor objeto : lista){
            if(objeto.getCodigoProveedor().equals(id)){
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Proveedor con el mismo ID", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public boolean tieneAlgunAtributoVacio(String a, String b, String c){
        
        if(a != null && b != null && c != null){
            if(a.isBlank() || b.isBlank() || c.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !a.isBlank() && !b.isBlank() && !c.isBlank();
        }else if(a != null && b != null && c == null){
            if(a.isBlank() || b.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !a.isBlank() && !b.isBlank();
        }else if(a != null && b == null && c == null){
            if(a.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !a.isBlank();
        }else if(a == null && b != null && c != null){
            if(b.isBlank() || c.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !b.isBlank() && !c.isBlank();
        }else if(a == null && b == null && c != null){
            if(c.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !c.isBlank();
        }else if(a != null && b == null && c != null){
            if(a.isBlank() || c.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !a.isBlank() && !c.isBlank();
        }else if(a == null && b != null && c == null){
            if(b.isBlank()){
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !b.isBlank();
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean comprobarSiHayRelacionesEnELObjeto(Empleado a){
        if(a.getProyectosAsignados() == null){
            return true;
        }else if(a.getProyectosAsignados().isEmpty() || a.getProyectosAsignados().get(0).getId().isBlank()){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Empleado con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean comprobarSiHayRelacionesEnELObjeto(Proyecto a){
        if(a.getAsignacionesEmpleados()== null && a.getProductoProyecto() == null){
            return true;
        }else if((a.getAsignacionesEmpleados().isEmpty() || a.getAsignacionesEmpleados().get(0).getDNI().isBlank()) && a.getProductoProyecto().getCodigoProductos().isBlank()){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Proyecto con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean comprobarSiHayRelacionesEnELObjeto(Producto a){
        if(a.getProyectosProducto() == null && a.getProveedorProducto() == null){
            return true;
        }else if((a.getProyectosProducto().isEmpty() || a.getProyectosProducto().get(0).getId().isBlank()) && a.getProveedorProducto().getCodigoProveedor().isBlank()){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Producto con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean comprobarSiHayRelacionesEnELObjeto(Proveedor a){
        if(a.getProductoProveedor()== null){
            return true;
        }else if(a.getProductoProveedor().getCodigoProductos().isBlank()){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Proveedor con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
