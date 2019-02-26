package com.example.michael.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.Scroller;

public class TestView extends ViewGroup implements GestureDetector.OnGestureListener {
    private static final int OFFSET = 0;
    GestureDetector mGestureDetector = new GestureDetector(this);
    Scroller scroller = new Scroller(getContext());
    OverScroller overScroller = new OverScroller(getContext());
    Paint paint = new Paint();
    Bitmap bitmap;
    VelocityTracker mVelocityTracker;

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {

        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGestureDetector.onTouchEvent(event);
                return true;
            }
        });
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        // mVelocityTracker = VelocityTracker.obtain();
        // smoothScrollTo(-300, -700);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

 /*   @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);

        if (event.getAction() == MotionEvent.ACTION_UP) {

            mVelocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) mVelocityTracker.getXVelocity();
            int yVelocity = (int) mVelocityTracker.getYVelocity();

            scroller.fling(getScrollX(), getScrollY(),
                    -xVelocity, -yVelocity, -getMeasuredWidth(), 0, -getMeasuredHeight(), 0);
            invalidate();
        }
        return true;
    }

*/
    /* @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            left = i * OFFSET;
            right = left + child.getMeasuredWidth();
            bottom = top + child.getMeasuredHeight();

            child.layout(left, top, right, bottom);

            top += child.getMeasuredHeight();
        }
    }*/

  /*  @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            ViewGroup.LayoutParams lp = child.getLayoutParams();
            int childWidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, lp.width);
            int childHeightSpec = getChildMeasureSpec(heightMeasureSpec, 0, lp.height);
            child.measure(childWidthSpec, childHeightSpec);
            // measureChildWithMargins(child, childWidthSpec, 0, childHeightSpec, 0);
        }

        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);

                    int widthAddOffset = i * OFFSET + child.getMeasuredWidth();
                    width = Math.max(width, widthAddOffset);
                }
                break;
            default:
                break;

        }

        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);
                    height = height + child.getMeasuredHeight();
                }
                break;
            default:
                break;

        }

        setMeasuredDimension(width, height);

    }
*/
/*
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return new MarginLayoutParams(lp);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
*/

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), paint);

    }

    // 缓慢滚动到指定位置
    private void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        int scrollY = getScrollY();
        int deltaY = destY - scrollY;
        scroller.startScroll(scrollX, scrollY, deltaX, deltaY, 2000); //从当前xy到目标xy

        invalidate();   //使View重绘
    }

    @Override
    public void computeScroll() {  //draw方法中又会去调用
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());  //实现滑动
            postInvalidate();  //第二次重绘,重绘再调用computeScroll
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {

        // scrollBy(-50, -500);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("gads", "press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("gads", "ontapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("gads", "scroll");
        scrollBy((int) distanceX, (int) distanceY);
        //scrollTo((int) (e2.getX() - e1.getX()), (int) (e2.getY() - e1.getY()));
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("gads", "longpress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("gads", "fling");
        if (velocityX < 1 && velocityY < 1) {
            return false;
        }

        scroller.fling(getScrollX(), getScrollY(),
                (int) -velocityX, (int) -velocityY, -getMeasuredWidth(), 0, -getMeasuredHeight(), 0);
        invalidate();
        return false;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        getChildAt(0).setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.startDrag(null, new DragShadowBuilder(v), v, 0);

                return false;
            }
        });
        getChildAt(0).setOnDragListener(new OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });
    }
}
