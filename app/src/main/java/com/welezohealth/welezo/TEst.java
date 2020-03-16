package com.welezohealth.welezo;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TEst extends AppCompatActivity {

    private ViewPager2 viewPager2;
    List<BannerItems> bannerItems=new ArrayList<>();

    List<Model_RecentSearch> model_recentSearches=new ArrayList<>();
    private RecyclerView recyclerView,recent_add_packageList;

    List<Model_Recent_Add> model_recent_adds=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_test);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        viewPager2=findViewById(R.id.viewPager);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabL);


        viewPager2.setAdapter(new BannerAdapter(bannerItems,viewPager2));

        recyclerView=findViewById(R.id.search_recycle);
        RecentSearchAdapter adapter=new RecentSearchAdapter(model_recentSearches,recyclerView);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);


        recent_add_packageList=findViewById(R.id.recent_add_PackageList);
        Recent_Add_Package_Adapter recent_add_package_adapter=new
                Recent_Add_Package_Adapter(model_recent_adds,recent_add_packageList);
        recent_add_packageList.setAdapter(recent_add_package_adapter);
        LinearLayoutManager recent_add_package_adapterlayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recent_add_packageList.setLayoutManager(recent_add_package_adapterlayoutManager);

        parseFragment();

        recent_add_packageListCreation();


    }

    private void recent_add_packageListCreation() {

        parse_recent_add_packageListCreation();

    }

    private void parse_recent_add_packageListCreation() {
        {
            try {
                JSONObject obj = new JSONObject(loadrecent_add_packageListCreationJSONFromAsset());

                    // Log.d("Details-->", jo_inside.getString("formule"));
for (int i=0;i<=5;i++) {
    String Title = obj.getString("Tests");
    String Rating = obj.getString("Rating");
    String Price = obj.getString("Price");
    //String PackagesId = obj.getString("PackagesId");

    model_recent_adds.add(new Model_Recent_Add(Title, "$ "+Price, Rating, Rating,"("+Rating+")", "https://static01.nyt.com/images/2020/02/02/business/02up-payless-illo/02up-payless-illo-facebookJumbo.jpg"

    ));
}


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String loadrecent_add_packageListCreationJSONFromAsset() {

            String json = null;
            try {
                InputStream is = getApplicationContext().getAssets().open("package.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;


    }

    private void parseFragment() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("articles");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                // Log.d("Details-->", jo_inside.getString("formule"));

                String urlToImage = jo_inside.getString("urlToImage");
                String url = jo_inside.getString("url");
                String title = jo_inside.getString("title");
                String source = jo_inside.getString("source");
                String publishedAt = jo_inside.getString("publishedAt");
                String description = jo_inside.getString("description");
                String content = jo_inside.getString("content");
                String author = jo_inside.getString("author");
                bannerItems.add(new BannerItems(urlToImage));
                model_recentSearches.add(new Model_RecentSearch(author));




                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();

                m_li.put("urlToImage", urlToImage);
                m_li.put("url", url);

                m_li.put("title", title);
                m_li.put("source", source);

                m_li.put("publishedAt", publishedAt);
                m_li.put("description", description);

                m_li.put("content", content);
                m_li.put("author", author);



                formList.add(m_li);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("pictures.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
