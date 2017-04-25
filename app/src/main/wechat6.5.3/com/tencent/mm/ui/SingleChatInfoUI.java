package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.v;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.contact.r;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class SingleChatInfoUI extends MMPreference implements v {
    private static boolean eut = false;
    private String bdo;
    private SharedPreferences cnm = null;
    private f dxf;
    private boolean eJx;
    private String ePE = SQLiteDatabase.KeyEmpty;
    private ContactListExpandPreference ePg;
    private CheckBoxPreference ePh;
    private CheckBoxPreference ePj;
    private int ePt = -1;
    private d ePu = new d(new OnScrollListener(this) {
        final /* synthetic */ SingleChatInfoUI nHf;

        {
            this.nHf = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean ePv = false;
    private u euW;
    private ac handler = new ac(Looper.getMainLooper());

    private static class a implements OnCancelListener {
        private a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            SingleChatInfoUI.eut = true;
        }
    }

    static /* synthetic */ void c(SingleChatInfoUI singleChatInfoUI) {
        g.iuh.Y(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.bdo);
        linkedList.add(k.xF());
        String b = t.b(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(2131230881));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", r.oHK);
        intent.putExtra("always_select_contact", b);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
    }

    static /* synthetic */ void d(SingleChatInfoUI singleChatInfoUI) {
        eut = false;
        singleChatInfoUI.getString(2131231164);
        final ProgressDialog a = com.tencent.mm.ui.base.g.a((Context) singleChatInfoUI, singleChatInfoUI.getString(2131231182), true, new a());
        aw.a(singleChatInfoUI.euW.field_username, new com.tencent.mm.model.aw.a(singleChatInfoUI) {
            final /* synthetic */ SingleChatInfoUI nHf;

            public final boolean zp() {
                return SingleChatInfoUI.eut;
            }

            public final void zo() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        singleChatInfoUI.handler.post(new Runnable(singleChatInfoUI) {
            final /* synthetic */ SingleChatInfoUI nHf;

            {
                this.nHf = r1;
            }

            public final void run() {
                o.Ho().fP(7);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.a(this);
        }
        this.bdo = getIntent().getStringExtra("Single_Chat_Talker");
        ak.yW();
        this.euW = c.wH().LX(this.bdo);
        this.ePE = getPackageName() + "_preferences";
        NI();
    }

    public void onResume() {
        adj();
        if (this.ePg != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.bdo);
            this.ePg.j(this.bdo, linkedList);
        }
        this.dxf.notifyDataSetChanged();
        super.onResume();
        if (!this.ePv) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!t.kS(stringExtra)) {
                final int Oy = this.dxf.Oy(stringExtra);
                setSelection(Oy - 3);
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ SingleChatInfoUI nHf;

                    public final void run() {
                        View a = ((com.tencent.mm.ui.base.preference.a) this.nHf.dxf).a(Oy, this.nHf.gMx);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.b(this.nHf.nDR.nEl, a);
                        }
                    }
                }, 10);
            }
            this.ePv = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.b(this);
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1) {
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final int Oo() {
        return 2131099713;
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        Fd(getString(2131234689));
        this.ePg = (ContactListExpandPreference) this.dxf.Ow("roominfo_contact_anchor");
        this.ePg.a(this.dxf, this.ePg.dnU);
        this.ePg.hZ(true).ia(false);
        if (this.euW != null && this.euW.field_deleteFlag == 1) {
            this.ePg.hZ(false);
        }
        this.ePh = (CheckBoxPreference) this.dxf.Ow("room_notify_new_msg");
        this.ePj = (CheckBoxPreference) this.dxf.Ow("room_placed_to_the_top");
        if (this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.euW != null) {
            ak.yW();
            this.cnm.edit().putBoolean("room_placed_to_the_top", c.wK().Mn(this.euW.field_username)).commit();
            this.eJx = this.euW.tM();
            this.cnm.edit().putBoolean("room_notify_new_msg", this.eJx).commit();
        } else {
            this.cnm.edit().putBoolean("room_notify_new_msg", false).commit();
            this.eJx = false;
        }
        ak.yW();
        this.ePt = c.wJ().Nc(this.bdo);
        this.dxf.notifyDataSetChanged();
        if (this.ePg != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.bdo);
            this.ePg.j(this.bdo, linkedList);
            this.gMx.setOnScrollListener(this.ePu);
            this.ePg.a(this.ePu);
            this.ePg.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a(this) {
                final /* synthetic */ SingleChatInfoUI nHf;

                {
                    this.nHf = r1;
                }

                public final void jo(int i) {
                }

                public final void jp(int i) {
                    String tY = this.nHf.ePg.tY(i);
                    String ma = t.ma(this.nHf.ePg.ua(i));
                    if (t.kS(ma)) {
                        ak.yW();
                        ba Nw = c.wI().Nw(tY);
                        if (!(Nw == null || t.kS(Nw.field_encryptUsername))) {
                            ma = Nw.field_conRemark;
                        }
                    }
                    if (!t.kS(tY)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", tY);
                        intent.putExtra("Contact_RemarkName", ma);
                        intent.putExtra("Contact_Nick", t.ma(this.nHf.ePg.tZ(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        ak.yW();
                        ab LX = c.wH().LX(tY);
                        if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                            e.a(intent, tY);
                        }
                        intent.putExtra("Kdel_from", 0);
                        com.tencent.mm.ay.c.b(this.nHf, "profile", ".ui.ContactInfoUI", intent, 0);
                    }
                }

                public final void adp() {
                    if (this.nHf.ePg != null) {
                        this.nHf.ePg.bpp();
                    }
                }

                public final void jq(int i) {
                    SingleChatInfoUI.c(this.nHf);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SingleChatInfoUI nHf;

            {
                this.nHf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nHf.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.dnU;
        if (str.equals("room_notify_new_msg")) {
            if (this.eJx) {
                z = false;
            }
            this.eJx = z;
            if (this.eJx) {
                m.l(this.euW);
            } else {
                m.m(this.euW);
            }
            ak.yW();
            this.euW = c.wH().LX(this.bdo);
            if (this.cnm == null) {
                this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.cnm.edit().putBoolean("room_notify_new_msg", this.eJx).commit();
            adj();
        } else if (str.equals("room_placed_to_the_top")) {
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
        } else if (str.equals("room_chatting_images")) {
            g.iuh.a(219, 12, 1, true);
            r0 = new Intent();
            r0.setClass(this.nDR.nEl, ImageGalleryGridUI.class);
            r0.addFlags(67108864);
            r0.putExtra("kintent_intent_source", 1);
            r0.putExtra("kintent_talker", this.bdo);
            r0.putExtra("kintent_image_count", this.ePt);
            if (this.ePt > 0) {
                ak.yW();
                r0.putExtra("kintent_image_index", c.wJ().Nb(this.bdo) - 1);
            }
            g.iuh.h(11627, Integer.valueOf(1));
            startActivity(r0);
        } else if (str.equals("room_set_chatting_background")) {
            r0 = new Intent();
            r0.putExtra("isApplyToAll", false);
            r0.putExtra("username", this.euW.field_username);
            com.tencent.mm.ay.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", r0, 2);
        } else if (str.equals("room_search_chatting_content")) {
            r0 = new Intent();
            r0.putExtra("detail_username", this.bdo);
            com.tencent.mm.ay.c.b((Context) this, "search", ".ui.FTSChattingTalkerUI", r0);
        } else if (str.equals("room_clear_chatting_history")) {
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131232871, new Object[]{this.euW.tU()}), SQLiteDatabase.KeyEmpty, getString(2131231012), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ SingleChatInfoUI nHf;

                {
                    this.nHf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SingleChatInfoUI.d(this.nHf);
                }
            }, null, 2131689512);
        } else if (str.equals("room_expose")) {
            r0 = new Intent();
            r0.putExtra("k_username", this.bdo);
            r0.putExtra("showShare", false);
            r0.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            com.tencent.mm.ay.c.b((Context) this, "webview", ".ui.tools.WebViewUI", r0);
        }
        return false;
    }

    private void adj() {
        if (this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.eJx = this.euW.tM();
        if (this.eJx) {
            vI(0);
            if (this.ePh != null) {
                this.cnm.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            vI(8);
            if (this.ePh != null) {
                this.cnm.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.dxf.notifyDataSetChanged();
    }

    public final void y(String str, String str2, String str3) {
        if (str.equals(this.bdo) && this.ePg != null) {
            this.ePg.notifyChanged();
        }
    }

    public final h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
