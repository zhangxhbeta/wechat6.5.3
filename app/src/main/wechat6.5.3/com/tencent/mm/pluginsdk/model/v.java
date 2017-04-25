package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.j;
import com.tencent.smtt.sdk.u;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v {
    private static long lAb;
    private static final Map<String, Object> lAc = new HashMap();

    public static final class a {
        private static boolean lAg = false;

        static {
            TbsLog.setTbsLogClient(new s(aa.getContext()) {
                public final void i(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.v.i(str, str2);
                }

                public final void e(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.v.e(str, str2);
                }

                public final void w(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.v.w(str, str2);
                }

                public final void d(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.v.d(str, str2);
                }

                public final void v(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.v.v(str, str2);
                }

                public final void ot(String str) {
                    com.tencent.mm.sdk.platformtools.v.i("TBSDownloadChecker.TbsLogClient", "TbsLogClient: " + str);
                }
            });
        }

        public static void df(Context context) {
            int i;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)));
            if (sharedPreferences.getBoolean("tbs_download_oversea", false)) {
                i = 2;
            } else if (be.buw()) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
                return;
            } else {
                i = 1;
            }
            if ("1".equals(sharedPreferences.getString("tbs_download", null))) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", r5, Boolean.valueOf(ak.isWifi(context)));
                if (ak.isWifi(context)) {
                    boolean z;
                    Intent intent;
                    if (sharedPreferences == null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TBSDownloadChecker", "sp is null");
                    } else {
                        long j = sharedPreferences.getLong("last_check_ts", 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j > 7200000) {
                            Editor edit = sharedPreferences.edit();
                            edit.putLong("last_check_ts", currentTimeMillis);
                            edit.apply();
                            z = true;
                            if (!z) {
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getTbsCoreVersion(context)));
                                if (WebView.getTbsCoreVersion(context) > 0) {
                                    return;
                                }
                            }
                            intent = new Intent();
                            intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                            intent.putExtra("intent_extra_download_type", i);
                            context.startService(intent);
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getTbsCoreVersion(context)));
                        if (WebView.getTbsCoreVersion(context) > 0) {
                            return;
                        }
                    }
                    intent = new Intent();
                    intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                    intent.putExtra("intent_extra_download_type", i);
                    context.startService(intent);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                    return;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
                return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", sharedPreferences.getString("tbs_download", null));
        }

        public static void bna() {
            if (be.buw()) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
            } else if (j.fc(aa.getContext()) && WebView.getTbsCoreVersion(aa.getContext()) <= 0) {
                Intent intent = new Intent();
                intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", 1);
                aa.getContext().startService(intent);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            }
        }

        public static boolean bnb() {
            return j.alC() || QbSdk.getTBSInstalling() || lAg;
        }

        public static void hN(boolean z) {
            lAg = z;
        }

        public static int bnc() {
            if (QbSdk.getTbsVersion(aa.getContext()) < 36824) {
                if (!be.buw()) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d should download", Integer.valueOf(r2));
                    return 1;
                } else if (d.dX(17)) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "is GP version can not download");
                    return 2;
                } else {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "is GP version no need download");
                    return 0;
                }
            } else if (QbSdk.canOpenWebPlus(aa.getContext())) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can load x5", Integer.valueOf(r2));
                return 0;
            } else {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can not load x5", Integer.valueOf(r2));
                return 1;
            }
        }

        public static int bnd() {
            if (d.dW(19) || d.dX(16)) {
                return 1;
            }
            if (WebView.getTbsCoreVersion(aa.getContext()) > 0) {
                return 4;
            }
            if (j.alC()) {
                return 2;
            }
            if (QbSdk.getTBSInstalling()) {
                return 3;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "oversea = %b", Boolean.valueOf(aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)));
            if (aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)) {
                return 2;
            }
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
            return 0;
        }

        public static void dg(Context context) {
            Intent intent = new Intent();
            intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 2);
            intent.putExtra("intent_extra_download_ignore_network_type", true);
            context.startService(intent);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
            }
        }
    }

    static /* synthetic */ void dj(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSHelper", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        aa.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
    }

    static /* synthetic */ void dk(String str, String str2) {
        Intent intent = new Intent(aa.getContext(), MiniQBReaderUI.class);
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        aa.getContext().startActivity(intent);
    }

    public static void bmY() {
        QbSdk.preInit(aa.getContext(), null);
    }

    public static String bmZ() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<TBSInfo>");
        stringBuilder.append("<TBSCoreVersion>");
        stringBuilder.append(WebView.getTbsCoreVersion(aa.getContext()));
        stringBuilder.append("</TBSCoreVersion>");
        stringBuilder.append("<TBSSDKVersion>");
        stringBuilder.append(WebView.getTbsSDKVersion(aa.getContext()));
        stringBuilder.append("</TBSSDKVersion>");
        stringBuilder.append("</TBSInfo>");
        stringBuilder.append("<IMEI>");
        stringBuilder.append(p.rJ());
        stringBuilder.append("</IMEI>");
        return stringBuilder.toString();
    }

    public static void P(Intent intent) {
        final String stringExtra = intent.getStringExtra("file_path");
        final String stringExtra2 = intent.getStringExtra("file_ext");
        if (System.currentTimeMillis() - lAb >= 1000 && !be.kS(stringExtra)) {
            lAb = System.currentTimeMillis();
            final Context context = aa.getContext();
            String str = SQLiteDatabase.KeyEmpty;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("path", stringExtra);
                jSONObject.putOpt("ext", stringExtra2);
                str = jSONObject.toString();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TBSHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSHelper", "openFileByMiniQB, file pathinfo:%s", str);
            QbSdk.canOpenFile(context, str, new u<Boolean>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        v.dj(stringExtra, stringExtra2);
                    } else if (QbSdk.isTbsCoreInited()) {
                        v.dk(stringExtra, stringExtra2);
                    } else {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSHelper", "tbs preInit");
                        QbSdk.preInit(context, new com.tencent.smtt.sdk.QbSdk.a(this) {
                            final /* synthetic */ AnonymousClass1 lAf;

                            {
                                this.lAf = r1;
                            }

                            public final void RT() {
                            }

                            public final void by(boolean z) {
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TBSHelper", "tbs preInit callback, %b", Boolean.valueOf(z));
                                if (z) {
                                    v.dk(stringExtra, stringExtra2);
                                } else {
                                    v.dj(stringExtra, stringExtra2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static void di(String str, String str2) {
        lAc.put(str, str2);
        QbSdk.initTbsSettings(lAc);
    }
}
