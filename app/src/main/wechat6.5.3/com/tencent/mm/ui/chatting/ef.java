package com.tencent.mm.ui.chatting;

import android.view.View;
import java.util.LinkedList;

public final class ef {
    private static LinkedList<View> ozn = new LinkedList();
    private static LinkedList<View> ozo = new LinkedList();

    public static View xp(int i) {
        LinkedList linkedList = i == 1 ? ozn : ozo;
        if (linkedList.size() != 0) {
            return (View) linkedList.removeFirst();
        }
        return null;
    }

    public static void D(View view, int i) {
        LinkedList linkedList = i == 1 ? ozn : ozo;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
    }

    public static void clear() {
        ozn.clear();
        ozo.clear();
    }
}
