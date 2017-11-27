package com.tm.repository;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * Created by tudor.maier on 30/10/2017.
 */
public class CollectionRepository<T> implements InMemoryRepository<T> {

    private final Collection<T> delegate;

    public CollectionRepository(Supplier<? extends Collection<T>> supplier) {
        this.delegate = supplier.get();
    }

    @Override
    public boolean add(T obj) {
        return delegate.add(obj);
    }

    @Override
    public boolean contains(T obj) {
        return delegate.contains(obj);
    }

    @Override
    public boolean remove(T obj) {
        return delegate.remove(obj);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    public int size() {
        return delegate.size();
    }

    @Override
    public String toString() {
        return String.valueOf(delegate);
    }

    protected Collection<T> getDelegate() {
        return delegate;
    }
}
