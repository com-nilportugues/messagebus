package com.nilportugues.messagebus.di;

public interface IBeanProvider<T> {
    T get(final String beanName);
}
