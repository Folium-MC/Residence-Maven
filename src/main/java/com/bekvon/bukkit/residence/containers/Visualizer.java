package com.bekvon.bukkit.residence.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bekvon.bukkit.residence.utils.ResScheduler;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.CuboidArea;

public class Visualizer {
    private Player player;
    private long start;
    private List<CuboidArea> areas = new ArrayList<CuboidArea>();
    private List<CuboidArea> errorAreas = new ArrayList<CuboidArea>();
    private ScheduledTask id = null;
    private ScheduledTask errorId = null;
    private ScheduledTask baseShedId = null;
    private boolean once = false;
    private int starting = 0;
    private int currentSkip = 0;

    private List<Location> locations = new ArrayList<Location>();
    private List<Location> errorLocations = new ArrayList<Location>();
    private List<Location> locations2 = new ArrayList<Location>();
    private List<Location> errorLocations2 = new ArrayList<Location>();
    private Location loc = null;

    public Visualizer(Player player) {
	this.player = player;
	this.start = System.currentTimeMillis();
    }

    public void cancelAll() {
	if (id != null) {
	    ResScheduler.cancelTask(id);
	}
	if (errorId != null) {
	    ResScheduler.cancelTask(errorId);
	}
	if (baseShedId != null) {
	    ResScheduler.cancelTask(baseShedId);
	}
    }

    public boolean isSameLoc() {
	if (loc == null)
	    return false;
	if (loc.getWorld() != player.getWorld())
	    return false;
	if (!errorAreas.isEmpty() && errorLocations.isEmpty())
	    return false;
	if (loc.distance(player.getLocation()) > 1)
	    return false;

	return true;
    }

    public long getStart() {
	return start;
    }

    public void setStart(long start) {
	this.start = start;
    }

    public Player getPlayer() {
	return player;
    }

    public void setPlayer(Player player) {
	this.player = player;
    }

    public List<CuboidArea> getAreas() {
	return areas;
    }

    public void setAreas(ClaimedResidence res) {
	if (res != null)
	    this.areas = Arrays.asList(res.getAreaArray());
    }

    public void setAreas(CuboidArea[] areas) {
	this.areas = Arrays.asList(areas);
    }

    public void setAreas(ArrayList<CuboidArea> areas) {
	this.areas = areas;
    }

    public void setAreas(CuboidArea area) {
	areas = new ArrayList<CuboidArea>();
	this.areas.add(area);
    }

    public List<CuboidArea> getErrorAreas() {
	return errorAreas;
    }

    public void setErrorAreas(ClaimedResidence res) {
	if (res != null)
	    this.errorAreas = Arrays.asList(res.getAreaArray());
    }

    public void setErrorAreas(CuboidArea[] errorAreas) {
	this.errorAreas = Arrays.asList(errorAreas);
    }

    public void setErrorAreas(ArrayList<CuboidArea> errorAreas) {
	this.errorAreas = errorAreas;
    }

    public void setErrorAreas(CuboidArea errorArea) {
	this.errorAreas.add(errorArea);
    }

    public ScheduledTask getId() {
	return id;
    }

    public void setId(ScheduledTask id) {
	this.id = id;
    }

    public ScheduledTask getErrorId() {
	return errorId;
    }

    public void setErrorId(ScheduledTask errorId) {
	this.errorId = errorId;
    }

    public boolean isOnce() {
	return once;
    }

    public void setOnce(boolean once) {
	this.once = once;
    }

    public List<Location> getLocations() {
	return locations;
    }

    public void setLocations(List<Location> locations) {
	this.locations = locations;
    }

    public List<Location> getLocations2() {
	return locations2;
    }

    public void setLocations2(List<Location> locations) {
	this.locations2 = locations;
    }

    public List<Location> getErrorLocations() {
	return errorLocations;
    }

    public void setErrorLocations(List<Location> errorLocations) {
	this.errorLocations = errorLocations;
    }

    public List<Location> getErrorLocations2() {
	return errorLocations2;
    }

    public void setErrorLocations2(List<Location> errorLocations) {
	this.errorLocations2 = errorLocations;
    }

    public Location getLoc() {
	return loc;
    }

    public void setLoc(Location loc) {
	this.loc = loc;
    }

    public int getStarting() {
	return starting;
    }

    public void setStarting(int starting) {
	this.starting = starting;
    }

    public ScheduledTask getBaseShedId() {
	return baseShedId;
    }

    public void setBaseShedId(ScheduledTask baseShedId) {
	this.baseShedId = baseShedId;
    }

    public int getCurrentSkip() {
	return currentSkip;
    }

    public void setCurrentSkip(int currentSkip) {
	this.currentSkip = currentSkip;
    }

    public void addCurrentSkip() {
	this.currentSkip++;
    }
}
