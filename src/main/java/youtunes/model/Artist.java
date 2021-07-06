package youtunes.model;

public class Artist 
{
	private long artistId; 
	private String firstName;
	private String lastName;
	
	public Artist(long artistId, String firstName, String lastName)
	{
		this.artistId = artistId; 
		this.firstName = firstName; 
		this.lastName = lastName;
	}
	
	public Artist(String firstName, String lastName)
	{
		this.firstName = firstName; 
		this.lastName = lastName;
	}
	
	public Artist() {}
	
	public void setAritstId(long artistId) 
	{
		this.artistId = artistId; 
	}
	
	public long getArtistId()
	{
		return artistId;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	@Override
	public String toString()
	{
		return String.format("Artist{artistId=%s, firstName=%s, lastName=%s}", artistId, firstName, lastName);
	}
}
