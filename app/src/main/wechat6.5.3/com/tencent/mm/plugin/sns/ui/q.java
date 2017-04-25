package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;

public final class q extends LinearLayout implements t {
    private String bYE = "";
    private boolean bcR = false;
    int bcS;
    private String bde = "";
    private Context context;
    private int eKg = 0;
    b jFC = new b(this);
    private k jFD = null;
    a jFE;
    private OnTouchListener jFF = be.buq();
    private boolean jFG = true;

    public interface a {
        void aVn();
    }

    class b {
        ImageView dtz;
        TextView emb;
        final /* synthetic */ q jFH;
        LinearLayout jFJ;
        TextView jFK;
        LinearLayout jFL;
        LinearLayout jFM;
        ImageView jFN;
        LinearLayout jFO;
        LinearLayout jFP;
        TextView jFQ;
        TextView jFR;
        TextView jFS;
        LinearLayout jFT;
        ImageView jFU;
        ImageView jFV;
        LinearLayout jFW;
        LinearLayout jFX;
        TextView jFY;

        b(q qVar) {
            this.jFH = qVar;
        }
    }

    public final void setVisibility(int i) {
        boolean z = false;
        if (this.eKg == 2 || this.eKg == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.jFG = z;
        } else if (this.jFD != null && !this.jFD.aUK()) {
        } else {
            if (i == 8) {
                this.jFC.jFJ.setVisibility(8);
                this.jFG = false;
            } else if (i == 0) {
                this.jFC.jFJ.setVisibility(0);
                this.jFG = true;
            }
        }
    }

    public q(final Context context, int i, boolean z) {
        super(context);
        this.eKg = i;
        this.bcR = z;
        this.context = context;
        if (this.eKg != -1) {
            this.bYE = com.tencent.mm.model.k.xF();
            View inflate = LayoutInflater.from(context).inflate(2130904450, this, true);
            this.jFC.jFJ = (LinearLayout) inflate.findViewById(2131759351);
            this.jFC.jFT = (LinearLayout) inflate.findViewById(2131759345);
            this.jFC.jFM = (LinearLayout) inflate.findViewById(2131759352);
            this.jFC.jFM.setOnTouchListener(this.jFF);
            this.jFC.jFN = (ImageView) inflate.findViewById(2131759353);
            this.jFC.jFO = (LinearLayout) inflate.findViewById(2131759355);
            this.jFC.jFO.setOnTouchListener(this.jFF);
            this.jFC.jFP = (LinearLayout) inflate.findViewById(2131759356);
            this.jFC.jFR = (TextView) inflate.findViewById(2131759357);
            this.jFC.jFS = (TextView) inflate.findViewById(2131759358);
            this.jFC.jFQ = (TextView) inflate.findViewById(2131759354);
            this.jFC.jFK = (TextView) inflate.findViewById(2131759344);
            this.jFC.jFL = (LinearLayout) inflate.findViewById(2131759343);
            this.jFC.emb = (TextView) inflate.findViewById(2131759348);
            this.jFC.emb.setTextSize(1, (this.jFC.emb.getTextSize() * u.ds(context)) / com.tencent.mm.bd.a.getDensity(this.jFC.emb.getContext()));
            this.jFC.jFX = (LinearLayout) inflate.findViewById(2131759346);
            ((LinearLayout) inflate.findViewById(2131759346)).getBackground().setAlpha(50);
            this.jFC.dtz = (ImageView) inflate.findViewById(2131759347);
            this.jFC.jFU = (ImageView) inflate.findViewById(2131759349);
            this.jFC.jFV = (ImageView) inflate.findViewById(2131759350);
            this.jFC.jFW = (LinearLayout) inflate.findViewById(2131759341);
            this.jFC.jFY = (TextView) inflate.findViewById(2131759342);
            if (this.eKg == 2) {
                this.jFC.jFT.setVisibility(8);
                this.jFC.jFW.setVisibility(8);
                this.jFC.jFL.setVisibility(0);
            } else if (this.eKg == 3) {
                this.jFC.jFT.setVisibility(8);
                this.jFC.jFL.setVisibility(8);
                this.jFC.jFW.setVisibility(0);
            } else {
                this.jFC.jFT.setVisibility(0);
                this.jFC.jFL.setVisibility(8);
                this.jFC.jFW.setVisibility(8);
            }
            this.jFC.jFM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ q jFH;

                {
                    this.jFH = r1;
                }

                public final void onClick(View view) {
                    if (this.jFH.jFD != null) {
                        if (this.jFH.jFD.field_likeFlag == 0) {
                            if (this.jFH.jFD.aUK()) {
                                com.tencent.mm.plugin.sns.e.ak.a.a(this.jFH.jFD, 1, "", "", this.jFH.bcS);
                            } else {
                                com.tencent.mm.plugin.sns.e.ak.a.a(this.jFH.jFD.field_userName, 5, "", this.jFH.jFD, this.jFH.bcS);
                            }
                            this.jFH.jFD.field_likeFlag = 1;
                            ad.aSE().a(this.jFH.jFD.aUq(), this.jFH.jFD);
                        } else {
                            this.jFH.jFD.field_likeFlag = 0;
                            ad.aSE().a(this.jFH.jFD.aUq(), this.jFH.jFD);
                            com.tencent.mm.plugin.sns.e.ak.a.Ay(this.jFH.jFD.aUq());
                            this.jFH.jFD = ad.aSE().dd(this.jFH.jFD.field_snsId);
                        }
                        String cE = this.jFH.jFD.field_snsId == 0 ? "" : i.cE(this.jFH.jFD.field_snsId);
                        g.iuh.h(11989, new Object[]{Integer.valueOf(1), cE, Integer.valueOf(0)});
                        new ac().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jFI;

                            {
                                this.jFI = r1;
                            }

                            public final void run() {
                                this.jFI.jFH.refresh();
                            }
                        }, 500);
                    }
                }
            });
            this.jFC.jFO.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ q jFH;

                public final void onClick(View view) {
                    v.d("MicroMsg.GalleryFooter", "comment cmd");
                    if (this.jFH.jFD != null) {
                        int i = this.jFH.jFD.jBI;
                        Intent intent = new Intent();
                        intent.putExtra("sns_comment_localId", i);
                        intent.putExtra("sns_source", this.jFH.bcS);
                        intent.setClass(context, SnsCommentUI.class);
                        String cE = this.jFH.jFD.field_snsId == 0 ? "" : i.cE(this.jFH.jFD.field_snsId);
                        g.iuh.h(11989, new Object[]{Integer.valueOf(2), cE, Integer.valueOf(0)});
                        context.startActivity(intent);
                    }
                }
            });
            this.jFC.jFP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ q jFH;

                public final void onClick(View view) {
                    if (this.jFH.jFD != null) {
                        String cE = this.jFH.jFD.field_snsId == 0 ? "" : i.cE(this.jFH.jFD.field_snsId);
                        g.iuh.h(11989, new Object[]{Integer.valueOf(3), cE, Integer.valueOf(0)});
                        int i = this.jFH.jFD.jBI;
                        Intent intent = new Intent();
                        intent.setClass(context, SnsCommentDetailUI.class);
                        intent.putExtra("INTENT_TALKER", this.jFH.jFD.field_userName);
                        intent.putExtra("INTENT_SNS_LOCAL_ID", s.B("sns_table_", (long) i));
                        intent.putExtra("INTENT_FROMGALLERY", true);
                        ((MMActivity) context).startActivityForResult(intent, 1);
                    }
                }
            });
            this.jFC.jFK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ q jFH;

                {
                    this.jFH = r1;
                }

                public final void onClick(View view) {
                    if (this.jFH.jFE != null) {
                        this.jFH.jFE.aVn();
                    }
                }
            });
            this.jFC.jFY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ q jFH;

                {
                    this.jFH = r1;
                }

                public final void onClick(View view) {
                }
            });
        }
    }

    public final void refresh() {
        if (this.eKg != -1) {
            this.jFD = ad.aSE().Bq(this.bde);
            if (!be.kS(this.bde) && this.jFD != null) {
                this.jFC.jFV.setVisibility(8);
                if (this.jFD.field_snsId == 0 || ah.H(this.jFD.field_localPrivate, this.bcR)) {
                    this.jFC.jFO.setVisibility(8);
                    this.jFC.jFM.setVisibility(8);
                } else if (this.jFD.aUK()) {
                    if (this.jFG) {
                        this.jFC.jFJ.setVisibility(0);
                    }
                    this.jFC.jFP.setVisibility(0);
                    this.jFC.jFO.setVisibility(0);
                    this.jFC.jFM.setVisibility(0);
                    this.jFC.jFT.setVisibility(0);
                } else {
                    this.jFC.jFX.setVisibility(0);
                    this.jFC.jFT.setVisibility(0);
                    this.jFC.jFJ.setVisibility(8);
                    this.jFC.jFP.setVisibility(8);
                    this.jFC.jFO.setVisibility(8);
                    this.jFC.jFM.setVisibility(8);
                }
                awa n = ah.n(this.jFD);
                if (n != null) {
                    if (this.jFD.aUK()) {
                        int i = n.mTl;
                        if (i > 0) {
                            this.jFC.jFS.setText(String.valueOf(i));
                            this.jFC.jFS.setVisibility(0);
                        } else {
                            this.jFC.jFS.setVisibility(8);
                        }
                        int i2 = n.mTi;
                        if (i2 > 0) {
                            this.jFC.jFR.setText(String.valueOf(i2));
                            this.jFC.jFR.setVisibility(0);
                        } else {
                            this.jFC.jFR.setVisibility(8);
                        }
                        v.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                        if (this.jFD.field_likeFlag == 1) {
                            this.jFC.jFQ.setText(getResources().getString(2131235418));
                            this.jFC.jFN.setImageResource(2131165577);
                        } else {
                            this.jFC.jFQ.setText(getResources().getString(2131235419));
                            this.jFC.jFN.setImageResource(2131165578);
                        }
                    }
                    if (this.bYE.equals(this.jFD.field_userName) || !this.bcR) {
                        this.jFC.dtz.setVisibility(8);
                    } else {
                        this.jFC.dtz.setVisibility(0);
                        com.tencent.mm.pluginsdk.ui.a.b.m(this.jFC.dtz, this.jFD.field_userName);
                    }
                }
                if (this.jFD.aUp() == null) {
                    this.jFC.emb.setVisibility(8);
                    return;
                }
                String str = this.jFD.aUp().mWn;
                if (str == null || str.equals("")) {
                    this.jFC.emb.setText("");
                    this.jFC.emb.setVisibility(8);
                } else {
                    this.jFC.emb.setText(e.a(getContext(), str + " ", this.jFC.emb.getTextSize()));
                    this.jFC.emb.setVisibility(0);
                }
                if (ah.H(this.jFD.field_localPrivate, this.bcR)) {
                    this.jFC.jFU.setVisibility(0);
                    this.jFC.emb.setVisibility(0);
                } else {
                    this.jFC.jFU.setVisibility(8);
                }
                if (this.bcR && this.jFD.aUN()) {
                    this.jFC.jFP.setVisibility(0);
                    this.jFC.emb.setVisibility(0);
                    this.jFC.jFV.setVisibility(0);
                }
            }
        }
    }

    public final void BS(String str) {
        this.bde = str;
        refresh();
    }
}
