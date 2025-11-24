package tn.esprit.employees.implementations;

import tn.esprit.employees.entities.Employe;
import tn.esprit.employees.entities.Departement;
import java.util.*;

public class AffectationHashMap {
    // Instruction 1: Collection dynamique pour les affectations
    private HashMap<Employe, Departement> affectations;

    public AffectationHashMap() {
        this.affectations = new HashMap<>();
    }

    // Ajouter une affectation
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d);
    }

    // Afficher toutes les affectations
    public void afficherEmployesEtDepartements() {
        System.out.println("=== Liste des affectations Employé -> Département ===");
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println("Employé: " + entry.getKey().getNom() + " " + entry.getKey().getPrenom() +
                    " -> Département: " + entry.getValue().getNomDepartement());
        }
    }

    // Supprimer un employé
    public void supprimerEmploye(Employe e) {
        if (affectations.remove(e) != null) {
            System.out.println("Employé " + e.getNom() + " supprimé avec succès.");
        } else {
            System.out.println("Employé non trouvé.");
        }
    }

    // Supprimer un employé d'un département spécifique
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
            System.out.println("Employé " + e.getNom() + " supprimé du département " + d.getNomDepartement());
        } else {
            System.out.println("Affectation non trouvée.");
        }
    }

    // Afficher tous les employés
    public void afficherEmployes() {
        System.out.println("=== Liste des employés ===");
        for (Employe e : affectations.keySet()) {
            System.out.println("ID: " + e.getId() + ", Nom: " + e.getNom() + ", Prénom: " + e.getPrenom());
        }
    }

    // Afficher tous les départements
    public void afficherDepartements() {
        System.out.println("=== Liste des départements ===");
        Set<Departement> departementsUniques = new HashSet<>(affectations.values());
        for (Departement d : departementsUniques) {
            System.out.println("ID: " + d.getId() + ", Nom: " + d.getNomDepartement());
        }
    }

    // Rechercher un employé
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    // Rechercher un département
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    // Trier par ID employé
    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> sortedMap = new TreeMap<>(
                Comparator.comparingInt(Employe::getId)
        );
        sortedMap.putAll(affectations);
        return sortedMap;
    }

    // Afficher une TreeMap
    public void afficherMapTrie() {
        TreeMap<Employe, Departement> sorted = trierMap();
        System.out.println("=== Affectations triées par ID employé ===");
        for (Map.Entry<Employe, Departement> entry : sorted.entrySet()) {
            System.out.println("ID: " + entry.getKey().getId() +
                    ", Employé: " + entry.getKey().getNom() +
                    " -> Département: " + entry.getValue().getNomDepartement());
        }
    }
}