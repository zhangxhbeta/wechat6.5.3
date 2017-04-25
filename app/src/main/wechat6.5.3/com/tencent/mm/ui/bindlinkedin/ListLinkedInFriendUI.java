package com.tencent.mm.ui.bindlinkedin;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.ag.d;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindlinkedin.a.a;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public class ListLinkedInFriendUI extends MMActivity implements a, e {
    private boolean cQo = false;
    private int cQp = 0;
    private ListView eyT = null;
    private Dialog gpw = null;
    private a ofp = null;
    private boolean ofq = false;
    private boolean ofr = false;
    private com.tencent.mm.ag.a ofs;
    private int scene = 0;

    static /* synthetic */ void a(ListLinkedInFriendUI listLinkedInFriendUI, s sVar) {
        if (sVar != null) {
            String str = sVar.field_wechatUsername;
            v.d("MicroMsg.LinkedInFriendUI", "[oneliang][goToProfile] username:%s", str);
            ak.yW();
            ab LX = c.wH().LX(str);
            if ((LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) && be.kS(sVar.field_wechatUsername)) {
                Intent intent = new Intent(listLinkedInFriendUI, InviteFriendUI.class);
                intent.putExtra("friend_type", 3);
                intent.putExtra("friend_nick", sVar.field_name);
                intent.putExtra("friend_linkedInID", sVar.field_linkedInId);
                intent.putExtra("friend_linkedInPicUrl", sVar.field_picUrl);
                intent.putExtra("friend_scene", 76);
                intent.putExtra("Contact_Scene", 76);
                listLinkedInFriendUI.startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Encryptusername", str);
                intent2.putExtra("Contact_Nick", sVar.field_nickname);
                intent2.putExtra("Contact_ShowFMessageList", true);
                intent2.putExtra("Contact_Source_FMessage", 76);
                intent2.putExtra("Contact_Scene", 76);
                intent2.putExtra("Contact_verify_Scene", 76);
                intent2.putExtra("KLinkedInAddFriendNickName", sVar.field_name);
                intent2.putExtra("KLinkedInAddFriendPubUrl", sVar.field_linkedInProfileUrl);
                intent2.putExtra("Contact_KSnsIFlag", 0);
                h hVar = new h();
                hVar.username = str;
                hVar.cyC = sVar.field_wechatSmallHead;
                hVar.cyD = sVar.field_wechatBigHead;
                hVar.aP(true);
                n.Bo().a(hVar);
                if (str != null && str.length() > 0) {
                    com.tencent.mm.plugin.a.a.drp.d(intent2, listLinkedInFriendUI.nDR.nEl);
                }
            }
            listLinkedInFriendUI.ofq = false;
        }
    }

    static /* synthetic */ void h(ListLinkedInFriendUI listLinkedInFriendUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", k.xF());
        intent.putExtra("geta8key_scene", 17);
        com.tencent.mm.ay.c.b(listLinkedInFriendUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232776);
        NI();
        this.ofs = new com.tencent.mm.ag.a(this.scene, this);
    }

    protected final void NI() {
        this.eyT = (ListView) findViewById(2131757696);
        this.scene = getIntent().getIntExtra("KScene", 0);
        this.ofp = new a(this, k.xF());
        this.ofp.ofj = this;
        this.eyT.setAdapter(this.ofp);
        this.eyT.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ListLinkedInFriendUI oft;

            {
                this.oft = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i + i2 >= i3 && !this.oft.ofr) {
                    this.oft.ofr = true;
                    v.d("MicroMsg.LinkedInFriendUI", "[oneliang][onScroll] want to pull data.");
                    if (this.oft.cQo) {
                        v.d("MicroMsg.LinkedInFriendUI", "[oneliang][onScroll] has more data.");
                        this.oft.ofq = true;
                        this.oft.bDl();
                    }
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ListLinkedInFriendUI oft;

            {
                this.oft = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oft.finish();
                return true;
            }
        });
        this.eyT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ListLinkedInFriendUI oft;

            {
                this.oft = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.d("MicroMsg.LinkedInFriendUI", "onItemClick position:%d,", Integer.valueOf(i));
                if (this.oft.ofp != null) {
                    ListLinkedInFriendUI.a(this.oft, (s) this.oft.ofp.getItem(i - this.oft.eyT.getHeaderViewsCount()));
                }
            }
        });
        this.ofq = true;
    }

    protected void onResume() {
        super.onResume();
        if (this.ofp != null) {
            this.ofp.Ol();
        }
        bDl();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.ofp.ipD.destory();
        ak.vy().b(676, this.ofs);
    }

    private void bDl() {
        boolean z = true;
        if (this.ofq) {
            com.tencent.mm.ag.a aVar = this.ofs;
            v.i("MicroMsg.LinkedInFriendDataMgr", "getNextPage, status:%d, hasNext:%b, uiWaiting:%b, nextPos:%d", Integer.valueOf(aVar.status), Boolean.valueOf(aVar.cQo), Boolean.valueOf(aVar.cQr), Integer.valueOf(aVar.cQp));
            if (aVar.status == com.tencent.mm.ag.a.cQs && aVar.cQo) {
                aVar.cQq = new d(aVar.scene, aVar.cQp);
                ak.vy().a(aVar.cQq, 0);
                aVar.cQr = true;
            } else if (aVar.status == com.tencent.mm.ag.a.cQt) {
                aVar.cQr = true;
            } else if (aVar.status == com.tencent.mm.ag.a.cQu) {
                ak.vA();
                ad.o(new Runnable(aVar) {
                    final /* synthetic */ a cQz;

                    {
                        this.cQz = r1;
                    }

                    public final void run() {
                        this.cQz.cAR.a(this.cQz.cQv, this.cQz.cQw, this.cQz.cQx, this.cQz.cQy);
                        this.cQz.cQr = false;
                        this.cQz.Hf();
                    }
                });
            } else {
                z = false;
            }
            if (z) {
                this.gpw = g.a((Context) this, getString(2131233521), false, new OnCancelListener(this) {
                    final /* synthetic */ ListLinkedInFriendUI oft;

                    {
                        this.oft = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            }
            this.ofq = false;
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903858;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.LinkedInFriendUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent == null) {
            finish();
            return;
        }
        switch (i) {
            case 100:
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                String string = bundleExtra.getString("ret");
                String string2 = bundleExtra.getString("limid");
                String string3 = bundleExtra.getString("liname");
                String string4 = bundleExtra.getString("liurl");
                String string5 = bundleExtra.getString("liswitch");
                if (be.kS(string)) {
                    v.e("MicroMsg.LinkedInFriendUI", "linkedin oauth ret is null, maybe canceled");
                    return;
                }
                int KL = be.KL(string);
                if (KL != 0) {
                    v.e("MicroMsg.LinkedInFriendUI", "linkedin oauth bind failed ret %s ", Integer.valueOf(KL));
                    g.a((Context) this, getString(KL == 1 ? 2131232075 : 2131232074), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                        final /* synthetic */ ListLinkedInFriendUI oft;

                        {
                            this.oft = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                                this.oft.finish();
                            }
                        }
                    });
                    this.ofq = false;
                    return;
                }
                this.ofq = true;
                if (be.kS(string2)) {
                    v.e("MicroMsg.LinkedInFriendUI", "linkedin member id is null");
                    return;
                }
                v.d("MicroMsg.LinkedInFriendUI", "%s, %s, %s, %s", string2, string3, string4, string5);
                ak.yW();
                c.vf().set(286722, string3);
                ak.yW();
                c.vf().set(286721, string2);
                ak.yW();
                c.vf().set(286723, string4);
                return;
            default:
                v.e("MicroMsg.LinkedInFriendUI", "onActivityResult unknow request");
                return;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (!(i2 == 5 || this.gpw == null)) {
            this.gpw.dismiss();
            this.gpw = null;
        }
        this.ofr = false;
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.LinkedInFriendUI", "[oneliang][onSceneEnd]:ok");
            this.cQo = ((d) kVar).hasNext();
            this.cQp = ((d) kVar).Hg();
            if (this.ofp != null) {
                this.ofp.Ol();
            }
        } else if (i2 == 2) {
            this.gpw = g.a((Context) this, true, getString(2131233508), SQLiteDatabase.KeyEmpty, getString(2131233505), getString(2131233506), new OnClickListener(this) {
                final /* synthetic */ ListLinkedInFriendUI oft;

                {
                    this.oft = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ListLinkedInFriendUI.h(this.oft);
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.oft.ofq = true;
                }
            }, new OnClickListener(this) {
                final /* synthetic */ ListLinkedInFriendUI oft;

                {
                    this.oft = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.oft.finish();
                }
            });
        } else if (i2 == 5) {
            new ah(new ah.a(this) {
                final /* synthetic */ ListLinkedInFriendUI oft;

                {
                    this.oft = r1;
                }

                public final boolean oU() {
                    if (this.oft.gpw != null) {
                        this.oft.gpw.dismiss();
                        this.oft.gpw = null;
                    }
                    ListLinkedInFriendUI.h(this.oft);
                    this.oft.ofq = true;
                    return false;
                }
            }, false).ea(2000);
        } else {
            this.gpw = g.a((Context) this, true, getString(2131233507), SQLiteDatabase.KeyEmpty, getString(2131233509), getString(2131233506), new OnClickListener(this) {
                final /* synthetic */ ListLinkedInFriendUI oft;

                {
                    this.oft = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.oft.ofq = true;
                    this.oft.bDl();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ ListLinkedInFriendUI oft;

                {
                    this.oft = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public final void dk(int i, int i2) {
        if (this.ofp != null) {
            s sVar = (s) this.ofp.getItem(i);
            if (sVar != null) {
                String str = sVar.field_linkedInId;
                String str2 = sVar.field_name;
                switch (sVar.field_status) {
                    case 1:
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                            final /* synthetic */ ListLinkedInFriendUI oft;

                            {
                                this.oft = r1;
                            }

                            public final void a(boolean z, boolean z2, String str, String str2) {
                                v.d("MicroMsg.LinkedInFriendUI", "[oneliang]AddContact hasSentVerify:" + z2);
                                if (!be.kS(str2)) {
                                    if (z) {
                                        ak.yW();
                                        com.tencent.mm.i.a LX = c.wH().LX(str);
                                        if (((int) LX.chr) > 0) {
                                            m.n(LX);
                                        }
                                        com.tencent.mm.modelfriend.ah.FU().iL(str2);
                                        Toast.makeText(this.oft, 2131233510, 0).show();
                                    }
                                    this.oft.ofp.Ol();
                                }
                            }
                        });
                        aVar.lJl = true;
                        aVar.lJk = true;
                        aVar.lJm = str;
                        aVar.lJl = true;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(76));
                        aVar.b(sVar.field_wechatUsername, linkedList, true);
                        sVar.field_userOpStatus = 1;
                        com.tencent.mm.modelfriend.ah.FU().iL(str);
                        this.ofp.Ol();
                        return;
                    case 2:
                        if (i2 == 1) {
                            Intent intent = new Intent(this, InviteLinkedInFriendUI.class);
                            intent.putExtra("intent.key.linkedin.id", str);
                            ak.yW();
                            Object obj = c.vf().get(286722, null);
                            String xH = k.xH();
                            String str3 = "intent.key.linkedin.from.name";
                            if (obj != null) {
                                xH = obj.toString();
                            }
                            intent.putExtra(str3, xH);
                            intent.putExtra("intent.key.linkedin.to.name", be.ma(str2));
                            startActivity(intent);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
