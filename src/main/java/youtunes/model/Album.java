package youtunes.model;

/**
 * Sprint 3
 * @author RK
 */
public class Album 
{
	private long albumId; 
	private String title; 
	private double price; 
	private String genre; 
	private String imgUrl; 
	private long artistId;
	
	public Album(long albumId, String title, double price, String imgUrl, String genre, long artistId)
	{
		this.albumId = albumId;
		this.title = title;
		this.price = price; 
		this.genre = genre; 
		this.imgUrl = imgUrl;
		this.artistId = artistId;
	}
	
	public Album(long albumId, String title, double price, String genre, long artistId)
	{
		this.albumId = albumId; 
		this.title = title;
		this.price = price;
		this.genre = genre;
		this.artistId = artistId;
	}
	
	public Album() {}
	
	public void setAlbumId(long albumId) 
	{
		this.albumId = albumId;
	}
	
	public long getAlbumId()
	{
		return albumId;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title; 
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setImgUrl(String imgUrl) 
	{
		this.imgUrl = imgUrl;
	}
	
	public String getImgUrl()
	{
		return imgUrl;
	}
	
	public void setArtistId(long artistId)
	{
		this.artistId = artistId;
	}
	
	public long getArtistId()
	{
		return artistId;
	}
	
	@Override
	public String toString() 
	{
		return String.format("Album{albumId=%s, title=%s, price=%s, genre=%s, imgUrl=%s, artistId=%s}", 
				albumId, title, price, genre, imgUrl, artistId);
	}
}
