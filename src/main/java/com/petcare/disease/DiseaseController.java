package com.petcare.disease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DiseaseController {
	
	@Autowired
	DiseaseMapper diseaseMapper;
	
	
	@RequestMapping(path = "/disease/{d_id}", method = RequestMethod.GET)
	public DiseaseDTO showDetail(@PathVariable(value = "d_id")int id) {

		DiseaseDTO diseaseDetail=diseaseMapper.diseaseDetail(id);
		return diseaseDetail;


	}
	

	@RequestMapping(path = "/disease", method = RequestMethod.GET)
	public List diseaseList(@RequestParam(value="list[]") String[] list, @RequestParam(value="category") String category) {

		DiseaseDTO[] dtoList = diseaseMapper.diseaseList(category);		
		
		List<DiseaseDTO> diseaseList = new ArrayList();
		
		Boolean flag = false;
		
		for(DiseaseDTO dto : dtoList) {
			flag= false;
			for(String symptom : list) {
				if(dto.getD_symptom().matches(".*"+symptom+".*")) {
						dto.setCount(dto.getCount()+1);
						flag=true;
				}	
			}
			if(flag){
				diseaseList.add(dto);
			}
		}
		
		Collections.sort(diseaseList, new CountDescCompare());

		return diseaseList;
	}
	

	
	
	public static class CountDescCompare implements Comparator<DiseaseDTO> { // Count로 내림차순 정렬
		 
		/**
		 * 내림차순(DESC)
		 */
		public int compare(DiseaseDTO arg0, DiseaseDTO arg1) {
			// TODO Auto-generated method stub
			return arg0.getCount() > arg1.getCount() ? -1 : arg0.getCount() < arg1.getCount() ? 1:0;
		}
 
 
	
}
