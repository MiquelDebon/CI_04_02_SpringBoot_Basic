package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collation = "Fruita")
public class Fruita {
    @Id
    private int id;
    private String name;
    private int quantityKg;

}
