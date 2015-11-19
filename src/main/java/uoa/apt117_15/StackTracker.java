package uoa.apt117_15;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StackTracker {
    boolean pushInUse = false;
    boolean popInUse = false;
    boolean topInUse = false;

    @Pointcut("call(void push(int)) && args(element)")
    void pointcutInPush(int element) {
    }

    @Pointcut("call(int pop())")
    void pointcutInPop() {
    }

    @Pointcut("call(int top())")
    void pointcutInTop() {
    }

    @Around("pointcutInPush(element)")
    public void aroundPush(ProceedingJoinPoint point, int element) {
        try {
             synchronized(this) {
                while (pushInUse || popInUse || topInUse) {
                    this.wait();
                }
                pushInUse = true;
                point.proceed();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Around("pointcutInPop()")
    public int aroundPop(ProceedingJoinPoint point) {
        try {
            synchronized (this) {
                while (pushInUse || popInUse || topInUse) {
                    this.wait();
                }

                popInUse = true;
                return Integer.parseInt(point.proceed().toString());
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

    @Around("pointcutInTop()")
    public int aroundTop(ProceedingJoinPoint point) {
        try {
            synchronized (this) {
                while (pushInUse || popInUse) {
                    this.wait();
                }
                topInUse = true;
                return Integer.parseInt(point.proceed().toString());
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

    @After("pointcutInPush(int)")
    synchronized public void afterPush() {
        if (pushInUse)
            pushInUse = false;
        notifyAll();
    }

    @After("call(int pop())")
    synchronized public void afterPop() {
        if (popInUse)
            popInUse = false;
        notifyAll();
    }

    @After("call(int top())")
    synchronized public void afterTop() {
        if (topInUse)
            topInUse = false;
        notifyAll();
    }
}