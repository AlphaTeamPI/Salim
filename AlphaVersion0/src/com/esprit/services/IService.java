/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;


import com.esprit.models.programme;
import com.esprit.models.exercice;
import java.util.List;

/**
 *
 * @author trabe
 */
public interface IService<T> {
    public void ajouter(T t);
    public void supprimer(T t);
    public void modifier(T t);
    public List<T> afficher();
    public List<programme> triasc();
    public List<programme> tridesc();
    
}