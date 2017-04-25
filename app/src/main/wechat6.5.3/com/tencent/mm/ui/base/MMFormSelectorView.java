package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;

public class MMFormSelectorView extends LinearLayout {
    private TextView dtY;
    private EditText idd;
    private String lPG;
    private int layout;
    private Context mContext;
    private String title;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPg, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            this.lPG = context.getString(resourceId);
        }
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.dtY = (TextView) findViewById(2131755226);
        this.idd = (EditText) findViewById(2131755280);
        if (this.dtY == null || this.idd == null) {
            v.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[]{this.dtY, this.idd});
            return;
        }
        if (this.title != null) {
            this.dtY.setText(this.title);
        }
        if (this.lPG != null) {
            this.idd.setHint(this.lPG);
        }
    }
}
