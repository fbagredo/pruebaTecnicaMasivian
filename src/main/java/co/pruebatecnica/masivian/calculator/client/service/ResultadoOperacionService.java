package co.pruebatecnica.masivian.calculator.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pruebatecnica.masivian.calculator.client.entities.ResultadoOperacionRepository;
import co.pruebatecnica.masivian.calculator.client.entities.ResultadoOperacion;

@Service
public class ResultadoOperacionService {

    @Autowired
    ResultadoOperacionRepository resultadoOperacionRepository;

    public List<ResultadoOperacion> getAllResultadoOperacion() {
        List<ResultadoOperacion> resultadosOperacion = new ArrayList<ResultadoOperacion>();
        resultadoOperacionRepository.findAll().forEach(resultadoOperacion -> resultadosOperacion.add(resultadoOperacion));
        return resultadosOperacion;
    }

    public ResultadoOperacion getResultadoOperacionById(int id) {
        return resultadoOperacionRepository.findById(id).get();
    }

    public void saveOrUpdate(ResultadoOperacion resultadoOperacion) {
    	resultadoOperacionRepository.save(resultadoOperacion);
    }

    public void delete(int id) {
    	resultadoOperacionRepository.deleteById(id);
    }
}