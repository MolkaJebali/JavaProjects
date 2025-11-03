package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) throws InvalidAgeException {
        setFamily(family);
        setName(name);
        setAge(age);
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public void setFamily(String family) {
        if (family != null && !family.trim().isEmpty()) {
            this.family = family;
        } else {
            System.out.println("Erreur: La famille ne peut pas être vide");
        }
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur: Le nom ne peut pas être vide");
        }
    }

    public int getAge() { return age; }
    public void setAge(int age) throws InvalidAgeException {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new InvalidAgeException("Erreur: L'âge ne peut pas être négatif - âge reçu: " + age);
        }
    }

    public boolean isMammal() { return isMammal; }
    public void setMammal(boolean isMammal) { this.isMammal = isMammal; }

    public void displayAnimal() {
        System.out.println("Animal: " + name + ", Family: " + family + ", Age: " + age + ", Mammal: " + isMammal);
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', family='" + family + "', age=" + age + ", isMammal=" + isMammal + "}";
    }
}