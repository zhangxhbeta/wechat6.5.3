package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class TranslateCommentTextView extends LinearLayout {
    public SnsTranslateResultView jNO;
    public MaskTextView jZz;

    public TranslateCommentTextView(Context context) {
        super(context);
        init();
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(2130904543, this);
        this.jZz = (MaskTextView) findViewById(2131759564);
        this.jNO = (SnsTranslateResultView) findViewById(2131759300);
        this.jNO.setVisibility(8);
    }
}
