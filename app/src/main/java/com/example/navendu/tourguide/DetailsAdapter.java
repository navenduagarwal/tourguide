package com.example.navendu.tourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by navendu on 7/3/2016.
 */
public class DetailsAdapter extends ArrayAdapter<Details> {
    private int mColorResourceId;
    private int mIconResourceId;

    public DetailsAdapter(Context context, ArrayList<Details> items, int colorResourceId, int iconResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
        mIconResourceId = iconResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Details detail = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView titleText = (TextView) convertView.findViewById(R.id.list_title_textview);
        titleText.setText(detail.getTitle());

        TextView addressText = (TextView) convertView.findViewById(R.id.list_address_textview);
        addressText.setText(detail.getCategory());

        TextView miscText = (TextView) convertView.findViewById(R.id.list_misc_textview);
        miscText.setText(detail.getMiscInfo());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.list_image);
        if (detail.hasImage()) {
            imageView.setImageResource(detail.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        ImageView iconView = (ImageView) convertView.findViewById(R.id.icon_image);
        iconView.setImageResource(mIconResourceId);

        View textContainer = convertView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return convertView;
    }
}
