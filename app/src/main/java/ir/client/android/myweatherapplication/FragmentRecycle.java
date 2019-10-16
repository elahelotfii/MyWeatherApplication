package ir.client.android.myweatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cunoraz.gifview.library.GifView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.orhanobut.hawk.Hawk;


//import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import ir.client.android.myweatherapplication.DailyWeathermodel.DailyWeatherClass;
import ir.client.android.myweatherapplication.UpdateWeathermodel.UpdateWeatherClass;

//import static ir.client.android.myweatherapplication.R.id.imgMiladTower;


public class FragmentRecycle extends Fragment {

    //TextView edtCity;

    String desc = "";
    String newDesc = "";

    private String city = "";

    private java.lang.Object Object;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //String strtext = getArguments().getString( "City" );
        View v = inflater.inflate(R.layout.recycle_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<String> List = new ArrayList<>(  );
        List.add( "Elahe" );





        /*GifView gifView1 = (GifView) view.findViewById(R.id.gifcloud);
        gifView1.setVisibility(View.VISIBLE);
        gifView1.play();
        gifView1.setGifResource(R.mipmap.avatarlaurafla);
        gifView1.getGifResource();*/

        //Intent intent = getIntent();
        //String s = Intent.getStringExtra("city");
        //txtName.setText(s);



        Hawk.init( getContext() ).build();

        Hawk.put("city", city);
        city = Hawk.get("city");


        final EditText edtCity = view.findViewById(R.id.edtCity);
        Button btnOk = view.findViewById(R.id.btnOk);

        final TextView txtDate = view.findViewById( R.id.txtDate );

        final TextView txtTemp = view.findViewById(R.id.txtTemp);
        final TextView txtName = view.findViewById(R.id.txtName);
        final TextView txtSpeed = view.findViewById(R.id.txtSpeed);
        final TextView txtPressure = view.findViewById(R.id.txtPressure);
        final TextView txtSunrise = view.findViewById(R.id.txtSunrise);
        final TextView txtSunset = view.findViewById(R.id.txtSunset);
        final TextView txtTempMin = view.findViewById(R.id.txtTempMin);
        final TextView txtTempMax = view.findViewById(R.id.txtTempMax);
        final TextView txtHumidity = view.findViewById(R.id.txtHumidity);
        final TextView txtDescription = view.findViewById( R.id.txtDescription );

        final RecyclerView recycler = view.findViewById( R.id.recycler );
        RecyclerView recycler2 = view.findViewById( R.id.recycler2 );
        RecyclerView recycler3 = view.findViewById( R.id.recycler3 );
        RecyclerView recycler4 = view.findViewById( R.id.recycler4 );
        RecyclerView recycler5 = view.findViewById( R.id.recycler5 );


        //final TextView txtDt = view.findViewById( R.id.txtDt );


        /*TestAdapter adapter = new TestAdapter(List);
        recycler.setAdapter( adapter );
        recycler.setLayoutManager( new LinearLayoutManager( getContext(),RecyclerView.VERTICAL,false ) );*/

        TestAdapter2 adapter2 = new TestAdapter2();
        recycler2.setAdapter( adapter2 );
        recycler2.setLayoutManager( new LinearLayoutManager( getContext(),RecyclerView.VERTICAL,false ) );

        TestAdapter3 adapter3 = new TestAdapter3();
        recycler3.setAdapter( adapter3 );
        recycler3.setLayoutManager( new LinearLayoutManager( getContext(),RecyclerView.VERTICAL,false ) );

        TestAdapter4 adapter4 = new TestAdapter4();
        recycler4.setAdapter( adapter4 );
        recycler4.setLayoutManager( new LinearLayoutManager( getContext(),RecyclerView.VERTICAL,false ) );

        TestAdapter5 adapter5 = new TestAdapter5();
        recycler5.setAdapter( adapter5 );
        recycler5.setLayoutManager( new LinearLayoutManager( getContext(),RecyclerView.VERTICAL,false ) );


        GifView gifcloud = view.findViewById( R.id.gifcloud );



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
                DailyWeatherClass weather = gson.fromJson( response.toString(), DailyWeatherClass.class );


                //Intent intent = getIntent();
                //String s = intent.getStringExtra("city");
                //txtName.setText(s);

                /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDateandTime = sdf.format(new Date());

                txtDate.setText(weather.getDt());*/


                txtName.setText(weather.getName());

                DecimalFormat tempFormat = new DecimalFormat( ".#" );
                String temperature = tempFormat.format( weather.getMain().getTemp() - 273.15D );
                txtTemp.setText( temperature + "°C" );

                desc = weather.getWeather().get(0).getDescription();
                String[] words = desc.split(" ");

                for (int i = 0; i < words.length; i++) {
                    newDesc += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).concat(" ");
                }

                txtDescription.setText(newDesc.trim());

                txtSpeed.setText( weather.getWind().getSpeed() + " m/s" );
                txtPressure.setText( weather.getMain().getPressure() + "hpa" );
                txtHumidity.setText( weather.getMain().getHumidity() + "%" );

                SimpleDateFormat sunriseFormat = new SimpleDateFormat( "HH:mm" );
                String formattedSunrise = sunriseFormat.format( new Date( weather.getSys().getSunrise() * 1000L ) );
                txtSunrise.setText( formattedSunrise );

                SimpleDateFormat sunsetFormat = new SimpleDateFormat( "HH:mm" );
                String formattedSunset = sunsetFormat.format( new Date( weather.getSys().getSunset() * 1000L ) );
                txtSunset.setText( formattedSunset );



                super.onSuccess( statusCode, headers, response );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


        String url2 = "http://api.openweathermap.org/data/2.5/forecast?q=Tehran&APPID=4a795a76be3c3dde65fdf55dab9f5361";
        AsyncHttpClient client1 = new AsyncHttpClient(  );
        client1.get(url2, new JsonHttpResponseHandler(  ) {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Gson gson = new Gson();
                //UpdateWeatherClass weather1 = gson.fromJson( response.toString(), UpdateWeatherClass.class );


                //TestAdapter adapter = new TestAdapter(weather1.getList());
                //recycler.setAdapter( adapter );
                recycler.setLayoutManager( new LinearLayoutManager( getContext(),RecyclerView.VERTICAL,false ) );





                super.onSuccess( statusCode, headers, response );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
            });
    }
}