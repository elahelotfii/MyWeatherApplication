package ir.client.android.myweatherapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.Attributes;

import cz.msebera.android.httpclient.Header;
import ir.client.android.myweatherapplication.DailyWeathermodel.DailyWeatherClass;

import static ir.client.android.myweatherapplication.R.id.imgMiladTower;

public class TestFragment extends Fragment {


    private Object Tehran;
    private java.lang.Object Object;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        EditText edtCity = view.findViewById(R.id.edtCity);

        //final ImageView imgPic = view.findViewById(R.id.imgPic);
        final TextView txtTemp = view.findViewById(R.id.txtTemp);
        final TextView txtDescribe = view.findViewById(R.id.txtDescribe);
        final TextView txtName = view.findViewById(R.id.txtName);
        final TextView txtSpeed = view.findViewById(R.id.txtSpeed);
        final TextView txtPressure = view.findViewById(R.id.txtPressure);
        final TextView txtSunrise = view.findViewById(R.id.txtSunrise);
        final TextView txtSunset = view.findViewById(R.id.txtSunset);
        final TextView txtTempMin = view.findViewById(R.id.txtTempMin);
        final TextView txtTempMax = view.findViewById(R.id.txtTempMax);
        final TextView txtHumidity = view.findViewById(R.id.txtHumidity);
        ImageView imgMiladTower = view.findViewById(R.id.imgMiladTower);


        String Name;
        Name = "Tehran";
        if(Name==Tehran) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.miladpic);
            imgMiladTower.setImageDrawable(myDrawable);
        }


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
