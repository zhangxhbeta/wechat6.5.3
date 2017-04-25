package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.ui.SightRangeWidget;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckySnsUploadSayFooter extends BasePanelKeybordLayout {
    private MMActivity aWn;
    private ImageButton hhJ;
    public ChatFooterPanel hhM;
    private boolean hhP = true;
    public MMEditText jij = null;
    public SightRangeWidget jik;

    static /* synthetic */ void c(LuckySnsUploadSayFooter luckySnsUploadSayFooter) {
        if (luckySnsUploadSayFooter.hhM.getVisibility() == 8) {
            luckySnsUploadSayFooter.aWn.axg();
            luckySnsUploadSayFooter.hhM.onResume();
            luckySnsUploadSayFooter.hhM.setVisibility(0);
            luckySnsUploadSayFooter.jij.requestFocus();
            luckySnsUploadSayFooter.hhJ.setImageResource(2131165971);
            luckySnsUploadSayFooter.hhP = false;
            return;
        }
        luckySnsUploadSayFooter.hhP = false;
        luckySnsUploadSayFooter.jij.requestFocus();
        luckySnsUploadSayFooter.SR();
        luckySnsUploadSayFooter.aWn.aJs();
    }

    public LuckySnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        ak.yW();
        c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        ak.yW();
        c.vf().set(-29414083, Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) inflate(this.aWn, 2130903910, this);
        this.hhJ = (ImageButton) viewGroup.findViewById(2131757969);
        this.hhJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckySnsUploadSayFooter jil;

            {
                this.jil = r1;
            }

            public final void onClick(View view) {
                LuckySnsUploadSayFooter.c(this.jil);
            }
        });
        if (f.lNK == null) {
            this.hhM = new e(this.aWn);
        } else {
            this.hhM = f.lNK.bC(getContext());
            this.hhM.jT(ChatFooterPanel.lGp);
            this.hhM.setVisibility(8);
            ((LinearLayout) findViewById(2131755452)).addView(this.hhM, -1, 0);
            this.hhM.ahm();
            this.hhM.ahn();
            this.hhM.lGm = new a(this) {
                final /* synthetic */ LuckySnsUploadSayFooter jil;

                {
                    this.jil = r1;
                }

                public final void ayC() {
                }

                public final void ef(boolean z) {
                }

                public final void Tm() {
                    this.jil.jij.pcq.sendKeyEvent(new KeyEvent(0, 67));
                    this.jil.jij.pcq.sendKeyEvent(new KeyEvent(1, 67));
                }

                public final void append(String str) {
                    try {
                        this.jil.jij.PL(str);
                    } catch (Throwable e) {
                        v.a("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
                    }
                }
            };
        }
        this.jik = (SightRangeWidget) viewGroup.findViewById(2131757970);
        this.jik.jEh = null;
        this.jik.jJs = true;
        SightRangeWidget sightRangeWidget = this.jik;
        int color = getContext().getResources().getColor(2131689768);
        int color2 = getContext().getResources().getColor(2131689547);
        TextView textView = (TextView) sightRangeWidget.findViewById(2131756626);
        TextView textView2 = (TextView) sightRangeWidget.findViewById(2131758760);
        textView.setTextColor(color);
        textView2.setTextColor(color2);
    }

    public final void SR() {
        this.hhM.onPause();
        this.hhM.setVisibility(8);
        this.hhJ.setImageResource(2131165970);
    }

    protected final View ayB() {
        return this.hhM;
    }
}
