package org.practise.topinterview150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class LC_380 {

    private HashSet<Integer> randomizedSet;
    public LC_380() {
        randomizedSet = new HashSet<>();
    }

    public static void main(String[] args) {

    }

    public boolean insert(int val) {
        if(!randomizedSet.contains(val)) {
            randomizedSet.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(randomizedSet.contains(val)) {
            randomizedSet.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(randomizedSet);
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
