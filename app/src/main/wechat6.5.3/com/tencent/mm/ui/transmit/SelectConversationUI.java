package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.f;
import com.tencent.mm.as.o;
import com.tencent.mm.e.a.ex;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.c.c;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.q;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@a(19)
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int oXq = r.s(1, 2);
    private long aZa;
    private long bao;
    private String blu;
    private at bmk;
    private int duf;
    private List<String> ejp;
    private int[] fSx = new int[]{2131756248, 2131756249, 2131756250, 2131756251, 2131756252};
    private int fromScene = 0;
    private String imagePath = null;
    private int msgType;
    private boolean oHp;
    private boolean oIo = false;
    private String oXA;
    private boolean oXB = false;
    private boolean oXC = false;
    private List<String> oXD = null;
    private ReportArgs oXE;
    private String oXF;
    private String oXG = null;
    private String oXH = null;
    private OnMenuItemClickListener oXI = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectConversationUI oXK;

        {
            this.oXK = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.oXK.oXC = !this.oXK.oXC;
            this.oXK.bHH().jW(this.oXK.oXC);
            this.oXK.oHd.jW(this.oXK.oXC);
            this.oXK.NN();
            this.oXK.oiD.setText(!this.oXK.oXC ? this.oXK.oXr : 2131234872);
            return true;
        }
    };
    private OnMenuItemClickListener oXJ = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectConversationUI oXK;

        {
            this.oXK = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (this.oXK.kl(false)) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", t.b(this.oXK.oXD, ","));
            Intent intent2 = (Intent) this.oXK.getIntent().getParcelableExtra("Select_Conv_NextStep");
            if (intent2 != null) {
                this.oXK.a(intent, intent2);
            } else {
                SelectConversationUI.a(this.oXK, intent);
            }
            return true;
        }
    };
    private int oXr;
    private boolean oXs = false;
    private boolean oXt = false;
    private boolean oXu = false;
    private boolean oXv = false;
    private boolean oXw = false;
    private int oXx;
    private boolean oXy = false;
    private int oXz = 3;
    private TextView oiD;

    static /* synthetic */ void a(SelectConversationUI selectConversationUI, final Intent intent) {
        if (r.dn(selectConversationUI.duf, FileUtils.S_IRUSR)) {
            selectConversationUI.setResult(-1, intent);
            selectConversationUI.finish();
            return;
        }
        c cVar = new c(selectConversationUI.nDR.nEl);
        cVar.ba(selectConversationUI.oXD);
        if (selectConversationUI.oIo) {
            selectConversationUI.a(cVar, selectConversationUI.oXA);
            a(intent, selectConversationUI.oXA, selectConversationUI.oXD);
        } else if (selectConversationUI.oXt) {
            if (selectConversationUI.aZa != -1) {
                b exVar = new ex();
                exVar.bdL.aZa = selectConversationUI.aZa;
                exVar.bdL.bdM = cVar;
                exVar.bdL.bdN = selectConversationUI.nDR.nEl;
                com.tencent.mm.sdk.c.a.nhr.z(exVar);
            } else if (selectConversationUI.msgType == 17 && selectConversationUI.oXx != 0) {
                cVar.Hw(new StringBuffer(selectConversationUI.getResources().getString(2131231092)).append(selectConversationUI.nDR.nEl.getString(2131234556, new Object[]{Integer.valueOf(selectConversationUI.oXx)})).toString());
            }
        } else if (selectConversationUI.oXu) {
            cVar.Hw(new StringBuffer(selectConversationUI.getResources().getString(2131231171)).append((String) ((HashMap) selectConversationUI.getIntent().getSerializableExtra("webview_params")).get(SlookSmartClipMetaTag.TAG_TYPE_TITLE)).toString());
        } else if (selectConversationUI.oXv) {
            cVar.Hw(new StringBuffer(selectConversationUI.getResources().getString(2131230923)).append((String) ((HashMap) selectConversationUI.getIntent().getSerializableExtra("webview_params")).get(SlookSmartClipMetaTag.TAG_TYPE_TITLE)).toString());
        } else {
            selectConversationUI.a(cVar);
        }
        cVar.d(Boolean.valueOf(true)).tS(2131231149).a(new com.tencent.mm.pluginsdk.ui.applet.c.a(selectConversationUI) {
            final /* synthetic */ SelectConversationUI oXK;

            public final void a(boolean z, String str, int i) {
                this.oXK.axg();
                if (z) {
                    intent.putExtra("custom_send_text", str);
                    this.oXK.setResult(-1, intent);
                    this.oXK.finish();
                }
            }
        }).iji.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        v.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!t.kS(stringExtra) && !t.kS(stringExtra2)) {
            new d(this, stringExtra, stringExtra2, new d.a(this) {
                final /* synthetic */ SelectConversationUI oXK;

                {
                    this.oXK = r1;
                }

                public final void bV(boolean z) {
                    boolean isFinishing = this.oXK.isFinishing();
                    v.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                    if (!z && !isFinishing) {
                        this.oXK.finish();
                    }
                }
            }).WK();
        }
    }

    protected final void NH() {
        super.NH();
        this.oXs = getIntent().getBooleanExtra("select_is_ret", false);
        this.fromScene = getIntent().getIntExtra("scene_from", 0);
        v.i("MicroMsg.SelectConversationUI", "from scene:%d", Integer.valueOf(this.fromScene));
        if (this.fromScene == 1) {
            this.oXt = true;
        } else if (this.fromScene == 2) {
            this.oXu = true;
        } else if (this.fromScene == 3) {
            this.oXv = true;
        }
        this.oXw = getIntent().getBooleanExtra("send_to_biz", false);
        this.aZa = getIntent().getLongExtra("select_fav_local_id", -1);
        this.oXx = getIntent().getIntExtra("select_fav_select_count", 0);
        this.oXB = getIntent().getBooleanExtra("mutil_select_is_ret", false);
        this.oIo = getIntent().getBooleanExtra("Select_Send_Card", false);
        this.oXy = getIntent().getBooleanExtra("Retr_Big_File", false);
        if (this.oIo) {
            this.oXA = getIntent().getStringExtra("Select_Talker_Name");
        }
        this.duf = getIntent().getIntExtra("Select_Conv_Type", oXq);
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.bao = getIntent().getLongExtra("Retr_Msg_Id", -1);
        ak.yW();
        this.bmk = com.tencent.mm.model.c.wJ().ek(this.bao);
        this.imagePath = getIntent().getStringExtra("image_path");
        this.oXG = getIntent().getStringExtra("ad_video_title");
        this.oXH = getIntent().getStringExtra("file_title");
        this.oXF = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.blu = getIntent().getStringExtra("Retr_Msg_content");
        if (this.blu == null && this.bmk != null) {
            this.blu = this.bmk.field_content;
        }
        this.oXE = (ReportArgs) getIntent().getParcelableExtra("Select_Report_Args");
        Collection hashSet = new HashSet();
        hashSet.addAll(r.bHP());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!t.kS(stringExtra)) {
            hashSet.addAll(t.g(stringExtra.split(",")));
        }
        if (r.dn(this.duf, 2)) {
            Collection bHQ = r.bHQ();
            r.e(bHQ);
            hashSet.addAll(bHQ);
        }
        this.ejp = new ArrayList();
        this.ejp.addAll(hashSet);
        if (r.dn(this.duf, 1)) {
            this.oHp = true;
        }
        if (this.oXB) {
            this.oXD = new LinkedList();
            if (this.oXB) {
                a(1, getString(2131231094), this.oXI, k.b.nET);
                NN();
            }
        }
    }

    protected final n NL() {
        return new s(this, this.ejp, this.oHp, this.oXC, this.oXw, this.duf);
    }

    protected final p NM() {
        return new p(this, this.ejp, this.oXC, this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.oiD == null) {
            if (this.oIo) {
                this.oXr = 2131234872;
            } else {
                this.oXr = 2131234867;
            }
            OnClickListener anonymousClass2 = new OnClickListener(this) {
                final /* synthetic */ SelectConversationUI oXK;

                {
                    this.oXK = r1;
                }

                public final void onClick(View view) {
                    if (this.oXK.oXC) {
                        this.oXK.bJK();
                    } else if (this.oXK.oIo) {
                        this.oXK.bJL();
                    } else {
                        this.oXK.bJM();
                    }
                }
            };
            CharSequence string = getString(this.oXr);
            View inflate = q.em(this).inflate(2130903780, null);
            inflate.setOnClickListener(anonymousClass2);
            TextView textView = (TextView) inflate.findViewById(2131757427);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.oiD = textView;
        }
        this.oiD.setVisibility(i);
    }

    protected final void ayE() {
        super.ayE();
        axg();
        if (this.oXE != null) {
            ReportUtil.a((Context) this, this.oXE);
        }
    }

    public final void gJ(int i) {
        com.tencent.mm.ui.contact.a.a xS;
        if (this.oXC) {
            int headerViewsCount = i - this.ieb.getHeaderViewsCount();
            if (headerViewsCount < 0) {
                v.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
                bJK();
                return;
            }
            m bHH = bHH();
            xS = bHH.xS(headerViewsCount);
            if (xS != null && xS.euW != null) {
                String str = xS.euW.field_username;
                v.i("MicroMsg.SelectConversationUI", "ClickUser=%s", str);
                if (this.oXD.contains(str) || !kl(true)) {
                    bHM();
                    this.hkH.Hq(str);
                    if (this.oXD.contains(str)) {
                        this.oXD.remove(str);
                    } else {
                        this.oXD.add(str);
                    }
                    NN();
                    bHH.notifyDataSetChanged();
                    return;
                }
                bHM();
            }
        } else if (i < this.ieb.getHeaderViewsCount()) {
            v.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
            if (this.oIo) {
                bJL();
            } else {
                bJM();
            }
        } else {
            xS = (com.tencent.mm.ui.contact.a.a) this.ieb.getAdapter().getItem(i);
            if (xS == null) {
                return;
            }
            Intent intent;
            if ((xS instanceof com.tencent.mm.ui.contact.a.b) && ((com.tencent.mm.ui.contact.a.b) xS).aGX == getResources().getString(2131230868)) {
                v.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                intent = new Intent();
                intent.putExtra("list_attr", 16384);
                com.tencent.mm.ay.c.b(this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.oXu = true;
                return;
            }
            ab abVar = xS.euW;
            if (abVar != null) {
                String str2 = abVar.field_username;
                v.i("MicroMsg.SelectConversationUI", "doClickUser=%s", str2);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", str2);
                intent = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent != null) {
                    a(intent2, intent);
                } else if (this.oXs || this.oIo || this.oXt || this.oXu || this.oXv) {
                    l(intent2, str2);
                } else {
                    setResult(-1, intent2);
                    finish();
                }
                axg();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            v.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            v.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        String stringExtra;
        Intent intent2;
        if (i == 1) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                v.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    a(intent, intent2);
                } else if (this.oXs || this.oIo || this.oXt || this.oXu || this.oXv) {
                    l(intent, stringExtra);
                } else {
                    setResult(-1, intent);
                    finish();
                }
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    finish();
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        intent2 = new Intent(this, TaskRedirectUI.class);
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    }
                    return;
                case 0:
                    if (intent != null) {
                        this.oXE = (ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3) {
            switch (i2) {
                case -1:
                    if (intent != null) {
                        r0 = intent.getStringExtra("received_card_name");
                        if (!be.kS(r0)) {
                            c cVar = new c(this.nDR.nEl);
                            cVar.ba(r0);
                            a(cVar, this.oXA);
                            cVar.d(Boolean.valueOf(true)).tS(2131231149).a(new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                                final /* synthetic */ SelectConversationUI oXK;

                                public final void a(boolean z, String str, int i) {
                                    this.oXK.axg();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (r0.endsWith("@chatroom")) {
                                            SelectConversationUI.b(intent, this.oXK.oXA, r0);
                                        } else {
                                            SelectConversationUI.a(intent, this.oXK.oXA, r0);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        this.oXK.setResult(-1, intent);
                                        this.oXK.finish();
                                    }
                                }
                            }).iji.show();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 4) {
            if (i2 == -1) {
                l(intent, intent.getStringExtra("Select_Contact"));
            }
        } else if (i != 5) {
            v.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            for (String Hr : this.oXD) {
                this.hkH.Hr(Hr);
            }
            if (t.kS(stringExtra)) {
                this.oXD.clear();
            } else {
                this.oXD = t.g(stringExtra.split(","));
            }
            for (String Hr2 : this.oXD) {
                this.hkH.aD(Hr2, false);
            }
            NN();
            bHH().notifyDataSetChanged();
        }
    }

    private static void a(Intent intent, String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(str2);
        a(intent, str, linkedList);
    }

    private static void a(Intent intent, String str, List<String> list) {
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", t.b(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
    }

    private static void b(Intent intent, String str, String str2) {
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
    }

    private void a(c cVar, String str) {
        ak.yW();
        ab LV = com.tencent.mm.model.c.wH().LV(str);
        CharSequence charSequence = null;
        Bitmap a = com.tencent.mm.u.b.a(str, true, -1);
        if (a == null) {
            a = com.tencent.mm.u.b.a(str, false, -1);
        }
        if (!com.tencent.mm.model.m.eG(LV.field_verifyFlag)) {
            charSequence = LV.pD();
            if (be.kS(charSequence)) {
                charSequence = LV.tV();
            }
        } else if (a != null) {
            a = com.tencent.mm.sdk.platformtools.d.a(a, false, (float) (a.getWidth() / 2));
        }
        if (a == null) {
            a = com.tencent.mm.compatible.f.a.decodeResource(this.nDR.nEl.getResources(), 2131165440);
        }
        Object er = l.er(str);
        h.a aVar = cVar.lJF;
        aVar.nUn.nRM = a;
        aVar.nUn.nRP = er;
        aVar.nUn.nRQ = charSequence;
        aVar.nUn.nSg = true;
        ak.yW();
        new StringBuffer(com.tencent.mm.model.m.eG(com.tencent.mm.model.c.wH().LV(str).field_verifyFlag) ? getResources().getString(2131231069) : getResources().getString(2131231070)).append(er);
    }

    private void a(Intent intent, Intent intent2) {
        v.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=" + intent2);
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        com.tencent.mm.ui.base.b.x(this.nDR.nEl, intent2);
    }

    private void l(final Intent intent, String str) {
        if (r.dn(this.duf, FileUtils.S_IRUSR)) {
            setResult(-1, intent);
            finish();
        } else if (t.kS(str)) {
            v.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
        } else {
            if (com.tencent.mm.model.m.dE(str)) {
                int el = i.el(str);
                if (!this.oXy || el <= t.getInt(j.sU().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)) {
                    getString(2131234863, new Object[]{Integer.valueOf(el)});
                } else {
                    v.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", Integer.valueOf(t.getInt(j.sU().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)), Integer.valueOf(el));
                    g.A(this, getString(2131234865, new Object[]{Integer.valueOf(r1)}), SQLiteDatabase.KeyEmpty);
                    return;
                }
            }
            c cVar = new c(this.nDR.nEl);
            cVar.ba(str);
            if (this.oIo) {
                a(cVar, this.oXA);
                if (str.endsWith("@chatroom")) {
                    b(intent, this.oXA, str);
                } else {
                    a(intent, this.oXA, str);
                }
            } else if (this.oXt) {
                if (this.aZa != -1) {
                    b exVar = new ex();
                    exVar.bdL.aZa = this.aZa;
                    exVar.bdL.bdM = cVar;
                    exVar.bdL.bdN = this.nDR.nEl;
                    com.tencent.mm.sdk.c.a.nhr.z(exVar);
                } else if (this.msgType == 17 && this.oXx != 0) {
                    cVar.Hw(new StringBuffer(getResources().getString(2131231092)).append(this.nDR.nEl.getString(2131234556, new Object[]{Integer.valueOf(this.oXx)})).toString());
                }
            } else if (this.oXu) {
                r0 = (HashMap) getIntent().getSerializableExtra("webview_params");
                r1 = (String) r0.get("img_url");
                cVar.Hw(new StringBuffer(getResources().getString(2131231171)).append((String) r0.get(SlookSmartClipMetaTag.TAG_TYPE_TITLE)).toString());
                cVar.Hx(r1).bpi();
            } else if (this.oXv) {
                r0 = (HashMap) getIntent().getSerializableExtra("appbrand_params");
                r1 = (String) r0.get(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
                String str2 = (String) r0.get("img_url");
                cVar.Hw(new StringBuffer(getResources().getString(2131230923)).append(r1).toString());
                cVar.Hx(str2).bpi();
            } else {
                a(cVar);
            }
            cVar.d(Boolean.valueOf(true)).tS(2131231149).a(new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                final /* synthetic */ SelectConversationUI oXK;

                public final void a(boolean z, String str, int i) {
                    this.oXK.axg();
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        this.oXK.setResult(-1, intent);
                        this.oXK.finish();
                    }
                }
            }).iji.show();
        }
    }

    private void a(c cVar) {
        String str;
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap bitmap;
                if (this.bmk == null) {
                    bitmap = null;
                } else {
                    str = this.bmk.field_imgPath;
                    f GH = com.tencent.mm.ae.n.GH();
                    bitmap = com.tencent.mm.sdk.platformtools.d.a(GH.x(str, true), com.tencent.mm.bd.a.getDensity(aa.getContext()), 0);
                }
                if (bitmap == null && this.imagePath != null) {
                    bitmap = com.tencent.mm.sdk.platformtools.d.JV(this.imagePath);
                }
                cVar.a(bitmap, 3);
                return;
            case 1:
                cVar.a(bJJ(), 2);
                return;
            case 2:
            case 10:
                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(this.blu));
                if (dV != null) {
                    String string;
                    str = dV.title;
                    if (dV.type == 5) {
                        string = getResources().getString(2131231171);
                    } else if (dV.type == 6) {
                        string = getResources().getString(2131231063);
                    } else if (dV.type == 24) {
                        String string2 = getResources().getString(2131231106);
                        b kwVar = new kw();
                        kwVar.bmf.type = 0;
                        kwVar.bmf.bmh = dV.coC;
                        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
                        str = be.ah(kwVar.bmg.bmp.desc, dV.description).replaceAll("\n", " ");
                        string = string2;
                    } else if (dV.type == 19) {
                        string = getResources().getString(2131231138);
                    } else if (dV.type == 3) {
                        string = getResources().getString(2131231095);
                    } else if (dV.type == 4) {
                        string = getResources().getString(2131231176);
                    } else if (dV.type == 8) {
                        string = getResources().getString(2131231033);
                    } else if (dV.type == 33) {
                        string = getResources().getString(2131230923);
                    } else {
                        string = getResources().getString(2131230904);
                    }
                    if (str == null) {
                        str = SQLiteDatabase.KeyEmpty;
                    }
                    cVar.Hw(new StringBuffer(string).append(str).toString());
                    if (dV.thumburl != null) {
                        cVar.Hx(dV.thumburl).bpi();
                        return;
                    }
                    return;
                } else if (this.oXG != null) {
                    str = getResources().getString(2131231176);
                    cVar.Hw(new StringBuffer(str).append(this.oXG).toString());
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.oXH != null) {
                    cVar.Hw(new StringBuffer(getResources().getString(2131231063)).append(this.oXH).toString());
                    return;
                }
                return;
            case 4:
                cVar.Hw(this.blu);
                cVar.bph();
                return;
            case 5:
                if (!be.kS(this.oXF)) {
                    cVar.Hy(this.oXF);
                    return;
                } else if (be.kS(this.bmk.field_imgPath)) {
                    cVar.Hy(this.imagePath);
                    return;
                } else {
                    cVar.Hy(this.bmk.field_imgPath);
                    return;
                }
            case 8:
                ak.yW();
                this.oXA = com.tencent.mm.model.c.wJ().MU(this.blu).lct;
                a(cVar, this.oXA);
                return;
            case 9:
                ak.yW();
                at.b MV = com.tencent.mm.model.c.wJ().MV(this.blu);
                str = SQLiteDatabase.KeyEmpty;
                if (MV != null) {
                    str = MV.label;
                }
                cVar.Hw(this.nDR.nEl.getString(2131231086) + str);
                return;
            case 11:
                cVar.a(bJJ(), 2);
                return;
            case 12:
                int size;
                kw eB = y.eB(this.nDR.nEl);
                if (eB.bmf.bml != null) {
                    size = eB.bmf.bml.size();
                } else {
                    size = 0;
                }
                cVar.Hw(new StringBuffer(getResources().getString(2131231092)).append(this.nDR.nEl.getString(2131234556, new Object[]{Integer.valueOf(size)})).toString());
                return;
            case 13:
                cVar.Hw(new StringBuffer(getResources().getString(2131231093)).append(t.ah(y.eB(this.nDR.nEl).bmg.bmo.title, SQLiteDatabase.KeyEmpty)).toString());
                return;
            default:
                return;
        }
    }

    private Bitmap bJJ() {
        com.tencent.mm.as.k.KV();
        String ld = o.ld(this.bmk.field_imgPath);
        if (ld == null) {
            ld = this.imagePath;
        }
        return com.tencent.mm.sdk.platformtools.d.JV(ld);
    }

    private void bJK() {
        v.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(2131230883));
        intent.putExtra("list_attr", r.oHO);
        intent.putExtra("already_select_contact", t.b(this.oXD, ","));
        intent.putExtra("max_limit_num", 9);
        this.nDR.nEl.startActivityForResult(intent, 5);
    }

    private void bJL() {
        v.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", r.oHL);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.oXA);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(2131230883));
        this.nDR.nEl.startActivityForResult(intent, 3);
    }

    private void bJM() {
        v.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(2131230883));
        if (this.fromScene == 4 && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", r.s(32, 16, 1, 2, 4, 16384));
        } else {
            intent.putExtra("list_attr", r.oHN);
        }
        this.nDR.nEl.startActivityForResult(intent, 1);
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return getString(2131234869);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.oXD.contains(aVar.euW.field_username);
    }

    public final void mf(String str) {
        this.oXD.remove(str);
        bHH().notifyDataSetChanged();
        NN();
    }

    private void NN() {
        if (!this.oXB) {
            return;
        }
        if (this.oXD != null && this.oXD.size() > 0) {
            aq(1, getString(2131231149) + "(" + this.oXD.size() + ")");
            a(this.oXJ);
            U(1, true);
        } else if (this.oXC) {
            aq(1, getString(2131231157));
            a(this.oXI);
            U(1, true);
        } else {
            aq(1, getString(2131231094));
            a(this.oXI);
            U(1, true);
        }
    }

    private boolean kl(boolean z) {
        if (!z ? this.oXD.size() > 9 : this.oXD.size() >= 9) {
            return false;
        }
        g.a(this.nDR.nEl, getString(2131234866, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), getString(2131231139), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ SelectConversationUI oXK;

            {
                this.oXK = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    protected final boolean bHK() {
        return true;
    }

    public final int[] ayD() {
        if (this.oXw) {
            return new int[]{131072, 131075, 131076};
        }
        if (this.fromScene != 4) {
            return super.ayD();
        }
        return new int[]{131072};
    }
}
