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
import java.util.List;

public class ServicePreference extends Preference {
    private Context context;
    List<f> kgD;
    OnItemClickListener kgG;
    private OnItemClickListener kgH;
    private OnClickListener kgI;
    private int kgJ;
    private boolean kgK;
    private int kgL;
    b kha;

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgG = null;
        this.kgH = null;
        this.kgI = null;
        this.kgK = false;
        this.kgL = 0;
        this.context = context;
        setLayoutResource(2130903126);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOU);
        this.kgJ = obtainStyledAttributes.getInt(0, 8);
        this.kgK = obtainStyledAttributes.getBoolean(1, false);
        this.kgL = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(2131755441);
        if (mMGridView != null) {
            this.kha = new b(this.context, this.kgD);
            am.bnB().d(this.kha);
            am.bnB().c(this.kha);
            mMGridView.setAdapter(this.kha);
            mMGridView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ServicePreference khb;

                {
                    this.khb = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.khb.kha.lB(i)) {
                        this.khb.kha.gC(false);
                    } else if (this.khb.kha.kgB) {
                        if (this.khb.kgH != null) {
                            this.khb.kgH.onItemClick(adapterView, view, i, j);
                        }
                    } else if (this.khb.kgG != null) {
                        this.khb.kgG.onItemClick(adapterView, view, i, j);
                    }
                }
            });
            if (this.kgK) {
                mMGridView.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                    final /* synthetic */ ServicePreference khb;

                    {
                        this.khb = r1;
                    }

                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        ServicePreference servicePreference = this.khb;
                        if (servicePreference.kha != null) {
                            servicePreference.kha.gC(!servicePreference.kha.kgB);
                        }
                        return true;
                    }
                });
            }
            TextView textView = (TextView) view.findViewById(2131755442);
            if (this.kha.getCount() == 0) {
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
    }

    public final f ro(int i) {
        if (i < 0 || i >= this.kha.getCount()) {
            return null;
        }
        return (f) this.kha.getItem(i);
    }

    public final void onResume() {
        if (this.kha != null) {
            am.bnB().c(this.kha);
        }
    }

    public final void onPause() {
        if (this.kha != null) {
            am.bnB().d(this.kha);
        }
    }
}
