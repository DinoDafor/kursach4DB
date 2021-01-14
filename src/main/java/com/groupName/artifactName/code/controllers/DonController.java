package com.groupName.artifactName.code.controllers;

import com.groupName.artifactName.code.models.Don;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.groupName.artifactName.code.service.DonServices;

import java.util.List;

@RestController
@RequestMapping("/dons")
public class DonController {

    private final DonServices donServices;

    @Autowired
    public DonController(DonServices donServices) {
        this.donServices = donServices;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Don don) {
        donServices.create(don);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Don>> read() {
        final List<Don> dons = donServices.readAll();

        return dons != null &&  !dons.isEmpty()
                ? new ResponseEntity<>(dons, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/dons/{id}")
    public ResponseEntity<Don> read(@PathVariable(name = "id") int id) {
        final Don don = donServices.read(id);

        return don != null
                ? new ResponseEntity<>(don, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/dons/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Don don) {
        final boolean updated = donServices.update(don, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/dons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = donServices.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
