package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.h;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.d.b;

@Deprecated
public class RoomInfoDetailUI extends MMPreference implements a {
    private boolean bhx;
    private f dxf;
    private String ePE;
    private SignaturePreference ePc;
    private CheckBoxPreference ePh;
    private String ePn;
    private boolean ePr = false;
    private int eRr;
    private CheckBoxPreference eRs;
    private CheckBoxPreference eRt;
    private u euW;
    private boolean eut = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onResume() {
        super.onResume();
        adj();
        adv();
        if (!(this.euW == null || this.eRs == null)) {
            o LD = ak.yW().wO().LD(this.ePn);
            SharedPreferences sharedPreferences = getSharedPreferences(this.ePE, 0);
            if (LD.bvh()) {
                this.eRs.ocf = true;
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.eRs.ocf = false;
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.dxf.notifyDataSetChanged();
    }

    protected final void NI() {
        vD(2131234688);
        this.dxf = this.ocZ;
        this.ePE = getPackageName() + "_preferences";
        this.bhx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ePn = getIntent().getStringExtra("RoomInfo_Id");
        if (this.ePn == null) {
            this.ePn = getIntent().getStringExtra("Single_Chat_Talker");
        }
        ak.yW();
        this.euW = c.wH().LX(this.ePn);
        if (this.bhx) {
            this.eRr = this.euW.bCh;
            this.ePc = (SignaturePreference) this.dxf.Ow("room_name");
            this.ePh = (CheckBoxPreference) this.dxf.Ow("room_msg_notify");
            this.eRt = (CheckBoxPreference) this.dxf.Ow("room_show_msg_count");
            this.eRs = (CheckBoxPreference) this.dxf.Ow("room_msg_show_username");
            this.eRt.odB = false;
        } else {
            this.eRr = 1;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomInfoDetailUI eRu;

            {
                this.eRu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eRu.finish();
                return true;
            }
        });
    }

    public final void a(String str, i iVar) {
    }

    public final int Oo() {
        return 2131099711;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.dnU;
        v.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[]{str});
        if (str.equals("room_name")) {
            Intent intent = new Intent();
            intent.setClass(this, b.class);
            intent.putExtra("Contact_mode_name_type", 4);
            String xF = k.xF();
            intent.putExtra("Contact_Nick", adb());
            intent.putExtra("Contact_User", xF);
            intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
            intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
            this.nDR.nEl.startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            o LC = ak.yW().wO().LC(this.ePn);
            LC.iA(!LC.bvh());
            this.ePr = true;
        }
        if (str.equals("room_msg_notify")) {
            int i;
            if (this.eRr == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.eRr = i;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.k(this.ePn, this.eRr));
            ak.yW();
            this.euW = c.wH().LX(this.ePn);
            this.euW.cZ(this.eRr);
            ak.yW();
            c.wH().a(this.ePn, this.euW);
            adj();
            ak.yW();
            this.euW = c.wH().LX(this.ePn);
            this.dxf.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.euW.field_username);
            com.tencent.mm.ay.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            g.a(this, this.bhx ? getString(2131232872) : getString(2131232871, new Object[]{this.euW.tU()}), new String[]{getString(2131234576)}, null, new g.c(this) {
                final /* synthetic */ RoomInfoDetailUI eRu;

                {
                    this.eRu = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            this.eRu.eut = false;
                            RoomInfoDetailUI roomInfoDetailUI = this.eRu;
                            this.eRu.getString(2131231164);
                            final p a = g.a(roomInfoDetailUI, this.eRu.getString(2131231182), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass2 eRv;

                                {
                                    this.eRv = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.eRv.eRu.eut = true;
                                }
                            });
                            if (h.ed(this.eRu.euW.field_username)) {
                                com.tencent.mm.plugin.chatroom.a.drq.bq(this.eRu.euW.field_username);
                            }
                            aw.a(this.eRu.euW.field_username, new aw.a(this) {
                                final /* synthetic */ AnonymousClass2 eRv;

                                public final boolean zp() {
                                    return this.eRv.eRu.eut;
                                }

                                public final void zo() {
                                    if (a != null) {
                                        a.dismiss();
                                    }
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.ePE, 0);
            if (this.euW != null) {
                ak.yW();
                if (c.wK().Mn(this.euW.field_username)) {
                    m.m(this.euW.field_username, true);
                } else {
                    m.l(this.euW.field_username, true);
                }
                ak.yW();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.wK().Mn(this.euW.field_username)).commit();
            }
        }
        if ("room_show_msg_count".equals(str)) {
            boolean z2;
            boolean tN = tN();
            v.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[]{Boolean.valueOf(tN), Boolean.valueOf(tN)});
            if (tN) {
                z2 = false;
            } else {
                z2 = true;
            }
            LC = ak.yW().wO().LC(this.ePn);
            if (z2) {
                LC.ej(0);
            } else {
                LC.ej(2);
            }
            v.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[]{Boolean.valueOf(z2)});
            ak.yW().wO().a(LC, new String[0]);
            xF = k.xF();
            aip com_tencent_mm_protocal_c_aip = new aip();
            com_tencent_mm_protocal_c_aip.moN = this.ePn;
            com_tencent_mm_protocal_c_aip.gln = xF;
            com_tencent_mm_protocal_c_aip.mIV = 2;
            com_tencent_mm_protocal_c_aip.itI = z2 ? 2 : 1;
            ak.yW();
            c.wG().b(new j.a(49, com_tencent_mm_protocal_c_aip));
            if (this.eRt != null) {
                CheckBoxPreference checkBoxPreference = this.eRt;
                if (tN) {
                    z = false;
                }
                checkBoxPreference.ocf = z;
            }
            this.dxf.notifyDataSetChanged();
        }
        return false;
    }

    public void onPause() {
        int i = 1;
        super.onPause();
        if (this.ePr) {
            o LC = ak.yW().wO().LC(this.ePn);
            ak.yW().wO().a(LC, new String[0]);
            String xF = k.xF();
            boolean bvh = LC.bvh();
            aip com_tencent_mm_protocal_c_aip = new aip();
            com_tencent_mm_protocal_c_aip.moN = this.ePn;
            com_tencent_mm_protocal_c_aip.gln = xF;
            com_tencent_mm_protocal_c_aip.mIV = 1;
            if (!bvh) {
                i = 0;
            }
            com_tencent_mm_protocal_c_aip.itI = i;
            ak.yW();
            c.wG().b(new j.a(49, com_tencent_mm_protocal_c_aip));
        }
    }

    private boolean tN() {
        return (ak.yW().wO().LC(this.ePn).field_chatroomdataflag & 2) == 0;
    }

    private String adb() {
        o LC = ak.yW().wO().LC(this.ePn);
        if (LC == null) {
            return "";
        }
        return LC.field_selfDisplayName;
    }

    private void adv() {
        if (this.euW != null && this.ePc != null) {
            CharSequence adb = adb();
            if (be.kS(adb)) {
                adb = k.xH();
            }
            if (be.kS(adb)) {
                this.ePc.setSummary("");
                return;
            }
            SignaturePreference signaturePreference = this.ePc;
            if (adb.length() <= 0) {
                adb = getString(2131235144);
            }
            signaturePreference.setSummary(e.a(this, adb));
        }
    }

    private void adj() {
        boolean z = true;
        if (this.bhx) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.ePE, 0);
            if (this.eRr == 0) {
                vI(0);
                if (this.ePh != null) {
                    this.ePh.ocf = true;
                    sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
                }
                if (this.eRt != null) {
                    this.eRt.ocf = tN();
                }
            } else if (this.eRr == 1) {
                vI(8);
                if (this.ePh != null) {
                    this.ePh.ocf = false;
                    sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
                }
            }
            f fVar = this.dxf;
            String str = "room_show_msg_count";
            if (this.eRr != 1) {
                z = false;
            }
            fVar.aO(str, z);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String ah = be.ah(intent.getStringExtra("Contact_Nick"), "");
                        if (!be.kS(ah)) {
                            String xF = k.xF();
                            o LC = ak.yW().wO().LC(this.ePn);
                            if (LC == null) {
                                LC = new o();
                            }
                            LC.field_chatroomname = this.ePn;
                            LC.field_selfDisplayName = ah;
                            ak.yW().wO().a(LC, new String[0]);
                            aio com_tencent_mm_protocal_c_aio = new aio();
                            com_tencent_mm_protocal_c_aio.moN = this.ePn;
                            com_tencent_mm_protocal_c_aio.gln = xF;
                            com_tencent_mm_protocal_c_aio.mlX = be.ma(ah);
                            ak.yW();
                            c.wG().b(new j.a(48, com_tencent_mm_protocal_c_aio));
                            adv();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
