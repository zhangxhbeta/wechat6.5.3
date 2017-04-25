package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static a dlk;

    public interface a {
        e uX();
    }

    public static class b {
        public int dll = 0;
        public String host = null;
        public String ip = SQLiteDatabase.KeyEmpty;
        URL url = null;

        public b(String str) {
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                String str2;
                if (b.dlk == null || b.dlk.uX() == null) {
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.dlk == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.dlk.uX();
                    }
                    objArr[0] = str2;
                    objArr[1] = be.bur();
                    v.e(str3, str4, objArr);
                    return;
                }
                this.dll = b.dlk.uX().getHostByName(this.host, arrayList);
                v.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.dll), this.host, str);
                if (arrayList.size() <= 0) {
                    this.dll = 0;
                } else if (1 == this.dll) {
                    str2 = (String) arrayList.get((int) (be.Ni() % ((long) arrayList.size())));
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, str2));
                }
            } catch (Throwable e) {
                v.e("MicroMsg.GprsSetting", "exception:%s", be.e(e));
            }
        }

        public b(String str, boolean z) {
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                String str2;
                if (b.dlk == null || b.dlk.uX() == null) {
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.dlk == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.dlk.uX();
                    }
                    objArr[0] = str2;
                    objArr[1] = be.bur();
                    v.e(str3, str4, objArr);
                    return;
                }
                this.dll = b.dlk.uX().a(this.host, z, arrayList);
                v.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.dll), this.host, str, arrayList);
                if (arrayList.size() <= 0) {
                    this.dll = 0;
                } else if (1 == this.dll) {
                    str2 = (String) arrayList.get((int) (be.Ni() % ((long) arrayList.size())));
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, str2));
                }
            } catch (Throwable e) {
                v.e("MicroMsg.GprsSetting", "exception:%s", be.e(e));
            }
        }
    }

    public static void a(a aVar) {
        v.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.valueOf(false), be.bur());
        dlk = aVar;
    }

    public static int a(boolean z, List<String> list, String str) {
        int i = -1;
        if (dlk != null) {
            try {
                i = dlk.uX().a(str, z, list);
            } catch (Throwable e) {
                v.e("MicroMsg.GprsSetting", "exception:%s", be.e(e));
            }
        }
        return i;
    }

    public static InputStream h(String str, int i, int i2) {
        t a = a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (a(a) != 0) {
            return null;
        }
        return a.getInputStream();
    }

    public static t a(String str, b bVar) {
        if (bVar == null) {
            bVar = new b(str);
        }
        t tVar = new t(bVar.url, bVar.dll);
        if (1 == bVar.dll) {
            tVar.setRequestProperty("Host", bVar.host);
            tVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        return tVar;
    }

    public static int a(t tVar) {
        try {
            if (tVar.getResponseCode() != 200) {
                return -1;
            }
            return 0;
        } catch (Throwable e) {
            v.e("MicroMsg.GprsSetting", "exception:%s", be.e(e));
            return -3;
        }
    }

    public static u lL(String str) {
        return new u(str);
    }
}
