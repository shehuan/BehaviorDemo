package com.othershe.behaviortest.extend;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

public class FollowTitleBehavior extends CoordinatorLayout.Behavior<View> {
    /**
     * 需要移动的距离
     */
    int deltaY;

    public FollowTitleBehavior() {
    }

    public FollowTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    //被观察的view发生改变时回调
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //依赖view: dependency;

        float navigationViewY = dependency.getY() - dp2px(parent.getContext(), 40);

        //依赖view navigationViewY >= 自身高度. 显示完整  child.setTranslationY(0);
        //依赖view navigationViewY < 自身高度. 向上移动. (自身高度-view.getY());
        //依赖view navigationViewY <0; 不移动

        Log.d("lzl", "==onDependentViewChanged(); dependency_y: " + dependency.getY() + " child_height:" + child.getHeight());

        if (navigationViewY <= 0) {
            child.setTranslationY(0 - child.getHeight());
            return true;
        }
        if (navigationViewY < child.getHeight()) {
            child.setTranslationY(navigationViewY - child.getHeight());
        } else {
            child.setTranslationY(0);
        }
        return true;
    }

    /**
     * dp 2 px
     */
    public int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }
}
