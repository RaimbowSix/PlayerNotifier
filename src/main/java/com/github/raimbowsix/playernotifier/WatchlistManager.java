package com.github.raimbowsix.playernotifier;

import java.io.*;
import java.util.*;

public class WatchlistManager
{
    private static final File file;
    private static final HashSet<String> enemies;

    public static void loadWatchlist() {
        WatchlistManager.enemies.clear();
        if (!WatchlistManager.file.exists()) {
            try {
                WatchlistManager.file.getParentFile().mkdirs();
                WatchlistManager.file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(WatchlistManager.file));
            String line;
            while ((line = reader.readLine()) != null) {
                WatchlistManager.enemies.add(line.trim().toLowerCase());
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveWatchlist() {
        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(WatchlistManager.file));
            for (final String name : WatchlistManager.enemies) {
                writer.write(name);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addEnemy(final String name) {
        final boolean added = WatchlistManager.enemies.add(name.toLowerCase());
        if (added) {
            saveWatchlist();
        }
        return added;
    }

    public static boolean removeEnemy(final String name) {
        final boolean removed = WatchlistManager.enemies.remove(name.toLowerCase());
        if (removed) {
            saveWatchlist();
        }
        return removed;
    }

    public static boolean isEnemy(final String name) {
        return WatchlistManager.enemies.contains(name.toLowerCase());
    }

    public static HashSet<String> getEnemies() {
        return new HashSet<String>(WatchlistManager.enemies);
    }

    static {
        file = new File("config/watchlist.txt");
        enemies = new HashSet<String>();
    }
}
