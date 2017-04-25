package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;

public class ConversationOverscrollListView extends ListView implements OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener, com.tencent.mm.sdk.platformtools.ah.a {
    private static final boolean iXZ = d.dY(10);
    private int Ad = 0;
    private OnItemClickListener Xp;
    private OnItemSelectedListener Xq;
    private ah dwn;
    private Rect fu = new Rect();
    private c oKM = new c();
    private a oKN;
    private boolean oKO = false;
    private int oKP = 0;
    private int oKQ = 0;
    private float oKR = 0.0f;
    private long oKS = 1;
    private final float oKT = 3.5f;
    private final float oKU = 13.5f;
    private float oKV = 0.0f;
    private b oKW = new b(this);
    private final int oKX = 50;
    private OnItemLongClickListener oKY;

    public interface a {
        boolean bIg();
    }

    public class b implements Runnable {
        final /* synthetic */ ConversationOverscrollListView oKZ;

        public b(ConversationOverscrollListView conversationOverscrollListView) {
            this.oKZ = conversationOverscrollListView;
        }

        public final void run() {
            if (this.oKZ.oKN != null && !this.oKZ.oKN.bIg()) {
                v.d("MicroMsg.ConversationOverscrollListView", "jacks cancel to Show Main");
                this.oKZ.oKN;
            }
        }
    }

    private static class c implements Interpolator {
        private float ijz = 1.3f;

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            f2 = (((f2 * (this.ijz + 1.0f)) + this.ijz) * (f2 * f2)) + 1.0f;
            if (f2 > 1.0f) {
                return 1.0f;
            }
            return f2;
        }
    }

    public ConversationOverscrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        this.dwn = new ah(this, false);
    }

    @TargetApi(11)
    protected void onFinishInflate() {
    }

    @TargetApi(11)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.Xp = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.oKY = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Xq = onItemSelectedListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.oKO = true;
        if (this.Xp != null) {
            this.Xp.onItemClick(adapterView, view, i, j);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.oKO = true;
        if (this.Xq != null) {
            this.Xq.onItemSelected(adapterView, view, i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        if (this.Xq != null) {
            this.Xq.onNothingSelected(adapterView);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.oKO = true;
        if (this.oKY != null) {
            return this.oKY.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }

    public final boolean oU() {
        return false;
    }
}
