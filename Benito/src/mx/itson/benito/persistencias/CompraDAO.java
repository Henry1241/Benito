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
 * @author enri0
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

    public static boolean guardar(Proveedor idProveedor, String folio, List<Articulo> idArticulo, Date fecha) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Compra c = new Compra();
            c.setIdProveedor(idProveedor);
            c.setFolio(folio);
            c.setIdArticulo(idArticulo);
            c.setFecha(fecha);

            session.save(c);

            session.getTransaction().commit();

            resultado = c.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }

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
}
