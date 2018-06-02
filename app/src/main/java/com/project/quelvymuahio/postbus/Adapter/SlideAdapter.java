package com.project.quelvymuahio.postbus.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.quelvymuahio.postbus.R;

public class SlideAdapter extends PagerAdapter {

    final Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context = context;
    }

    public final int[] slide_image = {R.drawable.comfort, R.drawable.save, R.drawable.ticket};

    public final String[] slide_heading = {
            "CONFORTO", "SEGURANÇA", "BILHETE"
    };

    public final String[] slide_desc = {
            "Descrição de conforto",
            "Descrição de segurança",
            "Obtenha seu bilhete electrónico hoje!!"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView heading = (TextView) view.findViewById(R.id.slide_heading);
        TextView desc = (TextView) view.findViewById(R.id.slide_desc);

        imageView.setImageResource(slide_image[position]);
        heading.setText(slide_heading[position]);
        desc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
