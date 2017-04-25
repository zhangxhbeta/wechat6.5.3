package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j.aj;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.d.d;
import com.tencent.mm.ui.h.a.a;
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import java.io.RandomAccessFile;

public class AddMoreFriendsUI extends MMPreference implements a, b, e {
    private ProgressDialog dwR = null;
    private f dxf;
    private String fPD;
    private ProgressDialog gNy = null;
    private ProgressBar ilM = null;
    private com.tencent.mm.ui.h.a jYd = new com.tencent.mm.ui.h.a();
    private boolean khA = false;
    private boolean khB = false;
    private p khm = null;
    private l khn;
    private final int kho = 1;
    private final int khp = 2;
    private final int khq = 3;
    private final int khr = 4;
    private final int khs = 5;
    private final int kht = 4;
    private final int khu = 9;
    private int khv;
    private Bitmap khw = null;
    private View khx;
    private EditText khy = null;
    private ImageView khz = null;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] gNW = new int[c.values().length];

        static {
            try {
                gNW[c.oYo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gNW[c.oYq.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gNW[c.oYp.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static /* synthetic */ void a(AddMoreFriendsUI addMoreFriendsUI, int i) {
        final com.tencent.mm.modelmulti.e eVar = new com.tencent.mm.modelmulti.e(i);
        addMoreFriendsUI.getString(2131231164);
        addMoreFriendsUI.dwR = g.a(addMoreFriendsUI, addMoreFriendsUI.getString(2131233521), true, new OnCancelListener(addMoreFriendsUI) {
            final /* synthetic */ AddMoreFriendsUI khC;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(eVar);
            }
        });
        ak.vy().a(eVar, 0);
    }

    static /* synthetic */ void a(AddMoreFriendsUI addMoreFriendsUI, int i, String str) {
        final h hVar = new h(i, str);
        addMoreFriendsUI.getString(2131231164);
        addMoreFriendsUI.dwR = g.a(addMoreFriendsUI, addMoreFriendsUI.getString(2131231151), true, new OnCancelListener(addMoreFriendsUI) {
            final /* synthetic */ AddMoreFriendsUI khC;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(hVar);
            }
        });
        ak.vy().a(hVar, 0);
    }

    public final int Oo() {
        return 2131099649;
    }

    public final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(1803, this);
        ak.vy().a(1804, this);
        ak.vy().a(168, this);
        if (aj.lyc != null) {
            this.khm = aj.lyc.ap(this, k.xF());
        }
        this.khv = be.getInt(j.sU().getValue("InviteFriendsInviteFlags"), 0);
        NI();
    }

    public void onResume() {
        super.onResume();
        ak.vy().a(106, this);
        if (com.tencent.mm.ay.c.EH("brandservice")) {
            this.dxf.aO("find_friends_by_web", false);
        } else {
            this.dxf.aO("find_friends_by_web", true);
        }
        AddFriendItemPreference addFriendItemPreference = (AddFriendItemPreference) this.dxf.Ow("find_friends_by_other_way");
        if (addFriendItemPreference != null) {
            boolean z = (k.xQ() & 16777216) != 16777216 && com.tencent.mm.h.g.sX();
            if (z) {
                addFriendItemPreference.setTitle(getString(2131232779));
            }
        }
        this.dxf.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.dxf.Ow("find_friends_by_input");
        addFriendSearchPreference.khd = getString(2131232211);
        addFriendSearchPreference.khf = new OnClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI khC;

            {
                this.khC = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ay.c.b(this.khC, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0));
            }
        };
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.dxf.Ow("find_friends_info");
        String xF = k.xF();
        String xG = k.xG();
        ak.yW();
        CharSequence string = !be.kS(xG) ? getString(2131232788, new Object[]{xG}) : !u.LL(xF) ? getString(2131232788, new Object[]{xF}) : !be.kS(al.Kq((String) com.tencent.mm.model.c.vf().get(6, null))) ? getString(2131232789, new Object[]{al.Kp(al.Kq((String) com.tencent.mm.model.c.vf().get(6, null)))}) : getString(2131232790);
        preferenceInfoCategory.setTitle(string);
        preferenceInfoCategory.nEN = 2130838421;
        OnClickListener anonymousClass9 = new OnClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI khC;

            {
                this.khC = r1;
            }

            public final void onClick(View view) {
                if (this.khC.khm != null) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11264, new Object[]{Integer.valueOf(1)});
                    this.khC.khm.show();
                }
            }
        };
        preferenceInfoCategory.lPi = anonymousClass9;
        preferenceInfoCategory.odK = anonymousClass9;
        ((AddFriendItemPreference) this.dxf.Ow("find_friends_create_pwdgroup")).fgx = 8;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.ocZ != null) {
            Preference Ow = this.ocZ.Ow("find_friends_by_web");
            if (Ow != null) {
                Ow.setEnabled(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(106, this);
    }

    public void onDestroy() {
        if (this.khm != null) {
            this.khm.onDestroy();
            this.khm = null;
        }
        super.onDestroy();
        ak.vy().b(1803, this);
        ak.vy().b(1804, this);
        ak.vy().b(168, this);
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.dnU)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            com.tencent.mm.plugin.report.service.g.iuh.h(11265, new Object[]{Integer.valueOf(1)});
            if (!(com.tencent.mm.as.u.bi(this) || com.tencent.mm.ah.a.aT(this))) {
                com.tencent.mm.ay.c.b(this, "scanner", ".ui.BaseScanUI", intent);
            }
            return true;
        } else if ("find_friends_by_other_way".equals(preference.dnU)) {
            startActivity(new Intent(this, AddMoreFriendsByOtherWayUI.class));
            return true;
        } else if ("find_friends_by_web".equals(preference.dnU)) {
            if (com.tencent.mm.modelsearch.h.Ih()) {
                intent = com.tencent.mm.modelsearch.h.Ij();
                intent.putExtra("KRightBtn", true);
                intent.putExtra("ftsneedkeyboard", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsType", 1);
                intent.putExtra("ftsbizscene", 9);
                intent.putExtra("rawUrl", com.tencent.mm.modelsearch.h.l(com.tencent.mm.modelsearch.h.a(9, true, 0)));
                com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", intent);
                preference.setEnabled(false);
            } else {
                v.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        } else if ("find_friends_by_radar".equals(preference.dnU)) {
            com.tencent.mm.ay.c.w(this, "radar", ".ui.RadarSearchUI");
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.dnU)) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11140, new Object[]{Integer.valueOf(1)});
            com.tencent.mm.ay.c.w(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            return true;
        } else if (!"find_friends_by_invite".equals(preference.dnU)) {
            return false;
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(224, 2, 1, false);
            this.khn = new l(this.nDR.nEl);
            this.khn.jXn = new n.c(this) {
                final /* synthetic */ AddMoreFriendsUI khC;

                {
                    this.khC = r1;
                }

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    if ((this.khC.khv & 1) > 0) {
                        lVar.dg(1, 2131233313);
                    }
                    if ((this.khC.khv & 2) > 0) {
                        lVar.dg(2, 2131233315);
                    }
                    if ((this.khC.khv & 4) > 0 && AddMoreFriendsUI.Z(this.khC.nDR.nEl, "com.whatsapp")) {
                        lVar.dg(3, 2131233317);
                    }
                    if ((this.khC.khv & 8) > 0 && k.yf()) {
                        lVar.dg(4, 2131233311);
                    }
                    if ((this.khC.khv & 16) > 0) {
                        lVar.dg(5, 2131233316);
                    }
                }
            };
            this.khn.jXo = new n.d(this) {
                final /* synthetic */ AddMoreFriendsUI khC;

                {
                    this.khC = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            AddMoreFriendsUI.a(this.khC, 1);
                            return;
                        case 2:
                            AddMoreFriendsUI.a(this.khC, 2);
                            return;
                        case 3:
                            AddMoreFriendsUI.a(this.khC, 4);
                            return;
                        case 4:
                            if (k.yh()) {
                                this.khC.khB = true;
                                AddMoreFriendsUI.a(this.khC, 8);
                                return;
                            }
                            g.a(this.khC.nDR.nEl, 2131235011, 2131231164, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 khD;

                                {
                                    this.khD = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.ay.c.a(this.khD.khC.nDR.nEl, ".ui.account.FacebookAuthUI", new Intent());
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 khD;

                                {
                                    this.khD = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        case 5:
                            if (this.khC.jYd.bJR()) {
                                this.khC.khA = true;
                                AddMoreFriendsUI.a(this.khC, 16);
                                return;
                            }
                            g.a(this.khC.nDR.nEl, 2131235184, 2131231164, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 khD;

                                {
                                    this.khD = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AddMoreFriendsUI addMoreFriendsUI = this.khD.khC;
                                    ActionBarActivity actionBarActivity = this.khD.khC.nDR.nEl;
                                    this.khD.khC.nDR.nEl.getString(2131231164);
                                    addMoreFriendsUI.gNy = g.a(actionBarActivity, this.khD.khC.nDR.nEl.getString(2131235701), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass3 khE;

                                        {
                                            this.khE = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    this.khD.khC.jYd.a(this.khD.khC, this.khD.khC.nDR.nEl);
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 khD;

                                {
                                    this.khD = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            };
            this.khn.aXZ();
            return true;
        }
    }

    private static boolean Z(Context context, String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    protected final void NI() {
        vD(2131230810);
        this.dxf = this.ocZ;
        Preference addFriendItemPreference = new AddFriendItemPreference(this.nDR.nEl);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle(2131232774);
        addFriendItemPreference.OL = 2131165213;
        Drawable drawable = addFriendItemPreference.mContext.getResources().getDrawable(2131165213);
        if ((drawable == null && addFriendItemPreference.jP != null) || !(drawable == null || addFriendItemPreference.jP == drawable)) {
            addFriendItemPreference.jP = drawable;
            addFriendItemPreference.notifyChanged();
        }
        addFriendItemPreference.setSummary(2131232775);
        if ((be.getInt(j.sU().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.dxf.a(addFriendItemPreference, 4);
        }
        if (true == this.nDR.nEl.getIntent().getBooleanExtra("Invite_friends", false)) {
            a(this.dxf, addFriendItemPreference);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI khC;

            {
                this.khC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.khC.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.AddMoreFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (!com.tencent.mm.plugin.subapp.b.drq.b(this.nDR.nEl, i, i2, str)) {
            Intent intent;
            String a;
            String str2;
            Intent intent2;
            if (kVar.getType() == 106) {
                if (i == 4 && i2 == -4) {
                    g.f(this.nDR.nEl, 2131230867, 2131231164);
                    return;
                } else if (i == 0 && i2 == 0) {
                    ars Jx = ((y) kVar).Jx();
                    if (Jx.mxP > 0) {
                        intent = new Intent();
                        intent.setClass(this.nDR.nEl, ContactSearchResultUI.class);
                        try {
                            intent.putExtra("result", Jx.toByteArray());
                            startActivity(intent);
                        } catch (Throwable e) {
                            v.a("MicroMsg.AddMoreFriendsUI", e, "", new Object[0]);
                        }
                    } else {
                        int i3;
                        a = m.a(Jx.moM);
                        str2 = this.fPD;
                        if (be.Kw(str2)) {
                            i3 = 1;
                        } else if (be.Kx(str2)) {
                            i3 = 2;
                        } else {
                            be.Ky(str2);
                            i3 = 3;
                        }
                        intent2 = new Intent();
                        com.tencent.mm.plugin.subapp.b.drq.a(intent2, Jx, i3);
                        if (be.ma(a).length() > 0) {
                            if ((Jx.mFu & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(10298, a + "," + i3);
                            }
                            com.tencent.mm.ay.c.b(this.nDR.nEl, "profile", ".ui.ContactInfoUI", intent2);
                        }
                    }
                } else {
                    Toast.makeText(this, getString(2131232921), 0).show();
                    v.w("MicroMsg.AddMoreFriendsUI", getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                    return;
                }
            }
            if (kVar.getType() == 1803) {
                if (i == 0 && i2 == 0) {
                    Object obj;
                    com.tencent.mm.modelmulti.e eVar = (com.tencent.mm.modelmulti.e) kVar;
                    String str3 = be.kS(eVar.title) ? null : eVar.title;
                    eVar = (com.tencent.mm.modelmulti.e) kVar;
                    String str4 = be.kS(eVar.content) ? null : eVar.content;
                    a = k.xG();
                    ak.yW();
                    str2 = (String) com.tencent.mm.model.c.vf().get(6, null);
                    if (be.kS(a)) {
                        obj = str2;
                    } else {
                        String str5 = a;
                    }
                    int i4 = ((com.tencent.mm.modelmulti.e) kVar).cRc;
                    if ((i4 & 1) > 0) {
                        if (be.kS(str3)) {
                            str3 = String.format(getString(2131233321), new Object[]{k.xH()});
                        }
                        if (be.kS(str4)) {
                            str4 = String.format(getString(2131233320), new Object[]{obj});
                        }
                        intent = new Intent("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.SUBJECT", str3);
                        intent.putExtra("android.intent.extra.TEXT", str4);
                        intent.setType("plain/text");
                        startActivity(Intent.createChooser(intent, getString(2131233314)));
                    }
                    str2 = str4;
                    if ((i4 & 2) > 0) {
                        if (be.kS(str2)) {
                            str2 = String.format(getString(2131233322), new Object[]{obj});
                        }
                        intent2 = new Intent("android.intent.action.VIEW");
                        intent2.putExtra("sms_body", str2);
                        intent2.setType("vnd.android-dir/mms-sms");
                        if (be.m(this, intent2)) {
                            startActivity(intent2);
                        } else {
                            Toast.makeText(this, 2131234877, 1).show();
                        }
                    }
                    if ((i4 & 4) > 0) {
                        if (be.kS(str2)) {
                            str2 = String.format(getString(2131233322), new Object[]{obj});
                        }
                        intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.TEXT", str2);
                        intent2.setType("text/plain");
                        intent2.setPackage("com.whatsapp");
                        startActivity(intent2);
                    }
                    if ((i4 & 8) > 0) {
                        if (be.kS(str2)) {
                            if (be.kS(k.xG())) {
                                str2 = getString(2131233319);
                            } else {
                                str2 = String.format(getString(2131233318), new Object[]{k.xG()});
                            }
                        }
                        str3 = getString(2131233311);
                        if (this.khB) {
                            n(i4, str2, str3);
                            this.khB = false;
                        }
                    }
                    if ((i4 & 16) > 0) {
                        this.jYd.a(this);
                        if (be.kS(str2)) {
                            if (be.kS(k.xG())) {
                                str2 = getString(2131233319);
                            } else {
                                str2 = String.format(getString(2131233318), new Object[]{k.xG()});
                            }
                        }
                        str3 = getString(2131233316);
                        if (this.khA) {
                            n(i4, str2, str3);
                            this.khA = false;
                        }
                    }
                } else {
                    g.f(this.nDR.nEl, 2131233519, 2131231164);
                    return;
                }
            }
            if (kVar.getType() == 1804) {
                if (i == 0 && i2 == 0) {
                    g.bf(this, getResources().getString(2131231978));
                } else {
                    g.f(this.nDR.nEl, 2131234920, 2131231164);
                    return;
                }
            }
            if (kVar.getType() == 168 && i == 0 && i2 == 0 && this.khz != null) {
                if (this.ilM != null) {
                    this.ilM.setVisibility(8);
                }
                this.khz.setImageBitmap(avp());
            }
        }
    }

    private void n(final int i, final String str, String str2) {
        this.khx = View.inflate(this.nDR.nEl, 2130903397, null);
        this.khy = (EditText) this.khx.findViewById(2131756405);
        this.khz = (ImageView) this.khx.findViewById(2131756404);
        this.ilM = (ProgressBar) this.khx.findViewById(2131755522);
        this.khy.setText(str);
        this.khw = avp();
        if (this.khw == null) {
            String xF = k.xF();
            ak.yW();
            ak.vy().a(new com.tencent.mm.am.a(xF, be.f((Integer) com.tencent.mm.model.c.vf().get(66561, null))), 0);
            ((ProgressBar) this.khx.findViewById(2131755522)).setVisibility(0);
        } else if (this.khz != null) {
            this.khz.setImageBitmap(this.khw);
        }
        com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, str2, this.khx, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.b(this) {
            final /* synthetic */ AddMoreFriendsUI khC;

            public final void dP(boolean z) {
                if (z) {
                    AddMoreFriendsUI.a(this.khC, i, this.khC.khy == null ? str : this.khC.khy.getText().toString());
                }
            }
        });
    }

    private static Bitmap avp() {
        byte[] vc = vc(k.xF());
        if (vc == null) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.bc(vc);
    }

    private static byte[] vc(String str) {
        Throwable e;
        ak.yW();
        String wP = com.tencent.mm.model.c.wP();
        ak.yW();
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(com.tencent.mm.sdk.platformtools.h.e(wP, com.tencent.mm.model.c.wQ(), "qr_", com.tencent.mm.a.g.m(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Exception e2) {
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.a("MicroMsg.AddMoreFriendsUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            v.a("MicroMsg.AddMoreFriendsUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }

    private void mj(int i) {
        g.a(this.nDR.nEl, i, 2131231164, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI khC;

            {
                this.khC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ AddMoreFriendsUI khC;

            {
                this.khC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void a(c cVar) {
        if (this.gNy != null) {
            this.gNy.cancel();
        }
        switch (AnonymousClass3.gNW[cVar.ordinal()]) {
            case 1:
                mj(2131235703);
                return;
            case 3:
                mj(2131235702);
                return;
            default:
                return;
        }
    }

    public final void b(c cVar) {
    }
}
