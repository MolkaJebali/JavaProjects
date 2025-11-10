package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Mon Zoo", "Ma Ville", 3);

        try {
            Aquatic aquatic2 = new Aquatic("Poisson", "Nemo", 2, true, "Océan") {
                @Override
                public void swim() {

                }
            };
            Terrestrial terrestrial2 = new Terrestrial("Félin", "Lion", 5, true, 4);
            Dolphin dolphin2 = new Dolphin("Delphinidés", "Flipper", 10, true, "Océan", 56.8f);
            Penguin penguin2 = new Penguin("Sphéniscidés", "Tux", 3, true, "Antarctique", 150.5f);

            try {
                Aquatic invalidAgeAnimal = new Aquatic("Poisson", "Méchant", -5, true, "Océan") {
                    @Override
                    public void swim() {

                    }
                };
            } catch (InvalidAgeException e) {
                System.out.println("Exception attrapée: " + e.getMessage());
            }

            System.out.println("=== Ajout des animaux au zoo ===");

            zoo.addAnimal(aquatic2);
            System.out.println("Nombre d'animaux: " + zoo.getAnimalCount());

            zoo.addAnimal(terrestrial2);
            System.out.println("Nombre d'animaux: " + zoo.getAnimalCount());

            zoo.addAnimal(dolphin2);
            System.out.println("Nombre d'animaux: " + zoo.getAnimalCount());

            zoo.addAnimal(penguin2);
            System.out.println("Nombre d'animaux: " + zoo.getAnimalCount());

        } catch (ZooFullException e) {
            System.out.println("Exception ZooFullException: " + e.getMessage());
            System.out.println("Nombre d'animaux actuels: " + zoo.getAnimalCount());
        } catch (InvalidAgeException e) {
            System.out.println("Exception InvalidAgeException: " + e.getMessage());
        }


        try {
            Dolphin dolphin1 = new Dolphin("Delphinidés", "Flipper", 10, true, "Océan", 56.8f);
            Penguin penguin1 = new Penguin("Sphéniscidés", "Tux", 3, true, "Antarctique", 150.5f);

            zoo.addAquaticAnimal(dolphin1);
            zoo.addAquaticAnimal(penguin1);

            System.out.println("\n=== Comportement de nage ===");
            zoo.displaySwim();

            System.out.println("\n=== Profondeur maximale des pingouins ===");
            System.out.println("Profondeur max: " + zoo.maxPenguinSwimmingDepth() + " m");

            System.out.println("\n=== Nombre d'animaux aquatiques par type ===");
            zoo.displayNumberOfAquaticsByType();

        } catch (InvalidAgeException e) {
            System.out.println("Exception InvalidAgeException: " + e.getMessage());
        }

         try {
        System.out.println("\n=== Test des nouvelles interfaces ===");

        Aquatic dolphin = new Dolphin("Delphinidés", "Flipper", 10, true, "Océan", 56.8f);
        Penguin penguin = new Penguin("Sphéniscidés", "Tux", 3, true, "Antarctique", 150.5f);
        Terrestrial terrestrial = new Terrestrial("Canidés", "Wolf", 4, true, 4);


        System.out.println("\n-- Test Aquatic (Carnivore) --");
        dolphin.eatMeat(Food.MEAT);
        dolphin.eatMeat(Food.PLANT);


        System.out.println("\n-- Test Penguin (Carnivore) --");
        penguin.eatMeat(Food.MEAT);
        penguin.eatMeat(Food.BOTH);


        System.out.println("\n-- Test Terrestrial (Omnivore) --");
        terrestrial.eatMeat(Food.MEAT);
        terrestrial.eatPlant(Food.PLANT);
        terrestrial.eatPlantAndMeat(Food.BOTH);
        terrestrial.eatPlantAndMeat(Food.MEAT);

    } catch (InvalidAgeException e) {
        System.out.println("Exception InvalidAgeException: " + e.getMessage());
    }
}
}