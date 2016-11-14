package stick.profecoplus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by petu on 13/11/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

    private List<RecyclerItem> feedItemList;
    private ClickListener clickListener;
    private int tipo;
    public RecyclerAdapter(List<RecyclerItem> feedItemList, int tipo){
        this.feedItemList = feedItemList;
        this.tipo = tipo;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (tipo == 0)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        else
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_favoritos, parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        RecyclerItem feedItem = feedItemList.get(position);
        //Setting text view title
        holder.titulo.setText(feedItem.titulo);
        holder.imagen.setImageResource(R.drawable.side_nav_bar);
        //MainActivity.imageLoader.get(feedItem.img, ImageLoader.getImageListener(holder.imagen, R.drawable.default_image1, R.drawable.default_image1));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected ImageView imagen;
        protected TextView titulo;

        public CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.imagen = (ImageView) itemView.findViewById(R.id.itemImg);
            this.titulo = (TextView) itemView.findViewById(R.id.itemTitulo);

        }
        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.itemClickListener(view, getPosition());
        }
    }

    public interface ClickListener{
        void itemClickListener(View view, int position);
    }
}
