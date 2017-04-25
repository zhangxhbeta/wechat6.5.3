package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference.a;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    private final HashMap<CharSequence, b> bXL;
    private int hRS;
    private RadioGroup och;
    private CharSequence[] oci;
    private CharSequence[] ocj;
    public a ock;
    String value;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXL = new HashMap();
        this.hRS = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOX, i, 0);
        this.oci = obtainStyledAttributes.getTextArray(0);
        this.ocj = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        bDb();
    }

    public final void a(a aVar) {
        this.ock = aVar;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904011, viewGroup2);
        this.och = (RadioGroup) onCreateView.findViewById(2131758248);
        for (int i = 0; i < this.ocj.length; i++) {
            b bVar = (b) this.bXL.get(this.ocj[i]);
            if (bVar != null) {
                RadioButton radioButton;
                if (i == 0) {
                    radioButton = (RadioButton) layoutInflater.inflate(2130903979, null);
                    bVar.a(radioButton);
                    this.och.addView(radioButton);
                } else if (i == this.ocj.length - 1) {
                    radioButton = (RadioButton) layoutInflater.inflate(2130903981, null);
                    bVar.a(radioButton);
                    this.och.addView(radioButton);
                } else {
                    radioButton = (RadioButton) layoutInflater.inflate(2130903980, null);
                    bVar.a(radioButton);
                    this.och.addView(radioButton);
                }
            }
        }
        this.och.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ ChoicePreference ocl;

            {
                this.ocl = r1;
            }

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (this.ocl.ock != null) {
                    if (i != -1) {
                        this.ocl.value = this.ocl.ocj[i - 1048576];
                    } else {
                        this.ocl.value = null;
                    }
                    this.ocl.hRS = i;
                    this.ocl.ock.a(this.ocl, this.ocl.value);
                }
            }
        });
        return onCreateView;
    }

    private void bDb() {
        boolean z;
        int i = 0;
        if (this.oci == null) {
            this.oci = new CharSequence[0];
        }
        if (this.ocj == null) {
            this.ocj = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.oci.length == this.ocj.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.bXL.clear();
        while (i < this.ocj.length) {
            this.bXL.put(this.ocj[i], new b(this.oci[i], 1048576 + i));
            i++;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.och != null) {
            this.och.check(this.hRS);
        }
    }

    public final void setValue(String str) {
        this.value = str;
        b bVar = (b) this.bXL.get(str);
        if (bVar == null) {
            this.hRS = -1;
        } else {
            this.hRS = bVar.id;
        }
    }
}
