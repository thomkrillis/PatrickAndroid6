package io.github.thomkrillis.patrickandroid6.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.thomkrillis.patrickandroid6.R;

import java.util.List;
import java.util.Random;

public class MoonsAdapter extends BaseAdapter {

    private final List<String> moons;

    public MoonsAdapter(List<String> moons) {
        this.moons = moons;
    }

    @Override
    public int getCount() {
        return moons.size();
    }

    @Override
    public Object getItem(int position) {
        return moons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            //if the view was null it wasn't recycled
            // we need to inflate a new one
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.list_row, parent, false);
        }

        Context context = parent.getContext();

        Random rnd = new Random();
        int backgroundColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        convertView.setBackgroundColor(backgroundColor);

        TextView moonTextView = (TextView) convertView.findViewById(R.id.text);
        String moonName = moons.get(position);
        moonTextView.setText(moonName);

        ImageView moonImageView = (ImageView) convertView.findViewById(R.id.icon);
        int planetNumber = rnd.nextInt(10 - 1 + 1) + 1;
        String planet = "planet".concat(Integer.toString(planetNumber));
        int moonIcon = context.getResources()
                .getIdentifier(planet, "drawable", context.getPackageName());
        moonImageView.setImageResource(moonIcon);

        return convertView;
    }
}