package catering.businesslogic.event;

import catering.businesslogic.summaryDocument.SummaryDocument;
import catering.businesslogic.user.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Event implements EventState {
    private UUID id;
    private Date dateStart;
    private Date dateEnd;
    private Integer partecipants;
    private User organizer;
    private ArrayList<SummaryDocument> listSummaryDocument;
    private EventState currentEvent; 
    
    public Event(){
        listSummaryDocument = new ArrayList<>();
        this.currentEvent = new EventStart(); 
    }

    /**
     * 
     * @param listSummaryDocument : list of summary documents
     */
    public Event(ArrayList<SummaryDocument> listSummaryDocument) {
        this.listSummaryDocument = listSummaryDocument;
        this.currentEvent = new EventStart();  // Stato iniziale
    }

    public void setState(EventState newState ){
        this.currentEvent= newState;

    }
    public void modeEvent(Event event) {
        this.currentEvent.modeEvent(this); 
    }

    public void changeMode(Event event) {
        this.currentEvent.changeMode(this);
    }

    public Event getInfoEvent(Event event) {
        return this.currentEvent.getInfoEvent(this);
    }
    public ArrayList<SummaryDocument> getsummaryDocumentArrayList(){
        return this.listSummaryDocument;
    }
}
