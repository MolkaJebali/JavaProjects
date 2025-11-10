package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String city;
    private final int nbrCages;
    private int animalCount;

    public int getAquaticCount() {
        return aquaticCount;
    }

    public void setAquaticCount(int aquaticCount) {
        this.aquaticCount = aquaticCount;
    }

    private int aquaticCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.nbrCages = Math.min(nbrCages, 25);
        this.animals = new Animal[this.nbrCages];
        this.aquaticAnimals = new Aquatic[10];
        this.animalCount = 0;
        this.aquaticCount = 0;
    }


    public void addAnimal(Animal animal) throws ZooFullException {
        if (isZooFull()) {
            throw new ZooFullException("Le zoo est plein ! Impossible d'ajouter " + animal.getName());
        }

        if (animalExists(animal)) {
            System.out.println("L'animal " + animal.getName() + " existe déjà dans le zoo !");
            return;
        }

        animals[animalCount] = animal;
        animalCount++;
        System.out.println("Animal " + animal.getName() + " ajouté avec succès !");
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
            System.out.println("Animal non trouvé !");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }

        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("Animal " + animal.getName() + " supprimé avec succès !");
        return true;
    }

    public void displayZoo() {
        System.out.println("Zoo: " + name + ", City: " + city + ", Number of cages: " + nbrCages);
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + nbrCages + "}";
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

    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquaticCount < 10) {
            aquaticAnimals[aquaticCount] = aquatic;
            aquaticCount++;
        } else {
            System.out.println("Le tableau d'animaux aquatiques est plein !");
        }
    }

    public void displaySwim() {
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = -1;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Nombre de dauphins: " + dolphinCount);
        System.out.println("Nombre de pingouins: " + penguinCount);
    }

    public int getAnimalCount() {
        return animalCount;
    }
}