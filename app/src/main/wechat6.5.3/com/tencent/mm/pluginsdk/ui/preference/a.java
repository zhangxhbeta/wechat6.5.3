package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.i;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends LinearLayout implements e {
    static a lPk;
    private Context context;
    p dwg;
    private TextView dyL;
    private Button lPl;

    public static class a {
        public String bdo;
        public String hUb;
        public int scene;
        public int type;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.pluginsdk.ui.preference.a r9, java.lang.String r10) {
        /*
        r7 = 0;
        r6 = 1;
        r0 = lPk;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "FMessage Args is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x000f:
        return;
    L_0x0010:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "try to reply verify content";
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r2 = new java.util.LinkedList;
        r2.<init>();
        r0 = lPk;
        r0 = r0.bdo;
        r2.add(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = lPk;
        r0 = r0.scene;
        r0 = java.lang.Integer.valueOf(r0);
        r3.add(r0);
        r0 = lPk;
        r0 = r0.type;
        r1 = lPk;
        r1 = r1.bdo;
        r4 = "MicroMsg.FMessageItemView";
        r5 = new java.lang.StringBuilder;
        r8 = "getOpCode, type = ";
        r5.<init>(r8);
        r5 = r5.append(r0);
        r8 = ", talker = ";
        r5 = r5.append(r8);
        r5 = r5.append(r1);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.d(r4, r5);
        switch(r0) {
            case 0: goto L_0x00b2;
            case 1: goto L_0x00f4;
            case 2: goto L_0x0111;
            default: goto L_0x0061;
        };
    L_0x0061:
        r1 = 6;
    L_0x0062:
        r0 = "MicroMsg.FMessageItemView";
        r4 = new java.lang.StringBuilder;
        r5 = "reply, final opcode = ";
        r4.<init>(r5);
        r4 = r4.append(r1);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r4);
        r0 = com.tencent.mm.model.ak.vy();
        r4 = 30;
        r0.a(r4, r9);
        r0 = new com.tencent.mm.pluginsdk.model.m;
        r4 = lPk;
        r5 = r4.hUb;
        r4 = r10;
        r0.<init>(r1, r2, r3, r4, r5);
        r1 = com.tencent.mm.model.ak.vy();
        r1.a(r0, r7);
        r1 = r9.context;
        r2 = r9.context;
        r3 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r2.getString(r3);
        r2 = r9.context;
        r3 = 2131231151; // 0x7f0801af float:1.8078375E38 double:1.052968095E-314;
        r2 = r2.getString(r3);
        r3 = new com.tencent.mm.pluginsdk.ui.preference.a$2;
        r3.<init>(r9, r0);
        r0 = com.tencent.mm.ui.base.g.a(r1, r2, r6, r3);
        r9.dwg = r0;
        goto L_0x000f;
    L_0x00b2:
        if (r1 == 0) goto L_0x00ba;
    L_0x00b4:
        r0 = r1.length();
        if (r0 != 0) goto L_0x00c8;
    L_0x00ba:
        r0 = "MicroMsg.FMessageLogic";
        r1 = "isVerifyReceiver, invalid argument";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x00c3:
        r0 = r7;
    L_0x00c4:
        if (r0 != 0) goto L_0x0061;
    L_0x00c6:
        r1 = 5;
        goto L_0x0062;
    L_0x00c8:
        r0 = com.tencent.mm.ar.l.KC();
        r0 = r0.kH(r1);
        if (r0 != 0) goto L_0x00e9;
    L_0x00d2:
        r0 = "MicroMsg.FMessageLogic";
        r4 = new java.lang.StringBuilder;
        r5 = "isVerifyReceiver, lastRecvFmsg does not exist, talker = ";
        r4.<init>(r5);
        r1 = r4.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x00c3;
    L_0x00e9:
        r1 = r0.field_type;
        if (r1 == r6) goto L_0x00f2;
    L_0x00ed:
        r0 = r0.field_type;
        r1 = 2;
        if (r0 != r1) goto L_0x00c3;
    L_0x00f2:
        r0 = r6;
        goto L_0x00c4;
    L_0x00f4:
        r0 = com.tencent.mm.ar.l.KE();
        r0 = r0.kM(r1);
        if (r0 != 0) goto L_0x0109;
    L_0x00fe:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last lbsMsg is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0061;
    L_0x0109:
        r0 = r0.field_content;
        r1 = HM(r0);
        goto L_0x0062;
    L_0x0111:
        r0 = com.tencent.mm.ar.l.KF();
        r0 = r0.kO(r1);
        if (r0 != 0) goto L_0x0126;
    L_0x011b:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last shakeMsg is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0061;
    L_0x0126:
        r0 = r0.field_content;
        r1 = HM(r0);
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.preference.a.a(com.tencent.mm.pluginsdk.ui.preference.a, java.lang.String):void");
    }

    public a(Context context) {
        super(context);
        this.context = context;
        View inflate = View.inflate(this.context, 2130903658, this);
        this.dyL = (TextView) inflate.findViewById(2131757079);
        this.lPl = (Button) inflate.findViewById(2131757080);
        this.lPl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a lPm;

            {
                this.lPm = r1;
            }

            public final void onClick(View view) {
                View inflate = View.inflate(this.lPm.context, 2130904345, null);
                ((TextView) inflate.findViewById(2131759061)).setVisibility(8);
                final TextView textView = (TextView) inflate.findViewById(2131756526);
                textView.setVisibility(0);
                textView.setText("50");
                final EditText editText = (EditText) inflate.findViewById(2131759062);
                editText.setSingleLine(false);
                c.b(editText).yn(100).a(null);
                editText.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ AnonymousClass1 lPo;

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        int aw = h.aw(100, editable.toString());
                        if (textView != null) {
                            textView.setText(String.valueOf(aw));
                        }
                    }
                });
                g.a(this.lPm.context, this.lPm.context.getString(2131231141), inflate, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 lPo;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = editText.getText().toString().trim();
                        if (trim != null && trim.length() > 0) {
                            a.a(this.lPo.lPm, trim);
                        }
                    }
                }, null);
                editText.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lPo;

                    {
                        this.lPo = r1;
                    }

                    public final void run() {
                        if (this.lPo.lPm.context instanceof MMActivity) {
                            ((MMActivity) this.lPo.lPm.context).aJs();
                        }
                    }
                });
            }
        });
    }

    private static int HM(String str) {
        if (str == null) {
            v.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            return 6;
        }
        switch (d.MB(str).bdn) {
            case 2:
            case 5:
                return 6;
            case 6:
                return 5;
            default:
                return 6;
        }
    }

    public final void HN(String str) {
        this.dyL.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, be.ma(str), this.dyL.getTextSize()));
    }

    public final void ur(int i) {
        if (this.lPl != null) {
            this.lPl.setVisibility(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 30) {
            v.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.dwg != null) {
                this.dwg.dismiss();
            }
            if (i == 0 && i2 == 0) {
                int i3 = ((m) kVar).bdn;
                String str2 = ((m) kVar).lzE;
                v.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
                v.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + lPk.type);
                switch (lPk.type) {
                    case 1:
                        com.tencent.mm.ar.h hVar = new com.tencent.mm.ar.h();
                        hVar.field_createtime = i.kN(lPk.bdo);
                        hVar.field_isSend = 1;
                        hVar.field_content = str2;
                        hVar.field_talker = "fmessage";
                        hVar.field_sayhiuser = lPk.bdo;
                        hVar.field_svrid = System.currentTimeMillis();
                        hVar.field_status = 4;
                        l.KE().a(hVar);
                        break;
                    case 2:
                        j jVar = new j();
                        jVar.field_createtime = com.tencent.mm.ar.k.kN(lPk.bdo);
                        jVar.field_isSend = 1;
                        jVar.field_content = str2;
                        jVar.field_talker = "fmessage";
                        jVar.field_sayhiuser = lPk.bdo;
                        jVar.field_svrid = System.currentTimeMillis();
                        jVar.field_status = 4;
                        v.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = " + l.KF().a(jVar));
                        break;
                    default:
                        f fVar = new f();
                        fVar.field_createTime = com.tencent.mm.ar.e.h(lPk.bdo, 0);
                        fVar.field_isSend = 1;
                        fVar.field_msgContent = str2;
                        fVar.field_talker = lPk.bdo;
                        fVar.field_type = i3 == 5 ? 2 : 3;
                        v.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = " + l.KC().a(fVar));
                        break;
                }
            }
            if (i == 4 && i2 == -34) {
                str = this.context.getString(2131232851);
            } else if (i == 4 && i2 == -94) {
                str = this.context.getString(2131232852);
            } else if (!(i == 4 && i2 == -24 && !be.kS(str))) {
                str = this.context.getString(2131234920);
            }
            Toast.makeText(this.context, str, 1).show();
            ak.vy().b(30, this);
        }
    }
}
