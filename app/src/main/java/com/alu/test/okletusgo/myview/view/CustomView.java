package com.alu.test.okletusgo.myview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.alu.test.okletusgo.R;

/**
 * Created by Alu on 2017/5/12.
 * 版本：V1.0
 */

public class CustomView extends View {
    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context) {
        this(context, null);
    }

    /**
     * 获得自定义的样式属性
     *
     * @param context c
     * @param attrs a
     * @param defStyle d
     */
    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyle, 0);
        for(int i = 0; i< typedArray.getIndexCount();i++){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.CustomTitleView_Text:
                    break;
                case R.styleable.CustomTitleView_TextColor:
                    break;
                case R.styleable.CustomTitleView_TextSize:
                    break;
            }
        }
    }
}
