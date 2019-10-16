package ir.client.android.myweatherapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter3 extends RecyclerView.Adapter<TestAdapter3.TestViewHolder> {

    TextView txt3;

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.test_recycler_item3, parent, false );
        TestViewHolder holder = new TestViewHolder( v );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        switch (position) {
            case 0:
                holder.txt3.setText( "Elahe Lotfi" );
                break;
        }

    }


    @Override
    public int getItemCount() {
        return 5;
    }

    class TestViewHolder extends RecyclerView.ViewHolder{


        TextView txt3 = itemView.findViewById( R.id.txtitem3 );

        public TestViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}
