package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.ae.n;
import com.tencent.mm.ar.l;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.lm;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.p.a.a;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.aj;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.d.d;
import com.tencent.mmdb.database.SQLiteDatabase;

public class r extends a implements b {
    private f dxf;
    private a iNj = new a(this) {
        final /* synthetic */ r nFX;

        {
            this.nFX = r1;
        }

        public final void er(int i) {
            if (i == 262145) {
                this.nFX.bAx();
                this.nFX.aMX();
            } else if (i == 262147) {
                this.nFX.bAy();
            } else if (i == 262156) {
                this.nFX.bAA();
            } else if (i == 262152) {
                this.nFX.bAw();
            }
            this.nFX.dxf.notifyDataSetChanged();
        }

        public final void es(int i) {
        }

        public final void a(t.a aVar) {
            if (aVar == t.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC) {
                this.nFX.bAw();
            } else if (aVar == t.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC) {
                this.nFX.bAw();
            }
            this.nFX.dxf.notifyDataSetChanged();
        }
    };
    private p nFW;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ak.uz() || ak.uG()) {
            v.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", Boolean.valueOf(ak.uz()), Boolean.valueOf(ak.uG()));
        } else if (aj.lyc != null) {
            this.nFW = aj.lyc.ap(this.nDR.nEl, k.xF());
        }
    }

    public final int Oo() {
        return 2131099702;
    }

    public final boolean aXG() {
        return false;
    }

    public final boolean Sk() {
        return true;
    }

    public final void onDestroy() {
        if (this.nFW != null) {
            this.nFW.onDestroy();
            this.nFW = null;
        }
        super.onDestroy();
    }

    public final void onActivityCreated(Bundle bundle) {
        v.i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.dxf = this.ocZ;
        this.dxf.aO("more_setting", true);
        this.dxf.aO("settings_emoji_store", true);
        this.dxf.aO("settings_mm_wallet", true);
        this.dxf.aO("settings_mm_cardpackage", true);
        this.dxf.aO("settings_mm_favorite", true);
        this.dxf.aO("settings_my_album", true);
        this.dxf.aO("settings_my_address", true);
        this.dxf.aO("more_tab_setting_personal_info", true);
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.dnU.equals("more_tab_setting_personal_info")) {
            c.b(this.nDR.nEl, "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
            return true;
        } else if (preference.dnU.equals("settings_my_address")) {
            r0 = new Intent(this.nDR.nEl, AddressUI.class);
            r0.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            startActivity(r0);
            return true;
        } else if (preference.dnU.equals("settings_my_add_contact")) {
            c.b(this.nDR.nEl, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            return true;
        } else if (preference.dnU.equals("settings_mm_wallet")) {
            boolean ax = com.tencent.mm.p.c.us().ax(262156, 266248);
            boolean ay = com.tencent.mm.p.c.us().ay(262156, 266248);
            g.iuh.Y(10958, "9");
            g gVar = g.iuh;
            Object[] objArr = new Object[1];
            if (ax || ay) {
                r0 = 1;
            } else {
                r0 = 0;
            }
            objArr[0] = Integer.valueOf(r0);
            gVar.h(13341, objArr);
            com.tencent.mm.sdk.c.b lmVar = new lm();
            lmVar.bmR.context = this.nDR.nEl;
            com.tencent.mm.sdk.c.a.nhr.z(lmVar);
            com.tencent.mm.p.c.us().az(262156, 266248);
            return true;
        } else if (preference.dnU.equals("settings_mm_cardpackage")) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, SQLiteDatabase.KeyEmpty);
            r0 = new Intent();
            r0.putExtra("key_from_scene", 22);
            c.b(this.nDR.nEl, "card", ".ui.CardHomePageUI", r0);
            return true;
        } else if (preference.dnU.equals("settings_my_album")) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ak.yW();
                String str = (String) com.tencent.mm.model.c.vf().get(2, null);
                Intent intent = new Intent();
                intent.putExtra("sns_userName", str);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                ak.yW();
                r0 = com.tencent.mm.platformtools.t.g((Integer) com.tencent.mm.model.c.vf().get(68389, null));
                ak.yW();
                com.tencent.mm.model.c.vf().set(68389, Integer.valueOf(r0 + 1));
                c.b(this.nDR.nEl, "sns", ".ui.SnsUserUI", intent);
                return true;
            }
            s.ey(this.nDR.nEl);
            return true;
        } else if (preference.dnU.equals("settings_mm_favorite")) {
            g.iuh.Y(10958, "8");
            c.w(this.nDR.nEl, "favorite", ".ui.FavoriteIndexUI");
            r0 = new Intent();
            r0.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            r0.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(r0);
            return true;
        } else if (preference.dnU.equals("settings_emoji_store")) {
            g.iuh.Y(10958, "7");
            com.tencent.mm.p.c.us().az(262147, 266244);
            com.tencent.mm.p.c.us().az(262149, 266244);
            r0 = new Intent();
            r0.putExtra("preceding_scence", 2);
            c.b(this.nDR.nEl, "emoji", ".ui.v2.EmojiStoreV2UI", r0);
            g.iuh.h(12065, Integer.valueOf(1));
            return true;
        } else if (!preference.dnU.equals("more_setting")) {
            return false;
        } else {
            com.tencent.mm.p.c.us().az(262145, 266242);
            if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) == 1) {
                ak.yW();
                if ((com.tencent.mm.model.c.vf().getInt(40, 0) & 131072) == 0) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN, Boolean.valueOf(false));
                    ((IconPreference) fVar.Ow("more_setting")).wI(8);
                    v.d("MicroMsg.MoreTabUI", "unset voicepint setting dot show");
                }
            }
            c.b(this.nDR.nEl, "setting", ".ui.setting.SettingsUI", new Intent());
            return true;
        }
    }

    private void aMX() {
        if (c.EH("sns")) {
            this.dxf.aO("settings_my_album", false);
        } else {
            this.dxf.aO("settings_my_album", true);
        }
    }

    private void bAw() {
        com.tencent.mm.pluginsdk.j.d dVar = com.tencent.mm.pluginsdk.j.a.lxM;
        if (dVar == null || !((dVar.ZV() || dVar.ZW()) && c.EH("card"))) {
            this.dxf.aO("settings_mm_cardpackage", true);
            return;
        }
        String str = SQLiteDatabase.KeyEmpty;
        if (dVar != null) {
            CharSequence ZX = dVar.ZX();
        } else {
            Object obj = str;
        }
        boolean ay = com.tencent.mm.p.c.us().ay(262152, 266256);
        boolean ax = com.tencent.mm.p.c.us().ax(262152, 266256);
        boolean a = com.tencent.mm.p.c.us().a(t.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, t.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = com.tencent.mm.p.c.us().a(t.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, t.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        this.dxf.aO("settings_mm_cardpackage", false);
        final IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_mm_cardpackage");
        if (iconPreference != null) {
            iconPreference.setTitle(2131235051);
            if (ax) {
                iconPreference.wG(0);
                iconPreference.aO(getString(2131231102), 2130838762);
                iconPreference.wI(8);
                iconPreference.setSummary(null);
                iconPreference.J(null);
                iconPreference.wK(8);
                iconPreference.cc(SQLiteDatabase.KeyEmpty, -1);
                iconPreference.wH(8);
                return;
            }
            ak.yW();
            String str2 = (String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, SQLiteDatabase.KeyEmpty);
            if (!a2 || TextUtils.isEmpty(str2)) {
                iconPreference.J(null);
                iconPreference.wK(8);
            } else {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131493349);
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                aVar.cPv = e.cnj;
                n.GM();
                aVar.cPN = null;
                aVar.cPu = i.pR(str2);
                aVar.cPs = true;
                aVar.cPP = true;
                aVar.cPq = true;
                aVar.cPz = dimensionPixelOffset;
                aVar.cPy = dimensionPixelOffset;
                n.GL().a(str2, iconPreference.fgD, aVar.GU(), new com.tencent.mm.ae.a.c.g(this) {
                    final /* synthetic */ r nFX;

                    public final void jk(String str) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 nFZ;

                            {
                                this.nFZ = r1;
                            }

                            public final void run() {
                                iconPreference.wK(0);
                                iconPreference.wJ(2130838736);
                            }
                        });
                    }

                    public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
                        if (bVar.bitmap != null) {
                            final Bitmap bitmap = bVar.bitmap;
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 nFZ;

                                public final void run() {
                                    iconPreference.J(bitmap);
                                    iconPreference.wK(0);
                                }
                            });
                            return;
                        }
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 nFZ;

                            {
                                this.nFZ = r1;
                            }

                            public final void run() {
                                iconPreference.J(null);
                                iconPreference.wK(8);
                            }
                        });
                    }
                });
            }
            if (ay) {
                iconPreference.wI(0);
            } else {
                iconPreference.wI(8);
            }
            if (a) {
                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                iconPreference.wG(8);
                if (a2) {
                    iconPreference.setSummary(null);
                    if (com.tencent.mm.platformtools.t.kS(ZX)) {
                        iconPreference.cc(SQLiteDatabase.KeyEmpty, -1);
                        iconPreference.wH(8);
                        return;
                    }
                    iconPreference.L(ZX, -1, getResources().getColor(2131689792));
                    iconPreference.wH(0);
                    return;
                }
                iconPreference.cc(SQLiteDatabase.KeyEmpty, -1);
                iconPreference.wH(8);
                if (com.tencent.mm.platformtools.t.kS(ZX)) {
                    iconPreference.setSummary(null);
                    return;
                } else {
                    iconPreference.setSummary(ZX);
                    return;
                }
            }
            iconPreference.wH(8);
            iconPreference.wG(8);
            iconPreference.setSummary(null);
        }
    }

    private void bAx() {
        this.dxf.aO("more_setting", false);
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("more_setting");
        if (iconPreference != null) {
            iconPreference.wL(8);
            boolean ax = com.tencent.mm.p.c.us().ax(262145, 266242);
            if (ax) {
                iconPreference.wG(0);
                iconPreference.aO(getString(2131231102), 2130838762);
            } else {
                iconPreference.wG(8);
                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
            }
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(9, null)).intValue() != 0) {
                if (k.xN()) {
                    iconPreference.setSummary(SQLiteDatabase.KeyEmpty);
                } else {
                    iconPreference.setSummary(2131234693);
                }
            }
            if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) == 1) {
                ak.yW();
                if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
                    ak.yW();
                    if ((com.tencent.mm.model.c.vf().getInt(40, 0) & 131072) == 0 && !k.yo().booleanValue() && !ax) {
                        v.i("MicroMsg.MoreTabUI", "show voiceprint dot");
                        iconPreference.wI(0);
                    }
                }
            }
        }
    }

    private void bAy() {
        if (c.EH("emoji")) {
            c.brh();
            this.dxf.aO("settings_emoji_store", false);
            boolean ax = com.tencent.mm.p.c.us().ax(262147, 266244);
            boolean ax2 = com.tencent.mm.p.c.us().ax(262149, 266244);
            final IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_emoji_store");
            if (iconPreference != null) {
                if (ax) {
                    iconPreference.wG(0);
                    iconPreference.aO(getString(2131231102), 2130838762);
                } else if (ax2) {
                    iconPreference.wG(0);
                    iconPreference.aO(getString(2131231067), 2130838762);
                } else {
                    iconPreference.wG(8);
                    iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                }
                if (ax2 || ax) {
                    ak.yW();
                    n.GL().a((String) com.tencent.mm.model.c.vf().get(229633, null), iconPreference.fgD, new com.tencent.mm.ae.a.c.g(this) {
                        final /* synthetic */ r nFX;

                        public final void jk(String str) {
                        }

                        public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
                            if (bVar.status != 0 || bVar.bitmap == null) {
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass3 nGb;

                                    {
                                        this.nGb = r1;
                                    }

                                    public final void run() {
                                        iconPreference.wK(8);
                                    }
                                });
                                return;
                            }
                            final Bitmap bitmap = bVar.bitmap;
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 nGb;

                                public final void run() {
                                    iconPreference.J(bitmap);
                                    iconPreference.wK(0);
                                }
                            });
                        }
                    });
                    return;
                }
                iconPreference.wK(8);
                return;
            }
            return;
        }
        this.dxf.aO("settings_emoji_store", false);
    }

    private void bAz() {
        boolean xO = k.xO();
        v.d("MicroMsg.MoreTabUI", "wallet status: is open" + xO);
        this.dxf.aO("settings_mm_wallet", !xO);
        this.ocZ.notifyDataSetChanged();
    }

    private void bAA() {
        ak.yW();
        int g = com.tencent.mm.platformtools.t.g((Integer) com.tencent.mm.model.c.vf().get(204820, null));
        ak.yW();
        g += com.tencent.mm.platformtools.t.g((Integer) com.tencent.mm.model.c.vf().get(204817, null));
        boolean ax = com.tencent.mm.p.c.us().ax(262156, 266248);
        boolean ay = com.tencent.mm.p.c.us().ay(262156, 266248);
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_mm_wallet");
        if (iconPreference != null) {
            v.d("MicroMsg.MoreTabUI", "isShowNew : " + ax);
            v.d("MicroMsg.MoreTabUI", "isShowDot : " + ay);
            if (ax) {
                iconPreference.wG(0);
                iconPreference.aO(getString(2131231102), 2130838762);
                iconPreference.wI(8);
            } else if (g > 99) {
                iconPreference.wG(0);
                iconPreference.aO(getString(2131236490), com.tencent.mm.ui.tools.s.eN(this.nDR.nEl));
                iconPreference.wI(8);
            } else if (g > 0) {
                iconPreference.wG(0);
                iconPreference.aO(String.valueOf(g), com.tencent.mm.ui.tools.s.eN(this.nDR.nEl));
                iconPreference.wI(8);
            } else if (ay) {
                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                iconPreference.wG(8);
                iconPreference.wI(0);
            } else {
                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                iconPreference.wG(8);
                iconPreference.wI(8);
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int az = com.tencent.mm.platformtools.t.az(obj);
        v.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(az), jVar);
        ak.yW();
        if (jVar != com.tencent.mm.model.c.vf() || az <= 0) {
            v.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(az), jVar);
        } else if (204817 == az || 204820 == az) {
            bAA();
        } else if (40 == az) {
            bAz();
        } else if ("208899".equals(Integer.valueOf(i))) {
            bAy();
        }
    }

    protected final void bys() {
        this.dxf = this.ocZ;
    }

    protected final void byt() {
        this.dxf = this.ocZ;
        ak.yW();
        com.tencent.mm.model.c.vf().a(this);
        com.tencent.mm.p.c.us().a(this.iNj);
        this.dxf.aO("more_tab_setting_personal_info", false);
        AccountInfoPreference accountInfoPreference = (AccountInfoPreference) this.ocZ.Ow("more_tab_setting_personal_info");
        String xG = k.xG();
        if (com.tencent.mm.platformtools.t.kS(xG)) {
            xG = k.xF();
            if (u.LL(xG)) {
                accountInfoPreference.lPg = null;
            } else {
                accountInfoPreference.lPg = xG;
            }
        } else {
            accountInfoPreference.lPg = xG;
        }
        accountInfoPreference.userName = k.xF();
        CharSequence xH = k.xH();
        if (com.tencent.mm.platformtools.t.kS(xH)) {
            xH = k.xF();
        }
        accountInfoPreference.lPf = com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, xH);
        ((AccountInfoPreference) this.dxf.Ow("more_tab_setting_personal_info")).khm = this.nFW;
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_my_address");
        if (iconPreference != null) {
            int Kr = l.KD().Kr();
            if (Kr > 0) {
                iconPreference.wG(0);
                iconPreference.aO(String.valueOf(Kr), 2130838762);
            } else {
                iconPreference.wG(8);
                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
            }
        }
        aMX();
        bAy();
        bAx();
        if (c.EH("favorite")) {
            this.dxf.aO("settings_mm_favorite", false);
        } else {
            this.dxf.aO("settings_mm_favorite", true);
        }
        bAA();
        bAz();
        bAw();
        this.dxf.notifyDataSetChanged();
        final View findViewById = findViewById(2131759528);
        if (findViewById != null && findViewById.getVisibility() != 8) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ r nFX;

                public final void run() {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this.nFX.nDR.nEl, 2130968623));
                }
            });
        }
    }

    protected final void byu() {
    }

    protected final void byv() {
        com.tencent.mm.p.c.us().b(this.iNj);
        ak.yW();
        com.tencent.mm.model.c.vf().b(this);
    }

    protected final void byw() {
    }

    protected final void byx() {
    }

    public final void byz() {
        if (this.dxf != null) {
            this.dxf.removeAll();
        }
        this.gMx.setAdapter(null);
    }

    public final void byA() {
        if (this.dxf != null) {
            this.dxf.removeAll();
            this.dxf.addPreferencesFromResource(2131099702);
        }
        this.gMx.setAdapter(this.ocZ);
    }

    public final void byC() {
    }

    public final void bzm() {
    }
}
