package leo.com.cat.sprintgoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://gist.githubusercontent.com/hart88")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        ProductInterface productInterface = restAdapter.create(ProductInterface.class);
        recycler = (RecyclerView)findViewById(R.id.recycler);

        productInterface.getProducts(new Callback<List<Product>>() {
            @Override
            public void success(List<Product> productL, Response response) {
                productList = productL;

                Log.i("leobas", productList.size() + "");
                for(int i = 0 ; i < productList.size() ; i++) {
                    Product product = productList.get(i);
                    Log.i("List", "" + product.getTitle());
                }

                recycler.hasFixedSize();
                recycler.setItemAnimator(new DefaultItemAnimator());
                recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Adapter adapt = new Adapter(getApplicationContext(), productList);
                recycler.setAdapter(adapt);
                adapt.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("ErrorLeobas",error.getMessage());
            }
        });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
