package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.services;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.entity.Fruita;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaServiceImpl implements FruitaService {

    //FACADE PATTERN
    //Interface que va a decir que methodos usar al controller!!

    @Autowired
    private FruitaRepository fruitaRepository;

    @Override
    public List<Fruita> findAll() {
        return fruitaRepository.findAll();
    }

    @Override
    public Optional<Fruita> findById(int id) {
        return fruitaRepository.findById(id);
    }

    @Override
    public Fruita save(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    @Override
    public void deleteById(int id) {
        fruitaRepository.deleteById(id);
    }

    @Override
    public List<Fruita> findByQuantityKgLessThan(int quantityKg) {
        return fruitaRepository.findByQuantityKgLessThan(quantityKg);
    }

    @Override
    public List<Fruita> findByNameContainingIgnoreCase(String name) {
        return fruitaRepository.findByNameContainingIgnoreCase(name);
    }
}
