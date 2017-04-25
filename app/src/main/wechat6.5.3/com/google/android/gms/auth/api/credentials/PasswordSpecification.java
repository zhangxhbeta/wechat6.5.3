package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final PasswordSpecification ajD = new a().iV().P("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").Q("abcdefghijkmnopqrstxyz").Q("ABCDEFGHJKLMNPQRSTXY").Q("3456789").iW();
    public static final PasswordSpecification ajE = new a().iV().P("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").Q("abcdefghijklmnopqrstuvwxyz").Q("ABCDEFGHIJKLMNOPQRSTUVWXYZ").Q("1234567890").iW();
    final String ajF;
    final List<String> ajG;
    final List<Integer> ajH;
    final int ajI;
    final int ajJ;
    private final int[] ajK = iU();
    private final Random ajL = new SecureRandom();
    final int mVersionCode;

    public static class a {
        private final List<String> ajG = new ArrayList();
        private final List<Integer> ajH = new ArrayList();
        private int ajI = 12;
        private int ajJ = 16;
        private final TreeSet<Character> ajM = new TreeSet();

        private static TreeSet<Character> h(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new b(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.bC(c)) {
                    throw new b(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final a P(String str) {
            this.ajM.addAll(h(str, "allowedChars"));
            return this;
        }

        public final a Q(String str) {
            this.ajG.add(PasswordSpecification.b(h(str, "requiredChars")));
            this.ajH.add(Integer.valueOf(1));
            return this;
        }

        public final a iV() {
            this.ajI = 12;
            this.ajJ = 16;
            return this;
        }

        public final PasswordSpecification iW() {
            if (this.ajM.isEmpty()) {
                throw new b("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.ajH) {
                i = intValue.intValue() + i;
            }
            if (i > this.ajJ) {
                throw new b("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.ajG) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        throw new b("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - 32] = true;
                }
            }
            return new PasswordSpecification(1, PasswordSpecification.b(this.ajM), this.ajG, this.ajH, this.ajI, this.ajJ);
        }
    }

    public static class b extends Error {
        public b(String str) {
            super(str);
        }
    }

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.ajF = str;
        this.ajG = Collections.unmodifiableList(list);
        this.ajH = Collections.unmodifiableList(list2);
        this.ajI = i2;
        this.ajJ = i3;
    }

    static /* synthetic */ String b(Collection collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    static /* synthetic */ boolean bC(int i) {
        return i < 32 || i > 126;
    }

    private int[] iU() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.ajG) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        return iArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
