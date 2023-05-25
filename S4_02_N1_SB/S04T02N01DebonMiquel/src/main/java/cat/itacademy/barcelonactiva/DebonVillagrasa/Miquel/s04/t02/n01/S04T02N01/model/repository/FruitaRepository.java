package cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.repository;

import java.util.List;
import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
    List<Fruita> findByName(String name);
    List<Fruita> findByQuantityKg (int quantityKg);

    //MOLT IMPORTANT EL NOM DEl METODE!!!

}
