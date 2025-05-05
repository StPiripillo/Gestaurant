package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ordine extends baseEntity {
    private LocalTime ora;
    @ManyToOne
    @JoinColumn(name = "id_tavolo")
    private tavolo tavolo;
    @OneToMany(mappedBy = "ordine", fetch = FetchType.EAGER)
    private List<prodotto> prodotti = new ArrayList<>();

    public double getTotale() {
        return prodotti.stream().mapToDouble(i -> i.getQtn() * i.getPrezzo()).sum();

    }
}
