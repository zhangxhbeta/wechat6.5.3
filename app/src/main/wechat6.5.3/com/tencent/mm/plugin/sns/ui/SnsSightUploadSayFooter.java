package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity aWn;
    private ImageButton hhJ;
    ChatFooterPanel hhM;
    private boolean hhP = true;
    SightLocationWidget jTe;
    MMEditText jij = null;
    SightRangeWidget jik;

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        if (snsSightUploadSayFooter.hhM.getVisibility() == 8) {
            snsSightUploadSayFooter.aWn.axg();
            snsSightUploadSayFooter.hhM.onResume();
            snsSightUploadSayFooter.hhM.setVisibility(0);
            snsSightUploadSayFooter.jij.requestFocus();
            snsSightUploadSayFooter.hhJ.setImageResource(2131165921);
            snsSightUploadSayFooter.hhP = false;
            return;
        }
        snsSightUploadSayFooter.hhP = false;
        snsSightUploadSayFooter.jij.requestFocus();
        snsSightUploadSayFooter.SR();
        snsSightUploadSayFooter.aWn.aJs();
        snsSightUploadSayFooter.hhJ.setImageResource(2131165920);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        ak.yW();
        c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        ak.yW();
        c.vf().set(-29414083, Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) inflate(this.aWn, 2130904493, this);
        this.hhJ = (ImageButton) viewGroup.findViewById(2131757969);
        this.hhJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightUploadSayFooter jTf;

            {
                this.jTf = r1;
            }

            public final void onClick(View view) {
                SnsSightUploadSayFooter.d(this.jTf);
            }
        });
        if (f.lNK == null) {
            this.hhM = new e(this.aWn);
        } else {
            this.hhM = f.lNK.bC(getContext());
            this.hhM.jT(ChatFooterPanel.SCENE_SNS);
            this.hhM.setVisibility(8);
            ((LinearLayout) findViewById(2131755452)).addView(this.hhM, -1, 0);
            this.hhM.ahm();
            this.hhM.ahn();
            this.hhM.lGm = new a(this) {
                final /* synthetic */ SnsSightUploadSayFooter jTf;

                {
                    this.jTf = r1;
                }

                public final void ayC() {
                }

                public final void ef(boolean z) {
                }

                public final void Tm() {
                    this.jTf.jij.pcq.sendKeyEvent(new KeyEvent(0, 67));
                    this.jTf.jij.pcq.sendKeyEvent(new KeyEvent(1, 67));
                }

                public final void append(String str) {
                    try {
                        this.jTf.jij.PL(str);
                    } catch (Throwable e) {
                        v.a("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
                    }
                }
            };
        }
        this.jik = (SightRangeWidget) viewGroup.findViewById(2131757970);
        this.jik.jEh = null;
        this.jik.style = 1;
        this.jTe = (SightLocationWidget) viewGroup.findViewById(2131759454);
    }

    private void SR() {
        this.hhM.onPause();
        this.hhM.setVisibility(8);
    }

    protected final View ayB() {
        return this.hhM;
    }
}
