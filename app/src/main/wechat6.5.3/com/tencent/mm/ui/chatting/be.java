package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.e.a.ji;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.e.a.pz;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.t.g;
import com.tencent.mm.t.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ChattingUI.b;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class be extends ad {
    static int ooH = Color.parseColor("#888888");
    static int ooI = Color.parseColor("#888888");
    private String dzg;
    private p nGQ;
    private c nHa;
    private com.tencent.mm.sdk.c.c<ji> ojR;
    private a onG;
    private OnClickListener ooC;
    private OnClickListener ooD;
    private OnClickListener ooE;
    private b ooF;
    private String ooG;

    static /* synthetic */ void b(be beVar, String str) {
        com.tencent.mm.sdk.c.b mVar = new m();
        mVar.aWJ.aWH = str;
        com.tencent.mm.sdk.c.a.nhr.z(mVar);
        if (mVar.aWK.aWL) {
            y(1, mVar.aWK.appId, beVar.ooG);
        }
        Intent intent = new Intent();
        intent.putExtra("key_username", str);
        intent.putExtra("key_from_scene", 5);
        if (mVar.aWK.aWL) {
            intent.putExtra("key_scene_export_url_params", new AppBrandExportUrlParams(mVar.aWK.appId, 6));
        }
        com.tencent.mm.ay.c.b(beVar.onG.nDR.nEl, "appbrand", ".ui.AppBrandProfileUI", intent);
    }

    public be() {
        super(40);
        c.a aVar = new c.a();
        this.nHa = aVar.GU();
        this.ooC = new OnClickListener(this) {
            final /* synthetic */ be ooJ;

            {
                this.ooJ = r1;
            }

            public final void onClick(final View view) {
                final at atVar = (at) view.getTag(2131756120);
                if (atVar == null) {
                    v.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                    return;
                }
                Map q = bf.q(atVar.field_content, "msg");
                if (q != null && q.size() != 0) {
                    final String ma = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"));
                    com.tencent.mm.sdk.c.b mVar = new m();
                    mVar.aWJ.aWH = ma;
                    com.tencent.mm.sdk.c.a.nhr.z(mVar);
                    final int n = com.tencent.mm.sdk.platformtools.be.n(q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                    final int n2 = com.tencent.mm.sdk.platformtools.be.n(q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                    f fVar = new f(view.getContext(), f.pbS, false);
                    final boolean z = (mVar.aWK.aWN & 1) > 0;
                    if (z) {
                        fVar.c(view.getResources().getString(2131234129), 3);
                    } else {
                        fVar.c(view.getResources().getString(2131234114), 3);
                    }
                    fVar.jXn = new n.c(this) {
                        final /* synthetic */ AnonymousClass1 ooL;

                        public final void a(l lVar) {
                            if (z) {
                                lVar.a(1, view.getResources().getColor(2131689767), view.getResources().getString(2131234128));
                            } else {
                                lVar.a(0, view.getResources().getColor(2131689961), view.getResources().getString(2131234113));
                            }
                            lVar.add(0, 2, 0, view.getResources().getString(2131234119));
                        }
                    };
                    final View view2 = view;
                    fVar.jXo = new d(this) {
                        final /* synthetic */ AnonymousClass1 ooL;

                        public final void c(MenuItem menuItem, int i) {
                            v.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                            com.tencent.mm.sdk.c.b pzVar;
                            LinkedList linkedList;
                            ayy com_tencent_mm_protocal_c_ayy;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    ((dr) view2.getTag(2131756119)).oyl.setVisibility(0);
                                    pzVar = new pz();
                                    pzVar.brl.aWH = ma;
                                    pzVar.brl.action = 1;
                                    pzVar.brl.brn = 1;
                                    com.tencent.mm.sdk.c.a.nhr.z(pzVar);
                                    linkedList = new LinkedList();
                                    com_tencent_mm_protocal_c_ayy = new ayy();
                                    com_tencent_mm_protocal_c_ayy.mWa = ma;
                                    com_tencent_mm_protocal_c_ayy.mVZ = 0;
                                    com_tencent_mm_protocal_c_ayy.efm = 1;
                                    linkedList.add(com_tencent_mm_protocal_c_ayy);
                                    be.y(2, this.ooL.ooJ.dzg, this.ooL.ooJ.ooG);
                                    ak.vy().a(1176, new e(this) {
                                        final /* synthetic */ AnonymousClass2 ooM;

                                        {
                                            this.ooM = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            ak.vy().b(1176, (e) this);
                                            v.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true));
                                            if (atVar != view2.getTag(2131756120)) {
                                                v.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(atVar.field_msgId));
                                            } else if (i != 0 || i2 != 0) {
                                                ((dr) view2.getTag(2131756119)).oyl.setVisibility(8);
                                                s.makeText(view2.getContext(), 2131234125, 0).show();
                                                com.tencent.mm.sdk.c.b pzVar = new pz();
                                                pzVar.brl.aWH = ma;
                                                pzVar.brl.action = 2;
                                                pzVar.brl.brn = 1;
                                                com.tencent.mm.sdk.c.a.nhr.z(pzVar);
                                                if (this.ooM.ooL.ooJ.onG != null) {
                                                    this.ooM.ooL.ooJ.onG.bCe();
                                                }
                                            }
                                        }
                                    });
                                    ak.vy().a(new com.tencent.mm.t.d(linkedList), 0);
                                    if (this.ooL.ooJ.onG != null) {
                                        this.ooL.ooJ.onG.bCe();
                                        return;
                                    }
                                    return;
                                case 1:
                                    ((dr) view2.getTag(2131756119)).oyl.setVisibility(8);
                                    pzVar = new pz();
                                    pzVar.brl.aWH = ma;
                                    pzVar.brl.action = 2;
                                    pzVar.brl.brn = 1;
                                    com.tencent.mm.sdk.c.a.nhr.z(pzVar);
                                    linkedList = new LinkedList();
                                    com_tencent_mm_protocal_c_ayy = new ayy();
                                    com_tencent_mm_protocal_c_ayy.mWa = ma;
                                    com_tencent_mm_protocal_c_ayy.mVZ = 1;
                                    com_tencent_mm_protocal_c_ayy.efm = 1;
                                    linkedList.add(com_tencent_mm_protocal_c_ayy);
                                    be.y(3, this.ooL.ooJ.dzg, this.ooL.ooJ.ooG);
                                    ak.vy().a(1176, new e(this) {
                                        final /* synthetic */ AnonymousClass2 ooM;

                                        {
                                            this.ooM = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            ak.vy().b(1176, (e) this);
                                            v.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                            if (atVar != view2.getTag(2131756120)) {
                                                v.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(atVar.field_msgId));
                                            } else if (i != 0 || i2 != 0) {
                                                ((dr) view2.getTag(2131756119)).oyl.setVisibility(0);
                                                s.makeText(view2.getContext(), 2131234125, 0).show();
                                                com.tencent.mm.sdk.c.b pzVar = new pz();
                                                pzVar.brl.aWH = ma;
                                                pzVar.brl.action = 1;
                                                pzVar.brl.brn = 1;
                                                com.tencent.mm.sdk.c.a.nhr.z(pzVar);
                                                if (this.ooM.ooL.ooJ.onG != null) {
                                                    this.ooM.ooL.ooJ.onG.bCe();
                                                }
                                            }
                                        }
                                    });
                                    ak.vy().a(new com.tencent.mm.t.d(linkedList), 0);
                                    if (this.ooL.ooJ.onG != null) {
                                        this.ooL.ooJ.onG.bCe();
                                        return;
                                    }
                                    return;
                                case 2:
                                    ak.vy().a(1198, new e(this) {
                                        final /* synthetic */ AnonymousClass2 ooM;

                                        {
                                            this.ooM = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            bjj com_tencent_mm_protocal_c_bjj = null;
                                            ak.vy().b(1198, (e) this);
                                            v.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                            if (this.ooM.ooL.ooJ.nGQ != null) {
                                                this.ooM.ooL.ooJ.nGQ.dismiss();
                                                this.ooM.ooL.ooJ.nGQ = null;
                                            }
                                            if (i == 0 && i2 == 0) {
                                                g gVar = (g) kVar;
                                                if (gVar.cxe != null) {
                                                    com_tencent_mm_protocal_c_bjj = (bjj) gVar.cxe.czl.czs;
                                                }
                                                if (com_tencent_mm_protocal_c_bjj == null) {
                                                    s.makeText(view2.getContext(), 2131234120, 0).show();
                                                    return;
                                                }
                                                final String str2 = com_tencent_mm_protocal_c_bjj.ndQ;
                                                com.tencent.mm.sdk.c.b pVar = new com.tencent.mm.e.a.p();
                                                pVar.aWX.aWH = ma;
                                                pVar.aWX.aWY = new com.tencent.mm.pluginsdk.f(this) {
                                                    final /* synthetic */ AnonymousClass3 ooN;

                                                    public final void a(com.tencent.mm.sdk.c.b bVar, Object... objArr) {
                                                        if (objArr[0] instanceof h) {
                                                            if (TextUtils.isEmpty(((h) objArr[0]).field_appId) || TextUtils.isEmpty(str2)) {
                                                                v.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", r0, str2);
                                                                s.makeText(view2.getContext(), 2131234125, 0).show();
                                                                return;
                                                            }
                                                            try {
                                                                v.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, "utf-8"), URLEncoder.encode(str2, "utf-8"), Integer.valueOf(1), Integer.valueOf(n), Integer.valueOf(n2)}));
                                                                Intent intent = new Intent();
                                                                intent.putExtra("rawUrl", r1);
                                                                com.tencent.mm.ay.c.b(this.ooN.ooM.ooL.ooJ.onG.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                                                                return;
                                                            } catch (UnsupportedEncodingException e) {
                                                                v.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                                                s.makeText(view2.getContext(), 2131234125, 0).show();
                                                                return;
                                                            }
                                                        }
                                                        s.makeText(view2.getContext(), 2131234125, 0).show();
                                                    }
                                                };
                                                com.tencent.mm.sdk.c.a.nhr.z(pVar);
                                                return;
                                            }
                                            s.makeText(view2.getContext(), 2131234120, 0).show();
                                        }
                                    });
                                    final k gVar = new g(atVar.field_content);
                                    be beVar = this.ooL.ooJ;
                                    Context context = view2.getContext();
                                    view2.getResources().getString(2131231164);
                                    beVar.nGQ = com.tencent.mm.ui.base.g.a(context, view2.getResources().getString(2131231182), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass2 ooM;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ak.vy().c(gVar);
                                        }
                                    });
                                    ak.vy().a(gVar, 0);
                                    be.y(4, this.ooL.ooJ.dzg, this.ooL.ooJ.ooG);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.bKh();
                }
            }
        };
        this.ooD = new OnClickListener(this) {
            final /* synthetic */ be ooJ;

            {
                this.ooJ = r1;
            }

            public final void onClick(View view) {
                dl dlVar = (dl) view.getTag();
                v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", dlVar.userName);
                Map q = bf.q(dlVar.bmk.field_content, "msg");
                if (!(q == null || q.size() == 0)) {
                    com.tencent.mm.sdk.platformtools.be.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                }
                be beVar = this.ooJ;
                view.getContext();
                be.b(beVar, dlVar.userName);
            }
        };
        this.ojR = new com.tencent.mm.sdk.c.c<ji>(this) {
            final /* synthetic */ be ooJ;

            {
                this.ooJ = r2;
                this.nhz = ji.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                if (this.ooJ.onG != null) {
                    this.ooJ.onG.nDR.nEl.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 ooP;

                        {
                            this.ooP = r1;
                        }

                        public final void run() {
                            this.ooP.ooJ.onG.bCe();
                        }
                    });
                }
                return true;
            }
        };
        this.ooF = new b(this) {
            final /* synthetic */ be ooJ;

            {
                this.ooJ = r1;
            }

            public final void bEB() {
                v.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExit, then remove AppBrandTmplMsgReceivingSwitchListener.");
                com.tencent.mm.sdk.c.a.nhr.f(this.ooJ.ojR);
                if (this.ooJ.onG != null) {
                    this.ooJ.onG.a((b) this);
                }
            }
        };
        this.ooE = new OnClickListener(this) {
            final /* synthetic */ be ooJ;

            {
                this.ooJ = r1;
            }

            public final void onClick(View view) {
                dl dlVar = (dl) view.getTag();
                v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", dlVar.userName);
                com.tencent.mm.sdk.c.b okVar = new ok();
                okVar.bpu.userName = dlVar.userName;
                okVar.bpu.bpw = dlVar.oxV;
                Map q = bf.q(dlVar.bmk.field_content, "msg");
                if (q != null && q.size() > 0) {
                    okVar.bpu.bpx = com.tencent.mm.sdk.platformtools.be.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                }
                okVar.bpu.bpA = true;
                okVar.bpu.scene = 1014;
                okVar.bpu.aWP = dlVar.bmk.field_msgSvrId + ":" + dlVar.userName;
                com.tencent.mm.sdk.c.a.nhr.z(okVar);
                be.y(9, this.ooJ.dzg, this.ooJ.ooG);
            }
        };
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903303);
        dd ddVar = new dd(this.eKg);
        ddVar.gfb = (CheckBox) view.findViewById(2131755022);
        ddVar.fIV = view.findViewById(2131755026);
        ddVar.iJL = (TextView) view.findViewById(2131755341);
        ddVar.dtX = (ImageView) view.findViewById(2131755340);
        ddVar.eTg = (TextView) view.findViewById(2131755027);
        ddVar.ihk = (LinearLayout) view.findViewById(2131756091);
        ddVar.oxv.ilI = view.findViewById(2131756112);
        ddVar.oxv.oxx = view.findViewById(2131756140);
        ddVar.oxv.dID = (TextView) ddVar.oxv.ilI.findViewById(2131755226);
        ddVar.oxv.grr = (TextView) ddVar.oxv.ilI.findViewById(2131756099);
        ddVar.oxv.oxy = (LinearLayout) ddVar.oxv.ilI.findViewById(2131756141);
        ddVar.oxv.olG = (TextView) ddVar.ihk.findViewById(2131756105);
        ddVar.oxv.oxz = ddVar.ihk.findViewById(2131756142);
        ddVar.oxw.oyg = view.findViewById(2131756113);
        ddVar.oxw.oyh = (ImageView) view.findViewById(2131756121);
        ddVar.oxw.oyi = view.findViewById(2131756116);
        ddVar.oxw.oyk = (TextView) view.findViewById(2131756118);
        ddVar.oxw.oyj = (ImageView) view.findViewById(2131756117);
        ddVar.oxw.oyl = view.findViewById(2131756119);
        ddVar.oxw.oym = view.findViewById(2131756120);
        ddVar.oxw.oyn = (TextView) view.findViewById(2131756122);
        ddVar.oxw.oyo = (TextView) view.findViewById(2131756123);
        ddVar.oxw.oyp = (TextView) view.findViewById(2131756124);
        ddVar.oxw.oyq = (LinearLayout) view.findViewById(2131756125);
        ddVar.oxw.oyr = (TextView) view.findViewById(2131756126);
        ddVar.oxw.oys = (TextView) view.findViewById(2131756127);
        ddVar.oxw.oyt = view.findViewById(2131756128);
        ddVar.oxw.oyu = (LinearLayout) view.findViewById(2131756129);
        ddVar.oxw.oyw = view.findViewById(2131756130);
        ddVar.oxw.oyv = (LinearLayout) view.findViewById(2131756131);
        ddVar.oxw.oyx = (LinearLayout) view.findViewById(2131756132);
        ddVar.oxw.oyA = (TextView) view.findViewById(2131756133);
        ddVar.oxw.oyC = (ImageView) view.findViewById(2131756134);
        ddVar.oxw.oyz = view.findViewById(2131756135);
        ddVar.oxw.oyy = (LinearLayout) view.findViewById(2131756136);
        ddVar.oxw.oyB = (TextView) view.findViewById(2131756137);
        ddVar.oxw.oyD = (ImageView) view.findViewById(2131756138);
        ddVar.oxw.oyE = (ImageView) view.findViewById(2131756139);
        ddVar.okJ = (ImageView) view.findViewById(2131756114);
        view.setTag(ddVar);
        return view;
    }

    protected final boolean bEy() {
        return false;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        aVar = (dd) aVar;
        Map q = bf.q(atVar.field_content, "msg");
        if (q == null || q.size() == 0) {
            v.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            aVar.ihk.setVisibility(8);
            return;
        }
        aVar.ihk.setVisibility(0);
        int i2 = com.tencent.mm.sdk.platformtools.be.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.ooG = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.appmsg.template_id"));
        com.tencent.mm.sdk.c.a.nhr.f(this.ojR);
        aVar2.a(this.ooF);
        String ma;
        if (i2 != 0) {
            CharSequence charSequence;
            final String ma2;
            Object obj;
            boolean z;
            int d;
            int d2;
            String ma3;
            aVar.oxv.ilI.setVisibility(8);
            dr drVar = aVar.oxw;
            if ("notifymessage".equals(atVar.field_talker)) {
                ma = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"));
                if (com.tencent.mm.q.a.a.dW(ma)) {
                    com.tencent.mm.sdk.c.b mVar = new m();
                    mVar.aWJ.aWH = ma;
                    com.tencent.mm.sdk.c.a.nhr.z(mVar);
                    a(drVar.oyj, this.onG, ma, atVar, mVar.aWK.aWM);
                    charSequence = TextUtils.isEmpty(mVar.aWK.appName) ? ma : mVar.aWK.appName;
                } else {
                    a(drVar.oyj, this.onG, ma, atVar, null);
                    charSequence = this.onG.er(ma);
                }
                drVar.oyk.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.onG.nDR.nEl, charSequence, drVar.oyk.getTextSize()));
                if (com.tencent.mm.q.a.a.dW(ma)) {
                    drVar.oyi.setTag(new dl(atVar, ma, 0));
                    drVar.oyi.setOnClickListener(this.ooD);
                } else {
                    drVar.oyi.setTag(new dl(ma, 1, this.onG.onl ? this.onG.bEn() : null));
                    drVar.oyi.setOnClickListener(this.onG.onh.oqh);
                }
                drVar.oyi.setVisibility(0);
            } else {
                drVar.oyi.setVisibility(8);
            }
            charSequence = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.appmsg.mmreader.template_header.title"));
            drVar.oyn.setTextColor(d(q, ".msg.appmsg.mmreader.template_header.title_color", WebView.NIGHT_MODE_COLOR));
            drVar.oyn.setText(charSequence);
            long j = com.tencent.mm.sdk.platformtools.be.getLong(com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
            if (j > 0) {
                drVar.oyo.setText(o.F(this.onG.getString(2131232869), j));
                drVar.oyo.setVisibility(0);
            } else {
                drVar.oyo.setVisibility(8);
            }
            charSequence = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.appmsg.mmreader.template_header.first_data"));
            int d3 = d(q, ".msg.appmsg.mmreader.template_header.first_color", ooI);
            if (com.tencent.mm.sdk.platformtools.be.kS(charSequence)) {
                drVar.oyp.setVisibility(8);
            } else {
                drVar.oyp.setTextColor(d3);
                drVar.oyp.setText(charSequence);
                drVar.oyp.setVisibility(0);
                if (i2 == 2) {
                    drVar.oyp.setPadding(0, this.onG.getResources().getDimensionPixelOffset(2131493135), 0, 0);
                } else {
                    drVar.oyp.setPadding(0, 0, 0, 0);
                }
            }
            if ("notifymessage".equals(atVar.field_talker)) {
                ma2 = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"));
                boolean dW = com.tencent.mm.q.a.a.dW(ma2);
                if (dW) {
                    a aVar3 = this.onG;
                    b bVar = this.ooF;
                    if (!(bVar == null || aVar3.otz.contains(bVar))) {
                        aVar3.otz.add(bVar);
                    }
                    com.tencent.mm.sdk.c.a.nhr.e(this.ojR);
                    com.tencent.mm.sdk.c.b mVar2 = new m();
                    mVar2.aWJ.aWH = ma2;
                    com.tencent.mm.sdk.c.a.nhr.z(mVar2);
                    if (mVar2.aWK.aWL) {
                        obj = (mVar2.aWK.aWN & 1) > 0 ? 1 : null;
                        this.dzg = mVar2.aWK.appId;
                        z = dW;
                    } else {
                        mVar2 = new com.tencent.mm.e.a.p();
                        mVar2.aWX.aWH = ma2;
                        final dr drVar2 = drVar;
                        mVar2.aWX.aWY = new com.tencent.mm.pluginsdk.f(this) {
                            final /* synthetic */ be ooJ;

                            public final void a(com.tencent.mm.sdk.c.b bVar, Object... objArr) {
                                int i = 0;
                                if (ma2.equals(((com.tencent.mm.e.a.p) bVar).aWX.aWH)) {
                                    int i2;
                                    com.tencent.mm.sdk.c.b mVar = new m();
                                    mVar.aWJ.aWH = ma2;
                                    com.tencent.mm.sdk.c.a.nhr.z(mVar);
                                    this.ooJ.dzg = mVar.aWK.appId;
                                    if ((mVar.aWK.aWN & 1) > 0) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    View view = drVar2.oyl;
                                    if (i2 == 0) {
                                        i = 8;
                                    }
                                    view.setVisibility(i);
                                }
                            }
                        };
                        com.tencent.mm.sdk.c.a.nhr.z(mVar2);
                    }
                }
                obj = null;
                z = dW;
            } else {
                z = false;
                obj = null;
            }
            drVar.oyl.setVisibility(obj != null ? 0 : 8);
            drVar.oym.setVisibility(z ? 0 : 8);
            drVar.oym.setTag(2131756120, atVar);
            drVar.oym.setTag(2131756119, drVar);
            drVar.oym.setOnClickListener(this.ooC);
            drVar.oyh.setVisibility(8);
            drVar.oyp.setText(com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.appmsg.mmreader.template_header.first_data")));
            ma2 = (String) q.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            String str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            if (com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                drVar.oyq.setVisibility(8);
            } else {
                d = d(q, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", WebView.NIGHT_MODE_COLOR);
                d2 = d(q, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", WebView.NIGHT_MODE_COLOR);
                drVar.oyr.setTextColor(d);
                drVar.oys.setTextColor(d2);
                drVar.oyr.setText(ma2);
                drVar.oys.setText(str2);
                drVar.oyq.setVisibility(0);
            }
            List arrayList = new ArrayList();
            d = 0;
            int i3 = 0;
            while (i3 < 100) {
                ma = i3 == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + i3;
                ma2 = (String) q.get(ma + ".value.word");
                str2 = (String) q.get(ma + ".key.word");
                if (com.tencent.mm.sdk.platformtools.be.kS(ma2) && com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                    v.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", Integer.valueOf(i3));
                    break;
                }
                dm dmVar = new dm();
                dmVar.oxX = ma2;
                dmVar.oxW = com.tencent.mm.sdk.platformtools.be.ma(str2);
                dmVar.oxY = d(q, ma + ".key.color", ooH);
                dmVar.oxZ = d(q, ma + ".value.color", WebView.NIGHT_MODE_COLOR);
                int OK = (OK(dmVar.oxW) + 1) / 2;
                if (OK <= d) {
                    OK = d;
                }
                arrayList.add(dmVar);
                i3++;
                d = OK;
            }
            d2 = d > 8 ? 8 : d;
            LinearLayout linearLayout = drVar.oyu;
            if (linearLayout.getChildCount() > arrayList.size()) {
                if (arrayList.size() == 0) {
                    linearLayout.removeAllViews();
                } else {
                    linearLayout.removeViews(arrayList.size(), linearLayout.getChildCount() - arrayList.size());
                }
            }
            int childCount = linearLayout.getChildCount();
            for (i3 = 0; i3 < arrayList.size(); i3++) {
                LinearLayout linearLayout2;
                dm dmVar2 = (dm) arrayList.get(i3);
                if (i3 < childCount) {
                    linearLayout2 = (LinearLayout) linearLayout.getChildAt(i3);
                } else {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.onG.nDR.nEl).inflate(2130903283, null, false);
                    dn dnVar = new dn();
                    dnVar.oya = (TextView) linearLayout2.findViewById(2131756064);
                    dnVar.oyb = (TextView) linearLayout2.findViewById(2131756065);
                    linearLayout2.setTag(dnVar);
                    linearLayout.addView(linearLayout2);
                }
                dn dnVar2 = (dn) linearLayout2.getTag();
                dnVar2.oya.setEms(d2);
                dnVar2.oya.setTextColor(dmVar2.oxY);
                dnVar2.oyb.setTextColor(dmVar2.oxZ);
                dnVar2.oya.setText(dmVar2.oxW);
                dnVar2.oyb.setText(dmVar2.oxX);
            }
            if (linearLayout.getChildCount() == 0) {
                drVar.oyt.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                drVar.oyt.setVisibility(0);
                linearLayout.setVisibility(0);
            }
            ma2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
            str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
            if (com.tencent.mm.sdk.platformtools.be.kS(ma2)) {
                drVar.oyx.setVisibility(8);
            } else {
                drVar.oyA.setTextColor(d(q, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", WebView.NIGHT_MODE_COLOR));
                drVar.oyA.setText(ma2);
                if (com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                    drVar.oyC.setVisibility(8);
                } else {
                    drVar.oyC.setVisibility(0);
                    e(drVar.oyC, str2);
                }
                ma2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                ma3 = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"));
                drVar.oyx.setTag(new dl(atVar, ma3, ma2));
                if (com.tencent.mm.q.a.a.dW(ma3)) {
                    drVar.oyx.setOnClickListener(this.ooE);
                } else {
                    drVar.oyx.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ be ooJ;

                        public final void onClick(View view) {
                            if (!com.tencent.mm.sdk.platformtools.be.kS(ma2)) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", ma2);
                                com.tencent.mm.ay.c.b(this.ooJ.onG.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                            }
                        }
                    });
                }
                drVar.oyx.setVisibility(0);
            }
            ma2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
            ma3 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
            if (com.tencent.mm.sdk.platformtools.be.kS(ma2)) {
                drVar.oyy.setVisibility(8);
            } else {
                drVar.oyB.setTextColor(d(q, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", WebView.NIGHT_MODE_COLOR));
                drVar.oyB.setText(ma2);
                if (com.tencent.mm.sdk.platformtools.be.kS(ma3)) {
                    drVar.oyD.setVisibility(8);
                } else {
                    drVar.oyD.setVisibility(0);
                    e(drVar.oyD, ma3);
                }
                ma2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                drVar.oyy.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ be ooJ;

                    public final void onClick(View view) {
                        if (!com.tencent.mm.sdk.platformtools.be.kS(ma2)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", ma2);
                            com.tencent.mm.ay.c.b(this.ooJ.onG.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                });
                drVar.oyy.setVisibility(0);
            }
            drVar.oyE.setVisibility(8);
            if (drVar.oyx.getVisibility() == 8 && drVar.oyy.getVisibility() == 8) {
                drVar.oyv.setVisibility(8);
                drVar.oyw.setVisibility(8);
            } else {
                drVar.oyw.setVisibility(0);
                if (drVar.oyx.getVisibility() == 0 && drVar.oyy.getVisibility() == 0) {
                    drVar.oyx.setGravity(17);
                    drVar.oyy.setGravity(17);
                    drVar.oyx.setPadding(0, 0, 0, 0);
                    drVar.oyy.setPadding(0, 0, 0, 0);
                } else if (drVar.oyx.getVisibility() == 0) {
                    if (com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                        drVar.oyx.setGravity(19);
                        drVar.oyx.setPadding(this.onG.getResources().getDimensionPixelOffset(2131493135), 0, 0, 0);
                        drVar.oyE.setVisibility(0);
                    } else {
                        drVar.oyx.setGravity(17);
                        drVar.oyx.setPadding(0, 0, 0, 0);
                    }
                } else if (com.tencent.mm.sdk.platformtools.be.kS(ma3)) {
                    drVar.oyy.setGravity(19);
                    drVar.oyy.setPadding(this.onG.getResources().getDimensionPixelOffset(2131493135), 0, 0, 0);
                    drVar.oyE.setVisibility(0);
                } else {
                    drVar.oyy.setGravity(17);
                    drVar.oyy.setPadding(0, 0, 0, 0);
                }
                drVar.oyv.setVisibility(0);
            }
            if (drVar.oyx.getVisibility() == 0 && drVar.oyy.getVisibility() == 0) {
                drVar.oyz.setVisibility(0);
            } else {
                drVar.oyz.setVisibility(8);
            }
            String ma4 = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"));
            String str3 = null;
            if (!com.tencent.mm.sdk.platformtools.be.kS(ma4)) {
                ak.yW();
                str3 = com.tencent.mm.model.c.wH().LX(ma4).tT();
            }
            String str4 = (String) q.get(".msg.appmsg.mmreader.category.item.title");
            String str5 = (String) q.get(".msg.appmsg.mmreader.category.item.url");
            String str6 = (String) q.get(".msg.appmsg.mmreader.category.item.native_url");
            String str7 = (String) q.get(".msg.appmsg.template_id");
            if (com.tencent.mm.q.a.a.dW(ma4)) {
                String str8 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view = drVar.oyg;
                dl dlVar = new dl(atVar, false, i, ma4, 6, false, this.onG.bFU(), ma4, str3, str4);
                dlVar.cCj = str6;
                dlVar.oxV = str8;
                view.setTag(dlVar);
                drVar.oyg.setOnClickListener(this.ooE);
            } else {
                View view2 = drVar.oyg;
                dl dlVar2 = new dl(atVar, false, i, str5, 6, false, this.onG.bFU(), ma4, str3, str4);
                dlVar2.cCj = str6;
                view2.setTag(dlVar2);
                drVar.oyg.setOnClickListener(this.onG.onh.oqh);
            }
            drVar.oyg.setOnLongClickListener(this.onG.onh.oqj);
            if (j.sV().sQ()) {
                aVar.okJ.setVisibility(0);
                ad.c(this.onG, aVar.okJ, new ec(str7, atVar, str3));
            }
            aVar.oxw.oyg.setVisibility(0);
            return;
        }
        aVar.oxw.oyg.setVisibility(8);
        ma = com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"));
        a(aVar, this.onG, atVar, ma);
        a(aVar.dtX, this.onG, ma, atVar, null);
        v.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", atVar.field_talker);
        if ("notifymessage".equals(atVar.field_talker)) {
            aVar.oxv.oxx.setVisibility(0);
            aVar.oxv.dID.setTextSize(0, (float) com.tencent.mm.bd.a.N(aVar.oxv.dID.getContext(), 2131493169));
        } else {
            aVar.oxv.oxx.setVisibility(8);
            aVar.oxv.dID.setTextSize(0, (float) com.tencent.mm.bd.a.N(aVar.oxv.dID.getContext(), 2131492960));
        }
        aVar.oxv.ilI.setVisibility(0);
        dc X = dc.X(q);
        if (com.tencent.mm.sdk.platformtools.be.kS(X.url)) {
            aVar.oxv.oxz.setVisibility(8);
            aVar.oxv.olG.setVisibility(8);
        } else {
            aVar.oxv.oxz.setVisibility(0);
            aVar.oxv.olG.setVisibility(0);
        }
        aVar.oxv.dID.setText(X.title);
        aVar.oxv.grr.setText(o.F(this.onG.getString(2131232866), X.time));
        bf.a(aVar.oxv.oxy, q);
        String str9 = null;
        if (!com.tencent.mm.sdk.platformtools.be.kS(ma)) {
            ak.yW();
            str9 = com.tencent.mm.model.c.wH().LX(ma).tT();
        }
        View view3 = aVar.oxv.ilI;
        dl dlVar3 = new dl(atVar, false, i, X.url, 6, false, this.onG.bFU(), ma, str9, X.title);
        dlVar3.cCj = X.cCj;
        view3.setTag(dlVar3);
        aVar.oxv.ilI.setOnClickListener(this.onG.onh.oqh);
        aVar.oxv.ilI.setOnLongClickListener(this.onG.onh.oqj);
        if (j.sV().sQ()) {
            aVar.okJ.setVisibility(0);
            ad.c(this.onG, aVar.okJ, new ec(X.eHB, atVar, str9));
        }
        aVar.oxv.ilI.setVisibility(0);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        dl dlVar = (dl) view.getTag();
        if (dlVar == null) {
            return false;
        }
        int i = dlVar.position;
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
        }
        return true;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        switch (menuItem.getItemId()) {
            case 100:
                Map q = bf.q(atVar.field_content, "msg");
                if (!(q == null || q.size() == 0 || !com.tencent.mm.q.a.a.dW(com.tencent.mm.sdk.platformtools.be.ma((String) q.get(".msg.fromusername"))))) {
                    y(7, this.dzg, this.ooG);
                    break;
                }
        }
        return false;
    }

    protected final void a(ad.a aVar, a aVar2, at atVar, String str) {
        if (str != null && aVar.iJL != null) {
            ad.a(aVar, com.tencent.mm.pluginsdk.ui.d.e.a(aVar2.nDR.nEl, aVar2.er(str), aVar.iJL.getTextSize()));
        }
    }

    private void a(ImageView imageView, a aVar, String str, at atVar, String str2) {
        String str3 = null;
        if (imageView != null) {
            if (com.tencent.mm.model.m.fn(str)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            if (com.tencent.mm.q.a.a.dW(str)) {
                com.tencent.mm.ae.n.GL().a(str2, imageView, this.nHa);
                imageView.setTag(new dl(atVar, str, 1));
                imageView.setOnClickListener(this.ooD);
            } else {
                Bitmap b = com.tencent.mm.modelbiz.j.b(str, null, 0);
                if (b != null) {
                    imageView.setImageBitmap(b);
                } else {
                    imageView.setImageResource(2130837790);
                }
                if (aVar.onl) {
                    str3 = aVar.bEn();
                }
                imageView.setTag(new dl(str, 1, str3));
                imageView.setOnClickListener(aVar.onh.oqh);
            }
            imageView.setOnLongClickListener(aVar.onh.oqj);
            imageView.setContentDescription(com.tencent.mm.model.l.er(str) + aVar.nDR.nEl.getString(2131231201));
        }
    }

    private static void e(ImageView imageView, String str) {
        if (!com.tencent.mm.sdk.platformtools.be.kS(str) && imageView != null) {
            c.a aVar = new c.a();
            ak.yW();
            aVar.cPv = com.tencent.mm.model.c.wQ();
            aVar.cPs = true;
            aVar.cPO = true;
            com.tencent.mm.ae.n.GL().a(str, imageView, aVar.GU());
        }
    }

    private static void y(int i, String str, String str2) {
        v.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", Integer.valueOf(13796), Integer.valueOf(i), str, str2);
        com.tencent.mm.plugin.report.service.g.iuh.h(13796, Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(com.tencent.mm.sdk.platformtools.be.Nh()));
    }

    private static int d(Map<String, String> map, String str, int i) {
        if (!(map == null || com.tencent.mm.sdk.platformtools.be.kS(str))) {
            try {
                i = Color.parseColor(com.tencent.mm.sdk.platformtools.be.ma((String) map.get(str)));
            } catch (Exception e) {
            }
        }
        return i;
    }

    private static int OK(String str) {
        int i = 0;
        if (com.tencent.mm.sdk.platformtools.be.kS(str)) {
            return 0;
        }
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (i < str.length()) {
            if (str.substring(i, i + 1).matches(str2)) {
                i2 += 2;
            } else {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
