package boids;
import java.util.Iterator;
import java.util.ArrayList;

public class EventManager {
    protected long currentDate;
    protected ArrayList<Event> events;

    public EventManager(){
        this.currentDate = 0;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event e){
        events.add(e);

    }

    public void next(){
        currentDate++;
        System.out.println("Next... Current date : "+currentDate);
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            Event e = iterator.next();
            if (e.getDate() == currentDate) {
                e.execute();
                iterator.remove(); // Utilisation de l'itérateur pour supprimer en toute sécurité
            }
        }
    }

    public boolean isFinished(){
        return events.isEmpty();
    }

    public void restart(){
        currentDate = 0;
        events.clear(); 
    }

}
