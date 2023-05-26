package cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.services;

import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.Entity.Fruita;
import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.repository.FruitaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitaService{

    List<Fruita> findAll();
    Optional<Fruita> findById(int id);
    Fruita save(Fruita fruita);
    void deleteById(int id);

}
