package cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.repository;

import java.util.List;
import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.domainEntity.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
    List<Fruita> findByQuantityKgLessThan(int quantityKg);
    List<Fruita> findByNameContainingIgnoreCase(String name);

    //MOLT IMPORTANT EL NOM DEl METODE!!! PENDENT a estudiar!
    //https://www.bezkoder.com/jpa-repository-query/
}
