package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class Practice10HistogramView extends View{
    
    
    private int mWidth;
    private int mHeight;
    private int marginTop=20;
    private int marginBotom=80;
    private int marginLeft=100;
    private int gramGap=15;
    
    private int gramWidth=30;
    
    
    private Paint paint;
    
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event){
        super.onInitializeAccessibilityEvent(event);
    }
    
    public Practice10HistogramView(Context context){
        super(context);
    }
    
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        
        Path path=new Path();
        path.moveTo(marginLeft, marginTop);
        path.lineTo(marginLeft, mHeight - marginBotom);
        path.lineTo(mWidth, mHeight - marginBotom);
        canvas.drawPath(path, paint);
        
        
        int firstLeft=marginLeft + gramGap;
        int firstTop=mHeight - marginBotom - 15;
        int firstRight=firstLeft + gramWidth;
        int rectBottom=mHeight - marginBotom;
        
        
        Rect rectFirst=new Rect(firstLeft, firstTop, firstRight, rectBottom);
        
        Paint paintGram=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintGram.setStyle(Paint.Style.FILL);
        paintGram.setColor(Color.GREEN);
        
        
        canvas.drawRect(rectFirst, paintGram);
        
        
        int secondLeft=rectFirst.right + gramGap;
        int secondTop=mHeight - marginBotom - 20;
        int secondRight=secondLeft + gramWidth;
        int secondBotto=mHeight - marginBotom;
        
        Rect rectSecond=new Rect(secondLeft, secondTop, secondRight, secondBotto);
        canvas.drawRect(rectSecond, paintGram);
        
        int thirdLeft=rectSecond.right + gramGap;
        int thirdTop=mHeight - marginBotom - 35;
        int thirdRight=thirdLeft + gramWidth;
        int thirdBottom=mHeight - marginBotom;
        
        Rect thirdRect=new Rect(thirdLeft, thirdTop, thirdRight, thirdBottom);
        canvas.drawRect(thirdRect, paintGram);
        
        
        int fourthLeft=thirdRect.right + gramGap;
        int fourthTop=mHeight - marginBotom - 55;
        int fourthRight=fourthLeft + gramWidth;
        int fourthBottom=mHeight - marginBotom;
        
        Rect fourthRect=new Rect(fourthLeft, fourthTop, fourthRight, fourthBottom);
        canvas.drawRect(fourthRect, paintGram);
        
        
        int fifthLeft=fourthRect.right + gramGap;
        int fifthTop=mHeight - marginBotom - 80;
        int fifthRight=fifthLeft + gramWidth;
        int fifthBottom=mHeight - marginBotom;
        
        Rect fifthRect=new Rect(fifthLeft, fifthTop, fifthRight, fifthBottom);
        canvas.drawRect(fifthRect, paintGram);
        
        
        int sixthLeft=fifthRect.right + gramGap;
        int sixthTop=mHeight - marginBotom - 101;
        int sixthRight=sixthLeft + gramWidth;
        int sixthBottom=mHeight - marginBotom;
        
        Rect sixthRect=new Rect(sixthLeft, sixthTop, sixthRight, sixthBottom);
        canvas.drawRect(sixthRect, paintGram);
        
        int seventhLeft=sixthRect.right + gramGap;
        int seventhTop=mHeight - marginBotom - 92;
        int seventhRight=seventhLeft + gramWidth;
        int seventhBottom=mHeight - marginBotom;
        
        Rect seventhRect=new Rect(seventhLeft, seventhTop, seventhRight, seventhBottom);
        canvas.drawRect(seventhRect, paintGram);
        
        
        Paint paintBottom=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBottom.setStyle(Paint.Style.STROKE);
        paintBottom.setColor(Color.WHITE);
        paintBottom.setTextSize(20);
        
        Paint paintRect=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRect.setStyle(Paint.Style.STROKE);
        paintRect.setColor(Color.WHITE);
        paintRect.setTextSize(10);
        
        canvas.drawText("Froyo", rectFirst.left, rectBottom + 10, paintRect);
        canvas.drawText("CB", rectSecond.left, rectBottom + 10, paintRect);
        canvas.drawText("CS", thirdRect.left, rectBottom +10, paintRect);
        canvas.drawText("JB", fourthRect.left, rectBottom + 10, paintRect);
        canvas.drawText("LLL", fifthRect.left, rectBottom +10, paintRect);
        canvas.drawText("LenVo", sixthRect.left, rectBottom +10, paintRect);
        canvas.drawText("HeLLO", seventhRect.left, rectBottom +10, paintRect);
        
        canvas.drawText("直方图", mWidth / 2, mHeight - 10, paintBottom);
    }
}
