package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.entity;

import jakarta.persistence.*;


@Entity //Data Model
public class Fruita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (length = 50, nullable = false)
    private String name;
    @Column (name = "quantityKg")
    private int quantityKg;


    public Fruita() {
    }
    public Fruita(int id, String name, int quantityKg) {
        this.id = id;
        this.name = name;
        this.quantityKg = quantityKg;
    }



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
    public int getQuantityKg() {
        return quantityKg;
    }
    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }


}
