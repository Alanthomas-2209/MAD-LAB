package com.example.gridviewwithimages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ImageAdapter extends ArrayAdapter<Integer> {

    private Context context;
    private Integer[] images;

    public ImageAdapter(Context context, Integer[] images) {
        super(context, R.layout.grid_item, images);
        this.context = context;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);

            imageView = convertView.findViewById(R.id.gridImageView);
            convertView.setTag(imageView);
        } else {
            imageView = (ImageView) convertView.getTag();
        }

        imageView.setImageResource(images[position]);
        return convertView;
    }
}


