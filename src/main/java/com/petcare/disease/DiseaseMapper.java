package com.petcare.disease;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiseaseMapper {

	DiseaseDTO diseaseDetail(String d_symptom);
	
	DiseaseDTO[] diseaseList(HashMap list);
	
	DiseaseDTO disease(int id);
}
