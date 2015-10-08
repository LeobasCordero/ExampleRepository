package leo.com.cat.sprintgoal;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Exchange on 10/5/2015.
 */
public interface ProductInterface {
    @GET("/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json")
    public void getProducts(Callback<List<Product>> response);
}
