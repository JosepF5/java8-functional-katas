package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Map> kata01=movies.stream()
                .map(movie->{
                    HashMap map=new HashMap<>();
                    map.put("id",movie.getId());
                    map.put("title",movie.getTitle());
                    return map;
                }).collect(Collectors.toList());
        return kata01;
        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys"));
    }
}
