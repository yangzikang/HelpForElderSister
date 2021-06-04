package yzk.help;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LittleVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<VideoBean> list = new ArrayList<>();
    public Context context;

    public void setList(List<VideoBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void appendList(List<VideoBean> appendList) {
        this.list.addAll(appendList);
        notifyDataSetChanged();
    }

    public List<VideoBean> getList() {
        return list;
    }

    public LittleVideoAdapter(Context context) {
        this.context = context;
    }

    @androidx.annotation.NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        return new LittleVideoHolder(LayoutInflater.from(context).inflate(R.layout.item_little_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull RecyclerView.ViewHolder holder, int position) {
        if (position + 1 < list.size() - 1) { //预加载下一张 我的下下策，老姐请忽略
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            imagePipeline.prefetchToDiskCache(ImageRequest.fromUri(Uri.parse(list.get(position + 1).getThumb())), context);
        }
        if (holder instanceof LittleVideoHolder) {
            ((LittleVideoHolder) holder).imageView.setImageURI(Uri.parse(list.get(position).getThumb()));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class LittleVideoHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView imageView;
        public FrameLayout frameLayout;

        public LittleVideoHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.first_picture_sdv);
            frameLayout = itemView.findViewById(R.id.content_layout);
        }
    }
}
