package com.tranhuyson.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCanvas extends View   {
    Paint mPaintPoints;
    Paint mPaintLines;
    Paint mPaintText;
    Paint mPainLine2;
    List<String> mListData;




    public void getData(List<String> mListGraphDay){
        this.mListData=mListGraphDay;
      invalidate();
    }
    public TestCanvas(Context context) {
        super(context);
        init();
    }

    public TestCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public TestCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaintPoints = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintPoints.setColor(getResources().getColor(R.color.colorAccent));
        mPaintPoints.setStrokeWidth(15);

        mPaintLines = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLines.setColor(getResources().getColor(R.color.colorPrimary));
        mPaintLines.setStrokeWidth(10);

        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setColor(Color.parseColor("#000000"));
        mPaintText.setTextSize(50);

        mPainLine2=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPainLine2.setColor(Color.parseColor("#000000"));
        mPainLine2.setStrokeWidth(5);



    }

    //    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawArc(100,100,400,300,30,315,true,mPaint);
//    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mListData == null) return;
       String [] a=mListData.toArray(new String[mListData.size()]);
       String stime=String.valueOf(a[0]);
        String stime1=String.valueOf(a[2]);
        String stime2=String.valueOf(a[4]);
        String stime3=String.valueOf(a[6]);
        String stime4=String.valueOf(a[8]);
        String stime5=String.valueOf(a[10]);
        String stime6=String.valueOf(a[12]);
        int iTemp=Integer.parseInt(String.valueOf(a[1]));
        int yTemp=1200-(iTemp*20);
        int iTemp1=Integer.parseInt(String.valueOf(a[3]));
        int yTemp1=1200-(iTemp1*20);
        int iTemp2=Integer.parseInt(String.valueOf(a[5]));
        int yTemp2=1200-(iTemp2*20);
        int iTemp3=Integer.parseInt(String.valueOf(a[7]));
        int yTemp3=1200-(iTemp3*20);
        int iTemp4=Integer.parseInt(String.valueOf(a[9]));
        int yTemp4=1200-(iTemp4*20);
        int iTemp5=Integer.parseInt(String.valueOf(a[11]));
        int yTemp5=1200-(iTemp5*20);
        int iTemp6=Integer.parseInt(String.valueOf(a[13]));
        int yTemp6=1200-(iTemp6*20);




        //time
//        time0=new SimpleDateForm
//        at("dd/MM").format(new Date(MainActivity.))

        float[] temp = {100, 100, 100, 1200};
        float[] time = {100, 1200, 900, 1200};
        canvas.drawLines(temp, mPainLine2);
        canvas.drawLines(time, mPainLine2);
        canvas.drawText("ºC", 15, 80, mPaintText);
        canvas.drawText("O", 32, 1200, mPaintText);
        canvas.drawText("Time", 860, 1300, mPaintText);
        //ºC
        canvas.drawLine(80, 200, 120, 200, mPainLine2);
        canvas.drawLine(80, 400, 120, 400, mPainLine2);
        canvas.drawLine(80, 600, 120, 600, mPainLine2);
        canvas.drawLine(80, 800, 120, 800, mPainLine2);
        canvas.drawLine(80, 1000, 120, 1000, mPainLine2);
        canvas.drawText("50", 15, 220, mPaintText);
        canvas.drawText("40", 15, 420, mPaintText);
        canvas.drawText("30", 15, 620, mPaintText);
        canvas.drawText("20", 15, 820, mPaintText);
        canvas.drawText("10", 15, 1020, mPaintText);
        //Time
        canvas.drawText(stime, 165, 1270, mPaintText);
        canvas.drawLine(200, 1180, 200, 1220, mPainLine2);
        canvas.drawText(stime1, 265, 1270, mPaintText);
        canvas.drawLine(300, 1180, 300, 1220, mPainLine2);
        canvas.drawText(stime2, 365, 1270, mPaintText);
        canvas.drawLine(400, 1180, 400, 1220, mPainLine2);
        canvas.drawText(stime3, 465, 1270, mPaintText);
        canvas.drawLine(500, 1180, 500, 1220, mPainLine2);
        canvas.drawText(stime4, 565, 1270, mPaintText);
        canvas.drawLine(600, 1180, 600, 1220, mPainLine2);
        canvas.drawText(stime5, 665, 1270, mPaintText);
        canvas.drawLine(700, 1180, 700, 1220, mPainLine2);
        canvas.drawText(stime6, 765, 1270, mPaintText);
        canvas.drawLine(800, 1180, 800, 1220, mPainLine2);







        //tinh toan
//        canvas.drawPoint(300,640,mPaintPoints);
//        canvas.drawPoint(400,540,mPaintPoints);
//        canvas.drawPoint(500,520,mPaintPoints);
//        canvas.drawPoint(600,560,mPaintPoints);
//        canvas.drawPoint(700,500,mPaintPoints);
//        canvas.drawPoint(800,500,mPaintPoints);
//        canvas.drawPoint(900,520,mPaintPoints);
        float[] tempDayPoints={200,yTemp,300,yTemp1,400,yTemp2,500,yTemp3,600,yTemp4,700,yTemp5,800,yTemp6};
        canvas.drawPoints(tempDayPoints,mPaintPoints);
        float[]tempDayLines={200,yTemp,300,yTemp1,300,yTemp1,400,yTemp2,400,yTemp2,500,yTemp3,500,yTemp3,600,yTemp4,600,yTemp4,700,yTemp5,700,yTemp5,800,yTemp6};
        canvas.drawLines(tempDayLines,mPaintLines);


    }

}
