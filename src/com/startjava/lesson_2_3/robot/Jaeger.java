package com.startjava.lesson_2_3.robot;

public class Jaeger {

    private String name;
    private int speed;
    private float height;
    private int weight;
    private int armor;
    private int strength;

    public Jaeger() {}

    public Jaeger(String name, int speed, float height, int weight, int armor, int strength) {
        this.name = name;
        this.speed = speed;
        this.height = height;
        this.weight = weight;
        this.armor = armor;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    void move() {
        System.out.println("Moving");
    }

    void scanKaiju() {
        System.out.println("Scanning Kaiju");
    }

    void useVortexCannon() {
        System.out.println("Activated");
    }

    void speak() {
        System.out.println("Speak");
    }

    boolean shoot() {
        return true;
    }

    public String toString() {
        return String.format("Name: %s \nSpeed: %d \nHeight: %f \nWeight: %d \nArmor: %d \nStrength %d",
                name, speed, height, weight, armor, strength);
    }
}