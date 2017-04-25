package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference extends Preference {
    private Context context;
    int kgC;
    a kgF;
    OnItemClickListener kgG;
    OnItemClickListener kgH;
    private OnClickListener kgI;
    private int kgJ;
    private boolean kgK;
    private int kgL;

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgG = null;
        this.kgH = null;
        this.kgI = null;
        this.kgC = 0;
        this.kgK = false;
        this.kgL = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOU);
        this.kgJ = obtainStyledAttributes.getInt(0, 8);
        this.kgK = obtainStyledAttributes.getBoolean(1, false);
        this.kgL = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(2131755441);
        this.kgF = new a(this.context, this.kgC);
        mMGridView.setAdapter(this.kgF);
        mMGridView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AppPreference kgM;

            {
                this.kgM = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.kgM.kgF.lB(i)) {
                    this.kgM.kgF.gC(false);
                } else if (this.kgM.kgF.kgB) {
                    if (this.kgM.kgH != null) {
                        this.kgM.kgH.onItemClick(adapterView, view, i, j);
                    }
                } else if (this.kgM.kgG != null) {
                    this.kgM.kgG.onItemClick(adapterView, view, i, j);
                }
            }
        });
        if (this.kgK) {
            mMGridView.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ AppPreference kgM;

                {
                    this.kgM = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppPreference appPreference = this.kgM;
                    if (appPreference.kgF != null) {
                        appPreference.kgF.gC(!appPreference.kgF.kgB);
                    }
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(2131755442);
        if (this.kgF.getCount() == 0) {
            textView.setVisibility(0);
            textView.setText(this.kgL);
            mMGridView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            mMGridView.setVisibility(0);
        }
        Button button = (Button) view.findViewById(2131755443);
        button.setVisibility(this.kgJ);
        button.setOnClickListener(this.kgI);
    }

    public final f ro(int i) {
        if (i < 0 || i >= this.kgF.getCount()) {
            return null;
        }
        return (f) this.kgF.getItem(i);
    }

    public final void onResume() {
        if (this.kgF != null) {
            am.bnB().c(this.kgF);
        }
    }

    public final void onPause() {
        if (this.kgF != null) {
            am.bnB().d(this.kgF);
        }
    }
}
