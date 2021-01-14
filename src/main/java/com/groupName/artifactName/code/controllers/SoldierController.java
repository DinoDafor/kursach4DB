package com.groupName.artifactName.code.controllers;

import com.groupName.artifactName.code.models.Don;
import com.groupName.artifactName.code.models.Soldier;
import com.groupName.artifactName.code.service.DonServices;
import com.groupName.artifactName.code.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
public class SoldierController {

    private final SoldierService soldierService;

    @Autowired
    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Soldier soldier) {
        soldierService.create(soldier);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Soldier>> read() {
        final List<Soldier> soldiers = soldierService.readAll();

        return soldiers != null &&  !soldiers.isEmpty()
                ? new ResponseEntity<>(soldiers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/dons/{id}")
    public ResponseEntity<Soldier> read(@PathVariable(name = "id") int id) {
        final Soldier soldier = soldierService.read(id);

        return soldier != null
                ? new ResponseEntity<>(soldier, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/dons/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Soldier soldier) {
        final boolean updated = soldierService.update(soldier, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/dons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = soldierService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
