package com.clock.harvic.blogwonderfulview;

public class PieChartBean {

    private int color;
    private float percentage;

    public PieChartBean(int color, float percentage) {
        this.color = color;
        this.percentage = percentage;
    }

    public int getColor() {
        return this.color;
    }

    public float getPercentage() {
        return this.percentage;
    }

}
