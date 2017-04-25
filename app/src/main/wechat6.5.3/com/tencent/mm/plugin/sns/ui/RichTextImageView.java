package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class RichTextImageView extends LinearLayout {
    private Activity bij;
    private TextView dtB;
    private ImageView hiF;
    private TextView jFb;
    private TextView jJx;
    private boolean jJy = false;
    private String jJz;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bij = (Activity) context;
        View inflate = inflate(this.bij, 2130904490, this);
        this.jFb = (TextView) inflate.findViewById(2131759415);
        this.dtB = (TextView) inflate.findViewById(2131759414);
        this.jJx = (TextView) inflate.findViewById(2131759450);
        this.hiF = (ImageView) inflate.findViewById(2131759412);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.jJy && this.jJz != null) {
            v.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.jFb.getHeight() + " LineHeight:" + this.jFb.getLineHeight());
            int height = this.jFb.getHeight() / this.jFb.getLineHeight();
            int lineCount = this.jFb.getLineCount();
            Rect rect = new Rect();
            int i5 = 0;
            int i6 = 0;
            while (i5 < height) {
                try {
                    this.jFb.getLineBounds(i5, rect);
                    i6 += rect.height();
                    if (i6 > this.jFb.getHeight()) {
                        break;
                    }
                    i5++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
            if (lineCount >= i5 && this.jJy) {
                if (i5 <= 0) {
                    i5 = 1;
                }
                i5 = this.jFb.getLayout().getLineVisibleEnd(i5 - 1);
                v.e("test", "bottomH:" + this.jJx.getHeight() + "length" + this.jJz.substring(i5, this.jJz.length()).length());
                v.e("test", "bottomH:" + this.jJx.getHeight());
                if (this.jJx.getText().length() > 0) {
                    this.jJx.setVisibility(0);
                    this.jJy = false;
                    new ac().post(new Runnable(this) {
                        final /* synthetic */ RichTextImageView jJB;

                        public final void run() {
                            this.jJB.jFb.setText(this.jJB.jJz.substring(0, i5));
                            this.jJB.jJx.setText(this.jJB.jJz.substring(i5, this.jJB.jJz.length()));
                            this.jJB.jJx.invalidate();
                            this.jJB.jJy = false;
                            v.e("test", "bottomH:" + this.jJB.jJx.getHeight());
                        }
                    });
                }
                v.e("test", "bottom:" + i4 + "   mesH:" + this.jJx.getMeasuredHeight());
            }
        }
    }
}
