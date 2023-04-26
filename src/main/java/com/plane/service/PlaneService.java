package com.plane.service;

import com.plane.entity.Plane;

import java.util.List;

public interface PlaneService {
    List<Plane> getAllPlanes();
    //Plane getPlaneById(int id);
    Plane getPlaneBySize(String size);
    void addPlane(Plane plane);
    void updatePlane(Plane plane);
    void deletePlane(int id);
}
