package stick.profecoplus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petu on 13/11/16.
 */

public class Favoritos extends Fragment {
    List<RecyclerItem> listItems;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hemeroteca, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHemeroteca);
        ((MainActivity)getActivity()).setTitleActionBar(getString(R.string.bar_favoritos));
        // Usar un administrador para LinearLayout
        listItems = new ArrayList<>();
        RecyclerItem recyclerItem = new RecyclerItem();
        recyclerItem.titulo = "Tendencias";
        recyclerItem.img = "";
        listItems.add(recyclerItem);
        RecyclerItem recyclerItem2 = new RecyclerItem();
        recyclerItem2.titulo = "Ciencia";
        recyclerItem2.img = "";
        listItems.add(recyclerItem2);
        RecyclerItem recyclerItem3 = new RecyclerItem();
        recyclerItem3.titulo = "Tendencias";
        recyclerItem3.img = "";
        listItems.add(recyclerItem3);
        RecyclerItem recyclerItem4 = new RecyclerItem();
        recyclerItem4.titulo = "Ciencia";
        recyclerItem4.img = "";
        listItems.add(recyclerItem4);
        recyclerView.setAdapter(new RecyclerAdapter(listItems, 1));
        LinearLayoutManager lManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lManager);
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int columnCount = 2;
        int spacing = Utils.dpToPx(5, getActivity()); // 50px

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacing));
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}
