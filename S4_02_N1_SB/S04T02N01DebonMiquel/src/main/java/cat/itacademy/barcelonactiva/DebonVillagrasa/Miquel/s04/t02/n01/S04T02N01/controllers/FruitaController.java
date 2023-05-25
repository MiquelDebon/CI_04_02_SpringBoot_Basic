package cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.controllers;

import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.Fruita;
import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {
    @Autowired
    FruitaRepository fruitaRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAll(){
        try{
            List<Fruita> fruits = new ArrayList<>();
            if(fruits != null)
                fruitaRepository.findAll().forEach(fruits::add);

            if(fruits.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOneById(@PathVariable("id")int id){
        Optional<Fruita> fruia = fruitaRepository.findById(id);
        if(fruia.isPresent()){
            return new ResponseEntity<>(fruia.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Rehacer -  No funciona!!!
    /*
    @GetMapping("/fruites/minimumquantity/quantity")
    public ResponseEntity<List<Fruita>> getFruitLoweMinimumQuantity(@PathVariable("quantity") int quantity){
        try{
            List<Fruita> fruits = new ArrayList<>(fruitaRepository.findAll());

            if(fruits.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                List<Fruita>minimumFruita = fruits.stream()
                        .filter(f -> f.getQuantityKg() < quantity)
                        .toList();
                return new ResponseEntity<>(minimumFruita, HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruit(@RequestBody Fruita fruita){
        try{
            Fruita _fruita = fruitaRepository
                    .save(new Fruita(fruita.getId(), fruita.getName(), fruita.getQuantityKg()));
            return  new ResponseEntity<>(_fruita, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruit(@PathVariable("id") int id, @RequestBody Fruita fruita){
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);

        if(fruitaData.isPresent()){
            Fruita newfruita = fruitaData.get();
            newfruita.setId(fruita.getId()); //da problemas esto creo!
            newfruita.setName(fruita.getName());
            newfruita.setQuantityKg(fruita.getQuantityKg());
            return new ResponseEntity<>(fruitaRepository.save(newfruita), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id){
        try{
            Optional<Fruita> fruita = fruitaRepository.findById(id);
            if(fruita.isPresent()){
                fruitaRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
