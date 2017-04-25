package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    protected MMActivity eLn;
    private String esV;
    private ImageView fyB;
    private TextView fyC;
    private TextView fyD;
    private TextView fyE;
    private View fyF;
    TextView fyG;
    private boolean[] fyH;
    private OnClickListener[] fyI;
    String fyJ;
    private String fyK;
    private boolean fyL;
    private CharSequence uU;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyH = new boolean[6];
        this.fyI = new OnClickListener[6];
        this.fyL = false;
        this.eLn = (MMActivity) context;
        this.fyL = false;
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyH = new boolean[6];
        this.fyI = new OnClickListener[6];
        this.fyL = false;
        this.eLn = (MMActivity) context;
        this.fyL = false;
    }

    public final void onBindView(View view) {
        v.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.fyB = (ImageView) view.findViewById(2131756803);
        this.fyC = (TextView) view.findViewById(2131756776);
        this.fyD = (TextView) view.findViewById(2131756805);
        this.fyE = (TextView) view.findViewById(2131756806);
        this.fyF = view.findViewById(2131756804);
        this.fyG = (TextView) view.findViewById(2131756807);
        t(this.fyB, 0);
        t(this.fyC, 2);
        t(this.fyD, 1);
        t(this.fyE, 3);
        t(this.fyF, 4);
        t(this.fyG, 5);
        this.fyL = true;
        if (this.fyL) {
            this.fyC.setText(this.uU);
            this.fyE.setText(this.esV);
            this.fyG.setText(this.fyJ);
            cy(this.fyK);
        } else {
            v.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.fyL);
        }
        super.onBindView(view);
    }

    private void t(View view, int i) {
        view.setVisibility(this.fyH[i] ? 8 : 0);
        view.setOnClickListener(this.fyI[i]);
    }

    public final void z(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        switch (i) {
            case 0:
                view = this.fyB;
                break;
            case 1:
                view = this.fyD;
                break;
            case 2:
                view = this.fyC;
                break;
            case 3:
                view = this.fyE;
                break;
            case 4:
                view = this.fyF;
                break;
            case 5:
                view = this.fyG;
                break;
            default:
                return;
        }
        boolean[] zArr = this.fyH;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final void a(int i, OnClickListener onClickListener) {
        View view;
        switch (i) {
            case 0:
                view = this.fyB;
                break;
            case 1:
                view = this.fyD;
                break;
            case 2:
                view = this.fyC;
                break;
            case 3:
                view = this.fyE;
                break;
            case 4:
                view = this.fyF;
                break;
            case 5:
                view = this.fyG;
                break;
            default:
                return;
        }
        this.fyI[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void setName(CharSequence charSequence) {
        this.uU = charSequence;
        if (this.fyC != null) {
            this.fyC.setText(charSequence);
        }
    }

    public final void st(String str) {
        this.esV = str;
        if (this.fyE != null) {
            this.fyE.setText(str);
        }
    }

    public final void cy(String str) {
        this.fyK = str;
        if (this.fyB != null) {
            a aVar = new a();
            Bitmap uU = d.uU(2130838184);
            if (!(uU == null || uU.isRecycled())) {
                uU = d.a(uU, true, 0.5f * ((float) uU.getWidth()));
                if (!(uU == null || uU.isRecycled())) {
                    aVar.cPI = new BitmapDrawable(uU);
                }
            }
            if (uU == null || uU.isRecycled()) {
                aVar.cPH = 2130838184;
            }
            aVar.cPP = true;
            n.GL().a(this.fyK, this.fyB, aVar.GU());
        }
    }
}
