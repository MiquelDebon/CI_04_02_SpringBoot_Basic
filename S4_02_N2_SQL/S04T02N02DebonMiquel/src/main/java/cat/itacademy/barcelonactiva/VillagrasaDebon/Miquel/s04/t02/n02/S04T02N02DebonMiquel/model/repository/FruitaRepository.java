package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.repository;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.entity.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
    List<Fruita> findByQuantityKgLessThan(int quantityKg);
    List<Fruita> findByNameContainingIgnoreCase(String name);

    //MOLT IMPORTANT EL NOM DEl METODE!!! PENDENT a estudiar!
    //https://www.bezkoder.com/jpa-repository-query/
}
