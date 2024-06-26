package co.edu.uniquindio.gri.master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import co.edu.uniquindio.gri.model.Investigador;
import co.edu.uniquindio.gri.model.Produccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.edu.uniquindio.gri.dao.GrupoDAO;
import co.edu.uniquindio.gri.dao.InvestigadorDAO;
import co.edu.uniquindio.gri.dao.LineasInvestigacionDAO;
import co.edu.uniquindio.gri.model.Grupo;
import co.edu.uniquindio.gri.utils.Constantes;

@Component
public class Main implements CommandLineRunner {

	@Autowired
	GrupoDAO grupoDAO;

	@Autowired
	InvestigadorDAO investigadorDAO;

	@Autowired
	LineasInvestigacionDAO lineasInvestigacionDAO;


	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(String... arg0) throws Exception {

		long startTime = System.currentTimeMillis();
		long stopTime = 0;
		long elapsedTime = 0;
		
		scrapData();



		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.err.println(elapsedTime);


		System.exit(0);
	}

	@Autowired
	Extractor extractor;

	public List<Grupo> scrapData() throws InterruptedException {

		List<Grupo> gruposInicial = leerDataSet();
		
		//lineasInvestigacionDAO.deleteAll();

		//investigadorDAO.deleteAll();

		List<String> urlSet = llenarUrlSet(gruposInicial);

		List<Grupo> grupos = new ArrayList<Grupo>();
		List<Future<Grupo>> resultList = new ArrayList<Future<Grupo>>();

		for (int i = 0; i < urlSet.size(); i++) {
			Future<Grupo> result = extractor.scrapData(urlSet.get(i), gruposInicial.get(i));
			resultList.add(result);
		}



		for (Future<Grupo> future : resultList) {
			try {
				grupos.add(future.get());

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		return grupos;
	}

	public List<Grupo> leerDataSet() {

		entityManager.clear();

		return grupoDAO.findAll();
	}

	public Grupo leerDataSetPruebas(Long id) {
		Grupo grupo = grupoDAO.findOne(id);
		entityManager.refresh(grupo); // Recarga la entidad desde la base de datos
		return grupo;
	}

	public List<String> llenarUrlSet(List<Grupo> grupos) {

		List<String> urlSet = new ArrayList<String>();

		for (int i = 0; i < grupos.size(); i++) {
			String cadena = "00000000000000" + grupos.get(i).getId();
			cadena = cadena.substring(cadena.length() - Constantes.LINK_GRUPLAC, cadena.length());
			String url = "https://scienti.minciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=" + cadena;
			//System.out.println(i);
			urlSet.add(url);
		}
		/*
		List<String> grupoP = Arrays.asList("https://scienti.minciencias.gov.co/gruplac/jsp/visualiza/visualizagr.jsp?nro=00000000013154");
		urlSet.add(grupoP.get(0));*/
		for(String url : urlSet){
		//	System.out.println(url);
		}
		return urlSet;
	}
}
