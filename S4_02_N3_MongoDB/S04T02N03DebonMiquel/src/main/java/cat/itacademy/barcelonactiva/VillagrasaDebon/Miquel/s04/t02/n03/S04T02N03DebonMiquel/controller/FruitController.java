package cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.controller;

import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.entity.Fruita;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.VillagrasaDebon.Miquel.s04.t02.n03.S04T02N03DebonMiquel.model.services.FruitaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitController {
    @Autowired
    private FruitaServiceImpl fruitaService;
    private static Logger LOG = LoggerFactory.getLogger(FruitController.class);

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruits(@RequestBody Fruita fruita) {
        try{
            fruitaService.save(fruita);
            System.out.println("Product added");
            LOG.info("Using method createFruit");
            return new ResponseEntity<>(fruita, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruita(@PathVariable int id){
        try{
            Optional<Fruita> fruita = fruitaService.findById(id);
            if(fruita.isPresent()){
                return new ResponseEntity<>(fruita.get(), HttpStatus.OK);
            }else{
                return  ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .eTag("error")
                        .body(null);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAll(){

        try{
            if(!fruitaService.findAll().isEmpty()){
                return new ResponseEntity<>(fruitaService.findAll(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOne(@PathVariable int id){
        try{
            if(fruitaService.findById(id).isPresent()){
                fruitaService.deleteById(id);
                return new ResponseEntity<>( HttpStatus.OK);
            }else{
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Fruita> updateOne(@RequestBody Fruita fruita){
        try{
            if(fruitaService.findById(fruita.getId()).isPresent()){
                Fruita newFruita = new Fruita();
                newFruita.setId(fruita.getId());
                newFruita.setName(fruita.getName());
                newFruita.setQuantityKg(fruita.getQuantityKg());
                fruitaService.save(newFruita);
                return new ResponseEntity<>(newFruita, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * EXTRAA
     *
     */

    @GetMapping("/minimumquantity/{quantity}")
    public ResponseEntity<List<Fruita>> getFruitByQuantityKgLessThan(@PathVariable int quantity){
        try{
            List<Fruita> listFruits = fruitaService.findByQuantityKgLessThan(quantity);
            if(!listFruits.isEmpty()){
                return new ResponseEntity<>(listFruits, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nameContaining/{name}")
    public ResponseEntity<List<Fruita>> getFruitByName(@PathVariable String name){
        try{
            List<Fruita> listFruits = fruitaService.findByNameContainingIgnoreCase(name);
            if(!listFruits.isEmpty()){
                return new ResponseEntity<>(listFruits, HttpStatusCode.valueOf(200));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
