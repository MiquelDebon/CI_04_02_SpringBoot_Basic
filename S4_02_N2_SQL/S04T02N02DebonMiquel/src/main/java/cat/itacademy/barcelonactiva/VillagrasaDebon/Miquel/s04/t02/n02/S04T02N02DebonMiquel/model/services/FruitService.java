package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.services;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.entity.Fruita;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.repository.FruitaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitService{
    Fruita save (Fruita fruita);
    Optional<Fruita> findById(int id);
    List<Fruita> findAll();
    void deleteById(int id);
    List<Fruita> saveAll (Iterable<Fruita> iterableFruits);

    List<Fruita> findByQuantityKgLessThan(int quantityKg);
    List<Fruita> findByNameContainingIgnoreCase(String name);

}
