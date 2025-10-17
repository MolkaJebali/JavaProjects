package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int animalCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.nbrCages = Math.min(nbrCages, 25);
        this.animals = new Animal[this.nbrCages];
        this.animalCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur: Le nom du zoo ne peut pas être vide");
            this.name = "tn.esprit.gestionzoo.entities.Zoo Sans Nom";
        }
    }
    private boolean animalExists(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName()) &&
                    animals[i].getFamily().equals(animal.getFamily())) {
                return true;
            }
        }
        return false;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein ! Impossible d'ajouter " + animal.getName());
            return false;
        }

        if (animalExists(animal)) {
            System.out.println("L'animal " + animal.getName() + " existe déjà dans le zoo !");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        System.out.println("tn.esprit.gestionzoo.entities.Animal " + animal.getName() + " ajouté avec succès !");
        return true;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("tn.esprit.gestionzoo.entities.Animal non trouvé !");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }

        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("tn.esprit.gestionzoo.entities.Animal " + animal.getName() + " supprimé avec succès !");
        return true;
    }

    public void displayZoo() {
        System.out.println("tn.esprit.gestionzoo.entities.Zoo: " + name + ", City: " + city + ", Number of cages: " + nbrCages);
    }

    @Override
    public String toString() {
        return "tn.esprit.gestionzoo.entities.Zoo{name='" + name + "', city='" + city + "', nbrCages=" + nbrCages + "}";
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) {
            return z1;
        } else if (z2.animalCount > z1.animalCount) {
            return z2;
        } else {
            return null;
        }
    }
}