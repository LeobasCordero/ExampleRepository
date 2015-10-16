package leo.com.cat.sprintchallenge;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Exchange on 10/16/2015.
 */
public interface PhotoInterface {
    @GET("/")
    void getObjectList(Callback<List<Photo>> response);

    /*@GET("/photos/{idphoto}")
    Photo getPhoto(
            @Path("id") String idphoto
    );*/
}
