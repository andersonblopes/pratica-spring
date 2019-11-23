package com.lopes.foto.controller;


import com.lopes.foto.service.DiscoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class FotoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FotoController.class);

    @Autowired
    private DiscoService discoService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("foto") MultipartFile foto, RedirectAttributes redirectAttributes) {
        //TODO Proteger o sistema contra envio de arquivos não suportados
        //TODO Tratar erro de tentativa de upload de arquivo com tamanho superior ao definido nas configurações
        //TODO Recriar WS para upload de arquivos.
        LOGGER.info("Upload de foto ---> " + foto.getOriginalFilename());
        discoService.salvarFoto(foto);
        String mensagem = String.format("Upload de foto ---> %s.", foto.getOriginalFilename());

        redirectAttributes.addFlashAttribute("message",
                "Upload do arquivo: " + foto.getOriginalFilename() + "realizado com sucesso!");

        return "redirect:/";
    }

    @PostMapping("/uploadArquivos")
    public String uploadArquivos(@RequestParam("fotos") MultipartFile[] fotos, RedirectAttributes redirectAttributes) {
        //TODO Proteger o sistema contra envio de arquivos não suportados
        //TODO Tratar erro de tentativa de upload de arquivo com tamanho superior ao definido nas configurações
        //TODO Recriar WS para upload de arquivos.
        Arrays.asList(fotos)
                .stream()
                .forEach(foto -> discoService.salvarFoto(foto));

        redirectAttributes.addFlashAttribute("message",
                "Fotos enviadas com sucesso!");

        return "redirect:/";
    }


}
