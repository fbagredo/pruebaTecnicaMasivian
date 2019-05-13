package co.pruebatecnica.masivian.calculator.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;

import co.pruebatecnica.masivian.calculator.client.entities.ResultadoOperacion;

@Controller
@Configurable
public class ResultadoOperacionController {

    @Autowired
    ResultadoOperacionService resultadoOperacionService;

    public List<ResultadoOperacion> getAllResultadoOperacion() {
        return resultadoOperacionService.getAllResultadoOperacion();
    }

    public ResultadoOperacion getResultadoOperacion(int id) {
        return resultadoOperacionService.getResultadoOperacionById(id);
    }

    public void deleteResultadoOperacionService(int id) {
    	resultadoOperacionService.delete(id);
    }

    public long saveResultadoOperacion(ResultadoOperacion resultadoOperacion) {
    	resultadoOperacionService.saveOrUpdate(resultadoOperacion);
        return resultadoOperacion.getId();
    }
}
