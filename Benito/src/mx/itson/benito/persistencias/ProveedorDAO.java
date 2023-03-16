/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.persistencias;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author enri0
 */
public class ProveedorDAO {
    
    /**
     * Conecta con Hibernate y con la base de datos MySQL para obtener datos de
     * la base de datos especifica.
     * @return multas
     */
    public static List<Proveedor> obtenerTodos(){
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Proveedor> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Proveedor.class);
            criteriaQuery.from(Articulo.class);
            
            proveedores = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return proveedores;
    }
    /**
     * Metodo encargado de registrar los datos que seran usados para guardar
     * una multa nueva.
     * @param clave
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param contacto
     * @param articulos
     * @return resultado
     */
    public static boolean guardar(String clave, String nombre, String direccion, String telefono, String email, String contacto, List<Articulo> articulos){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Proveedor p = new Proveedor();
            p.setClave(clave);
            p.setNombre(nombre);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setEmail(email);
            p.setContacto(contacto);
            p.setArticulos(articulos);
            
            session.save(p);
            
            session.getTransaction().commit();
            
            resultado = p.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
   /**
    * Metodo que se encarga de buscar un parametro a traves de su id.
    * @param id
    * @return proveedor
    */
    public static Proveedor obtenerPorId(int id){
        Proveedor proveedor = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            proveedor = session.get(Proveedor.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return proveedor;
    }
    /**
     * Metodo que se encarga de seleccionar los parametros a editar.
     * @param id
     * @param clave
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param contacto
     * @param articulos
     * @return resultado
     */
    public static boolean editar(int id, String clave, String nombre, String direccion, String telefono, String email, String contacto, List<Articulo> articulos){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Proveedor proveedor = obtenerPorId(id);
            if(proveedor != null){
                proveedor.setClave(clave);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
                proveedor.setTelefono(telefono);
                proveedor.setEmail(email);
                proveedor.setContacto(contacto);
                proveedor.setArticulos(articulos);
                
                session.saveOrUpdate(proveedor);              
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * Metodo que se encarga de eliminar usando el id como referencia.
     * @param id
     * @return resultado
     */
    public static boolean eliminar(int id){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Proveedor proveedor = obtenerPorId(id);
            proveedor.getArticulos().get(id);
            
            if(proveedor != null){
                session.delete(proveedor);
                HibernateUtil.getSessionFactory().getCurrentSession().delete(proveedor);
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}
