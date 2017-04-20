package com.geni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bson.types.ObjectId;

import com.geni.beans.ApplicationReqIdentifier;
import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.beans.StorageARI;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import com.geni.utility.MongoDB;
import com.geni.utility.MysqlJdbc;

public class ARI_Dao {
	// get ARI id from usersappdata
	/*
	 * public String getUserIdFromEmail(String emailID){ String ARI_ID = null;
	 * Connection con = MysqlJdbc.getConnection(); Statement stmt = null; try{
	 * PreparedStatement ps = (PreparedStatement)
	 * con.prepareStatement("insert into usersapp(email) values(?)");
	 * ps.setString(1, emailID); if(ps.executeUpdate() == 1){ stmt =
	 * con.createStatement(); ResultSet rs =
	 * stmt.executeQuery("select * from usersappdata where email ='"+emailID+"'"
	 * ); while(rs.next()){ //System.out.println(rs.getString("pass")); ARI_ID =
	 * rs.getString("apprid"); } } }catch (SQLException e){ e.printStackTrace();
	 * }finally{ MysqlJdbc.closeConn(stmt, con); } return ARI_ID; }
	 */

	// insert generated ARI into table
	public int insertARIIntoMySql(ApplicationReqIdentifier ari) {
		boolean flag = false;
		int user_id = 1;
		int ari_id = -1;
		int n_ari_id = 0;
		int s_ari_id = 0;
		int c_ari_id = 0;
		int sw_ari_id = 0;

		GeneralARI g_ari = ari.getGeneralARI();
		NetworkARI n_ari = ari.getNetworkARI();
		StorageARI s_ari = ari.getStorageARI();
		ComputationARI c_ari = ari.getComputationARI();
		// SoftwareARI sw_ari = ari.getSoftwareARI();

		Connection con = MysqlJdbc.getConnection();
		Statement stmt = null;
		try {
			// insert network features and precondition into network_ari table
			PreparedStatement ps_network = (PreparedStatement) con
					.prepareStatement("insert into network_ari(vpn,public_ip,firewall,sdn) values(?,?,?,?)");
			ps_network.setString(1, n_ari.getVpn());
			ps_network.setString(2, n_ari.getPublicIp());
			ps_network.setString(3, n_ari.getFirewall());
			ps_network.setString(4, n_ari.getSdn());

			// insert network features and precondition into storage_ari table
			PreparedStatement ps_storage = (PreparedStatement) con
					.prepareStatement("insert into storage_ari values(?,?,?)");
			ps_storage.setInt(1, 0);
			ps_storage.setFloat(2, s_ari.getStorageSize());
			ps_storage.setString(3, s_ari.getStorageDisk());

			// insert computation features and preconditions into
			// computation_ari table
			PreparedStatement ps_computation = (PreparedStatement) con.prepareStatement(
					"insert into computation_ari(no_of_nodes,bandwidth,no_of_cores,dedicate_server,os_name,ram_size,gpu,gpu_size,local_storage) values(?,?,?,?,?,?,?,?,?)");
			ps_computation.setString(1, c_ari.getNoOfNodes());
			ps_computation.setInt(2, c_ari.getBandwidth());
			ps_computation.setInt(3, c_ari.getNoOfCores());
			ps_computation.setString(4, c_ari.getDedicatedServer());
			ps_computation.setString(5, c_ari.getOperatingSystem());
			ps_computation.setDouble(6, c_ari.getRamSize());
			ps_computation.setString(7, c_ari.getGpu());
			ps_computation.setString(8, c_ari.getGpuSize());
			ps_computation.setInt(9, c_ari.getLocalStorage());

			ps_computation.executeUpdate();

			if (ps_network.executeUpdate() == 1) {
				Statement n_st = con.createStatement();
				ResultSet n_rs = n_st.executeQuery("select last_insert_id()");
				while (n_rs.next()) {
					n_ari_id = n_rs.getInt(1);
				}
				System.out.println("network_ari_id : " + n_ari_id);
				if (ps_storage.executeUpdate() == 1) {
					Statement s_st = con.createStatement();
					ResultSet s_rs = s_st.executeQuery("select last_insert_id()");
					while (s_rs.next()) {
						s_ari_id = s_rs.getInt(1);
					}
					System.out.println("storage_ari_id : " + s_ari_id);
					if (ps_computation.executeUpdate() == 1) {
						Statement c_st = con.createStatement();
						ResultSet c_rs = c_st.executeQuery("select last_insert_id()");
						while (c_rs.next()) {
							c_ari_id = c_rs.getInt(1);
						}
						System.out.println("compute_ari_id : " + c_ari_id);
						flag = true;
					}
				}
			} // uppermost if condition ends

			if (flag) {
				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement("insert into ari values(?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, g_ari.getAppName());
				ps.setString(3, g_ari.getAppKind());
				ps.setString(4, g_ari.getAppPriority());
				ps.setString(5, g_ari.getAppDataSize());
				ps.setInt(6, n_ari_id);
				ps.setInt(7, s_ari_id);
				ps.setInt(8, c_ari_id);
				ps.setInt(9, sw_ari_id);
				ps.setInt(10, user_id);

				if (ps.executeUpdate() == 1) {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select last_insert_id()");
					while (rs.next()) {
						ari_id = rs.getInt(1);
					}
					System.out.println("ari_id : " + ari_id);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(stmt, con);
		}
		return ari_id;
	}

	public String insertARIIntoMango(ApplicationReqIdentifier ari) {
		String ariJson = "{ " + "'userId': '" + ari.getUserId() + "'," + "'appId': '" + ari.getUserId() + "',"
				+ "'services' : " + "{general : { " + "precondition: 'AppName'," + "feature: '"
				+ ari.getGeneralARI().getAppName() + "'}" +

				"}}";
		DBObject dbObject = (DBObject) JSON.parse(ariJson);
		DB db = MongoDB.getMongoConnection("local");
		DBCollection collection = db.getCollection("ari");
		collection.insert(dbObject);
		ObjectId id = (ObjectId) dbObject.get("_id");
		System.out.println("inside ARI_Dao class; arid id = " + id.toString());
		return id.toString();

	}
}
