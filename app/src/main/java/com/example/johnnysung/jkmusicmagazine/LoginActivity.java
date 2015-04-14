package com.example.johnnysung.jkmusicmagazine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by johnnysung on 2015/04/13.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.username_ed)
    EditText username_ed;

    @InjectView(R.id.password_ed)
    EditText password_ed;

    @InjectView(R.id.login_btn)
    Button login_btn;

    @InjectView(R.id.create_account_btn)
    Button create_account_btn;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);

        login_btn.setOnClickListener(this);
        create_account_btn.setOnClickListener(this);

        queue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v == login_btn) {
//            StringRequest stringRequest = new StringRequest("http://www.kkbox.com/tw/tc/rss/playlists.xml",
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            try {
//                                RssParser rssParser = new RssParser(response);
//                                RssParserHandler parserHandler = new RssParserHandler();
//                                rssParser.setParserHandler(parserHandler);
//                                rssParser.parse();
//                                RssObject result = parserHandler.getResult();
//                                Log.v("Test", result.toString());
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Log.e("TAG", error.getMessage(), error);
//                }
//            });
//            queue.add(stringRequest);

            intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (v == create_account_btn) {

        }
    }
}
