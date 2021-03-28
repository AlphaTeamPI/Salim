/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;


import com.esprit.models.Abonnement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iyed Zidi
 */
public interface IServiceAbonnement<T> {
    public void ajouter(T t);
    public void supprimer(T t);
    public void modifier(T t);
    public List<T> afficher();
    public List<Abonnement> triasc();
    public List<Abonnement> tridesc();
}
