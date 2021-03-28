/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import java.util.List;

/**
 *
 * @author asus
 * @param <T>
 */
public interface IServiceCommande<T> {
    public void ajouter(T t);
    public void supprimer(T t);
    public void modifier(T t,int id);
    public List<T> afficher();
    public int nombre();
//    public List<T> rechercheID(int r);
    public List<T> triasc();
    public List<T> tridesc();
}
