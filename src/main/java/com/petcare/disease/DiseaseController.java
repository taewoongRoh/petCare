package com.petcare.disease;

import java.util.HashMap;

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
	
	
	@RequestMapping(path = "/disease/{symptom}", method = RequestMethod.GET)
	public DiseaseDTO showDetail(@PathVariable(value = "symptom")String d_symptom,HttpServletResponse response) {

		DiseaseDTO detailList=diseaseMapper.diseaseDetail(d_symptom);
		System.out.println("--------------");
		return detailList;
	}
	

	@RequestMapping(path = "/disease", method = RequestMethod.GET)
	public DiseaseDTO[] diseaseList(@RequestParam(value="list[]") String[] list, @RequestParam(value="category") String category) {
		for(String temp : list) {
			System.out.print(temp + ",");
		}
		System.out.println();
		System.out.println(category);
		System.out.println("-----------------------------");
		
		HashMap<String, Object> map =new HashMap();
		
		map.put("list", list);
		map.put("category", category);
		DiseaseDTO[] show = diseaseMapper.diseaseList(map);
		
		
		return show;
	}
	
	@RequestMapping(path = "/disease123", method = RequestMethod.GET)
	public DiseaseDTO disease(@RequestParam(value="list[]") String list[]) {
		
		System.out.println("111");
		DiseaseDTO show = diseaseMapper.disease(1);
		
		System.out.println(show);
		System.out.println(list[0]);


		return show;
	}
	
}
