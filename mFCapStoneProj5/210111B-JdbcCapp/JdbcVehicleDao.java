package com.cp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class JdbcVehicleDao implements VehicleDao {

	private static final String INSERT_SQL = "INSERT INTO HR.VEHICLE (COLOR, WHEEL, SEAT, VEHICLE_NO) VALUES (?,?,?,?)";
	private static final String UPDATE_SQL = "UPDATE HR.VEHICLE SET COLOR=?, WHEEL=?, SEAT=? WHERE VEHICLE_NO=?";
	private static final String SELECT_ALL_SQL = "SELECT * FROM HR.VEHICLE";
	private static final String SELECT_ONE_SQL = "SELECT * FROM HR.VEHICLE WHERE VEHICLE_NO=?";
	private static final String DELETE_SQL = "DELETE FROM HR.VEHICLE WHERE VEHICLE_NO=?";
	private static final String COUNT_ALL = "SELECT COUNT(*) FROM HR.VEHICLE";
	private static final String GET_COLOR = "SELECT COLOR FROM HR.VEHICLE WHERE VEHICLE_NO = ?";


	private final DataSource ds;
	
	public JdbcVehicleDao(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public void insert(Vehicle vehicle) {
		// TODO Auto-generated method stub
		try( Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_SQL)){
			prepareStmt(vehicle, pstmt);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(" Exception in insert op :: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private void prepareStmt(Vehicle vehicle, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, vehicle.getColor());
		pstmt.setInt(2,vehicle.getWheel());
		pstmt.setInt(3, vehicle.getSeat());
		pstmt.setString(4, vehicle.getVehicleNo());
	}

	@Override
	public void insert(Iterable<Vehicle> vehicles) {
		// TODO Auto-generated method stub
		vehicles.forEach(this::insert);
		
	}

	@Override
	public void delete(String vehicleNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColor(String vehicleNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVehicleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
