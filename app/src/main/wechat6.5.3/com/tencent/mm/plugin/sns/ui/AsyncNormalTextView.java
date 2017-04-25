package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;

public class AsyncNormalTextView extends CollapsibleTextView {
    public String content;
    private Context context;
    private c jDX;
    public int jDY = 0;
    public av jDZ;
    public as jpB;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void c(c cVar) {
        this.jDX = cVar;
        aVo();
    }

    public final void aVo() {
        if (!be.kS(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.jDY == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.jDY, new SpannableStringBuilder(e.a(this.context, this.content, this.jEL.getTextSize())), BufferType.NORMAL, this.jpB.jER, this.jDZ.jFt, this.jDZ.jWu, this.jpB, this.content, this.jDZ.jEb);
            } else if (this.content.length() < 400 || this.jDZ.jEb) {
                CharSequence charSequence = null;
                if (this.jDZ != null) {
                    charSequence = this.jDZ.jWs;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(e.a(this.context, this.content, this.jEL.getTextSize()));
                }
                a(this.jDY, charSequence, BufferType.SPANNABLE, this.jpB.jER, this.jDZ.jFt, this.jDZ.jWu, this.jpB, this.content, this.jDZ.jEb);
            } else {
                a(this.jDY, this.content, BufferType.NORMAL, this.jpB.jER, this.jDZ.jFt, this.jDZ.jWu, this.jpB, this.content, this.jDZ.jEb);
            }
            ap apVar = new ap(this.jDZ.jWu, this.jDZ.jFt, false, false, 1);
            this.jEL.setTag(apVar);
            if (this.jEM != null) {
                this.jEM.setTag(apVar);
            }
            this.jEN.setTag(this.jDX);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
    }

    public final void setContentWidth(int i) {
        if (this.jEM != null) {
            this.jEL.kci = i;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -2);
            this.jEM.setLayoutParams(layoutParams);
            this.jEL.setLayoutParams(layoutParams);
            this.jEN.setLayoutParams(layoutParams);
        }
    }
}
