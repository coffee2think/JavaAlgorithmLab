package dev.coffee2think.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
public class QueueBenchmark {

    @Benchmark
    public Integer arrayDeque() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        return queue.poll();
    }

    @Benchmark
    public Integer linkedList() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        return queue.poll();
    }
}
