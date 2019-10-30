package com.example.preloved;

import java.util.ArrayList;

public class PrelovedData {
    public static String[][] data = new String[][]{
            {"Kimora Outer Geo Borders", "Outer", "http://static.id.zalora.net/p/just-jo-design-8899-1007091-1.jpg", "Kardigan desain kimono dengan detail motif bunga", "ONE SIZE", "Navy", "Rp. 441.000"},
            {"Lace Up A-Line Mini Skirt ", "Skirt", "http://static.hk.zalora.net/p/something-borrowed-1571-3856305-1.jpg", "Solid toned mini skirt with lace up details", "M", "Maroon", "Rp. 71.000"},
            {"Classic Boat Neck Knit Top", "Top", "http://static.ph.zalora.net/p/tokichoi-2635-9363321-1.jpg", "Solid shade long sleeves top", "L", "White", "Rp. 171.000"},
            {"Tribal Skirt", "Skirt", "https://cdna.lystit.com/photos/96c3-2013/12/27/hm-black-pencil-skirt-product-1-16447151-0-512733347-normal.jpeg", "Women's tribal skirt details", "Ukuran 32", "Black", "Rp. 30.000"}
//            {"Petite Superstretch Mini Skirt", "Skirt", "http://static.sg.zalora.net/p/missguided-6469-3294301-1.jpg"},
//            {"Woven Laurie Long Sleeve V-Neck Playsuit", "Playsuit", "http://static.id.zalora.net/p/cotton-on-1451-3328671-1.jpg"}
    };

    public static ArrayList<Preloved> getListData() {
        Preloved preloved = null;
        ArrayList<Preloved> list = new ArrayList<>();
        for (String[] aData : data) {
            preloved = new Preloved();
            preloved.setName(aData[0]);
            preloved.setRemarks(aData[1]);
            preloved.setPhoto(aData[2]);
            preloved.setDescription(aData[3]);
            preloved.setSize(aData[4]);
            preloved.setWarna(aData[5]);
            preloved.setHarga(aData[6]);

            list.add(preloved);
        }

        return list;
    }
}