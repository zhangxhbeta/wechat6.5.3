package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private static a gEw = null;
    private long endTime = -1;
    private boolean foB = false;
    public ArrayList<a> gEv = new ArrayList();
    ac handler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ a gEx;

        public final void handleMessage(Message message) {
            long currentTimeMillis = System.currentTimeMillis();
            d aur = i.aur();
            ArrayList<c> arrayList = (ArrayList) message.obj;
            if (arrayList != null && arrayList.size() > 0) {
                long auU = aur.auU();
                v.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
                Cursor query = aur.cie.query("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null);
                Map hashMap = new HashMap();
                if (query != null && query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        if (!hashMap.containsKey(query.getString(0))) {
                            hashMap.put(query.getString(0), Boolean.valueOf(true));
                        }
                        query.moveToNext();
                    }
                }
                if (query != null) {
                    query.close();
                }
                v.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                for (c cVar : arrayList) {
                    if (!hashMap.containsKey(cVar.field_contactId)) {
                        aur.b(cVar);
                    }
                }
                aur.cb(auU);
            }
            v.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.gEx.endTime = System.currentTimeMillis();
            v.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", new Object[]{Long.valueOf(this.gEx.endTime - this.gEx.startTime)});
            this.gEx.foB = false;
            this.gEx.endTime = -1;
            this.gEx.startTime = -1;
            Iterator it = this.gEx.gEv.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.atX();
                }
            }
            this.gEx.gEv.clear();
        }
    };
    private long startTime = -1;

    public interface a {
        void atX();
    }

    private a() {
    }

    public static a atW() {
        if (gEw == null) {
            gEw = new a();
        }
        return gEw;
    }

    public final void a(a aVar, boolean z) {
        if (aVar != null) {
            this.gEv.add(aVar);
        }
        if (this.foB) {
            v.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.auR().size() == 0 || !z) {
            v.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            ArrayList auQ = b.auQ();
            v.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = auQ;
            this.handler.sendMessage(obtainMessage);
            this.foB = true;
        }
    }
}
