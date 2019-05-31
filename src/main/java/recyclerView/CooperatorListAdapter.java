package recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.besnault.coopup.R;

import java.util.List;

import entities.Cooperator;

public class CooperatorListAdapter extends RecyclerView.Adapter<CooperatorListAdapter.CooperatorViewHolder> {

    class CooperatorViewHolder extends RecyclerView.ViewHolder {
        private final TextView cooperatorItemView;

        private CooperatorViewHolder (View itemView){
            super(itemView);
            cooperatorItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Cooperator> mCooperators;

    CooperatorListAdapter (Context context){
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CooperatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CooperatorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CooperatorViewHolder holder, int position) {
        if (mCooperators != null){
            Cooperator current = mCooperators.get(position);
            holder.cooperatorItemView.setText("Il n'y a pas de coopérateur disponible.");
        }
    }

    void setCooperators(List<Cooperator> cooperators) {
        mCooperators = cooperators;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCooperators != null)
            return mCooperators.size();
        else return 0;
    }
}
