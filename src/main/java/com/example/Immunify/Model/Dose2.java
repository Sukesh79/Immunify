package com.example.Immunify.Model;

import com.example.Immunify.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "dose2")
public class Dose2 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "dose_id")
    String doseId;
    @Column(name = "vaccine_type")
    VaccineType vaccineType;
    @Column(name = "vaccination_date")
    @CreationTimestamp
    Date vaccinationDate;

    @OneToOne
    @JoinColumn
    User user;
}
