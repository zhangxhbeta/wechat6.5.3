package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int eQs = Color.argb(0, 0, 0, 0);
    private ImageButton eQA;
    private final ArrayList<b> eQt = new ArrayList();
    private c eQu;
    a eQv;
    private int eQw;
    private boolean eQx;
    private int eQy = -1;
    private int eQz = -1;
    private final Paint ft = new Paint();

    public interface a {
        void cq(boolean z);
    }

    private static class b {
        public int color;
        public Rect rect;

        public b(Rect rect, int i) {
            this.rect = rect;
            this.color = i;
        }
    }

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.eQu = new c(this);
        this.ft.setStyle(Style.FILL);
        this.eQw = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(2130903375, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.eQA = (ImageButton) findViewById(2131756324);
        this.eQA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LargeTouchableAreasItemView eQB;

            {
                this.eQB = r1;
            }

            public final void onClick(View view) {
                this.eQB.cp(!this.eQB.eQx);
                if (this.eQB.eQv != null) {
                    this.eQB.eQv.cq(this.eQB.eQx);
                }
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != this.eQy || i6 != this.eQz) {
            this.eQy = i5;
            this.eQz = i6;
            c cVar = this.eQu;
            if (cVar.eUl != null) {
                cVar.eUl.clear();
            }
            cVar.eUm = null;
            Rect rect = new Rect((i5 - this.eQA.getWidth()) - this.eQw, 0, i5, i6);
            i5 = eQs;
            View view = this.eQA;
            c cVar2 = this.eQu;
            TouchDelegate touchDelegate = new TouchDelegate(rect, view);
            if (cVar2.eUl == null) {
                cVar2.eUl = new ArrayList();
            }
            cVar2.eUl.add(touchDelegate);
            this.eQt.add(new b(rect, i5));
            setTouchDelegate(this.eQu);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Iterator it = this.eQt.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.ft.setColor(bVar.color);
            canvas.drawRect(bVar.rect, this.ft);
        }
        super.dispatchDraw(canvas);
    }

    public final void cp(boolean z) {
        if (this.eQx != z) {
            this.eQx = z;
            this.eQA.setImageResource(this.eQx ? 2131165400 : 2131165403);
        }
    }
}
