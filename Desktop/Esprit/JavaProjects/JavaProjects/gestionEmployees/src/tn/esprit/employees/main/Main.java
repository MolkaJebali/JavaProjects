package tn.esprit.employees.main;

import tn.esprit.employees.entities.*;
import tn.esprit.employees.implementations.AffectationHashMap;
import tn.esprit.employees.implementations.SocieteArrayList;
import tn.esprit.employees.implementations.DepartementHashSet;
import java.util.TreeSet;
import tn.esprit.employees.entities.Etudiant;
import tn.esprit.employees.implementations.StudentManagement;
import java.util.*;

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
    {
    List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant(1, "Alice", 20));
        etudiants.add(new Etudiant(3, "Bob", 22));
        etudiants.add(new Etudiant(2, "Charlie", 21));
        etudiants.add(new Etudiant(4, "David", 23));

    // Création du StudentManagement
    StudentManagement studentManagement = new StudentManagement();

    // 1. Test displayStudents
        System.out.println("\n1. Affichage des étudiants:");
        studentManagement.displayStudents(etudiants, e -> System.out.println("  - " + e));

    // 2. Test displayStudentsByFilter (étudiants de plus de 21 ans)
        System.out.println("\n2. Étudiants de plus de 21 ans:");
        studentManagement.displayStudentsByFilter(
    etudiants,
    e -> e.getAge() > 21,
    e -> System.out.println("  - " + e.getNom() + " (" + e.getAge() + " ans)")
            );

    // 3. Test returnStudentsNames
        System.out.println("\n3. Noms des étudiants concaténés:");
    String noms = studentManagement.returnStudentsNames(etudiants, Etudiant::getNom);
        System.out.println("  Noms: " + noms);

    // 4. Test createStudent
        System.out.println("\n4. Création d'un nouvel étudiant:");
    Etudiant nouvelEtudiant = studentManagement.createStudent(() -> new Etudiant(5, "Emma", 19));
        System.out.println("  Nouvel étudiant: " + nouvelEtudiant);

    // 5. Test sortStudentsById
        System.out.println("\n5. Étudiants triés par ID:");
    List<Etudiant> etudiantsTries = studentManagement.sortStudentsById(
            etudiants,
            Comparator.comparingInt(Etudiant::getId)
    );
        etudiantsTries.forEach(e -> System.out.println("  - " + e));

    // 6. Test convertToStream
        System.out.println("\n6. Utilisation du Stream:");
        studentManagement.convertToStream(etudiants)
            .filter(e -> e.getAge() < 22)
            .map(e -> e.getNom().toUpperCase())
            .forEach(nom -> System.out.println("  - " + nom));
}


}