package com.tencent.mm.modelsearch;

import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class g extends l implements Runnable {
    String bkC;
    HashSet<String> cUR;
    k cVI;
    private int errorCode = -2;
    private ac handler;

    public g(String str, HashSet<String> hashSet, k kVar, ac acVar) {
        this.bkC = str;
        this.cVI = kVar;
        this.handler = acVar;
        this.cUR = hashSet;
    }

    public final void run() {
        try {
            if (this.errorCode == -2 || this.errorCode == -3) {
                final List linkedList = new LinkedList();
                final String[] strArr = new String[]{this.bkC};
                if (this.handler == null) {
                    this.cVI.a(this, linkedList, this.cUR, strArr, this.bkC);
                } else {
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ g cVL;

                        public final void run() {
                            this.cVL.cVI.a(this.cVL, linkedList, this.cVL.cUR, strArr, this.cVL.bkC);
                        }
                    });
                }
            }
        } catch (Exception e) {
        }
    }
}
