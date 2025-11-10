package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    private float swimmingSpeed;

    public Dolphin() throws InvalidAgeException {
        super();
        this.swimmingSpeed = 0.0f;
    }

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingSpeed=" + swimmingSpeed;
    }

    public void swim() {
        System.out.println("This dolphin is swimming.");
    }
}