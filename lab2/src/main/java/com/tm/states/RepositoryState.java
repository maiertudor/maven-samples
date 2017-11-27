package com.tm.states;

import com.tm.model.Order;
import com.tm.repository.InMemoryRepository;
import org.openjdk.jmh.annotations.*;

import java.util.stream.IntStream;

/**
 * Created by tudor.maier on 30/10/2017.
 */
@State(Scope.Benchmark)
public class RepositoryState {
    @Param
    private RepositorySupplier repositorySupplier;

    public InMemoryRepository<Order> orders;

    /* run before each benchmark */
    @Setup
    public void setUp(SizeState sizeState) {
        System.out.println(getClass().getSimpleName() + " > setup > populate");
        orders = repositorySupplier.get();

        IntStream.rangeClosed(1, sizeState.size)
                .mapToObj(Order::new)
                .forEach(orders::add);
    }

    /* run after each benchmark */
    @TearDown
    public void tearDown() {
        System.out.println(getClass().getSimpleName() + " > teardown > clear");
        orders.clear();
        System.gc();
    }
}
