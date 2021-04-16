package yucroq.webservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yucroq.dao.AnimalRepository;
import yucroq.dto.PoidsPourAnimal;

@Service
@RequestMapping(path = "/api/stats")
public class StatsWebService {
	@Autowired
	private AnimalRepository dao;
	/**
	 * Relevés de poids pour un animal donné.
	 * @param id l'ID de l'animal concerné
	 * @return les pesées pour l'animal en question en format JSON
	 */
	@GetMapping(
                path = "listePeseesPourAnimal", 
                produces = { MediaType.APPLICATION_JSON_VALUE,
			     MediaType.APPLICATION_XML_VALUE }
        )
	public @ResponseBody List<PoidsPourAnimal> listePeseesPourAnimal(
			@RequestParam(required = true) final Integer id) {
		return dao.listePeseesPour(id);
	}
}
