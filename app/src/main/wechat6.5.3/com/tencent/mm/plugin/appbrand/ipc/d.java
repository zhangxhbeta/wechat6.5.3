package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class d {
    private static HashMap<String, MMToClientEvent> dEF = new HashMap();

    public static void a(MMToClientEvent mMToClientEvent) {
        v.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[]{mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode())});
        if (mMToClientEvent.appId == null) {
            v.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
        } else if (dEF.get(mMToClientEvent.appId) == null) {
            dEF.put(mMToClientEvent.appId, mMToClientEvent);
        } else {
            v.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
            dEF.remove(mMToClientEvent.appId);
            dEF.put(mMToClientEvent.appId, mMToClientEvent);
        }
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        v.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[]{mMToClientEvent.appId});
        dEF.remove(mMToClientEvent.appId);
    }

    public static void f(String str, int i, String str2) {
        v.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[]{str, Integer.valueOf(i), str2});
        MMToClientEvent mMToClientEvent = (MMToClientEvent) dEF.get(str);
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.dED = 3;
                mMToClientEvent.appId = str;
                mMToClientEvent.type = i;
                mMToClientEvent.bcZ = str2;
                mMToClientEvent.PP();
            }
            return;
        }
        v.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static void Z(String str, int i) {
        v.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[]{Integer.valueOf(i)});
        MMToClientEvent mMToClientEvent = (MMToClientEvent) dEF.get(str);
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.dED = 4;
                mMToClientEvent.aWI = i;
                mMToClientEvent.PP();
            }
            return;
        }
        v.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }
}
