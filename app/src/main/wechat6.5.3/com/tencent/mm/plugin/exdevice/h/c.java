package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.e.b.bk;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class c extends f<b> {
    public static final String[] cic = new String[]{f.a(b.chq, "HardDeviceInfo")};
    private d cie;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.h.c cVar) {
        b bVar = (b) cVar;
        if (bVar == null || be.kS(bVar.field_brandName) || be.kS(bVar.field_deviceID)) {
            v.w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            return false;
        }
        v.i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", new Object[]{bVar.field_brandName, bVar.field_deviceID, Boolean.valueOf(this.cie.replace("HardDeviceInfo", b.chq.nmc, bVar.py()) > 0)});
        return this.cie.replace("HardDeviceInfo", b.chq.nmc, bVar.py()) > 0;
    }

    public c(d dVar) {
        super(dVar, b.chq, "HardDeviceInfo", null);
        this.cie = dVar;
        dVar.dF("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        dVar.dF("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
    }

    public final b sp(String str) {
        if (be.kS(str)) {
            return null;
        }
        Cursor query = this.cie.query("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            v.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + str);
            query.close();
            return null;
        }
        query.moveToFirst();
        b bVar = new b();
        bVar.b(query);
        query.close();
        return bVar;
    }

    public final b bq(long j) {
        b bVar = null;
        Cursor query = this.cie.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                bVar = new b();
                bVar.b(query);
            } else {
                v.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + j);
            }
            query.close();
        }
        return bVar;
    }

    public final b sq(String str) {
        if (be.kS(str)) {
            return null;
        }
        Cursor query = this.cie.query("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            v.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:" + str);
            query.close();
            return null;
        }
        query.moveToFirst();
        b bVar = new b();
        bVar.b(query);
        query.close();
        return bVar;
    }

    public final b bs(String str, String str2) {
        if (be.kS(str2) || be.kS(str)) {
            v.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[]{str2, str});
            return null;
        }
        Cursor query = this.cie.query("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            v.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[]{str2, str});
            query.close();
            return null;
        }
        query.moveToFirst();
        b bVar = new b();
        bVar.b(query);
        query.close();
        return bVar;
    }

    public static boolean sr(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            return true;
        } else {
            return false;
        }
    }

    public final List<b> ajY() {
        List<b> linkedList = new LinkedList();
        Cursor Kp = Kp();
        if (Kp == null || !Kp.moveToFirst()) {
            if (Kp != null) {
                Kp.close();
            }
            return linkedList;
        }
        do {
            bk bVar = new b();
            bVar.b(Kp);
            String str = bVar.bLi;
            if (str != null && sr(str)) {
                linkedList.add(bVar);
            }
        } while (Kp.moveToNext());
        if (Kp != null) {
            Kp.close();
        }
        return linkedList;
    }

    public final List<b> ajZ() {
        List<b> linkedList = new LinkedList();
        Cursor Kp = Kp();
        if (Kp == null || !Kp.moveToFirst()) {
            if (Kp != null) {
                Kp.close();
            }
            return linkedList;
        }
        do {
            bk bVar = new b();
            bVar.b(Kp);
            String str = bVar.bLe;
            String str2 = bVar.iconUrl;
            String str3 = bVar.category;
            String str4 = bVar.field_brandName;
            if (!(be.kS(str3) || str3.equals("1") || str3.equals("0") || be.kS(str4) || be.kS(str) || be.kS(str2))) {
                linkedList.add(bVar);
            }
        } while (Kp.moveToNext());
        if (Kp != null) {
            Kp.close();
        }
        return linkedList;
    }

    public final b bt(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[]{str, str2});
            return null;
        }
        Cursor query = this.cie.query("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            v.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:" + str);
            query.close();
            return null;
        }
        query.moveToFirst();
        b bVar = new b();
        bVar.b(query);
        query.close();
        return bVar;
    }

    public final LinkedList<b> ss(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        Cursor query = this.cie.query("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null);
        if (query == null) {
            return linkedList;
        }
        if (query.moveToFirst()) {
            do {
                b bVar = new b();
                bVar.b(query);
                linkedList.add(bVar);
            } while (query.moveToNext());
        }
        query.close();
        return linkedList;
    }

    public final LinkedList<b> aka() {
        LinkedList<b> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.b(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final LinkedList<b> akb() {
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList<b> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where connProto like '6'", new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.b(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            v.i("MicroMsg.exdevice.HardDeviceInfoStorage", "[hakon][step] PhoneStepDevice size = %s, cost = %s", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean bu(String str, String str2) {
        if (be.kS(str)) {
            return false;
        }
        if (this.cie.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            v.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[]{str});
            return false;
        }
        v.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[]{str});
        return true;
    }

    public final int h(b bVar) {
        int update;
        ContentValues py = bVar.py();
        if (py.size() > 0) {
            update = this.cie.update("HardDeviceInfo", py, "deviceID = ? and deviceType = ? ", new String[]{bVar.field_deviceID, bVar.field_deviceType});
        } else {
            update = 0;
        }
        v.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[]{bVar.field_deviceID, bVar.field_deviceType, Integer.valueOf(update)});
        return update;
    }
}
