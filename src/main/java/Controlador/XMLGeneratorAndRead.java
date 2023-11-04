package Controlador;

import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Proyecto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class XMLGeneratorAndRead{
    
    public XMLGeneratorAndRead(){  
    }

    public void generarXMLParaEmpleados(List<Empleado> empleados, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Inicio del documento XML
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Empleados>\n");

            // Itera sobre la lista de empleados
            for (Empleado empleado : empleados) {
                writer.write("    <Empleado>\n");
                writer.write("        <DNI>" + empleado.getDNI() + "</DNI>\n");
                writer.write("        <Nombre>" + empleado.getNombre() + "</Nombre>\n");

                for (Proyecto proyecto : empleado.getProyectosAsignados()) {
                    writer.write("        <Proyecto>\n");
                    writer.write("            <Id>" + proyecto.getId() + "</Id>\n");
                    writer.write("            <Nombre>" + proyecto.getNombre() + "</Nombre>\n");
                    writer.write("            <Presupuesto>" + proyecto.getPresupuesto() + "</Presupuesto>\n");
                    writer.write("        </Proyecto>\n");
                }

                writer.write("    </Empleado>\n");
            }

            writer.write("</Empleados>\n");

            System.out.println("Archivo XML de empleados creado con éxito.");
        } catch (IOException e) {
        }
    }
    
    public void generarXMLParaProyecto(List<Proyecto> proyectos, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Inicio del documento XML
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Proyectos>\n");

            // Itera sobre la lista de empleados
            for (Proyecto proyecto : proyectos) {
                writer.write("    <Proyecto>\n");
                writer.write("        <Codigo>" + proyecto.getId() + "</Codigo>\n");
                writer.write("        <Nombre>" + proyecto.getNombre() + "</Nombre>\n");
                writer.write("        <Presupuesto>" + proyecto.getPresupuesto() + "</Presupuesto>\n");
                
                // Itera sobre los proyectos del empleado
                for (Empleado empleado : proyecto.getAsignacionesEmpleados()) {
                    writer.write("        <Empleado>\n");
                    writer.write("            <DNI>" + empleado.getDNI()+ "</DNI>\n");
                    writer.write("            <Nombre>" + empleado.getNombre()+ "</Nombre>\n");
                    writer.write("        </Empleado>\n");
                }
                if(!proyecto.getProductoProyecto().getCodigoProductos().isBlank()){
                    writer.write("        <Producto>\n");
                    writer.write("            <Codigo>" + proyecto.getProductoProyecto().getCodigoProductos() + "</Codigo>\n");
                    writer.write("            <Nombre>" + proyecto.getProductoProyecto().getNombreProductos() + "</Nombre>\n");
                    writer.write("            <Precio>" + proyecto.getProductoProyecto().getPrecio() + "</Precio>\n");
                    writer.write("        </Producto>\n");
                }

                writer.write("    </Proyecto>\n");
            }

            writer.write("</Proyectos>\n");

            System.out.println("Archivo XML de Proyectos creado con éxito.");
        } catch (IOException e) {
        }
    }
    
    public void generarXMLParaProducto(List<Producto> productos, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Inicio del documento XML
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Productos>\n");

            // Itera sobre la lista de empleados
            for (Producto producto : productos) {
                writer.write("    <Producto>\n");
                writer.write("        <Codigo>" + producto.getCodigoProductos()+ "</Codigo>\n");
                writer.write("        <Nombre>" + producto.getNombreProductos()+ "</Nombre>\n");
                writer.write("        <Precio>" + producto.getPrecio() + "</Precio>\n");
                
                // Itera sobre los proyectos del empleado
                for (Proyecto proyecto : producto.getProyectosProducto()) {
                    writer.write("        <Proyecto>\n");
                    writer.write("            <Codigo>" + proyecto.getId()+ "</Codigo>\n");
                    writer.write("            <Nombre>" + proyecto.getNombre() + "</Nombre>\n");
                    writer.write("            <Presupuesto>" + proyecto.getPresupuesto() + "</Presupuesto>\n");
                    writer.write("        </Proyecto>\n");
                }
                if(!producto.getProveedorProducto().getCodigoProveedor().isBlank()){
                    writer.write("        <Proveedor>\n");
                    writer.write("            <Codigo>" + producto.getProveedorProducto().getCodigoProveedor()+ "</Codigo>\n");
                    writer.write("            <Nombre>" + producto.getProveedorProducto().getNombreProveedor() + "</Nombre>\n");
                    writer.write("        </Proveedor>\n");
                }
                writer.write("    </Producto>\n");
                
            }

            writer.write("</Productos>\n");

            System.out.println("Archivo XML de Productos creado con éxito.");
        } catch (IOException e) {
        }
    }
    
    public void generarXMLParaProveedor(List<Proveedor> proveedores, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Inicio del documento XML
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Proveedores>\n");

            // Itera sobre la lista de empleados
            for (Proveedor proveedor : proveedores) {
                writer.write("    <Proveedor>\n");
                writer.write("        <Codigo>" + proveedor.getCodigoProveedor()+ "</Codigo>\n");
                writer.write("        <Nombre>" + proveedor.getNombreProveedor() + "</Nombre>\n");
                
                // Itera sobre los proyectos del empleado
                if(!proveedor.getProductoProveedor().getCodigoProductos().isBlank()) {
                    writer.write("        <Producto>\n");
                    writer.write("            <Codigo>" + proveedor.getProductoProveedor().getCodigoProductos() + "</Codigo>\n");
                    writer.write("            <Nombre>" + proveedor.getProductoProveedor().getNombreProductos() + "</Nombre>\n");
                    writer.write("            <Presupuesto>" + proveedor.getProductoProveedor().getPrecio() + "</Presupuesto>\n");
                    writer.write("        </Producto>\n");
                }
                writer.write("    </Proveedor>\n");
                
            }
            writer.write("</Proveedores>\n");
            
            System.out.println("Archivo XML de Proveedores creado con éxito.");
        } catch (IOException e) {
        }
    }
    
    public List<Empleado> leerXMLDeEmpleados(String nombreArchivo) {
    List<Empleado> empleados = new ArrayList<>();

    try {
        File archivoXML = new File(nombreArchivo);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(archivoXML);

        doc.getDocumentElement().normalize();

        NodeList empleadoNodes = doc.getElementsByTagName("Empleado");

        for (int i = 0; i < empleadoNodes.getLength(); i++) {
            Element empleadoElement = (Element) empleadoNodes.item(i);
            String dni = empleadoElement.getElementsByTagName("DNI").item(0).getTextContent();
            String nombre = empleadoElement.getElementsByTagName("Nombre").item(0).getTextContent();

            Empleado empleado = new Empleado(dni, nombre);

            NodeList proyectoNodes = empleadoElement.getElementsByTagName("Proyecto");

            for (int j = 0; j < proyectoNodes.getLength(); j++) {
                Element proyectoElement = (Element) proyectoNodes.item(j);
                String id = proyectoElement.getElementsByTagName("Id").item(0).getTextContent();
                String nombreProyecto = proyectoElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String presupuestoProyecto = proyectoElement.getElementsByTagName("Presupuesto").item(0).getTextContent();

                Proyecto proyecto = new Proyecto(id, nombreProyecto, presupuestoProyecto);
                empleado.getProyectosAsignados().add(proyecto);
            }

            empleados.add(empleado);
        }
    } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
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
    List<Proyecto> proyectos = new ArrayList<>();

    try {
        File archivoXML = new File(nombreArchivo);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(archivoXML);

        doc.getDocumentElement().normalize();

        NodeList empleadoNodes = doc.getElementsByTagName("Proyecto");

        for (int i = 0; i < empleadoNodes.getLength(); i++) {
            Element empleadoElement = (Element) empleadoNodes.item(i);
            String codigo = empleadoElement.getElementsByTagName("Codigo").item(0).getTextContent();
            String nombre = empleadoElement.getElementsByTagName("Nombre").item(0).getTextContent();
            String presupuesto = empleadoElement.getElementsByTagName("Presupuesto").item(0).getTextContent();

            Proyecto proyecto = new Proyecto(codigo, nombre, presupuesto);

            NodeList proyectoNodes = empleadoElement.getElementsByTagName("Empleado");

            for (int j = 0; j < proyectoNodes.getLength(); j++) {
                Element proyectoElement = (Element) proyectoNodes.item(j);
                String dni = proyectoElement.getElementsByTagName("DNI").item(0).getTextContent();
                String nombreEmpleado = proyectoElement.getElementsByTagName("Nombre").item(0).getTextContent();
                

                Empleado empleado = new Empleado(dni, nombreEmpleado);
                proyecto.getAsignacionesEmpleados().add(empleado);
            }
            
            NodeList productoNodes = empleadoElement.getElementsByTagName("Producto");
            Element productoElement = (Element) productoNodes.item(0);
            if(productoElement != null){
                String codigoPro = productoElement.getElementsByTagName("Codigo").item(0).getTextContent();
                String nombrePro = productoElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String precio = productoElement.getElementsByTagName("Precio").item(0).getTextContent();
                Producto producto = new Producto(codigoPro,nombrePro, precio);
                proyecto.setProductoProyecto(producto);
            }
            proyectos.add(proyecto);
        }
    } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
    }

        return proyectos;
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
    List<Producto> productos = new ArrayList<>();

    try {
        File archivoXML = new File(nombreArchivo);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(archivoXML);

        doc.getDocumentElement().normalize();

        NodeList productoNodes = doc.getElementsByTagName("Producto");

        for (int i = 0; i < productoNodes.getLength(); i++) {
            Element productoElement = (Element) productoNodes.item(i);
            String codigo = productoElement.getElementsByTagName("Codigo").item(0).getTextContent();
            String nombre = productoElement.getElementsByTagName("Nombre").item(0).getTextContent();
            String precio = productoElement.getElementsByTagName("Precio").item(0).getTextContent();

            // Crear un objeto Producto usando el constructor por copia
            Producto producto = new Producto(codigo, nombre, precio);

            // Proyectos del producto
            NodeList proyectoNodes = productoElement.getElementsByTagName("Proyecto");
            ArrayList<Proyecto> proyectos = new ArrayList<>();

            for (int j = 0; j < proyectoNodes.getLength(); j++) {
                Element proyectoElement = (Element) proyectoNodes.item(j);
                String proyectoCodigo = proyectoElement.getElementsByTagName("Codigo").item(0).getTextContent();
                String proyectoNombre = proyectoElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String presupuesto = proyectoElement.getElementsByTagName("Presupuesto").item(0).getTextContent();

                // Crear un objeto Proyecto usando el constructor por copia
                Proyecto proyecto = new Proyecto(proyectoCodigo, proyectoNombre, presupuesto);

                proyectos.add(proyecto);
            }

            producto.setProyectosProducto(proyectos);

            // Proveedor del producto
            Element proveedorElement = (Element) productoElement.getElementsByTagName("Proveedor").item(0);

            if (proveedorElement != null) {
                String proveedorCodigo = proveedorElement.getElementsByTagName("Codigo").item(0).getTextContent();
                String proveedorNombre = proveedorElement.getElementsByTagName("Nombre").item(0).getTextContent();

                // Crear un objeto Proveedor usando el constructor por copia
                Proveedor proveedor = new Proveedor(proveedorCodigo, proveedorNombre);

                producto.setProveedorProducto(proveedor);
            }

            productos.add(producto);
        }

    } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
    }

    return productos;
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
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            File archivoXML = new File(nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            doc.getDocumentElement().normalize();

            NodeList proveedorNodes = doc.getElementsByTagName("Proveedor");

            for (int i = 0; i < proveedorNodes.getLength(); i++) {
                Element proveedorElement = (Element) proveedorNodes.item(i);
                String codigoProveedor = proveedorElement.getElementsByTagName("Codigo").item(0).getTextContent();
                String nombreProveedor = proveedorElement.getElementsByTagName("Nombre").item(0).getTextContent();

                // Crear un objeto Proveedor usando el constructor por copia
                Proveedor proveedor = new Proveedor(codigoProveedor, nombreProveedor);

                // Producto asociado al proveedor
                Element productoElement = (Element) proveedorElement.getElementsByTagName("Producto").item(0);

                if (productoElement != null) {
                    String codigoProductoProveedor = productoElement.getElementsByTagName("Codigo").item(0).getTextContent();
                    String nombreProductoProveedor = productoElement.getElementsByTagName("Nombre").item(0).getTextContent();
                    String precioProductoProveedor = productoElement.getElementsByTagName("Presupuesto").item(0).getTextContent();

                    // Crear un objeto Producto usando el constructor por copia
                    Producto productoProveedor = new Producto(codigoProductoProveedor, nombreProductoProveedor, precioProductoProveedor);

                    proveedor.setProductoProveedor(productoProveedor);
                }

                proveedores.add(proveedor);
            }

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }

       return proveedores;
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
