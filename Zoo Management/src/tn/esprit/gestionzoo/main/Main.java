package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {
        Animal animalInvalide = new Animal("", "", -5, true);

        Zoo zooInvalide = new Zoo("", "Ville", 10);

        Zoo zoo1 = new Zoo("Zoo de Tunis", "Tunis", 10);
        Zoo zoo2 = new Zoo("Zoo de Sousse", "Sousse", 15);

        zoo1.addAnimal(new Animal("Panthera", "Simba", 5, true));
        zoo1.addAnimal(new Animal("Elephantidae", "Dumbo", 10, true));

        zoo2.addAnimal(new Animal("Panthera", "Rajah", 4, true));
        zoo2.addAnimal(new Animal("Giraffidae", "Spots", 7, true));
        zoo2.addAnimal(new Animal("Ursidae", "Baloo", 8, true));

        Zoo plusGrandZoo = Zoo.comparerZoo(zoo1, zoo2);

        if (plusGrandZoo != null) {
            System.out.println("Le zoo avec le plus d'animaux est: " + plusGrandZoo.getName());
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux");
        }

        System.out.println("Zoo1 est plein: " + zoo1.isZooFull());
        zoo1.displayZoo();
        zoo2.displayZoo();
    }
}