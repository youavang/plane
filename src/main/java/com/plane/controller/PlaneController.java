package com.plane.controller;

import com.plane.entity.Plane;
import com.plane.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plane")
public class PlaneController {
    @Autowired
    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    //Get list of all planes REST API.
    @GetMapping
    public ResponseEntity<List<Plane>> getAllPlanes(){
        return ResponseEntity.ok(planeService.getAllPlanes());
    }

    /*
    //Get plane by id REST API.
    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable int id) {
        planeService.getPlaneById(id);
        return ResponseEntity.ok(planeService.getPlaneById(id));
    }
    */


    //Get data of plane by string size REST API.
    @GetMapping("/{size}")
    public ResponseEntity<Plane> getPlaneBySize (@PathVariable String size) {
        return ResponseEntity.ok(planeService.getPlaneBySize(size));
    }

    //Add new plane to database REST API.
    @PostMapping
    public ResponseEntity addPlane(@RequestBody Plane plane) {
        planeService.addPlane(plane);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Update plane REST API
    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
        return ResponseEntity.ok().build();
    }

    //Delete plane REST API.
    @DeleteMapping("/{id}")
    public ResponseEntity deletePlane(@PathVariable int id) {
        planeService.deletePlane(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
