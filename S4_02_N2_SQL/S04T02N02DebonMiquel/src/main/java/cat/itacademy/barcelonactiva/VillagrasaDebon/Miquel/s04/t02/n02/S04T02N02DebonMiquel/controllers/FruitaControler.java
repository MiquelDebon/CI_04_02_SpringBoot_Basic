package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.controllers;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.entity.Fruita;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fruita")
public class FruitaControler {
    @Autowired
    private FruitaRepository fruitaRepository;

    @PostMapping("/add")
    public ResponseEntity<Fruita> add (@RequestParam String name, @RequestParam int quantityKg){
        try{
            Fruita newfruita = new Fruita(name, quantityKg);
            fruitaRepository.save(newfruita);
            return new ResponseEntity<>(newfruita, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
