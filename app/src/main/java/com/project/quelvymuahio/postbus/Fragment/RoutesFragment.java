package com.project.quelvymuahio.postbus.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.quelvymuahio.postbus.Adapter.TicketAdapter;
import com.project.quelvymuahio.postbus.Model.Bilhete;
import com.project.quelvymuahio.postbus.Model.Car;
import com.project.quelvymuahio.postbus.Model.CarModel;
import com.project.quelvymuahio.postbus.Model.Carro;
import com.project.quelvymuahio.postbus.Model.Rota;
import com.project.quelvymuahio.postbus.Model.Route;
import com.project.quelvymuahio.postbus.Model.RouteModel;
import com.project.quelvymuahio.postbus.Model.Ticket;
import com.project.quelvymuahio.postbus.Model.TicketModel;
import com.project.quelvymuahio.postbus.R;

import java.util.ArrayList;
import java.util.List;

public class RoutesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TicketAdapter ticketAdapter;

    private List<Ticket> list;
    private DatabaseReference mDatabaseRef;

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


        //listaBilhetes = new ArrayList<>();
        //carList = new ArrayList<>();
        //listaRotas = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressBar = (ProgressBar) view.findViewById(R.id.progress_circle);

        //list.add(new Ticket("123", "auto_id", "rota_id", "Agendado", "75", "750", "28-05-2018", "09:00", "14-0-2018", "15h"));
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("bilhete");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Ticket ticket = snapshot.getValue(Ticket.class);
                    list.add(ticket);
                }

                progressBar.setVisibility(View.INVISIBLE);

                ticketAdapter = new TicketAdapter(getContext(), list);
                recyclerView.setAdapter(ticketAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

    private void addDataToList() {

        //listaCarros.clear();
        //listaBilhetes.clear();
        //listaRotas.clear();
        //list.clear();
        //carList.clear();



    }

}
