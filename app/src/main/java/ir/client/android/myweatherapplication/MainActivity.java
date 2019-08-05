package ir.client.android.myweatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cz.msebera.android.httpclient.Header;
import ir.client.android.myweatherapplication.DailyWeathermodel.DailyWeatherClass;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager pager = findViewById(R.id.pager);
        SmartTabLayout tab = findViewById(R.id.tab);

        TestPagerAdapter adapter = new TestPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tab.setViewPager(pager);

        Hawk.init(MainActivity.this).build();


        //final ImageView imgPic = findViewById(R.id.imgPic);
        final TextView txtTemp = findViewById(R.id.txtTemp);
        //final TextView txtDescribe = findViewById(R.id.txtDescribe);
        final TextView txtName = findViewById(R.id.txtName);
        final TextView txtSpeed = findViewById(R.id.txtSpeed);
        final TextView txtPressure = findViewById(R.id.txtPressure);
        final TextView txtSunrise = findViewById(R.id.txtSunrise);
        final TextView txtSunset = findViewById(R.id.txtSunset);
        final TextView txtTempMin = findViewById(R.id.txtTempMin);
        final TextView txtTempMax = findViewById(R.id.txtTempMax);
        final TextView txtHumidity = findViewById(R.id.txtHumidity);

        String url = "https://api.openweathermap.org/data/2.5/weather?q=Tehran&APPID=4a795a76be3c3dde65fdf55dab9f5361";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {


                //Picasso.with(MainActivity.this).load("https://www.google.com/imgres?imgurl=https%3A%2F%2Fftpcontent.worldnow.com%2Fgriffin%2FbaronIcons%2Fday%2Fpartlycloudy.svg&imgrefurl=http%3A%2F%2Fwww.news9.com%2Fweather&docid=NIGELagQXD1FgM&tbnid=xcdKw0JAaEOkBM%3A&vet=10ahUKEwiwtI7b46fjAhXwB50JHX7IDswQMwhNKAwwDA..i&w=800&h=643&bih=754&biw=1536&q=weather%20image&ved=0ahUKEwiwtI7b46fjAhXwB50JHX7IDswQMwhNKAwwDA&iact=mrc&uact=8").into(imgPic);

                super.onStart();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {


                Gson gson = new Gson();
                DailyWeatherClass weather = gson.fromJson(response.toString(),DailyWeatherClass.class);


                txtName.setText(weather.getName());

                DecimalFormat tempFormat = new DecimalFormat(".#");
                String temperature = tempFormat.format(weather.getMain().getTemp() - 273.15D);
                txtTemp.setText(temperature + "°C");

                txtSpeed.setText(weather.getWind().getSpeed() + " m/s");
                txtPressure.setText(weather.getMain().getPressure() + "hpa");
                txtHumidity.setText(weather.getMain().getHumidity() + "%");

                SimpleDateFormat sunriseFormat = new SimpleDateFormat("HH:mm");
                String formattedSunrise = sunriseFormat.format(new Date(weather.getSys().getSunrise() * 1000L));
                txtSunrise.setText(formattedSunrise);

                SimpleDateFormat sunsetFormat = new SimpleDateFormat("HH:mm");
                String formattedSunset = sunsetFormat.format(new Date(weather.getSys().getSunset() * 1000L));
                txtSunset.setText(formattedSunset);

                /*DecimalFormat tempminFormat = new DecimalFormat(".#");
                String temperaturemin = tempFormat.format(weather.getMain().getTempMin() - 273.15D);
                txtTempMin.setText(temperature + "°C");*/

                /*DecimalFormat tempmaxFormat = new DecimalFormat(".#");
                String temperaturemax = tempFormat.format(weather.getMain().getTempMax() - 273.15D);
                txtTempMax.setText(temperature + "°C");*/




                //txtTemp.setText((Double)  weather.getMain().getTemp()+"°C");

                super.onSuccess(statusCode, headers, response);



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
