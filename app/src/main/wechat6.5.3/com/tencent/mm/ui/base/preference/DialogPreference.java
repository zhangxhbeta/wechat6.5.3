package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public final class DialogPreference extends Preference {
    private h iji;
    public com.tencent.mm.ui.base.preference.Preference.a ock;
    private final d ocm;
    a ocn;

    public interface a {
        void bDc();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ocm = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOX, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.ocm.oci = context.getResources().getStringArray(resourceId);
        }
        this.ocm.ocj = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        this.ocm.bDb();
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.ock = aVar;
    }

    public final String getValue() {
        return this.ocm.value;
    }

    public final void setValue(String str) {
        this.ocm.value = str;
        c cVar = (c) this.ocm.bXL.get(str);
        if (cVar == null) {
            this.ocm.hRS = -1;
            return;
        }
        this.ocm.hRS = cVar.id;
    }

    public final void onBindView(View view) {
        c cVar = (c) this.ocm.bXL.get(this.ocm.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
    }

    protected final void showDialog() {
        ListView listView = (ListView) View.inflate(this.mContext, 2130903991, null);
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ DialogPreference oco;

            {
                this.oco = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.oco.iji != null) {
                    this.oco.iji.dismiss();
                }
                this.oco.setValue((String) this.oco.ocm.ocj[i]);
                if (this.oco.ocn != null) {
                    this.oco.ocn.bDc();
                }
                if (this.oco.ock != null) {
                    this.oco.ock.a(this.oco, this.oco.getValue());
                }
            }
        });
        listView.setAdapter(this.ocm);
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.mContext);
        aVar.Op(getTitle().toString());
        aVar.cC(listView);
        this.iji = aVar.RX();
        this.iji.show();
        g.a(this.mContext, this.iji);
    }
}
