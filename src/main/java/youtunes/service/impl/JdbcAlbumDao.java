package youtunes.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import youtunes.model.Album;
import youtunes.service.JdbcManager;
import youtunes.service.dao.AlbumDao;

/**
 * Sprint 3
 * @author RK
 */
public class JdbcAlbumDao implements AlbumDao {

	JdbcManager db; 
	
	public JdbcAlbumDao() 
	{
		db = new JdbcManager(); 
	}
	
	@Override
	public void add(Album entity) 
	{
		Connection conn = db.getConn(); 
		Album newAlbum = entity; 
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement(); 
				
				String sql = String.format("INSERT INTO album(title, price, genre, img_url, artist_id) values('%s', %s, '%s', '%s', %s);", 
						newAlbum.getTitle(), newAlbum.getPrice(), newAlbum.getGenre(), newAlbum.getImgUrl(), newAlbum.getArtistId());
				
				System.out.println(sql);
				
				try 
				{
					s.executeUpdate(sql);
				}
				finally { s.close(); }
			}
			catch (SQLException ex)
			{
				System.out.println("Unable to insert newAlbum: " + newAlbum.toString()); 
				System.out.println(ex.getMessage());
			}
		}
	}

	@Override
	public List<Album> list() 
	{
		Connection conn = db.getConn(); 
		ArrayList<Album> albums = new ArrayList<Album>();
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement();
				
				String sql = "select album_id, title, price, img_url, genre from album";
				
				System.out.println(sql);
				
				try 
				{
					ResultSet rs = s.executeQuery(sql);
					
					try 
					{
						while (rs.next()) 
						{
							Album album = new Album();
							album.setAlbumId(rs.getLong(1));
							album.setTitle(rs.getString(2));
							album.setPrice(rs.getDouble(3));
							album.setImgUrl(rs.getString(4));
							album.setGenre(rs.getString(5));
							albums.add(album);
						}
					}
					finally { rs.close(); }
				}
				finally { s.close(); }
			}
			catch (SQLException ex)
			{
				System.out.println("COuld not get albums: " + ex.getMessage()); 
			}
			finally
			{
				db.closeConn(conn);
			}
		}
		
		return albums;
	}

	@Override
	public Album find(Long key) 
	{
		Connection conn = db.getConn(); 
		
		Album album = null; 
		
		if (conn != null) 
		{
			try 
			{
				Statement s = conn.createStatement(); 
				
				String sql = "select album_id, title, price, img_url, genre, artist_id from album where album_id = " + key;
				
				System.out.println(sql);
				
				try 
				{
					ResultSet rs = s.executeQuery(sql);
					
					try 
					{
						if (rs.next()) 
						{
							album = new Album(rs.getLong(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getLong(6)); 
						}
					}
					finally { rs.close(); }
				}
				finally { s.close(); }
				
			}
			catch (SQLException ex)
			{
				System.out.println("Could not get album: " + ex.getMessage());
			}
		}
		return album;
	}

	@Override
	public void update(Album entity) {
		Connection conn = db.getConn(); 
		
		Album updatedAlbum = entity; 
		
		if (conn != null) 
		{
			try {
				Statement s = conn.createStatement(); 
				
				String sql = String.format("UPDATE album SET title = '%s', price = %s, genre = '%s', img_url = '%s', artist_id = %s WHERE album_id = %s;", 
						updatedAlbum.getTitle(), updatedAlbum.getPrice(), updatedAlbum.getGenre(), updatedAlbum.getImgUrl(), updatedAlbum.getArtistId(), updatedAlbum.getAlbumId());
				
				System.out.println(sql);
				
				try {
					s.executeUpdate(sql);
				} finally { s.close(); }
			}
			catch (SQLException ex) {
				System.out.println("Could not update album: " + updatedAlbum.toString());
				System.out.println(ex.getMessage());
			}
		}
	}

	@Override
	public void remove(Long key) {
		Connection conn = db.getConn(); 
		
		if (conn != null) 
		{	
			try 
			{	
				Statement s = conn.createStatement(); 
				
				String sql = String.format("DELETE FROM album WHERE album_id = %s", key);
				
				System.out.println(sql);
				
				try 
				{
					s.executeUpdate(sql);
				} 
				finally { s.close(); }
			} 
			catch (SQLException ex) 
			{
				System.out.println("Could not delete ablum: " + key);
				System.out.println(ex.getMessage());
			}
		}
	}
}
