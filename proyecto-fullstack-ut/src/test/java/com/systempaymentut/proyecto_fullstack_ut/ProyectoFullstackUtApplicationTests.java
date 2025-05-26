package com.systempaymentut.proyecto_fullstack_ut;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.systempaymentut.proyecto_fullstack_ut.entities.Estudiante;
import com.systempaymentut.proyecto_fullstack_ut.entities.Pago;
import com.systempaymentut.proyecto_fullstack_ut.enums.PagoStatus;
import com.systempaymentut.proyecto_fullstack_ut.enums.TypePago;
import com.systempaymentut.proyecto_fullstack_ut.repository.EstudianteRepository;
import com.systempaymentut.proyecto_fullstack_ut.repository.PagoRepository;

@Configuration
@SpringBootTest
public class ProyectoFullstackUtApplicationTests {

	@Test
	public static void contextLoads() {
	}

	@Bean
	CommandLineRunner commandLineRunner(EstudianteRepository estudianteRepository, PagoRepository pagoRepository){
		return args ->{
			estudianteRepository.save(Estudiante.builder()
			.id(UUID.randomUUID().toString())
			.nombre("melissa")
			.apellido("gordillo")
			.codigo("1234")
			.programaId("ISIS123")
			.build());

			estudianteRepository.save(Estudiante.builder()
            .id(UUID.randomUUID().toString())
            .nombre("Carlos")
            .apellido("Ramírez")
            .codigo("5678")
            .programaId("ISIS123")
            .build());

       		 estudianteRepository.save(Estudiante.builder()
            .id(UUID.randomUUID().toString())
            .nombre("Ana")
            .apellido("Martínez")
            .codigo("9012")
            .programaId("ISIS123")
            .build());

      		  estudianteRepository.save(Estudiante.builder()
            .id(UUID.randomUUID().toString())
            .nombre("Juan")
            .apellido("Pérez")
            .codigo("3456")
            .programaId("ISIS123")
            .build());

      		estudianteRepository.save(Estudiante.builder()
            .id(UUID.randomUUID().toString())
            .nombre("Laura")
            .apellido("Sánchez")
            .codigo("7890")
            .programaId("ISIS123")
            .build());

        	estudianteRepository.save(Estudiante.builder()
            .id(UUID.randomUUID().toString())
            .nombre("Diego")
            .apellido("González")
            .codigo("2345")
            .programaId("ISIS123")
            .build());
		

			TypePago tiposPago[] = TypePago.values();

			Random random = new Random();


			estudianteRepository.findAll().forEach(estudiante -> {

				for(int i = 0; i<10; i++){
					int index = random.nextInt(tiposPago.length);
					 

					Pago pago = Pago.builder()
						.cantidad(1000 + (int) (Math.random() * 20000))
						.type(tiposPago[index])
						.status(PagoStatus.CREADO)
						.fecha(LocalDate.now())
						.estudiante(estudiante)
						.build();
					
				    pagoRepository.save(pago);
					
				}

			});

		};




	}


}
					
						
						
				
			
			



	 	
	



	


