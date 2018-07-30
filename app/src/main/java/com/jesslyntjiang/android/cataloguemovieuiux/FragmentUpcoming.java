package com.jesslyntjiang.android.cataloguemovieuiux;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentUpcoming extends Fragment {

    private RecyclerView rvCategory;
    private RecyclerView.Adapter adapter;
    private View view;
    private List<MovieList2> movieLists;

    private static final String API_URL ="https://api.themoviedb.org/3/movie/upcoming?api_key="+BuildConfig.MY_MOVIE_DB_API_KEY+"&language=en-US";


    public FragmentUpcoming() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_now_playing, container,false);

        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        movieLists = new ArrayList<>();

        loadUrlData();

        return view;
    }

    private void loadUrlData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray array = jsonObject.getJSONArray("results");

                    for (int i = 0; i < array.length(); i++){

                        JSONObject data = array.getJSONObject(i);

                        MovieList2 movies = new MovieList2();
                        movies.setJudulFilm(data.getString("title"));
                        movies.setDeskripsiFilm(data.getString("overview"));
                        movies.setTanggalFilm(data.getString("release_date"));
                        movies.setFotoFilm(data.getString("poster_path"));
                        movies.setPerhitunganRating(data.getString("vote_count"));
                        movies.setRatingFilm(data.getString("vote_average"));
                        movieLists.add(movies);

                    }

                    adapter = new Adapter2(movieLists, getActivity());
                    rvCategory.setAdapter(adapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }


}
