package com.tm.states;

import com.koloboke.collect.map.hash.HashObjIntMaps;
import com.koloboke.collect.set.hash.HashObjSets;
import com.tm.model.Order;
import com.tm.repository.CollectionRepository;
import com.tm.repository.InMemoryRepository;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by tudor.maier on 30/10/2017.
 */
public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
//    HASH_SET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(HashSet::new);
//        }
//    },
//
//    TREE_SET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(TreeSet::new);
//        }
//    },
//
    ARRAY_LIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(ArrayList::new);
        }
    },
//
//    CONCURRENT_HASH_MAP() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new CollectionRepository<>(() -> Collections.newSetFromMap(new ConcurrentHashMap<Order, Boolean>()));
//        }
//    },
//
//    KOLOBOKE_HASHSET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            Set<Order> set = HashObjSets.newMutableSet();
//            return new CollectionRepository<>(() -> Collections.synchronizedSet(set));
//        }
//    },

    ECLIPSE_COLLECTIONS_MLIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new CollectionRepository<>(FastList::new);
        }
    }
}
