package com.generaExcel.service;

import com.generaExcel.entity.UtenteEntity;
import com.generaExcel.helper.Helper;
import com.generaExcel.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    private UtenteRepository utenteRepository;

    public ByteArrayInputStream getActualData() throws IOException {
        try{
            List<UtenteEntity> listaUtenti =  utenteRepository.findAll();
            ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(listaUtenti);
            return byteArrayInputStream;
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Errore nel service di import del file Excel...");
            return null;
        }
    }
}
