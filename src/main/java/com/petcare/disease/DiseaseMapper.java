package com.petcare.disease;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiseaseMapper {

	DiseaseDTO diseaseDetail(int id);
	
	DiseaseDTO[] diseaseList(String category);

}
