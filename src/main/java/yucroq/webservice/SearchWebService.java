package yucroq.webservice;
import yucroq.entity.Espece;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yucroq.dao.CroquetteRepository;
import yucroq.dto.RechercheCroquettes;

@Service
@RequestMapping(path = "/api/search")
public class SearchWebService {
	@Autowired
        private CroquetteRepository dao;
        
        /**
         * Résultats d'une recherche
         * @param recherche le texte entré
         * @return les croquettes correspondant au texte entré
         */
        
        @GetMapping(
                path = "rechercheCroquettes", 
                produces = { MediaType.APPLICATION_JSON_VALUE}
        )
	public @ResponseBody List<RechercheCroquettes> rechercheCroquettes(
			@RequestParam(required = true) final String recherche, final Integer idanimal) {
		return dao.rechercheCroquettes(recherche, idanimal);
	}
}
