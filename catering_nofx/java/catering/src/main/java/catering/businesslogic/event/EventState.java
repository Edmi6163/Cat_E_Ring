package catering.businesslogic.event;

public interface EventState {
    public void modeEvent(Event event);
    public void changeMode(Event event);
    public Event getInfoEvent(Event event);
}
