package leo.com.cat.sprintgoal2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<Value> jokeList;
    private Response respList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.icndb.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        JokeInterface jokeInterface = restAdapter.create(JokeInterface.class);
        recycler = (RecyclerView)findViewById(R.id.recycler);

        jokeInterface.getJokes(new Callback<Response>() {
            @Override
            public void success(Response resp, retrofit.client.Response response) {
                respList = resp;

                if("success".equals(respList.getType())){
                    jokeList = respList.getValue();
//                    Log.i("Leobas", jokeList.size() + "");
                    for (Value v: jokeList) {
                        Log.i("Leobas1", v.getId() + "");
                        Log.i("Leobas2", v.getJoke() + "");
                    }
                }

                if(jokeList.size() > 0) {
                    recycler.hasFixedSize();
                    recycler.setItemAnimator(new DefaultItemAnimator());
                    recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    Adapter adapt = new Adapter(getApplicationContext(), respList.getValue());
                    recycler.setAdapter(adapt);
                    adapt.notifyDataSetChanged();
                }else{
                    Log.i("Leobas", "Lista Vacia");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("ErrorLeobas", error.getMessage());
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
