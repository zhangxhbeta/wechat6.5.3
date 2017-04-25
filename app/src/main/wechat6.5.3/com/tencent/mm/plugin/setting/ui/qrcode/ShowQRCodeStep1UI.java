package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.am.a;
import com.tencent.mm.am.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.v.e;
import java.io.FileOutputStream;

public class ShowQRCodeStep1UI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private int iJu = 1;
    private ImageView iJz = null;

    protected final int getLayoutId() {
        return 2130904391;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.vy().a(168, this);
    }

    public void onDestroy() {
        ak.vy().b(168, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131234914);
        this.iJz = (ImageView) findViewById(2131755310);
        this.iJu = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(2131759196);
        if (this.iJu == 3) {
            textView.setText(getString(2131234887, new Object[]{getString(2131234891)}));
        } else if (this.iJu == 4) {
            textView.setText(getString(2131234887, new Object[]{getString(2131234888)}));
        } else if (this.iJu == 2) {
            textView.setText(getString(2131234887, new Object[]{getString(2131234890)}));
        } else {
            textView.setText(getString(2131234887, new Object[]{getString(2131234889)}));
        }
        Bitmap HU = b.HU();
        if (HU == null) {
            aMP();
        } else {
            this.iJz.setImageBitmap(HU);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI iJA;

            {
                this.iJA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJA.axg();
                this.iJA.finish();
                return true;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI iJA;

            {
                this.iJA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShowQRCodeStep1UI showQRCodeStep1UI = this.iJA;
                g.a(showQRCodeStep1UI, "", new String[]{showQRCodeStep1UI.getString(2131234879), showQRCodeStep1UI.getString(2131234883)}, "", false, new c(showQRCodeStep1UI) {
                    final /* synthetic */ ShowQRCodeStep1UI iJA;

                    {
                        this.iJA = r1;
                    }

                    public final void gT(int i) {
                        FileOutputStream fileOutputStream;
                        Throwable e;
                        switch (i) {
                            case 0:
                                this.iJA.aMP();
                                return;
                            case 1:
                                ShowQRCodeStep1UI showQRCodeStep1UI = this.iJA;
                                String xF = k.xF();
                                ak.yW();
                                be.f((Integer) com.tencent.mm.model.c.vf().get(66561, null));
                                byte[] jv = b.jv(xF);
                                if (jv != null && jv.length > 0) {
                                    String str = l.bqT() + "mmqrcode" + System.currentTimeMillis() + ".png";
                                    try {
                                        fileOutputStream = new FileOutputStream(str);
                                        try {
                                            fileOutputStream.write(jv);
                                            Toast.makeText(showQRCodeStep1UI, showQRCodeStep1UI.getString(2131232244, new Object[]{str}), 1).show();
                                            l.c(str, showQRCodeStep1UI);
                                            try {
                                                fileOutputStream.close();
                                                return;
                                            } catch (Exception e2) {
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                v.a("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                        return;
                                                    } catch (Exception e4) {
                                                        return;
                                                    }
                                                }
                                                return;
                                            } catch (Throwable th) {
                                                e = th;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Exception e5) {
                                                    }
                                                }
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        fileOutputStream = null;
                                        v.a("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        fileOutputStream = null;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        ((Button) findViewById(2131759197)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI iJA;

            {
                this.iJA = r1;
            }

            public final void onClick(View view) {
                if (this.iJA.iJu == 3) {
                    byte[] uT = ak.uT();
                    String xF = k.xF();
                    ak.yW();
                    v.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[]{be.KW(be.bn(uT)), xF, Integer.valueOf(be.f((Integer) com.tencent.mm.model.c.vf().get(66561, null)))});
                    v.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[]{"http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.a.g.m(uT) + "&u=" + xF + "&qr=" + r0 + "&device=" + d.cmW + "&version=" + d.lWh});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.iJA.getString(2131234897));
                    com.tencent.mm.ay.c.b(this.iJA, "webview", ".ui.tools.WebViewUI", intent);
                    this.iJA.finish();
                } else if (this.iJA.iJu == 4) {
                    if (k.yh()) {
                        r0 = new Intent(this.iJA, ShareToQQUI.class);
                        r0.putExtra("show_to", 4);
                        this.iJA.startActivity(r0);
                    } else {
                        this.iJA.q(FacebookAuthUI.class);
                    }
                    this.iJA.finish();
                } else if (this.iJA.iJu == 2) {
                    r0 = new Intent(this.iJA, ShareToQQUI.class);
                    r0.putExtra("show_to", 2);
                    this.iJA.startActivity(r0);
                    this.iJA.finish();
                } else {
                    r0 = new Intent(this.iJA, ShareToQQUI.class);
                    r0.putExtra("show_to", 1);
                    this.iJA.startActivity(r0);
                    this.iJA.finish();
                }
            }
        });
    }

    final void aMP() {
        final a aVar = new a();
        ak.vy().a(aVar, 0);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwR = g.a(actionBarActivity, getString(2131234882), true, new OnCancelListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI iJA;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(aVar);
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (!com.tencent.mm.plugin.setting.a.drq.b(this.nDR.nEl, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.iJz.setImageBitmap(b.HU());
                return;
            }
            Toast.makeText(this, getString(2131232922, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
