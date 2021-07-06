package youtunes.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import youtunes.model.Artist;
import youtunes.service.JdbcManager;
import youtunes.service.dao.ArtistDao;

public class JdbcArtistDao implements ArtistDao {

	JdbcManager db;  
	
	public JdbcArtistDao() 
	{
		db = new JdbcManager();
	}
	
	@Override
	public void add(Artist entity) 
	{
		Connection conn = db.getConn(); 
		Artist newArtist = entity;
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement(); 
				String sql = "INSERT INTO artist(first_name, last_name) VALUES('" + newArtist.getFirstName() + "', '" + newArtist.getLastName() + "')";
				
				System.out.println(sql);
				
				try
				{
					s.executeUpdate(sql);
				}
				finally { s.close(); }
			}
			catch(SQLException ex)
			{
				System.out.println("Unable to insert newArtist: {firstName=" + newArtist.getFirstName() + ";lastName=" + newArtist.getLastName() + "}"); 
				System.out.println(ex.getMessage());
			}
		}
	}

	@Override
	public List<Artist> list() {
		Connection conn = db.getConn();
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement();
				String sql = "select artist_id, first_name, last_name from artist";
				
				try 
				{
					ResultSet rs = s.executeQuery(sql);
					
					try 
					{
						while (rs.next()) 
						{
							Artist artist = new Artist();
							artist.setAritstId(rs.getLong(1));
							artist.setFirstName(rs.getString(2));
							artist.setLastName(rs.getString(3));
							artists.add(artist);
						}
					}
					finally { rs.close(); }
				}
				finally { s.close(); }
			}
			catch (SQLException ex)
			{
				System.out.println("Could not artists: " + ex.getMessage());
			}
			finally 
			{
				db.closeConn(conn);
			}
		}
		
		return artists;
	}

	@Override
	public Artist find(Long key) {
		Connection conn = db.getConn(); 
		
		Artist artist = null;
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement(); 
				String sql = "select artist_id, first_name, last_name from artist where artist_id =" + key;
				
				try 
				{
					ResultSet rs = s.executeQuery(sql);
					
					try 
					{
						if (rs.next()) 
						{
							artist = new Artist(rs.getLong(1), rs.getString(2), rs.getString(3));
						}
					}
					finally { rs.close();}
				}
				finally { s.close(); }				
			}
			catch (SQLException ex)
			{
				System.out.println("Could not get artist: " + ex.getMessage());
			}
		}
		
		return artist;
	}

	@Override
	public void update(Artist entity) 
	{
		Connection conn = db.getConn();
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement();
				String sql = "UPDATE artist SET first_name = '" + entity.getFirstName() + "', last_name = '" + entity.getLastName() + "' WHERE artist_id = " + entity.getArtistId();
				System.out.println(sql);
				
				try 
				{
					s.executeUpdate(sql);
				}
				finally { s.close(); }
			}
			catch (SQLException ex)
			{
				System.out.println("Could not update artist: " + ex.getMessage());
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long key) 
	{
		Connection conn = db.getConn(); 
		
		if (conn != null) 
		{
			try
			{
				Statement s = conn.createStatement(); 
				String sql = "DELETE FROM artist WHERE artist_id = " + key;
				System.out.println(sql);
				
				try 
				{
					s.executeUpdate(sql);
				}
				finally { s.close(); }
			}
			catch (SQLException ex)
			{
				System.out.println("Could not delete artist: " + ex.getMessage());
			}
		}
	}
}
