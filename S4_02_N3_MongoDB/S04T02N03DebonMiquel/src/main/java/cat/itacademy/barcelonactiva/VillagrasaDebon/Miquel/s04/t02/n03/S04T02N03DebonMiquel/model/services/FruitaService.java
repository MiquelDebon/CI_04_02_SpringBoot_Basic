package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.services;


import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.entity.Fruita;

import java.util.List;
import java.util.Optional;

public interface FruitaService{

    List<Fruita> findAll();
    Optional<Fruita> findById(int id);
    Fruita save(Fruita fruita);
    void deleteById(int id);

    /**
     *
     * EXTRAA
     *
     */

    List<Fruita> findByQuantityKgLessThan(int quantityKg);
    List<Fruita> findByNameContainingIgnoreCase(String name);


}
