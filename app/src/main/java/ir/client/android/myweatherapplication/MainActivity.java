package ir.client.android.myweatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import ir.client.android.myweatherapplication.DailyWeathermodel.DailyWeatherClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imgPic = findViewById(R.id.imgPic);
        TextView txtTemp = findViewById(R.id.txtTemp);

        String url = "https://api.openweathermap.org/data/2.5/weather?q=Tehran&APPID=4a795a76be3c3dde65fdf55dab9f5361";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();

                Picasso.with(MainActivity.this).load("https://www.google.com/imgres?imgurl=https%3A%2F%2Fftpcontent.worldnow.com%2Fgriffin%2FbaronIcons%2Fday%2Fpartlycloudy.svg&imgrefurl=http%3A%2F%2Fwww.news9.com%2Fweather&docid=NIGELagQXD1FgM&tbnid=xcdKw0JAaEOkBM%3A&vet=10ahUKEwiwtI7b46fjAhXwB50JHX7IDswQMwhNKAwwDA..i&w=800&h=643&bih=754&biw=1536&q=weather%20image&ved=0ahUKEwiwtI7b46fjAhXwB50JHX7IDswQMwhNKAwwDA&iact=mrc&uact=8").into(imgPic);


            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                DailyWeatherClass weather = gson.fromJson(response.toString(),DailyWeatherClass.class);

                Double t = weather.getMain().getTemp();
                System.out.println(t);


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
