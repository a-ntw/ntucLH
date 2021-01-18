package com.cp5;

import java.util.List;

import org.springframework.data.domain.Page;

public interface MyfileDao {
	
	public List<Myfile> getAllMyfiles();

	public void saveMyfile(Myfile myfile);

	public Myfile getMyfileById(long fid);

	public void deleteMyfileById(long fid);

	public Page<Myfile> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

//	public Page<Myfile> findPaginated(int pageNo, int pageSize);

}
