package yzk.help;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class PagerLayoutManager extends LinearLayoutManager {

    private PagerSnapHelper mSnapHelper;

    public PagerLayoutManager(Context context) {
        super(context);
        mSnapHelper = new PagerSnapHelper();
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        mSnapHelper.attachToRecyclerView(view);
    }

    /**
     * https://blog.csdn.net/smileiam/article/details/88396546
     * 老姐牛逼
     * @param state
     * @return
     */
    @Override
    public int getExtraLayoutSpace(RecyclerView.State state) {
        return 400;
    }
}
