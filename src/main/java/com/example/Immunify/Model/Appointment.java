package com.example.Immunify.Model;

import com.example.Immunify.Enum.DoseNo;
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
@Table(name = "appointment")
public class Appointment {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "appointment_no")
    String appointmentNo;

    @Column(name = "date_of_appointment")
    @CreationTimestamp
    Date dateOfAppointment;
    @Column(name = "dose_no")
    @Enumerated(EnumType.STRING)
    DoseNo doseNo;

    @Column(name = "vaccine_type")
    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Doctor doctor;
}
