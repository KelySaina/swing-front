/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProduitForm;

/**
 *
 * @author Ramandimbinirina
 */
public class ModelProduit {
    private String numProduit;
    private String designation;
    private double prix;
    private int quantite;
    private double montant;

    public ModelProduit(String numProduit, String designation, double prix, int quantite, double montant) {
        this.numProduit = numProduit;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
        this.montant = montant;
    }
    
    public ModelProduit(){}

    public ModelProduit(String numProduit, String designation, double prix, int quantite) {
        this.numProduit = numProduit;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }

    public String getNumProduit() {
        return numProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setNumProduit(String numProduit) {
        this.numProduit = numProduit;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
}
