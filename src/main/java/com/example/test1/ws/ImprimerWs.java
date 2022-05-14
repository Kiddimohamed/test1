package com.example.test1.ws;

import com.example.test1.bean.Test;
import com.example.test1.service.Imprimer;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping ("/v1/test")
public class ImprimerWs {
    @PostMapping("/")
    public int save(@RequestBody Test test) {
        return imprimer.save(test);
    }

    @GetMapping("/")
    public List<Test> findAll() {
        return imprimer.findAll();
    }

    @GetMapping("/imprimer/")
    public String imprimer(String objet) throws FileNotFoundException, JRException {
        return imprimer.imprimer(objet);
    }

    @Autowired
    Imprimer imprimer;
}
