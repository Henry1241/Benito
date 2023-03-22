/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.persistencias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.Compra;
import mx.itson.benito.entidades.Proveedor;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Enrique Gonzalez Leyva
 */
public class CompraDAO {

    /**
     * Conecta con Hibernate y con la base de datos MySQL para obtener datos de
     * la base de datos especifica
     *
     * @return compra
     */
    public static List<Compra> obtenerTodos() {
        List<Compra> compra = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Compra> criteriaQuery
                    = session.getCriteriaBuilder().createQuery(Compra.class);
            criteriaQuery.from(Compra.class);

            compra = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return compra;
    }

    /**
     * Metodo que se encarga de guardar una orden de compra nueva
     *
     * @param idProveedor Es el identificador del proveedor
     * @param folio Es el folio para la orden registrada
     * @param idArticulo Es el idetificador para el articulo registrado
     * @param fecha Es la fecha en que se realizo la orden de compra
     * @param cantidad Es la cantidad de articulos a comprar
     * @return resultado
     */
    public static boolean guardar(Proveedor idProveedor, String folio, Articulo idArticulo, Date fecha, int cantidad) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Compra c = new Compra();
            c.setIdProveedor(idProveedor);
            c.setFolio(folio);
            c.setIdArticulo(idArticulo);
            c.setFecha(fecha);
            c.setCantidad(cantidad);

            session.save(c);

            session.getTransaction().commit();

            resultado = c.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Metodo que se encarga de buscar por el identificador encontrado en la
     * linea
     *
     * @param id el identificador de la linea
     * @return
     */
    public static Compra obtenerPorId(int id) {
        Compra ordenCompra = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            ordenCompra = session.get(Compra.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return ordenCompra;
    }

    /**
     * Metodo que se encarga de editar una linea seleccionada
     *
     * @param id Es el identificador de la linea seleccionada
     * @param idProveedor Es el identificador del proveedor
     * @param folio Es el folio para la orden registrada
     * @param idArticulo Es el idetificador para el articulo registrado
     * @param fecha Es la fecha en que se realizo la orden de compra
     * @param cantidad Es la cantidad de articulos a comprar
     * @return resultado
     */
    public static boolean editar(int id, Proveedor idProveedor, String folio, Articulo idArticulo, Date fecha, int cantidad) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Compra compra = obtenerPorId(id);
            if (compra != null) {
                compra.setIdProveedor(idProveedor);
                compra.setFolio(folio);
                compra.setIdArticulo(idArticulo);
                compra.setFecha(fecha);
                compra.setCantidad(cantidad);

                session.saveOrUpdate(compra);
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Metodoq que se encarga de eliminar usando un identificador para encontrar la linea a eliminar
     * @param id
     * @return
     */
    public static boolean eliminar(int id) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Compra compra = obtenerPorId(id);
            compra.getId();

            if (compra != null) {
                session.delete(compra);
                HibernateUtil.getSessionFactory().getCurrentSession().delete(compra);
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}
