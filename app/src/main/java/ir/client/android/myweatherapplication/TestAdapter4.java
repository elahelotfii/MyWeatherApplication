package ir.client.android.myweatherapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter4 extends RecyclerView.Adapter<TestAdapter4.TestViewHolder> {

       TextView txt4;

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext()).inflate( R.layout.test_recycler_item4,parent,false );
        TestViewHolder holder = new TestViewHolder( v );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.txt4.setText( "Elahe Lotfi" );
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class TestViewHolder extends RecyclerView.ViewHolder{

        TextView txt4 = itemView.findViewById( R.id.txtitem4 );

        public TestViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}
