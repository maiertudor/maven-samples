package com.tm;

import com.tm.model.Order;
import com.tm.states.RepositoryState;
import com.tm.states.SizeState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by tudor.maier on 31/10/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 20, time = 1)
@Fork(2)
public class TestRemove {

    @State(Scope.Benchmark)
    public static class AfterState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepositoryState repoState) {
            repoState.orders.add(order);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepositoryState repoState) {
            repoState.orders.add(order);
        }
    }

    @Benchmark
    public boolean remove_existing(RepositoryState repoState, TestRemove.ExistingState existing) {
        return repoState.orders.remove(existing.order);
    }

    @Benchmark
    public boolean remove_after(RepositoryState repoState, TestRemove.AfterState after) {
        return repoState.orders.remove(after.order);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestAdd.class.getSimpleName() + ".*")
                .build();

        new Runner(opt).run();
    }
}
