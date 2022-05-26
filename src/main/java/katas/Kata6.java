package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        String kata06=movies.stream()
                .map(bArts->bArts.getBoxarts())
                .flatMap(fBox->fBox.stream())
                .reduce((boxArt, boxArt2) -> boxArt.getWidth()*boxArt.getHeight()>boxArt2.getWidth()*boxArt2.getHeight()?boxArt:boxArt2)
                .map(bArt->bArt.getUrl())
                .orElseThrow();
        return kata06;
        //return "someUrl";
    }
}
