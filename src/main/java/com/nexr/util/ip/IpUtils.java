package com.nexr.util.ip;

import org.jetbrains.annotations.NotNull;

/**
 * Create by lucy on 2020-04-19
 **/
interface IP extends Comparable<IP> {
//    @NotNull
//    IP getHighestBinary();
    int getMaxPrefix();

//    @NotNull
//    IP and(@NotNull IP var1);
//
//    @NotNull
//    IP or(@NotNull IP var1);
//
//    @NotNull
//    IP shl(int var1);
//
//    @NotNull
//    IP ushr(int var1);
}


final class IPv6 implements IP {

    public int getMaxPrefix() {
        return 128;
    }

    @Override
    public int compareTo(@NotNull IP o) {
        return 0;
    }

//    public int compareTo(@NotNull IPv6 other) {
//        Intrinsics.checkParameterIsNotNull(other, "other");
//        int high = Long.compareUnsigned(this.highBits, other.highBits);
//        return high != 0 ? high : Long.compareUnsigned(this.lowBits, other.lowBits);
//    }
//
//    public int compareTo(Object var1) {
//        return this.compareTo((IPv6)var1);
//    }

}