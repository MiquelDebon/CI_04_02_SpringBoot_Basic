package cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.controllers;

import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.Entity.Fruita;
import cat.itacademy.barcelonactiva.DebonVillagrasa.Miquel.s04.t02.n01.S04T02N01.model.services.FruitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {
    @Autowired
    private FruitaServiceImpl fruitaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAll(){
        try{
            List<Fruita> fruits = new ArrayList<>();
            if(fruits != null)
                fruitaService.findAll().forEach(fruits::add);

            if(fruits.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOneById(@PathVariable int id){
        Optional<Fruita> fruia = fruitaService.findById(id);
        if(fruia.isPresent()){
            return new ResponseEntity<>(fruia.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruit(@RequestBody Fruita fruita){
        try{
            Fruita _fruita = fruitaService
                    .save(new Fruita(fruita.getId(), fruita.getName(), fruita.getQuantityKg()));
            return  new ResponseEntity<>(_fruita, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruit(@PathVariable int id, @RequestBody Fruita fruita){
        Optional<Fruita> fruitaToUpdate = fruitaService.findById(id);

        if(fruitaToUpdate.isPresent()){
            Fruita newfruita = fruitaToUpdate.get();
            newfruita.setId(id);
            newfruita.setName(fruita.getName());
            newfruita.setQuantityKg(fruita.getQuantityKg());
            return new ResponseEntity<>(fruitaService.save(newfruita), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id){
        try{
            Optional<Fruita> fruita = fruitaService.findById(id);
            if(fruita.isPresent()){
                fruitaService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     *
     * EXTRAAA
     *
     */

    //Method using the JPA Repository Query
    @GetMapping("/minimumquantity/{quantity}")
    public ResponseEntity<List<Fruita>> findByQuantityKgLessThan(@PathVariable int quantity){
        try{
            List<Fruita> fruitWithQuantity = new ArrayList<>(fruitaService.findByQuantityKgLessThan(quantity));

            if(fruitWithQuantity.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(fruitWithQuantity, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Method achieving same result using Lambdas
    @GetMapping("/minimumquantityLambda/{quantity}")
    public ResponseEntity<List<Fruita>> findByQuantityKgLessThanWithLambda(@PathVariable int quantity){
        try{
            List<Fruita> allFruits = new ArrayList<>(fruitaService.findAll());

            if(allFruits.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                List<Fruita>minimumFruita = allFruits.stream()
                        .filter(f -> f.getQuantityKg() < quantity)
                        .toList();
                return new ResponseEntity<>(minimumFruita, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("nameContaining/{name}")
    public ResponseEntity<List<Fruita>> findListFruitsContainingName(@PathVariable String name){
        try{
            List<Fruita> fruitsWithName = new ArrayList<>(fruitaService.findByNameContainingIgnoreCase(name));
            if(fruitsWithName.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(fruitsWithName, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
