package com.gosuncn.mydatabindingdemo.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gosuncn.mydatabindingdemo.R;
import com.gosuncn.mydatabindingdemo.model.User;

/**
 * Created by wing on 2018/5/4 0004.
 * 自定义视图
 *
 */

public class PersonalCard extends LinearLayout{
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mAge;

    public PersonalCard(Context context) {
        this(context, null);
    }

    public PersonalCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PersonalCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.card, this);
        setOrientation(VERTICAL);

        mFirstName = (TextView) findViewById(R.id.firstname);
        mLastName = (TextView) findViewById(R.id.lastname);
        mAge = (TextView) findViewById(R.id.age);
    }

    // 自动 Setter
    public void setObject(User user) {
        mFirstName.setText(user.getFirstName());
        mLastName.setText(user.getLastName());
        mAge.setText(String.valueOf(user.getAge()));
    }
}
