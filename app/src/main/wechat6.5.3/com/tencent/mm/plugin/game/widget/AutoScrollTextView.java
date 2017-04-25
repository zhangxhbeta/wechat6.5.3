package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import java.util.ArrayList;

public class AutoScrollTextView extends LinearLayout {
    private int fqz = 0;
    private ah gpC = new ah(new a(this) {
        final /* synthetic */ AutoScrollTextView gzY;

        {
            this.gzY = r1;
        }

        public final boolean oU() {
            AutoScrollTextView.a(this.gzY);
            return true;
        }
    }, true);
    private ArrayList<String> gqO = new ArrayList();
    private Animation gqV;
    private Animation gqW;
    private TextView gzW;
    private TextView gzX;

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        if (autoScrollTextView.gqO.size() >= 2) {
            CharSequence charSequence;
            if (autoScrollTextView.fqz < autoScrollTextView.gqO.size() - 1) {
                autoScrollTextView.fqz++;
                charSequence = (String) autoScrollTextView.gqO.get(autoScrollTextView.fqz);
            } else {
                autoScrollTextView.fqz = 0;
                String str = (String) autoScrollTextView.gqO.get(autoScrollTextView.fqz);
            }
            TextView textView = autoScrollTextView.gzX;
            textView.setText(new SpannableString(e.a(autoScrollTextView.getContext(), charSequence, textView.getTextSize())));
            autoScrollTextView.gzW.startAnimation(autoScrollTextView.gqW);
            autoScrollTextView.gzW.setVisibility(8);
            autoScrollTextView.gzX.startAnimation(autoScrollTextView.gqV);
            autoScrollTextView.gzX.setVisibility(0);
            TextView textView2 = autoScrollTextView.gzW;
            autoScrollTextView.gzW = autoScrollTextView.gzX;
            autoScrollTextView.gzX = textView2;
        }
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzW = new TextView(context, attributeSet);
        this.gzW.setVisibility(8);
        this.gzX = new TextView(context, attributeSet);
        this.gzX.setVisibility(8);
        addView(this.gzW);
        addView(this.gzX);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.gqV = AnimationUtils.loadAnimation(context, 2130968675);
        this.gqW = AnimationUtils.loadAnimation(context, 2130968683);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gpC.QI();
    }
}
