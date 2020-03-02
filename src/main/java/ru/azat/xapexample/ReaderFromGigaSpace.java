package ru.azat.xapexample;

import ru.azat.xapexample.model.Event;

import java.util.Arrays;

import org.openspaces.core.GigaSpace;

import com.gigaspaces.client.ReadByIdsResult;

import static ru.azat.xapexample.Utils.getGigaSpace;

public class ReaderFromGigaSpace {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                GigaSpace space = getGigaSpace("jini://*/*/myGrid?groups=You_Can_Wipe_This&ignoreValidation=true&total_members=2,1&cluster_schema=partitioned-sync2backup&id=2&schema=default&state=started");

                for (int i = 0; i < 100; i++) {
                    int count = space.count(new Event());
                    System.out.println(count);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
