package models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class sedia extends tavolo {

	private boolean occupata;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tavolo")
	private tavolo tavolo;
}
