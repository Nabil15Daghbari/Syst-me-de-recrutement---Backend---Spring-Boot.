package com.nabil.SystemRecrutement.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface cvFileService {
	
	
	
	  public void init();

	  public String save(MultipartFile cv);

	  
	  public Resource load(String nameCv);

	  public void deleteAll();

	  public Stream<Path> loadAll();

}
