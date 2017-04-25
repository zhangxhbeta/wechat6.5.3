package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.ui.base.i;

public class ArtistHeader extends LinearLayout implements b {
    Context context = null;
    private View fIV;
    private i fUp = null;
    de jDE = null;
    a jDJ;
    private ImageView jDK;
    private ProgressBar jDL;

    class a {
        TextView dtB;
        ImageView dtz;
        TextView emb;
        final /* synthetic */ ArtistHeader jDM;
        TextView jDO;
        TextView jDP;

        a(ArtistHeader artistHeader) {
            this.jDM = artistHeader;
        }
    }

    public ArtistHeader(Context context) {
        super(context);
        init(context);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(2130904436, this, true);
        this.context = context;
        this.jDJ = new a(this);
        this.jDJ.dtz = (ImageView) inflate.findViewById(2131759276);
        this.jDJ.emb = (TextView) inflate.findViewById(2131759279);
        this.jDJ.jDO = (TextView) inflate.findViewById(2131759277);
        this.jDJ.jDP = (TextView) inflate.findViewById(2131759280);
        this.jDJ.dtB = (TextView) inflate.findViewById(2131759278);
        this.jDJ.dtz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ArtistHeader jDM;

            {
                this.jDM = r1;
            }

            public final void onClick(View view) {
                if ((this.jDM.fUp == null || !this.jDM.fUp.isShowing()) && this.jDM.jDE != null) {
                    View inflate = LayoutInflater.from(this.jDM.getContext()).inflate(2130904577, null);
                    this.jDM.fUp = new i(this.jDM.getContext(), 2131559262);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 jDN;

                        {
                            this.jDN = r1;
                        }

                        public final void onClick(View view) {
                            this.jDN.jDM.fUp.dismiss();
                        }
                    });
                    this.jDM.fUp.setCanceledOnTouchOutside(true);
                    this.jDM.fUp.setContentView(inflate);
                    this.jDM.fUp.show();
                    this.jDM.jDK = (ImageView) inflate.findViewById(2131759634);
                    this.jDM.jDL = (ProgressBar) inflate.findViewById(2131759636);
                    this.jDM.fIV = inflate.findViewById(2131759635);
                }
            }
        });
    }

    public final void Aa(String str) {
    }

    public final void ai(String str, boolean z) {
        if (this.jDE != null && this.fUp != null && this.fUp.isShowing() && !z) {
            aib com_tencent_mm_protocal_c_aib = this.jDE.mdK.mdL;
            if (com_tencent_mm_protocal_c_aib.gID != null && com_tencent_mm_protocal_c_aib.gID.equals(str)) {
                Toast.makeText(this.context, this.context.getString(2131235392), 0).show();
            }
        }
    }

    public final void aj(String str, boolean z) {
    }

    public final void aRc() {
    }
}
