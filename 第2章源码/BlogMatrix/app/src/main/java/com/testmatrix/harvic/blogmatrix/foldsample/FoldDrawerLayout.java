package com.testmatrix.harvic.blogmatrix.foldsample;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

public class FoldDrawerLayout extends DrawerLayout {
    public FoldDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            if (isDrawerView(child)) {
                LayoutParams layPar = ((LayoutParams) child.getLayoutParams());
                PolyToPolySample6View foldlayout = new PolyToPolySample6View(getContext());
                removeView(child);
                foldlayout.addView(child);
                addView(foldlayout, i, layPar);
            }

        }
        setDrawerListener(new DrawerListener() {

            @Override
            public void onDrawerStateChanged(int arg0) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (drawerView instanceof PolyToPolySample6View) {
                    PolyToPolySample6View foldLayout = ((PolyToPolySample6View) drawerView);
                    foldLayout.setFactor(slideOffset);
                }

            }

            @Override
            public void onDrawerOpened(View arg0) {
            }

            @Override
            public void onDrawerClosed(View arg0) {
            }
        });

    }

    boolean isDrawerView(View child) {
        final int gravity = ((LayoutParams) child.getLayoutParams()).gravity;
        final int absGravity = GravityCompat.getAbsoluteGravity(gravity,
                ViewCompat.getLayoutDirection(child));
        return (absGravity & (Gravity.LEFT | Gravity.RIGHT)) != 0;
    }
}
