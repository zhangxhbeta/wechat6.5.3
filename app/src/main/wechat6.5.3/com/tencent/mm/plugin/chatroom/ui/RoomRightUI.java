package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.pluginsdk.ui.applet.j.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI extends MMPreference implements e {
    private ProgressDialog dwR = null;
    private f dxf;
    private String eRw = "";
    private int eRx = 0;

    static /* synthetic */ void a(RoomRightUI roomRightUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new j(roomRightUI, new a(roomRightUI) {
            final /* synthetic */ RoomRightUI eRy;

            {
                this.eRy = r1;
            }

            public final void cr(boolean z) {
            }
        }).f(linkedList, linkedList2);
    }

    public final int Oo() {
        return 2131099710;
    }

    private void adw() {
        ak.yW();
        int a = be.a((Integer) c.vf().get(135175, null), 0);
        Preference Ow = this.dxf.Ow("settings_room_size");
        if (Ow != null && a > 0) {
            Ow.setSummary(getResources().getQuantityString(2131361817, a, new Object[]{Integer.valueOf(a)}));
            Ow.setEnabled(false);
        } else if (Ow != null) {
            this.dxf.b(Ow);
        }
        this.dxf.Ow("room_right_max_tip").setTitle(getString(2131234648, new Object[]{Integer.valueOf(a)}));
        ak.yW();
        int a2 = be.a((Integer) c.vf().get(135176, null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.dxf.Ow("settings_room_grant");
        if (roomGrantPreference != null && a2 <= 0) {
            this.dxf.b(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            CharSequence charSequence = getString(2131234651, new Object[]{Integer.valueOf(a2)});
            roomGrantPreference.eRq = charSequence;
            if (roomGrantPreference.eRp != null) {
                roomGrantPreference.eRp.setText(charSequence);
            }
        }
        Preference Ow2 = this.dxf.Ow("room_right_tip");
        Preference Ow3 = this.dxf.Ow("room_right_grant_tip");
        if (a2 <= 0) {
            if (Ow2 != null) {
                this.dxf.b(Ow2);
            }
            if (Ow3 != null) {
                this.dxf.b(Ow3);
            }
            Preference Ow4 = this.dxf.Ow("room_grant_to_friend");
            if (Ow4 != null) {
                this.dxf.b(Ow4);
            }
            if (roomGrantPreference != null) {
                this.dxf.b(roomGrantPreference);
                return;
            }
            return;
        }
        CharSequence string = getString(2131234652, new Object[]{Integer.valueOf(a2), Integer.valueOf(a)});
        if (Ow2 != null) {
            Ow2.setTitle(string);
        }
        string = getString(2131234645, new Object[]{Integer.valueOf(this.eRx)});
        if (Ow3 != null) {
            Ow3.setTitle(string);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        this.eRx = be.a((Integer) c.vf().get(135177, null), 0);
        ak.vy().a(339, this);
        ak.vy().a(30, this);
        ak.yW();
        c.vf().set(135184, Boolean.valueOf(false));
        NI();
    }

    public void onResume() {
        super.onResume();
        adw();
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.dnU.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(aa.getPackageName(), aa.getPackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            List linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", be.b(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(339, this);
        ak.vy().b(30, this);
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        vD(2131235131);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomRightUI eRy;

            {
                this.eRy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eRy.axg();
                this.eRy.finish();
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 1:
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    v.d("MicroMsg.RoomRightUI", "pick user %s", new Object[]{stringExtra});
                    if (!be.kS(stringExtra)) {
                        this.eRw = stringExtra;
                        stringExtra = this.eRw;
                        ak.yW();
                        g.a(this.nDR.nEl, getString(2131234599, new Object[]{c.wH().LX(stringExtra).tU(), Integer.valueOf(this.eRx)}), "", new OnClickListener(this) {
                            final /* synthetic */ RoomRightUI eRy;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final com.tencent.mm.plugin.chatroom.c.j jVar = new com.tencent.mm.plugin.chatroom.c.j(stringExtra);
                                RoomRightUI roomRightUI = this.eRy;
                                RoomRightUI roomRightUI2 = this.eRy;
                                this.eRy.getString(2131231164);
                                roomRightUI.dwR = g.a(roomRightUI2, "", true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 eRB;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(jVar);
                                    }
                                });
                                ak.vy().a(jVar, 0);
                            }
                        }, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void A(final LinkedList<String> linkedList) {
        boolean z;
        if (linkedList.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String string = aa.getContext().getString(2131231758);
        linkedList.size();
        Object[] objArr = new Object[1];
        List linkedList2 = new LinkedList();
        if (ak.uz() && linkedList != null) {
            for (String er : linkedList) {
                linkedList2.add(l.er(er));
            }
        }
        objArr[0] = be.b(linkedList2, string);
        g.a(this, getString(2131234649, objArr), getString(2131231164), new OnClickListener(this) {
            final /* synthetic */ RoomRightUI eRy;

            public final void onClick(DialogInterface dialogInterface, int i) {
                RoomRightUI.a(this.eRy, linkedList);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        if (kVar.getType() == 339) {
            String str2;
            ak.yW();
            u LX = c.wH().LX(this.eRw);
            if (LX == null || ((int) LX.chr) == 0) {
                str2 = this.eRw;
            } else {
                str2 = LX.tU();
            }
            if (i == 0 && i2 == 0) {
                g.A(this, getString(2131234602, new Object[]{str2}), getString(2131231164));
                if (this.dxf != null) {
                    adw();
                    this.dxf.notifyDataSetChanged();
                }
            } else if (i2 == -251) {
                g.A(this, getString(2131234600, new Object[]{str2, Integer.valueOf(this.eRx)}), getString(2131231164));
            } else if (i2 == -44) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.eRw);
                A(linkedList);
            } else if (i2 == -22) {
                g.A(this, getString(2131234601, new Object[]{str2}), getString(2131231164));
            } else {
                Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
            }
        }
    }
}
