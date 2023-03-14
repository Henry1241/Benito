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
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author enri0
 */
public class OrdenCompraDAO {
    
    /**
     * Conecta con Hibernate y con la base de datos MySQL para obtener datos de
     * la base de datos especifica
     *
     * @return conductores
     */
    public static List<OrdenCompra> obtenerTodos() {
        List<OrdenCompra> ordenCompra = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<OrdenCompra> criteriaQuery
                    = session.getCriteriaBuilder().createQuery(OrdenCompra.class);
            criteriaQuery.from(OrdenCompra.class);

            ordenCompra = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return ordenCompra;
    }

    public static boolean guardar(String folio, double subtotal, Date fecha) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            OrdenCompra o = new OrdenCompra();
            o.setFolio(folio);
            o.setSubtotal(subtotal);
            o.setFecha(fecha);

            session.save(o);

            session.getTransaction().commit();

            resultado = o.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }

    public static OrdenCompra obtenerPorId(int id) {
        OrdenCompra ordenCompra = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            ordenCompra = session.get(OrdenCompra.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return ordenCompra;
    }
}
