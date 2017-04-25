package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView extends FrameLayout {
    private c fgM;
    private TextView kpu;
    private float lOW = 1.5f;
    private int lOX;
    private int lOY;
    private int lOZ;
    public ChattingEmojiView lPa;
    private ProgressBar lPb;
    private LayoutParams lPc;
    private long lPd;
    private int mStatus = -1;

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aeG();
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aeG();
    }

    private void aeG() {
        this.lOW = getResources().getDisplayMetrics().scaledDensity / 1.5f;
        if (this.lOW < 1.0f) {
            this.lOW = 1.0f;
        }
        v.i("MicroMsg.emoji.RTChattingEmojiView", "mScaleDesity" + this.lOW);
        this.lOX = getContext().getResources().getDimensionPixelSize(2131493447);
        this.lOY = getContext().getResources().getDimensionPixelSize(2131493446);
        this.lOZ = getContext().getResources().getDimensionPixelSize(2131493448);
        this.lPa = new ChattingEmojiView(getContext());
        this.lPb = new ProgressBar(getContext());
        this.lPb.setIndeterminateDrawable(getResources().getDrawable(2130838933));
        this.kpu = new TextView(getContext());
        Drawable drawable = getResources().getDrawable(2130838154);
        drawable.setBounds(0, 0, this.lOZ, this.lOZ);
        this.kpu.setCompoundDrawables(null, drawable, null, null);
        this.kpu.setText(2131232357);
        this.kpu.setTextColor(getResources().getColor(2131689684));
        this.lPc = new LayoutParams(-2, -2);
        this.lPc.gravity = 17;
        addView(this.lPb, this.lPc);
        addView(this.kpu, this.lPc);
        addView(this.lPa, this.lPc);
    }

    public final void a(c cVar, long j) {
        a(cVar, j, new ag(SQLiteDatabase.KeyEmpty));
    }

    public final void a(c cVar, long j, ag agVar) {
        v.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
        this.fgM = cVar;
        this.lPd = j;
        if (this.fgM.bnk()) {
            boolean z;
            uq(2);
            MMGIFImageView mMGIFImageView = this.lPa;
            if (agVar.dhD) {
                z = false;
            } else {
                z = true;
            }
            int e = a.bmr().e(cVar);
            int[] f = a.bmr().f(cVar);
            String name = cVar.getName();
            String valueOf = String.valueOf(j + cVar.getName());
            Drawable cVar2;
            if (be.kS(valueOf)) {
                cVar2 = new com.tencent.mm.plugin.gif.c(mMGIFImageView.getContext(), false, z, e, f, name);
                cVar2.start();
                mMGIFImageView.setImageDrawable(cVar2);
                return;
            }
            mMGIFImageView.eZd = valueOf;
            b atw = b.atw();
            Context context = mMGIFImageView.getContext();
            if (TextUtils.isEmpty(name)) {
                cVar2 = null;
            } else {
                if (atw.gCP.get(valueOf) == null || ((WeakReference) atw.gCP.get(valueOf)).get() == null) {
                    cVar2 = null;
                } else {
                    cVar2 = (com.tencent.mm.plugin.gif.c) ((WeakReference) atw.gCP.get(valueOf)).get();
                }
                if (cVar2 == null) {
                    cVar2 = new com.tencent.mm.plugin.gif.c(context, false, z, e, f, name);
                    atw.gCP.put(valueOf, new WeakReference(cVar2));
                }
            }
            if (z == cVar2.gCX) {
                cVar2.start();
            } else {
                cVar2.fqz = 0;
                cVar2.gCZ = 0;
                cVar2.gCX = true;
                cVar2.start();
            }
            mMGIFImageView.setImageDrawable(cVar2);
        } else if (this.fgM.bxG()) {
            uq(2);
            this.lPa.a(c.ba(getContext(), cVar.getName()), String.valueOf(j));
        } else {
            String dR = this.fgM.dR(this.fgM.field_groupId, this.fgM.EB());
            if (e.aR(dR)) {
                uq(2);
                byte[] c = e.c(dR, 0, 10);
                if (c == null || o.bf(c)) {
                    this.lPa.bM(dR, String.valueOf(j));
                    return;
                } else {
                    this.lPa.a(this.fgM, a.bmr().g(this.fgM), String.valueOf(j));
                    return;
                }
            }
            int i;
            if (cVar.field_state == c.nxc) {
                uq(0);
                bqA();
            } else {
                uq(3);
                bqA();
            }
            if (this.fgM == null || this.fgM.field_height == 0) {
                i = this.lOY;
            } else {
                i = (int) (((float) this.fgM.field_height) * this.lOW);
                if (i <= this.lOY) {
                    i = this.lOY;
                }
            }
            setMeasuredDimension(this.lOX, i);
            this.lPa.setImageBitmap(null);
        }
    }

    public final void setImageBitmap(Bitmap bitmap) {
        uq(2);
        if (this.lPa != null && bitmap != null && !bitmap.isRecycled()) {
            this.lPa.setImageBitmap(bitmap);
        }
    }

    public boolean performClick() {
        if (this.mStatus == 3) {
            uq(1);
            bqA();
            return true;
        } else if (this.mStatus == 2) {
            return super.performClick();
        } else {
            v.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            return true;
        }
    }

    private void bqA() {
        com.tencent.mm.sdk.c.b bvVar = new bv();
        bvVar.aZp.aZq = this.fgM;
        bvVar.aZp.scene = 0;
        com.tencent.mm.sdk.c.a.nhr.z(bvVar);
    }

    private void uq(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                this.lPb.setVisibility(0);
                this.kpu.setVisibility(4);
                this.lPa.setVisibility(4);
                setBackgroundResource(2130839576);
                return;
            case 1:
                this.lPb.setVisibility(0);
                this.kpu.setVisibility(4);
                this.lPa.setVisibility(4);
                setBackgroundResource(2130837999);
                return;
            case 2:
                this.lPa.setVisibility(0);
                this.lPb.setVisibility(4);
                this.kpu.setVisibility(4);
                setBackgroundResource(2130839576);
                return;
            case 3:
                this.kpu.setVisibility(0);
                this.lPb.setVisibility(4);
                this.lPa.setVisibility(4);
                setBackgroundResource(2130837999);
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            int i3;
            if (this.fgM == null || this.fgM.field_height == 0) {
                i3 = this.lOY;
            } else {
                i3 = (int) (((float) this.fgM.field_height) * this.lOW);
                if (i3 <= this.lOY) {
                    i3 = this.lOY;
                }
            }
            int i4 = this.lOX;
            setMeasuredDimension(i4, i3);
            i = MeasureSpec.makeMeasureSpec(i4, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
