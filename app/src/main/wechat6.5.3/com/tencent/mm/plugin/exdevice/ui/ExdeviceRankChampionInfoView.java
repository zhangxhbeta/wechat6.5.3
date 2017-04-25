package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private int cmH = 0;
    private String dRA;
    private TextView eJL;
    private ImageView fyB;
    private TextPaint gl;

    public void setAlpha(float f) {
        this.eJL.setAlpha(f);
        this.fyB.setAlpha(f);
    }

    public ExdeviceRankChampionInfoView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(2130903566, this, true);
        this.gl = new TextPaint(1);
        this.eJL = (TextView) inflate.findViewById(2131756774);
        this.fyB = (ImageView) inflate.findViewById(2131756803);
        this.fyB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankChampionInfoView fDE;

            public final void onClick(View view) {
                if (be.kS(this.fDE.dRA)) {
                    v.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", this.fDE.dRA);
                context.startActivity(intent);
            }
        });
        this.eJL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankChampionInfoView fDE;

            public final void onClick(View view) {
                if (be.kS(this.fDE.dRA)) {
                    v.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", this.fDE.dRA);
                context.startActivity(intent);
            }
        });
        try {
            this.cmH = context.getResources().getDimensionPixelSize(2131493055);
            if (this.cmH <= 0) {
                this.cmH = 128;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.cmH <= 0) {
                this.cmH = 128;
            }
        } catch (Throwable th) {
            if (this.cmH <= 0) {
                this.cmH = 128;
            }
        }
        v.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[]{Integer.valueOf(this.cmH)});
    }

    public final void sA(String str) {
        this.dRA = str;
        if (this.eJL != null) {
            if (be.kS(str)) {
                this.eJL.setVisibility(8);
                this.eJL.setText("");
            } else {
                this.eJL.setVisibility(0);
                Context context = getContext();
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(e.a(getContext(), l.er(this.dRA)), this.gl, (float) this.cmH, TruncateAt.END);
                v.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[]{e.a(getContext(), context.getString(2131232509, objArr))});
                this.eJL.setText(e.a(getContext(), r0, this.eJL.getTextSize()));
            }
        }
        if (this.fyB == null) {
            return;
        }
        if (be.kS(str)) {
            this.fyB.setVisibility(4);
            return;
        }
        b.o(this.fyB, str);
        this.fyB.setVisibility(0);
    }
}
