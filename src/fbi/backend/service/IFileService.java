package fbi.backend.service;

import java.io.Serializable;

public interface IFileService {

	public void serialize(String dest, Serializable obj);
	
	public Serializable deserialize(String source);
	
}
