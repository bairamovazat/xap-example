package ru.azat.xapexample;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.EmbeddedSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

public class Utils {

    public static GigaSpace getGigaSpace(String spaceUrl) {
        return new GigaSpaceConfigurer(new UrlSpaceConfigurer(spaceUrl)).gigaSpace();
    }

}
