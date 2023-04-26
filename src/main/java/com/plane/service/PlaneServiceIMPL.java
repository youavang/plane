package com.plane.service;

import com.plane.entity.Plane;
import com.plane.dao.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceIMPL implements PlaneService{
    private final PlaneRepository planeRepository;

    public PlaneServiceIMPL(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    /*
    @Override
    public Optional<Plane> getPlaneById(int id) {
        return planeRepository.findById(id);
                //.orElseThrow(()-> new RuntimeException(String.format("Cannot find plane with ID %s.", id)));
    }
     */

    @Override
    public Plane getPlaneBySize(String size) {
        return planeRepository.findBySize(size)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find plane by size %s.", size)));
    }

    @Override
    public void addPlane(Plane plane) {
        planeRepository.insert(plane);
    }


    @Override
    public void updatePlane(Plane plane) {
        Plane updatePlane = planeRepository.findById(plane.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find plane by ID %s.", plane.getId())));
        updatePlane.setSize(plane.getSize());
        updatePlane.setSeats(plane.getSeats());
        planeRepository.save(updatePlane);
    }


    @Override
    public void deletePlane(int id) {
        Plane plane = planeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find plane with ID %s.", id)));
        planeRepository.delete(plane);
    }
}
