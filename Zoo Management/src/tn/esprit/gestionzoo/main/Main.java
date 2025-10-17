package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class Main {
    public static void main(String[] args) {

        Aquatic aquatic = new Aquatic();
        Terrestrial terrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();


        Aquatic aquatic2 = new Aquatic("Poisson", "Nemo", 2, true, "Océan");
        Terrestrial terrestrial2 = new Terrestrial("Félin", "Lion", 5, true, 4);
        Dolphin dolphin2 = new Dolphin("Delphinidés", "Flipper", 10, true, "Océan", 56.8f);
        Penguin penguin2 = new Penguin("Sphéniscidés", "Tux", 3, true, "Antarctique", 150.5f);


        System.out.println("=== Affichage des animaux ===");
        System.out.println(aquatic2);
        System.out.println(terrestrial2);
        System.out.println(dolphin2);
        System.out.println(penguin2);


        System.out.println("\n=== Comportement de nage ===");
        aquatic2.swim();
        dolphin2.swim();
    }
}