package recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.besnault.coopup.R;

import java.util.List;

import entities.Comment;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.CommentViewHolder> {

   class CommentViewHolder extends RecyclerView.ViewHolder {
       private final TextView commentItemView;

       private CommentViewHolder(View itemView) {
           super(itemView);
           commentItemView = itemView.findViewById(R.id.textView);
       }
   }

   private final LayoutInflater mInflater;
   private List<Comment> mComments;

   CommentListAdapter(Context context) {
       mInflater = LayoutInflater.from(context);
   }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
       if (mComments != null){
           Comment current = mComments.get(position);
           holder.commentItemView.setText("Il n'y a pas de commentaire disponible.");
       }
    }

    void setComments(List<Comment> comments){
       mComments = comments;
       notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
       if (mComments != null)
           return mComments.size();
       else return 0;
    }
}
