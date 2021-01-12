package com.cp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDao implements VehicleDao {

	private static final String INSERT_SQL = "INSERT INTO HR.VEHICLE (COLOR, WHEEL, SEAT, VEHICLE_NO) VALUES (?,?,?,?)";
	private static final String UPDATE_SQL = "UPDATE HR.VEHICLE SET COLOR=?, WHEEL=?, SEAT=? WHERE VEHICLE_NO=?";
	private static final String SELECT_ALL_SQL = "SELECT * FROM HR.VEHICLE";
	private static final String SELECT_ONE_SQL = "SELECT * FROM HR.VEHICLE WHERE VEHICLE_NO=?";
	private static final String DELETE_SQL = "DELETE FROM HR.VEHICLE WHERE VEHICLE_NO=?";
	private static final String COUNT_ALL = "SELECT COUNT(*) FROM HR.VEHICLE";
	private static final String GET_COLOR = "SELECT COLOR FROM HR.VEHICLE WHERE VEHICLE_NO = ?";

	private final DataSource ds;
	private final JdbcTemplate jdbcTemplate;

	public JDBCTemplateDao(DataSource ds) {
		this.ds = ds;
		jdbcTemplate = new JdbcTemplate(this.ds);
	}

	@Override
	public void insert(Vehicle vehicle) {
//		  JdbcTemplate jdbcTemplate = new JdbcTemplate(this.ds);
		jdbcTemplate.update(INSERT_SQL, vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat(),
				vehicle.getVehicleNo());
	}

	private void prepareStmt(PreparedStatement pstmt, Vehicle vehicle) throws SQLException {
		pstmt.setString(1, vehicle.getColor());
		pstmt.setInt(2, vehicle.getWheel());
		pstmt.setInt(3, vehicle.getSeat());
		pstmt.setString(4, vehicle.getVehicleNo());
	}

	@Override
	public void insert(Collection<Vehicle> vehicles) {
		jdbcTemplate.batchUpdate(INSERT_SQL, vehicles, vehicles.size(), this::prepareStmt);
	}

	@Override
	public void update(Vehicle vehicle) {
		jdbcTemplate.update(UPDATE_SQL, vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat(),
				vehicle.getVehicleNo());
	}

	@Override
	public void delete(String vehicleNo) {
		jdbcTemplate.update(DELETE_SQL, vehicleNo);
	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) {
		return jdbcTemplate.queryForObject(SELECT_ONE_SQL, BeanPropertyRowMapper.newInstance(Vehicle.class), vehicleNo);
	}

	private Vehicle toVehicle(ResultSet rs) throws Exception {
		return new Vehicle(rs.getString("VEHICLE_NO"), rs.getString("COLOR"), rs.getInt("SEAT"), rs.getInt("WHEEL"));
	}

	@Override
	public List<Vehicle> findAll() {
		return jdbcTemplate.query(SELECT_ALL_SQL, BeanPropertyRowMapper.newInstance(Vehicle.class));
	}

	@Override
	public String getColor(String vehicleNo) {
		return jdbcTemplate.queryForObject(GET_COLOR, String.class, vehicleNo);
	}

	@Override
	public int getVehicleCount() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

}
