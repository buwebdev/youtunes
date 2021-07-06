SELECT al.title, art.last_name FROM album al 
	INNER JOIN artist art ON al.artist_id = art.artist_id;
	
	
-- Query to populate the index.jsp page
SELECT al.album_id, 
	   al.title, 
	   al.price, 
	   al.genre, 
	   ar.last_name, 
	   ar.artist_id 
FROM album al
INNER JOIN 
	artist ar ON al.artist_id = ar.artist_id; 

