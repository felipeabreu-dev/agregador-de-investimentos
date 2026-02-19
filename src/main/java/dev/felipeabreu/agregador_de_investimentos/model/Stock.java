package dev.felipeabreu.agregador_de_investimentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_stock")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Stock {

    @Id
    private String stockId;

    private String description;

}
