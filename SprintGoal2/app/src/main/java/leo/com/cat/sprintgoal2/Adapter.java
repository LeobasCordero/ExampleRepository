package leo.com.cat.sprintgoal2;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Exchange on 10/14/2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private Context context;
    private List<Value> jokeList;


    public Adapter(Context context, List<Value> jokeList) {
        this.context = context;
        this.jokeList = jokeList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView joke;
        TextView category;

        public ViewHolder(View v) {
            super(v);

            joke = (TextView) v.findViewById(R.id.joke);
            category = (TextView) v.findViewById(R.id.category);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Value joke = jokeList.get(i);

        if(null != joke) {
//            Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/Secret of the Octopus.ttf");
            viewHolder.joke.setText(joke.getJoke());
//            viewHolder.name.setTypeface(type);
//            viewHolder.category.setText(joke.getCategories().get(1).toString());
        } else {
            Log.e("Leobas", "No Items on the List");
        }
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }

}
