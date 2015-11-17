package uoa.apt117_15;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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
            while (pushInUse || popInUse || topInUse) {
                Thread.sleep(100);
            }
            pushInUse = true;
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Around("pointcutInPop()")
    public int aroundPop(ProceedingJoinPoint point) {
        try {
            while (pushInUse || popInUse || topInUse) {
                Thread.sleep(100);
            }
            popInUse = true;
            return Integer.parseInt(point.proceed().toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

    @Around("pointcutInTop()")
    public int aroundTop(ProceedingJoinPoint point) {
        try {
            while (pushInUse || popInUse) {
                Thread.sleep(100);
            }
            topInUse = true;
            return Integer.parseInt(point.proceed().toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

    @After("pointcutInPush(int)")
    public void afterPush() {
        if (pushInUse)
            pushInUse = false;
    }

    @After("call(int pop())")
    public void afterPop() {
        if (popInUse)
            popInUse = false;
    }

    @After("call(int top())")
    public void afterTop() {
        if (topInUse)
            topInUse = false;
    }
}