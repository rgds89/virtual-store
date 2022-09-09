package br.com.alura.virtual.store.modelo;

public class Category {
    private int id;
    private String name;

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

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("A categoria cadastrado é: %d, %s", this.id,this.name);
    }
}
