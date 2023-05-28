package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.services;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.entity.Fruita;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitServiceImpl implements FruitService{
    @Autowired
    private FruitaRepository fruitaRepository;


    @Override
    public Fruita save(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }
    @Override
    public Optional<Fruita> findById(int id) {
        return fruitaRepository.findById(id);
    }
    @Override
    public List<Fruita> findAll() {
        return fruitaRepository.findAll();
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
    @Override
    public List<Fruita> saveAll(Iterable<Fruita> iterableFruits) {
        return fruitaRepository.saveAll(iterableFruits);
    }


}
