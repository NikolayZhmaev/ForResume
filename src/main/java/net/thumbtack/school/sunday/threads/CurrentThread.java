package net.thumbtack.school.sunday.threads;

// 1. Напечатать все свойства текущего потока

public class CurrentThread {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        System.out.println("thread = " + thread);
        System.out.println("thread Id = " + thread.getId());
        System.out.println("thread Name = " + thread.getName());
        System.out.println("thread Priority = " + thread.getPriority());
        System.out.println("thread State = " + thread.getState());
        System.out.println("thread ThreadGroup = " + thread.getThreadGroup());
        System.out.println("thread StackTrace = " + thread.getStackTrace());
        System.out.println("thread isAlive = " + thread.isAlive());
        System.out.println("thread isDaemon = " + thread.isDaemon());
        System.out.println("thread isInterrupted = " + thread.isInterrupted());
        System.out.println("thread ContextClassLoader = " + thread.getContextClassLoader());
    }
}
