package com.gildedgames.the_aether.items.util;

public enum EnumDungeonKeyType {
    Bronze(0, "bronze"),
    Silver(1, "silver"),
    Golden(2, "golden");

    private int meta;

    private String name;

    EnumDungeonKeyType(int meta, String name) {
        this.meta = meta;
        this.name = name;
    }

    public static EnumDungeonKeyType getType(int meta) {
        return meta == 1 ? Silver : meta == 2 ? Golden : Bronze;
    }

    public int getMeta() {
        return this.meta;
    }

    public String toString() {
        return this.name;
    }
}