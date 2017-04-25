package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class IPCallUserProfileUI extends MMActivity {
    private String bpN;
    private String bpP;
    private ImageView dtz;
    private boolean gKw = false;
    private TextView gOE;
    private TextView gOF;
    private LinearLayout gOG;
    private LinearLayout gOH;
    private TextView gOI;
    private TextView gOJ;
    private TextView gOK;
    private TextView gOL;
    private TextView gOM;
    private Button gON;
    private String gOO;
    private String gOP;
    private Bitmap gOQ;
    private boolean gOR;
    private Cursor gOS = null;
    private boolean gOT = false;
    private e gOU = new e();

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, final TextView textView) {
        l lVar = new l(iPCallUserProfileUI);
        lVar.jXn = new c(iPCallUserProfileUI) {
            final /* synthetic */ IPCallUserProfileUI gOV;

            {
                this.gOV = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.add(2131231015);
            }
        };
        lVar.jXo = new d(iPCallUserProfileUI) {
            final /* synthetic */ IPCallUserProfileUI gOV;

            public final void c(MenuItem menuItem, int i) {
                if (i == 0) {
                    g.iuh.h(12766, new Object[]{Integer.valueOf(4)});
                    com.tencent.mm.plugin.ipcall.b.c.c(this.gOV, textView.getText().toString());
                    Toast.makeText(this.gOV, 2131233366, 0).show();
                }
            }
        };
        lVar.aXZ();
    }

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (com.tencent.mm.plugin.ipcall.b.c.avB()) {
            Toast.makeText(iPCallUserProfileUI, 2131233397, 1).show();
            return;
        }
        Intent intent = new Intent(iPCallUserProfileUI, IPCallDialUI.class);
        if (iPCallUserProfileUI.gOT) {
            intent.putExtra("IPCallTalkUI_dialScene", 4);
            g.iuh.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        } else {
            intent.putExtra("IPCallTalkUI_dialScene", 2);
            g.iuh.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
        }
        intent.putExtra("IPCallTalkUI_contactId", iPCallUserProfileUI.bpN);
        intent.putExtra("IPCallTalkUI_nickname", iPCallUserProfileUI.gOO);
        intent.putExtra("IPCallTalkUI_phoneNumber", com.tencent.mm.plugin.ipcall.b.c.vt(str));
        intent.putExtra("IPCallTalkUI_toWechatUsername", iPCallUserProfileUI.gOP);
        iPCallUserProfileUI.startActivityForResult(intent, 1001);
        iPCallUserProfileUI.gOR = true;
    }

    static /* synthetic */ void b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (!be.kS(iPCallUserProfileUI.bpN) && !be.kS(str) && !str.endsWith("@stranger")) {
            com.tencent.mm.plugin.ipcall.a.g.c uK = i.aur().uK(iPCallUserProfileUI.bpN);
            if (uK.nmb > 0) {
                uK.field_wechatUsername = str;
                i.aur().a(uK.nmb, uK);
            }
        }
    }

    protected final int NO() {
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        r10 = this;
        r2 = 0;
        r9 = 2131233370; // 0x7f080a5a float:1.8082876E38 double:1.0529691914E-314;
        r8 = 8;
        r6 = 1;
        r7 = 0;
        super.onCreate(r11);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 12061; // 0x2f1d float:1.6901E-41 double:5.959E-320;
        r3 = 6;
        r3 = new java.lang.Object[r3];
        r4 = java.lang.Integer.valueOf(r7);
        r3[r7] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r3[r6] = r4;
        r4 = 2;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r4 = 4;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r4 = 5;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r0.h(r1, r3);
        r0 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$1;
        r0.<init>(r10);
        r10.b(r0);
        r0 = 2131233372; // 0x7f080a5c float:1.808288E38 double:1.0529691924E-314;
        r10.vD(r0);
        r0 = 2131755508; // 0x7f1001f4 float:1.9141897E38 double:1.053227162E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r10.dtz = r0;
        r0 = 2131757573; // 0x7f100a05 float:1.9146086E38 double:1.053228182E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOE = r0;
        r0 = 2131757574; // 0x7f100a06 float:1.9146088E38 double:1.0532281826E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOF = r0;
        r0 = 2131757577; // 0x7f100a09 float:1.9146094E38 double:1.053228184E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.LinearLayout) r0;
        r10.gOG = r0;
        r0 = 2131757580; // 0x7f100a0c float:1.91461E38 double:1.0532281855E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOI = r0;
        r0 = 2131757579; // 0x7f100a0b float:1.9146098E38 double:1.053228185E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOK = r0;
        r0 = 2131757578; // 0x7f100a0a float:1.9146096E38 double:1.0532281846E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOJ = r0;
        r0 = 2131757576; // 0x7f100a08 float:1.9146092E38 double:1.0532281836E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.LinearLayout) r0;
        r10.gOH = r0;
        r0 = 2131757575; // 0x7f100a07 float:1.914609E38 double:1.053228183E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOL = r0;
        r0 = 2131757582; // 0x7f100a0e float:1.9146104E38 double:1.0532281865E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.gOM = r0;
        r0 = 2131757581; // 0x7f100a0d float:1.9146102E38 double:1.053228186E-314;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r10.gON = r0;
        r0 = r10.getIntent();
        r1 = "IPCallProfileUI_contactid";
        r0 = r0.getStringExtra(r1);
        r10.bpN = r0;
        r0 = r10.getIntent();
        r1 = "IPCallProfileUI_systemUsername";
        r0 = r0.getStringExtra(r1);
        r10.gOO = r0;
        r0 = r10.getIntent();
        r1 = "IPCallProfileUI_wechatUsername";
        r0 = r0.getStringExtra(r1);
        r10.gOP = r0;
        r0 = r10.getIntent();
        r1 = "IPCallProfileUI_phonenumber";
        r0 = r0.getStringExtra(r1);
        r10.bpP = r0;
        r0 = r10.getIntent();
        r1 = "IPCallProfileUI_isNeedShowRecord";
        r0 = r0.getBooleanExtra(r1, r7);
        r10.gOT = r0;
        r0 = r10.bpN;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0120;
    L_0x010d:
        r0 = r10.bpN;
        r0 = com.tencent.mm.plugin.ipcall.b.a.ad(r10, r0);
        r10.gOQ = r0;
        r0 = r10.gOQ;
        if (r0 == 0) goto L_0x0120;
    L_0x0119:
        r0 = r10.dtz;
        r1 = r10.gOQ;
        r0.setImageBitmap(r1);
    L_0x0120:
        r0 = r10.gOQ;
        if (r0 != 0) goto L_0x0140;
    L_0x0124:
        r0 = r10.gOP;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0140;
    L_0x012c:
        r0 = r10.gOP;
        r1 = -1;
        r0 = com.tencent.mm.u.b.a(r0, r7, r1);
        r10.gOQ = r0;
        r0 = r10.gOQ;
        if (r0 == 0) goto L_0x0140;
    L_0x0139:
        r0 = r10.dtz;
        r1 = r10.gOQ;
        r0.setImageBitmap(r1);
    L_0x0140:
        r0 = r10.gOO;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0197;
    L_0x0148:
        r0 = r10.gOE;
        r1 = r10.gOO;
        r0.setText(r1);
    L_0x014f:
        r0 = r10.gOP;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x01ab;
    L_0x0157:
        r0 = r10.gOP;
        r1 = "@stranger";
        r0 = r0.endsWith(r1);
        if (r0 != 0) goto L_0x01ab;
    L_0x0162:
        r0 = 2131233373; // 0x7f080a5d float:1.8082882E38 double:1.052969193E-314;
        r1 = new java.lang.Object[r6];
        r3 = r10.gOP;
        r3 = com.tencent.mm.model.l.er(r3);
        r1[r7] = r3;
        r0 = r10.getString(r0, r1);
        r1 = r10.gOF;
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r10, r0);
        r1.setText(r0);
    L_0x017c:
        r0 = r10.bpN;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x01d2;
    L_0x0184:
        r0 = "android.permission.READ_CONTACTS";
        r0 = com.tencent.mm.pluginsdk.i.a.aP(r10, r0);
        if (r0 != 0) goto L_0x01b1;
    L_0x018d:
        r0 = "MicroMsg.IPCallUserProfileUI";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x0196:
        return;
    L_0x0197:
        r0 = r10.bpP;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x014f;
    L_0x019f:
        r0 = r10.gOE;
        r1 = r10.bpP;
        r1 = com.tencent.mm.plugin.ipcall.b.a.vp(r1);
        r0.setText(r1);
        goto L_0x014f;
    L_0x01ab:
        r0 = r10.gOF;
        r0.setVisibility(r8);
        goto L_0x017c;
    L_0x01b1:
        r0 = r10.getContentResolver();
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r3 = "contact_id=?";
        r4 = new java.lang.String[r6];
        r5 = r10.bpN;
        r4[r7] = r5;
        r5 = r2;
        r0 = r0.query(r1, r2, r3, r4, r5);
        r10.gOS = r0;
        r0 = r10.gOS;
        r0 = r0.getCount();
        if (r0 > r6) goto L_0x02a3;
    L_0x01cf:
        r0 = r6;
    L_0x01d0:
        r10.gKw = r0;
    L_0x01d2:
        r10.avr();
        r0 = r10.gOK;
        r0.setVisibility(r8);
        r0 = r10.gOJ;
        r0.setVisibility(r8);
        r0 = r10.gOI;
        r0.setVisibility(r8);
        r0 = r10.gON;
        r0.setVisibility(r8);
        r0 = r10.gOM;
        r0.setVisibility(r8);
        r0 = r10.gOP;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x02a6;
    L_0x01f6:
        r0 = r10.gOO;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x02a6;
    L_0x01fe:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wH();
        r1 = r10.gOP;
        r0 = r0.LX(r1);
        if (r0 == 0) goto L_0x022c;
    L_0x020d:
        r0 = r0.field_type;
        r0 = com.tencent.mm.i.a.ei(r0);
        if (r0 != 0) goto L_0x022c;
    L_0x0215:
        r0 = r10.gON;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$8;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
        r0 = r10.gON;
        r1 = 2131233367; // 0x7f080a57 float:1.808287E38 double:1.05296919E-314;
        r0.setText(r1);
        r0 = r10.gON;
        r0.setVisibility(r7);
    L_0x022c:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r10.gOS;
        if (r1 == 0) goto L_0x0313;
    L_0x0235:
        r1 = r10.gOS;
        r1 = r1.getCount();
        if (r1 <= 0) goto L_0x0313;
    L_0x023d:
        r1 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r1 = r1.moveToFirst();	 Catch:{ Exception -> 0x0288 }
        if (r1 == 0) goto L_0x030c;
    L_0x0245:
        r1 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r1 = r1.isAfterLast();	 Catch:{ Exception -> 0x0288 }
        if (r1 != 0) goto L_0x030c;
    L_0x024d:
        r7 = r7 + 1;
        r1 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r2 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r3 = "data1";
        r2 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x0288 }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0288 }
        r2 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r3 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r4 = "data2";
        r3 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x0288 }
        r2 = r2.getInt(r3);	 Catch:{ Exception -> 0x0288 }
        r3 = r0.contains(r1);	 Catch:{ Exception -> 0x0288 }
        if (r3 != 0) goto L_0x0282;
    L_0x0273:
        r0.add(r1);	 Catch:{ Exception -> 0x0288 }
        r3 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r3 = r3.getCount();	 Catch:{ Exception -> 0x0288 }
        if (r7 != r3) goto L_0x02ff;
    L_0x027e:
        r3 = 0;
        r10.j(r1, r2, r3);	 Catch:{ Exception -> 0x0288 }
    L_0x0282:
        r1 = r10.gOS;	 Catch:{ Exception -> 0x0288 }
        r1.moveToNext();	 Catch:{ Exception -> 0x0288 }
        goto L_0x0245;
    L_0x0288:
        r0 = move-exception;
        r1 = "MicroMsg.IPCallUserProfileUI";
        r2 = "initPhoneNumberList error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0305 }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0305 }
        r3[r4] = r0;	 Catch:{ all -> 0x0305 }
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);	 Catch:{ all -> 0x0305 }
        r0 = r10.gOS;
        r0.close();
        goto L_0x0196;
    L_0x02a3:
        r0 = r7;
        goto L_0x01d0;
    L_0x02a6:
        r0 = r10.bpN;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x02c0;
    L_0x02ae:
        r0 = r10.gOO;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x02c0;
    L_0x02b6:
        r10.avq();
        r0 = r10.gON;
        r0.setText(r9);
        goto L_0x022c;
    L_0x02c0:
        r0 = r10.bpP;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x022c;
    L_0x02c8:
        r0 = r10.gOJ;
        r0.setVisibility(r7);
        r0 = r10.gOK;
        r0.setVisibility(r7);
        r0 = r10.gOI;
        r0.setVisibility(r7);
        r0 = r10.gOI;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$10;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
        r0 = r10.gOJ;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$11;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
        r0 = r10.gOK;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$2;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
        r10.avq();
        r0 = r10.gON;
        r0.setText(r9);
        goto L_0x022c;
    L_0x02ff:
        r3 = 1;
        r10.j(r1, r2, r3);	 Catch:{ Exception -> 0x0288 }
        goto L_0x0282;
    L_0x0305:
        r0 = move-exception;
        r1 = r10.gOS;
        r1.close();
        throw r0;
    L_0x030c:
        r0 = r10.gOS;
        r0.close();
        goto L_0x0196;
    L_0x0313:
        r0 = r10.gOG;
        r0.setVisibility(r8);
        goto L_0x0196;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.onCreate(android.os.Bundle):void");
    }

    protected final int getLayoutId() {
        return 2130903825;
    }

    private void j(final String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this).inflate(2130904202, this.gOG, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131758668);
        if (z) {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(2130838468));
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        TextView textView = (TextView) inflate.findViewById(2131758669);
        final TextView textView2 = (TextView) inflate.findViewById(2131757550);
        textView2.setText(a.vp(com.tencent.mm.plugin.ipcall.b.c.vt(str)));
        textView.setText(a.mk(i));
        inflate.setClickable(true);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallUserProfileUI gOV;

            public final void onClick(View view) {
                IPCallUserProfileUI.a(this.gOV, str);
            }
        });
        inflate.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ IPCallUserProfileUI gOV;

            public final boolean onLongClick(View view) {
                IPCallUserProfileUI.a(this.gOV, textView2);
                return true;
            }
        });
        this.gOG.addView(inflate);
    }

    private static String vd(String str) {
        Exception e;
        String str2 = "";
        Cursor query;
        String str3;
        if (com.tencent.mm.pluginsdk.i.a.aP(aa.getContext(), "android.permission.READ_CONTACTS")) {
            query = aa.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    str3 = str2;
                    while (!query.isAfterLast()) {
                        try {
                            str2 = str3 + query.getString(query.getColumnIndex("data1")) + ",";
                            query.moveToNext();
                            str3 = str2;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                } else {
                    str3 = str2;
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                str3 = str2;
            }
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            return str3;
        }
        v.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
        return null;
        try {
            v.e("MicroMsg.IPCallUserProfileUI", "extractAddressItemFromCursor, error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            return str3;
        } finally {
            query.close();
        }
    }

    private void avq() {
        this.gON.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallUserProfileUI gOV;

            {
                this.gOV = r1;
            }

            public final void onClick(View view) {
                this.gOV.gOU.start();
                this.gOV.gOU.gIb = 1;
                this.gOV.gOU.gIc = 5;
                this.gOV.gOU.finish();
                g.iuh.h(12766, new Object[]{Integer.valueOf(3)});
                Intent intent;
                if (!be.kS(this.gOV.bpN)) {
                    intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.vd(this.gOV.bpN)));
                    intent.putExtra("sms_body", this.gOV.getString(2131233357, new Object[]{k.ym().tT()}));
                    this.gOV.startActivity(intent);
                } else if (!be.kS(this.gOV.bpP)) {
                    intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + this.gOV.bpP));
                    intent.putExtra("sms_body", this.gOV.getString(2131233357, new Object[]{k.ym().tT()}));
                    this.gOV.startActivity(intent);
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void avr() {
        /*
        r14 = this;
        r0 = r14.gOT;
        if (r0 != 0) goto L_0x0012;
    L_0x0004:
        r0 = r14.gOH;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r14.gOL;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0012:
        r0 = r14.bpN;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x011f;
    L_0x001a:
        r0 = r14.bpN;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 != 0) goto L_0x011c;
    L_0x0022:
        r1 = com.tencent.mm.plugin.ipcall.a.i.aur();
        r0 = r1.uK(r0);
        if (r0 == 0) goto L_0x011c;
    L_0x002c:
        r2 = r0.nmb;
        r4 = -1;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x011c;
    L_0x0034:
        r6 = r0.nmb;
        r0 = com.tencent.mm.plugin.ipcall.a.i.aus();
        r0 = r0.cie;
        r1 = "IPCallRecord";
        r2 = com.tencent.mm.plugin.ipcall.a.g.l.gIK;
        r3 = "addressId=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = java.lang.String.valueOf(r6);
        r4[r5] = r6;
        r5 = 0;
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r8 = "calltime desc limit 4";
        r7.<init>(r8);
        r7 = r7.toString();
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
    L_0x0060:
        r5 = r0;
    L_0x0061:
        if (r5 == 0) goto L_0x01a3;
    L_0x0063:
        r0 = r5.getCount();
        if (r0 <= 0) goto L_0x01a3;
    L_0x0069:
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x0155 }
        if (r0 == 0) goto L_0x0177;
    L_0x006f:
        r0 = 0;
    L_0x0070:
        r1 = r5.isAfterLast();	 Catch:{ Exception -> 0x0155 }
        if (r1 != 0) goto L_0x016e;
    L_0x0076:
        r6 = new com.tencent.mm.plugin.ipcall.a.g.k;	 Catch:{ Exception -> 0x0155 }
        r6.<init>();	 Catch:{ Exception -> 0x0155 }
        r6.b(r5);	 Catch:{ Exception -> 0x0155 }
        r3 = r0 + 1;
        r0 = 0;
        r1 = 3;
        if (r3 < r1) goto L_0x01b2;
    L_0x0084:
        r0 = 1;
        r4 = r0;
    L_0x0086:
        r7 = r5.getCount();	 Catch:{ Exception -> 0x0155 }
        r0 = android.view.LayoutInflater.from(r14);	 Catch:{ Exception -> 0x0155 }
        r1 = 2130904203; // 0x7f03048b float:1.7415246E38 double:1.0528065613E-314;
        r2 = r14.gOH;	 Catch:{ Exception -> 0x0155 }
        r8 = 0;
        r8 = r0.inflate(r1, r2, r8);	 Catch:{ Exception -> 0x0155 }
        r0 = 2131757607; // 0x7f100a27 float:1.9146155E38 double:1.053228199E-314;
        r0 = r8.findViewById(r0);	 Catch:{ Exception -> 0x0155 }
        r0 = (android.widget.TextView) r0;	 Catch:{ Exception -> 0x0155 }
        r1 = 2131757608; // 0x7f100a28 float:1.9146157E38 double:1.0532281994E-314;
        r1 = r8.findViewById(r1);	 Catch:{ Exception -> 0x0155 }
        r1 = (android.widget.TextView) r1;	 Catch:{ Exception -> 0x0155 }
        r2 = 2131757609; // 0x7f100a29 float:1.9146159E38 double:1.0532282E-314;
        r2 = r8.findViewById(r2);	 Catch:{ Exception -> 0x0155 }
        r2 = (android.widget.TextView) r2;	 Catch:{ Exception -> 0x0155 }
        r9 = r6.field_phonenumber;	 Catch:{ Exception -> 0x0155 }
        r9 = com.tencent.mm.plugin.ipcall.b.a.vp(r9);	 Catch:{ Exception -> 0x0155 }
        r1.setText(r9);	 Catch:{ Exception -> 0x0155 }
        r10 = r6.field_duration;	 Catch:{ Exception -> 0x0155 }
        r12 = 0;
        r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r1 <= 0) goto L_0x014a;
    L_0x00c4:
        r10 = r6.field_duration;	 Catch:{ Exception -> 0x0155 }
        r1 = com.tencent.mm.plugin.ipcall.b.c.cf(r10);	 Catch:{ Exception -> 0x0155 }
        r2.setText(r1);	 Catch:{ Exception -> 0x0155 }
    L_0x00cd:
        r10 = r6.field_calltime;	 Catch:{ Exception -> 0x0155 }
        r1 = com.tencent.mm.plugin.ipcall.b.c.cd(r10);	 Catch:{ Exception -> 0x0155 }
        r0.setText(r1);	 Catch:{ Exception -> 0x0155 }
        if (r4 == 0) goto L_0x00f6;
    L_0x00d8:
        r0 = r14.getResources();	 Catch:{ Exception -> 0x0155 }
        r1 = 2130838928; // 0x7f020590 float:1.7282852E38 double:1.052774311E-314;
        r0 = r0.getDrawable(r1);	 Catch:{ Exception -> 0x0155 }
        r8.setBackgroundDrawable(r0);	 Catch:{ Exception -> 0x0155 }
        r0 = r14.getResources();	 Catch:{ Exception -> 0x0155 }
        r1 = 2131492930; // 0x7f0c0042 float:1.8609326E38 double:1.053097431E-314;
        r0 = r0.getDimensionPixelSize(r1);	 Catch:{ Exception -> 0x0155 }
        r1 = 0;
        r2 = 0;
        r8.setPadding(r0, r1, r0, r2);	 Catch:{ Exception -> 0x0155 }
    L_0x00f6:
        r0 = 1;
        if (r0 != r7) goto L_0x010f;
    L_0x00f9:
        r0 = r8.getLayoutParams();	 Catch:{ Exception -> 0x0155 }
        r0 = (android.widget.LinearLayout.LayoutParams) r0;	 Catch:{ Exception -> 0x0155 }
        r1 = r14.nDR;	 Catch:{ Exception -> 0x0155 }
        r1 = r1.nEl;	 Catch:{ Exception -> 0x0155 }
        r2 = 2131493544; // 0x7f0c02a8 float:1.8610571E38 double:1.0530977344E-314;
        r1 = com.tencent.mm.bd.a.N(r1, r2);	 Catch:{ Exception -> 0x0155 }
        r0.height = r1;	 Catch:{ Exception -> 0x0155 }
        r8.setLayoutParams(r0);	 Catch:{ Exception -> 0x0155 }
    L_0x010f:
        r0 = r14.gOH;	 Catch:{ Exception -> 0x0155 }
        r0.addView(r8);	 Catch:{ Exception -> 0x0155 }
        if (r4 != 0) goto L_0x016d;
    L_0x0116:
        r5.moveToNext();	 Catch:{ Exception -> 0x0155 }
        r0 = r3;
        goto L_0x0070;
    L_0x011c:
        r0 = 0;
        goto L_0x0060;
    L_0x011f:
        r0 = com.tencent.mm.plugin.ipcall.a.i.aus();
        r5 = r14.bpP;
        r0 = r0.cie;
        r1 = "IPCallRecord";
        r2 = com.tencent.mm.plugin.ipcall.a.g.l.gIK;
        r3 = "phonenumber=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r6 = 0;
        r4[r6] = r5;
        r5 = 0;
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r8 = "calltime desc limit 4";
        r7.<init>(r8);
        r7 = r7.toString();
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r5 = r0;
        goto L_0x0061;
    L_0x014a:
        r1 = r6.field_status;	 Catch:{ Exception -> 0x0155 }
        r1 = com.tencent.mm.plugin.ipcall.b.c.ml(r1);	 Catch:{ Exception -> 0x0155 }
        r2.setText(r1);	 Catch:{ Exception -> 0x0155 }
        goto L_0x00cd;
    L_0x0155:
        r0 = move-exception;
        r1 = "MicroMsg.IPCallUserProfileUI";
        r2 = "initRecordList, error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x019e }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x019e }
        r3[r4] = r0;	 Catch:{ all -> 0x019e }
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);	 Catch:{ all -> 0x019e }
        r5.close();
    L_0x016c:
        return;
    L_0x016d:
        r0 = r3;
    L_0x016e:
        if (r0 > 0) goto L_0x017b;
    L_0x0170:
        r0 = r14.gOH;	 Catch:{ Exception -> 0x0155 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x0155 }
    L_0x0177:
        r5.close();
        goto L_0x016c;
    L_0x017b:
        r0 = r5.getCount();	 Catch:{ Exception -> 0x0155 }
        r1 = 4;
        if (r0 < r1) goto L_0x0177;
    L_0x0182:
        r0 = android.view.LayoutInflater.from(r14);	 Catch:{ Exception -> 0x0155 }
        r1 = 2130904204; // 0x7f03048c float:1.7415248E38 double:1.052806562E-314;
        r2 = r14.gOH;	 Catch:{ Exception -> 0x0155 }
        r3 = 0;
        r0 = r0.inflate(r1, r2, r3);	 Catch:{ Exception -> 0x0155 }
        r1 = r14.gOH;	 Catch:{ Exception -> 0x0155 }
        r1.addView(r0);	 Catch:{ Exception -> 0x0155 }
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$3;	 Catch:{ Exception -> 0x0155 }
        r1.<init>(r14);	 Catch:{ Exception -> 0x0155 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x0155 }
        goto L_0x0177;
    L_0x019e:
        r0 = move-exception;
        r5.close();
        throw r0;
    L_0x01a3:
        r0 = r14.gOH;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r14.gOL;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x016c;
    L_0x01b2:
        r4 = r0;
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.avr():void");
    }

    protected void onResume() {
        super.onResume();
        if (this.gOR) {
            this.gOR = false;
            this.gOH.removeAllViews();
            avr();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
