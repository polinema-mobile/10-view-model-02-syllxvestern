package id.putraprima.mvvmlogin.models;

import android.widget.Space;

public class Splash {
    public int imageSplash;
    public String textSplash;

    public Splash() {
    }

    public Splash(int i, String s) {
        this.imageSplash=imageSplash;
        this.textSplash=textSplash;
    }

    public int getImageSplash() {
        return imageSplash;
    }

    public void setImageSplash(int imageSplash) {
        this.imageSplash = imageSplash;
    }

    public String getTextSplash() {
        return textSplash;
    }

    public void setTextSplash(String textSplash) {
        this.textSplash = textSplash;
    }
}
