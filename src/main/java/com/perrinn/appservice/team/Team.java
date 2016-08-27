package com.perrinn.appservice.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;
import com.perrinn.appservice.util.Config;

@Entity
@Table(name="team")
public class Team {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long teamOwner;
	private String teamName;

	private Connection conn;

	// Getters
	public long getId() {
		return this.id;
	}

	public long getTeamOwner() {
		return this.teamOwner;
	}

	public String getTeamName() {
		return this.teamName;
	}

	// Setters
	public void setId(long value) {
		this.id = value;
	}

	public void setTeamOwner(long value) {
		this.teamOwner = value;
	}

	public void setTeamName(String value) {
		this.teamName = value;
	}

	private void initLocals() {
		this.id = 0;
		this.teamOwner = 0;
		this.teamName = null;
		this.conn = null;
	}

	public Team() {
		this.initLocals();
	}

	public Team(long id) {
		this.initLocals();
		this.id = id;
	}

	public Team(String name) {
		this.initLocals();
		this.teamName = name;
	}

	private boolean open() {
		boolean ret = false;

		Config conf = new Config();
		try {
			Class.forName(conf.getDatabaseDriver());
			this.conn = DriverManager.getConnection(conf.getDatabaseString(), conf.getDatabaseUser(), conf.getDatabasePassword());
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			ret = true;
		}

		return ret;
	}
	public boolean close() {
    	boolean ret = false;
    	
    	try {
    		if(this.conn.isClosed() == false) {
    			this.conn.close();
    		}
    	}
    	catch(Exception ex) {
    		System.err.println(ex.toString());
    	}
    	
    	return ret;
	}

	public long loadById() {
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "select * from team where id= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setLong(1, this.id);
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.teamOwner = rs.getLong("team_owner");
					this.teamName = rs.getString("team_name");
				}
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				this.id = 0; // The entry is not available.
			} 
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
				}
			}
		}
		else {
			this.id = 0;	// Database not open.  Didn't get anything
		}

		return this.id;
	}

	public boolean save() {
		boolean ret = false;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "update team set team_name=?, team_owner=? where id= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, this.teamName);
				stmt.setLong(2, this.teamOwner);
				stmt.setLong(3, this.id);
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				this.id = 0; // The entry is not available.
			} 
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
					ret = true;
				}
			}
		}
		else {
			ret = true;	// Database not open.  Didn't get anything
		}

		return ret;
	}
}