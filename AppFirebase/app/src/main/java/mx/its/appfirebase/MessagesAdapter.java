package mx.its.appfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.Query;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MessagesAdapter extends FirebaseRecyclerAdapter<MessagesAdapter.ViewHolder, Message> {

    private final Context context;

    public MessagesAdapter(Context context, Query query, Class<Message> itemClass, ArrayList<Message> items, ArrayList<String> keys) {
        super(query, itemClass, items, keys);
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage,txtUser,txtAgo;

        public ViewHolder(View view) {
            super(view);
            txtMessage = view.findViewById(R.id.txtMessage);
            txtUser = view.findViewById(R.id.txtUser);
            txtAgo = view.findViewById(R.id.txtAgo);
        }


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message m = getItem(position);
        String key = getKeys().get(position);
        holder.txtUser.setText(m.getEmail());
        holder.txtMessage.setText(m.getMessage());
        holder.txtAgo.setText(Helper.getTimeAgo(m.getCreationDateLong()));
    }

    @Override
    protected void itemAdded(Message item, String key, int position) {

    }

    @Override
    protected void itemChanged(Message oldItem, Message newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Message item, String key, int position) {

    }

    @Override
    protected void itemMoved(Message item, String key, int oldPosition, int newPosition) {

    }

}
