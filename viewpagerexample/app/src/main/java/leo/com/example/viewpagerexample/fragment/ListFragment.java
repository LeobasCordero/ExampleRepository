package leo.com.example.viewpagerexample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import leo.com.example.viewpagerexample.R;

/**
 * Fragmento con la lista de celdas
 */
public class ListFragment extends Fragment {

    @Bind(R.id.ListaCeldas)
    ListView listaCeldas;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.lista_celdas_layout, container, false);
        ButterKnife.bind(this, v);
        fillList(v);

        return v;
    }

    public void fillList(View v){

        List<String> lst = new ArrayList<String>();

        for(int j = 1; j <= 10; j++) {
            String y = "";
            for (int i = 0; i < j; i++) {
                y+= i;
            }

            lst.add(y);
        }

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(getActivity().getApplicationContext(),
                        android.R.layout.simple_list_item_1,lst);


        listaCeldas.setAdapter(adaptador);
    }



}
