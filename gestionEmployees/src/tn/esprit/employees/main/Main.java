package tn.esprit.employees.main;

import tn.esprit.employees.entities.*;
import tn.esprit.employees.implementations.SocieteArrayList;
public class Main {
    public static void main(String[] args) {


        SocieteArrayList societe = new SocieteArrayList();

        Employe emp1 = new Employe(1, "Doe", "John", "IT", 3);
        Employe emp2 = new Employe(2, "Smith", "Jane", "HR", 2);
        Employe emp3 = new Employe(3, "Brown", "Bob", "IT", 1);
        Employe emp4 = new Employe(4, "Wilson", "Alice", "Finance", 2);

        societe.ajouterEmploye(emp1);
        societe.ajouterEmploye(emp2);
        societe.ajouterEmploye(emp3);
        societe.ajouterEmploye(emp4);

        System.out.println("=== All Employees ===");
        societe.displayEmploye();

        System.out.println("\n=== Search Results ===");
        System.out.println("Search for 'Doe': " + societe.rechercherEmploye("Doe"));
        System.out.println("Search for 'Wilson': " + societe.rechercherEmploye("Wilson"));
        System.out.println("Search for 'Unknown': " + societe.rechercherEmploye("Unknown"));

        System.out.println("Search for emp1 object: " + societe.rechercherEmploye(emp1));

        System.out.println("\n=== Sorted by ID ===");
        societe.trierEmployeParId();
        societe.displayEmploye();

        System.out.println("\n=== Sorted by Department and Grade ===");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();

        System.out.println("\n=== After removing emp2 ===");
        societe.supprimerEmploye(emp2);
        societe.displayEmploye();

        System.out.println("\nTotal employees: " + societe.getSize());
    }

}