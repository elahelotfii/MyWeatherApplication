package ir.client.android.myweatherapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter5 extends RecyclerView.Adapter<TestAdapter5.TestViewHolder> {

    TextView txt5;

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext()).inflate( R.layout.test_recycler_item5,parent,false );
        TestViewHolder holder = new TestViewHolder( v );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        switch (position) {
            case 0:
                holder.txt5.setText( "Elahe Lotfi" );
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
    class TestViewHolder extends RecyclerView.ViewHolder{

        TextView txt5 = itemView.findViewById( R.id.txtitem5 );

        public TestViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}
