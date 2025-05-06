package controllers;

import dto.OrdineDTO;
import dto.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController
{
	@Autowired
	private OrdineService ordineService;

	@GetMapping
	public List<OrdineDTO> getAll()
	{
		return ordineService.getAll();
	}
}
