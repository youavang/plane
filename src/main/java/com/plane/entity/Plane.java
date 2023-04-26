package com.plane.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("plane")
public class Plane {
    @Id
    private int id;

    @Field("size")
    @Indexed(unique = true)
    private String size;
    @Field("seats")
    private ArrayList<String> seats;
}
