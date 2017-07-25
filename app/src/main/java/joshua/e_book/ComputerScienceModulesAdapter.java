package joshua.e_book;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by OLUWASONA on 30/12/2016.
 */
public class ComputerScienceModulesAdapter extends RecyclerView.Adapter<ComputerScienceModulesAdapter.MyViewHolder> {
    private static ClickListener clickListener;
    private Context mContext;
    private List<ComputerScienceModules> modulesList;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView moduleNamesView;
        public ImageView moduleImagesView;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            moduleNamesView = (TextView) itemView.findViewById(R.id.ModuleName);
            moduleImagesView = (ImageView) itemView.findViewById(R.id.ModuleImageView);
        }

        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ComputerScienceModulesAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    public ComputerScienceModulesAdapter(Context mContext, List<ComputerScienceModules> modulesList) {
        this.mContext = mContext;
        this.modulesList = modulesList;
    }

    @Override
    public ComputerScienceModulesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComputerScienceModulesAdapter.MyViewHolder holder, int position) {
        ComputerScienceModules computerScienceModules = modulesList.get(position);
        holder.moduleNamesView.setText((computerScienceModules.getModuleName()));

        Glide.with(mContext).load(computerScienceModules.getModuleImage()).into(holder.moduleImagesView);
    }

    @Override
    public int getItemCount() {
        return modulesList.size();
    }
}
