package com.example.user.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.databinding.adapter.MovieAdapter;
import com.example.user.databinding.databinding.ActivityMainBinding;
import com.example.user.databinding.model.ModelClass;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //private RecyclerView mList;

//    private LinearLayoutManager linearLayoutManager;
//    private DividerItemDecoration dividerItemDecoration;
    private List<ModelClass> modelClassList;
    private RecyclerView.Adapter adapter;
    private String url = "http://192.168.1.49/android/mashpee/building/android/movie_2.php";

    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        activityMainBinding.recyclerView.setHasFixedSize(true);
        modelClassList = new ArrayList<>();
        adapter = new MovieAdapter(getApplicationContext(), modelClassList);
        activityMainBinding.recyclerView.setAdapter(adapter);


       // mList = (RecyclerView) findViewById(R.id.recyclerView);

        //modelClassList = new ArrayList<>();
       // adapter = new MovieAdapter(getApplicationContext(), modelClassList);

       // linearLayoutManager = new LinearLayoutManager(this);
      //  linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
       /// dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());


       // activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
       // mList.addItemDecoration(dividerItemDecoration);
       // mList.setAdapter(adapter);

        getData();
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("response = " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        ModelClass modelClass = new ModelClass();
                        modelClass.setFirst_name(jsonObject1.getString("first_name"));
                        modelClass.setLast_name(jsonObject1.getString("last_name"));
                        modelClass.setEmail(jsonObject1.getString("email"));
                        modelClass.setImage(jsonObject1.getString("avatar"));


                        modelClassList.add(modelClass);


                }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
