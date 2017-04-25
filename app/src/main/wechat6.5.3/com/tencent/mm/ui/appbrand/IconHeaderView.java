package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

public class IconHeaderView extends LinearLayout {
    private View nPF;
    private TextView nPH;
    public ImageView nPI;
    private TextView pRK;

    public IconHeaderView(Context context) {
        super(context);
        init();
    }

    public IconHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IconHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        inflate(getContext(), 2130903129, this);
        this.nPF = findViewById(2131755448);
        this.nPI = (ImageView) findViewById(2131755449);
        this.nPH = (TextView) findViewById(2131755450);
        this.pRK = (TextView) findViewById(2131760118);
        F(SQLiteDatabase.KeyEmpty);
        j(null);
    }

    public final void j(OnClickListener onClickListener) {
        boolean z = true;
        if (this.nPF != null) {
            boolean z2;
            this.nPF.setOnClickListener(onClickListener);
            View view = this.nPF;
            if (onClickListener != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            view.setClickable(z2);
            View view2 = this.nPF;
            if (onClickListener == null) {
                z = false;
            }
            view2.setLongClickable(z);
            this.nPF.setBackgroundDrawable(onClickListener != null ? getResources().getDrawable(2130839086) : null);
        }
    }

    public final void J(CharSequence charSequence) {
        if (this.nPH != null) {
            this.nPH.setText(charSequence);
        }
    }

    public final void F(CharSequence charSequence) {
        if (this.pRK != null) {
            this.pRK.setText(charSequence);
            this.pRK.setVisibility(be.D(this.pRK.getText()) ? 8 : 0);
        }
    }
}
