package models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private tavolo tavolo;
}
