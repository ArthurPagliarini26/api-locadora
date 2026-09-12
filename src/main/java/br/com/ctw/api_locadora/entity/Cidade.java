package br.com.ctw.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="cidade")

@Entity

/**
 * Representa uma cidade cadastrada no sistema
 * @author Gustavo Richardt
 */

public class Cidade {

    /**
     * Identificador único da cidade
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidade_id;

    /**
     * Nome da cidade
     */
    @Column(name = "cidade")
    private String cidade;

    /**
     * Última data da atualização, sendo put ou patch
     */
    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultima_atualizacao;

    /**
     * Relação muitos pra um com a classe país
     */
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

}
