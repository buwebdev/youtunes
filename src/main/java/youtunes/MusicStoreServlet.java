package youtunes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youtunes.model.Album;
import youtunes.model.Artist;
import youtunes.service.impl.JdbcAlbumDao;
import youtunes.service.impl.JdbcArtistDao;

/**
 * Servlet implementation class MusicStoreServlet
 */
@WebServlet(name = "MusicStoreServlet", urlPatterns = { "/store/*" })
public class MusicStoreServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MusicStoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String base = "/jsp/"; // Set the base folder name to jsp.
		String url = base + "index.jsp"; // set the default url to /jsp/index.jsp.
		String action = request.getParameter("action"); // get the parameter action value.

		System.out.println("Action value from the doPost method: " + action);
		System.out.println("URL value from the doPost method: " + url);

		if (action != null) 
		{
			switch (action) 
			{
				case "showContactUs":
					url = base + "Contact.jsp";
					break;
				case "showAboutUs":
					url = base + "About.jsp";
					break;
				case "showArtists":
					url = base + "artists/List.jsp";
					break;
				case "newArtist":
					url = base + "artists/New.jsp";
					break;
				case "artistDetails":
					url = base + "artists/Details.jsp";
					break;
				case "updateArtist":
					updateArtist(request, response);
					url = base + "artists/List.jsp";
					break;
				case "deleteArtist": 
					deleteArtist(request, response);
					url = base + "artists/List.jsp";
					break;
				case "createArtist":
					createArtist(request, response);
					url = base + "artists/List.jsp";
					break;
				case "newAlbum":
					url = base + "albums/New.jsp";
					break;
				case "albumDetails":
					url = base + "albums/Details.jsp";
					break;
				case "createAlbum":
					createAlbum(request, response);
					url = base + "index.jsp";
					break;
				case "updateAlbum":
					updateAlbum(request, response);
					url = base + "index.jsp";
					break;
				case "showAlbums":
					url = base + "index.jsp";
					break;
				case "deleteAlbum":
					deleteAlbum(request, response);
					url = base + "index.jsp";
					break;
			}
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);

		requestDispatcher.forward(request, response);
	}
	
	private void updateArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String artistId = request.getParameter("artistId"); 
		
		Artist artistToUpdate = new Artist(); 
		artistToUpdate.setAritstId(Long.parseLong(artistId));
		artistToUpdate.setFirstName(firstName);
		artistToUpdate.setLastName(lastName);
		
		JdbcArtistDao artistDao = new JdbcArtistDao(); 
		artistDao.update(artistToUpdate);
		
		System.out.println("ArtistId: " + artistId + "; First name: " + firstName + "; Last name: " + lastName);
		System.out.println("Updated artist: " + artistId);
	}
	
	private void deleteArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String artistId = request.getParameter("artistId");
		
		JdbcArtistDao artistDao = new JdbcArtistDao();
		artistDao.remove(Long.parseLong(artistId));
		
		System.out.println("Removed artist: " + artistId);
	}
	
	private void createArtist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		JdbcArtistDao artistDao = new JdbcArtistDao(); 
		artistDao.add(new Artist(firstName, lastName));
		
		System.out.println("Added artist: {first_name='" + firstName + "';last_name='" + lastName + "'}");
	}
	
	private void createAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String genre = request.getParameter("genre");
		String imgUrl = request.getParameter("img_url");
		String artistId = request.getParameter("artist");
		
		Album newAlbum = new Album(); 
		newAlbum.setTitle(title);
		newAlbum.setPrice(Double.parseDouble(price));
		newAlbum.setGenre(genre);
		newAlbum.setImgUrl(imgUrl);
		newAlbum.setArtistId(Long.parseLong(artistId));
		
		JdbcAlbumDao albumDao = new JdbcAlbumDao(); 
		albumDao.add(newAlbum);
		
		System.out.println(newAlbum.toString());
		// System.out.println(String.format("Album{title=%s, price=%s, genre=%s, artistId=%s}", title, price, genre, artistId));
	}
	
	private void updateAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String albumId = request.getParameter("albumId");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String imgUrl = request.getParameter("img_url");
		String genre = request.getParameter("genre");
		String artistId = request.getParameter("artist");
		
		Album updatedAlbum = new Album();
		updatedAlbum.setAlbumId(Long.parseLong(albumId));
		updatedAlbum.setTitle(title);
		updatedAlbum.setPrice(Double.parseDouble(price));
		updatedAlbum.setGenre(genre);
		updatedAlbum.setImgUrl(imgUrl);
		updatedAlbum.setArtistId(Long.parseLong(artistId));
		
		System.out.println(imgUrl);
		
		JdbcAlbumDao albumDao = new JdbcAlbumDao(); 
		albumDao.update(updatedAlbum);
		
		System.out.println(updatedAlbum.toString());
	}
	
	private void deleteAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String albumId = request.getParameter("albumId");
		
		JdbcAlbumDao albumDao = new JdbcAlbumDao(); 
		albumDao.remove(Long.parseLong(albumId));
				
		System.out.println("Removed album: " + albumId);
	}
}
