package com.lopes.foto.controller;


import com.lopes.foto.modelo.Disco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FotoController.class);

    @Autowired
    private Disco disco;

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam MultipartFile foto) {
        LOGGER.info("Upload de foto ---> " + foto.getOriginalFilename());
        disco.salvarFoto(foto);
        String mensagem = String.format("Upload de foto ---> %s.", foto.getOriginalFilename());
        return ResponseEntity.ok().body(mensagem);
    }


}
