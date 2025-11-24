package tn.esprit.employees.main;

import tn.esprit.employees.entities.*;
import tn.esprit.employees.implementations.AffectationHashMap;
import tn.esprit.employees.implementations.SocieteArrayList;
import tn.esprit.employees.implementations.DepartementHashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Test de l'AffectationHashMap
        AffectationHashMap gestionAffectations = new AffectationHashMap();

        // Création des employés et départements
        Employe emp1 = new Employe(1, "Doe", "John", "IT", 3);
        Employe emp2 = new Employe(2, "Smith", "Jane", "HR", 2);
        Employe emp3 = new Employe(3, "Brown", "Bob", "IT", 1);
        Employe emp4 = new Employe(4, "Wilson", "Alice", "Finance", 2);

        Departement depIT = new Departement(1, "IT", 50);
        Departement depHR = new Departement(2, "HR", 20);
        Departement depFinance = new Departement(3, "Finance", 15);
        Departement depMarketing = new Departement(4, "Marketing", 10);

        // Instruction 2: Ajout des affectations
        gestionAffectations.ajouterEmployeDepartement(emp1, depIT);
        gestionAffectations.ajouterEmployeDepartement(emp2, depHR);
        gestionAffectations.ajouterEmployeDepartement(emp3, depIT);
        gestionAffectations.ajouterEmployeDepartement(emp4, depFinance);

        // Instruction 3: Test - ajouter le même employé dans deux départements
        System.out.println("=== Test ajout même employé dans deux départements ===");
        gestionAffectations.ajouterEmployeDepartement(emp1, depMarketing); // Remplace l'ancienne affectation
        gestionAffectations.afficherEmployesEtDepartements();

        // Instructions 6 et 7
        gestionAffectations.afficherEmployes();
        gestionAffectations.afficherDepartements();

        // Instructions 8 et 9
        System.out.println("Recherche emp1: " + gestionAffectations.rechercherEmploye(emp1));
        System.out.println("Recherche département IT: " + gestionAffectations.rechercherDepartement(depIT));

        // Instruction 4: Suppression d'un employé
        gestionAffectations.supprimerEmploye(emp2);

        // Instruction 5: Suppression avec département spécifique
        gestionAffectations.supprimerEmployeEtDepartement(emp3, depIT);

        // Affichage après suppressions
        gestionAffectations.afficherEmployesEtDepartements();

        // Instruction 10: Tri par ID
        gestionAffectations.afficherMapTrie();

        // Tests des autres classes existantes
        System.out.println("\n=== Tests des autres classes ===");
        SocieteArrayList societe = new SocieteArrayList();
        societe.ajouterEmploye(emp1);
        societe.ajouterEmploye(emp2);
        societe.ajouterEmploye(emp3);
        societe.ajouterEmploye(emp4);

        System.out.println("=== Tous les employés ===");
        societe.displayEmploye();

        DepartementHashSet gestionDepartements = new DepartementHashSet();
        gestionDepartements.ajouterDepartement(depIT);
        gestionDepartements.ajouterDepartement(depHR);
        gestionDepartements.ajouterDepartement(depFinance);

        System.out.println("\n=== Tous les départements ===");
        gestionDepartements.displayDepartement();
    }
}