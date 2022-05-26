package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> kata04=movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(mUrl->mUrl.stream())
                .map(movie -> {
                    List<BoxArt> bArts=movie.getBoxarts()
                            .stream()
                            .filter(bArt->bArt.getWidth()==150&&bArt.getHeight()==200)
                            .collect(Collectors.toList());
                    HashMap map=new HashMap<>();
                    map.put("id", movie.getId().toString());
                    map.put("title", movie.getTitle());
                    map.put("boxArt", bArts.get(0).getUrl());
                    return map;
                }).collect(Collectors.toList());
        return kata04;
        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
    }
}

