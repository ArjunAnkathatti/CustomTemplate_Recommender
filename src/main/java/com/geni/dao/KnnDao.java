package com.geni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.geni.beans.MiniTemplate;

import com.geni.utility.MysqlJdbc;

public class KnnDao {

	public List<MiniTemplate> getEligibleTemplates(String[] nResources, String[] sResources,
			String storageDisk, String[] cResources) {
		List<MiniTemplate> miniTemplateList = new ArrayList<MiniTemplate>();
		StringBuilder nSql = new StringBuilder();
		StringBuilder sSql = new StringBuilder();
		StringBuilder cSql = new StringBuilder();

		for (int i = 0; i < nResources.length; i++) {
			if (i != 0) {
				nSql.append(",'");
			} else {
				nSql.append("('");
			}
			nSql.append(nResources[i]);
			nSql.append("'");
		}
		nSql.append(")");

		for (int i = 0; i < sResources.length; i++) {
			if (i != 0) {
				sSql.append(",'");
			} else {
				sSql.append("('");
			}
			sSql.append(sResources[i]);
			sSql.append("'");
		}
		sSql.append(")");

		for (int i = 0; i < cResources.length; i++) {
			if (i != 0) {
				cSql.append(",'");
			} else {
				cSql.append("('");
			}
			cSql.append(cResources[i]);
			cSql.append("'");
		}
		cSql.append(")");

		Connection con = MysqlJdbc.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			String sql1 = "select template_id,bandwidth,storage_size,total_cost,compute_resourceID from catalog where network_resourceID in "
					+ nSql.toString() + " and storage_resourceID in " + sSql.toString() + " and storage_disk='" + storageDisk
					+ "' and compute_resourceID in " + cSql.toString() + " order by total_cost";
			System.out.println(sql1);
			ResultSet rs1 = st.executeQuery(sql1);

			MiniTemplate mt = null;
			
			
			
			while (rs1.next()) {
				// v = (vcpu, ram, local_storage, bandwidth, storage_size)
				//get compute resource details
				
				double[] computeDetails = getComputeDetailsById(rs1.getInt(5));
				double[] attr = { computeDetails[0], computeDetails[1], computeDetails[2], rs1.getInt(2), rs1.getInt(3) };
				mt = new MiniTemplate(attr, "" + rs1.getInt(1), rs1.getFloat(4));
				miniTemplateList.add(mt);
				
			}

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(st, con);
		}
		return miniTemplateList;
	}
	
	public double[] getComputeDetailsById(int computeResourceId) {
		double attr[] = new double[3];
		Connection con = MysqlJdbc.getConnection();
		Statement st = null;
		try {
		st = con.createStatement();
		String sql2 = "select vcpu, ram, storage_size from sample_rspace where resource_id = " + computeResourceId;
		ResultSet rs2 = st.executeQuery(sql2);
		rs2.next();
		attr[0] = rs2.getFloat(1);
		attr[1] = rs2.getFloat(2);
		attr[2] = rs2.getInt(3);
		}
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(st, con);
		}
		return attr;
	}
}
