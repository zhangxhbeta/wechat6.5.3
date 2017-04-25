package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private View dtW;
    private Activity gZX;
    private ImageView jEe;
    public SnsUploadConfigView jEh;
    private TextView jJo;
    private boolean jJp = true;
    int jJq = 0;
    String jJr = "";
    public boolean jJs = false;
    private String jhM = "";
    private String jhN = "";
    public int style = 0;

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.gZX = (Activity) context;
        this.dtW = View.inflate(context, getLayoutResource(), this);
        this.jJo = (TextView) this.dtW.findViewById(2131758760);
        this.jEe = (ImageView) this.dtW.findViewById(2131758759);
        this.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RangeWidget jJt;

            {
                this.jJt = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.jJt.gZX, SnsLabelUI.class);
                intent.putExtra("KLabel_range_index", this.jJt.jJq);
                intent.putExtra("Klabel_name_list", this.jJt.jhM);
                intent.putExtra("Kother_user_name_list", this.jJt.jhN);
                intent.putExtra("Ktag_rangeFilterprivate", this.jJt.jJs);
                intent.putExtra("k_sns_label_ui_style", this.jJt.style);
                this.jJt.gZX.startActivityForResult(intent, 5);
            }
        });
    }

    private static List<String> ah(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ak.uz()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ak.yW();
            u LX = c.wH().LX(obj2);
            if (!(LX == null || ((int) LX.chr) == 0)) {
                obj2 = LX.tU();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String b;
        this.jJq = intent.getIntExtra("Ktag_range_index", 0);
        this.jhM = intent.getStringExtra("Klabel_name_list");
        this.jhN = intent.getStringExtra("Kother_user_name_list");
        int aWk = aWk();
        Object obj = "";
        if (!be.kS(this.jhM)) {
            obj = obj + this.jhM;
        }
        if (!be.kS(this.jhN)) {
            b = be.b(ah(Arrays.asList(this.jhN.split(","))), ",");
            if (obj.length() > 0) {
                obj = obj + "," + b;
            } else {
                obj = obj + b;
            }
        }
        if (!(aWk == -1 || obj == null || obj.length() <= aWk)) {
            obj = obj.substring(0, aWk) + "...";
        }
        aWk = this.jJq;
        if (this.jEe != null) {
            this.jEe.setImageResource(2131165952);
        }
        if (this.jEh != null) {
            this.jEh.gy(false);
        }
        switch (aWk) {
            case 0:
                if (this.jEe != null) {
                    this.jEe.setImageResource(2131165951);
                }
                this.jJo.setText(2131235450);
                break;
            case 1:
                if (this.jEh != null) {
                    this.jEh.gy(true);
                }
                if (!(atContactWidget == null || this.jEh == null || atContactWidget.aVp().size() <= 0)) {
                    g.f(this.gZX, 2131235536, 2131231164);
                    atContactWidget.aVq();
                    this.jEh.aYb();
                }
                this.jJo.setText(2131235448);
                break;
            case 2:
                this.jJo.setText(obj);
                break;
            case 3:
                TextView textView = this.jJo;
                b = this.gZX.getString(2131235436);
                obj = b + "  " + obj;
                CharSequence spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(-65536), b.length() + 2, obj.length(), 33);
                textView.setText(spannableString);
                break;
        }
        return true;
    }

    protected int getLayoutResource() {
        return 2130904221;
    }

    protected int aWk() {
        return -1;
    }
}
