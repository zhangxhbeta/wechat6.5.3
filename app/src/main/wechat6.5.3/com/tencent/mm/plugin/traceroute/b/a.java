package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.a.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    public static String kmO;
    public static c kmP;
    private final String TAG = "MicroMsg.MMTraceRoute";
    private final int kmQ = 64;
    private boolean kmR = false;
    f kmS = new f();
    public Map<String, Set<Integer>> kmT = new HashMap();
    public e kmU;
    public d kmV;
    public c kmW;
    public b kmX;
    String userName;

    private class a implements Runnable {
        private String ip;
        private Set<Integer> kmY;
        final /* synthetic */ a kmZ;

        public a(a aVar, String str, Set<Integer> set) {
            this.kmZ = aVar;
            this.ip = str;
            this.kmY = set;
        }

        public final void run() {
            Socket socket;
            Throwable e;
            this.kmZ.a(this.ip, String.format("connect %s: ", new Object[]{this.ip}), Integer.valueOf(1));
            for (Integer num : this.kmY) {
                a aVar = this.kmZ;
                String str = this.ip;
                int intValue = num.intValue();
                try {
                    socket = new Socket();
                    try {
                        socket.setSoTimeout(5000);
                        long Ni = be.Ni();
                        socket.connect(new InetSocketAddress(str, intValue));
                        long Ni2 = be.Ni();
                        v.i("MicroMsg.MMTraceRoute", "connect success" + str + ":" + intValue);
                        aVar.a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(Ni2 - Ni)}), Integer.valueOf(1));
                        try {
                            socket.close();
                        } catch (Throwable e2) {
                            v.e("MicroMsg.MMTraceRoute", "close err: " + e2.getMessage());
                            v.a("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        }
                    } catch (UnknownHostException e3) {
                        e2 = e3;
                        try {
                            aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                            v.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                            v.a("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (Throwable e22) {
                                    v.e("MicroMsg.MMTraceRoute", "close err: " + e22.getMessage());
                                    v.a("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            e22 = th;
                        }
                    } catch (IOException e4) {
                        e22 = e4;
                        aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e22.toString()}), Integer.valueOf(1));
                        v.e("MicroMsg.MMTraceRoute", "connect err:" + e22.getMessage());
                        v.a("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e222) {
                                v.e("MicroMsg.MMTraceRoute", "close err: " + e222.getMessage());
                                v.a("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                            }
                        }
                    } catch (Exception e5) {
                        e222 = e5;
                        aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e222.toString()}), Integer.valueOf(1));
                        v.e("MicroMsg.MMTraceRoute", "connect err:" + e222.toString());
                        v.a("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e2222) {
                                v.e("MicroMsg.MMTraceRoute", "close err: " + e2222.getMessage());
                                v.a("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                            }
                        }
                    }
                } catch (UnknownHostException e6) {
                    e2222 = e6;
                    socket = null;
                    aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    v.e("MicroMsg.MMTraceRoute", "connect err: " + e2222.getMessage());
                    v.a("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e7) {
                    e2222 = e7;
                    socket = null;
                    aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    v.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.getMessage());
                    v.a("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    socket = null;
                    aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    v.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.toString());
                    v.a("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    socket = null;
                }
            }
            this.kmZ.a(this.ip, "\n", Integer.valueOf(1));
            return;
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable e9) {
                    v.e("MicroMsg.MMTraceRoute", "close err: " + e9.getMessage());
                    v.a("MicroMsg.MMTraceRoute", e9, "", new Object[0]);
                }
            }
            throw e2222;
            throw e2222;
        }
    }

    public interface b {
        void baI();
    }

    public interface c {
        void baJ();
    }

    public interface d {
        void baK();
    }

    public interface e {
        void baL();
    }

    private class f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {
        final /* synthetic */ a kmZ;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int kna;
            final /* synthetic */ String knb;
            final /* synthetic */ PByteArray knc;
            final /* synthetic */ f knd;

            AnonymousClass1(f fVar, int i, String str, PByteArray pByteArray) {
                this.knd = fVar;
                this.kna = i;
                this.knb = str;
                this.knc = pByteArray;
            }

            public final void run() {
                String str = "http://" + aa.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
                stringBuffer.append(Integer.toHexString(com.tencent.mm.protocal.d.lWh));
                stringBuffer.append("&devicetype=");
                stringBuffer.append(com.tencent.mm.protocal.d.cmW);
                stringBuffer.append("&filelength=");
                stringBuffer.append(this.kna);
                stringBuffer.append("&sum=");
                stringBuffer.append(this.knb);
                stringBuffer.append("&reporttype=");
                stringBuffer.append(4);
                if (!(this.knd.kmZ.userName == null || this.knd.kmZ.userName.equals(""))) {
                    stringBuffer.append("&username=");
                    stringBuffer.append(this.knd.kmZ.userName);
                }
                v.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
                f.a(this.knd, stringBuffer.toString(), this.knc.value);
            }
        }

        private f(a aVar) {
            this.kmZ = aVar;
        }

        static /* synthetic */ void a(f fVar, String str, byte[] bArr) {
            DefaultHttpClient defaultHttpClient;
            HttpUriRequest httpPost;
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    defaultHttpClient = new DefaultHttpClient();
                    httpPost = new HttpPost(str);
                    try {
                        break;
                    } catch (Throwable e) {
                        v.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                        v.a("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                        i = i2;
                    } catch (Throwable e2) {
                        v.e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                        v.a("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        i = i2;
                    }
                } else {
                    a.a(fVar.kmZ);
                    return;
                }
            }
            HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            v.i("MicroMsg.MMTraceRoute", "http pose returnContent : " + be.e(defaultHttpClient.execute(httpPost).getEntity().getContent()));
            a aVar = fVar.kmZ;
            if (aVar.kmW != null) {
                aVar.kmW.baJ();
            }
        }
    }

    private class g implements Runnable {
        final /* synthetic */ a kmZ;
        private String kne;
        private String knf;
        private boolean kng;
        private Integer knh;

        public g(a aVar, String str, String str2, boolean z, Integer num) {
            this.kmZ = aVar;
            this.kne = str;
            this.knf = str2;
            this.kng = z;
            this.knh = num;
        }

        public final void run() {
            a aVar = this.kmZ;
            String str = this.kne;
            String str2 = this.knf;
            Integer num = this.knh;
            for (int i = 1; i <= 3; i++) {
                List y = b.y(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), str});
                if (y.size() == 2) {
                    String str3 = (String) y.get(0);
                    if (be.kS(str3)) {
                        v.e("MicroMsg.MMTraceRoute", "runcommand err " + str);
                        aVar.a(str2, "run command err ", num);
                    } else {
                        String obj = y.get(1).toString();
                        if (b.CH(str3) > 0) {
                            if (!be.kS(b.CG(str3))) {
                                str3 = String.format(" %sms ", new Object[]{b.CG(str3)});
                            } else if (be.kS(obj)) {
                                str3 = String.format("unable to get time", new Object[0]);
                            } else {
                                str3 = String.format(" %sms ", new Object[]{obj});
                            }
                        } else {
                            str3 = String.format(" router no response ", new Object[0]);
                        }
                        if (i == 3) {
                            str3 = str3 + "\n";
                        }
                        aVar.a(str2, str3, num);
                    }
                } else if (i == 3) {
                    aVar.a(str2, " router no response\n", num);
                } else {
                    aVar.a(str2, " router no response", num);
                }
            }
        }
    }

    private class h implements Runnable {
        private String ip;
        final /* synthetic */ a kmZ;
        private int kni;

        public h(a aVar, String str, int i) {
            this.kmZ = aVar;
            this.ip = str;
            this.kni = i;
        }

        public final void run() {
            boolean z = true;
            v.i("MicroMsg.MMTraceRoute", "ttl= " + this.kni);
            a aVar = this.kmZ;
            String str = this.ip;
            int i = this.kni;
            List y = b.y(new String[]{"ping", "-c 1", "-t " + String.valueOf(i), str});
            if (y.size() != 2) {
                aVar.a(str, String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)}), Integer.valueOf(i + 1));
            } else {
                String str2 = (String) y.get(0);
                if (str2.length() == 0) {
                    v.e("MicroMsg.MMTraceRoute", "runcommand err");
                } else {
                    String str3;
                    int indexOf = str2.indexOf("From ");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("from ");
                        if (indexOf < 0) {
                            str3 = null;
                            if (be.kS(str3)) {
                                if (b.CH(str2) <= 0) {
                                    str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                                    v.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                                    aVar.a(str, str2, Integer.valueOf(i + 1));
                                }
                                if (!z) {
                                }
                            }
                            if (!str.equals(str3)) {
                                aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                            } else if (b.CH(str2) > 0) {
                                aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                if (a.kmP != null) {
                                    a.kmP.execute(new g(aVar, str3, str, true, Integer.valueOf(i + 1)));
                                }
                            } else {
                                aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                if (a.kmP != null) {
                                    a.kmP.execute(new g(aVar, str3, str, false, Integer.valueOf(i + 1)));
                                }
                            }
                            if (!z) {
                            }
                        }
                    }
                    int indexOf2 = str2.indexOf(" ", indexOf);
                    if (indexOf2 < 0) {
                        indexOf = str2.indexOf(":", indexOf);
                        if (indexOf < 0) {
                            str3 = null;
                            if (be.kS(str3)) {
                                if (!str.equals(str3)) {
                                    aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                } else if (b.CH(str2) > 0) {
                                    aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                    if (a.kmP != null) {
                                        a.kmP.execute(new g(aVar, str3, str, false, Integer.valueOf(i + 1)));
                                    }
                                } else {
                                    aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                    if (a.kmP != null) {
                                        a.kmP.execute(new g(aVar, str3, str, true, Integer.valueOf(i + 1)));
                                    }
                                }
                                if (!z) {
                                }
                            }
                            if (b.CH(str2) <= 0) {
                                str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                                v.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                                aVar.a(str, str2, Integer.valueOf(i + 1));
                            }
                            if (!z) {
                            }
                        }
                    }
                    indexOf = indexOf2;
                    indexOf++;
                    indexOf2 = str2.indexOf(" ", indexOf);
                    str3 = indexOf2 < 0 ? null : str2.substring(indexOf, indexOf2).replace(":", "");
                    if (be.kS(str3)) {
                        if (b.CH(str2) <= 0) {
                            str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                            v.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                            aVar.a(str, str2, Integer.valueOf(i + 1));
                        }
                        if (!z) {
                        }
                    }
                    if (!str.equals(str3)) {
                        aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                    } else if (b.CH(str2) > 0) {
                        aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                        if (a.kmP != null) {
                            a.kmP.execute(new g(aVar, str3, str, true, Integer.valueOf(i + 1)));
                        }
                    } else {
                        aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                        if (a.kmP != null) {
                            a.kmP.execute(new g(aVar, str3, str, false, Integer.valueOf(i + 1)));
                        }
                    }
                    if (!z) {
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
    }

    private class i implements Runnable {
        private String ip;
        final /* synthetic */ a kmZ;

        public i(a aVar, String str) {
            this.kmZ = aVar;
            this.ip = str;
        }

        public final void run() {
            int i = 1;
            List y = b.y(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), this.ip});
            if (y.size() != 2) {
                this.kmZ.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                return;
            }
            String str = (String) y.get(0);
            if (be.kS(str)) {
                this.kmZ.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                v.e("MicroMsg.MMTraceRoute", "runcommand err");
                return;
            }
            int CH = b.CH(str);
            if (CH <= 0) {
                v.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
                this.kmZ.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
                return;
            }
            String obj = y.get(1).toString();
            if (!be.kS(b.CG(str))) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(CH), b.CG(str)});
            } else if (be.kS(obj)) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(CH), "unknown"});
            } else {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(CH), obj});
            }
            this.kmZ.a(this.ip, str + "\n", Integer.valueOf(0));
            int i2 = (64 - CH) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            while (i < i2 && !this.kmZ.baG()) {
                Runnable hVar = new h(this.kmZ, this.ip, i);
                if (a.kmP != null) {
                    a.kmP.execute(hVar);
                }
                i++;
            }
        }
    }

    private class j implements Runnable {
        final /* synthetic */ a kmZ;

        private j(a aVar) {
            this.kmZ = aVar;
        }

        public final void run() {
            long Ni;
            this.kmZ.gI(false);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long Ni2 = be.Ni();
            v.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(Ni2)));
            for (Entry entry : this.kmZ.kmT.entrySet()) {
                Runnable iVar = new i(this.kmZ, (String) entry.getKey());
                if (a.kmP != null) {
                    a.kmP.execute(iVar);
                }
                iVar = new a(this.kmZ, (String) entry.getKey(), (Set) entry.getValue());
                if (a.kmP != null) {
                    a.kmP.execute(iVar);
                }
            }
            while (!this.kmZ.baG() && a.kmP.getActiveCount() > 0) {
                v.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.kmP.getActiveCount()));
                Ni = be.Ni();
                if (Ni - Ni2 >= 120000) {
                    v.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((Ni - Ni2) / 1000));
                    this.kmZ.gI(true);
                    this.kmZ.stop();
                    if (this.kmZ.kmU != null) {
                        this.kmZ.kmU.baL();
                        return;
                    }
                    return;
                }
                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    v.e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                    v.a("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                }
            }
            Ni = be.Ni();
            v.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(Ni)));
            v.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((Ni - Ni2) / 1000));
            if (this.kmZ.kmV != null && !this.kmZ.baG()) {
                this.kmZ.kmV.baK();
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.kmX != null) {
            aVar.kmX.baI();
        }
    }

    final synchronized boolean baG() {
        return this.kmR;
    }

    final synchronized void gI(boolean z) {
        this.kmR = z;
    }

    public a(String str) {
        this.userName = str;
        kmO = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
    }

    public final void stop() {
        gI(true);
        if (kmP != null) {
            try {
                kmP.shutdownNow();
            } catch (Exception e) {
                v.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
    }

    public final void b(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            v.e("MicroMsg.MMTraceRoute", "no ip contains");
            return;
        }
        String str = "";
        if (z) {
            str = str + "long: ";
        } else {
            str = str + "short: ";
        }
        int length = strArr.length;
        int i = 0;
        String str2 = str;
        while (i < length) {
            str = strArr[i];
            String[] split = str.split(":");
            if (split == null || split.length != 3) {
                v.e("MicroMsg.MMTraceRoute", "err ip " + str);
                str = str2;
            } else if (this.kmT.containsKey(split[0])) {
                ((Set) this.kmT.get(split[0])).add(Integer.valueOf(be.getInt(split[1], 0)));
                str = str2;
            } else {
                Set hashSet = new HashSet();
                hashSet.add(Integer.valueOf(be.getInt(split[1], 0)));
                this.kmT.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        com.tencent.mm.a.e.e(kmO, (str2 + "\n").getBytes());
    }

    final synchronized void a(String str, String str2, Integer num) {
        if (!(str == null || str2 == null)) {
            if (num.intValue() >= 0) {
                if (!this.kmS.containsKey(str)) {
                    Map concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(num, new StringBuilder(str2));
                    this.kmS.put(str, (ConcurrentHashMap) concurrentHashMap);
                } else if (((ConcurrentHashMap) this.kmS.get(str)).containsKey(num)) {
                    ((StringBuilder) ((ConcurrentHashMap) this.kmS.get(str)).get(num)).append(str2);
                } else {
                    new ConcurrentHashMap().put(num, new StringBuilder(str2));
                    ((ConcurrentHashMap) this.kmS.get(str)).put(num, new StringBuilder(str2));
                }
            }
        }
    }

    public final synchronized void baH() {
        if (this.kmS != null) {
            String str;
            f fVar = this.kmS;
            File file = new File(kmO);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    com.tencent.mm.a.e.e(kmO, (fVar.kmZ.userName + "\n").getBytes());
                } catch (Throwable e) {
                    v.e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    v.a("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    a(fVar.kmZ);
                }
            }
            for (Entry key : fVar.kmZ.kmS.entrySet()) {
                String str2 = (String) key.getKey();
                if (!be.kS(str2) && fVar.kmZ.kmS.containsKey(str2)) {
                    Map map = (Map) fVar.kmZ.kmS.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                Object obj2;
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!be.kS(stringBuilder)) {
                                        str = str3 + stringBuilder;
                                        obj2 = stringBuilder.contains("FIN") ? 1 : obj;
                                        i++;
                                        obj = obj2;
                                        str3 = str;
                                    }
                                }
                                str = str3;
                                obj2 = obj;
                                i++;
                                obj = obj2;
                                str3 = str;
                            }
                        } else {
                            str3 = str3 + ((StringBuilder) map.get(Integer.valueOf(1))).toString();
                        }
                        if (str3.length() > 0) {
                            v.i("MicroMsg.MMTraceRoute", str2 + str3);
                            com.tencent.mm.a.e.e(kmO, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] c = com.tencent.mm.a.e.c(kmO, 0, -1);
            if (be.bl(c)) {
                v.e("MicroMsg.MMTraceRoute", "read log failed");
                a(fVar.kmZ);
            } else {
                str = com.tencent.mm.a.g.m(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.lWh), Integer.valueOf(c.length)}).getBytes()).toLowerCase();
                c = q.k(c);
                PByteArray pByteArray = new PByteArray();
                com.tencent.mm.a.c.a(pByteArray, c, str.getBytes());
                com.tencent.mm.sdk.i.e.a(new AnonymousClass1(fVar, r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        return;
    }
}
