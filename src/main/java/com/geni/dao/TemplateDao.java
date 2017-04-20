package com.geni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.geni.beans.CandidateResource;
import com.geni.beans.ComputeCandidateResource;
import com.geni.beans.NetworkCandidateResource;
import com.geni.beans.StorageCandidateResource;
import com.geni.beans.Template;

import com.geni.utility.MysqlJdbc;

public class TemplateDao {

	public List<CandidateResource> getTemplateInfo(String templateId) {

		String sql = "select network_resource,bandwidth,network_csp,storage_resource,storage_size,storage_disk,storage_csp,storage_cost,"
				+ "compute_resource,compute_csp,compute_cost,total_cost" + " from catalog where template_id = "
				+ templateId;
		System.out.println(sql);
		Connection con = null;
		Statement st = null;

		String nResName = null;
		int bandwidth = -1;
		String nCsp = null;

		int storageSize = -1;
		String storageDisk = null;
		String sResName = null;
		String sCsp = null;
		float sCost = 0;

		String cResName = null;
		String cCSP = null;
		float cCost = 0;

		List<CandidateResource> crList = new ArrayList<CandidateResource>();
		NetworkCandidateResource ncr = null;
		StorageCandidateResource scr = null;
		ComputeCandidateResource ccr = null;

		try {
			con = MysqlJdbc.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				nResName = rs.getString(1);
				bandwidth = rs.getInt(2);
				nCsp = rs.getString(3);

				sResName = rs.getString(4);
				storageSize = rs.getInt(5);
				storageDisk = rs.getString(6);
				sCsp = rs.getString(7);
				sCost = rs.getFloat(8);

				cResName = rs.getString(9);
				cCSP = rs.getString(10);
				cCost = rs.getFloat(11);
			}

			String nSql = "select public_ip,vpn,firewall,sdn,total_cost from network_rspace where Resource_Name='"
					+ nResName + "'";
			String sSql = "select resource_name from storage_rspace where Resource_Name='" + sResName + "'";
			String cSql = "select vcpu,ram,storage_type,storage_size from sample_rspace where resource_name='"
					+ cResName + "' and csp_name='" + cCSP + "'";

			System.out.println(nSql);
			// System.out.println(sSql);
			System.out.println(cSql);

			System.out.println("inside getTemplateInfo method");
			st.close();
			Statement nSt = con.createStatement();
			ResultSet nRs = nSt.executeQuery(nSql);

			// Statement sSt = con.createStatement();
			// ResultSet sRs = sSt.executeQuery(sSql);

			Statement cSt = con.createStatement();
			ResultSet cRs = cSt.executeQuery(cSql);

			while (nRs.next()) {
				ncr = new NetworkCandidateResource();
				ncr.setResourceName(nResName);
				ncr.setPublicIp(nRs.getString(1));
				ncr.setVpn(nRs.getString(2));
				ncr.setFirewall(nRs.getString(3));
				ncr.setSdn(nRs.getString(4));
				ncr.setCost(nRs.getFloat(5));
				ncr.setCsp(nCsp);
			}
			/*
			 * while (sRs.next()) { scr = new StorageCandidateResource();
			 * scr.setResourceName(sResName); scr.setStorageSize(storageSize);
			 * scr.setSsd(sRs.getString(1)); scr.setCsp(sCsp);
			 * scr.setCost(sCost); }
			 */

			scr = new StorageCandidateResource();
			scr.setResourceName(sResName);
			scr.setStorageSize(storageSize);
			scr.setSsd(storageDisk);
			scr.setCsp(sCsp);
			scr.setCost(sCost);

			while (cRs.next()) {
				ccr = new ComputeCandidateResource();
				ccr.setResourceName(cResName);
				ccr.setMaxBandwidth(bandwidth);
				ccr.setvCpu(cRs.getInt(1));
				ccr.setRam(cRs.getFloat(2));
				ccr.setCsp(cCSP);
				ccr.setCost(cCost);
				ccr.setStorageType(cRs.getString(3));
				ccr.setStorageSize(cRs.getInt(4));
			}

			nSt.close();
			// sSt.close();
			cSt.close();

			crList.add(ncr);
			System.out.println("ncr added to the list");
			crList.add(scr);
			System.out.println("scr added to the list");
			crList.add(ccr);
			System.out.println("ccr added to the list");

			System.out.println("length of the list : " + crList.size());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(st, con);
		}
		return crList;
	}

	public int insertTemplates(Collection<Template> templateList) {
		Connection con = MysqlJdbc.getConnection();
		String sql = "insert into catalog values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);

			for (Template t : templateList) {
				ps.setInt(1, 0);
				ps.setString(2, "template.txt");
				ps.setString(3, t.getNetworkResource());
				ps.setInt(4, Integer.parseInt(t.getNetworkResourceId()));
				ps.setInt(5, t.getBandwidth());
				ps.setString(6, t.getNetworkCSP());
				ps.setFloat(7, t.getNetwork_cost());
				ps.setString(8, t.getStorageResource());
				ps.setInt(9, Integer.parseInt(t.getStorageResourceId()));
				ps.setInt(10, t.getStorageSize());
				ps.setString(11, t.getStorageDisk());
				ps.setString(12, t.getStorageCSP());
				ps.setFloat(13, t.getStorageCost());
				ps.setString(14, t.getComputeResource());
				ps.setInt(15, Integer.parseInt(t.getComputeResourceId()));
				ps.setString(16, t.getComputeCSP());
				ps.setFloat(17, t.getComputeCost());
				ps.setFloat(18, t.getTotalCost());
				ps.addBatch();
			}
			int[] count = null;
			count = ps.executeBatch();
			if (count.length == templateList.size()) {
				System.out.println("All the templates are succesfully inserted into catalog table");
			} else {
				System.out.println("no of templates : " + templateList.size());
				System.out.println("no of templates inserted : " + count.length);
				System.out.println("insertion of some templates into catalog table failed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(ps, con);
		}
		return 1;
	}

	public Collection<Template> getUniqueTemplates(Collection<Template> templateList) {
		Collection<Template> uniqueTemplateList = new ArrayList<Template>();
		Connection con = MysqlJdbc.getConnection();
		ResultSet rs = null;
		try {
			for (Template t : templateList) {
				Statement st = con.createStatement();
				String sql = "select count(*) from catalog where network_resourceID='" + t.getNetworkResourceId()
				+ "' and storage_resourceID='" + t.getStorageResourceId() + "' and compute_resourceID='"
				+ t.getComputeResourceId() + "'";
				rs = st.executeQuery(sql);
				rs.next();
				if (rs.getInt(1) < 1) {
					uniqueTemplateList.add(t);
				}
				rs.close();
				rs = null;
				st.close();
			}
			con.close();
			System.out.println("no of eligible templates : " + templateList.size());
			System.out.println("no of unique templates :  " + uniqueTemplateList.size());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {

		}
		return uniqueTemplateList;
	}
}
