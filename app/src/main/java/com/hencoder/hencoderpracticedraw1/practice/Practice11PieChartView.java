package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.PieChartData;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View{
    
    
    public static String TAG="Practice11PieChartView";
    
    /**
     * 宽高位置变量
     */
    private int mWidth;
    private int mHeight;
    private int marginBottom=15;
    
    /**
     * model 变量+draw过程中的变量
     */
    private float totalNumber=0.0f;
    private float maxNumber=0.0f;//计算最大的值;
    private float startAngle=0.0f;
    private float sweapAngle=0.0f;
    private float halfAngle=0.0f;
    private float radius;//半径，正方形的半径 圆的半径;
    private RectF rectF;//画圆的矩形
    
    private float lineStartX=0;
    private float lineStartY=0;
    private float lineEndX=0;
    private float lineEndY=0;
    
    private int BOTTOM_TEXT_SIZE=28;
    private String BOTTOM_TEXT="饼图";
    
    private Paint paint;
    private List<PieChartData> listData;
    
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
    
    
    public Practice11PieChartView(Context context){
        super(context);
        init();
    }
    
    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        listData=new ArrayList<>();
        
        listData.add(new PieChartData(Color.BLUE, "Fyoyo", 15.0f));
        listData.add(new PieChartData(Color.GREEN, "Griddheand", 13.0f));
        listData.add(new PieChartData(Color.GRAY, "ICE sandWich", 78.0f));
        
        listData.add(new PieChartData(Color.YELLOW, "ICE JellyBean", 95.0f));
        
        listData.add(new PieChartData(Color.DKGRAY, "KIKKKK", 105.0f));
        listData.add(new PieChartData(Color.BLUE, "LOOOPPPP", 103.0f));
        listData.add(new PieChartData(Color.RED, "Mashollow", 82.0f));
        
        
        for (PieChartData pieChartData : listData) {
            totalNumber+=pieChartData.getNumber();
            maxNumber=Math.max(maxNumber, pieChartData.getNumber());
        }
        
    }
    
    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }
    
    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        drawBottomText(canvas);
        traslateCanvanceToCenter(canvas);
        caclulateRectAndRadius(canvas);
        int listNumber=listData.size();
        for (int i=0; i < listNumber; i++) {
            PieChartData temData=listData.get(i);
            setupPaintByPieChartData(temData);
            calculateSweapAngle(temData);
            calculateLinePoint();
            if (temData.getNumber() == maxNumber) {
                canvas.save();
                traslateAlittleCanvance(canvas);
                canvas.drawArc(rectF, startAngle, sweapAngle - 1.0f, true, paint);
                canvas.restore();
            }else {
                canvas.drawArc(rectF, startAngle, sweapAngle - 1.0f, true, paint);
            }
            
            
            startAngle+=sweapAngle;
            
            
        }
        
    }
    
    private void calculateSweapAngle(PieChartData temData){
        sweapAngle=temData.getNumber() / totalNumber * 360f;
    }
    
    private void traslateAlittleCanvance(Canvas canvas){
        canvas.translate(0.1f * lineStartX, 0.1f * lineEndY);
    }
    
    private void calculateLinePoint(){
        halfAngle=startAngle + sweapAngle / 2;
        lineStartX=radius * new Double(Math.cos(halfAngle * Math.PI / 180)).floatValue();
        lineStartY=radius * new Double(Math.sin(halfAngle * Math.PI / 180)).floatValue();
        
        Log.i(TAG, "linestartX is " + lineStartX + "    lineStartY is  " + lineStartY);
    }
    
    private void caclulateRectAndRadius(Canvas canvas){
        radius=canvas.getWidth() * 0.3f;
        rectF=new RectF(-radius, -radius, radius, radius);
    }
    
    private void traslateCanvanceToCenter(Canvas canvas){
        int centHeightY=(canvas.getHeight() - marginBottom) / 2;
        canvas.translate(canvas.getWidth() / 2, centHeightY);
    }
    
    
    public void setupPaintByPieChartData(PieChartData data){
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        paint.setColor(data.getColor());
    }
    
    
    private void drawBottomText(Canvas canvas){
        int bottomTextX=mWidth / 2 - new Float(paint.measureText(BOTTOM_TEXT)).intValue();
        int bottomTextY=mHeight - marginBottom;
        paint.setColor(Color.WHITE);
        paint.setTextSize(BOTTOM_TEXT_SIZE);
        canvas.drawText(BOTTOM_TEXT, bottomTextX, bottomTextY, paint);
    }
    
    
}
