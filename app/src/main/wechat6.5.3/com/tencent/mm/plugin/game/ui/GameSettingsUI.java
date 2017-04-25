package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.d.u;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.s;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Map;

public class GameSettingsUI extends MMActivity implements s, e {
    private String appId;
    private ProgressDialog dwR = null;
    private int gjl = 0;
    private ImageView goy;
    private TextView goz;
    private f gpF;
    private TextView gyf;
    private TextView gyg;
    private CheckBox gyh;
    private View gyi;
    private View gyj;
    private CheckBox gyk;
    private AuthorizationInfoLayout gyl;
    private ArrayList<String> gym;
    private boolean gyn;

    static /* synthetic */ void a(GameSettingsUI gameSettingsUI, boolean z) {
        gameSettingsUI.f(new w(2, z ? new ai(gameSettingsUI.appId, 0, "1") : new ai(gameSettingsUI.appId, 0, "0")));
    }

    static /* synthetic */ void b(GameSettingsUI gameSettingsUI, boolean z) {
        int i = 0;
        if (!z) {
            i = 1;
        }
        gameSettingsUI.gyn = z;
        gameSettingsUI.f(new com.tencent.mm.plugin.game.c.ai(gameSettingsUI.appId, 1, i));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjl = getIntent().getIntExtra("game_report_from_scene", 0);
        au.ash().a(2, this);
        ak.vy().a(1221, this);
        this.appId = getIntent().getStringExtra("game_app_id");
        if (be.kS(this.appId)) {
            v.f("MicroMsg.GameSettingsUI", "appid is null or nill");
        } else {
            this.gpF = g.aC(this.appId, true);
        }
        NI();
        f(new com.tencent.mm.plugin.game.c.ai(this.appId));
    }

    protected final int getLayoutId() {
        return 2130903138;
    }

    protected void onDestroy() {
        super.onDestroy();
        au.ash().b(2, this);
        ak.vy().b(1221, this);
    }

    protected final void NI() {
        int i = 0;
        this.goy = (ImageView) findViewById(2131755481);
        this.goz = (TextView) findViewById(2131755483);
        this.gyf = (TextView) findViewById(2131755484);
        this.gyl = (AuthorizationInfoLayout) findViewById(2131755489);
        if (this.gpF != null) {
            Bitmap b = g.b(this.gpF.field_appId, 1, a.getDensity(this));
            if (b == null) {
                this.goy.setImageResource(2130837663);
            } else {
                this.goy.setImageBitmap(d.a(b, true, 5.0f));
            }
            if (!be.kS(this.gpF.field_appName)) {
                this.goz.setText(g.a(this, this.gpF, null));
            }
            if (!be.kS(this.gpF.bxn)) {
                this.gyf.setText(this.gpF.bxn);
            }
            String str = this.gpF.bxm;
            if (!be.kS(str)) {
                Map q = bf.q(str, "ScopeList");
                if (q != null && q.size() > 0) {
                    int i2 = be.getInt((String) q.get(".ScopeList.Count"), 0);
                    if (i2 > 0) {
                        this.gym = new ArrayList();
                        while (i < i2) {
                            Object obj;
                            StringBuilder stringBuilder = new StringBuilder(".ScopeList.List.item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            String stringBuilder2 = stringBuilder.append(obj).append(".Scope").toString();
                            if (!be.kS((String) q.get(stringBuilder2))) {
                                this.gym.add(q.get(stringBuilder2));
                            }
                            i++;
                        }
                    } else {
                        v.d("MicroMsg.GameSettingsUI", "auth info is null :" + this.gpF.field_appName + ", " + this.appId);
                    }
                }
                if (this.gym == null || this.gym.size() <= 0) {
                    v.d("MicroMsg.GameSettingsUI", "this game's authinfo is null " + this.appId);
                    this.gyl.setVisibility(8);
                } else {
                    this.gyl.E(this.gym);
                }
            }
        }
        this.gyg = (TextView) findViewById(2131755490);
        this.gyg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameSettingsUI gyo;

            {
                this.gyo = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.g.a(this.gyo, 2131233077, 2131233076, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 gyp;

                    {
                        this.gyp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.gyp.gyo.f(new w(2, new ai(this.gyp.gyo.appId, 1, null)));
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 gyp;

                    {
                        this.gyp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.gyh = (CheckBox) findViewById(2131755486);
        this.gyh.setChecked(g.Gv(this.appId));
        this.gyi = findViewById(2131755485);
        this.gyi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameSettingsUI gyo;

            {
                this.gyo = r1;
            }

            public final void onClick(View view) {
                if (this.gyo.gyh.isChecked()) {
                    this.gyo.gyh.setChecked(false);
                    GameSettingsUI.a(this.gyo, false);
                    return;
                }
                this.gyo.gyh.setChecked(true);
                GameSettingsUI.a(this.gyo, true);
            }
        });
        this.gyk = (CheckBox) findViewById(2131755488);
        this.gyj = findViewById(2131755487);
        this.gyj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameSettingsUI gyo;

            {
                this.gyo = r1;
            }

            public final void onClick(View view) {
                if (this.gyo.gyk.isChecked()) {
                    this.gyo.gyk.setChecked(false);
                    GameSettingsUI.b(this.gyo, false);
                    return;
                }
                this.gyo.gyk.setChecked(true);
                GameSettingsUI.b(this.gyo, true);
            }
        });
        vD(2131233132);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameSettingsUI gyo;

            {
                this.gyo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gyo.setResult(0);
                this.gyo.finish();
                return true;
            }
        });
    }

    private void f(final k kVar) {
        ak.vy().a(kVar, 0);
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ GameSettingsUI gyo;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(kVar);
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.v vVar) {
        if (!bH(i, i2)) {
            ai aiVar = (ai) vVar;
            if (aiVar.cmdId == 0) {
                boolean Gv = g.Gv(this.appId);
                if (this.gyh != null) {
                    this.gyh.setChecked(Gv);
                }
                if (Gv) {
                    af.a(this.nDR.nEl, 10, 1008, AuthorizedGameListUI.goI, 20, 1, this.appId, this.gjl, 0, null, null, null);
                } else {
                    af.a(this.nDR.nEl, 10, 1008, AuthorizedGameListUI.goI, 21, 1, this.appId, this.gjl, 0, null, null, null);
                }
            } else if (aiVar.cmdId == 1) {
                v.i("MicroMsg.GameSettingsUI", "relieve app authorization ok");
                Intent intent = new Intent();
                intent.putExtra("game_app_id", this.appId);
                setResult(-1, intent);
                finish();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!bH(i, i2)) {
            switch (kVar.getType()) {
                case 1221:
                    int i3 = ((u) ((com.tencent.mm.plugin.game.c.ai) kVar).fut.czk.czs).glu;
                    com.tencent.mm.plugin.game.d.v vVar = (com.tencent.mm.plugin.game.d.v) ((com.tencent.mm.plugin.game.c.ai) kVar).fut.czl.czs;
                    Object obj = (vVar == null || (vVar.glv & 1) <= 0) ? null : 1;
                    switch (i3) {
                        case 0:
                            this.gyk.setChecked(obj == null);
                            return;
                        case 1:
                            af.a(this.nDR.nEl, 10, 1008, AuthorizedGameListUI.goJ, this.gyn ? 20 : 21, 1, this.appId, this.gjl, 0, null, null, null);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    private boolean bH(int i, int i2) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        Toast.makeText(this, getString(2131233092, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
