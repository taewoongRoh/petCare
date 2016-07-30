package com.petcare.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DiseaseController {
	
	@Autowired
	DiseaseMapper diseaseMapper;
	
	
	@RequestMapping(path = "/detail")
	public DiseaseDTO showDetail(@RequestParam("symptom")String d_symptom) {
		
		DiseaseDTO detailList=diseaseMapper.diseaseDetail(d_symptom);
		
		return detailList;
	}

}
