package controllers;

import dao.ordineDao;
import dao.tavoloDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tavolo")
@RequiredArgsConstructor
public class TavoloController
{
	@Autowired
	private tavoloDao tavoloDao;
	@Autowired
	private ordineDao ordineDao;



}
