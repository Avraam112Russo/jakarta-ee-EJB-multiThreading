package com.example.ejbexample;

import jakarta.ejb.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
@Lock(LockType.WRITE)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER) // default value - container // bean -> manually handling multithreading
@AccessTimeout(value = 20, unit = TimeUnit.SECONDS)//automatic unblock resource after 20 seconds
public class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int increment(){
        return count++;
    }
}
