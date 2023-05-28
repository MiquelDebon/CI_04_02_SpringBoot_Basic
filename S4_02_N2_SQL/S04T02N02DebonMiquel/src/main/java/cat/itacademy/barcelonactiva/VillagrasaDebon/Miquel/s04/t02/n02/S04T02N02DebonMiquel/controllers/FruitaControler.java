package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.controllers;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.entity.Fruita;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n02.S04T02N02DebonMiquel.model.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitaControler {
    @Autowired
    private FruitServiceImpl fruitServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<Fruita> add (@RequestParam String name, @RequestParam int quantityKg){
        try{
            Fruita newfruita = new Fruita(name, quantityKg);
            fruitServiceImpl.save(newfruita);
            return new ResponseEntity<>(newfruita, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAll(){
        try{
            List<Fruita> fruits = new ArrayList<>();
            if(fruits != null)
                fruits.addAll(fruitServiceImpl.findAll());

            if(fruits.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOneById(@PathVariable int id){
        Optional<Fruita> fruia = fruitServiceImpl.findById(id);
        if(fruia.isPresent()){
            return new ResponseEntity<>(fruia.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruit(@PathVariable int id, @RequestBody Fruita fruita){
        Optional<Fruita> fruitaToUpdate = fruitServiceImpl.findById(id);

        if(fruitaToUpdate.isPresent()){
            Fruita newfruita = fruitaToUpdate.get();
            newfruita.setId(id);
            newfruita.setName(fruita.getName());
            newfruita.setQuantityKg(fruita.getQuantityKg());
            return new ResponseEntity<>(fruitServiceImpl.save(newfruita), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id){
        try{
            Optional<Fruita> fruita = fruitServiceImpl.findById(id);
            if(fruita.isPresent()){
                fruitServiceImpl.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addBase")
    public ResponseEntity<List<Fruita>> addBase (){
        try{
            List<Fruita> newFruitList = new ArrayList<>();
            newFruitList.add(new Fruita("Poma", 20));
            newFruitList.add(new Fruita("Pera", 30));
            newFruitList.add(new Fruita("Taronja", 124));

            Iterable<Fruita> iterableFruits = newFruitList;
            fruitServiceImpl.saveAll(iterableFruits);

            return new ResponseEntity<>(newFruitList, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
