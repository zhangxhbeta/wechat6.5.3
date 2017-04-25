package com.tencent.mm.ui.friend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InviteFriendUI extends MMActivity implements a {
    private ImageView cHH;
    private String oNY;
    private int oNZ;
    private String oOa;
    private String oOb;
    private String oOc;
    private Button oOd;
    private int oOe;
    private int oOf;
    private String oOg = null;
    private String ofd = null;

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        if (inviteFriendUI.oOe > 0 && inviteFriendUI.oOf > 0) {
            g.iuh.h(10991, Integer.valueOf(inviteFriendUI.oOe), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.oOf));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233310);
        Intent intent = getIntent();
        this.oNZ = intent.getIntExtra("friend_type", -1);
        this.oOa = intent.getStringExtra("friend_nick");
        this.oNY = intent.getStringExtra("friend_num");
        this.oOb = intent.getStringExtra("friend_googleID");
        this.oOc = intent.getStringExtra("friend_googleItemID");
        this.oNY = be.ma(this.oNY);
        this.ofd = intent.getStringExtra("friend_linkedInID");
        this.oOg = intent.getStringExtra("friend_linkedInPicUrl");
        NI();
        this.oOe = intent.getIntExtra("search_kvstat_scene", 0);
        this.oOf = intent.getIntExtra("search_kvstat_position", 0);
    }

    protected void onPause() {
        super.onPause();
        n.AX().e(this);
    }

    protected void onResume() {
        super.onResume();
        n.AX().d(this);
    }

    protected final int getLayoutId() {
        return 2130903807;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        Bitmap a;
        this.cHH = (ImageView) findViewById(2131756903);
        TextView textView = (TextView) findViewById(2131756904);
        TextView textView2 = (TextView) findViewById(2131757503);
        TextView textView3 = (TextView) findViewById(2131756905);
        this.oOd = (Button) findViewById(2131756906);
        Button button = (Button) findViewById(2131757505);
        textView.setText(this.oOa);
        textView3.setText(getString(2131233308, new Object[]{this.oOa}));
        if (this.oNZ == 1) {
            this.cHH.setBackgroundDrawable(com.tencent.mm.bd.a.a(this, 2131165453));
            textView2.setText(getString(2131231050) + this.oNY);
            String m = com.tencent.mm.a.g.m(this.oNY.getBytes());
            ak.yW();
            if (c.isSDCardAvailable()) {
                b iB = ah.FL().iB(m);
                if (iB != null) {
                    a = m.a(iB.EC(), this);
                } else {
                    a = null;
                }
            } else {
                a = n.AX().aM(aa.getContext());
            }
            if (a != null) {
                this.cHH.setImageBitmap(a);
            } else {
                this.cHH.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165453));
            }
        }
        if (this.oNZ == 0) {
            this.cHH.setBackgroundDrawable(com.tencent.mm.bd.a.a(this, 2131165458));
            textView2.setText(getString(2131231053) + this.oNY);
            long ba = (long) o.ba(this.oNY);
            a = null;
            if (ba != 0) {
                a = com.tencent.mm.u.b.P(ba);
            }
            if (a == null) {
                this.cHH.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165458));
            } else {
                this.cHH.setImageBitmap(a);
            }
            button.setVisibility(0);
        }
        if (this.oNZ == 2) {
            Bitmap gv;
            this.oOd.setText(2131233154);
            this.cHH.setBackgroundDrawable(com.tencent.mm.bd.a.a(this, 2130838082));
            textView2.setText(getString(2131231045) + this.oNY);
            ak.yW();
            if (c.isSDCardAvailable()) {
                gv = com.tencent.mm.u.b.gv(this.oOb);
            } else {
                gv = n.AX().aM(aa.getContext());
            }
            if (gv != null) {
                this.cHH.setImageBitmap(gv);
            } else {
                this.cHH.setImageDrawable(com.tencent.mm.bd.a.a(this, 2130838082));
            }
            if (TextUtils.isEmpty(this.oOa)) {
                textView.setText(be.KU(this.oNY));
                textView3.setText(getString(2131233308, new Object[]{be.KU(this.oNY)}));
            }
        }
        if (this.oNZ == 3) {
            this.oOd.setText(2131233307);
            Bitmap a2 = j.a(new d(this.oOg, this.oOg, 0, 0));
            if (a2 != null) {
                this.cHH.setImageBitmap(a2);
            } else {
                this.cHH.setImageResource(2131165440);
            }
            button.setVisibility(8);
        }
        this.oOd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteFriendUI oOh;

            {
                this.oOh = r1;
            }

            public final void onClick(View view) {
                String str;
                final String string;
                switch (this.oOh.oNZ) {
                    case 0:
                        new g(this.oOh, new g.a(this) {
                            final /* synthetic */ AnonymousClass1 oOk;

                            {
                                this.oOk = r1;
                            }

                            public final void j(boolean z, String str) {
                                if (z) {
                                    this.oOk.oOh.finish();
                                }
                            }
                        }).t(new int[]{o.ba(this.oOh.oNY)});
                        return;
                    case 1:
                        ak.yW();
                        str = (String) c.vf().get(42, SQLiteDatabase.KeyEmpty);
                        if (str == null || str.length() == 0) {
                            ak.yW();
                            str = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
                        }
                        string = this.oOh.getString(2131233326, new Object[]{str});
                        final Uri parse = Uri.parse("smsto:" + this.oOh.oNY);
                        Intent intent = new Intent("android.intent.action.SENDTO", parse);
                        intent.putExtra("sms_body", string);
                        final PackageManager packageManager = this.oOh.getPackageManager();
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                        final HashMap hashMap = new HashMap();
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                                hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                            }
                        }
                        if (hashMap.size() == 1) {
                            Iterator it = hashMap.keySet().iterator();
                            if (it.hasNext()) {
                                str = (String) it.next();
                                Intent intent2 = new Intent();
                                intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                intent2.setAction("android.intent.action.SENDTO");
                                intent2.setData(parse);
                                intent2.putExtra("sms_body", string);
                                this.oOh.startActivity(intent2);
                                InviteFriendUI.c(this.oOh);
                                return;
                            }
                            return;
                        } else if (hashMap.size() > 1) {
                            l lVar = new l(this.oOh);
                            lVar.oTB = new com.tencent.mm.ui.base.n.a(this) {
                                final /* synthetic */ AnonymousClass1 oOk;

                                public final void a(ImageView imageView, MenuItem menuItem) {
                                    imageView.setImageDrawable(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadIcon(packageManager));
                                }
                            };
                            lVar.oTC = new com.tencent.mm.ui.base.n.b(this) {
                                final /* synthetic */ AnonymousClass1 oOk;

                                public final void a(TextView textView, MenuItem menuItem) {
                                    textView.setText(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadLabel(packageManager).toString());
                                }
                            };
                            lVar.jXn = new com.tencent.mm.ui.base.n.c(this) {
                                final /* synthetic */ AnonymousClass1 oOk;

                                public final void a(com.tencent.mm.ui.base.l lVar) {
                                    for (CharSequence add : hashMap.keySet()) {
                                        lVar.add(add);
                                    }
                                }
                            };
                            lVar.jXo = new com.tencent.mm.ui.base.n.d(this) {
                                final /* synthetic */ AnonymousClass1 oOk;

                                public final void c(MenuItem menuItem, int i) {
                                    String str = menuItem.getTitle();
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                    intent.setAction("android.intent.action.SENDTO");
                                    intent.setData(parse);
                                    intent.putExtra("sms_body", string);
                                    this.oOk.oOh.startActivity(intent);
                                }
                            };
                            lVar.aXZ();
                            InviteFriendUI.c(this.oOh);
                            return;
                        } else {
                            Toast.makeText(this.oOh, 2131234877, 1).show();
                            return;
                        }
                    case 2:
                        e hVar = new h(this.oOh, new h.a(this) {
                            final /* synthetic */ AnonymousClass1 oOk;

                            {
                                this.oOk = r1;
                            }

                            public final void kb(boolean z) {
                                if (z) {
                                    ah.FT().t(this.oOk.oOh.oOc, 1);
                                }
                            }
                        });
                        String e = this.oOh.oOb;
                        string = this.oOh.oNY;
                        ak.vy().a(489, hVar);
                        Cursor iJ = ah.FT().iJ(e);
                        if (iJ == null || iJ.getCount() <= 1) {
                            hVar.Pu(string);
                        } else {
                            hVar.h(iJ);
                        }
                        if (iJ != null) {
                            iJ.close();
                            return;
                        }
                        return;
                    case 3:
                        Intent intent3 = new Intent();
                        intent3.putExtra("intent.key.linkedin.id", this.oOh.ofd);
                        ak.yW();
                        Object obj = c.vf().get(286722, null);
                        str = k.xH();
                        String str2 = "intent.key.linkedin.from.name";
                        if (obj != null) {
                            str = obj.toString();
                        }
                        intent3.putExtra(str2, str);
                        com.tencent.mm.ay.c.b(this.oOh, "accountsync", "com.tencent.mm.ui.bindlinkedin.InviteLinkedInFriendUI", intent3);
                        this.oOh.finish();
                        return;
                    default:
                        return;
                }
            }
        });
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteFriendUI oOh;

            {
                this.oOh = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.c.b keVar = new ke();
                keVar.bla.opType = 0;
                keVar.bla.blc = this.oOh.oNY + "@qqim";
                keVar.bla.bld = this.oOh.oOa;
                com.tencent.mm.sdk.c.a.nhr.z(keVar);
                if (keVar.blb.aYN) {
                    com.tencent.mm.plugin.a.a.drp.e(new Intent().putExtra("Chat_User", this.oOh.oNY + "@qqim"), this.oOh);
                }
                this.oOh.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFriendUI oOh;

            {
                this.oOh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oOh.finish();
                return true;
            }
        });
    }

    public final void gM(String str) {
        if (this.oNY != null && !this.oNY.equals(SQLiteDatabase.KeyEmpty)) {
            long gA = com.tencent.mm.u.b.gA(str);
            if (gA > 0 && this.oNY.equals(String.valueOf(gA)) && this.oNZ == 0) {
                this.cHH.setImageBitmap(com.tencent.mm.u.b.a(str, false, -1));
            }
        }
    }
}
