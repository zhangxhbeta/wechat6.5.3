package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.ConcurrentSkipListSet;

public final class i {
    private static ConcurrentSkipListSet<Integer> lzz = new ConcurrentSkipListSet();

    public static synchronized void tv(int i) {
        synchronized (i.class) {
            try {
                v.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", Integer.valueOf(i));
                lzz.add(Integer.valueOf(i));
            } catch (Exception e) {
                v.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", e.getMessage());
            }
        }
    }

    public static synchronized void tw(int i) {
        synchronized (i.class) {
            try {
                v.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", Integer.valueOf(i));
                lzz.remove(Integer.valueOf(i));
            } catch (Exception e) {
                v.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", e.getMessage());
            }
        }
    }

    public static synchronized boolean tx(int i) {
        boolean contains;
        synchronized (i.class) {
            try {
                contains = lzz.contains(Integer.valueOf(i));
                v.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", Integer.valueOf(i), Boolean.valueOf(contains));
            } catch (Exception e) {
                v.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", e.getMessage());
                contains = false;
            }
        }
        return contains;
    }
}
