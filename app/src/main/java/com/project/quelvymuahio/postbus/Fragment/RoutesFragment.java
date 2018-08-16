package com.project.quelvymuahio.postbus.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.project.quelvymuahio.postbus.R;

import java.util.ArrayList;
import java.util.List;

public class RoutesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TicketAdapter ticketAdapter;

    private List<Bilhete> lista;
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

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressBar = (ProgressBar) view.findViewById(R.id.progress_circle);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("bilhete");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Bilhete bilhete = snapshot.getValue(Bilhete.class);
                    lista.add(bilhete);
                }

                progressBar.setVisibility(View.INVISIBLE);

                ticketAdapter = new TicketAdapter(getContext(), lista);
                recyclerView.setAdapter(ticketAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
