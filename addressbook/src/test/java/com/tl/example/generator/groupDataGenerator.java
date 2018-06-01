package com.tl.example.generator;

import com.tl.example.model.GroupData;

import java.io.File;
import java.util.List;

public class groupDataGenerator {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData> groups = generateGroups(count);

        save(groups, file);
    }
}
