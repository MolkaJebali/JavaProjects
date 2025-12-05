package tn.esprit.employees.entities;

import java.util.Objects;

public class Etudiant {
    private int id;
    private String nom;
    private int age;

    // Constructeur sans paramètres
    public Etudiant() {}

    // Constructeur avec paramètres
    public Etudiant(int id, String nom, int age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Redéfinition de toString
    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + nom + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Etudiant etudiant = (Etudiant) obj;
        return id == etudiant.id && Objects.equals(nom, etudiant.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}