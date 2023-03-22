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
 * @author Enrique Gonzalez Leyva
 */
public class ArticuloDAO {
    
    /**
     * Conecta con Hibernate y con la base de datos MySQL para obtener datos de
     * la base de datos especifica.
     * @return articulos
     */
    public static List<Articulo> obtenerTodos(){
        List<Articulo> articulos = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Articulo> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Articulo.class);
            criteriaQuery.from(Articulo.class);
            
            articulos = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return articulos;
    }
    /**
     * Metodo encargado de registrar los datos que seran usados para guardar
     * una multa nueva.
     * @param clave La clave del articulo registrado
     * @param nombre El nombre del articulo registrado
     * @param precio El precio del articulo registrado
     * @param proveedor El nombre del proveedor que vende el articulo
     * @return resultado
     */
    public static boolean guardar(String clave, String nombre, double precio, Proveedor proveedor){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Articulo a = new Articulo();
            a.setClave(clave);
            a.setNombre(nombre);
            a.setPrecio(precio);
            a.setIdProveedor(proveedor);
            
            session.save(a);
            
            session.getTransaction().commit();
            
            resultado = a.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
   /**
    * Metodo que se encarga de buscar un parametro a traves de su id.
    * @param id
    * @return multa
    */
    public static Articulo obtenerPorId(int id){
        Articulo articulo = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            articulo = session.get(Articulo.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return articulo;
    }
    /**
     * Metodo que se encarga de seleccionar los parametros a editar.
     * @param id el identificador de la linea
     * @param clave La clave del articulo registrado
     * @param nombre El nombre del articulo registrado
     * @param precio El precio del articulo registrado
     * @param proveedor El nombre del proveedor que vende el articulo
     * @return resultado
     */
    public static boolean editar(int id, String clave, String nombre, double precio, Proveedor proveedor){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Articulo articulo = obtenerPorId(id);
            if(articulo != null){
                articulo.setClave(clave);
                articulo.setNombre(nombre);
                articulo.setPrecio(precio);
                articulo.setIdProveedor(proveedor);
                
                session.saveOrUpdate(articulo);              
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
     * @param id el identificador de la linea
     * @return resultado
     */
    public static boolean eliminar(int id){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Articulo articulo = obtenerPorId(id);
            articulo.getId();
            
            if(articulo != null){
                session.delete(articulo);
                HibernateUtil.getSessionFactory().getCurrentSession().delete(articulo);
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}
