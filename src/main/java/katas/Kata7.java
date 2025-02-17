package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> kata06=movieLists.stream()
                .map(bArts->bArts.getVideos())
                .flatMap(fBox->fBox.stream())
                .map(movie->{
                    HashMap map= new HashMap();
                    map.put("id", movie.getId().toString());
                    map.put("title", movie.getTitle());
                    BoxArt sBoxArt=movie.getBoxarts().stream()
                                    .reduce((bArt1,bArt2)->bArt1.getHeight() * bArt1.getWidth() < bArt2.getWidth() * bArt2.getHeight() ? bArt1 : bArt2)
                                    .orElseThrow();
                    map.put("boxart", sBoxArt.getUrl());
                    return map;
                }).collect(Collectors.toList());
        return kata06;
        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }
}
