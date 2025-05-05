package dao;

import models.prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface prodottoDao extends JpaRepository<Long, prodotto>
{
}
