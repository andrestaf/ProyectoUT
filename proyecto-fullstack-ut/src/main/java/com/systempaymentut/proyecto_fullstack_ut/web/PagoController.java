package com.systempaymentut.proyecto_fullstack_ut.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.systempaymentut.proyecto_fullstack_ut.entities.Estudiante;
import com.systempaymentut.proyecto_fullstack_ut.entities.Pago;
import com.systempaymentut.proyecto_fullstack_ut.enums.PagoStatus;
import com.systempaymentut.proyecto_fullstack_ut.enums.TypePago;
import com.systempaymentut.proyecto_fullstack_ut.repository.EstudianteRepository;
import com.systempaymentut.proyecto_fullstack_ut.repository.PagoRepository;
import com.systempaymentut.proyecto_fullstack_ut.services.PagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping("/api")
@Tag(name = "Pagos", description = "Operaciones relacionadas con pagos y estudiantes")

public class    PagoController {

   @Autowired 
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PagoService pagoService;


    @GetMapping("/estudiantes")
    public List <Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/estudiantes/{codigo}")
    public Estudiante listarEstudiantePorCodigo(@PathVariable String codigo){
        return estudianteRepository.findByCodigo(codigo);
    

    }

     @GetMapping("/estudiantesPorPrograma")
    public List<Estudiante> listarEstudiantePorPrograma(@RequestParam String programaId){
        return estudianteRepository.findByProgramaId(programaId);

    }





        @GetMapping("/pagos")
        public List<Pago> listarPagos() {
            return pagoRepository.findAll();
          

        }
    
         @GetMapping("/pagos/{id}")
         public Pago listarPagoPorId(@PathVariable Long id) { 
            return pagoRepository.findById(id).get();
        }

         
            @GetMapping("/estudiantes/{codigo}/pagos")
        public List<Pago> listarPagosPorCodigoEstudiante(@PathVariable String codigo) {
            return pagoRepository.findByEstudianteCodigo(codigo);
        }


            @GetMapping("/pagosPorStatus")
        public List<Pago> listarPagosPorCodigoStatus(@RequestParam PagoStatus status) {
            return pagoRepository.findByStatus(status);
        }

          @GetMapping("/pagos/PorTipo")
        public List<Pago> listarPagosPorCodigoType(@RequestParam TypePago type) {
            return pagoRepository.findByType(type);
        }
        
          @PutMapping("pagos/{pagoId}/actualizarPago")
          public Pago actualizarStatusDePago(@RequestParam PagoStatus status, @PathVariable Long pagoId){
          return pagoService.actualizarPagoPorStatus(status, pagoId);
        }
        @PostMapping(path = "/pagos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
            public Pago guardarPago(
                @RequestParam("file") MultipartFile file,
                @RequestParam("cantidad") double cantidad,
                @RequestParam("type") TypePago type,
                @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                @RequestParam("codigoEstudiante") String codigoEstudiante) throws IOException {
        return pagoService.savePago(file, cantidad, type, date, codigoEstudiante);
    }


        @GetMapping (value = "/pagoFile/{pagoId}", produces = MediaType.APPLICATION_PDF_VALUE)
            public byte[] listarArchivoPorId(@PathVariable Long pagoId) throws IOException {
                    return pagoService.getArchivoPorId(pagoId);
            
            }
                
           
        }


    
        
        




