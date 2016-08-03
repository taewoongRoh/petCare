package com.petcare.disease;

import javax.servlet.http.HttpServletResponse;

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
	public DiseaseDTO showDetail(@PathVariable(value = "symptom")String d_symptom,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		DiseaseDTO detailList=diseaseMapper.diseaseDetail(d_symptom);
		return detailList;
	}

}
