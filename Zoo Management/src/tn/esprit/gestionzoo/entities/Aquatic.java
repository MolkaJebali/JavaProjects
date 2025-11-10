package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal implements Carnivore<Food> {
    private String habitat;

    public Aquatic() throws InvalidAgeException {
        super("AquaticFamily", "AquaticAnimal", 1, true);
        this.habitat = "Water";
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aquatic aquatic = (Aquatic) obj;
        return getName().equals(aquatic.getName()) &&
                getAge() == aquatic.getAge() &&
                habitat.equals(aquatic.habitat);
    }
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println("This aquatic animal is eating meat.");
        } else {
            System.out.println("This aquatic animal cannot eat this food.");
        }
    }
}