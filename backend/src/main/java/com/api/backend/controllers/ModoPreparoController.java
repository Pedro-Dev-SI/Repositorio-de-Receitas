package com.api.backend.controllers;

import java.util.Optional;
import java.util.UUID;

import com.api.backend.model.ModoPreparoModel;
import com.api.backend.services.ModoPreparoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/receitas/modo-preparo")
public class ModoPreparoController {
   
   //Ponto de injeção entre o ModoPreparoService e o ModoPreparoController
   final ModoPreparoService modoPreparoService;

   public ModoPreparoController(ModoPreparoService modoPreparoService) {
      this.modoPreparoService = modoPreparoService;
   }

   //MÉTODO POST
   @PostMapping
   public ResponseEntity<Object> saveModoPreparo(@RequestBody ModoPreparoModel modoPreparoModel){
      
      return ResponseEntity.status(HttpStatus.CREATED).body(modoPreparoService.save(modoPreparoModel));
   }

   //MÉTODO DELETE
   @DeleteMapping("/{mpid}")
   public ResponseEntity<Object> deleteModoPreparo(@PathVariable(value = "mpid") UUID mpid){
      Optional<ModoPreparoModel> modoPreparoModelOptional = modoPreparoService.findById(mpid);
      
      if(!modoPreparoModelOptional.isPresent()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modo de preparo não encontrado");
      }
      
      modoPreparoService.delete(modoPreparoModelOptional.get());
      return ResponseEntity.status(HttpStatus.OK).body("Modo de preparo deletado com sucesso");
   }

}
