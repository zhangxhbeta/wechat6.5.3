package com.tencent.mm.plugin.soter_mp.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.plugin.soter_mp.a.c;
import com.tencent.mm.plugin.soter_mp.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(7)
public class SoterAuthenticationUI extends MMActivity {
    public static a kem = null;
    private p dFI = null;
    private int fromScene = -1;
    private c kel = null;

    public static class a extends ac {
        private WeakReference<SoterAuthenticationUI> ken;

        static /* synthetic */ void a(a aVar) {
            if (aVar.ken != null) {
                aVar.ken.clear();
            }
        }

        private a(SoterAuthenticationUI soterAuthenticationUI) {
            this.ken = null;
            this.ken = new WeakReference(soterAuthenticationUI);
        }

        @TargetApi(23)
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            com.tencent.mm.plugin.soter_mp.b.c cVar;
            switch (message.what) {
                case 0:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
                    cVar = (com.tencent.mm.plugin.soter_mp.b.c) message.obj;
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.a((SoterAuthenticationUI) this.ken.get(), cVar);
                        return;
                    }
                case 1:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
                    cVar = (com.tencent.mm.plugin.soter_mp.b.c) message.obj;
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.b((SoterAuthenticationUI) this.ken.get(), cVar);
                        return;
                    }
                case 2:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
                    cVar = (com.tencent.mm.plugin.soter_mp.b.c) message.obj;
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        ((SoterAuthenticationUI) this.ken.get()).a(cVar);
                        return;
                    }
                case 3:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                    String[] stringArray = message.getData().getStringArray("permissions");
                    int i = message.getData().getInt("request_code");
                    if (stringArray == null || stringArray.length <= 1) {
                        v.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
                        return;
                    } else {
                        ((SoterAuthenticationUI) this.ken.get()).requestPermissions(stringArray, i);
                        return;
                    }
                case 4:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.a((SoterAuthenticationUI) this.ken.get());
                        return;
                    }
                case 5:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    } else {
                        SoterAuthenticationUI.b((SoterAuthenticationUI) this.ken.get());
                        return;
                    }
                case 6:
                    v.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
                    if (this.ken == null || this.ken.get() == null) {
                        v.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
                        return;
                    }
                    ((SoterAuthenticationUI) this.ken.get()).a((h) message.obj);
                    return;
                default:
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[]{Integer.valueOf(message.what)});
                    return;
            }
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.dFI == null || !soterAuthenticationUI.dFI.isShowing()) {
            soterAuthenticationUI.dFI = g.a(soterAuthenticationUI, soterAuthenticationUI.getString(2131231182), false, null);
        }
    }

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI, com.tencent.mm.plugin.soter_mp.b.c cVar) {
        soterAuthenticationUI.setResult(-1, b(cVar));
        soterAuthenticationUI.c(cVar);
        soterAuthenticationUI.finish();
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI) {
        if (soterAuthenticationUI.dFI != null && soterAuthenticationUI.dFI.isShowing()) {
            soterAuthenticationUI.dFI.dismiss();
        }
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, com.tencent.mm.plugin.soter_mp.b.c cVar) {
        cVar.errCode = 90008;
        cVar.biS = "user cancelled the authentication process";
        soterAuthenticationUI.setResult(0, b(cVar));
        soterAuthenticationUI.c(cVar);
        soterAuthenticationUI.finish();
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        if (kem != null) {
            a.a(kem);
        }
        kem = new a();
        b bVar = new b();
        com.tencent.mm.plugin.soter_mp.b.c cVar = new com.tencent.mm.plugin.soter_mp.b.c();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (be.kS(stringExtra)) {
            v.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            cVar.errCode = 90003;
            cVar.biS = "authen mode is null";
        } else {
            try {
                bVar.keh = Byte.parseByte(be.ah(stringExtra.substring(2), "00"), 16);
                bVar.fUl = getIntent().getStringExtra("challenge");
                bVar.content = getIntent().getStringExtra("auth_content");
                if (!k.aYJ()) {
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    cVar.errCode = 90001;
                    cVar.biS = "not support soter";
                } else if (bVar.keh <= (byte) 0) {
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    cVar.errCode = 90003;
                    cVar.biS = "resp model error";
                } else if (be.kS(bVar.fUl)) {
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    cVar.errCode = 90004;
                    cVar.biS = "challenge is null";
                } else if (bVar.fUl.length() >= 512) {
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    cVar.errCode = 90004;
                    cVar.biS = "challenge is too long. 512 chars at most";
                } else if (be.kS(bVar.content)) {
                    bVar.content = getString(2131236711);
                } else if (bVar.content.length() > 42) {
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    bVar.content = getString(2131236711);
                }
            } catch (NumberFormatException e) {
                v.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                cVar.errCode = 90003;
                cVar.biS = "authen mode is illegal: number format error. found: " + stringExtra;
                if (cVar.errCode != 0) {
                    i = com.tencent.mm.plugin.soter_mp.a.a.kdQ;
                    this.kel = com.tencent.mm.plugin.soter_mp.a.a.a(this, bVar, cVar);
                    if (this.kel == null) {
                        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                        this.kel.cW();
                    }
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    cVar.errCode = 90003;
                    cVar.biS = "no corresponding mode";
                    a(cVar);
                    return;
                }
                a(cVar);
                return;
            } catch (IndexOutOfBoundsException e2) {
                v.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                cVar.errCode = 90003;
                cVar.biS = "authen mode is illegal: number format error. found: " + stringExtra;
                if (cVar.errCode != 0) {
                    a(cVar);
                    return;
                }
                i = com.tencent.mm.plugin.soter_mp.a.a.kdQ;
                this.kel = com.tencent.mm.plugin.soter_mp.a.a.a(this, bVar, cVar);
                if (this.kel == null) {
                    v.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    cVar.errCode = 90003;
                    cVar.biS = "no corresponding mode";
                    a(cVar);
                    return;
                }
                this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                this.kel.cW();
            }
        }
        if (cVar.errCode != 0) {
            a(cVar);
            return;
        }
        i = com.tencent.mm.plugin.soter_mp.a.a.kdQ;
        this.kel = com.tencent.mm.plugin.soter_mp.a.a.a(this, bVar, cVar);
        if (this.kel == null) {
            v.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            cVar.errCode = 90003;
            cVar.biS = "no corresponding mode";
            a(cVar);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        this.kel.cW();
    }

    protected void onResume() {
        super.onResume();
        if (this.kel != null) {
            this.kel.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kel != null) {
            this.kel.onPause();
        }
    }

    private void a(com.tencent.mm.plugin.soter_mp.b.c cVar) {
        setResult(1, b(cVar));
        c(cVar);
        finish();
    }

    private static Intent b(com.tencent.mm.plugin.soter_mp.b.c cVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", cVar.errCode);
        bundle.putString("err_msg", cVar.biS);
        bundle.putByte("use_mode", cVar.kei);
        bundle.putString("result_json", cVar.bnI);
        bundle.putString("result_json_signature", cVar.kej);
        v.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[]{bundle.toString()});
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void c(com.tencent.mm.plugin.soter_mp.b.c cVar) {
        if (cVar != null && this.fromScene == 0) {
            int i = -1;
            switch (cVar.errCode) {
                case 0:
                    i = 0;
                    break;
                case 90001:
                case 90002:
                case 90003:
                case 90004:
                case 90006:
                case 90007:
                case 90011:
                    i = 2;
                    break;
                case 90008:
                case 90009:
                case 90010:
                    i = 3;
                    break;
            }
            com.tencent.mm.pluginsdk.l.k kVar = com.tencent.mm.pluginsdk.l.k.lEU;
            com.tencent.mm.pluginsdk.l.k.k("requireSoterBiometricAuthentication", com.tencent.mm.pluginsdk.l.k.lEU.appId, i, cVar.errCode);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.kel != null) {
            this.kel.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kel != null) {
            this.kel.onDestroy();
        }
        a.a(kem);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
