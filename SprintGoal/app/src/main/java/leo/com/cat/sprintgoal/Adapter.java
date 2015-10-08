package leo.com.cat.sprintgoal;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Exchange on 10/5/2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private Context context;
    private List<Product> productList;
    ImageLoader imageLoader;

    public Adapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        initImageLoader(context);
        imageLoader = ImageLoader.getInstance();
    }

    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        ImageLoader.getInstance().init(config.build());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView description;

        public ViewHolder(View v) {
            super(v);

            image = (ImageView) v.findViewById(R.id.image);
            name = (TextView) v.findViewById(R.id.name);
            description = (TextView) v.findViewById(R.id.description);
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
        Product item = productList.get(i);

        if(null != item) {
            Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/Secret of the Octopus.ttf");
            viewHolder.name.setText(item.getTitle());
            viewHolder.name.setTypeface(type);
            viewHolder.description.setText(item.getDesc());
//            imageLoader.displayImage(item.getImage(), viewHolder.image);
            Picasso.with(context).load(item.getImage())
                    .resize(200,200)
                    .into(viewHolder.image);

        } else {
            Log.e("Error", "No Items on the List");
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

}
