package com.gas.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name="meter_reading")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MeterReading {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "meter_reading")
    private Double meterReading;

    @Column(name = "date", insertable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_gas_account_id", referencedColumnName = "id")
    @JsonBackReference
    private PersonalGasAccount personalGasAccount;

    public MeterReading(Double meterReading) {
        this.meterReading = meterReading;
    }
}