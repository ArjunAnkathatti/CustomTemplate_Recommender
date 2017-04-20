package com.geni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.geni.beans.*;

import com.geni.utility.MysqlJdbc;

public class MacroOperatorDao {

	public List<String> insertMacOpsToDB(Collection<MacroOperator> moCollection, String ariId) {
		List<String> macIdList = new ArrayList<String>();
		Connection connection = MysqlJdbc.getConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {

			String sql = "insert into macoperator(vm_id,vm_name,ram_size,ram_units,storage_size,storage_units,storage_disk,os_name,os_arch,no_of_Cores,ari_id) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			for (MacroOperator macOp : moCollection) {
				pstmt.setInt(1, Integer.parseInt(macOp.getVm_id()));
				pstmt.setString(2, macOp.getVmName());
				pstmt.setInt(3, Integer.parseInt(macOp.getRamSize()));
				pstmt.setString(4, macOp.getRamUnit());
				pstmt.setInt(5, Integer.parseInt(macOp.getStorageSize()));
				pstmt.setString(6, macOp.getStorageUnit());
				pstmt.setString(7, macOp.getStorageDisk());
				pstmt.setString(8, macOp.getOs());
				pstmt.setString(9, macOp.getOsArch());
				pstmt.setInt(10, Integer.parseInt(macOp.getNoOfCores()));
				pstmt.setString(11, ariId);
				pstmt.executeUpdate();
			}

			stmt = connection.createStatement();
			sql = "select mac_id from macoperator where ari_id = '" + ariId + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				macIdList.add(rs.getString("mac_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(stmt, connection);
			MysqlJdbc.closeConn(pstmt, connection);
		}
		return macIdList;
	}

	public NetworkCandidateResource[] getNetworkResource(NetworkQuery nq) {
		Collection<NetworkCandidateResource> c = new ArrayList<NetworkCandidateResource>();
		NetworkCandidateResource nr;
		Connection con = MysqlJdbc.getConnection();
		PreparedStatement ps = null;
		String sql = "select resource_name, public_ip, vpn, firewall, sdn, csp_name, total_cost, resource_id from network_rspace where vpn ='"
				+ nq.getVpn() + "' and sdn='" + nq.getSdn() + "' and firewall='" + nq.getFirewall() +"'";
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nr = new NetworkCandidateResource();
				String r = rs.getString(1);
				System.out.println(r);

				nr.setResourceName(r);
				nr.setPublicIp(rs.getString(2));
				nr.setVpn(rs.getString(3));
				nr.setFirewall(rs.getString(4));
				nr.setSdn(rs.getString(5));
				nr.setCsp(rs.getString(6));
				nr.setCost(rs.getFloat(7));
				nr.setResourceId(""+rs.getInt(8));

				c.add(nr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(ps, con);
		}
		return c.toArray(new NetworkCandidateResource[c.size()]);
	}

	public StorageCandidateResource[] getStorageResource(StorageQuery sq) {
		Collection<StorageCandidateResource> c = new ArrayList<StorageCandidateResource>();
		StorageCandidateResource sr;
		Connection con = MysqlJdbc.getConnection();
		PreparedStatement ps = null;
		String cost = sq.getStorageDisk().equalsIgnoreCase("yes") ? "ssd_cost" : "hdd_cost";
		String sql = "select resource_name, " + cost +", csp_name, resource_id from storage_rspace where storage_size =" + sq.getStorageSize();
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sr = new StorageCandidateResource();
				String r = rs.getString(1);
				System.out.println(r);

				sr.setResourceName(r);
				sr.setStorageSize(sq.getStorageSize());
				sr.setSsd(sq.getStorageDisk());
				sr.setCost(rs.getFloat(2));
				sr.setCsp(rs.getString(3));
				sr.setResourceId(""+rs.getInt(4));

				c.add(sr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(ps, con);
		}
		return c.toArray(new StorageCandidateResource[c.size()]);
	}

	public ComputeCandidateResource[] getEligibleComputeResources(String computeResourceIDs, String os) {
		Collection<ComputeCandidateResource> c = new ArrayList<ComputeCandidateResource>();
		ComputeCandidateResource cr;
		Connection con = MysqlJdbc.getConnection();
		PreparedStatement ps = null;
		String sql = "select resource_name,csp_name," + os + ", minBandwidth, maxBandwidth, resource_id from sample_rspace where"
				+ " resource_id in (" + computeResourceIDs + ")";
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cr = new ComputeCandidateResource();
				String r = rs.getString(1);
				System.out.println(r);

				cr.setResourceName(r);
				cr.setCsp(rs.getString(2));
				cr.setCost(rs.getFloat(3));
				cr.setMaxBandwidth(rs.getInt(4));
				cr.setMaxBandwidth(rs.getInt(5));
				cr.setResourceId(""+rs.getInt(6));
				c.add(cr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(ps, con);
		}
		return c.toArray(new ComputeCandidateResource[c.size()]);
	}
	
	public List<ComputeResource> getAllComputeResources(String os) {
		List<ComputeResource> computeResourceList = new ArrayList<ComputeResource>();
		Connection con = MysqlJdbc.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select vcpu, ram, storage_size, maxbandwidth, Resource_id from sample_rspace where " + os + "  is not null";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			ComputeResource cr = null;
			while (rs.next()) {
				double[] attr = { rs.getFloat(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4) };
				cr = new ComputeResource(attr, ""+rs.getInt(5));
				computeResourceList.add(cr);
			}

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(st, con);
		}
		return computeResourceList;
	}
}
