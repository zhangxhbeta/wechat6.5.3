package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.d;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.j;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.Map;

public class SelectMemberChattingRecordUI extends MMActivity {
    private static final f<Integer, c> cqx = new f(32);
    private p dFI;
    private String eQD;
    private MMLoadMoreListView eSX;
    private View eSY;
    private a eSZ;
    private String eTa;
    private int exY = 0;
    private String mTitle;

    public class a extends j<at> {
        String eSI;
        final /* synthetic */ SelectMemberChattingRecordUI eTb;
        String eTc;
        int eTd = -1;
        private o eTe;
        int emv = -1;
        Context mContext;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (at) obj;
            if (obj == null) {
                obj = new at();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, Context context, String str, String str2, int i) {
            this.eTb = selectMemberChattingRecordUI;
            super(context, new at());
            this.mContext = context;
            this.emv = i;
            this.eSI = str;
            this.eTc = str2;
            this.eTe = ak.yW().wO().LD(selectMemberChattingRecordUI.eQD);
        }

        public final void Ol() {
            if (this.eTd < 0 || this.eTd > this.emv) {
                this.eTd = this.emv - 16;
            }
            if (!be.kS(this.eTb.eTa) && k.eo(this.eTb.eTa)) {
                ak.yW();
                setCursor(com.tencent.mm.model.c.wJ().bT(this.eSI, this.emv - this.eTd));
            } else if (!k.eo(this.eTb.eTa)) {
                ak.yW();
                setCursor(com.tencent.mm.model.c.wJ().z(this.eSI, this.eTc, this.emv - this.eTd));
            }
        }

        protected final void Om() {
            Ol();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(2130903961, null, false);
                bVar = new b();
                bVar.dtX = (ImageView) view.findViewById(2131755508);
                bVar.euh = (TextView) view.findViewById(2131756539);
                bVar.eTf = (TextView) view.findViewById(2131757187);
                bVar.eTg = (TextView) view.findViewById(2131756540);
                view.setTag(bVar);
            }
            at atVar = (at) getItem(i);
            bVar = (b) view.getTag();
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.dtX, this.eTc);
            String str = this.eTc;
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(str);
            CharSequence a = !be.kS(LX.field_conRemark) ? LX.field_conRemark : SelectMemberChattingRecordUI.a(this.eTe, LX.field_username);
            if (be.kS(a)) {
                a = LX.tT();
            }
            if (!com.tencent.mm.i.a.ei(LX.field_type)) {
                ak.yW();
                ba Nw = com.tencent.mm.model.c.wI().Nw(LX.field_username);
                if (!(Nw == null || be.kS(Nw.field_conRemark))) {
                    a = Nw.field_conRemark;
                }
            }
            b(a, bVar.euh);
            b(SelectMemberChattingRecordUI.a(aa.getContext(), atVar.field_type, atVar.field_content, this.eTc, atVar.field_isSend).trim(), bVar.eTf);
            b(com.tencent.mm.pluginsdk.j.o.c(this.eTb, atVar.field_createTime, true), bVar.eTg);
            return view;
        }

        private static boolean b(CharSequence charSequence, TextView textView) {
            if (charSequence == null || charSequence.length() == 0) {
                textView.setVisibility(8);
                return false;
            }
            textView.setText(e.a(textView.getContext(), charSequence));
            textView.setVisibility(0);
            return true;
        }
    }

    private static class b {
        public ImageView dtX;
        public TextView eTf;
        public TextView eTg;
        public TextView euh;

        private b() {
        }
    }

    static /* synthetic */ void a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, long j) {
        v.i("MicroMsg.SelectMemberChattingRecordUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(j)});
        com.tencent.mm.plugin.chatroom.a.drp.e(new Intent().putExtra("Chat_User", selectMemberChattingRecordUI.eQD).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j), selectMemberChattingRecordUI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.SelectMemberChattingRecordUI", "[onCreate]");
        this.eQD = getIntent().getStringExtra("RoomInfo_Id");
        this.eTa = getIntent().getStringExtra("room_member");
        v.i("MicroMsg.SelectMemberChattingRecordUI", "roomId:%s", new Object[]{this.eQD});
        this.mTitle = getIntent().getStringExtra("title");
        if (!be.kS(this.eTa) && k.eo(this.eTa)) {
            ak.yW();
            this.exY = com.tencent.mm.model.c.wJ().Nk(this.eQD);
        } else if (!k.eo(this.eTa)) {
            ak.yW();
            this.exY = com.tencent.mm.model.c.wJ().dN(this.eQD, this.eTa);
        }
        NI();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
    }

    protected final void NI() {
        super.NI();
        Fd(be.ma(this.mTitle));
        this.eSX = (MMLoadMoreListView) findViewById(2131759038);
        this.eSX.bCi();
        this.eSZ = new a(this, this, this.eQD, this.eTa, this.exY);
        this.eSX.setAdapter(this.eSZ);
        this.eSY = findViewById(2131759039);
        if ((this.exY == 0 ? 1 : 0) != 0) {
            this.eSY.setVisibility(0);
            this.eSX.setVisibility(8);
        }
        this.eSX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectMemberChattingRecordUI eTb;

            {
                this.eTb = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                at atVar = (at) this.eTb.eSZ.getItem(i);
                if (atVar != null) {
                    SelectMemberChattingRecordUI.a(this.eTb, atVar.field_msgId);
                }
            }
        });
        this.eSX.nWA = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ SelectMemberChattingRecordUI eTb;

            {
                this.eTb = r1;
            }

            public final void adB() {
                if (this.eTb.eSZ != null) {
                    a a = this.eTb.eSZ;
                    a.eTd -= 16;
                    if (!be.kS(a.eTb.eTa) && k.eo(a.eTb.eTa)) {
                        ak.yW();
                        a.setCursor(com.tencent.mm.model.c.wJ().bT(a.eSI, a.emv - a.eTd));
                    } else if (!k.eo(a.eTb.eTa)) {
                        ak.yW();
                        a.setCursor(com.tencent.mm.model.c.wJ().z(a.eSI, a.eTc, a.emv - a.eTd));
                    }
                    this.eTb.eSZ.notifyDataSetChanged();
                }
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectMemberChattingRecordUI eTb;

            {
                this.eTb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eTb.setResult(0);
                this.eTb.finish();
                return true;
            }
        });
    }

    protected static String a(o oVar, String str) {
        if (oVar == null) {
            return null;
        }
        return oVar.er(str);
    }

    protected final int getLayoutId() {
        return 2130904331;
    }

    public static String a(Context context, int i, String str, String str2, int i2) {
        String str3 = "";
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
        switch (i) {
            case -1879048186:
                return context.getString(2131234363, new Object[]{dV.title});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(2131234354, new Object[]{dV.title});
            case 1:
                return str.substring(str.indexOf(":\n") + 1);
            case 3:
            case 23:
            case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                return context.getString(2131231122);
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                return context.getString(2131234366, new Object[]{Integer.valueOf((int) q.au(new n(str).time))});
            case JsApiGetLocation.CTRL_INDEX /*37*/:
                if (str == null || str.length() <= 0) {
                    return str3;
                }
                d MB = d.MB(str);
                if (MB.lct == null || MB.lct.length() <= 0) {
                    return str3;
                }
                switch (MB.scene) {
                    case 18:
                        return context.getString(2131232919, new Object[]{MB.getDisplayName()});
                    case bf.CTRL_INDEX /*22*/:
                    case 23:
                    case 24:
                    case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    case bv.CTRL_INDEX /*27*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.p.CTRL_INDEX /*28*/:
                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                        return context.getString(2131232929, new Object[]{MB.getDisplayName()});
                    case 25:
                        return context.getString(2131232859, new Object[]{MB.getDisplayName()});
                    default:
                        return context.getString(2131232938, new Object[]{MB.getDisplayName()});
                }
            case 42:
                if (be.ma(str).length() <= 0) {
                    return str3;
                }
                CharSequence fL = aw.fL(str);
                if (!TextUtils.isEmpty(fL)) {
                    CharSequence charSequence = fL;
                }
                ak.yW();
                com.tencent.mm.storage.at.a MU = com.tencent.mm.model.c.wJ().MU(str);
                ak.yW();
                str3 = com.tencent.mm.model.c.wH().LX(str2).tU();
                if (m.dE(str3)) {
                    str3 = i.b(i.em(str3), -1);
                }
                if (i2 == 1) {
                    return context.getString(2131232860, new Object[]{str3, MU.getDisplayName()});
                }
                return context.getString(2131232861, new Object[]{str3, MU.getDisplayName()});
            case 43:
            case ao.CTRL_INDEX /*62*/:
                return context.getString(62 == i ? 2131231156 : 2131231176);
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                return context.getString(2131231031);
            case 48:
                ak.yW();
                return context.getString(2131234358, new Object[]{com.tencent.mm.model.c.wJ().MV(str).label});
            case 49:
                if (dV == null) {
                    v.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                }
                switch (dV.type) {
                    case 2:
                        return context.getString(2131231122);
                    case 3:
                        return context.getString(2131234359, new Object[]{dV.title});
                    case 4:
                        return context.getString(2131234365, new Object[]{dV.title});
                    case 5:
                        return context.getString(2131234364, new Object[]{dV.getTitle()});
                    case 6:
                        return context.getString(2131234357, new Object[]{dV.title});
                    case 7:
                        return str3;
                    case 8:
                        return context.getString(2131231032);
                    case am.CTRL_INDEX /*15*/:
                    case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    case bv.CTRL_INDEX /*27*/:
                        return context.getString(2131231031);
                    case 17:
                        return context.getString(2131234358, new Object[]{dV.title});
                    case 19:
                        return context.getString(2131234361, new Object[]{dV.title});
                    case 24:
                        c cVar;
                        Object[] objArr = new Object[1];
                        String str4 = dV.coC;
                        if (be.kS(str4)) {
                            v.e("MicroMsg.SelectMemberChattingRecordUI", "xml is null");
                            cVar = null;
                        } else {
                            int hashCode = str4.hashCode();
                            cVar = (c) cqx.get(Integer.valueOf(hashCode));
                            if (cVar != null) {
                                v.d("MicroMsg.SelectMemberChattingRecordUI", "get record msg data from cache");
                            } else {
                                Map q = str4.trim().startsWith("<recordinfo>") ? com.tencent.mm.sdk.platformtools.bf.q(str4, "recordinfo") : com.tencent.mm.sdk.platformtools.bf.q("<recordinfo>" + str4 + "</recordinfo>", "recordinfo");
                                if (q == null) {
                                    v.e("MicroMsg.SelectMemberChattingRecordUI", "values is null: %s", new Object[]{str4});
                                    cVar = null;
                                } else {
                                    c cVar2 = new c();
                                    cVar2.title = (String) q.get(".recordinfo.title");
                                    cVar2.desc = (String) q.get(".recordinfo.desc");
                                    cVar2.lYv = (String) q.get(".recordinfo.favusername");
                                    cqx.put(Integer.valueOf(hashCode), cVar2);
                                    cVar = cVar2;
                                }
                            }
                        }
                        objArr[0] = cVar.desc;
                        return context.getString(2131234360, objArr);
                    case 25:
                        return context.getString(2131231022);
                    default:
                        return "";
                }
            case 369098801:
            case 452984881:
                return context.getString(2131234356, new Object[]{dV.title});
            case 419430449:
                str3 = context.getString(2131234362);
                if (dV == null) {
                    return str3;
                }
                int i3 = i2 == 1 ? 1 : 0;
                switch (dV.cpe) {
                    case 1:
                        if (i3 != 0) {
                            return context.getString(2131231191);
                        }
                        return context.getString(2131231194);
                    case 3:
                        if (i3 != 0) {
                            return context.getString(2131231192);
                        }
                        return context.getString(2131231189);
                    case 4:
                        if (i3 != 0) {
                            return context.getString(2131231193);
                        }
                        return context.getString(2131231190);
                    default:
                        return be.ma(dV.title);
                }
            case 436207665:
            case 469762097:
                if (dV == null) {
                    v.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(2131234355, new Object[]{dV.cpH, dV.cpE});
                } else {
                    return context.getString(2131234355, new Object[]{dV.cpH, dV.cpD});
                }
            case 503316529:
                if (dV == null) {
                    v.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(2131234355, new Object[]{dV.cpH, dV.cpV});
                } else {
                    return context.getString(2131234355, new Object[]{dV.cpH, dV.cpU});
                }
            case 520093745:
                return context.getString(2131234356, new Object[]{""});
            default:
                return str3;
        }
    }
}
