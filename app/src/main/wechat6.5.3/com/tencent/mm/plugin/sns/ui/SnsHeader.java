package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.q;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader extends LinearLayout {
    String bYE;
    boolean bcR = false;
    Context context;
    private Dialog gpw;
    b jOu;
    a jOv;
    private boolean jOw = false;
    private Map<Integer, View> jOx = new HashMap();
    private String jOy = "";
    Bitmap jOz = null;
    int type;
    String userName;

    public interface a {
        boolean aWR();

        boolean dj(long j);
    }

    class b {
        ImageView dtz;
        TextView emU;
        TextView jDP;
        final /* synthetic */ SnsHeader jOA;
        ImageView jOE;
        LinearLayout jOF;
        LinearLayout jOG;

        b(SnsHeader snsHeader) {
            this.jOA = snsHeader;
        }
    }

    class c implements Comparator<k> {
        final /* synthetic */ SnsHeader jOA;

        c(SnsHeader snsHeader) {
            this.jOA = snsHeader;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((k) obj).field_createTime > ((k) obj2).field_createTime ? -1 : 1;
        }
    }

    static /* synthetic */ boolean a(SnsHeader snsHeader, long j) {
        if (snsHeader.jOv != null) {
            snsHeader.jOv.dj(j);
        }
        return true;
    }

    public SnsHeader(Context context) {
        super(context);
        init(context);
    }

    public SnsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(final Context context) {
        this.context = context;
        View inflate = q.em(context).inflate(2130904454, this, true);
        this.jOu = new b(this);
        this.jOu.emU = (TextView) inflate.findViewById(2131756539);
        this.jOu.dtz = (ImageView) inflate.findViewById(2131755508);
        this.jOu.jDP = (TextView) inflate.findViewById(2131759365);
        this.jOu.jOE = (ImageView) inflate.findViewById(2131759364);
        this.jOu.jOF = (LinearLayout) inflate.findViewById(2131759371);
        this.jOu.jOG = (LinearLayout) inflate.findViewById(2131759370);
        this.jOu.jOE.setContentDescription(context.getString(2131235376));
        this.jOu.jOE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsHeader jOA;

            public final void onClick(View view) {
                v.d("MicroMsg.SnsHeader", "change backGround");
                if (this.jOA.gpw == null || !this.jOA.gpw.isShowing()) {
                    String d;
                    if (this.jOA.jOv != null) {
                        this.jOA.jOv.aWR();
                    }
                    if (this.jOA.type == 1) {
                        d = this.jOA.bYE;
                    } else {
                        d = this.jOA.userName;
                    }
                    i Bu = ad.aSG().Bu(d);
                    final long j = Bu.field_snsBgId;
                    if (this.jOA.bcR || j != 0) {
                        String[] strArr;
                        this.jOA.jOw = Bu.aUy();
                        if (this.jOA.type == 1 || this.jOA.bYE.trim().equals(this.jOA.userName.trim())) {
                            strArr = new String[]{context.getString(2131235572)};
                            this.jOA.jOw = false;
                        } else {
                            strArr = this.jOA.jOw ? new String[0] : new String[]{context.getString(2131235465)};
                        }
                        String string = this.jOA.jOw ? context.getString(2131235515) : "";
                        if (this.jOA.jOw) {
                            context.getString(2131231107);
                        } else {
                            context.getString(2131231010);
                        }
                        this.jOA.gpw = g.a(this.jOA.getContext(), string, strArr, new com.tencent.mm.ui.base.g.c(this) {
                            final /* synthetic */ AnonymousClass1 jOC;

                            public final void gT(int i) {
                                switch (i) {
                                    case 0:
                                        if (!this.jOC.jOA.jOw) {
                                            SnsHeader.a(this.jOC.jOA, j);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    }
                }
            }
        });
        this.jOu.dtz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsHeader jOA;

            public final void onClick(View view) {
                u LX = ad.aSs().LX(this.jOA.userName);
                if (LX == null || !(com.tencent.mm.i.a.ei(LX.field_type) || this.jOA.bcR)) {
                    Intent intent = ((Activity) context).getIntent();
                    intent.putExtra("Contact_User", this.jOA.userName);
                    com.tencent.mm.plugin.sns.b.a.drp.d(intent, context);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", this.jOA.userName);
                if (this.jOA.userName != null && this.jOA.userName.length() > 0) {
                    com.tencent.mm.plugin.sns.b.a.drp.d(intent, context);
                }
            }
        });
    }

    public final void aWP() {
        Bitmap a;
        String str = this.userName;
        if (this.type == 1) {
            str = this.bYE;
        }
        String xh = ad.xh();
        v.d("MicroMsg.SnsHeader", "MagicAsyncTask " + str);
        i Bu = ad.aSG().Bu(str);
        String str2 = Bu.field_bgId;
        v.d("MicroMsg.SnsHeader", "showName " + str + " get bgId : " + str2 + "  olderBgId：　" + Bu.field_older_bgId);
        String zL = com.tencent.mm.plugin.sns.data.i.zL(str2);
        String str3 = str + "bg_";
        String str4 = str + "tbg_";
        String cA = al.cA(xh, str);
        FileOp.jS(cA);
        if ((Bu.field_local_flag & 1) > 0) {
            v.d("MicroMsg.SnsHeader", "bg is change");
            ad.aSG().Bt(str);
            if (FileOp.aR(al.cA(xh, str) + str3)) {
                FileOp.deleteFile(al.cA(xh, str) + str4);
                FileOp.n(al.cA(xh, str), str3, str4);
            }
            Bu.field_local_flag &= -2;
            ad.aSG().c(Bu);
        }
        if (FileOp.aR(al.cA(ad.xh(), str2) + zL) && !FileOp.aR(al.cA(xh, str) + str3)) {
            FileOp.p(al.cA(xh, str2) + zL, al.cA(xh, str) + str3);
            v.d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        xh = Bu.field_bgUrl;
        if (str2 != null) {
            ad.aSB();
            String str5 = cA + str3;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.e.g.a(str5, xh, str2, true, ak.nvx);
            v.d("MicroMsg.SnsHeader", "set a new bg");
            if (a == null) {
                FileOp.deleteFile(cA + str3);
            }
        } else {
            a = null;
        }
        if (a == null && str2 != null) {
            ad.aSB();
            str5 = cA + str4;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.e.g.a(str5, xh, str2, false, ak.nvx);
        }
        if (this.jOu.jOE != null) {
            this.jOu.jOE.setImageBitmap(a);
            if (a != null) {
                this.jOu.jOE.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.jOz == null || this.jOz.isRecycled()) {
                        v.i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.jOz = d.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.jOu.jOE.setBackgroundDrawable(new BitmapDrawable(this.jOz));
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsHeader", e, "", new Object[0]);
                }
            }
        }
        this.jOu.jOF.setVisibility(8);
        if (a == null && (this.type == 1 || this.bYE.equals(str))) {
            this.jOu.jOF.setVisibility(0);
        }
        this.jOw = Bu.aUy();
    }

    public final boolean aWQ() {
        if (this.jOu.jOG == null) {
            return false;
        }
        int i;
        List aSV = ah.aSV();
        List linkedList = new LinkedList();
        for (i = 0; i < aSV.size(); i++) {
            k kVar = (k) aSV.get(i);
            try {
                if (((aic) new aic().az(kVar.field_postBuf)).mIC) {
                }
            } catch (Exception e) {
            }
            linkedList.add(kVar);
        }
        String str = "";
        i = 0;
        while (i < linkedList.size()) {
            String str2;
            try {
                if (((aic) new aic().az(((k) linkedList.get(i)).field_postBuf)).mIC) {
                    str2 = str;
                    i++;
                    str = str2;
                }
            } catch (Exception e2) {
            }
            str2 = str + ((k) linkedList.get(i)).aUL() + " ";
            i++;
            str = str2;
        }
        v.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[]{Integer.valueOf(linkedList.size()), str, this.jOy});
        if (!str.equals(this.jOy)) {
            this.jOy = str;
            this.jOu.jOG.removeAllViews();
            this.jOu.jOG.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new c(this));
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinearLayout linearLayout;
                View view;
                int i3 = ((k) linkedList.get(i2)).jBI;
                i = linkedList.size();
                if (!this.jOx.containsKey(Integer.valueOf(i3)) || this.jOx.get(Integer.valueOf(i3)) == null) {
                    linearLayout = (LinearLayout) q.em(this.context).inflate(2130903783, null);
                    linearLayout.getChildAt(0).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsHeader jOA;

                        public final void onClick(View view) {
                            if (view.getTag() instanceof String) {
                                String str = (String) view.getTag();
                                v.i("MicroMsg.SnsHeader", "sns Header localId " + str);
                                k Bq = ad.aSE().Bq(str);
                                if (this.jOA.context != null && Bq != null) {
                                    Intent intent = new Intent();
                                    intent.setClass(this.jOA.context, SnsCommentDetailUI.class);
                                    if (Bq == null || Bq.field_userName == null || Bq.field_userName.equals("")) {
                                        v.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                                        return;
                                    }
                                    intent.putExtra("INTENT_TALKER", Bq.field_userName);
                                    intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                                    intent.putExtra("INTENT_FROMGALLERY", true);
                                    com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(726);
                                    gh.gk(i).gk(i2).gk(Bq.field_createTime);
                                    gh.JF();
                                    this.jOA.context.startActivity(intent);
                                    try {
                                        aic com_tencent_mm_protocal_c_aic = (aic) new aic().az(Bq.field_postBuf);
                                        if (com_tencent_mm_protocal_c_aic.mIt == 201 || com_tencent_mm_protocal_c_aic.mIt == 210 || com_tencent_mm_protocal_c_aic.mIt != 211) {
                                            com_tencent_mm_protocal_c_aic.mIC = true;
                                            Bq.field_postBuf = com_tencent_mm_protocal_c_aic.toByteArray();
                                            ad.aSE().b(Bq.jBI, Bq);
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        }
                    });
                    this.jOx.put(Integer.valueOf(i3), linearLayout);
                } else {
                    view = (View) this.jOx.get(Integer.valueOf(i3));
                }
                linearLayout = (LinearLayout) view;
                linearLayout.getChildAt(0).setTag(((k) linkedList.get(i2)).aUL());
                TextView textView = (TextView) linearLayout.findViewById(2131757435);
                if (((k) linkedList.get(i2)).field_type == 15) {
                    textView.setText(2131235508);
                } else {
                    textView.setTag(Integer.valueOf(2131235503));
                }
                this.jOu.jOG.addView(linearLayout);
            }
            if (linkedList.size() > 0) {
                return true;
            }
            return false;
        } else if (linkedList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
