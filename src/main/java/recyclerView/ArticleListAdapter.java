package recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.besnault.coopup.R;

import java.util.List;

import entities.Article;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        private final TextView articleItemView;

        private ArticleViewHolder(View itemView){
            super(itemView);
            articleItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Article> mArticles;

    ArticleListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        if (mArticles != null) {
            Article current = mArticles.get(position);
            holder.articleItemView.setText("Il n'y a pas d'article disponible");
        }
    }

    void setArticles(List<Article> articles) {
        mArticles = articles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mArticles != null)
        return mArticles.size();
        else return 0;
    }
}
