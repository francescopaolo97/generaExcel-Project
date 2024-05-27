package com.generaExcel;

import com.generaExcel.repository.UtenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneraExcelApplicationTests {

	@Autowired
	private UtenteRepository utenteRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void startTest(){
		System.out.println("Test started...");
		utenteRepository.findAll().forEach(user->{
			System.out.println(user.getNome());
		});
	}

}
