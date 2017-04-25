package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView hWB;
    private int hWC;
    private Bitmap hWD;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWB = null;
        this.hWC = -1;
        this.hWD = null;
        setLayoutResource(2130903996);
        setWidgetLayoutResource(0);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904070, viewGroup2);
        return onCreateView;
    }

    public final void r(Bitmap bitmap) {
        this.hWD = bitmap;
        if (this.hWB != null) {
            this.hWB.setImageBitmap(bitmap);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hWB = (ImageView) view.findViewById(2131758295);
        if (this.hWB != null) {
            this.hWB.setVisibility(8);
            if (this.hWC != -1) {
                this.hWB.setImageResource(this.hWC);
                this.hWB.setVisibility(0);
            } else if (this.hWD != null) {
                this.hWB.setImageBitmap(this.hWD);
                this.hWB.setVisibility(0);
            }
        }
    }
}
