/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.benito.ui;

import mx.itson.benito.persistencias.CompraDAO;
import mx.itson.benito.persistencias.RelacionDAO;

/**
 *
 * @author Enrique Gonzalez Leyva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CompraDAO.obtenerTodos();
    }
    
}
