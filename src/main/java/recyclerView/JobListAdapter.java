package recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.besnault.coopup.R;

import java.util.List;

import entities.Job;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JobViewHolder> {

    class JobViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobItemView;

        private JobViewHolder (View itemView){
            super(itemView);
            jobItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Job> mJobs;

    JobListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new JobViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        if (mJobs != null) {
            Job current = mJobs.get(position);
            holder.jobItemView.setText("Il n'y a pas de métier disponible.");
        }
    }

    void setJobs(List<Job> jobs) {
        mJobs = jobs;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mJobs != null)
            return mJobs.size();
        else return 0;
    }
}
