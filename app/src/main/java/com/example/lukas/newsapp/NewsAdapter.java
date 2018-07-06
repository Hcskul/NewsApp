package com.example.lukas.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String DATE_SEPARATOR = "T";

    /**
     * Create a new {@link NewsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param news    is the list of {@link News}s to be displayed.
     */
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    /**
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        News currentNews = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID section
        TextView sectionTextView = listItemView.findViewById(R.id.section);
        // set this text on the name TextView
        sectionTextView.setText(currentNews.getSection());

        // Find the TextView in the list_item.xml layout with the ID author
        TextView authorTextView = listItemView.findViewById(R.id.author);
        // set this text on the name TextView
        authorTextView.setText(currentNews.getAuthor());

        // Find the TextView in the list_item.xml layout with the ID title
        TextView titleTextView = listItemView.findViewById(R.id.articleTitle);
        // set this text on the name TextView
        titleTextView.setText(currentNews.getTitle());

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Display the date of the current article in that TextView
        dateView.setText(formatDate(currentNews.getDate())[0]);

        // Find the TextView with view ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        timeView.setText(formatDate(currentNews.getDate())[1]);

        return listItemView;

    }


    /**
     * Return the formatted date and time string of the article
     */
    private String[] formatDate(String completeString) {
        String partOne = "";
        String partTwo = "";

        if (completeString.contains(DATE_SEPARATOR)) {
            int separator = completeString.indexOf(DATE_SEPARATOR);
            partOne = completeString.substring(0, separator);
            partTwo = completeString.substring(separator + 1, completeString.length() - 1);
        } else {
            partOne = getContext().getString((R.string.no_date));
            partTwo = "";
        }

        String[] separatedDate = new String[2];
        separatedDate[0] = partOne;
        separatedDate[1] = partTwo;

        return separatedDate;
    }

}
