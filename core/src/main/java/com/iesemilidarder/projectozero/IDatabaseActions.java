package com.iesemilidarder.projectozero;

import java.util.List;

/**
 * zeroproject
 * com.iesemilidarder.projectozero
 * Create by winadmin in 19/1/2018.
 * Description:
 */
public interface IDatabaseActions {
    public void save();
    public void delete();
    public void update();
    public List<DBObject> getAll();
}