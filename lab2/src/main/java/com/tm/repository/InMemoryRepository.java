package com.tm.repository;

/**
 * Created by tudor.maier on 17/10/2017.
 */
public interface InMemoryRepository<T> {
    boolean add(T obj);

    boolean contains(T obj);

    boolean remove(T obj);

    void clear();
}
