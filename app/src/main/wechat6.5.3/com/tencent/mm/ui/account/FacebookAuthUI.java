package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.a.b;
import com.tencent.mm.ui.e.a.c;
import com.tencent.mm.ui.e.a.d;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements e {
    public static final String[] nIg = new String[]{"publish_actions", "email"};
    private f dxf;
    private final Map<String, Preference> euX = new HashMap();
    private c nHN;
    private ProgressDialog nHO;
    private OnCancelListener nHP;
    private g nHQ;
    private boolean nIh = false;
    private boolean nIi = false;

    private final class a implements com.tencent.mm.ui.e.a.c.a {
        final /* synthetic */ FacebookAuthUI nIj;

        private a(FacebookAuthUI facebookAuthUI) {
            this.nIj = facebookAuthUI;
        }

        public final void k(Bundle bundle) {
            v.d("MicroMsg.FacebookAuthUI", "token:" + this.nIj.nHN.oed);
            ak.yW();
            com.tencent.mm.model.c.vf().set(65830, this.nIj.nHN.oed);
            if (this.nIj.nHN.oNm != 0) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(65832, Long.valueOf(this.nIj.nHN.oNm));
            }
            this.nIj.nHO = ProgressDialog.show(this.nIj, this.nIj.getString(2131231164), this.nIj.getString(2131232607), true);
            this.nIj.nHO.setOnCancelListener(this.nIj.nHP);
            this.nIj.nHQ = new g(1, this.nIj.nHN.oed);
            ak.vy().a(this.nIj.nHQ, 0);
            FacebookAuthUI.jc(true);
        }

        public final void a(d dVar) {
            v.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + dVar.oNt);
            com.tencent.mm.ui.base.g.A(this.nIj, dVar.getMessage(), this.nIj.getString(2131232029));
            FacebookAuthUI.jc(false);
        }

        public final void a(b bVar) {
            v.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
            com.tencent.mm.ui.base.g.A(this.nIj, bVar.getMessage(), this.nIj.getString(2131232029));
            FacebookAuthUI.jc(false);
        }

        public final void onCancel() {
            v.d("MicroMsg.FacebookAuthUI", "onCancel");
            FacebookAuthUI.jc(false);
        }
    }

    static /* synthetic */ void jc(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ak.i.a(32, z ? "0" : "1"));
        ak.yW();
        com.tencent.mm.model.c.wG().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        NI();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(183, (e) this);
        ak.vy().a(254, (e) this);
        bAN();
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(183, (e) this);
        ak.vy().b(254, (e) this);
    }

    public final int Oo() {
        return 2131099693;
    }

    protected final void NI() {
        this.nIh = getIntent().getBooleanExtra("is_force_unbind", false);
        this.nHN = new c("290293790992170");
        this.nHP = new OnCancelListener(this) {
            final /* synthetic */ FacebookAuthUI nIj;

            {
                this.nIj = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.nIj.nHQ != null) {
                    ak.vy().c(this.nIj.nHQ);
                }
            }
        };
        this.dxf.addPreferencesFromResource(2131099693);
        Preference Ow = this.dxf.Ow("facebook_auth_tip");
        if (Ow != null) {
            this.euX.put("facebook_auth_tip", Ow);
        }
        Ow = this.dxf.Ow("facebook_auth_cat");
        if (Ow != null) {
            this.euX.put("facebook_auth_cat", Ow);
        }
        Ow = this.dxf.Ow("facebook_auth_bind_btn");
        if (Ow != null) {
            this.euX.put("facebook_auth_bind_btn", Ow);
        }
        Ow = this.dxf.Ow("facebook_auth_account");
        if (Ow != null) {
            this.euX.put("facebook_auth_account", Ow);
        }
        Ow = this.dxf.Ow("facebook_auth_cat2");
        if (Ow != null) {
            this.euX.put("facebook_auth_cat2", Ow);
        }
        Ow = this.dxf.Ow("facebook_auth_unbind_btn");
        if (Ow != null) {
            this.euX.put("facebook_auth_unbind_btn", Ow);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FacebookAuthUI nIj;

            {
                this.nIj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = this.nIj.getIntent();
                intent.putExtra("bind_facebook_succ", this.nIj.nIi);
                this.nIj.setResult(-1, intent);
                this.nIj.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str == null) {
            v.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            try {
                this.nHN.eI(this);
            } catch (Throwable e) {
                v.a("MicroMsg.FacebookAuthUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            this.nHN = new c("290293790992170");
            this.nHN.a((Activity) this, nIg, new a());
            return true;
        } else if (!str.equals("facebook_auth_unbind_btn")) {
            return false;
        } else {
            com.tencent.mm.ui.base.g.a((Context) this, 2131232611, 2131231164, new OnClickListener(this) {
                final /* synthetic */ FacebookAuthUI nIj;

                {
                    this.nIj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nIj.nHO = ProgressDialog.show(this.nIj, this.nIj.getString(2131231164), this.nIj.getString(2131232614), true);
                    this.nIj.nHO.setOnCancelListener(this.nIj.nHP);
                    ak.vy().a(new h(h.cYu), 0);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FacebookAuthUI nIj;

                {
                    this.nIj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    private void bAN() {
        this.dxf.removeAll();
        boolean yh = this.nIh ? false : k.yh();
        if (this.euX.containsKey("facebook_auth_tip")) {
            Preference preference = (Preference) this.euX.get("facebook_auth_tip");
            preference.setTitle(yh ? 2131232613 : 2131232606);
            this.dxf.a(preference);
        }
        if (this.euX.containsKey("facebook_auth_cat")) {
            this.dxf.a((Preference) this.euX.get("facebook_auth_cat"));
        }
        if (yh) {
            if (this.euX.containsKey("facebook_auth_account")) {
                preference = (Preference) this.euX.get("facebook_auth_account");
                StringBuilder append = new StringBuilder().append(getString(2131232608));
                ak.yW();
                preference.setTitle(append.append(com.tencent.mm.model.c.vf().get(65826, null)).toString());
                this.dxf.a(preference);
            }
            if (this.euX.containsKey("facebook_auth_cat2")) {
                this.dxf.a((Preference) this.euX.get("facebook_auth_cat2"));
            }
            if (this.euX.containsKey("facebook_auth_unbind_btn")) {
                this.dxf.a((Preference) this.euX.get("facebook_auth_unbind_btn"));
            }
        } else if (this.euX.containsKey("facebook_auth_bind_btn")) {
            this.dxf.a((Preference) this.euX.get("facebook_auth_bind_btn"));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        v.i(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(be.kS(stringExtra));
            objArr2[1] = Integer.valueOf(be.kS(stringExtra) ? 0 : stringExtra.length());
            objArr2[2] = Integer.valueOf(intExtra);
            v.i(str2, str3, objArr2);
            if (intExtra == -217) {
                try {
                    this.nHN.eI(this);
                } catch (Throwable e) {
                    v.a("MicroMsg.FacebookAuthUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                this.nHN = new c("290293790992170");
                this.nHN.a((Activity) this, nIg, new a());
                return;
            }
        }
        this.nHN.d(i, i2, intent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        com.tencent.mm.f.a dm;
        if (kVar.getType() == 254) {
            if (i == 0 && i2 == 0) {
                this.nHQ = new g(0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(this.nHQ, 0);
                return;
            }
            if (this.nHO != null) {
                this.nHO.dismiss();
            }
            if (i2 == -82) {
                com.tencent.mm.ui.base.g.a((Context) this, 2131234951, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI nIj;

                    {
                        this.nIj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -83) {
                com.tencent.mm.ui.base.g.a((Context) this, 2131234948, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI nIj;

                    {
                        this.nIj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -84) {
                com.tencent.mm.ui.base.g.a((Context) this, 2131234949, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI nIj;

                    {
                        this.nIj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -85) {
                com.tencent.mm.ui.base.g.a((Context) this, 2131234947, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI nIj;

                    {
                        this.nIj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -86) {
                com.tencent.mm.ui.base.g.a((Context) this, 2131234952, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI nIj;

                    {
                        this.nIj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -106) {
                l.D(this, str);
            } else if (i2 == -217) {
                l.a(this, ((s) kVar).Jg(), i2);
            } else {
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this, null, null);
                }
            }
        } else if (kVar.getType() == 183) {
            if (this.nHO != null) {
                this.nHO.dismiss();
            }
            int i3 = ((g) kVar).opType;
            if (i == 0 && i2 == 0) {
                Toast.makeText(this, i3 == 0 ? 2131232036 : 2131232030, 1).show();
                this.nIh = false;
                bAN();
                if (i3 == 1) {
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mf("facebookapp");
                    ak.yW();
                    com.tencent.mm.model.c.wJ().MO("facebookapp");
                    this.nIi = true;
                }
            } else if (i == 4 && i2 == -67) {
                Toast.makeText(this, 2131232609, 1).show();
            } else if (i == 4 && i2 == -5) {
                Toast.makeText(this, i3 == 1 ? 2131232604 : 2131232610, 1).show();
            } else if (i2 == -106) {
                l.D(this, str);
            } else {
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this, null, null);
                } else {
                    Toast.makeText(this, i3 == 0 ? 2131232035 : 2131232029, 1).show();
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.nIi);
            setResult(-1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
