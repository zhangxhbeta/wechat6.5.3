package com.tencent.tmassistantsdk.util;

import java.io.UnsupportedEncodingException;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = (!Base64.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        Coder() {
        }
    }

    static class Decoder extends Coder {
        private static final int[] DECODE = new int[]{SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, 62, SKIP, SKIP, SKIP, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, SKIP, SKIP, SKIP, -2, SKIP, SKIP, SKIP, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP};
        private static final int[] DECODE_WEBSAFE = new int[]{SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, 62, SKIP, SKIP, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, SKIP, SKIP, SKIP, -2, SKIP, SKIP, SKIP, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, SKIP, SKIP, SKIP, SKIP, 63, SKIP, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP, SKIP};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r10, int r11, int r12, boolean r13) {
            /*
            r9 = this;
            r0 = r9.state;
            r1 = 6;
            if (r0 != r1) goto L_0x0007;
        L_0x0005:
            r0 = 0;
        L_0x0006:
            return r0;
        L_0x0007:
            r4 = r12 + r11;
            r2 = r9.state;
            r1 = r9.value;
            r0 = 0;
            r5 = r9.output;
            r6 = r9.alphabet;
            r3 = r2;
            r2 = r11;
        L_0x0014:
            if (r2 >= r4) goto L_0x0108;
        L_0x0016:
            if (r3 != 0) goto L_0x005d;
        L_0x0018:
            r7 = r2 + 4;
            if (r7 > r4) goto L_0x005b;
        L_0x001c:
            r1 = r10[r2];
            r1 = r1 & 255;
            r1 = r6[r1];
            r1 = r1 << 18;
            r7 = r2 + 1;
            r7 = r10[r7];
            r7 = r7 & 255;
            r7 = r6[r7];
            r7 = r7 << 12;
            r1 = r1 | r7;
            r7 = r2 + 2;
            r7 = r10[r7];
            r7 = r7 & 255;
            r7 = r6[r7];
            r7 = r7 << 6;
            r1 = r1 | r7;
            r7 = r2 + 3;
            r7 = r10[r7];
            r7 = r7 & 255;
            r7 = r6[r7];
            r1 = r1 | r7;
            if (r1 < 0) goto L_0x005b;
        L_0x0045:
            r7 = r0 + 2;
            r8 = (byte) r1;
            r5[r7] = r8;
            r7 = r0 + 1;
            r8 = r1 >> 8;
            r8 = (byte) r8;
            r5[r7] = r8;
            r7 = r1 >> 16;
            r7 = (byte) r7;
            r5[r0] = r7;
            r0 = r0 + 3;
            r2 = r2 + 4;
            goto L_0x0018;
        L_0x005b:
            if (r2 >= r4) goto L_0x0108;
        L_0x005d:
            r11 = r2 + 1;
            r2 = r10[r2];
            r2 = r2 & 255;
            r2 = r6[r2];
            switch(r3) {
                case 0: goto L_0x006a;
                case 1: goto L_0x007a;
                case 2: goto L_0x008d;
                case 3: goto L_0x00b1;
                case 4: goto L_0x00ed;
                case 5: goto L_0x00ff;
                default: goto L_0x0068;
            };
        L_0x0068:
            r2 = r11;
            goto L_0x0014;
        L_0x006a:
            if (r2 < 0) goto L_0x0072;
        L_0x006c:
            r1 = r3 + 1;
            r3 = r1;
            r1 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x0072:
            r7 = -1;
            if (r2 == r7) goto L_0x0068;
        L_0x0075:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x007a:
            if (r2 < 0) goto L_0x0084;
        L_0x007c:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r3 + 1;
            r3 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x0084:
            r7 = -1;
            if (r2 == r7) goto L_0x0068;
        L_0x0087:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x008d:
            if (r2 < 0) goto L_0x0098;
        L_0x008f:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r3 + 1;
            r3 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x0098:
            r7 = -2;
            if (r2 != r7) goto L_0x00a8;
        L_0x009b:
            r2 = r0 + 1;
            r3 = r1 >> 4;
            r3 = (byte) r3;
            r5[r0] = r3;
            r0 = 4;
            r3 = r0;
            r0 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x00a8:
            r7 = -1;
            if (r2 == r7) goto L_0x0068;
        L_0x00ab:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x00b1:
            if (r2 < 0) goto L_0x00ce;
        L_0x00b3:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r0 + 2;
            r3 = (byte) r1;
            r5[r2] = r3;
            r2 = r0 + 1;
            r3 = r1 >> 8;
            r3 = (byte) r3;
            r5[r2] = r3;
            r2 = r1 >> 16;
            r2 = (byte) r2;
            r5[r0] = r2;
            r0 = r0 + 3;
            r2 = 0;
            r3 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x00ce:
            r7 = -2;
            if (r2 != r7) goto L_0x00e4;
        L_0x00d1:
            r2 = r0 + 1;
            r3 = r1 >> 2;
            r3 = (byte) r3;
            r5[r2] = r3;
            r2 = r1 >> 10;
            r2 = (byte) r2;
            r5[r0] = r2;
            r0 = r0 + 2;
            r2 = 5;
            r3 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x00e4:
            r7 = -1;
            if (r2 == r7) goto L_0x0068;
        L_0x00e7:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x00ed:
            r7 = -2;
            if (r2 != r7) goto L_0x00f6;
        L_0x00f0:
            r2 = r3 + 1;
            r3 = r2;
            r2 = r11;
            goto L_0x0014;
        L_0x00f6:
            r7 = -1;
            if (r2 == r7) goto L_0x0068;
        L_0x00f9:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x00ff:
            r7 = -1;
            if (r2 == r7) goto L_0x0068;
        L_0x0102:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0108:
            r2 = r1;
            if (r13 != 0) goto L_0x0114;
        L_0x010b:
            r9.state = r3;
            r9.value = r2;
            r9.op = r0;
            r0 = 1;
            goto L_0x0006;
        L_0x0114:
            switch(r3) {
                case 0: goto L_0x0117;
                case 1: goto L_0x011e;
                case 2: goto L_0x0124;
                case 3: goto L_0x012d;
                case 4: goto L_0x013c;
                default: goto L_0x0117;
            };
        L_0x0117:
            r9.state = r3;
            r9.op = r0;
            r0 = 1;
            goto L_0x0006;
        L_0x011e:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0124:
            r1 = r0 + 1;
            r2 = r2 >> 4;
            r2 = (byte) r2;
            r5[r0] = r2;
            r0 = r1;
            goto L_0x0117;
        L_0x012d:
            r1 = r0 + 1;
            r4 = r2 >> 10;
            r4 = (byte) r4;
            r5[r0] = r4;
            r0 = r1 + 1;
            r2 = r2 >> 2;
            r2 = (byte) r2;
            r5[r1] = r2;
            goto L_0x0117;
        L_0x013c:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.util.Base64.Decoder.process(byte[], int, int, boolean):boolean");
        }
    }

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final byte[] ENCODE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            boolean z;
            if (Base64.class.desiredAssertionStatus()) {
                z = $assertionsDisabled;
            } else {
                z = true;
            }
            $assertionsDisabled = z;
        }

        public Encoder(int i, byte[] bArr) {
            boolean z = true;
            this.output = bArr;
            this.do_padding = (i & 1) == 0 ? true : $assertionsDisabled;
            this.do_newline = (i & 2) == 0 ? true : $assertionsDisabled;
            if ((i & 4) == 0) {
                z = $assertionsDisabled;
            }
            this.do_cr = z;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r11, int r12, int r13, boolean r14) {
            /*
            r10 = this;
            r6 = r10.alphabet;
            r7 = r10.output;
            r4 = 0;
            r2 = r10.count;
            r8 = r13 + r12;
            r0 = -1;
            r1 = r10.tailLen;
            switch(r1) {
                case 0: goto L_0x00a9;
                case 1: goto L_0x00ad;
                case 2: goto L_0x00d1;
                default: goto L_0x000f;
            };
        L_0x000f:
            r3 = r0;
            r1 = r12;
        L_0x0011:
            r0 = -1;
            if (r3 == r0) goto L_0x0248;
        L_0x0014:
            r0 = 0;
            r4 = r3 >> 18;
            r4 = r4 & 63;
            r4 = r6[r4];
            r7[r0] = r4;
            r0 = 1;
            r4 = r3 >> 12;
            r4 = r4 & 63;
            r4 = r6[r4];
            r7[r0] = r4;
            r0 = 2;
            r4 = r3 >> 6;
            r4 = r4 & 63;
            r4 = r6[r4];
            r7[r0] = r4;
            r4 = 3;
            r0 = 4;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r4] = r3;
            r2 = r2 + -1;
            if (r2 != 0) goto L_0x0244;
        L_0x003b:
            r2 = r10.do_cr;
            if (r2 == 0) goto L_0x0045;
        L_0x003f:
            r2 = 4;
            r0 = 5;
            r3 = 13;
            r7[r2] = r3;
        L_0x0045:
            r4 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = 19;
            r5 = r0;
        L_0x004e:
            r0 = r1 + 3;
            if (r0 > r8) goto L_0x00f5;
        L_0x0052:
            r0 = r11[r1];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r2 = r1 + 1;
            r2 = r11[r2];
            r2 = r2 & 255;
            r2 = r2 << 8;
            r0 = r0 | r2;
            r2 = r1 + 2;
            r2 = r11[r2];
            r2 = r2 & 255;
            r0 = r0 | r2;
            r2 = r0 >> 18;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r4] = r2;
            r2 = r4 + 1;
            r3 = r0 >> 12;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r2] = r3;
            r2 = r4 + 2;
            r3 = r0 >> 6;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r2] = r3;
            r2 = r4 + 3;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r2] = r0;
            r2 = r1 + 3;
            r1 = r4 + 4;
            r0 = r5 + -1;
            if (r0 != 0) goto L_0x023f;
        L_0x0094:
            r0 = r10.do_cr;
            if (r0 == 0) goto L_0x023c;
        L_0x0098:
            r0 = r1 + 1;
            r3 = 13;
            r7[r1] = r3;
        L_0x009e:
            r4 = r0 + 1;
            r1 = 10;
            r7[r0] = r1;
            r0 = 19;
            r1 = r2;
            r5 = r0;
            goto L_0x004e;
        L_0x00a9:
            r3 = r0;
            r1 = r12;
            goto L_0x0011;
        L_0x00ad:
            r1 = r12 + 2;
            if (r1 > r8) goto L_0x000f;
        L_0x00b1:
            r0 = r10.tail;
            r1 = 0;
            r0 = r0[r1];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r1 = r12 + 1;
            r3 = r11[r12];
            r3 = r3 & 255;
            r3 = r3 << 8;
            r0 = r0 | r3;
            r12 = r1 + 1;
            r1 = r11[r1];
            r1 = r1 & 255;
            r0 = r0 | r1;
            r1 = 0;
            r10.tailLen = r1;
            r3 = r0;
            r1 = r12;
            goto L_0x0011;
        L_0x00d1:
            r1 = r12 + 1;
            if (r1 > r8) goto L_0x000f;
        L_0x00d5:
            r0 = r10.tail;
            r1 = 0;
            r0 = r0[r1];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r1 = r10.tail;
            r3 = 1;
            r1 = r1[r3];
            r1 = r1 & 255;
            r1 = r1 << 8;
            r0 = r0 | r1;
            r1 = r12 + 1;
            r3 = r11[r12];
            r3 = r3 & 255;
            r0 = r0 | r3;
            r3 = 0;
            r10.tailLen = r3;
            r3 = r0;
            goto L_0x0011;
        L_0x00f5:
            if (r14 == 0) goto L_0x0202;
        L_0x00f7:
            r0 = r10.tailLen;
            r0 = r1 - r0;
            r2 = r8 + -1;
            if (r0 != r2) goto L_0x0161;
        L_0x00ff:
            r3 = 0;
            r0 = r10.tailLen;
            if (r0 <= 0) goto L_0x015a;
        L_0x0104:
            r0 = r10.tail;
            r3 = 0;
            r2 = 1;
            r0 = r0[r3];
        L_0x010a:
            r0 = r0 & 255;
            r3 = r0 << 4;
            r0 = r10.tailLen;
            r0 = r0 - r2;
            r10.tailLen = r0;
            r2 = r4 + 1;
            r0 = r3 >> 6;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r4] = r0;
            r0 = r2 + 1;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r2] = r3;
            r2 = r10.do_padding;
            if (r2 == 0) goto L_0x0135;
        L_0x0129:
            r2 = r0 + 1;
            r3 = 61;
            r7[r0] = r3;
            r0 = r2 + 1;
            r3 = 61;
            r7[r2] = r3;
        L_0x0135:
            r2 = r10.do_newline;
            if (r2 == 0) goto L_0x014b;
        L_0x0139:
            r2 = r10.do_cr;
            if (r2 == 0) goto L_0x0144;
        L_0x013d:
            r2 = r0 + 1;
            r3 = 13;
            r7[r0] = r3;
            r0 = r2;
        L_0x0144:
            r2 = r0 + 1;
            r3 = 10;
            r7[r0] = r3;
            r0 = r2;
        L_0x014b:
            r4 = r0;
        L_0x014c:
            r0 = $assertionsDisabled;
            if (r0 != 0) goto L_0x01f6;
        L_0x0150:
            r0 = r10.tailLen;
            if (r0 == 0) goto L_0x01f6;
        L_0x0154:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x015a:
            r2 = r1 + 1;
            r0 = r11[r1];
            r1 = r2;
            r2 = r3;
            goto L_0x010a;
        L_0x0161:
            r0 = r10.tailLen;
            r0 = r1 - r0;
            r2 = r8 + -2;
            if (r0 != r2) goto L_0x01da;
        L_0x0169:
            r3 = 0;
            r0 = r10.tailLen;
            r2 = 1;
            if (r0 <= r2) goto L_0x01cd;
        L_0x016f:
            r0 = r10.tail;
            r3 = 0;
            r2 = 1;
            r0 = r0[r3];
        L_0x0175:
            r0 = r0 & 255;
            r9 = r0 << 10;
            r0 = r10.tailLen;
            if (r0 <= 0) goto L_0x01d4;
        L_0x017d:
            r0 = r10.tail;
            r3 = r2 + 1;
            r0 = r0[r2];
            r2 = r3;
        L_0x0184:
            r0 = r0 & 255;
            r0 = r0 << 2;
            r0 = r0 | r9;
            r3 = r10.tailLen;
            r2 = r3 - r2;
            r10.tailLen = r2;
            r2 = r4 + 1;
            r3 = r0 >> 12;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r4] = r3;
            r3 = r2 + 1;
            r4 = r0 >> 6;
            r4 = r4 & 63;
            r4 = r6[r4];
            r7[r2] = r4;
            r2 = r3 + 1;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r3] = r0;
            r0 = r10.do_padding;
            if (r0 == 0) goto L_0x0239;
        L_0x01af:
            r0 = r2 + 1;
            r3 = 61;
            r7[r2] = r3;
        L_0x01b5:
            r2 = r10.do_newline;
            if (r2 == 0) goto L_0x01cb;
        L_0x01b9:
            r2 = r10.do_cr;
            if (r2 == 0) goto L_0x01c4;
        L_0x01bd:
            r2 = r0 + 1;
            r3 = 13;
            r7[r0] = r3;
            r0 = r2;
        L_0x01c4:
            r2 = r0 + 1;
            r3 = 10;
            r7[r0] = r3;
            r0 = r2;
        L_0x01cb:
            r4 = r0;
            goto L_0x014c;
        L_0x01cd:
            r2 = r1 + 1;
            r0 = r11[r1];
            r1 = r2;
            r2 = r3;
            goto L_0x0175;
        L_0x01d4:
            r3 = r1 + 1;
            r0 = r11[r1];
            r1 = r3;
            goto L_0x0184;
        L_0x01da:
            r0 = r10.do_newline;
            if (r0 == 0) goto L_0x014c;
        L_0x01de:
            if (r4 <= 0) goto L_0x014c;
        L_0x01e0:
            r0 = 19;
            if (r5 == r0) goto L_0x014c;
        L_0x01e4:
            r0 = r10.do_cr;
            if (r0 == 0) goto L_0x0237;
        L_0x01e8:
            r0 = r4 + 1;
            r2 = 13;
            r7[r4] = r2;
        L_0x01ee:
            r4 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            goto L_0x014c;
        L_0x01f6:
            r0 = $assertionsDisabled;
            if (r0 != 0) goto L_0x0212;
        L_0x01fa:
            if (r1 == r8) goto L_0x0212;
        L_0x01fc:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0202:
            r0 = r8 + -1;
            if (r1 != r0) goto L_0x0218;
        L_0x0206:
            r0 = r10.tail;
            r2 = r10.tailLen;
            r3 = r2 + 1;
            r10.tailLen = r3;
            r1 = r11[r1];
            r0[r2] = r1;
        L_0x0212:
            r10.op = r4;
            r10.count = r5;
            r0 = 1;
            return r0;
        L_0x0218:
            r0 = r8 + -2;
            if (r1 != r0) goto L_0x0212;
        L_0x021c:
            r0 = r10.tail;
            r2 = r10.tailLen;
            r3 = r2 + 1;
            r10.tailLen = r3;
            r3 = r11[r1];
            r0[r2] = r3;
            r0 = r10.tail;
            r2 = r10.tailLen;
            r3 = r2 + 1;
            r10.tailLen = r3;
            r1 = r1 + 1;
            r1 = r11[r1];
            r0[r2] = r1;
            goto L_0x0212;
        L_0x0237:
            r0 = r4;
            goto L_0x01ee;
        L_0x0239:
            r0 = r2;
            goto L_0x01b5;
        L_0x023c:
            r0 = r1;
            goto L_0x009e;
        L_0x023f:
            r5 = r0;
            r4 = r1;
            r1 = r2;
            goto L_0x004e;
        L_0x0244:
            r5 = r2;
            r4 = r0;
            goto L_0x004e;
        L_0x0248:
            r5 = r2;
            goto L_0x004e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.util.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[((i2 * 3) / 4)]);
        if (!decoder.process(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (decoder.op == decoder.output.length) {
            return decoder.output;
        } else {
            byte[] bArr2 = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr2, 0, decoder.op);
            return bArr2;
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!encoder.do_padding) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            int i5;
            int i6 = ((i2 - 1) / 57) + 1;
            if (encoder.do_cr) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            i4 += i5 * i6;
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        if ($assertionsDisabled || encoder.op == i4) {
            return encoder.output;
        }
        throw new AssertionError();
    }

    private Base64() {
    }
}
