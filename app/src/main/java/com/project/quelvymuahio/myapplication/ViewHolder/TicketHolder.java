package com.project.quelvymuahio.myapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.quelvymuahio.myapplication.R;

public class TicketHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView name, price, availableTicket, date;

    public TicketHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.ticket_image);
        name = (TextView) itemView.findViewById(R.id.ticket_name);
        price = (TextView) itemView.findViewById(R.id.ticket_price);
        availableTicket = (TextView) itemView.findViewById(R.id.available_tickets);
        date = (TextView) itemView.findViewById(R.id.ticket_date);
    }
}
