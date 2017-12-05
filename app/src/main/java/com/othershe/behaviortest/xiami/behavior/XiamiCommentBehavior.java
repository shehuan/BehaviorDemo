package com.othershe.behaviortest.xiami.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.othershe.behaviortest.R;
import com.othershe.behaviortest.source.HeaderScrollingViewBehavior;

import java.util.List;

/**
 * 列表Behavior
 */
public class XiamiCommentBehavior extends HeaderScrollingViewBehavior {
    private Context mContext;

    public XiamiCommentBehavior() {
    }

    public XiamiCommentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDependOn(dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float commentScrollY = dependency.getTranslationY() / getHeaderOffset() * (dependency.getHeight() - getTitleHeight());
        float y = dependency.getHeight() - commentScrollY;
        child.setY(y);
        return true;
    }

    @Override
    protected View findFirstDependency(List<View> views) {
        for (int i = 0, z = views.size(); i < z; i++) {
            View view = views.get(i);
            if (isDependOn(view))
                return view;
        }
        return null;
    }

    /**
     * 计算content的最大向上偏移距离
     *
     * @param v
     * @return
     */
    @Override
    protected int getScrollRange(View v) {
        if (isDependOn(v)) {
            return Math.max(0, v.getMeasuredHeight() - getTitleHeight());
        } else {
            return super.getScrollRange(v);
        }
    }

    private int getHeaderOffset() {
        return mContext.getResources().getDimensionPixelOffset(R.dimen.header_offset);
    }

    private int getTitleHeight() {
        return mContext.getResources().getDimensionPixelOffset(R.dimen.xiami_title_height);
    }


    private boolean isDependOn(View dependency) {
        return dependency != null && dependency.getId() == R.id.header;
    }
}
