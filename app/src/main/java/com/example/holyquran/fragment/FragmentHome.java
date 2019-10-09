package com.example.holyquran.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextLinks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.holyquran.R;
import com.example.holyquran.adapter.AdapterHome;
import com.example.holyquran.base.Constant;
import com.example.holyquran.modal.ModalAyatHome;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class FragmentHome extends Fragment {
    View view;
    RecyclerView recyclerView;
    AdapterHome adapterHome;
    GridLayoutManager glm;
    ArrayList<ModalAyatHome> modalAyatHomes;
    RequestQueue requestQueue;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        requestQueue = Volley.newRequestQueue(getActivity());
        recyclerView = view.findViewById(R.id.recycler_view);
        modalAyatHomes = new ArrayList<>();
        glm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(glm);


        requestJsonArray();
        return view;
    }

    private void requestJsonArray() {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Constant.ROOT_AYAT, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("Berhasil manggil obj", response + "");
                    try {
                        for (int i = 0; i < response.length(); i++) {

                            JSONObject object = response.getJSONObject(i);
                            String nomor = object.getString("nomor");
                            String name = object.getString("nama");
                            String asma = object.getString("asma");
                            String arti = object.getString("arti");

                            ModalAyatHome ss = new ModalAyatHome(nomor, arti, asma, name);
                            modalAyatHomes.add(ss);
                            adapterHome = new AdapterHome(getActivity(), modalAyatHomes);
                            recyclerView.setAdapter(adapterHome);


                        }

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ArrayGagal", error + "");

            }
        });
        requestQueue.add(request);


    }

}
