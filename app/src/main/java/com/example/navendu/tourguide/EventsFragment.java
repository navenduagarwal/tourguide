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
public class EventsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        ArrayList<Details> detailsAll = new ArrayList<>();
        detailsAll.add(new Details(R.string.events_title_one, R.string.events_category_one,
                R.string.events_date_one, R.string.events_url_one));
        detailsAll.add(new Details(R.string.events_title_two, R.string.events_category_two,
                R.string.events_date_two, R.string.events_url_two));
        detailsAll.add(new Details(R.string.events_title_three, R.string.events_category_three,
                R.string.events_date_three, R.string.events_url_three));
        detailsAll.add(new Details(R.string.events_title_four, R.string.events_category_four,
                R.string.events_date_four, R.string.events_url_four));
        detailsAll.add(new Details(R.string.events_title_five, R.string.events_category_five,
                R.string.events_date_five, R.string.events_url_five));
        detailsAll.add(new Details(R.string.events_title_six, R.string.events_category_six,
                R.string.events_date_six, R.string.events_url_six));
        detailsAll.add(new Details(R.string.events_title_seven, R.string.events_category_seven,
                R.string.events_date_seven, R.string.events_url_seven));
        detailsAll.add(new Details(R.string.events_title_eight, R.string.events_category_eight,
                R.string.events_date_eight, R.string.events_url_eight));

        final DetailsAdapter detailsAdapter = new DetailsAdapter(getActivity(), detailsAll, R.color.category_events, R.drawable.ic_details_white_36dp);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_word);
        listView.setAdapter(detailsAdapter);
        //Creating intent to open link for url on click
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