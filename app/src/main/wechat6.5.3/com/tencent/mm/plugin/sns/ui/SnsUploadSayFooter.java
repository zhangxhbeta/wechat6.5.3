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
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsUploadSayFooter extends BasePanelKeybordLayout {
    private MMActivity aWn;
    ImageButton hhJ;
    ChatFooterPanel hhM;
    private boolean hhP = true;
    MMEditText jij = null;

    static /* synthetic */ void b(SnsUploadSayFooter snsUploadSayFooter) {
        if (snsUploadSayFooter.hhM.getVisibility() == 8) {
            snsUploadSayFooter.aWn.axg();
            snsUploadSayFooter.hhM.onResume();
            snsUploadSayFooter.hhM.setVisibility(0);
            snsUploadSayFooter.jij.requestFocus();
            snsUploadSayFooter.hhJ.setImageResource(2130839231);
            snsUploadSayFooter.hhP = false;
            return;
        }
        snsUploadSayFooter.hhP = false;
        snsUploadSayFooter.jij.requestFocus();
        snsUploadSayFooter.SR();
        snsUploadSayFooter.aWn.aJs();
        snsUploadSayFooter.hhJ.setImageResource(2130839241);
    }

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        ak.yW();
        c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        ak.yW();
        c.vf().set(-29414083, Integer.valueOf(0));
        this.hhJ = (ImageButton) ((ViewGroup) q.em(this.aWn).inflate(2130904517, this)).findViewById(2131757969);
        this.hhJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsUploadSayFooter jYh;

            {
                this.jYh = r1;
            }

            public final void onClick(View view) {
                SnsUploadSayFooter.b(this.jYh);
            }
        });
        if (f.lNK == null) {
            this.hhM = new e(this.aWn);
            return;
        }
        this.hhM = f.lNK.bC(getContext());
        this.hhM.jT(ChatFooterPanel.SCENE_SNS);
        this.hhM.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131755452);
        linearLayout.setOnClickListener(null);
        linearLayout.addView(this.hhM, -1, 0);
        this.hhM.ahm();
        this.hhM.ahn();
        this.hhM.lGm = new a(this) {
            final /* synthetic */ SnsUploadSayFooter jYh;

            {
                this.jYh = r1;
            }

            public final void ayC() {
            }

            public final void ef(boolean z) {
            }

            public final void Tm() {
                this.jYh.jij.pcq.sendKeyEvent(new KeyEvent(0, 67));
                this.jYh.jij.pcq.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    this.jYh.jij.PL(str);
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public final boolean aYg() {
        return this.hhM.getVisibility() == 0;
    }

    public final void aYh() {
        SR();
        setVisibility(8);
    }

    private void SR() {
        this.hhM.onPause();
        this.hhM.setVisibility(8);
    }

    protected final View ayB() {
        return this.hhM;
    }
}
