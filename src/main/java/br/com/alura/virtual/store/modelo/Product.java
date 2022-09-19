package br.com.alura.virtual.store.modelo;

public class Product {
    private int id;
    private String name;
    private String description;

    private int category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Product(String name, String desciption, int category) {
        this.name = name;
        this.description = desciption;
        this.category = category;
    }

    public Product(int id, String name, String description, int category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("O produto cadastrado é: %d, %s, %s, %d", this.id, this.name, this.description, this.category);
    }
}
