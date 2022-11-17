package dev.ztech.vanadium.events;

import java.util.ArrayList;

public class Event {
    public Event call(){
        final ArrayList<EventData> dataList = EventManager.get(this.getClass());

        if(dataList != null){
            for(EventData data : dataList){
                try {
                    data.target.invoke(data.source,this);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
    public Event call(Object o){
        final ArrayList<EventData> dataList = EventManager.get(this.getClass());
        for(EventData data: dataList){
            if(data.source == o){
                try{
                    data.target.invoke(data.source, this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
}