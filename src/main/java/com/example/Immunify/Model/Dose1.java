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
@Table(name = "dose1")
public class Dose1 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "dose_id") //UUID
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

