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
                GigaSpace space = getGigaSpace("/./simple-space?schema=default&groups=xap-15.2.0&state=started");

                for (int i = 0; i < 1000; i++) {
                    ReadByIdsResult<Event> results = space.readByIds(Event.class, new Long[]{1L, 2L, (long) i});
                    System.out.println("read - " + Arrays.toString(results.getResultsArray()));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
