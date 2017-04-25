package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private String bde;
    private String boC;
    private Context context;
    private ac handler = new ac(Looper.getMainLooper());
    private int jDY = 0;
    protected SnsPostDescPreloadTextView jEL;
    protected SnsTextView jEM;
    protected TextView jEN;
    private boolean jEO = true;
    private String jEP;
    private String jEQ;
    private HashMap<String, Integer> jER;
    private Runnable jES = new Runnable(this) {
        final /* synthetic */ CollapsibleTextView jET;

        {
            this.jET = r1;
        }

        public final void run() {
            if (this.jET.jEL != null && (this.jET.jEL.getTag() instanceof ap) && ((ap) this.jET.jEL.getTag()).boC.equals(this.jET.boC)) {
                this.jET.jEL.setMaxLines(6);
                this.jET.jEN.setVisibility(0);
                this.jET.jEN.setText(this.jET.jEP);
            }
        }
    };
    private boolean jdE = false;
    private CharSequence text;

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.jEP = this.context.getString(2131235390);
        this.jEQ = this.context.getString(2131235389);
        View inflate = q.em(this.context).inflate(2130903383, this);
        inflate.setPadding(0, -3, 0, 0);
        this.jEL = (SnsPostDescPreloadTextView) inflate.findViewById(2131755458);
        this.jEN = (TextView) inflate.findViewById(2131756359);
        this.jEM = (SnsTextView) inflate.findViewById(2131756358);
    }

    public final void a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, as asVar, String str3, boolean z) {
        this.context = asVar.aWn;
        this.jER = hashMap;
        this.text = charSequence;
        this.jdE = z;
        this.bde = str;
        this.boC = str2;
        this.jDY = i;
        this.jEP = this.context.getString(2131235390);
        this.jEQ = this.context.getString(2131235389);
        this.jEM.gVC = str3;
        ap apVar = new ap(this.boC, this.bde, false, false, 1);
        if (i == 0) {
            this.jEL.setText(str3);
            this.jEM.setVisibility(8);
            this.jEN.setVisibility(0);
            this.jEL.setVisibility(0);
            this.jEL.setOnTouchListener(new h(this.context));
            this.jEL.setTag(apVar);
            if (hashMap.get(str) == null) {
                this.jEO = false;
                this.jEN.setVisibility(8);
                this.jEL.setMaxLines(7);
                return;
            }
            this.jEO = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.jEN.setVisibility(8);
                    return;
                case 1:
                    this.jEL.setMaxLines(6);
                    this.jEN.setVisibility(0);
                    this.jEN.setText(this.jEP);
                    return;
                case 2:
                    this.jEL.setMaxLines(Integer.MAX_VALUE);
                    this.jEN.setVisibility(0);
                    this.jEN.setText(this.jEQ);
                    return;
                default:
                    return;
            }
        }
        this.jEM.setText(charSequence, bufferType);
        this.jEM.setTag(apVar);
        this.jEM.setVisibility(0);
        this.jEN.setVisibility(8);
        this.jEL.setVisibility(8);
        this.jEM.setOnClickListener(asVar.joV.kbO);
    }

    public final int aVx() {
        v.i("MicroMsg.CollapsibleTextView", "count:" + this.jEL.getLineCount() + "  height:" + this.jEL.getLineHeight());
        return (this.jEL.getLineCount() - 6) * this.jEL.getLineHeight();
    }

    public final void e(OnClickListener onClickListener) {
        if (this.jEN != null) {
            this.jEN.setOnClickListener(onClickListener);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.jDY == 0 && !this.jdE && !this.jEO) {
            this.jEO = true;
            if (this.jEL.getLineCount() <= 6) {
                this.jER.put(this.bde, Integer.valueOf(0));
                return;
            }
            this.jER.put(this.bde, Integer.valueOf(1));
            this.handler.post(this.jES);
        }
    }
}
