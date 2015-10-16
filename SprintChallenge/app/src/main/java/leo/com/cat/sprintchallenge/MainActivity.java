package leo.com.cat.sprintchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private List<Photo> photoList;
    DatabaseHandler db;
    ArrayList<Photo> photos_data = new ArrayList<Photo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://challenge.superfling.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        PhotoInterface photoInterface = restAdapter.create(PhotoInterface.class);

        photoInterface.getObjectList(new Callback<List<Photo>>() {
            @Override
            public void success(List<Photo> photoL, Response response) {
                photoList = photoL;

                Log.i("leobas", photoList.size() + " from Json");
                for(int i = 0 ; i < photoList.size() ; i++) {
                    Photo photo = photoList.get(i);
                    Log.i("Leobas", "titulo: " + photo.getTitle());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                // something went wrong
            }
        });

//        refreshData(photoList);
    }

    public void refreshData(){//List<Photo> photoList) {
        photos_data.clear();
        db = new DatabaseHandler(this);
        ArrayList<Photo> photos_array_from_db = db.getPhotos();
        Log.i("Leobas",photos_array_from_db.size() + " from DB");

        for (int i = 0; i < photos_array_from_db.size(); i++) {
            int id = photos_array_from_db.get(i).getID();
            int imageid = photos_array_from_db.get(i).getImageID();
            String title = photos_array_from_db.get(i).getTitle();
            int userid = photos_array_from_db.get(i).getUserID();
            String username = photos_array_from_db.get(i).getUserName();
            Photo p = new Photo();
            p.setID(id);
            p.setImageID(imageid);
            p.setTitle(title);
            p.setUserID(userid);
            p.setUserName(username);

            photos_data.add(p);
        }
        db.close();
//        cAdapter = new Contact_Adapter(Main_Screen.this, R.layout.listview_row,
//                contact_data);
//        Contact_listview.setAdapter(cAdapter);
//        cAdapter.notifyDataSetChanged();
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
