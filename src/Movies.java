public class Movies {
    Movie [] movies;
    int nrfilme;
    Movies (){
        nrfilme=0;
        movies = new Movie[500];
    }
    void addMovie ( Movie movie ){
        movies[++nrfilme] = movie;
    }
    Movie searchMovie ( int nr ){
        return movies[nr];
    }
}
