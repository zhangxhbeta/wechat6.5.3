package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ListMenuItemView extends LinearLayout implements a {
    private LayoutInflater CE;
    private TextView EI;
    private RadioButton Pg;
    private CheckBox Ph;
    private TextView Pi;
    private Drawable Pj;
    private Context Pk;
    boolean Pl;
    private int Pm;
    boolean Pn;
    private h dQ;
    private int dZ;
    private ImageView kH;
    private Context mContext;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.cn, i, 0);
        this.Pj = obtainStyledAttributes.getDrawable(k.LQ);
        this.dZ = obtainStyledAttributes.getResourceId(k.LR, -1);
        this.Pl = obtainStyledAttributes.getBoolean(k.LS, false);
        this.Pk = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.Pj);
        this.EI = (TextView) findViewById(f.title);
        if (this.dZ != -1) {
            this.EI.setTextAppearance(this.Pk, this.dZ);
        }
        this.Pi = (TextView) findViewById(f.JA);
    }

    public final void a(h hVar) {
        int i;
        boolean z;
        this.dQ = hVar;
        this.Pm = 0;
        setVisibility(hVar.isVisible() ? 0 : 8);
        CharSequence a = hVar.a((a) this);
        if (a != null) {
            this.EI.setText(a);
            if (this.EI.getVisibility() != 0) {
                this.EI.setVisibility(0);
            }
        } else if (this.EI.getVisibility() != 8) {
            this.EI.setVisibility(8);
        }
        boolean isCheckable = hVar.isCheckable();
        if (!(!isCheckable && this.Pg == null && this.Ph == null)) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.dQ.dL()) {
                if (this.Pg == null) {
                    this.Pg = (RadioButton) dv().inflate(h.JT, this, false);
                    addView(this.Pg);
                }
                compoundButton = this.Pg;
                compoundButton2 = this.Ph;
            } else {
                if (this.Ph == null) {
                    this.Ph = (CheckBox) dv().inflate(h.JQ, this, false);
                    addView(this.Ph);
                }
                compoundButton = this.Ph;
                compoundButton2 = this.Pg;
            }
            if (isCheckable) {
                compoundButton.setChecked(this.dQ.isChecked());
                int i2 = isCheckable ? 0 : 8;
                if (compoundButton.getVisibility() != i2) {
                    compoundButton.setVisibility(i2);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility() == 8)) {
                    compoundButton2.setVisibility(8);
                }
            } else {
                if (this.Ph != null) {
                    this.Ph.setVisibility(8);
                }
                if (this.Pg != null) {
                    this.Pg.setVisibility(8);
                }
            }
        }
        boolean dK = hVar.dK();
        hVar.dJ();
        if (dK && this.dQ.dK()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            TextView textView = this.Pi;
            char dJ = this.dQ.dJ();
            if (dJ == '\u0000') {
                a = SQLiteDatabase.KeyEmpty;
            } else {
                StringBuilder stringBuilder = new StringBuilder(h.Qb);
                switch (dJ) {
                    case '\b':
                        stringBuilder.append(h.Qd);
                        break;
                    case '\n':
                        stringBuilder.append(h.Qc);
                        break;
                    case FileUtils.S_IRGRP /*32*/:
                        stringBuilder.append(h.Qe);
                        break;
                    default:
                        stringBuilder.append(dJ);
                        break;
                }
                a = stringBuilder.toString();
            }
            textView.setText(a);
        }
        if (this.Pi.getVisibility() != i) {
            this.Pi.setVisibility(i);
        }
        Drawable icon = hVar.getIcon();
        if (this.dQ.dV.PK || this.Pn) {
            z = true;
        } else {
            z = false;
        }
        if ((z || this.Pl) && !(this.kH == null && icon == null && !this.Pl)) {
            if (this.kH == null) {
                this.kH = (ImageView) dv().inflate(h.JR, this, false);
                addView(this.kH, 0);
            }
            if (icon != null || this.Pl) {
                this.kH.setImageDrawable(z ? icon : null);
                if (this.kH.getVisibility() != 0) {
                    this.kH.setVisibility(0);
                }
            } else {
                this.kH.setVisibility(8);
            }
        }
        setEnabled(hVar.isEnabled());
    }

    public final h C() {
        return this.dQ;
    }

    protected void onMeasure(int i, int i2) {
        if (this.kH != null && this.Pl) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kH.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public final boolean D() {
        return false;
    }

    private LayoutInflater dv() {
        if (this.CE == null) {
            this.CE = LayoutInflater.from(this.mContext);
        }
        return this.CE;
    }
}
