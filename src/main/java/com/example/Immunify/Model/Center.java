package com.example.Immunify.Model;

import com.example.Immunify.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "center")
public class Center {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "location")
    String location;
    @Column(name = "center_type")
    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
    List<Doctor> doctors = new ArrayList<>();
}
