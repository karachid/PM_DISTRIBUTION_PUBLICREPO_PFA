package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.MoyenLocomotion;

public interface IMoyenLocomotionService {
	
	public MoyenLocomotion save(MoyenLocomotion entity);
	
	public MoyenLocomotion update(MoyenLocomotion entity);
	
	public List<MoyenLocomotion> selectAll();
	
	public MoyenLocomotion getById(Long id);
	
	public void remove(Long id);
	
}