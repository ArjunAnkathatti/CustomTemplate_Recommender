package com.geni.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.geni.beans.ComputeResource;


public class KNNArjunDao {
	
	public static List<ComputeResource> getComputeResourceList() {
		List<ComputeResource> computeResourceList = new ArrayList<ComputeResource>();
		Connection con = MysqlJdbc.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			String sql = "select vcpu, ram, storage_size, maxbandwidth, Resource_id from sample_rspace where linux is not null";
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
