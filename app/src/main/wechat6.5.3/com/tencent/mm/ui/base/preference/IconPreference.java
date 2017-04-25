package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public class IconPreference extends Preference {
    private Context context;
    public Drawable drawable;
    private int fgA;
    private int fgB;
    private int fgC;
    public ImageView fgD;
    private ViewGroup fgE;
    private View fgF;
    public LayoutParams fgG;
    private String fgv;
    private int fgw;
    private int fgx;
    private Bitmap fgy;
    public int fgz;
    private int height;
    private int ocA;
    private TextView ocB;
    private TextView ocC;
    private boolean ocD;
    public boolean ocE;
    private int oct;
    private ImageView ocu;
    private TextView ocv;
    private String ocx;
    private int ocy;
    private int ocz;

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = SQLiteDatabase.KeyEmpty;
        this.fgw = -1;
        this.fgx = 8;
        this.oct = 8;
        this.ocx = SQLiteDatabase.KeyEmpty;
        this.ocy = -1;
        this.ocz = 8;
        this.ocA = -1;
        this.fgy = null;
        this.fgz = -1;
        this.fgA = 8;
        this.fgB = 0;
        this.fgC = 8;
        this.fgD = null;
        this.ocu = null;
        this.fgE = null;
        this.fgF = null;
        this.height = -1;
        this.ocD = false;
        this.ocE = false;
        this.context = context;
        setLayoutResource(2130903996);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904016, viewGroup2);
        return onCreateView;
    }

    public final void aO(String str, int i) {
        this.fgv = str;
        this.fgw = i;
    }

    public final void cc(String str, int i) {
        L(str, i, this.ocA);
    }

    public final void L(String str, int i, int i2) {
        this.ocx = str;
        this.ocy = i;
        this.ocA = i2;
        if (this.ocB != null) {
            this.ocB.setText(str);
            if (i != -1) {
                this.ocB.setBackgroundDrawable(a.a(this.context, i));
            }
            if (i2 != -1) {
                this.ocB.setTextColor(i2);
            }
        }
    }

    public final void wG(int i) {
        this.fgx = i;
        if (this.ocC != null) {
            this.ocC.setVisibility(i);
        }
    }

    public final void wH(int i) {
        this.ocz = i;
        if (this.ocB != null) {
            this.ocB.setVisibility(i);
        }
    }

    public final void jy(boolean z) {
        this.ocD = z;
        if (this.ocB == null) {
            return;
        }
        if (z) {
            this.ocB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839358, 0);
            this.ocB.setCompoundDrawablePadding((int) this.context.getResources().getDimension(2131493199));
            return;
        }
        this.ocB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final void wI(int i) {
        this.oct = i;
        if (this.ocu != null) {
            this.ocu.setVisibility(i);
        }
    }

    public final void J(Bitmap bitmap) {
        this.fgy = bitmap;
        this.fgz = -1;
        if (this.fgD != null) {
            this.fgD.setImageBitmap(bitmap);
        }
    }

    public final void wJ(int i) {
        this.fgz = i;
        this.fgy = null;
        if (this.fgD != null) {
            this.fgD.setImageResource(i);
        }
    }

    public final void wK(int i) {
        this.fgA = i;
        if (this.fgD != null) {
            this.fgD.setVisibility(this.fgA);
        }
    }

    public final void wL(int i) {
        this.fgB = i;
        if (this.fgE != null) {
            this.fgE.setVisibility(this.fgB);
        }
    }

    public final void wM(int i) {
        this.fgC = i;
        if (this.fgF != null) {
            this.fgF.setVisibility(this.fgC);
        }
    }

    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131756901);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.OL != 0) {
                Drawable drawable = this.mContext.getResources().getDrawable(this.OL);
                this.drawable = drawable;
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758240);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.ocC = (TextView) view.findViewById(2131758235);
        if (this.ocC != null) {
            if (this.ocE) {
                this.ocC.setCompoundDrawablesWithIntrinsicBounds(2130839358, 0, 0, 0);
                this.ocC.setCompoundDrawablePadding((int) this.context.getResources().getDimension(2131493199));
            } else {
                this.ocC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.ocC.setVisibility(this.fgx);
            this.ocC.setText(this.fgv);
            if (this.fgw != -1) {
                this.ocC.setBackgroundDrawable(a.a(this.context, this.fgw));
            }
        }
        this.ocB = (TextView) view.findViewById(2131758255);
        if (this.ocB != null) {
            this.ocB.setVisibility(this.ocz);
            this.ocB.setText(this.ocx);
            if (this.ocy != -1) {
                this.ocB.setBackgroundDrawable(a.a(this.context, this.ocy));
            }
            if (this.ocA != -1) {
                this.ocB.setTextColor(this.ocA);
            }
            if (this.ocD) {
                this.ocB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839358, 0);
                this.ocB.setCompoundDrawablePadding((int) this.context.getResources().getDimension(2131493199));
            } else {
                this.ocB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.ocu = (ImageView) view.findViewById(2131758254);
        this.ocu.setVisibility(this.oct);
        this.fgD = (ImageView) view.findViewById(2131758257);
        this.fgE = (ViewGroup) view.findViewById(2131758256);
        this.fgF = view.findViewById(2131758258);
        this.fgF.setVisibility(this.fgC);
        if (this.fgy != null) {
            this.fgD.setImageBitmap(this.fgy);
        } else if (this.fgz != -1) {
            this.fgD.setImageResource(this.fgz);
        }
        this.fgD.setVisibility(this.fgA);
        this.fgE.setVisibility(this.fgB);
        if (this.fgG != null) {
            this.fgD.setLayoutParams(this.fgG);
        }
        this.ocv = (TextView) view.findViewById(16908310);
    }
}
