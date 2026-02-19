package dev.felipeabreu.agregador_de_investimentos.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AccountStockId {

    private UUID accountId;

    private String stockId;
}
