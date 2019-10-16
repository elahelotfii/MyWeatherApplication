package ir.client.android.myweatherapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;

import ir.client.android.myweatherapplication.UpdateWeathermodel.UpdateWeatherClass;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    //Integer date ;
    //String newDate ;

    TextView txtDt;

   // List<ir.client.android.myweatherapplication.UpdateWeathermodel.List> myList;
    String url2 = "http://api.openweathermap.org/data/2.5/forecast?q=Tehran&APPID=4a795a76be3c3dde65fdf55dab9f5361";

    /*public TestAdapter(java.util.List<String>myList) {
        this.myList = myList;
    }*/

    TextView txt;
    List<ir.client.android.myweatherapplication.UpdateWeathermodel.List> myList;
    public TestAdapter(List<ir.client.android.myweatherapplication.UpdateWeathermodel.List> myList) {
        this.myList = myList;
    }


    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.test_recycler_item,parent,false );
       TestViewHolder holder = new TestViewHolder( v );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        String url2 = "http://api.openweathermap.org/data/2.5/forecast?q=Tehran&APPID=4a795a76be3c3dde65fdf55dab9f5361";
        ir.client.android.myweatherapplication.UpdateWeathermodel.List s = myList.get(position);


        UpdateWeatherClass weather1 = new UpdateWeatherClass();
        holder.txtTehran.setText( weather1.getCity().getName() );
        //holder.txtDt.setText( (CharSequence) testRecord );

        /*SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
        String formattedDate = dateFormat.format(new Date(weather1.getList().getDt() * 1000L));
        holder.txtDt.setText(formattedDate);*/

        /*date = weather1.getList().get(0).getDt();
        String[] words = date.split(" ");

        for (int i = 0; i < words.length; i++) {
            newDate += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).concat(" ");
        }*/

        //txtDt.setText(newDate.trim());

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder{




        TextView txtDt = itemView.findViewById( R.id.txtDt );
        TextView txt = itemView.findViewById( R.id.txtitem );
        TextView txtTehran = itemView.findViewById( R.id.txtTehran );





        public TestViewHolder(@NonNull View itemView) {
            super( itemView );



        }
    }
}
