package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.q;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private View dtW;
    private Activity gZX;
    private ImageView jEe;
    private TextView jEf;
    private PreviewContactView jEg;
    SnsUploadConfigView jEh;
    private List<String> jEi = new LinkedList();
    private boolean jEj = false;

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        if (atContactWidget.jEi == null) {
            atContactWidget.jEi = new LinkedList();
        }
        if (atContactWidget.jEh == null || atContactWidget.jEh.aYe() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.gZX.getString(2131235584));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", k.xF());
            intent.putExtra("Select_Contact", be.b(atContactWidget.jEi, ","));
            intent.putExtra("sns_address_count", 0);
            a.drp.a(intent, atContactWidget.gZX, 6);
            return;
        }
        g.f(atContactWidget.gZX, 2131235536, 2131231164);
    }

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final List<String> aVp() {
        if (this.jEi == null) {
            this.jEi = new LinkedList();
        }
        return this.jEi;
    }

    public final void aVq() {
        if (this.jEi == null) {
            this.jEi = new LinkedList();
        }
        this.jEi.clear();
        if (this.jEg != null) {
            this.jEg.bv(this.jEi);
        }
        aVr();
        if (this.jEf != null) {
            this.jEf.setVisibility(8);
        }
    }

    private void init(Context context) {
        this.gZX = (Activity) context;
        this.dtW = q.em(context).inflate(getLayoutResource(), this);
        this.jEg = (PreviewContactView) this.dtW.findViewById(2131755463);
        this.jEe = (ImageView) this.dtW.findViewById(2131755461);
        this.jEf = (TextView) this.dtW.findViewById(2131759199);
        this.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AtContactWidget jEk;

            {
                this.jEk = r1;
            }

            public final void onClick(View view) {
                AtContactWidget.a(this.jEk);
            }
        });
    }

    public final boolean G(Intent intent) {
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        List linkedList2;
        if (stringExtra == null || stringExtra.equals("")) {
            linkedList2 = new LinkedList();
        } else {
            linkedList2 = be.g(stringExtra.split(","));
        }
        if (this.jEi == null) {
            this.jEi = new LinkedList();
        }
        this.jEi.clear();
        for (String stringExtra2 : r0) {
            if (!this.jEi.contains(stringExtra2)) {
                this.jEi.add(stringExtra2);
            }
        }
        if (this.jEg != null) {
            this.jEg.bv(this.jEi);
        }
        if (this.jEj) {
            v.d("MicroMsg.AtContactWiget", "withList count " + this.jEi.size());
            if (!this.jEj || this.jEf == null || this.jEi.size() <= 0) {
                this.jEf.setVisibility(8);
            } else {
                this.jEf.setVisibility(0);
                if (this.jEi.size() < 100) {
                    this.jEf.setText(this.jEi.size());
                } else {
                    this.jEf.setText(2131235710);
                }
            }
        }
        aVr();
        return true;
    }

    private void aVr() {
        if (this.jEi.size() > 0) {
            this.jEe.setImageResource(aVs());
        } else {
            this.jEe.setImageResource(aVt());
        }
    }

    protected int getLayoutResource() {
        return 2130903134;
    }

    protected int aVs() {
        return 2131165942;
    }

    protected int aVt() {
        return 2131165941;
    }
}
