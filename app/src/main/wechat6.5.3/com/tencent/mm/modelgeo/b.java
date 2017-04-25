package com.tencent.mm.modelgeo;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements e {
    public static String TAG = "MicroMsg.LocationAddr";
    private static b cJs;
    private c cJt = null;
    private LinkedList<c> cJu = new LinkedList();
    private HashMap<String, LinkedList<WeakReference<a>>> cJv = new HashMap();
    private ap cJw = new ap(1, "addr_worker");
    private boolean cJx = true;

    public interface a {
        void b(Addr addr);
    }

    private class b implements com.tencent.mm.sdk.platformtools.ap.a {
        private Addr cJy = null;
        final /* synthetic */ b cJz;

        public b(b bVar) {
            this.cJz = bVar;
        }

        public final boolean AZ() {
            if (this.cJz.cJt == null) {
                return false;
            }
            if (this.cJy == null || this.cJy.cJf == null || this.cJy.cJf.equals("")) {
                this.cJy = b.a(this.cJz.cJt.lat, this.cJz.cJt.lng, this.cJz.cJx);
            }
            return true;
        }

        public final boolean Ba() {
            this.cJz.cJx = true;
            this.cJz.a(this.cJy);
            return true;
        }
    }

    class c {
        final /* synthetic */ b cJz;
        double lat;
        double lng;
        Object tag = "";

        public c(b bVar, double d, double d2, Object obj) {
            this.cJz = bVar;
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            String obj = this.tag == null ? "" : ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) ? this.tag : this.tag.toString();
            return append.append(obj).toString();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return ((c) obj).toString().equals(toString());
        }
    }

    private b() {
    }

    public static b FW() {
        if (cJs == null) {
            cJs = new b();
        }
        return cJs;
    }

    public final boolean a(a aVar) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str : this.cJv.keySet()) {
            LinkedList linkedList3 = (LinkedList) this.cJv.get(str);
            b(linkedList3, aVar);
            this.cJv.put(str, linkedList3);
            if (linkedList3 == null || linkedList3.size() == 0) {
                linkedList2.add(str);
            }
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            this.cJv.remove((String) it.next());
        }
        Iterator it2 = this.cJu.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            linkedList3 = (LinkedList) this.cJv.get(cVar.toString());
            if (linkedList3 == null || linkedList3.size() == 0) {
                linkedList.add(cVar);
                this.cJv.remove(cVar.toString());
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            this.cJu.remove((c) it.next());
        }
        v.i(TAG, "remove taskLists %d listeners size %d", new Object[]{Integer.valueOf(this.cJu.size()), Integer.valueOf(this.cJv.size())});
        return true;
    }

    private static boolean a(LinkedList<WeakReference<a>> linkedList, a aVar) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(LinkedList<WeakReference<a>> linkedList, a aVar) {
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                linkedList.remove(weakReference);
                return true;
            }
        }
        return false;
    }

    public final boolean a(double d, double d2, a aVar, Object obj) {
        c cVar;
        if (obj != null) {
            Iterator it = this.cJu.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (cVar != null && cVar.tag != null && cVar.tag.equals(obj)) {
                    this.cJu.remove(cVar);
                    break;
                }
            }
        }
        cVar = new c(this, d, d2, obj);
        LinkedList linkedList = (LinkedList) this.cJv.get(cVar.toString());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!a(linkedList, aVar)) {
            linkedList.add(new WeakReference(aVar));
        }
        this.cJv.put(cVar.toString(), linkedList);
        Iterator it2 = this.cJu.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).equals(cVar)) {
                FX();
                return false;
            }
        }
        if (this.cJt != null && cVar.equals(this.cJt)) {
            return false;
        }
        this.cJu.add(cVar);
        v.i(TAG, "push task size %d listeners %d", new Object[]{Integer.valueOf(this.cJu.size()), Integer.valueOf(this.cJv.size())});
        while (this.cJu.size() > 30) {
            v.i(TAG, "force remove task");
            cVar = (c) this.cJu.removeFirst();
            if (cVar != null) {
                this.cJv.remove(cVar.toString());
            }
        }
        FX();
        return true;
    }

    public final boolean a(double d, double d2, a aVar) {
        return a(d, d2, aVar, null);
    }

    private void FX() {
        if (this.cJt == null && this.cJu != null && this.cJu.size() > 0) {
            this.cJt = (c) this.cJu.removeFirst();
            if (be.He()) {
                this.cJw.c(new b(this));
                return;
            }
            ak.vy().a(655, this);
            ak.vy().a(new d(this.cJt.lat, this.cJt.lng), 0);
        }
    }

    private void a(Addr addr) {
        if (this.cJt != null) {
            if (addr == null) {
                addr = new Addr();
            }
            addr.tag = this.cJt.tag == null ? new Object() : this.cJt.tag;
            addr.cJq = (float) this.cJt.lat;
            addr.cJr = (float) this.cJt.lng;
            if (!be.kS(addr.cJi)) {
                String string = aa.getContext().getResources().getString(2131232770);
                v.d(TAG, "city %s", new Object[]{string});
                if (!be.He() && !be.kS(string) && addr.cJi.endsWith(string)) {
                    addr.cJj = addr.cJi;
                    addr.cJi = addr.cJi.substring(0, addr.cJi.length() - string.length());
                } else if (be.He() || be.kS(string) || addr.cJf.indexOf(string) < 0) {
                    addr.cJj = addr.cJi;
                } else {
                    addr.cJj = addr.cJi + string;
                }
            }
            LinkedList linkedList = (LinkedList) this.cJv.get(this.cJt.toString());
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((a) weakReference.get()).b(addr);
                    }
                }
            }
            this.cJv.remove(this.cJt.toString());
            v.d(TAG, "postexecute2 listeners %d", new Object[]{Integer.valueOf(this.cJv.size())});
            this.cJt = null;
            FX();
            if (this.cJt == null && this.cJu.size() > 0) {
                ak.vy().b(655, this);
            }
        }
    }

    private static Addr a(double d, double d2, boolean z) {
        String format;
        t a;
        InputStreamReader inputStreamReader;
        Throwable e;
        t tVar;
        String bsY = u.bsY();
        Addr addr = new Addr();
        if (z) {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), bsY});
        } else {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), "zh_CN"});
        }
        v.d(TAG, "url " + format);
        try {
            a = com.tencent.mm.network.b.a(format, null);
            try {
                a.setConnectTimeout(10000);
                a.setRequestMethod("GET");
                v.d(TAG, "conn " + a.getResponseCode());
                inputStreamReader = new InputStreamReader(a.getInputStream());
                try {
                    String readLine;
                    String string;
                    String string2;
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    v.d(TAG, "sb " + stringBuffer.toString());
                    JSONArray jSONArray = new JSONObject(stringBuffer.toString()).getJSONArray("results");
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    addr.cJf = jSONObject.getString("formatted_address");
                    JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("address_components");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                        try {
                            string = jSONObject2.getString("long_name");
                            string2 = jSONObject2.getJSONArray("types").getString(0);
                            if (string2.equals("administrative_area_level_1")) {
                                addr.cJh = string;
                            } else if (string2.equals("locality")) {
                                addr.cJi = string;
                            } else if (string2.equals("sublocality")) {
                                addr.cJk = string;
                            } else if (string2.equals("neighborhood")) {
                                addr.cJl = string;
                            } else if (string2.equals("route")) {
                                addr.cJm = string;
                            } else if (string2.equals("street_number")) {
                                addr.cJn = string;
                            } else if (string2.equals("country")) {
                                addr.cJg = string;
                            }
                        } catch (Exception e2) {
                        } catch (IOException e3) {
                            e = e3;
                            tVar = a;
                        }
                    }
                    format = ProtocolPackage.ServerEncoding;
                    string2 = URLDecoder.decode(addr.cJf, format);
                    readLine = URLDecoder.decode(jSONArray2.toString(), format);
                    string = URLDecoder.decode(jSONObject.getJSONObject("geometry").toString(), format);
                    String decode = URLDecoder.decode(jSONObject.getString("place_id"), format);
                    String decode2 = URLDecoder.decode(jSONObject.getJSONArray("types").toString(), format);
                    format = URLDecoder.decode(String.format("[%f,%f]", new Object[]{Double.valueOf(d), Double.valueOf(d2)}), format);
                    v.d(TAG, "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s", new Object[]{string2, readLine, string, decode, decode2, format, bsY});
                    g.iuh.h(12886, new Object[]{readLine, string2, string, decode, decode2, format, bsY});
                    a.dmc.disconnect();
                } catch (IOException e32) {
                    e = e32;
                    tVar = a;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        v.d(TAG, "error Exception");
                        v.e(TAG, "exception:%s", new Object[]{be.e(e)});
                        if (a != null) {
                            a.dmc.disconnect();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable e5) {
                                v.e(TAG, "exception:%s", new Object[]{be.e(e5)});
                            }
                        }
                        return addr;
                    } catch (Throwable th) {
                        e5 = th;
                        if (a != null) {
                            a.dmc.disconnect();
                        }
                        throw e5;
                    }
                }
            } catch (IOException e6) {
                e5 = e6;
                inputStreamReader = null;
                tVar = a;
                try {
                    v.d(TAG, "error e");
                    v.e(TAG, "exception:%s", new Object[]{be.e(e5)});
                    if (tVar != null) {
                        tVar.dmc.disconnect();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return addr;
                } catch (Throwable th2) {
                    e5 = th2;
                    a = tVar;
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    throw e5;
                }
            } catch (Exception e7) {
                e5 = e7;
                inputStreamReader = null;
                v.d(TAG, "error Exception");
                v.e(TAG, "exception:%s", new Object[]{be.e(e5)});
                if (a != null) {
                    a.dmc.disconnect();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return addr;
            }
        } catch (IOException e8) {
            e5 = e8;
            tVar = null;
            inputStreamReader = null;
            v.d(TAG, "error e");
            v.e(TAG, "exception:%s", new Object[]{be.e(e5)});
            if (tVar != null) {
                tVar.dmc.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Exception e9) {
            e5 = e9;
            a = null;
            inputStreamReader = null;
            v.d(TAG, "error Exception");
            v.e(TAG, "exception:%s", new Object[]{be.e(e5)});
            if (a != null) {
                a.dmc.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Throwable th3) {
            e5 = th3;
            a = null;
            if (a != null) {
                a.dmc.disconnect();
            }
            throw e5;
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        return addr;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 655) {
            Addr Gb = ((d) kVar).Gb();
            if (Gb == null || Gb.cJf == null || Gb.cJf.equals("")) {
                this.cJw.c(new b(this));
            } else {
                a(Gb);
            }
        }
    }
}
