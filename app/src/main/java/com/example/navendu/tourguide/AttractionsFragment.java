package com.example.navendu.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by navendu on 7/3/2016.
 */
public class AttractionsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        ArrayList<Details> detailsAll = new ArrayList<>();
        detailsAll.add(new Details(R.string.attractions_title_one, R.string.attractions_category_one,
                R.string.attractions_hours_one, R.string.attractions_url_one, R.drawable.ic_lalbagh));
        detailsAll.add(new Details(R.string.attractions_title_two, R.string.attractions_category_two,
                R.string.attractions_hours_two, R.string.attractions_url_two, R.drawable.ic_cubbon_park));
        detailsAll.add(new Details(R.string.attractions_title_three, R.string.attractions_category_three,
                R.string.attractions_hours_three, R.string.attractions_url_three, R.drawable.ic_isckon));
        detailsAll.add(new Details(R.string.attractions_title_four, R.string.attractions_category_four,
                R.string.attractions_hours_four, R.string.attractions_url_four, R.drawable.ic_bannerghatta));
        detailsAll.add(new Details(R.string.attractions_title_five, R.string.attractions_category_five,
                R.string.attractions_hours_five, R.string.attractions_url_five, R.drawable.ic_wonderla));
        detailsAll.add(new Details(R.string.attractions_title_six, R.string.attractions_category_six,
                R.string.attractions_hours_six, R.string.attractions_url_six, R.drawable.ic_vidhana));
        detailsAll.add(new Details(R.string.attractions_title_seven, R.string.attractions_category_seven,
                R.string.attractions_hours_seven, R.string.attractions_url_seven, R.drawable.ic_bangalore_palace));
        detailsAll.add(new Details(R.string.attractions_title_eight, R.string.attractions_category_eight,
                R.string.attractions_hours_eight, R.string.attractions_url_eight, R.drawable.ic_ulsoor));

        final DetailsAdapter detailsAdapter = new DetailsAdapter(getActivity(), detailsAll, R.color.category_attractions, R.drawable.ic_location_on_white_48dp);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_word);
        listView.setAdapter(detailsAdapter);
        //Creating intent to open map for url on click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //get current position detail
                Details detail = detailsAdapter.getItem(position);
                String url = getResources().getString(detail.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        return rootView;
    }
}
