package businesslogic.shiftWork;

import java.util.Date;

public class ShiftWork {
  private Date startingDate;
  private Date endingDate;
  private String location;
  private Date lowerBoundInitShift;
  private Date upperBoundEndShift;

  public ShiftWork(Date startingDate, Date endingDate, String location, Date lowerBoundInitShift, Date upperBoundEndShift) {
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.location = location;
    this.lowerBoundInitShift = lowerBoundInitShift;
    this.upperBoundEndShift = upperBoundEndShift;
  }
  
}


/**
 * Turno di servizio
--
Data inizio: Testo
Data fine: Testo
Luogo: Testo
Limite minimo data inizio: Testo
Limite fino data fine: Testo
Ricorrente: sì/no
 */