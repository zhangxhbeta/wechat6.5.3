package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    public LinearLayout nGc;
    public View nGd;
    public TextView nGe;
    public TextView nGf;
    public TextView nGg;
    public String nGh;
    public String nGi;
    public boolean nGj;
    public int nGk = b.nGu;
    public a nGl;
    private final int nGm = 6;
    public LinearLayout nGn;
    public boolean nGo = false;
    public com.tencent.mm.ah.b pQS = new com.tencent.mm.ah.b();

    class a {
        final /* synthetic */ MultiTalkRoomPopupNav nGp;
        LinearLayout nGq;
        private Button nGr;
        TextView titleView;

        private a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z) {
            this.nGp = multiTalkRoomPopupNav;
            this.nGr = (Button) multiTalkRoomPopupNav.findViewById(2131758365);
            this.titleView = (TextView) multiTalkRoomPopupNav.findViewById(2131758361);
            this.nGq = (LinearLayout) multiTalkRoomPopupNav.findViewById(2131758360);
            if (z) {
                this.nGq.setBackgroundResource(2130838729);
                this.nGr.setTextColor(multiTalkRoomPopupNav.getResources().getColor(2131689890));
                return;
            }
            this.nGq.setBackgroundResource(2130838722);
            this.nGr.setTextColor(multiTalkRoomPopupNav.getResources().getColor(2131689585));
        }
    }

    enum b {
        ;

        static {
            nGs = 1;
            nGt = 2;
            nGu = 3;
            nGv = new int[]{nGs, nGt, nGu};
        }
    }

    static /* synthetic */ void Od(String str) {
        v.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        com.tencent.mm.pluginsdk.j.a.lxR.wP(str);
        v.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!com.tencent.mm.pluginsdk.j.a.lxR.wN(str)) {
            v.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:" + str);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        if (multiTalkRoomPopupNav.nGh == null || multiTalkRoomPopupNav.nGi == null) {
            v.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.nGh + ",currentSenderUserName:" + multiTalkRoomPopupNav.nGi);
        } else if (!multiTalkRoomPopupNav.nGh.toLowerCase().endsWith("@chatroom") || multiTalkRoomPopupNav.nGj) {
            String str = multiTalkRoomPopupNav.nGh;
            if (com.tencent.mm.pluginsdk.j.a.lxR == null || !com.tencent.mm.pluginsdk.j.a.lxR.wH(str)) {
                v.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
                g.A(multiTalkRoomPopupNav.getContext(), aa.getContext().getString(2131233956), null);
                multiTalkRoomPopupNav.bAB();
                r3 = com.tencent.mm.plugin.report.service.g.iuh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.nGh;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
                r3.h(13945, r5);
                return;
            }
            List wJ = com.tencent.mm.pluginsdk.j.a.lxR.wJ(str);
            if (wJ.size() == 0) {
                v.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                g.A(multiTalkRoomPopupNav.getContext(), aa.getContext().getString(2131233956), null);
                multiTalkRoomPopupNav.bAB();
                r3 = com.tencent.mm.plugin.report.service.g.iuh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.nGh;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
                r3.h(13945, r5);
                return;
            }
            if (wJ.size() == 1) {
                v.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
            }
            if (multiTalkRoomPopupNav.nGk == b.nGt) {
                multiTalkRoomPopupNav.nGo = true;
                Intent intent = new Intent();
                intent.putExtra("enterMainUiSource", 2);
                intent.putExtra("enterMainUiWxGroupId", str);
                c.b(aa.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                r3 = com.tencent.mm.plugin.report.service.g.iuh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(0);
                r5[4] = multiTalkRoomPopupNav.nGh;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
                r3.h(13945, r5);
            } else if (multiTalkRoomPopupNav.nGk == b.nGs) {
                if (com.tencent.mm.pluginsdk.j.a.lxR.cf(str, multiTalkRoomPopupNav.nGi) != null) {
                    r4 = aa.getContext().getString(2131232448, new Object[]{com.tencent.mm.pluginsdk.j.a.lxR.er(com.tencent.mm.pluginsdk.j.a.lxR.cf(str, multiTalkRoomPopupNav.nGi))});
                    r5 = i(wJ, multiTalkRoomPopupNav.nGi);
                    wJ.size();
                    multiTalkRoomPopupNav.c(r4, r5, str);
                }
                r3 = com.tencent.mm.plugin.report.service.g.iuh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(0);
                r5[4] = multiTalkRoomPopupNav.nGh;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
                r3.h(13945, r5);
            } else if (com.tencent.mm.pluginsdk.j.a.lxR.aCu()) {
                g.A(multiTalkRoomPopupNav.getContext(), aa.getContext().getString(2131233940), null);
                r3 = com.tencent.mm.plugin.report.service.g.iuh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.nGh;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
                r3.h(13945, r5);
            } else if (wJ.size() >= 9) {
                g.A(multiTalkRoomPopupNav.getContext(), aa.getContext().getString(2131233942, new Object[]{Integer.valueOf(9)}), null);
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                if (multiTalkRoomPopupNav.nGk == b.nGs) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Integer.valueOf(1);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.nGh;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
                gVar.h(13945, objArr);
            } else {
                r4 = aa.getContext().getString(2131233963);
                r5 = i(wJ, SQLiteDatabase.KeyEmpty);
                wJ.size();
                multiTalkRoomPopupNav.c(r4, r5, str);
                com.tencent.mm.plugin.report.service.g.iuh.h(13945, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.nGh, Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId), Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey));
            }
        } else {
            g.A(multiTalkRoomPopupNav.getContext(), aa.getContext().getString(2131233947), null);
            multiTalkRoomPopupNav.bAB();
            com.tencent.mm.pluginsdk.j.a.lxR.hc(multiTalkRoomPopupNav.nGh);
            r3 = com.tencent.mm.plugin.report.service.g.iuh;
            r5 = new Object[7];
            r5[0] = Integer.valueOf(4);
            r5[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
            r5[2] = Integer.valueOf(0);
            r5[3] = Integer.valueOf(1);
            r5[4] = multiTalkRoomPopupNav.nGh;
            r5[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
            r5[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
            r3.h(13945, r5);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        if (com.tencent.mm.pluginsdk.j.a.lxR.wO(str)) {
            com.tencent.mm.pluginsdk.j.a.lxR.wM(str);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = multiTalkRoomPopupNav.nGh;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
            gVar.h(13945, objArr);
            return;
        }
        Toast.makeText(aa.getContext(), aa.getContext().getString(2131233921), 0).show();
        gVar = com.tencent.mm.plugin.report.service.g.iuh;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.nGk == b.nGs ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.nGh;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.pQS.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.pQS.field_roomKey);
        gVar.h(13945, objArr);
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    private void NI() {
        inflate(getContext(), 2130904100, this);
        this.nGc = (LinearLayout) findViewById(2131758355);
        this.nGd = findViewById(2131758354);
        this.nGe = (TextView) findViewById(2131758357);
        this.nGf = (TextView) findViewById(2131758358);
        this.nGg = (TextView) findViewById(2131758359);
        this.nGn = (LinearLayout) findViewById(2131758362);
        this.nGc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MultiTalkRoomPopupNav nGp;

            {
                this.nGp = r1;
            }

            public final void onClick(View view) {
                if (com.tencent.mm.pluginsdk.j.a.lxQ != null && com.tencent.mm.pluginsdk.j.a.lxR.bj(this.nGp.getContext())) {
                    v.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
                } else if (com.tencent.mm.pluginsdk.j.a.lxQ == null || !com.tencent.mm.pluginsdk.j.a.lxQ.awy()) {
                    MultiTalkRoomPopupNav.a(this.nGp);
                } else {
                    Toast.makeText(aa.getContext(), aa.getContext().getString(2131233931), 0).show();
                    v.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
                }
            }
        });
    }

    public final void Oc(String str) {
        this.nGd.setBackgroundResource(2130838722);
        this.nGe.setTextColor(getResources().getColor(2131689890));
        this.nGe.setText(str);
        if (this.nGn == null || this.nGn.getVisibility() != 0) {
            this.nGe.setVisibility(0);
            this.nGg.setVisibility(8);
            this.nGf.setVisibility(8);
            this.nGn.setVisibility(8);
        }
    }

    public final void bAB() {
        this.nGo = false;
        setVisibility(8);
        if (this.nGl != null) {
            this.nGl.nGq.setVisibility(8);
        }
    }

    private void c(String str, List<String> list, final String str2) {
        boolean z;
        this.nGd.setVisibility(8);
        this.nGc.setVisibility(8);
        if (this.nGk == b.nGs) {
            z = true;
        } else {
            z = false;
        }
        this.nGl = new a(z);
        if (com.tencent.mm.pluginsdk.j.a.lxR != null) {
            a aVar = this.nGl;
            OnClickListener anonymousClass2 = new OnClickListener(this) {
                final /* synthetic */ MultiTalkRoomPopupNav nGp;

                public final void onClick(View view) {
                    int i = 0;
                    if (str2 != null) {
                        if (com.tencent.mm.pluginsdk.j.a.lxR.aCu()) {
                            g.A(this.nGp.getContext(), aa.getContext().getString(2131233940), null);
                            return;
                        }
                        List wJ = com.tencent.mm.pluginsdk.j.a.lxR.wJ(this.nGp.nGh);
                        if (wJ.size() == 1) {
                            MultiTalkRoomPopupNav.Od(str2);
                            com.tencent.mm.plugin.report.service.g.iuh.h(13945, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), this.nGp.nGh, Integer.valueOf(this.nGp.pQS.field_roomId), Long.valueOf(this.nGp.pQS.field_roomKey));
                        } else if (wJ.size() >= 9) {
                            g.A(this.nGp.getContext(), aa.getContext().getString(2131233942, new Object[]{Integer.valueOf(9)}), null);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            Object[] objArr = new Object[7];
                            objArr[0] = Integer.valueOf(1);
                            if (this.nGp.nGk == b.nGs) {
                                i = 1;
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = Integer.valueOf(1);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = this.nGp.nGh;
                            objArr[5] = Integer.valueOf(this.nGp.pQS.field_roomId);
                            objArr[6] = Long.valueOf(this.nGp.pQS.field_roomKey);
                            gVar.h(13945, objArr);
                            return;
                        } else if (com.tencent.mm.pluginsdk.j.a.lxR.aCt()) {
                            g.A(this.nGp.getContext(), aa.getContext().getString(2131233939), null);
                            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.iuh;
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Integer.valueOf(1);
                            objArr2[1] = Integer.valueOf(this.nGp.nGk == b.nGs ? 1 : 0);
                            objArr2[2] = Integer.valueOf(0);
                            objArr2[3] = Integer.valueOf(1);
                            objArr2[4] = this.nGp.nGh;
                            objArr2[5] = Integer.valueOf(this.nGp.pQS.field_roomId);
                            objArr2[6] = Long.valueOf(this.nGp.pQS.field_roomKey);
                            gVar2.h(13945, objArr2);
                            return;
                        } else {
                            MultiTalkRoomPopupNav.a(this.nGp, str2);
                        }
                    }
                    this.nGp.nGl.nGq.setVisibility(8);
                    this.nGp.nGc.setVisibility(0);
                    this.nGp.nGd.setVisibility(0);
                    this.nGp.nGn.setVisibility(8);
                }
            };
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ MultiTalkRoomPopupNav nGp;

                public final void onClick(View view) {
                    int i = 1;
                    if (this.nGp.nGk == b.nGs) {
                        v.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
                        boolean wL = com.tencent.mm.pluginsdk.j.a.lxR.wL(str2);
                        com.tencent.mm.pluginsdk.j.a.lxR.wM(str2);
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Integer.valueOf(0);
                        if (wL) {
                            i = 0;
                        }
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = this.nGp.nGh;
                        objArr[5] = Integer.valueOf(this.nGp.pQS.field_roomId);
                        objArr[6] = Long.valueOf(this.nGp.pQS.field_roomKey);
                        gVar.h(13945, objArr);
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.h(13945, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), this.nGp.nGh, Integer.valueOf(this.nGp.pQS.field_roomId), Long.valueOf(this.nGp.pQS.field_roomKey));
                    }
                    this.nGp.nGl.nGq.setVisibility(8);
                    this.nGp.nGc.setVisibility(0);
                    this.nGp.nGd.setVisibility(0);
                    this.nGp.nGn.setVisibility(8);
                }
            };
            aVar.titleView.setText(str);
            aVar.nGq.setVisibility(0);
            aVar.nGp.nGn.setVisibility(0);
            aVar.nGp.nGn.removeAllViews();
            for (String str3 : list) {
                View imageView = new ImageView(aVar.nGp.getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 26), com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                aVar.nGp.nGn.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3, 0.1f, false);
            }
            ((Button) aVar.nGp.findViewById(2131758366)).setOnClickListener(anonymousClass2);
            ((Button) aVar.nGp.findViewById(2131758365)).setOnClickListener(anonymousClass3);
        }
    }

    public final void cl(List<String> list) {
        if (this.nGn != null && this.nGn.getVisibility() == 0) {
            this.nGn.removeAllViews();
            for (String str : list) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 26), com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.nGn.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str, 0.1f, false);
            }
        }
    }

    public static List<String> i(List<String> list, String str) {
        List<String> arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        if (!(str == null || str == SQLiteDatabase.KeyEmpty)) {
            for (String str2 : list) {
                if (!(str2 == null || str2.equals(str))) {
                    arrayList2.add(str2);
                }
            }
            list = arrayList2;
        }
        for (String str22 : r5) {
            arrayList.add(str22);
        }
        return arrayList;
    }
}
