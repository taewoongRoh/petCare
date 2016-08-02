package com.petcare.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DiseaseController {
	
	@Autowired
	DiseaseMapper diseaseMapper;
	
	
	@RequestMapping(path = "/disease/{symptom}", method = RequestMethod.GET)
	public DiseaseDTO showDetail(@PathVariable(value = "symptom")String d_symptom) {
		System.out.println("ssssssssssss >>>>>>>>>>. "+d_symptom);
		DiseaseDTO detailList=diseaseMapper.diseaseDetail(d_symptom);
		
		return detailList;
	}

}
