package com.tencent.mm.ui.voicesearch;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI extends MMActivity {
    int aXx = 1;
    private int cTZ = 2;
    private int fIn = -1;
    private ListView oYD;
    private String oYF = null;
    private TextView oYG;
    private b oYR;
    private String[] oYS;
    private boolean oYT = false;
    boolean oYU = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.oYT = false;
    }

    protected final void NI() {
        this.oYD = (ListView) findViewById(2131759674);
        this.oYG = (TextView) findViewById(2131755318);
        this.oYS = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.oYF = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.fIn = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.aXx = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.cTZ = this.aXx == 1 ? 2 : 1;
        this.oYU = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        v.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", Integer.valueOf(this.aXx), Boolean.valueOf(this.oYU));
        this.oYR = new b(getApplicationContext(), this.aXx);
        this.oYR.ko(false);
        List linkedList = new LinkedList();
        switch (this.aXx) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                int xQ = k.xQ();
                if ((xQ & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!(m.yt() && (xQ & 2) == 0)) {
                    linkedList.add("tmessage");
                }
                if ((xQ & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((xQ & FileUtils.S_IWUSR) != 0) {
                    linkedList.add("qqsync");
                }
                if ((xQ & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((524288 & xQ) != 0) {
                    linkedList.add("newsapp");
                }
                if (!((262144 & xQ) == 0 && m.ys())) {
                    linkedList.add("blogapp");
                }
                if ((65536 & xQ) != 0) {
                    linkedList.add("masssendapp");
                }
                if ((xQ & 33554432) != 0) {
                    linkedList.add("voiceinputapp");
                    break;
                }
                break;
        }
        if (this.oYR != null) {
            this.oYR.cB(linkedList);
        }
        this.oYD.setAdapter(this.oYR);
        this.oYG.setVisibility(8);
        v.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.fIn);
        if (this.aXx == 2) {
            Fd(SQLiteDatabase.KeyEmpty);
            this.oYS = G(this.oYS);
        } else {
            Fd(getString(2131235837));
        }
        Fd(getString(2131235837));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoiceSearchResultUI oYV;

            {
                this.oYV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.oYV.oYT) {
                    g.iuh.Y(10452, this.oYV.cTZ + "," + this.oYV.fIn + "," + (this.oYV.oYS == null ? 0 : this.oYV.oYS.length) + ",0");
                }
                if (this.oYV.oYU) {
                    this.oYV.moveTaskToBack(true);
                }
                this.oYV.finish();
                return true;
            }
        });
        this.oYD.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ VoiceSearchResultUI oYV;

            {
                this.oYV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!this.oYV.oYT) {
                    g.iuh.Y(10452, this.oYV.cTZ + "," + this.oYV.fIn + "," + (this.oYV.oYS == null ? 0 : this.oYV.oYS.length) + "," + i);
                }
                ab js = this.oYV.oYR.js(i);
                Context context = this.oYV;
                String str = js.field_username;
                String tU = js.tU();
                if (str != null && str.length() > 0) {
                    v.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + str);
                    Intent intent;
                    if (context.aXx == 3) {
                        intent = new Intent();
                        intent.putExtra("Select_Conv_User", str);
                        context.setResult(-1, intent);
                        context.finish();
                    } else if (context.aXx != 1 && !m.fo(str) && !m.eD(str) && !m.dE(str) && !m.eA(str) && !VoiceSearchResultUI.PK(tU)) {
                        Intent intent2 = new Intent(context, SearchConversationResultUI.class);
                        intent2.putExtra("SearchConversationResult_User", tU);
                        context.startActivity(intent2);
                    } else if (context.aXx == 1) {
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (m.eA(str)) {
                            intent.putExtra("Is_group_card", true);
                        }
                        if (str != null && str.length() > 0) {
                            e.a(intent, str);
                            if (context.oYU) {
                                context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                                context.finish();
                                return;
                            }
                            c.b(context, "profile", ".ui.ContactInfoUI", intent);
                        }
                    } else if (context.aXx != 2) {
                    } else {
                        if (be.kS(str)) {
                            v.e("MicroMsg.VoiceSearchResultUI", "username is null " + str);
                        } else if (m.eI(str)) {
                            if (k.xZ()) {
                                c.b(context.nDR.nEl, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (m.eK(str)) {
                            if (k.xW()) {
                                c.b(context.nDR.nEl, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (m.eJ(str)) {
                            c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (m.eO(str)) {
                            MMAppMgr.cancelNotification(str);
                            c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (m.eG(str)) {
                            if (k.yi()) {
                                context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (m.eT(str)) {
                            if (k.yd()) {
                                intent = new Intent();
                                intent.putExtra("type", 20);
                                c.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                                return;
                            }
                            c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (m.fb(str)) {
                            if (k.ye()) {
                                intent = new Intent();
                                intent.putExtra("type", 11);
                                c.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                                return;
                            }
                            c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (m.eL(str)) {
                            c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (m.eM(str)) {
                            if (k.yg()) {
                                c.b(context, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (m.eS(str)) {
                            if (k.ya()) {
                                context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (m.eQ(str) || m.eR(str) || m.eN(str) || m.eU(str) || m.eV(str) || m.eH(str) || m.fe(str)) {
                            c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else {
                            context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        }
                    }
                }
            }
        });
        H(this.oYS);
    }

    private static String[] G(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        v.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (String str : strArr) {
            String er = l.er(str);
            v.d("MicroMsg.VoiceSearchResultUI", "displayname " + er);
            if (!hashMap.containsValue(er) || !m.dE(str)) {
                v.d("MicroMsg.VoiceSearchResultUI", "username " + str);
                hashMap.put(er, str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.oYR.avc();
    }

    public void onPause() {
        super.onPause();
        this.oYT = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (!this.oYT) {
                g.iuh.Y(10452, this.cTZ + "," + this.fIn + "," + (this.oYS == null ? 0 : this.oYS.length) + ",0");
            }
            if (this.oYU) {
                moveTaskToBack(true);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    static boolean PK(String str) {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = ak.yW().cqW.a(m.crA, null, str);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                v.d("MicroMsg.VoiceSearchResultUI", "block user " + string);
            } catch (Throwable e) {
                v.a("MicroMsg.VoiceSearchResultUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        cursorArr[1] = ak.yW().cqX.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        v.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            return true;
        }
        return false;
    }

    private void H(String[] strArr) {
        List arrayList = new ArrayList();
        if (!(strArr == null || this.oYR == null)) {
            for (String str : strArr) {
                if (this.oYR.PJ(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.oYG.setVisibility(0);
            if (this.oYF != null) {
                this.oYG.setText(this.oYF);
            } else {
                this.oYG.setText(getString(2131230850));
            }
        } else {
            this.oYG.setVisibility(8);
        }
        if (this.oYR != null) {
            this.oYR.cI(arrayList);
        }
    }

    protected final int getLayoutId() {
        return 2130904590;
    }
}
