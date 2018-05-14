package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "NOTES")
@NamedQueries({
        @NamedQuery(name = "Notes.findAll", query = "SELECT r FROM Notes r"),
        @NamedQuery(name = "Notes.findById", query = "SELECT r FROM Notes r WHERE r.id = :id"),
        @NamedQuery(name = "Notes.AllIds", query = "SELECT r.id FROM Notes r")})
@EqualsAndHashCode(of = "noteDescription")
@ToString(of = {"id", "noteDescription"})
public class Notes  implements Serializable {
  @Column(name = "NOTE_DESCRIPTION")
  private String noteDescription;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Integer id;


  public String getNoteDescription() {
    return noteDescription;
  }

  public void setNoteDescription(String noteDescription) {
    this.noteDescription = noteDescription;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
