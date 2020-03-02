package ru.azat.xapexample;

import ru.azat.xapexample.model.Event;

import java.util.Arrays;
import java.util.UUID;

import org.openspaces.core.GigaSpace;

import com.j_spaces.core.LeaseContext;

import static ru.azat.xapexample.Utils.getGigaSpace;

public class WriterToGigaSpace {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                GigaSpace space = getGigaSpace("/./simple-space?schema=default&groups=xap-15.2.0&state=started");

                for (int i = 0; i < 100; i++) {
                    Event event = new Event(UUID.randomUUID(), "Hello " + i);
                    LeaseContext<Event> context = space.write(event);
                    System.out.println("write - " + event);
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
