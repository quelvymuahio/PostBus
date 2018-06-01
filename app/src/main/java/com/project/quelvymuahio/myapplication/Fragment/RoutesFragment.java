package com.project.quelvymuahio.myapplication.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.project.quelvymuahio.myapplication.Adapter.TicketAdapter;
import com.project.quelvymuahio.myapplication.Enum.TripStatus;
import com.project.quelvymuahio.myapplication.Model.CarModel;
import com.project.quelvymuahio.myapplication.Model.RouteModel;
import com.project.quelvymuahio.myapplication.Model.TicketModel;
import com.project.quelvymuahio.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoutesFragment extends Fragment {

    RecyclerView recyclerView;
    TicketAdapter ticketAdapter;

    List<TicketModel> ticketsList;

    public RoutesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_routes, container, false);

        ticketsList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        addDataToTheRecycleView(ticketsList);

        ticketAdapter = new TicketAdapter(getContext(), ticketsList);
        recyclerView.setAdapter(ticketAdapter);

        return view;
    }

    private void addDataToTheRecycleView(List<TicketModel> ticketsList) {

        CarModel carModel = new CarModel(1, R.drawable.background2, 75, "ADC - 785 MP");

        RouteModel routeModel = new RouteModel(1, carModel, "Maputo - Gaza", 300);
        RouteModel routeModel1 = new RouteModel(1, carModel, "Maputo - Beira", 1050);
        RouteModel routeModel2 = new RouteModel(1, carModel, "Maputo - Tete", 1350);
        RouteModel routeModel3 = new RouteModel(1, carModel, "Maputo - Nampula", 1600);

        ticketsList.add(new TicketModel(1, 48, "2.500", new Date(), new Date(), "9 Horas", "13 Horas", routeModel, TripStatus.DONE));
        ticketsList.add(new TicketModel(2, 55, "3.500", new Date(), new Date(), "5 Horas", "22 Horas", routeModel2, TripStatus.CANCELED));
        ticketsList.add(new TicketModel(3, 10, "3.000", new Date(), new Date(), "4 Horas", "15 Horas", routeModel1, TripStatus.RUNNING));
        ticketsList.add(new TicketModel(4, 66, "4.500", new Date(), new Date(), "6 Horas", "0 Horas", routeModel3, TripStatus.SCHEDULED));

    }

}
