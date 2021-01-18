package com.cp5;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MyfileDaoImpl implements MyfileDao {

	@Autowired
	private MyfileRepository myfileRepository;
	
	@Override
	public List<Myfile> getAllMyfiles() {
		
		List<Myfile> list = myfileRepository.findAll();
		System.out.println("********************************************");
		System.out.println("      Myfile List Size " + list.size());
		System.out.println("********************************************");
		
		return list;
	}
	
	@Override
	public void saveMyfile(Myfile myfile) {
		myfileRepository.save(myfile);
	}

	@Override
	public Myfile getMyfileById(long fid) {
		Optional <Myfile> optional = myfileRepository.findById(fid);
		Myfile myfile = null;
		
		if(optional.isPresent())
			myfile = optional.get();
		else
			throw new RuntimeException(" Myfile not found for id :: " + fid);
		
		return myfile;
	}

	@Override
	public void deleteMyfileById(long fid) {
		

		myfileRepository.deleteById(fid);
		
	}

//	@Override
//	public Page<Myfile> findPaginated(int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Page<Myfile> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) 
				? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return myfileRepository.findAll(pageable);
	}



}
