package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofEngineRepository;
import lt.pap.model.TofEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TofEngineService {
	/**
     * 
     */
	@Autowired
	private TofEngineRepository tofEngineRepository;
	
	@Autowired
	private TofDesignationService tofDesignationService;

	@Transactional
	public List<TofEngine> findAll(short localeId) {
		List<TofEngine> engineList = tofEngineRepository.findAll();
		loadDesignations(engineList, localeId);
		return engineList;
	}

	@Transactional
	public TofEngine findOne(Integer engineId, short localeId) {
		TofEngine engine = tofEngineRepository.findOne(engineId);
		loadDesignation(engine, localeId);
		return engine;
	}

	public TofEngine save(TofEngine engine) {
		return tofEngineRepository.save(engine);
	}
	
	private void loadDesignations(List<TofEngine> engineList, short localeId){
		for(TofEngine engine : engineList) {
			loadDesignation(engine, localeId);
		}
	}

	private void loadDesignation(TofEngine engine, short localeId){
		String engKvEngineString = tofDesignationService.getDesignationString(engine.getEngKvEngineDesId(), localeId);
		engine.setEngKvEngineString(engKvEngineString);
	}
}
