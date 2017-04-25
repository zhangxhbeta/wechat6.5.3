package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.u;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.tools.ShareImageRedirectUI;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class t extends q {
    private static final int[] nGG = new int[]{2, 1, 4, 10, 3, Integer.MAX_VALUE, 20};
    private LayoutInflater CE;
    private Context mContext;
    private SparseArray<c> nGC;
    private a nGE;
    s nGF = null;

    private class a extends BaseAdapter {
        final /* synthetic */ t nGH;

        private a(t tVar) {
            this.nGH = tVar;
        }

        public final int getCount() {
            return this.nGH.nGC.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar = (c) this.nGH.nGC.get(i);
            View inflate = this.nGH.CE.inflate(2130904075, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(2131755226);
            if (!be.kS(cVar.nGL.nGM)) {
                textView.setText(cVar.nGL.nGM);
            }
            if (cVar.nGL.textColor > 0) {
                textView.setTextColor(com.tencent.mm.bd.a.b(aa.getContext(), cVar.nGL.textColor));
            }
            ImageView imageView = (ImageView) inflate.findViewById(2131755225);
            if (cVar.nGL.icon > 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(((c) this.nGH.nGC.get(i)).nGL.icon);
            } else {
                imageView.setVisibility(8);
            }
            if (!be.kS(cVar.nGL.nGN)) {
                imageView.setContentDescription(cVar.nGL.nGN);
            }
            View findViewById = inflate.findViewById(2131756698);
            textView = (TextView) inflate.findViewById(2131758298);
            textView.setBackgroundResource(s.eN(this.nGH.mContext));
            View findViewById2 = inflate.findViewById(2131757544);
            if (cVar.nGJ) {
                findViewById.setVisibility(0);
            } else if (cVar.aWI > 0) {
                textView.setVisibility(0);
                if (cVar.aWI > 99) {
                    textView.setText(2131235710);
                } else {
                    textView.setText(cVar.aWI);
                }
            } else if (cVar.nGK) {
                findViewById2.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
                textView.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            if (i == getCount() - 1) {
                inflate.setBackgroundResource(2130839259);
            } else {
                inflate.setBackgroundResource(2130839258);
            }
            return inflate;
        }
    }

    public static class b {
        int cZF;
        int id;
        int nGI;
        int order;

        public b(int i, int i2, int i3) {
            this(i, i2, i3, 0);
        }

        public b(int i, int i2, int i3, int i4) {
            this.id = i;
            this.nGI = i2;
            this.cZF = i3;
            this.order = i4;
        }
    }

    public static class c {
        int aWI = 0;
        boolean nGJ = false;
        boolean nGK = false;
        d nGL;

        public c(d dVar) {
            this.nGL = dVar;
        }
    }

    public static class d {
        int icon;
        String nGM;
        String nGN;
        int nGO;
        int textColor;

        public d(int i, String str, String str2, int i2, int i3) {
            this.nGM = str;
            this.nGN = str2;
            this.icon = i2;
            this.nGO = i;
            this.textColor = i3;
        }
    }

    public t(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
        this.mContext = actionBarActivity;
        this.CE = LayoutInflater.from(actionBarActivity);
        kk(false);
        this.nGF = s.bAC();
    }

    public final boolean dQ() {
        int i = 0;
        this.nGF.ja(false);
        if (this.nGF.nGC.size() != 0) {
            this.nGC = this.nGF.nGC;
        } else {
            v.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.nGC != null) {
                this.nGC.clear();
            } else {
                this.nGC = new SparseArray();
            }
            for (int i2 = 0; i2 < nGG.length; i2++) {
                this.nGC.put(i2, new c(vP(nGG[i2])));
            }
        }
        try {
            ak.yW();
            if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                while (i < this.nGC.size() && ((c) this.nGC.get(i)).nGL.nGO != 2147483646) {
                    i++;
                }
                if (i == this.nGC.size()) {
                    this.nGC.put(this.nGC.size(), new c(vP(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.nGE != null) {
            this.nGE.notifyDataSetChanged();
        }
        return super.dQ();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        boolean z2 = false;
        if (this.mContext instanceof ActionBarActivity) {
            ((ActionBarActivity) this.mContext).aR();
        }
        int i2 = ((c) this.nGC.get(i)).nGL.nGO;
        g.iuh.h(11104, Integer.valueOf(i2));
        Intent intent;
        String str;
        int a;
        bf zP;
        switch (i2) {
            case 1:
                com.tencent.mm.ay.c.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(2131230881));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", r.s(r.oHK, FileUtils.S_IRUSR, 512));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                this.mContext.startActivity(new Intent(this.mContext, ShareImageRedirectUI.class));
                break;
            case 4:
                com.tencent.mm.sdk.c.b pdVar = new pd();
                pdVar.bqt.bqv = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                str = pdVar.bqu.bqx;
                if (!be.kS(str)) {
                    v.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + str);
                    com.tencent.mm.ui.base.g.b(this.mContext, this.mContext.getString(2131235616), SQLiteDatabase.KeyEmpty, this.mContext.getString(2131231107), this.mContext.getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ t nGH;

                        {
                            this.nGH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.b pdVar = new pd();
                            pdVar.bqt.bqw = true;
                            com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                            VoipAddressUI.eD(this.nGH.mContext);
                            dialogInterface.dismiss();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ t nGH;

                        {
                            this.nGH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                }
                VoipAddressUI.eD(this.mContext);
                break;
            case 5:
                ak.yW();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.ey(this.mContext);
                    break;
                }
                ak.yW();
                str = (String) com.tencent.mm.model.c.vf().get(2, null);
                Intent intent2 = new Intent();
                intent2.putExtra("sns_userName", str);
                intent2.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent2.addFlags(67108864);
                ak.yW();
                a = be.a((Integer) com.tencent.mm.model.c.vf().get(68389, null), 0);
                ak.yW();
                com.tencent.mm.model.c.vf().set(68389, Integer.valueOf(a + 1));
                com.tencent.mm.ay.c.b(this.mContext, "sns", ".ui.SnsUserUI", intent2);
                break;
            case 6:
                com.tencent.mm.ay.c.w(this.mContext, "favorite", ".ui.FavoriteIndexUI");
                break;
            case 7:
                com.tencent.mm.ay.c.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                com.tencent.mm.ay.c.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                com.tencent.mm.ay.c.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                g.iuh.h(11265, Integer.valueOf(3));
                if (!(u.bi(this.mContext) || com.tencent.mm.ah.a.aT(this.mContext))) {
                    com.tencent.mm.ay.c.w(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                ak.yW();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.ey(this.mContext);
                    break;
                }
                f.oR(10);
                ak.yW();
                str = (String) com.tencent.mm.model.c.vf().get(68377, null);
                ak.yW();
                com.tencent.mm.model.c.vf().set(68377, SQLiteDatabase.KeyEmpty);
                Intent intent3 = new Intent();
                intent3.putExtra("sns_timeline_NeedFirstLoadint", true);
                boolean z3 = be.kS(str);
                if (j.ak.lyg == null) {
                    z2 = z3;
                } else if (j.ak.lyg.Kw() <= 0) {
                    z2 = z3;
                }
                intent3.putExtra("sns_resume_state", z2);
                com.tencent.mm.ay.c.b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent3);
                break;
            case 12:
                ak.yW();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.ey(this.mContext);
                    break;
                }
                com.tencent.mm.ay.c.w(this.mContext, "game", ".ui.GameCenterUI");
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ t nGH;

                    {
                        this.nGH = r1;
                    }

                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        this.nGH.mContext.sendBroadcast(intent);
                    }
                }, 100);
                break;
            case 13:
                com.tencent.mm.sdk.c.a.nhr.z(new lg());
                com.tencent.mm.ay.c.w(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                ak.yW();
                if (!be.c((Boolean) com.tencent.mm.model.c.vf().get(4103, null))) {
                    com.tencent.mm.ay.c.w(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                zP = bf.zP();
                if (zP != null) {
                    String ma = be.ma(zP.getProvince());
                    a = be.a(Integer.valueOf(zP.bBZ), 0);
                    if (!be.kS(ma) && a != 0) {
                        ak.yW();
                        Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, 2130903854, null);
                            final CheckBox checkBox = (CheckBox) inflate.findViewById(2131757691);
                            checkBox.setChecked(false);
                            com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(2131231164), inflate, new OnClickListener(this) {
                                final /* synthetic */ t nGH;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (checkBox != null) {
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(4104, Boolean.valueOf(!checkBox.isChecked()));
                                    }
                                    LauncherUI bzB = LauncherUI.bzB();
                                    if (bzB != null) {
                                        bzB.NX("tab_find_friend");
                                    }
                                    com.tencent.mm.aw.a.cU(this.nGH.mContext);
                                }
                            }, null);
                            break;
                        }
                        LauncherUI bzB = LauncherUI.bzB();
                        if (bzB != null) {
                            bzB.NX("tab_find_friend");
                        }
                        com.tencent.mm.aw.a.cU(this.mContext);
                        break;
                    }
                    com.tencent.mm.ay.c.w(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                com.tencent.mm.ay.c.w(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
                break;
            case 15:
                zP = bf.zO();
                if (be.a(Integer.valueOf(zP.bBZ), 0) > 0 && !be.kS(zP.getProvince())) {
                    com.tencent.mm.ay.c.w(this.mContext, "bottle", ".ui.BottleBeachUI");
                    break;
                } else {
                    com.tencent.mm.ay.c.w(this.mContext, "bottle", ".ui.BottleWizardStep1");
                    break;
                }
                break;
            case 16:
                ak.yW();
                if (!com.tencent.mm.model.c.wC()) {
                    com.tencent.mm.ay.c.w(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.ay.c.w(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((k.xQ() & 65536) != 0) {
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.ay.c.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.ay.c.w(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case android.support.v7.a.a.k.MG /*18*/:
                com.tencent.mm.ay.c.w(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.ay.c.w(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                com.tencent.mm.ay.c.b(this.mContext, "wallet", ".trading.WalletPayOrCollectUI", null);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                com.tencent.mm.ay.c.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case Integer.MAX_VALUE:
                g.iuh.Y(10919, "1-6");
                com.tencent.mm.pluginsdk.d.cZ(this.mContext);
                break;
        }
        this.nGF.vO(i2);
        dismiss();
    }

    public static d vP(int i) {
        Context context = aa.getContext();
        switch (i) {
            case 1:
                if (LauncherUI.nBw.booleanValue()) {
                    return new d(1, context.getString(2131233829), SQLiteDatabase.KeyEmpty, 2131165771, 2131690123);
                }
                return new d(1, context.getString(2131233829), SQLiteDatabase.KeyEmpty, 2131165772, 0);
            case 2:
                if (LauncherUI.nBx.booleanValue()) {
                    return new d(2, context.getString(2131233832), SQLiteDatabase.KeyEmpty, 2131165789, 2131690123);
                }
                return new d(2, context.getString(2131233832), SQLiteDatabase.KeyEmpty, 2131165790, 0);
            case 3:
                return new d(3, context.getString(2131233833), SQLiteDatabase.KeyEmpty, 2131165361, 0);
            case 4:
                if (1 == be.getInt(com.tencent.mm.h.j.sU().getValue("VOIPCallType"), 0)) {
                    return new d(4, context.getString(2131233834), SQLiteDatabase.KeyEmpty, 2131165806, 0);
                }
                return new d(4, context.getString(2131233830), SQLiteDatabase.KeyEmpty, 2131165773, 0);
            case 5:
                return new d(5, context.getString(2131235069), SQLiteDatabase.KeyEmpty, 2131165795, 0);
            case 6:
                return new d(6, context.getString(2131235052), SQLiteDatabase.KeyEmpty, 2131165786, 0);
            case 7:
                return new d(7, context.getString(2131235054), SQLiteDatabase.KeyEmpty, 2131165776, 0);
            case 8:
                return new d(8, context.getString(2131232365), SQLiteDatabase.KeyEmpty, 2131165784, 0);
            case 9:
                return new d(9, context.getString(2131235072), SQLiteDatabase.KeyEmpty, 2131165793, 0);
            case 10:
                return new d(10, context.getString(2131232781), SQLiteDatabase.KeyEmpty, 2131165796, 0);
            case 11:
                return new d(11, context.getString(2131235394), SQLiteDatabase.KeyEmpty, 2131165792, 0);
            case 12:
                return new d(12, context.getString(2131233119), SQLiteDatabase.KeyEmpty, 2131165788, 0);
            case 13:
                return new d(13, context.getString(2131235271), SQLiteDatabase.KeyEmpty, 2131165805, 0);
            case 14:
                return new d(14, context.getString(2131234007), SQLiteDatabase.KeyEmpty, 2131165794, 0);
            case 15:
                return new d(15, context.getString(2131231509), SQLiteDatabase.KeyEmpty, 2131165774, 0);
            case 16:
                return new d(16, context.getString(2131234961), SQLiteDatabase.KeyEmpty, 2131165808, 0);
            case 17:
                return new d(17, context.getString(2131233815), SQLiteDatabase.KeyEmpty, 2131165791, 0);
            case android.support.v7.a.a.k.MG /*18*/:
                return new d(18, context.getString(2131232783), SQLiteDatabase.KeyEmpty, 2131165797, 0);
            case 19:
                return new d(19, context.getString(2131232786), SQLiteDatabase.KeyEmpty, 2131165194, 0);
            case 20:
                return new d(20, context.getString(2131230880), SQLiteDatabase.KeyEmpty, 2131165865, 0);
            case 2147483646:
                return new d(2147483646, "TIT", SQLiteDatabase.KeyEmpty, 2131165776, 0);
            case Integer.MAX_VALUE:
                return new d(Integer.MAX_VALUE, context.getString(2131235013), SQLiteDatabase.KeyEmpty, 2131165787, 0);
            default:
                return null;
        }
    }

    protected final BaseAdapter YP() {
        if (this.nGE == null) {
            this.nGE = new a();
        }
        return this.nGE;
    }
}
