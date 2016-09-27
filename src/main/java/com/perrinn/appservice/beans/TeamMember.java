package com.perrinn.appservice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;
import com.perrinn.appservice.util.Config;

@Entity
@Table(name="team_member")
public class TeamMember {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long team;
	private long teamMember;

	private Connection conn;

	// Getters
	public long getId() {
		return this.id;
	}

	public long getTeam() {
		return this.team;
	}

	public long getTeamMember() {
		return this.teamMember;
	}

	// Setters
	public void setId(long value) {
		this.id = value;
	}

	public void setTeam(long value) {
		this.team = value;
	}

	public void setTeamMember(long value) {
		this.teamMember = value;
	}

	private void initLocals() {
		this.id = 0;
		this.team = 0;
		this.teamMember = 0;
		this.conn = null;
	}

	public TeamMember() {
		this.initLocals();
	}

	public TeamMember(long id) {
		this.initLocals();
		this.id = id;
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
				sql = "select * from team_member where id= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setLong(1, this.id);
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.team = rs.getLong("team");
					this.teamMember = rs.getLong("member");
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
				sql = "update team_member set team=?, member=? where id= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setLong(1, this.team);
				stmt.setLong(2, this.teamMember);
				stmt.setLong(3, this.id);
				stmt.executeUpdate();
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

	public boolean add() {
		boolean ret = false;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "insert into team_member(team,member) values(?,?)";
				stmt = this.conn.prepareStatement(sql);
				stmt.setLong(1, this.team);
				stmt.setLong(2, this.teamMember);
				stmt.execute();
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