package com.yxna.onelove.views.dialog.pic;

/**
 * created by sws on 2020/4/2
 */
public class LocalMediaBean {

    public String path;

    public String fileName;

    public String compressPath;

    public String cutPath;

    public LocalMediaBean() {

    }

    @Override
    public String toString() {
        return "LocalMediaBean{" + "path='" + path + '\'' + ", fileName='" + fileName + '\'' + "," +
                " compressPath='" + compressPath + '\'' + ", cutPath='" + cutPath + '\'' + '}';
    }
}
