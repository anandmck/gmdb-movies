# gmdb-movies

## Requirements
Develop a microservice api to provide movie data.

The api should be able to:

*	Return all movies in the database
*	Allow search criteria by Actor and/or Title
*	Search by id
*	Search by imdbId
*	Return a specified number of random movies (or 5 by default)

## Acceptance Criteria
*	Ensure all movies are returned
*	If search criteria (Actor and/or Title) is provided, ensure correct movies are being returned
*	Ensure search by id returns the correct movie
*	Ensure search by imdbId returns the correct movie
*	Ensure that the specified number (or 5 by default) of random movies are being returned

## REST endpoints
*   GET: /v1/movies:  Returns a json array of all movies in the database
    * actor: Optional query parameter to include only movies that contain the supplied actor
    * title: Optional query parameter to include only movies that contain the supplied title
######&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Example: /v1/movies?actor=Chris Pratt&title=Guardians
```json
[
    {
        "movieId": 67,
        "metascore": "67",
        "boxOffice": "$389,804,217",
        "website": "https://marvel.com/guardians",
        "imdbRating": "7.7",
        "imdbVotes": "449,175",
        "runtime": "136 min",
        "language": "English",
        "rated": "PG-13",
        "production": "Walt Disney Pictures",
        "released": "2017-05-05T00:00:00.000+0000",
        "imdbId": "tt3896198",
        "plot": "The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lord's encounter with his father the ambitious celestial being Ego.",
        "director": "James Gunn",
        "title": "Guardians of the Galaxy Vol. 2",
        "actors": "Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel",
        "response": "True",
        "type": "movie",
        "awards": "Nominated for 1 Oscar. Another 12 wins & 42 nominations.",
        "dvd": "2017-08-22T00:00:00.000+0000",
        "year": "2017",
        "poster": "https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg",
        "country": "USA",
        "genre": "Action, Adventure, Comedy, Sci-Fi",
        "writer": "James Gunn, Dan Abnett (based on the Marvel comics by), Andy Lanning (based on the Marvel comics by), Steve Englehart (Star-Lord created by), Steve Gan (Star-Lord created by), Jim Starlin (Gamora and Drax created by), Stan Lee (Groot created by), Larry Lieber (Groot created by), Jack Kirby (Groot created by), Bill Mantlo (Rocket Raccoon created by), Keith Giffen (Rocket Raccoon created by), Steve Gerber (Howard the Duck created by), Val Mayerik (Howard the Duck created by)",
        "desc": null
    }
]
```
*   GET: /v1/movies/{id}:  If found, returns the movie by id, otherwise a 404 is returned
######&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Example: /v1/movies/91
```json
{
    "movieId": 91,
    "metascore": "48",
    "boxOffice": "N/A",
    "website": "N/A",
    "imdbRating": "6.4",
    "imdbVotes": "74,264",
    "runtime": "132 min",
    "language": "English, Klingon",
    "rated": "G",
    "production": "Paramount Home Video",
    "released": "1979-12-08T00:00:00.000+0000",
    "imdbId": "tt0079945",
    "plot": "When an alien spacecraft of enormous power is spotted approaching Earth, Admiral James T. Kirk resumes command of the overhauled USS Enterprise in order to intercept it.",
    "director": "Robert Wise",
    "title": "Star Trek: The Motion Picture",
    "actors": "William Shatner, Leonard Nimoy, DeForest Kelley, James Doohan",
    "response": "True",
    "type": "movie",
    "awards": "Nominated for 3 Oscars. Another 4 wins & 16 nominations.",
    "dvd": null,
    "year": "1979",
    "poster": "https://m.media-amazon.com/images/M/MV5BNzNlMzNlNmQtNmYzNS00YmU5LWIzYWQtMDRkYzIzNzEzOTIyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    "country": "USA",
    "genre": "Adventure, Mystery, Sci-Fi",
    "writer": "Gene Roddenberry (based on \"Star Trek\" created by), Harold Livingston (screenplay), Alan Dean Foster (story)",
    "desc": null
}
```
*   GET: /v1/movies/imdb/{imdbId}:  If found, returns the movie by imdb id, otherwise a 404 is returned
######&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Example: /v1/movies/imdb/tt0079945)
```json
{
    "movieId": 91,
    "metascore": "48",
    "boxOffice": "N/A",
    "website": "N/A",
    "imdbRating": "6.4",
    "imdbVotes": "74,264",
    "runtime": "132 min",
    "language": "English, Klingon",
    "rated": "G",
    "production": "Paramount Home Video",
    "released": "1979-12-08T00:00:00.000+0000",
    "imdbId": "tt0079945",
    "plot": "When an alien spacecraft of enormous power is spotted approaching Earth, Admiral James T. Kirk resumes command of the overhauled USS Enterprise in order to intercept it.",
    "director": "Robert Wise",
    "title": "Star Trek: The Motion Picture",
    "actors": "William Shatner, Leonard Nimoy, DeForest Kelley, James Doohan",
    "response": "True",
    "type": "movie",
    "awards": "Nominated for 3 Oscars. Another 4 wins & 16 nominations.",
    "dvd": null,
    "year": "1979",
    "poster": "https://m.media-amazon.com/images/M/MV5BNzNlMzNlNmQtNmYzNS00YmU5LWIzYWQtMDRkYzIzNzEzOTIyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
    "country": "USA",
    "genre": "Adventure, Mystery, Sci-Fi",
    "writer": "Gene Roddenberry (based on \"Star Trek\" created by), Harold Livingston (screenplay), Alan Dean Foster (story)",
    "desc": null
}
```
*   GET: /v1/movies/random:  Returns a json array of random movies (5 by default)
    * quantity: Optional query parameter specifying how many random movies to retrieve
######&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Example: /v1/movies/random?quantity=1
```json
[
    {
        "movieId": 95,
        "metascore": "78",
        "boxOffice": "N/A",
        "website": "N/A",
        "imdbRating": "7.8",
        "imdbVotes": "188,562",
        "runtime": "88 min",
        "language": "English",
        "rated": "PG",
        "production": "Paramount Pictures",
        "released": "1980-07-02T00:00:00.000+0000",
        "imdbId": "tt0080339",
        "plot": "A man afraid to fly must ensure that a plane lands safely after the pilots become sick.",
        "director": "Jim Abrahams, David Zucker, Jerry Zucker",
        "title": "Airplane!",
        "actors": "Kareem Abdul-Jabbar, Lloyd Bridges, Peter Graves, Julie Hagerty",
        "response": "True",
        "type": "movie",
        "awards": "Nominated for 1 Golden Globe. Another 2 wins & 6 nominations.",
        "dvd": null,
        "year": "1980",
        "poster": "https://m.media-amazon.com/images/M/MV5BZjA3YjdhMWEtYjc2Ni00YzVlLWI0MTUtMGZmNTJjNmU0Yzk2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
        "country": "USA",
        "genre": "Comedy",
        "writer": "Jim Abrahams (written for the screen by), David Zucker (written for the screen by), Jerry Zucker (written for the screen by)",
        "desc": null
    }
]
```