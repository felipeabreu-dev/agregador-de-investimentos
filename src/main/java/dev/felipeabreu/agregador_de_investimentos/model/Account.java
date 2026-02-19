package dev.felipeabreu.agregador_de_investimentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accountId;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    private BillingAddress address;

    @OneToMany(mappedBy = "account")
    private List<AccountStock> accountStocks;
}
