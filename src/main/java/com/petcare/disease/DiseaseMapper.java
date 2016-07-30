package com.petcare.disease;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiseaseMapper {

	DiseaseDTO diseaseDetail(String d_symptom);
	
	
}
