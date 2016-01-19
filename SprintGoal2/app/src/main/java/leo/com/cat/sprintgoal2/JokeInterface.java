package leo.com.cat.sprintgoal2;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Exchange on 10/14/2015.
 */
public interface JokeInterface {

    @GET("/jokes/52")
    public void getJokes(Callback<Response> response);
}
