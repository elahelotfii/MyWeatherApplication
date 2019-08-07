package ir.client.android.myweatherapplication;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cunoraz.gifview.library.GifView;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.orhanobut.hawk.Hawk;

import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cz.msebera.android.httpclient.Header;
import ir.client.android.myweatherapplication.DailyWeathermodel.DailyWeatherClass;

//import static ir.client.android.myweatherapplication.R.id.imgMiladTower;

public class TestFragment extends Fragment {



    String enterYourCityName;
    private String city = "";


    //private ArrayList<City> userCities;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test,container,false);


        Hawk.init( getContext() ).build();
        if (Hawk.contains( "enterYourCityName" )){
            enterYourCityName = Hawk.get( "enterYourCityName" );
        } else
            enterYourCityName = "Tehran";


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final EditText edtCity = view.findViewById(R.id.edtCity);
        Button btnOk = view.findViewById(R.id.btnOk);


        Hawk.init(getContext()).build();

        if (Hawk.contains( "enterYourCityName" )){
            enterYourCityName = Hawk.get( "enterYourCityName" );
        } else
            enterYourCityName = "Tehran";

        Hawk.put("city", city);
        city = Hawk.get("city");



        //GifView gifcity = (GifView) view.findViewById( R.id.gifcity );

        //gifcity.setVisibility(View.VISIBLE);
        //gifcity.play();
        //gifcity.setGifResource(R.mipmap.weathertest4);
        //gifcity.getGifResource();


        Uri i = Uri.parse( "https://ak0.picdn.net/shutterstock/videos/1015912480/preview/stock-footage-vienna-opera-house-at-sunset-time-lapse-camera-moves-from-left-to-right-change-day-to-night.mp4" );
        VideoView vv = view.findViewById( R.id.vv );
        vv.setMediaController( new MediaController( getContext() ) );
        vv.setVideoURI(i);
        vv.start();



        btnOk.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),MainActivity.class );
                intent.putExtra( "city","Tehran" );
                //edtCity.getText();
                startActivity(intent);

                if (Hawk.contains( "enterYourCityName" )){
                    enterYourCityName = Hawk.get( "enterYourCityName" );
                } else
                    enterYourCityName = "Tehran";




                city = Hawk.get("city");
                Hawk.put("city",city);

            }
        });


        //final ImageView imgPic = view.findViewById(R.id.imgPic);

        //final TextView txtDescribe = view.findViewById(R.id.txtDescribe);

        //ImageView imgMiladTower = view.findViewById(R.id.imgMiladTower);


        /*String Name;
        Name = "Tehran";
        if(Name==Tehran) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.miladpic);
            imgMiladTower.setImageDrawable(myDrawable);
        }*/




                //userCities = (Hawk.contains("UserCities")) ? userCities = Hawk.get("UserCities") : new ArrayList<City>();
                //City userCity = new City(txtName.getText().toString());
                //userCities.add(userCity);
                //Hawk.put("UserCities", userCities);
                //finish();
            }


        }




                /*DecimalFormat tempminFormat = new DecimalFormat(".#");
                String temperaturemin = tempFormat.format(weather.getMain().getTempMin() - 273.15D);
                txtTempMin.setText(temperature + "°C");*/

                /*DecimalFormat tempmaxFormat = new DecimalFormat(".#");
                String temperaturemax = tempFormat.format(weather.getMain().getTempMax() - 273.15D);
                txtTempMax.setText(temperature + "°C");*/




                //txtTemp.setText((Double)  weather.getMain().getTemp()+"°C");

