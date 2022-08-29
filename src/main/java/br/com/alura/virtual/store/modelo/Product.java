package br.com.alura.virtual.store.modelo;

public class Product {
    private int id;
    private String name;
    private String description;

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

    public Product(String name, String desciption) {
        this.name = name;
        this.description = desciption;
    }

    @Override
    public String toString() {
        return String.format("O produto cadastrado foi: %d, %s, %s", this.id, this.name, this.description);
    }
}
